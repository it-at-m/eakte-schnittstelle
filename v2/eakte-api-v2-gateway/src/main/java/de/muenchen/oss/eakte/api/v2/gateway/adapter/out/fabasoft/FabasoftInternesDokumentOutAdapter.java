package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.InternesDokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftInternesDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.InternesDokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabasoftInternesDokumentOutAdapter implements InternesDokumentOutPort {
    private final FabasoftSearchService searchService;
    private final FabasoftInternesDokumentMapper internesDokumentMapper;

    @Override
    public List<InternesDokumentResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = request
                .addAttributes(DokumentAttribute.getReferences())
                .addAttributes(InternesDokumentAttribute.getReferences());
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.INTERNES_DOKUMENT, enrichedRequest);
        return internesDokumentMapper.toDomain(result);
    }

    @Override
    public Optional<InternesDokumentResponse> get(final RequestContext context, final String dokumentId, final Set<String> attributes) {
        final Set<String> attrs = AttributeHelper.combineAttributes(attributes, DokumentAttribute.getReferences());
        final Set<String> attrsWithInternesDokument = AttributeHelper.combineAttributes(attrs, InternesDokumentAttribute.getReferences());
        final Optional<ResultObject> result = searchService.getObject(context, FabasoftObjectType.INTERNES_DOKUMENT, dokumentId, attrsWithInternesDokument);
        return result.map(internesDokumentMapper::toDomain);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.EingangsdokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftEingangsdokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.EingangsdokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabasoftEingangsdokumentOutAdapter implements EingangsdokumentOutPort {
    private final FabasoftSearchService searchService;
    private final FabasoftEingangsdokumentMapper eingangsdokumentMapper;

    @Override
    public List<EingangsdokumentResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = request
                .addAttributes(DokumentAttribute.getReferences())
                .addAttributes(EingangsdokumentAttribute.getReferences());
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.EINGANGSDOKUMENT, enrichedRequest);
        return eingangsdokumentMapper.toDomain(result);
    }

    @Override
    public Optional<EingangsdokumentResponse> get(final RequestContext context, final String vorgangsId, final Set<String> attributes) {
        final Set<String> attrsDefaultDok = AttributeHelper.combineAttributes(attributes, DokumentAttribute.getReferences());
        final Set<String> attrsAddEingang = AttributeHelper.combineAttributes(attrsDefaultDok, EingangsdokumentAttribute.getReferences());
        final Optional<ResultObject> result = searchService.getObject(context, FabasoftObjectType.EINGANGSDOKUMENT, vorgangsId, attrsAddEingang);
        return result.map(eingangsdokumentMapper::toDomain);
    }
}

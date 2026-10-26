package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ErledigungAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftErledigungMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.ErledigungOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabasoftErledigungOutAdapter implements ErledigungOutPort {
    private final FabasoftSearchService searchService;
    private final FabasoftErledigungMapper erledigungMapper;

    @Override
    public List<ErledigungResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = request
                .addAttributes(DokumentAttribute.getReferences())
                .addAttributes(ErledigungAttribute.getReferences());
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.ERLEDIGUNG, enrichedRequest);
        return erledigungMapper.toDomain(result);
    }

    @Override
    public Optional<ErledigungResponse> get(final RequestContext context, final String erledigungsId, final Set<String> attributes) {
        final Set<String> attrs = AttributeHelper.combineAttributes(attributes, DokumentAttribute.getReferences());
        final Set<String> attrsWithErledigung = AttributeHelper.combineAttributes(attrs, ErledigungAttribute.getReferences());
        final Optional<ResultObject> result = searchService.getObject(context, FabasoftObjectType.ERLEDIGUNG, erledigungsId, attrsWithErledigung);
        return result.map(erledigungMapper::toDomain);
    }
}

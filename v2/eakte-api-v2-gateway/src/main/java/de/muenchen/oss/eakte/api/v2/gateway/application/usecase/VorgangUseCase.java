package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.SearchHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;

import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VorgangUseCase implements VorgangInPort {
    private final SearchOutPort searchOutPort;
    private final SearchHelper searchHelper;

    @Override
    public SearchResult searchVorgang(final RequestContext context, final int limit, final String query, final Set<String> clientAttrs) {
        final Set<String> attrs = searchHelper.buildAttributes(context, SearchType.VORGANG, clientAttrs);
        // TODO determine scope from request context
        final SearchRequest request = new SearchRequest(SearchType.VORGANG, null, limit, query, attrs);
        return searchOutPort.searchObject(context, request);
    }

    @Override
    public Optional<ResultObject> getVorgang(final RequestContext context, final String vorgangsId, final Set<String> clientAttrs) {
        final Set<String> attrs = searchHelper.buildAttributes(context, SearchType.VORGANG, clientAttrs);
        return searchHelper.getObject(context, SearchType.VORGANG, vorgangsId, attrs);
    }

    @Override
    public SearchResult searchVorgangsDokumente(final RequestContext context, final String vorgangsId, final int limit, final String clientQuery,
            final Set<String> clientAttrs) {
        final Set<String> attrs = searchHelper.buildAttributes(context, SearchType.DOKUMENT, clientAttrs);
        final String query = searchHelper.concatQuery(searchHelper.buildParentIdQuery(vorgangsId), clientQuery);
        // TODO determine scope from request context
        final SearchRequest request = new SearchRequest(SearchType.DOKUMENT, null, limit, query, attrs);
        return searchOutPort.searchObject(context, request);
    }
}

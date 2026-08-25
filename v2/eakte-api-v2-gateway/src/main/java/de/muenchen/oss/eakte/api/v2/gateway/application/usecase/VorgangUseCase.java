package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.SearchHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VorgangUseCase implements VorgangInPort {
    private final SearchOutPort searchOutPort;
    private final SearchHelper searchHelper;

    private static final Set<String> DEFAULT_ATTRIBUTES = Set.of(
            PARENT_ID.getReference(), SUBJECT.getReference());

    @Override
    public SearchResult searchVorgang(final RequestContext context, final String scope, final String query, final Set<String> clientAttrs) {
        // build attributes to load
        final Set<String> attributes = new HashSet<>(DEFAULT_ATTRIBUTES);
        attributes.addAll(clientAttrs != null ? clientAttrs : searchHelper.loadDfVAttributes(context, SearchType.VORGANG));
        // search
        final SearchRequest request = new SearchRequest(SearchType.VORGANG, scope, query, attributes);
        return searchOutPort.searchObject(context, request);
    }
}

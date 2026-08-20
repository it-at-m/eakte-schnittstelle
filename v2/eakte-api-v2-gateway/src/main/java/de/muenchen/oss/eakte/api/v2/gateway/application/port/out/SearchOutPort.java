package de.muenchen.oss.eakte.api.v2.gateway.application.port.out;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;

public interface SearchOutPort {
    /**
     * Search for objects matching the conditions.
     *
     * @param requestContext The request context to execute the search under.
     * @param request The parameters for the search.
     * @return The search result including the found objects.
     */
    SearchResult searchObject(RequestContext requestContext, SearchRequest request);
}

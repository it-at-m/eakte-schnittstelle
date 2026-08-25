package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;

import java.util.Set;

public interface VorgangInPort {
    SearchResult searchVorgang(RequestContext context, String scope, String query, Set<String> attributes);
}

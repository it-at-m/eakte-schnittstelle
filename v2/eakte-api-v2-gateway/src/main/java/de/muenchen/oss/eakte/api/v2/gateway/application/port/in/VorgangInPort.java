package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;

import java.util.Optional;
import java.util.Set;

public interface VorgangInPort {
    SearchResult searchVorgang(RequestContext context, int limit, String query, Set<String> attributes);

    SearchResult searchVorgangsDokumente(RequestContext context, String vorgangsId, int limit, String query, Set<String> attributes);

    Optional<ResultObject> getVorgang(RequestContext context, String vorgangsId, Set<String> attributes);
}

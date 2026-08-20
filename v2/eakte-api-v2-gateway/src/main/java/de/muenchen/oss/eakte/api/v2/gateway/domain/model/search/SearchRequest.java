package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import java.util.Set;

/**
 * Container for specifying conditions for a search.
 *
 * @param type The object type to search for.
 * @param scope The scope to execute the search under.
 * @param query The conditions objects need to fulfill.
 * @param attributes The attributes to load for matching objects.
 */
public record SearchRequest(
        SearchType type,
        String scope,
        String query,
        Set<String> attributes) {
}

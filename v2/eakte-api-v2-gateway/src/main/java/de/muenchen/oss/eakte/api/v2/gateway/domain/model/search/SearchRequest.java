package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import java.util.Set;

public record SearchRequest(
        SearchType type,
        String scope,
        String query,
        Set<String> attributes) {
}

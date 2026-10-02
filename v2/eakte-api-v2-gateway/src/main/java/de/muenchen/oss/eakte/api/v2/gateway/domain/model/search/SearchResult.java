package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import java.util.List;

public record SearchResult(
        List<ResultObject> results) {
}

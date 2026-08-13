package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute;

import java.util.List;

public record SearchResult(
        List<ResultObject> results) {
    public record ResultObject(
            String name,
            String coo,
            List<Attribute<?>> attributes) {
    }
}

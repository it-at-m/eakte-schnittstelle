package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import lombok.Builder;

@Builder
public record ParentReference<T>(
        T type,
        String id) {
}

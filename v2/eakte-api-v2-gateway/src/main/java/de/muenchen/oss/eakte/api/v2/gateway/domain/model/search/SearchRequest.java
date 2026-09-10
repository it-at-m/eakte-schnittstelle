package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
        @NotNull SearchType type,
        String scope,
        @Min(1) @Max(LIMIT_MAX) int limit,
        String query,
        @NotEmpty Set<@NotBlank String> attributes) {
    public static final int LIMIT_MAX = 10_000;
}

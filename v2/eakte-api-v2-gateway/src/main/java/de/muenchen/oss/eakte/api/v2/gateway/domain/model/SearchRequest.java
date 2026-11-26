package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Builder;
import org.springframework.util.StringUtils;

@Builder
public record SearchRequest(
        @NotNull int limit,
        String query,
        @NotNull Set<@NotBlank String> attributes) {
    public SearchRequest addAttributes(@NotNull final Set<@NotBlank String> attributes) {
        return new SearchRequest(limit, query, AttributeHelper.combineAttributes(this.attributes, attributes));
    }

    /**
     * Concat a query to the existing one.
     *
     * @param query The query to concat to the existing.
     * @return The request with the concat query.
     */
    public SearchRequest concatQuery(final String query) {
        final String newQuery;
        if (StringUtils.hasText(this.query) && StringUtils.hasText(query)) {
            newQuery = "(%s) AND (%s)".formatted(this.query, query);
        } else if (StringUtils.hasText(this.query)) {
            return this;
        } else {
            newQuery = query;
        }
        return new SearchRequest(limit, newQuery, attributes);
    }
}

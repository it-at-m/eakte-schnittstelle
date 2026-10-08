package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.Set;

@Validated
public interface VorgangInPort {
    SearchResult searchVorgang(@NotNull RequestContext context, @NotNull int limit, String query, Set<String> attributes);

    SearchResult searchVorgangsDokumente(@NotNull RequestContext context, @NotBlank String vorgangsId, @NotNull int limit, String query, Set<String> attributes);

    Optional<ResultObject> getVorgang(@NotNull RequestContext context, @NotBlank String vorgangsId, Set<String> attributes);
}

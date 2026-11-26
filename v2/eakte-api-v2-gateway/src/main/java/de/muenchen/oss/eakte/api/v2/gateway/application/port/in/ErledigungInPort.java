package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ErledigungInPort {
    List<ErledigungResponse> search(@NotNull RequestContext context, @NotNull @Valid SearchRequest request);

    Optional<ErledigungResponse> get(@NotNull RequestContext context, @NotBlank String erledigungId, @NotNull Set<String> attributes);
}

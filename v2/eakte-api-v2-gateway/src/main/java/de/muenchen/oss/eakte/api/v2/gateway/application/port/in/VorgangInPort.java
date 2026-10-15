package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.validation.annotation.Validated;

@Validated
public interface VorgangInPort {
    List<VorgangResponse> search(@NotNull RequestContext context, @NotNull @Valid SearchRequest request);

    Optional<VorgangResponse> get(@NotNull RequestContext context, @NotBlank String vorgangsId, @NotNull Set<String> attributes);
}

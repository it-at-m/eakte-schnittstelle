package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.validation.annotation.Validated;

@Validated
public interface AkteInPort {
    List<AkteResponse> searchBellowAktenplan(@NotNull RequestContext context, @NotBlank String aktenplaneintragId, @NotNull @Valid SearchRequest request);

    Optional<AkteResponse> get(@NotNull RequestContext context, @NotBlank String vorgangId, @NotNull Set<String> attributes);

}

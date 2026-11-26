package de.muenchen.oss.eakte.api.v2.gateway.application.port.out;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SchriftstueckOutPort {
    List<SchriftstueckResponse> searchBellowDokument(@NotNull RequestContext context, @NotBlank String dokumentId, @NotNull @Valid SearchRequest request);

    Optional<SchriftstueckResponse> get(@NotNull RequestContext context, @NotBlank String schriftstueckId);
}

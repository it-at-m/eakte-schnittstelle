package de.muenchen.oss.eakte.api.v2.gateway.application.port.out;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.validation.annotation.Validated;

@Validated
public interface EingangsdokumentOutPort {
    List<EingangsdokumentResponse> search(@NotNull RequestContext context, @NotNull @Valid SearchRequest request);

    Optional<EingangsdokumentResponse> get(@NotNull RequestContext context, @NotBlank String eingangsdokumentId, Set<String> attributes);
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateVorgangRequest(
        @NotBlank String akteId,
        @NotBlank String titel,
        String betreff,
        String hinweis,
        String vorlagenId,
        VorgangMedium originalMedium,
        String zugriffsdefinition
// TODO dfv
) {
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import jakarta.validation.constraints.NotBlank;

public record CreateVorgangRequest(
        @NotBlank String aktenId,
        @NotBlank String name,
        String betreff,
        String vorlagenId,
        VorgangMedium originalMedium,
        boolean laufwegErzeugen,
        String geschaeftsgangvermerk,
        String zugriffsdefinition
// TODO dfv
) {
}

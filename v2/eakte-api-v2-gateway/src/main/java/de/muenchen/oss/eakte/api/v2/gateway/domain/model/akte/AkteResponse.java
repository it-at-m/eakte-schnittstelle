package de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import lombok.Builder;

import java.util.List;

@Builder
public record AkteResponse(
        String id,
        String betreffseinheitId,
        String titel,
        String name,
        String betreff,
        String zugriffsdefinition,
        String zugriffsdefinitionVorgang,
        String dfvId,
        List<Attribute> weitereEigenschaften) {
}

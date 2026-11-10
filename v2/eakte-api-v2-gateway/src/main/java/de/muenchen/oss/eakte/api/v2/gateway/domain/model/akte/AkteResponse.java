package de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import java.util.List;
import lombok.Builder;

@Builder
public record AkteResponse(
        String id,
        String aktenplaneintragId,
        String titel,
        String name,
        String betreff,
        String zugriffsdefinition,
        String zugriffsdefinitionVorgang,
        String dfvId,
        List<Attribute> weitereEigenschaften) {
}

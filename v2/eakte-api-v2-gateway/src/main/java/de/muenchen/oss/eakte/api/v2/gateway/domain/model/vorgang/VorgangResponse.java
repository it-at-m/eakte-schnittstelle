package de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import java.util.List;
import lombok.Builder;

@Builder
public record VorgangResponse(
        String id,
        String akteId,
        String name,
        String langname,
        String betreff,
        String hinweis,
        String geschaeftsgangvermerk,
        VorgangMedium originalMedium,
        VorgangStatus status,
        String bearbeitungsstatus,
        String zugriffsdefinition,
        String organisationseinheit,
        List<Attribute> weitereEigenschaften) {
}

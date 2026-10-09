package de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ParentReference;
import java.util.List;
import lombok.Builder;

@Builder
public record DokumentResponse(
        String id,
        DokumentKlasse klasse,
        ParentReference<DokumentParent> parent,
        String name,
        String langname,
        String betreff,
        String zugriffsdefinition,
        String organisationseinheit,
        List<Attribute> weitereEigenschaften) {
}

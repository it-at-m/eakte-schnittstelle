package de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public class DokumentResponse {
    private final String id;
    private final DokumentKlasse klasse;
    private final String vorgangId;
    private final String name;
    private final String langname;
    private final String betreff;
    private final String hinweis;
    private final String zugriffsdefinition;
    private final String organisationseinheit;
    private final List<Attribute> weitereEigenschaften;
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ErledigungResponse extends DokumentResponse {
    private final String bezugEingangsdokument;
    private final String dokumententypId;
    private final String anlagenBeschreibung;
}

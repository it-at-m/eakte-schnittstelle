package de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class InternesDokumentResponse extends DokumentResponse {
    private final LocalDate zustellungsDatum;
    private final String dokumententyp;
    private final String anlagenBeschreibung;
}

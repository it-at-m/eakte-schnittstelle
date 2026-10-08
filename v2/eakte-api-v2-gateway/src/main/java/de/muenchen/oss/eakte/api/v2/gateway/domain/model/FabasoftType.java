package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftType {
    // Objects
    VORGANG("DEPRECONFIG@15.1001:Procedure", "COO.1.1001.1.16603"),
    SUBJECT_AREA("COOELAK@1.1001:SubjectArea", null),
    DOKUMENT("SOLEGOVCOREMODEL@111.100:EGovCoreDocument", null),
    // Attributes
    ZUGRIFFSDEFINITION("FSCFOLIO@1.1001:AccessDefinition", null);

    private final String fabasoftReference;
    private final String coo;
}

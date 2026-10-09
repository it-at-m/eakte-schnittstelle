package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftObjectType {
    // Objects
    VORGANG("DEPRECONFIG@15.1001:Procedure", "COO.1.1001.1.16603"),
    SUBJECT_AREA("COOELAK@1.1001:SubjectArea", null),
    DOKUMENT("SOLEGOVCOREMODEL@111.100:EGovCoreDocument", null),
    EINGANG("COOELAK@1.1001:Incoming", null),
    ERLEDIGUNG("COOELAK@1.1001:Outgoing", null),
    INTERN("COOELAK@1.1001:InternalFile", null),
    // FabasoftAttribute objects
    ZUGRIFFSDEFINITION("FSCFOLIO@1.1001:AccessDefinition", null);

    public static final String COO_PATTERN = "^COO[.\\d]+$";

    private final String fabasoftReference;
    private final String coo;

    public static FabasoftObjectType fromFabasoftReference(final String fabasoftReference) {
        return Arrays.stream(values())
                .filter(i -> i.fabasoftReference.equals(fabasoftReference))
                .findFirst().orElse(null);
    }
}

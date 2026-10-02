package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DokumentClass {
    EINGANG("COOELAK@1.1001:Incoming"),
    ERLEDIGUNG("COOELAK@1.1001:Outgoing"),
    INTERN("COOELAK@1.1001:InternalFile");

    private final String reference;
}

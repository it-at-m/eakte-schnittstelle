package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftAttributeReferences {
    PARENT_ID("COOELAK@1.1001:referrednumber.address"),
    SUBJECT("COOELAK@1.1001:filesubj");

    private final String reference;
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model.search;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SearchType {
    VORGANG("DEPRECONFIG@15.1001:Procedure"),
    SUBJECT_AREA("COOELAK@1.1001:SubjectArea");

    private final String fabasoftReference;
}

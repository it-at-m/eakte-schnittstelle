package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EingangsdokumentAttribute {
    FREMDES_GESCHAEFTSZEICHEN("COOELAK@1.1001:foreignnr", AttributeType.STRING),
    EINGANGSDATUM("COOELAK@1.1001:delivery", AttributeType.DATE);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(EingangsdokumentAttribute::getReference).collect(Collectors.toSet());
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum InternesDokumentAttribute {
    ZUSTELLUNGSDATUM("COOELAK@1.1001:delivery", AttributeType.DATE),
    DOKUMENTENTYP("COOELAK@1.1001:subfiletype.name", AttributeType.STRING),
    ANLAGEN_BESCHREIBUNG("COOELAK@1.1001:incattachments", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(InternesDokumentAttribute::getReference).collect(Collectors.toSet());
    }
}

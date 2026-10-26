package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErledigungAttribute {
    BEZUG_EINGANGSDOKUMENT("CFGBAYERN@15.1400:referredincoming", AttributeType.OBJECT),
    DOKUMENTENTYP_ID("COOELAK@1.1001:subfiletype", AttributeType.STRING),
    ANLAGEN_BESCHREIBUNG("COOELAK@1.1001:incattachments", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(ErledigungAttribute::getReference).collect(Collectors.toSet());
    }
}

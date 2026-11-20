package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SchriftstueckAttribute {
    DOKUMENT_ID("COOELAK@1.1001:referrednumber", AttributeType.OBJECT),
    BETREFF("COOELAK@1.1001:filesubj", AttributeType.STRING),
    DATEI_ENDUNG("COOSYSTEM@1.1:content.contextension", AttributeType.STRING),
    DATEI_GROESSE("COOSYSTEM@1.1:content.contsize", AttributeType.INTEGER);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(SchriftstueckAttribute::getReference).collect(Collectors.toSet());
    }
}

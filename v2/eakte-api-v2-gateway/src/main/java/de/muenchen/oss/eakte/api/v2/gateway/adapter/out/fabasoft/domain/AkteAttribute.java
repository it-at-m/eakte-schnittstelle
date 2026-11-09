package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum AkteAttribute {
    PARENT_ID("ELAKGOV@1.1001:apentry", AttributeType.OBJECT),
    TITEL("COOELAK@1.1001:objmlname.langstring", AttributeType.STRING),
    NAME("COOSYSTEM@1.1:objname", AttributeType.STRING),
    BETREFF("COOELAK@1.1001:filesubj", AttributeType.STRING),
    ZUGRIFFSDEFINITION("FSCFOLIO@1.1001:objaccdef.name", AttributeType.STRING),
    ZUGRIFFSDEFINITION_VORGANG("CFGBAYERN@15.1400:procedureaccessdefinition", AttributeType.STRING),
    DFV_ID("EGOVTEMPLATE@15.1001:createdfromdefinition", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(AkteAttribute::getReference).collect(Collectors.toSet());

    }
}

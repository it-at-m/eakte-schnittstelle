package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DokumentAttribute {
    KLASSE("COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:fullreference", AttributeType.STRING),
    // TODO which attribute for Inbox & Arbeitsvorrat
    PARENT_ID("COOELAK@1.1001:referrednumber", AttributeType.OBJECT),
    PARENT_TYPE("COOELAK@1.1001:referrednumber.objclass.fullreference", AttributeType.STRING),
    NAME("COOELAK@1.1001:objmlname.langstring", AttributeType.STRING),
    BETREFF("COOELAK@1.1001:filesubj", AttributeType.STRING),
    ACL("FSCFOLIO@1.1001:objaccdef.name", AttributeType.STRING),
    ORGANISATIONSEINHEIT("COOSYSTEM@1.1:objowngroup.name", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(DokumentAttribute::getReference).collect(Collectors.toSet());
    }
}

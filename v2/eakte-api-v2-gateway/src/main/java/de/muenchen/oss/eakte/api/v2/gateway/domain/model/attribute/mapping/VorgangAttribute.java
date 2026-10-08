package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum VorgangAttribute {
    PARENT_ID("COOELAK@1.1001:referrednumber", AttributeType.OBJECT),
    NAME("COOELAK@1.1001:objmlname.langstring", AttributeType.STRING),
    BETREFF("COOELAK@1.1001:filesubj", AttributeType.STRING),
    STATUS("FSCFOLIO@1.1001:objdocstate", AttributeType.ENUM),
    BEARBEITUNGSSTATUS("FSCFOLIO@1.1001:bostate.name", AttributeType.STRING),
    // TODO map
    ZUGRIFFSDEFINITION("FSCFOLIO@1.1001:objaccdef", AttributeType.STRING),
    ORGANISATIONSEINHEIT("COOSYSTEM@1.1:objowngroup.name", AttributeType.STRING),
    ORIGINAL_MEDIUM("COOELAK@1.1001:filetype", AttributeType.ENUM),
    GESCHAEFTSGANGVERMERK("COOELAK@1.1001:inchargeremark", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;

    public static Set<String> getReferences() {
        return Arrays.stream(values()).map(VorgangAttribute::getReference).collect(Collectors.toSet());
    }
}

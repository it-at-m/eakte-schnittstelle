package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum VorgangAttribute {
    PARENT_ID("COOELAK@1.1001:referrednumber", AttributeType.OBJECT),
    NAME("COOELAK@1.1001:objmlname.langstring", AttributeType.STRING),
    BETREFF("COOELAK@1.1001:filesubj", AttributeType.STRING),
    SCHLAGWORTE_NAME("FSCTERM@1.1001:objterms.name", AttributeType.STRING),
    // TODO get name
    STATUS("FSCFOLIO@1.1001:objdocstate", AttributeType.ENUM),
    BEARBEITUNGSSTATUS("FSCFOLIO@1.1001:bostate.name", AttributeType.STRING),
    ACL("FSCFOLIO@1.1001:objaccdef.name", AttributeType.STRING),
    ORGANISATIONSEINHEIT("COOSYSTEM@1.1:objowngroup.name", AttributeType.STRING),
    ORIGINAL_MEDIUM("COOELAK@1.1001:filetype", AttributeType.ENUM),
    GESCHAEFTSGANGVERMERK("COOELAK@1.1001:inchargeremark", AttributeType.STRING);

    private final String reference;
    private final AttributeType type;
}

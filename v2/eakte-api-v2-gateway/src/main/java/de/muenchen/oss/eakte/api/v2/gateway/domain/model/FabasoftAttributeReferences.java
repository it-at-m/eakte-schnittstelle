package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftAttributeReferences {
    PARENT_ID("COOELAK@1.1001:referrednumber.address"),
    SUBJECT("COOELAK@1.1001:filesubj"),
    SHORTNAME("COOELAK@1.1001:objmlname.langstring"),
    KEYWORDS_NAME("FSCTERM@1.1001:objterms.name"),
    // TODO get name
    STATE("FSCFOLIO@1.1001:objdocstate"),
    PROCESSING_STATE("FSCFOLIO@1.1001:bostate.name"),
    ACL("FSCFOLIO@1.1001:objaccdef.name"),
    OE("COOSYSTEM@1.1:objowngroup.name"),
    ORIGINAL_MEDIUM("COOELAK@1.1001:filetype"),
    PROCESS_NOTE("COOELAK@1.1001:inchargeremark");

    private final String reference;
}

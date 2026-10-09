package de.muenchen.oss.eakte.api.v2.gateway.e2e;

abstract class VorgangE2eSupport extends FabasoftE2eSupport {
    public static final String DFV_ATTRIBUTE = "custom.dfv.attribute";
    private static final String FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";

    protected void stubVorgangResponse() {
        stubSearchRequestContaining("where query", vorgangResponse());
    }

    protected void stubGetVorgangResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", vorgangResponse());
    }

    protected void stubGetVorgangNotFoundResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", emptySearchResponse());
    }

    protected void stubDfVAndVorgangResponse() {
        stubSearchRequestContaining("availabledefinitions is not null", dfvResponse());
        stubSearchRequestContaining("where query", vorgangResponse());
    }

    private String vorgangResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult>
                    <urn:object>
                      <urn:objname>procedure-name</urn:objname>
                      <urn:objaddress>COO.1.2.3</urn:objaddress>
                      <urn:attrlist>
                        <urn:OBJECT urn:reference="COOELAK@1.1001:referrednumber" urn:index="1">file-id</urn:OBJECT>
                        <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                        <urn:STRING urn:reference="COOELAK@1.1001:objmlname.langstring" urn:index="1">short-name</urn:STRING>
                        <urn:ENUM urn:reference="FSCFOLIO@1.1001:objdocstate" urn:index="1">10</urn:ENUM>
                        <urn:STRING urn:reference="FSCFOLIO@1.1001:bostate.name" urn:index="1">processing</urn:STRING>
                        <urn:STRING urn:reference="FSCFOLIO@1.1001:objaccdef.name" urn:index="1">acl</urn:STRING>
                        <urn:STRING urn:reference="COOSYSTEM@1.1:objowngroup.name" urn:index="1">ou</urn:STRING>
                        <urn:ENUM urn:reference="COOELAK@1.1001:filetype" urn:index="1">1</urn:ENUM>
                        <urn:STRING urn:reference="COOELAK@1.1001:inchargeremark" urn:index="1">remark</urn:STRING>
                        <urn:STRING urn:reference="custom.attribute" urn:index="1">custom-value</urn:STRING>
                      </urn:attrlist>
                    </urn:object>
                  </urn:queryresult>
                </urn:SOAPSearchResponse>
                """);
    }

    private String dfvResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult>
                    <urn:object>
                      <urn:objname>subject-area</urn:objname>
                      <urn:objaddress>COO.SUBJECT.AREA</urn:objaddress>
                      <urn:attrlist>
                        <urn:STRING urn:reference="%s" urn:index="1">%s</urn:STRING>
                      </urn:attrlist>
                    </urn:object>
                  </urn:queryresult>
                </urn:SOAPSearchResponse>
                """.formatted(FULL_REFERENCE, DFV_ATTRIBUTE));
    }

    private String emptySearchResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult/>
                </urn:SOAPSearchResponse>
                """);
    }

}

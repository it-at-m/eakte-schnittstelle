package de.muenchen.oss.eakte.api.v2.gateway.e2e;

abstract class EingangsdokumentE2eSupport extends FabasoftE2eSupport {
    public static final String DFV_ATTRIBUTE = "custom.dfv.attribute";

    private static final String FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";

    protected void stubEingangsdokumentSearchResponse() {
        stubSearchRequestContaining("where query", eingangsdokumentResponse());
    }

    protected void stubGetEingangsdokumentResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", eingangsdokumentResponse());
    }

    protected void stubGetEingangsdokumentNotFoundResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", emptySearchResponse());
    }

    protected void stubDfVAndEingangsdokumentSearchResponse() {
        stubSearchRequestContaining("availabledefinitions is not null", dfvResponse());
        stubSearchRequestContaining("where query", eingangsdokumentResponse());
    }

    private String eingangsdokumentResponse() {
        return soapEnvelope(
                """
                        <urn:SOAPSearchResponse>
                          <urn:queryresult>
                            <urn:object>
                              <urn:objname>incoming-name</urn:objname>
                              <urn:objaddress>COO.4.5.6</urn:objaddress>
                              <urn:attrlist>
                                <urn:STRING urn:reference="COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:fullreference" urn:index="1">COOELAK@1.1001:Incoming</urn:STRING>
                                <urn:OBJECT urn:reference="COOELAK@1.1001:referrednumber" urn:index="1">COO.1.2.3</urn:OBJECT>
                                <urn:STRING urn:reference="COOELAK@1.1001:referrednumber.objclass.fullreference" urn:index="1">DEPRECONFIG@15.1001:Procedure</urn:STRING>
                                <urn:STRING urn:reference="COOELAK@1.1001:objmlname.langstring" urn:index="1">short-name</urn:STRING>
                                <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                                <urn:STRING urn:reference="FSCFOLIO@1.1001:objaccdef.name" urn:index="1">acl</urn:STRING>
                                <urn:STRING urn:reference="COOSYSTEM@1.1:objowngroup.name" urn:index="1">ou</urn:STRING>
                                <urn:STRING urn:reference="COOELAK@1.1001:foreignnr" urn:index="1">external-reference</urn:STRING>
                                <urn:DATE urn:reference="COOELAK@1.1001:delivery" urn:index="1">2025-01-02</urn:DATE>
                                <urn:STRING urn:reference="DEPRECONFIG@15.1001:fileaddsubj" urn:index="1">incoming note</urn:STRING>
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

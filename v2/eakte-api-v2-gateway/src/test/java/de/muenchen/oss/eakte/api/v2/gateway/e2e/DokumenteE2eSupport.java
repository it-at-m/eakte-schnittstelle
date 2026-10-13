package de.muenchen.oss.eakte.api.v2.gateway.e2e;

abstract class DokumenteE2eSupport extends FabasoftE2eSupport {
    protected void stubDokumentResponse() {
        stubSearchRequestContaining("COO123.123.123", dokumentResponse());
    }

    private String dokumentResponse() {
        return soapEnvelope(
                """
                        <urn:SOAPSearchResponse>
                          <urn:queryresult>
                            <urn:object>
                              <urn:objname>document-name</urn:objname>
                              <urn:objaddress>COO.2.3.4</urn:objaddress>
                              <urn:attrlist>
                                <urn:STRING urn:reference="COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:fullreference" urn:index="1">COOELAK@1.1001:Incoming</urn:STRING>
                                <urn:OBJECT urn:reference="COOELAK@1.1001:referrednumber" urn:index="1">COO123.123.123</urn:OBJECT>
                                <urn:STRING urn:reference="COOELAK@1.1001:referrednumber.objclass.fullreference" urn:index="1">DEPRECONFIG@15.1001:Procedure</urn:STRING>
                                <urn:STRING urn:reference="COOELAK@1.1001:objmlname.langstring" urn:index="1">short-name</urn:STRING>
                                <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                                <urn:STRING urn:reference="FSCFOLIO@1.1001:objaccdef.name" urn:index="1">acl</urn:STRING>
                                <urn:STRING urn:reference="COOSYSTEM@1.1:objowngroup.name" urn:index="1">ou</urn:STRING>
                                <urn:STRING urn:reference="custom.attribute" urn:index="1">custom-value</urn:STRING>
                              </urn:attrlist>
                            </urn:object>
                          </urn:queryresult>
                        </urn:SOAPSearchResponse>
                        """);
    }
}

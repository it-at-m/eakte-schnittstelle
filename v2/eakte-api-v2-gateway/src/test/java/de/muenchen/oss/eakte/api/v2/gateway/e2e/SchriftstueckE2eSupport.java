package de.muenchen.oss.eakte.api.v2.gateway.e2e;

abstract class SchriftstueckE2eSupport extends FabasoftE2eSupport {
    protected void stubSchriftstueckSearchResponse() {
        stubSearchRequestContaining("document query", schriftstueckResponse());
    }

    protected void stubGetSchriftstueckResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", schriftstueckResponse());
    }

    protected void stubGetSchriftstueckNotFoundResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", emptySearchResponse());
    }

    private String schriftstueckResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult>
                    <urn:object>
                      <urn:objname>name</urn:objname>
                      <urn:objaddress>COO.4.5.6</urn:objaddress>
                      <urn:attrlist>
                        <urn:OBJECT urn:reference="COOELAK@1.1001:referrednumber" urn:index="1">COO.1.2.3</urn:OBJECT>
                        <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                        <urn:STRING urn:reference="COOSYSTEM@1.1:content.contextension" urn:index="1">pdf</urn:STRING>
                        <urn:INTEGER urn:reference="COOSYSTEM@1.1:content.contsize" urn:index="1">1234</urn:INTEGER>
                        <urn:STRING urn:reference="custom.attribute" urn:index="1">custom-value</urn:STRING>
                      </urn:attrlist>
                    </urn:object>
                  </urn:queryresult>
                </urn:SOAPSearchResponse>
                """);
    }

    private String emptySearchResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult/>
                </urn:SOAPSearchResponse>
                """);
    }
}

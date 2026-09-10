package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import com.github.tomakehurst.wiremock.client.WireMock;

abstract class VorgangE2eSupport extends AbstractWireMockE2eTest {
    public static final String DFV_ATTRIBUTE = "custom.dfv.attribute";
    private static final String FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";
    private static final String SOAP_CONTENT_TYPE = "text/xml; charset=utf-8";
    private static final String SOAP_SEARCH_ACTION = "http://schemas.fabasoft.com/object/FSCBAI_1_1001_SOAPSearch";

    protected void stubVorgangResponse() {
        stubSearchRequestContaining("where query", vorgangResponse());
    }

    protected void stubDfVAndVorgangResponse() {
        stubSearchRequestContaining("availabledefinitions is not null", dfvResponse());
        stubSearchRequestContaining("where query", vorgangResponse());
    }

    protected void stubSoapFailure() {
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .willReturn(aResponse().withStatus(500).withHeader("Content-Type", SOAP_CONTENT_TYPE)));
    }

    protected void verifySearchRequest(final String query, final String attribute) {
        wireMock.verify(postRequestedFor(urlPathEqualTo("/"))
                .withHeader("SOAPAction", WireMock.containing(SOAP_SEARCH_ACTION))
                .withHeader("X-FSC-Authenticated-User", equalTo("login"))
                .withRequestBody(WireMock.containing(query))
                .withRequestBody(WireMock.containing(attribute)));
    }

    private void stubSearchRequestContaining(final String query, final String response) {
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .withRequestBody(WireMock.containing(query))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", SOAP_CONTENT_TYPE)
                        .withBody(response)));
    }

    private String vorgangResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult>
                    <urn:object>
                      <urn:objname>procedure-name</urn:objname>
                      <urn:objaddress>COO.1.2.3</urn:objaddress>
                      <urn:attrlist>
                        <urn:STRING urn:reference="COOELAK@1.1001:referrednumber.address" urn:index="1">file-id</urn:STRING>
                        <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
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

    private String soapEnvelope(final String body) {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:urn="urn:schemas-fabasoft-com:bai:search">
                  <soapenv:Body>%s</soapenv:Body>
                </soapenv:Envelope>
                """.formatted(body);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static de.muenchen.oss.eakte.api.v2.gateway.TestSecurityConfiguration.USER;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;

abstract class FabasoftE2eSupport extends AbstractWireMockE2eTest {
    private static final String SOAP_CONTENT_TYPE = "text/xml; charset=utf-8";
    private static final String SOAP_SEARCH_ACTION = "http://schemas.fabasoft.com/object/FSCBAI_1_1001_SOAPSearch";

    protected void stubSoapFailure() {
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withHeader("Content-Type", SOAP_CONTENT_TYPE)
                        .withBody(soapFault())));
    }

    protected void verifySearchRequest(final String query, final String attribute, final boolean impersonate) {
        RequestPatternBuilder pattern = postRequestedFor(urlPathEqualTo("/"))
                .withHeader("SOAPAction", WireMock.containing(SOAP_SEARCH_ACTION))
                .withRequestBody(WireMock.containing(query))
                .withRequestBody(WireMock.containing(attribute));
        if (impersonate) {
            pattern = pattern
                    .withHeader("X-FSC-Authenticated-User", equalTo("login"))
                    .withQueryParam("px", equalTo("role"))
                    .withQueryParam("gx", equalTo("ou"));
        } else {
            pattern = pattern
                    .withHeader("X-FSC-Authenticated-User", equalTo(USER))
                    .withoutQueryParam("px")
                    .withoutQueryParam("gx");
        }
        wireMock.verify(pattern);
    }

    protected void stubSearchRequestContaining(final String query, final String response) {
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .withRequestBody(WireMock.containing(query))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", SOAP_CONTENT_TYPE)
                        .withBody(response)));
    }

    protected String soapEnvelope(final String body) {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:urn="urn:schemas-fabasoft-com:bai:search">
                  <soapenv:Body>%s</soapenv:Body>
                </soapenv:Envelope>
                """.formatted(body);
    }

    private String soapFault() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:fs="http://schemas.fabasoft.com/faultdetails">
                  <soapenv:Body>
                    <soapenv:Fault>
                      <faultcode>soapenv:Server</faultcode>
                      <faultstring>Fabasoft service failure</faultstring>
                      <detail>
                        <fs:ErrorReference>TEST_ERROR</fs:ErrorReference>
                      </detail>
                    </soapenv:Fault>
                  </soapenv:Body>
                </soapenv:Envelope>
                """;
    }
}

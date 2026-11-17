package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_MANDANT;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_NAME;

import com.github.tomakehurst.wiremock.client.WireMock;

abstract class BenutzerE2eSupport extends FabasoftE2eSupport {
    private static final String USER_ROLE_POSITION_ID = "COO.1.1001.1.4328";
    private static final String USER_INFORMATION_ACTION = "http://schemas.fabasoft.com/object/FSCGOVXML_1_1001_SOAPGetUserInformation";
    private static final String USER_INFORMATION_NAMESPACE = "urn:schemas-editions-fabasoft-com:gov:getuserinformation";

    protected void stubUserInformationResponse(final String username) {
        stubSearchRequestContaining(username, userInformationResponse(username));
    }

    protected void verifyUserInformationRequest(final String username) {
        wireMock.verify(postRequestedFor(urlPathEqualTo("/"))
                .withHeader("SOAPAction", WireMock.containing(USER_INFORMATION_ACTION))
                .withHeader("X-FSC-Authenticated-User", equalTo(username))
                .withRequestBody(WireMock.containing(username))
                .withoutQueryParam("px")
                .withoutQueryParam("gx"));
    }

    private String userInformationResponse(final String username) {
        final String body = """
                <user:GetUserInformationResponse>
                  <user:user>
                    <user:objaddress>%s</user:objaddress>
                    <user:login>%s</user:login>
                    <user:active>true</user:active>
                  </user:user>
                  <user:userrole>
                    <user:position>
                      <user:objaddress>%s</user:objaddress>
                    </user:position>
                    <user:group>
                      <user:objname>%s</user:objname>
                      <user:objaddress>%s</user:objaddress>
                    </user:group>
                    <user:clientdomain>
                      <user:objname>%s</user:objname>
                    </user:clientdomain>
                    <user:default>true</user:default>
                  </user:userrole>
                </user:GetUserInformationResponse>
                """.formatted(BENUTZER_ID, username, USER_ROLE_POSITION_ID, BENUTZER_OE_NAME,
                BENUTZER_OE_ID, BENUTZER_MANDANT);
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:user="%s">
                  <soapenv:Body>%s</soapenv:Body>
                </soapenv:Envelope>
                """.formatted(USER_INFORMATION_NAMESPACE, body);
    }
}

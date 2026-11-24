package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftStelle;

abstract class VorgangE2eSupport extends FabasoftE2eSupport {
    public static final String DFV_ATTRIBUTE = "custom.dfv.attribute";
    private static final String TRANSACTION_HEADER = """
            <soapenv:Header>
              <tx:cootx xmlns:tx="http://schemas.fabasoft.com/websvc/FSCGOVXML_1_1001_DefaultWebServiceDefinition/">
                <tx:transaction>test-transaction</tx:transaction>
                <tx:commit>false</tx:commit>
              </tx:cootx>
            </soapenv:Header>
            """;
    private static final String FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";

    protected void stubVorgangResponse() {
        stubSearchRequestContaining("where query", vorgangResponse());
    }

    protected void stubAkteVorgaengeResponse() {
        stubSearchRequestContaining(".COOELAK@1.1001:referrednumber", vorgangResponse());
    }

    protected void stubGetVorgangResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", vorgangResponse());
    }

    protected void stubGetVorgangNotFoundResponse() {
        stubSearchRequestContaining("COOSYSTEM@1.1:objaddress", emptySearchResponse());
    }

    protected void stubCreateVorgangResponse() {
        wireMock.stubFor(com.github.tomakehurst.wiremock.client.WireMock.post(
                com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo("/"))
                .withHeader("SOAPAction", com.github.tomakehurst.wiremock.client.WireMock.containing("SOAPCreateSubFile"))
                .willReturn(com.github.tomakehurst.wiremock.client.WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(createSubFileResponse())));
        wireMock.stubFor(com.github.tomakehurst.wiremock.client.WireMock.post(
                com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo("/"))
                .withHeader("SOAPAction", com.github.tomakehurst.wiremock.client.WireMock.containing("SOAPGenericSetProperties"))
                .willReturn(com.github.tomakehurst.wiremock.client.WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(setPropertiesResponse())));
        wireMock.stubFor(com.github.tomakehurst.wiremock.client.WireMock.post(
                com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo("/"))
                .withHeader("SOAPAction", com.github.tomakehurst.wiremock.client.WireMock.containing("SOAPCommit"))
                .willReturn(com.github.tomakehurst.wiremock.client.WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody("""
                                <?xml version="1.0" encoding="UTF-8"?>
                                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                                        xmlns:urn="http://schemas.fabasoft.com/websvc/FSCGOVXML_1_1001_DefaultWebServiceDefinition/">
                                  <soapenv:Body><urn:SOAPCommitResponse/></soapenv:Body>
                                </soapenv:Envelope>
                                """)));
    }

    protected void verifyCreateVorgangRequest(final String akteId, final String name, final String betreff,
            final String vorlagenId, final boolean impersonate) {
        RequestPatternBuilder pattern = com.github.tomakehurst.wiremock.client.WireMock
                .postRequestedFor(
                        com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo("/"))
                .withHeader("SOAPAction", com.github.tomakehurst.wiremock.client.WireMock.containing("SOAPCreateSubFile"))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.containing(akteId))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.containing(name))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.containing(betreff))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.containing(vorlagenId));
        if (impersonate) {
            pattern = pattern
                    .withHeader("X-FSC-Authenticated-User", com.github.tomakehurst.wiremock.client.WireMock.equalTo("login"))
                    .withQueryParam("px", com.github.tomakehurst.wiremock.client.WireMock.equalTo(FabasoftStelle.SACHBEARBEITUNG.getId()))
                    .withQueryParam("gx", com.github.tomakehurst.wiremock.client.WireMock.equalTo("ou"));
        }
        wireMock.verify(pattern);
        wireMock.verify(com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor(
                com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo("/"))
                .withHeader("SOAPAction", com.github.tomakehurst.wiremock.client.WireMock.containing("SOAPGenericSetProperties"))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.matching(
                        "(?s).*<(?:\\w+:)?OBJECT\\s+[^>]*reference=\"FSCFOLIO@1\\.1001:objaccdef\"[^>]*>COO\\.1\\.1001\\.1\\.182601</(?:\\w+:)?OBJECT>.*"))
                .withRequestBody(com.github.tomakehurst.wiremock.client.WireMock.matching(
                        "(?s).*<(?:\\w+:)?STRING\\s+[^>]*reference=\"DEPRECONFIG@15\\.1001:procsubject\"[^>]*>note</(?:\\w+:)?STRING>.*")));
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
                      <urn:objname>name</urn:objname>
                      <urn:objaddress>COO.1.2.3</urn:objaddress>
                      <urn:attrlist>
                        <urn:OBJECT urn:reference="COOELAK@1.1001:referrednumber" urn:index="1">file-id</urn:OBJECT>
                        <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                        <urn:STRING urn:reference="DEPRECONFIG@15.1001:procsubject" urn:index="1">note</urn:STRING>
                        <urn:STRING urn:reference="COOELAK@1.1001:objmlname.langstring" urn:index="1">titel</urn:STRING>
                        <urn:ENUM urn:reference="FSCFOLIO@1.1001:objdocstate" urn:index="1">10</urn:ENUM>
                        <urn:STRING urn:reference="FSCFOLIO@1.1001:bostate.name" urn:index="1">processing</urn:STRING>
                        <urn:OBJECT urn:reference="FSCFOLIO@1.1001:objaccdef" urn:index="1">COO.1.1001.1.182601</urn:OBJECT>
                        <urn:STRING urn:reference="COOSYSTEM@1.1:objowngroup.name" urn:index="1">ou</urn:STRING>
                        <urn:ENUM urn:reference="COOELAK@1.1001:filetype" urn:index="1">1</urn:ENUM>
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

    private String createSubFileResponse() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:urn="urn:schemas-editions-fabasoft-com:gov:createsubfile">
                  %s
                  <soapenv:Body>
                    <urn:CreateSubFileResponse>
                      <urn:subfile>
                        <urn:objaddress>COO.1.2.3</urn:objaddress>
                      </urn:subfile>
                    </urn:CreateSubFileResponse>
                  </soapenv:Body>
                </soapenv:Envelope>
                """.formatted(TRANSACTION_HEADER);
    }

    private String setPropertiesResponse() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:urn="urn:schemas-fabasoft-com:universal">
                  %s
                  <soapenv:Body>
                    <urn:response/>
                  </soapenv:Body>
                </soapenv:Envelope>
                """.formatted(TRANSACTION_HEADER);
    }

}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.SPRING_TEST_PROFILE;
import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftTestFixtures.OBJECT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftTestFixtures.REQUEST_CONTEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.TXContext;
import de.muenchen.oss.eakte.api.v2.gateway.AbstractWireMockTest;
import de.muenchen.oss.eakte.api.v2.gateway.EAkteApiV2Gateway;
import de.muenchen.oss.eakte.api.v2.gateway.TestSecurityConfiguration;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import jakarta.xml.ws.Holder;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = EAkteApiV2Gateway.class)
@ActiveProfiles(SPRING_TEST_PROFILE)
@Import(TestSecurityConfiguration.class)
class FabasoftTransactionSoapIntegrationTest extends AbstractWireMockTest {
    private static final String FIRST_TRANSACTION = "transaction-from-create";
    private static final String UPDATED_TRANSACTION = "transaction-from-set";

    @Autowired
    private FabasoftSubFileService subFileService;

    @Autowired
    private FabasoftAttributeService attributeService;

    @Test
    void givenSoapTransactionResponses_thenUpdateHolderAndForwardItsValue() {
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .withHeader("SOAPAction", containing("SOAPCreateSubFile"))
                .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(soapResponse(FIRST_TRANSACTION, """
                                <create:CreateSubFileResponse xmlns:create="urn:schemas-editions-fabasoft-com:gov:createsubfile">
                                  <create:subfile><create:objaddress>%s</create:objaddress></create:subfile>
                                </create:CreateSubFileResponse>
                                """.formatted(OBJECT_ID)))));
        wireMock.stubFor(post(urlPathEqualTo("/"))
                .withHeader("SOAPAction", containing("SOAPGenericSetProperties"))
                .withRequestBody(containing(FIRST_TRANSACTION))
                .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "text/xml; charset=utf-8")
                        .withBody(soapResponse(UPDATED_TRANSACTION, """
                                <universal:response xmlns:universal="urn:schemas-fabasoft-com:universal"/>
                                """))));

        final FabasoftTransaction transaction = new FabasoftTransaction();
        final Holder<TXContext> holder = transaction.getHolder();
        assertNull(holder.value.getTransaction());

        final String objectId = subFileService.createSubFile(REQUEST_CONTEXT, transaction,
                new SubFileRequest(FabasoftObjectType.VORGANG, "parent", "title", "dfv", "subject"));

        assertEquals(OBJECT_ID, objectId);
        assertSame(holder, transaction.getHolder());
        assertEquals(FIRST_TRANSACTION, holder.value.getTransaction());

        attributeService.setAttributes(REQUEST_CONTEXT, transaction, objectId, List.of());

        assertSame(holder, transaction.getHolder());
        assertEquals(UPDATED_TRANSACTION, holder.value.getTransaction());
        wireMock.verify(postRequestedFor(urlPathEqualTo("/"))
                .withHeader("SOAPAction", containing("SOAPGenericSetProperties"))
                .withRequestBody(containing(FIRST_TRANSACTION)));
    }

    private static String soapResponse(final String transaction, final String body) {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                        xmlns:tx="http://schemas.fabasoft.com/websvc/FSCGOVXML_1_1001_DefaultWebServiceDefinition/">
                  <soap:Header><tx:cootx><tx:transaction>%s</tx:transaction><tx:commit>false</tx:commit></tx:cootx></soap:Header>
                  <soap:Body>%s</soap:Body>
                </soap:Envelope>
                """.formatted(transaction, body);
    }
}

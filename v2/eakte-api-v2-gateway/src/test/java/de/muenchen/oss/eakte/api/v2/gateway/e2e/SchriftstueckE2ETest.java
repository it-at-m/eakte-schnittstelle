package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.SPRING_TEST_PROFILE;
import static de.muenchen.oss.eakte.api.v2.gateway.TestSecurityConfiguration.USER;
import static de.muenchen.oss.eakte.api.v2.gateway.TestSecurityConfiguration.USER_IMPERSONATE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.muenchen.oss.eakte.api.v2.gateway.EAkteApiV2Gateway;
import de.muenchen.oss.eakte.api.v2.gateway.TestSecurityConfiguration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = EAkteApiV2Gateway.class)
@AutoConfigureMockMvc
@ActiveProfiles(SPRING_TEST_PROFILE)
@Import(TestSecurityConfiguration.class)
class SchriftstueckE2ETest extends SchriftstueckE2eSupport {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    class SearchDokumentSchriftstuecke {
        @Test
        void givenAuthenticatedRequest_thenReturnSchriftstueckeAndForwardSoapRequest() throws Exception {
            stubSchriftstueckSearchResponse();

            mockMvc.perform(get("/api/v2/dokumente/COO.1.2.3/schriftstuecke")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Stelle", "Sachbearbeitung")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "document query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.elemente[0].dokumentId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].name").value("name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].dateiEndung").value("pdf"))
                    .andExpect(jsonPath("$.elemente[0].dateiGroesse").value(1234));

            verifySearchRequest("document query", "COOELAK@1.1001:referrednumber", true);
            wireMock.verify(1, postRequestedFor(urlPathEqualTo("/")));
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/dokumente/COO.1.2.3/schriftstuecke"))
                    .andExpect(status().isUnauthorized());
        }

        @Test
        void givenImpersonationHeaderButNoRole_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/dokumente/COO.1.2.3/schriftstuecke")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .header("EAkte-Login-Name", "login"))
                    .andExpect(status().isForbidden());
        }

        @Test
        void givenFabasoftFailure_thenReturnServerError() throws Exception {
            stubSoapFailure();

            mockMvc.perform(get("/api/v2/dokumente/COO.1.2.3/schriftstuecke")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isInternalServerError());
        }
    }

    @Nested
    class GetSchriftstueck {
        @Test
        void givenAuthenticatedRequest_thenReturnSchriftstueckAndForwardSoapRequest() throws Exception {
            stubGetSchriftstueckResponse();

            mockMvc.perform(get("/api/v2/schriftstuecke/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Stelle", "Sachbearbeitung")
                    .header("EAkte-Organisationseinheit", "ou"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.dokumentId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.name").value("name"))
                    .andExpect(jsonPath("$.betreff").value("subject"))
                    .andExpect(jsonPath("$.dateiEndung").value("pdf"))
                    .andExpect(jsonPath("$.dateiGroesse").value(1234));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", "COOELAK@1.1001:referrednumber", true);
        }

        @Test
        void givenUnknownSchriftstueckId_thenReturnNotFound() throws Exception {
            stubGetSchriftstueckNotFoundResponse();

            mockMvc.perform(get("/api/v2/schriftstuecke/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER)))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/schriftstuecke/COO.4.5.6"))
                    .andExpect(status().isUnauthorized());
        }
    }
}

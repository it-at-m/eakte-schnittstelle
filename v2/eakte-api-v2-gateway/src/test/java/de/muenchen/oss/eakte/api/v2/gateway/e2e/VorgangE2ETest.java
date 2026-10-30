package de.muenchen.oss.eakte.api.v2.gateway.e2e;

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
class VorgangE2ETest extends VorgangE2eSupport {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetVorgaenge {
        @Test
        void givenAuthenticatedRequest_thenReturnVorgaengeAndForwardSoapRequest() throws Exception {
            stubVorgangResponse();

            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].akteId").value("file-id"))
                    .andExpect(jsonPath("$.elemente[0].name").value("short-name"))
                    .andExpect(jsonPath("$.elemente[0].langname").value("procedure-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].hinweis").value("note"))
                    .andExpect(jsonPath("$.elemente[0].geschaeftsgangvermerk").value("remark"))
                    .andExpect(jsonPath("$.elemente[0].originalMedium").value("elektronisch"))
                    .andExpect(jsonPath("$.elemente[0].status").value("In Bearbeitung"))
                    .andExpect(jsonPath("$.elemente[0].bearbeitungsstatus").value("processing"))
                    .andExpect(jsonPath("$.elemente[0].zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.elemente[0].organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("where query", "custom.attribute", true);
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndSearchVorgaenge() throws Exception {
            stubDfVAndVorgangResponse();

            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("availabledefinitions is not null", "fullreference", false);
            verifySearchRequest("where query", VorgangE2eSupport.DFV_ATTRIBUTE, false);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/vorgaenge").queryParam("bedingungen", "where query"))
                    .andExpect(status().isUnauthorized());
        }

        @Test
        void givenImpersonationHeaderButNoRole_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .header("EAkte-Login-Name", "login")
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isForbidden());
        }

        @Test
        void givenFabasoftFailure_thenReturnServerError() throws Exception {
            stubSoapFailure();

            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isInternalServerError());
        }
    }

    @Nested
    class GetVorgang {
        @Test
        void givenAuthenticatedRequest_thenReturnVorgangAndForwardSoapRequest() throws Exception {
            stubGetVorgangResponse();

            mockMvc.perform(get("/api/v2/vorgaenge/COO.1.2.3")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.name").value("short-name"))
                    .andExpect(jsonPath("$.langname").value("procedure-name"))
                    .andExpect(jsonPath("$.betreff").value("subject"))
                    .andExpect(jsonPath("$.hinweis").value("note"))
                    .andExpect(jsonPath("$.geschaeftsgangvermerk").value("remark"))
                    .andExpect(jsonPath("$.originalMedium").value("elektronisch"))
                    .andExpect(jsonPath("$.status").value("In Bearbeitung"))
                    .andExpect(jsonPath("$.bearbeitungsstatus").value("processing"))
                    .andExpect(jsonPath("$.zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", "custom.attribute", true);
        }

        @Test
        void givenUnknownVorgangId_thenReturnNotFound() throws Exception {
            stubGetVorgangNotFoundResponse();

            mockMvc.perform(get("/api/v2/vorgaenge/COO.1.2.3")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/vorgaenge/COO.1.2.3"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    class SearchVorgaengeBelowAkte {
        @Test
        void givenAuthenticatedRequest_thenReturnVorgaengeAndForwardSoapRequest() throws Exception {
            stubAkteVorgaengeResponse();

            mockMvc.perform(get("/api/v2/akten/COO.1.2.3/vorgaenge")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].akteId").value("file-id"))
                    .andExpect(jsonPath("$.elemente[0].hinweis").value("note"));

            verifySearchRequest(".COOELAK@1.1001:referrednumber = 'COO.1.2.3'", "custom.attribute", true);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/akten/COO.1.2.3/vorgaenge"))
                    .andExpect(status().isUnauthorized());
        }
    }

}

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
public class AkteE2eTest extends AkteE2eSupport {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class SearchAkteBelowAktenplan {
        @Test
        void givenAuthenticatedRequest_thenReturnAkteAndForwardSoapRequest() throws Exception {
            stubAktenplanAkteResponse();

            mockMvc.perform(get("/api/v2/aktenplaneintraege/COO.1.2.3/akten")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Stelle", "Sachbearbeitung")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].aktenplaneintragId").value("subjectArea-id"));

            verifySearchRequest(".ELAKGOV@1.1001:apentry = 'COO.1.2.3'", "custom.attribute", true);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/aktenplaneintraege/COO.1.2.3/akten"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    class GetAkte {
        @Test
        //TODO: fix test givenAuthenticatedRequest_thenReturnAkteAndForwardSoapRequest()
        void givenAuthenticatedRequest_thenReturnAkteAndForwardSoapRequest() throws Exception {
            stubGetAkteResponse();

            mockMvc.perform(get("/api/v2/akten/COO.1.2.3")
                            .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                            .header("EAkte-Login-Name", "login")
                            .header("EAkte-Rolle", "role")
                            .header("EAkte-Organisationseinheit", "ou")
                            .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.aktenplaneintragId").value("subjectArea-id"))
                    .andExpect(jsonPath("$.name").value("name"))
                    .andExpect(jsonPath("$.titel").value("titel"))
                    .andExpect(jsonPath("$.betreff").value("subject"))
                    .andExpect(jsonPath("$.zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.zugriffsdefinitionVorgang").value("acl-procedure"))
                    .andExpect(jsonPath("$.weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", "custom.attribute", true);
        }

        @Test
        void givenUnknownAktenId_thenReturnNotFound() throws Exception {
            stubGetAkteNotFoundResponse();

            mockMvc.perform(get("/api/v2/akten/COO.1.2.3")
                            .header("Authorization", "Bearer %s".formatted(USER))
                            .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/akten/COO.1.2.3"))
                    .andExpect(status().isUnauthorized());
        }
    }

}

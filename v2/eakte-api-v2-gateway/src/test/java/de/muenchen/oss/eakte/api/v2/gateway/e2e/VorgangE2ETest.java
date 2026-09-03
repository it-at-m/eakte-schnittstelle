package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.SPRING_TEST_PROFILE;
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
                    .header("Authorization", "Bearer authenticatedUser")
                    .header("Login-Name", "login")
                    .header("Stelle", "role")
                    .header("Organisationseinheit", "ou")
                    .queryParam("scope", "scope-value")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].sachakte_id").value("file-id"))
                    .andExpect(jsonPath("$.elemente[0].name").value("procedure-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].eigenschaften_map['custom.attribute_1']")
                            .value("custom-value"));

            verifySearchRequest("where query", "custom.attribute");
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndSearchVorgaenge() throws Exception {
            stubDfVAndVorgangResponse();

            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer authenticatedUser")
                    .header("Login-Name", "login")
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].eigenschaften_map['custom.attribute_1']")
                            .value("custom-value"));

            verifySearchRequest("availabledefinitions is not null", "fullreference");
            verifySearchRequest("where query", VorgangE2eSupport.DFV_ATTRIBUTE);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/vorgaenge").queryParam("bedingungen", "where query"))
                    .andExpect(status().isUnauthorized());
        }

        @Test
        void givenFabasoftFailure_thenReturnServerError() throws Exception {
            stubSoapFailure();

            mockMvc.perform(get("/api/v2/vorgaenge")
                    .header("Authorization", "Bearer authenticatedUser")
                    .header("Login-Name", "login")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isInternalServerError());
        }
    }
}

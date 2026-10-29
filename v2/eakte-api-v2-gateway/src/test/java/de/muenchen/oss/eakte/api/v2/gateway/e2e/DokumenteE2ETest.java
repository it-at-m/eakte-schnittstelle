package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.SPRING_TEST_PROFILE;
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
class DokumenteE2ETest extends DokumenteE2eSupport {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetVorgangsDokumente {
        @Test
        void givenAuthenticatedRequest_thenReturnDokumenteAndForwardSoapRequest() throws Exception {
            stubDokumentResponse();

            mockMvc.perform(get("/api/v2/vorgaenge/COO123.123.123/dokumente")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "Sachbearbeitung")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "document query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.2.3.4"))
                    .andExpect(jsonPath("$.elemente[0].klasse").value("Eingang"))
                    .andExpect(jsonPath("$.elemente[0].parent.id").value("COO123.123.123"))
                    .andExpect(jsonPath("$.elemente[0].parent.type").value("Vorgang"))
                    .andExpect(jsonPath("$.elemente[0].name").value("short-name"))
                    .andExpect(jsonPath("$.elemente[0].langname").value("document-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.elemente[0].organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("document query", "custom.attribute", true);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/vorgaenge/vorgang-id/dokumente"))
                    .andExpect(status().isUnauthorized());
        }
    }
}

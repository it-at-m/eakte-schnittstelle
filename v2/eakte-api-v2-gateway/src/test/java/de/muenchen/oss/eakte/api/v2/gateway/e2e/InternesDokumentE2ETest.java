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
class InternesDokumentE2ETest extends InternesDokumentE2eSupport {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    class SearchInterneDokumente {
        @Test
        void givenAuthenticatedRequest_thenReturnInterneDokumenteAndForwardSoapRequest() throws Exception {
            stubInternesDokumentSearchResponse();

            mockMvc.perform(get("/api/v2/interne-dokumente")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("limit", "123")
                    .queryParam("bedingungen", "where query")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.elemente[0].klasse").value("Intern"))
                    .andExpect(jsonPath("$.elemente[0].vorgangId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].name").value("short-name"))
                    .andExpect(jsonPath("$.elemente[0].langname").value("internal-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].hinweis").value("internal note"))
                    .andExpect(jsonPath("$.elemente[0].zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.elemente[0].organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.elemente[0].zustellungsDatum").value("2025-01-02"))
                    .andExpect(jsonPath("$.elemente[0].dokumententyp").value("letter"))
                    .andExpect(jsonPath("$.elemente[0].anlagenBeschreibung").value("additional enclosure"))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("where query", ZUSTELLUNGSDATUM_REFERENCE, true);
            verifySearchRequest("where query", DOKUMENTENTYP_REFERENCE, true);
            verifySearchRequest("where query", ANLAGEN_BESCHREIBUNG_REFERENCE, true);
            verifySearchRequest("where query", "custom.attribute", true);
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndSearchInterneDokumente() throws Exception {
            stubDfVAndInternesDokumentSearchResponse();

            mockMvc.perform(get("/api/v2/interne-dokumente")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].id").value("COO.4.5.6"));

            verifySearchRequest("availabledefinitions is not null", "fullreference", false);
            verifySearchRequest("where query", DFV_ATTRIBUTE, false);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/interne-dokumente").queryParam("bedingungen", "where query"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    class GetInternesDokument {
        @Test
        void givenAuthenticatedRequest_thenReturnInternesDokumentAndForwardSoapRequest() throws Exception {
            stubGetInternesDokumentResponse();

            mockMvc.perform(get("/api/v2/interne-dokumente/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.klasse").value("Intern"))
                    .andExpect(jsonPath("$.zustellungsDatum").value("2025-01-02"))
                    .andExpect(jsonPath("$.dokumententyp").value("letter"))
                    .andExpect(jsonPath("$.anlagenBeschreibung").value("additional enclosure"));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", ZUSTELLUNGSDATUM_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", DOKUMENTENTYP_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", ANLAGEN_BESCHREIBUNG_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", "custom.attribute", true);
        }

        @Test
        void givenUnknownInternesDokumentId_thenReturnNotFound() throws Exception {
            stubGetInternesDokumentNotFoundResponse();

            mockMvc.perform(get("/api/v2/interne-dokumente/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/interne-dokumente/COO.4.5.6"))
                    .andExpect(status().isUnauthorized());
        }
    }
}

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
class EingangsdokumentE2ETest extends EingangsdokumentE2eSupport {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    class SearchEingangsdokumente {
        @Test
        void givenAuthenticatedRequest_thenReturnEingangsdokumenteAndForwardSoapRequest() throws Exception {
            stubEingangsdokumentSearchResponse();

            mockMvc.perform(get("/api/v2/eingangsdokumente")
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
                    .andExpect(jsonPath("$.elemente[0].klasse").value("Eingang"))
                    .andExpect(jsonPath("$.elemente[0].vorgangId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].name").value("short-name"))
                    .andExpect(jsonPath("$.elemente[0].langname").value("incoming-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.elemente[0].organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.elemente[0].fremdesGeschaeftszeichen").value("external-reference"))
                    .andExpect(jsonPath("$.elemente[0].eingangsdatum").value("2025-01-02"))
                    .andExpect(jsonPath("$.elemente[0].hinweis").value("incoming note"))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("where query", "COOELAK@1.1001:delivery", true);
            verifySearchRequest("where query", "custom.attribute", true);
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndSearchEingangsdokumente() throws Exception {
            stubDfVAndEingangsdokumentSearchResponse();

            mockMvc.perform(get("/api/v2/eingangsdokumente")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].fremdesGeschaeftszeichen").value("external-reference"));

            verifySearchRequest("availabledefinitions is not null", "fullreference", false);
            verifySearchRequest("where query", DFV_ATTRIBUTE, false);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/eingangsdokumente").queryParam("bedingungen", "where query"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    class GetEingangsdokument {
        @Test
        void givenAuthenticatedRequest_thenReturnEingangsdokumentAndForwardSoapRequest() throws Exception {
            stubGetEingangsdokumentResponse();

            mockMvc.perform(get("/api/v2/eingangsdokumente/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.klasse").value("Eingang"))
                    .andExpect(jsonPath("$.vorgangId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.name").value("short-name"))
                    .andExpect(jsonPath("$.langname").value("incoming-name"))
                    .andExpect(jsonPath("$.fremdesGeschaeftszeichen").value("external-reference"))
                    .andExpect(jsonPath("$.eingangsdatum").value("2025-01-02"))
                    .andExpect(jsonPath("$.hinweis").value("incoming note"));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", "custom.attribute", true);
        }

        @Test
        void givenUnknownEingangsdokumentId_thenReturnNotFound() throws Exception {
            stubGetEingangsdokumentNotFoundResponse();

            mockMvc.perform(get("/api/v2/eingangsdokumente/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/eingangsdokumente/COO.4.5.6"))
                    .andExpect(status().isUnauthorized());
        }
    }
}

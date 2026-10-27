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
class ErledigungE2ETest extends ErledigungE2eSupport {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    class SearchErledigungen {
        @Test
        void givenAuthenticatedRequest_thenReturnErledigungenAndForwardSoapRequest() throws Exception {
            stubErledigungSearchResponse();

            mockMvc.perform(get("/api/v2/erledigungen")
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
                    .andExpect(jsonPath("$.elemente[0].klasse").value("Erledigung"))
                    .andExpect(jsonPath("$.elemente[0].vorgangId").value("COO.1.2.3"))
                    .andExpect(jsonPath("$.elemente[0].name").value("short-name"))
                    .andExpect(jsonPath("$.elemente[0].langname").value("outgoing-name"))
                    .andExpect(jsonPath("$.elemente[0].betreff").value("subject"))
                    .andExpect(jsonPath("$.elemente[0].hinweis").value("document note"))
                    .andExpect(jsonPath("$.elemente[0].zugriffsdefinition").value("acl"))
                    .andExpect(jsonPath("$.elemente[0].organisationseinheit").value("ou"))
                    .andExpect(jsonPath("$.elemente[0].bezugEingangsdokument").value("COO.7.8.9"))
                    .andExpect(jsonPath("$.elemente[0].dokumententyp").value("letter"))
                    .andExpect(jsonPath("$.elemente[0].anlagenBeschreibung").value("additional enclosure"))
                    .andExpect(jsonPath("$.elemente[0].weitereEigenschaften[?(@.reference=='custom.attribute')].value")
                            .value("custom-value"));

            verifySearchRequest("where query", BEZUG_EINGANGSDOKUMENT_REFERENCE, true);
            verifySearchRequest("where query", DOKUMENTENTYP_REFERENCE, true);
            verifySearchRequest("where query", ANLAGEN_BESCHREIBUNG_REFERENCE, true);
            verifySearchRequest("where query", "custom.attribute", true);
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndSearchErledigungen() throws Exception {
            stubDfVAndErledigungSearchResponse();

            mockMvc.perform(get("/api/v2/erledigungen")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("bedingungen", "where query"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.anzahl").value(1))
                    .andExpect(jsonPath("$.elemente[0].bezugEingangsdokument").value("COO.7.8.9"));

            verifySearchRequest("availabledefinitions is not null", "fullreference", false);
            verifySearchRequest("where query", DFV_ATTRIBUTE, false);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/erledigungen").queryParam("bedingungen", "where query"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @Nested
    class GetErledigung {
        @Test
        void givenAuthenticatedRequest_thenReturnErledigungAndForwardSoapRequest() throws Exception {
            stubGetErledigungResponse();

            mockMvc.perform(get("/api/v2/erledigungen/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", "login")
                    .header("EAkte-Rolle", "role")
                    .header("EAkte-Organisationseinheit", "ou")
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value("COO.4.5.6"))
                    .andExpect(jsonPath("$.klasse").value("Erledigung"))
                    .andExpect(jsonPath("$.hinweis").value("document note"))
                    .andExpect(jsonPath("$.bezugEingangsdokument").value("COO.7.8.9"))
                    .andExpect(jsonPath("$.dokumententyp").value("letter"))
                    .andExpect(jsonPath("$.anlagenBeschreibung").value("additional enclosure"));

            verifySearchRequest("COOSYSTEM@1.1:objaddress", BEZUG_EINGANGSDOKUMENT_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", DOKUMENTENTYP_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", ANLAGEN_BESCHREIBUNG_REFERENCE, true);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", "custom.attribute", true);
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesAndGetErledigung() throws Exception {
            stubDfVAndGetErledigungResponse();

            mockMvc.perform(get("/api/v2/erledigungen/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.bezugEingangsdokument").value("COO.7.8.9"));

            verifySearchRequest("availabledefinitions is not null", "fullreference", false);
            verifySearchRequest("COOSYSTEM@1.1:objaddress", BEZUG_EINGANGSDOKUMENT_REFERENCE, false);
        }

        @Test
        void givenUnknownErledigungId_thenReturnNotFound() throws Exception {
            stubGetErledigungNotFoundResponse();

            mockMvc.perform(get("/api/v2/erledigungen/COO.4.5.6")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .queryParam("eigenschaften", "custom.attribute"))
                    .andExpect(status().isNotFound());
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/erledigungen/COO.4.5.6"))
                    .andExpect(status().isUnauthorized());
        }
    }
}

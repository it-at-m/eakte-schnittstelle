package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_MANDANT;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_USERNAME;
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
class BenutzerE2ETest extends BenutzerE2eSupport {
    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetBenutzerIch {
        @Test
        void givenAuthenticatedRequest_thenReturnOwnUserAndForwardSoapRequest() throws Exception {
            stubUserInformationResponse(USER);

            mockMvc.perform(get("/api/v2/benutzer/ich")
                    .header("Authorization", "Bearer %s".formatted(USER)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(BENUTZER_ID))
                    .andExpect(jsonPath("$.username").value(USER))
                    .andExpect(jsonPath("$.rollen[0].mandant").value(BENUTZER_MANDANT))
                    .andExpect(jsonPath("$.rollen[0].organisationseinheit.id").value(BENUTZER_OE_ID))
                    .andExpect(jsonPath("$.rollen[0].organisationseinheit.name").value(BENUTZER_OE_NAME))
                    .andExpect(jsonPath("$.rollen[0].stelle").value("Sachbearbeitung"))
                    .andExpect(jsonPath("$.rollen[0].default").value(true));

            verifyUserInformationRequest(USER);
        }

        @Test
        void givenImpersonationPermissionAndLoginOverride_thenReturnRequestedUser() throws Exception {
            stubUserInformationResponse(BENUTZER_USERNAME);

            mockMvc.perform(get("/api/v2/benutzer/ich")
                    .header("Authorization", "Bearer %s".formatted(USER_IMPERSONATE))
                    .header("EAkte-Login-Name", BENUTZER_USERNAME))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username").value(BENUTZER_USERNAME));

            verifyUserInformationRequest(BENUTZER_USERNAME);
        }

        @Test
        void givenNoAuthentication_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/benutzer/ich"))
                    .andExpect(status().isUnauthorized());
        }

        @Test
        void givenLoginOverrideWithoutImpersonationRole_thenRejectRequest() throws Exception {
            mockMvc.perform(get("/api/v2/benutzer/ich")
                    .header("Authorization", "Bearer %s".formatted(USER))
                    .header("EAkte-Login-Name", BENUTZER_USERNAME))
                    .andExpect(status().isForbidden());
        }

        @Test
        void givenFabasoftFailure_thenReturnServerError() throws Exception {
            stubSoapFailure();

            mockMvc.perform(get("/api/v2/benutzer/ich")
                    .header("Authorization", "Bearer %s".formatted(USER)))
                    .andExpect(status().isInternalServerError());
        }
    }
}

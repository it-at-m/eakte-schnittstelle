package de.muenchen.oss.eakte.v2.starter;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.tomakehurst.wiremock.WireMockServer;
import de.muenchen.oss.eakte.v2.generated.api.VorgangApi;
import de.muenchen.oss.eakte.v2.generated.model.Vorgang;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(classes = EAkteClientCredentialsConfigurationTest.TestApplication.class)
class EAkteClientCredentialsConfigurationTest {

    private static final String REGISTRATION_ID = "custom-eakte-client";
    private static final String PROVIDER_ID = "local-keycloak";
    private static final String CLIENT_ID = "test-client";
    private static final String CLIENT_SECRET = "test-secret";
    private static final String ACCESS_TOKEN = "service-access-token";
    private static final WireMockServer WIREMOCK = new WireMockServer(options().dynamicPort());

    @Autowired
    private VorgangApi vorgangApi;

    @BeforeAll
    static void startWireMock() {
        WIREMOCK.start();
        WIREMOCK.stubFor(get(urlEqualTo("/.well-known/openid-configuration"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                  "issuer": "%s",
                                  "authorization_endpoint": "%s/oauth/authorize",
                                  "token_endpoint": "%s/oauth/token",
                                  "jwks_uri": "%s/oauth/keys",
                                  "response_types_supported": ["code"],
                                  "subject_types_supported": ["public"],
                                  "id_token_signing_alg_values_supported": ["RS256"]
                                }
                                """.formatted(
                                WIREMOCK.baseUrl(), WIREMOCK.baseUrl(), WIREMOCK.baseUrl(), WIREMOCK.baseUrl()))));
    }

    @AfterAll
    static void stopWireMock() {
        WIREMOCK.stop();
    }

    @AfterEach
    void clearSecurityContext() {
        SecurityContextHolder.clearContext();
        WIREMOCK.resetAll();
    }

    @DynamicPropertySource
    static void registerProperties(final DynamicPropertyRegistry registry) {
        registry.add("eakte.base-url", WIREMOCK::baseUrl);
        registry.add("eakte.auth.mode", () -> "client-credentials");
        registry.add("eakte.auth.client-registration-id", () -> REGISTRATION_ID);
        registry.add(
                "spring.security.oauth2.client.registration.%s.provider".formatted(REGISTRATION_ID),
                () -> PROVIDER_ID);
        registry.add(
                "spring.security.oauth2.client.registration.%s.authorization-grant-type".formatted(REGISTRATION_ID),
                () -> "client_credentials");
        registry.add(
                "spring.security.oauth2.client.registration.%s.client-id".formatted(REGISTRATION_ID),
                () -> CLIENT_ID);
        registry.add(
                "spring.security.oauth2.client.registration.%s.client-secret".formatted(REGISTRATION_ID),
                () -> CLIENT_SECRET);
        registry.add(
                "spring.security.oauth2.client.provider.%s.issuer-uri".formatted(PROVIDER_ID),
                WIREMOCK::baseUrl);
    }

    @SpringBootConfiguration
    @EnableAutoConfiguration
    @Import(EAkteClientConfiguration.class)
    static class TestApplication {}

    @Test
    void giveNoJwtAndClientCredentialsMode_thenAcquireAndReuseClientCredentialsToken() {
        WIREMOCK.stubFor(post(urlEqualTo("/oauth/token"))
                .withRequestBody(containing("grant_type=client_credentials"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                                {
                                  "access_token": "%s",
                                  "token_type": "Bearer",
                                  "expires_in": 300
                                }
                                """.formatted(ACCESS_TOKEN))));
        WIREMOCK.stubFor(get(urlEqualTo("/api/v2/vorgaenge/%s".formatted(EAkteClientConfigurationTest.VORGANG_ID)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(EAkteClientConfigurationTest.VORGANG_RESPONSE
                                .formatted(EAkteClientConfigurationTest.VORGANG_ID))));

        final Vorgang firstResponse = vorgangApi.getVorgang(
                EAkteClientConfigurationTest.VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of());
        final Vorgang secondResponse = vorgangApi.getVorgang(
                EAkteClientConfigurationTest.VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of());

        assertThat(firstResponse.getId()).isEqualTo(EAkteClientConfigurationTest.VORGANG_ID);
        assertThat(secondResponse.getId()).isEqualTo(EAkteClientConfigurationTest.VORGANG_ID);
        WIREMOCK.verify(1, postRequestedFor(urlEqualTo("/oauth/token"))
                .withRequestBody(containing("grant_type=client_credentials")));
        WIREMOCK.verify(2, getRequestedFor(urlEqualTo(
                        "/api/v2/vorgaenge/%s".formatted(EAkteClientConfigurationTest.VORGANG_ID)))
                .withHeader("Authorization", equalTo("Bearer %s".formatted(ACCESS_TOKEN))));
    }
}

package de.muenchen.oss.eakte.v2.starter;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.tomakehurst.wiremock.WireMockServer;
import de.muenchen.oss.eakte.v2.generated.api.VorgangApi;
import de.muenchen.oss.eakte.v2.generated.model.Vorgang;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(classes = EAkteClientConfiguration.class)
class EAkteClientConfigurationTest {

    private static final WireMockServer WIREMOCK = new WireMockServer(options().dynamicPort());
    static final String VORGANG_ID = "COO.1.2301.1.1042465";
    static final String VORGANG_RESPONSE = """
            {
              "id": "%s",
              "akteId": "COO.1.2301.1.1042400",
              "name": "Vorgang",
              "langname": "Vorgang",
              "originalMedium": "elektronisch",
              "status": "In Bearbeitung",
              "bearbeitungsstatus": "In Bearbeitung",
              "zugriffsdefinition": "zugriffsdefinition",
              "organisationseinheit": "COO.1.2301.1.ou",
              "weitereEigenschaften": []
            }
            """;

    @Autowired
    private VorgangApi vorgangApi;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeAll
    static void startWireMock() {
        WIREMOCK.start();
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
        registry.add("eaktev2.base-url", WIREMOCK::baseUrl);
        registry.add("eaktev2.auth.mode", () -> "existing-jwt");
    }

    @Test
    void giveGetVorgangRequest_thenUseStarterClientWithoutAdditionalDependencies() {
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(
                Jwt.withTokenValue("user-access-token").header("alg", "none").subject("user-1").build()));
        WIREMOCK.stubFor(get(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(VORGANG_RESPONSE.formatted(VORGANG_ID))));

        final Vorgang response = vorgangApi.getVorgang(
                VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of());

        assertThat(response.getId()).isEqualTo(VORGANG_ID);
        WIREMOCK.verify(getRequestedFor(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .withHeader("Authorization", equalTo("Bearer user-access-token"))
                .withHeader("EAkte-Login-Name", equalTo("user-login"))
                .withHeader("EAkte-Rolle", equalTo("Official"))
                .withHeader("EAkte-Organisationseinheit", equalTo("COO.1.2301.1.ou")));
    }

    @Test
    void giveExistingJwtModeWithoutJwt_thenFailWithoutCallingApi() {
        assertThatThrownBy(() -> vorgangApi.getVorgang(
                        VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("JWT");

        WIREMOCK.verify(0, getRequestedFor(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID))));
    }

    @Test
    void giveConcurrentJwtRequests_thenForwardEachThreadsToken() throws Exception {
        WIREMOCK.stubFor(get(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(VORGANG_RESPONSE.formatted(VORGANG_ID))));

        final ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            final Future<Vorgang> firstResponse = executor.submit(() -> getVorgangWithJwt("first-user-token"));
            final Future<Vorgang> secondResponse = executor.submit(() -> getVorgangWithJwt("second-user-token"));

            assertThat(firstResponse.get(10, TimeUnit.SECONDS).getId()).isEqualTo(VORGANG_ID);
            assertThat(secondResponse.get(10, TimeUnit.SECONDS).getId()).isEqualTo(VORGANG_ID);
        } finally {
            executor.shutdownNow();
        }

        WIREMOCK.verify(getRequestedFor(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .withHeader("Authorization", equalTo("Bearer first-user-token")));
        WIREMOCK.verify(getRequestedFor(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .withHeader("Authorization", equalTo("Bearer second-user-token")));
    }

    @Test
    void giveGeneratedApiClasses_thenEachIsRegisteredAsBean() {
        final ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*Api")));

        final Set<BeanDefinition> apiCandidates =
                scanner.findCandidateComponents("de.muenchen.oss.eakte.v2.generated.api");
        assertThat(apiCandidates).isNotEmpty();

        apiCandidates
                .forEach(candidate -> {
                    try {
                        final Class<?> apiClass = Class.forName(candidate.getBeanClassName());
                        assertThat(applicationContext.getBeansOfType(apiClass))
                                .as("Expected a bean for %s", apiClass.getName())
                                .isNotEmpty();
                    } catch (final ClassNotFoundException exception) {
                        throw new IllegalStateException(exception);
                    }
                });
    }

    private Vorgang getVorgangWithJwt(final String token) {
        final SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(new JwtAuthenticationToken(
                Jwt.withTokenValue(token).header("alg", "none").subject("user-1").build()));
        SecurityContextHolder.setContext(securityContext);
        try {
            return vorgangApi.getVorgang(
                    VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of());
        } finally {
            SecurityContextHolder.clearContext();
        }
    }
}

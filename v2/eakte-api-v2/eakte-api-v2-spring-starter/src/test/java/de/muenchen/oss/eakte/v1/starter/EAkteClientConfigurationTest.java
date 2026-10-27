package de.muenchen.oss.eakte.v1.starter;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.tomakehurst.wiremock.WireMockServer;
import de.muenchen.oss.eakte.v2.generated.api.VorgangApi;
import de.muenchen.oss.eakte.v2.generated.model.Vorgang;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(classes = EAkteClientConfiguration.class)
class EAkteClientConfigurationTest {

    private static final WireMockServer WIREMOCK = new WireMockServer(options().dynamicPort());
    private static final String VORGANG_ID = "COO.1.2301.1.1042465";

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

    @DynamicPropertySource
    static void registerProperties(final DynamicPropertyRegistry registry) {
        registry.add("eakte.base-url", WIREMOCK::baseUrl);
    }

    @Test
    void giveGetVorgangRequest_thenUseStarterClientWithoutAdditionalDependencies() {
        WIREMOCK.stubFor(get(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
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
                                """.formatted(VORGANG_ID))));

        final Vorgang response = vorgangApi.getVorgang(
                VORGANG_ID, "user-login", "Official", "COO.1.2301.1.ou", List.of());

        assertThat(response.getId()).isEqualTo(VORGANG_ID);
        WIREMOCK.verify(getRequestedFor(urlEqualTo("/api/v2/vorgaenge/%s".formatted(VORGANG_ID)))
                .withHeader("EAkte-Login-Name", equalTo("user-login"))
                .withHeader("EAkte-Rolle", equalTo("Official"))
                .withHeader("EAkte-Organisationseinheit", equalTo("COO.1.2301.1.ou")));
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
}

package de.muenchen.oss.eakte.v1.starter;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.tomakehurst.wiremock.WireMockServer;
import de.muenchen.oss.eakte.v1.generated.api.ContentObjectsApi;
import de.muenchen.oss.eakte.v1.generated.model.CreateContentObjectAnfrageDTO;
import de.muenchen.oss.eakte.v1.generated.model.CreateContentObjectAntwortDTO;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(classes = EAkteClientConfiguration.class)
class EAkteClientConfigurationTest {

    private static final WireMockServer WIREMOCK = new WireMockServer(options().dynamicPort());

    @Autowired
    private ContentObjectsApi contentObjectsApi;

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
        registry.add("eakte.username", () -> "technical-user");
        registry.add("eakte.password", () -> "technical-password");
    }

    @Test
    void giveContentObjectRequest_thenUseStarterClientWithoutAdditionalDependencies() {
        WIREMOCK.stubFor(post(urlEqualTo("/contentObjects"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"objid\":\"COO.1.2301.1.1042465\"}")));

        final CreateContentObjectAntwortDTO response = contentObjectsApi.createContentObject(
                        "user-login",
                        new CreateContentObjectAnfrageDTO().referrednumber("COO.1.2301.1.1042432"),
                        "test-application",
                        "COO.1.2301.1.ou",
                        "Official",
                        List.of(new ByteArrayResource("file-content".getBytes(StandardCharsets.UTF_8)) {
                            @Override
                            public String getFilename() {
                                return "test.txt";
                            }
                        }))
                .block();

        assertThat(response.getObjid()).isEqualTo("COO.1.2301.1.1042465");
        WIREMOCK.verify(postRequestedFor(urlEqualTo("/contentObjects"))
                .withHeader("Authorization", equalTo("Basic dGVjaG5pY2FsLXVzZXI6dGVjaG5pY2FsLXBhc3N3b3Jk"))
                .withHeader("Content-Type", containing("multipart/form-data"))
                .withHeader("x-anwendung", equalTo("test-application"))
                .withHeader("userlogin", equalTo("user-login"))
                .withHeader("joboe", equalTo("COO.1.2301.1.ou"))
                .withHeader("jobposition", equalTo("Official"))
                .withRequestBody(containing("COO.1.2301.1.1042432"))
                .withRequestBody(containing("file-content")));
    }
}

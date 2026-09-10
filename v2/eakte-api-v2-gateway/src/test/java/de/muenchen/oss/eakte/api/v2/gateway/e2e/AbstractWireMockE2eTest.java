package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;

@EnableWireMock(@ConfigureWireMock(baseUrlProperties = "fabasoft.url"))
abstract class AbstractWireMockE2eTest {

    @InjectWireMock
    protected WireMockServer wireMock;

    @BeforeEach
    void setUp() {
        wireMock.resetAll();
    }

    @DynamicPropertySource
    static void registerProperties(final DynamicPropertyRegistry registry) {
        final String keystoreLocation = createTestKeystore();
        registry.add("fabasoft.keystore-location", () -> keystoreLocation);
        registry.add("fabasoft.keystore-password", () -> "changeit");
        registry.add("fabasoft.connect-timeout", () -> "1s");
        registry.add("fabasoft.read-timeout", () -> "5s");
    }

    private static String createTestKeystore() {
        try {
            final Path keystore = Files.createTempFile("eakte-gateway-test-", ".p12");
            final KeyStore keyStore = KeyStore.getInstance("PKCS12");
            final char[] password = "changeit".toCharArray();
            keyStore.load(null, password);
            try (OutputStream outputStream = Files.newOutputStream(keystore)) {
                keyStore.store(outputStream, password);
            }
            return keystore.toUri().toString();
        } catch (final IOException | GeneralSecurityException e) {
            throw new IllegalStateException("Could not create test keystore", e);
        }
    }
}

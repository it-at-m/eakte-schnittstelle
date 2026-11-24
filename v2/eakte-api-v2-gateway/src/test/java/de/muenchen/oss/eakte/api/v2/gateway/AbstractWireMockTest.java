package de.muenchen.oss.eakte.api.v2.gateway;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
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
import org.wiremock.spring.WireMockConfigurationCustomizer;

@EnableWireMock(@ConfigureWireMock(baseUrlProperties = "fabasoft.url", configurationCustomizers = AbstractWireMockTest.WireMockHttpConfiguration.class))
public abstract class AbstractWireMockTest {

    @InjectWireMock
    protected WireMockServer wireMock;

    @BeforeEach
    protected void setUp() {
        wireMock.resetAll();
    }

    @DynamicPropertySource
    protected static void registerProperties(final DynamicPropertyRegistry registry) {
        final String keystoreLocation = createTestKeystore();
        registry.add("fabasoft.keystore-location", () -> keystoreLocation);
        registry.add("fabasoft.keystore-password", () -> "changeit");
        registry.add("fabasoft.connect-timeout", () -> "1s");
        registry.add("fabasoft.read-timeout", () -> "5s");
    }

    public static class WireMockHttpConfiguration implements WireMockConfigurationCustomizer {
        @Override
        public void customize(final WireMockConfiguration configuration, final ConfigureWireMock annotation) {
            // Jetty cannot upgrade the chunked SOAP request to cleartext HTTP/2.
            configuration.http2PlainDisabled(true);
        }
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

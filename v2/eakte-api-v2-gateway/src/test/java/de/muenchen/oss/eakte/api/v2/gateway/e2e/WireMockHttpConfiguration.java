package de.muenchen.oss.eakte.api.v2.gateway.e2e;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.WireMockConfigurationCustomizer;

public class WireMockHttpConfiguration implements WireMockConfigurationCustomizer {
    @Override
    public void customize(final WireMockConfiguration configuration, final ConfigureWireMock annotation) {
        // Jetty cannot upgrade the chunked SOAP request to cleartext HTTP/2.
        configuration.http2PlainDisabled(true);
    }
}

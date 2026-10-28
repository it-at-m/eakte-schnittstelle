package de.muenchen.oss.eakte.v1.starter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties("eakte")
@Data
@Validated
public class EAkteClientProperties {
    /**
     * Authentication settings for requests made by the generated eAkte client.
     */
    @NotNull
    @Valid
    private AuthProperties auth = new AuthProperties();
    /**
     * The base URL of the eAkte API. Generated API paths, including the /api/v2 prefix, are appended.
     */
    @NotBlank
    private String baseUrl;
    /**
     * Timeout for connecting to the eAkte API.
     */
    @NotNull
    @DurationMin(millis = 1)
    private Duration connectionTimeout = Duration.ofSeconds(30);
    /**
     * Timeout for waiting for an eAkte API response. Defaults to 120 seconds.
     */
    @NotNull
    @DurationMin(millis = 1)
    private Duration responseTimeout = Duration.ofSeconds(120);

    /**
     * Authentication mode and OAuth2 client registration used by the eAkte client.
     */
    @Data
    public static class AuthProperties {
        /**
         * Required token source: forward an existing JWT, use client credentials, or let
         * the application configure the generated ApiClient directly.
         */
        @NotNull
        private Mode mode;
        /**
         * Spring OAuth2 client registration ID used only in client-credentials mode. Defaults
         * to "eakte".
         */
        @NotBlank
        private String clientRegistrationId = "eakte";

        public enum Mode {
            /** Forward the JWT from the current Spring Security context. */
            EXISTING_JWT,
            /** Acquire a token from the configured Spring OAuth2 client registration. */
            CLIENT_CREDENTIALS,
            /** Leave bearer-token configuration to the application via ApiClient.setBearerToken. */
            CUSTOM
        }
    }
}

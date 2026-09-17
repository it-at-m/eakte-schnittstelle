package de.muenchen.oss.eakte.v1.starter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties("eakte")
@Data
@Validated
@ToString(exclude = "password")
public class EAkteClientProperties {
    /**
     * The base URL of the eAkte API.
     */
    @NotBlank private String baseUrl;
    /**
     * Username used for authenticating against the eAkte API.
     */
    @NotBlank private String username;
    /**
     * Password used for authenticating against the eAkte API.
     */
    @NotBlank private String password;
    /**
     * Timeout for connecting to the eAkte API.
     */
    @NotNull
    @DurationMin(millis = 1)
    private Duration connectionTimeout = Duration.ofSeconds(30);
    /**
     * Timeout for the eAkte API to response.
     */
    @NotNull
    @DurationMin(millis = 1)
    private Duration responseTimeout = Duration.ofSeconds(120);
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Duration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

@Data
@ConfigurationProperties("fabasoft")
@Validated
public class FabasoftProperties {
    @NotBlank private String url;
    @NotNull private Resource keystoreLocation;
    private String keystorePassword;
    @NotNull private Duration connectTimeout = Duration.ofSeconds(10);
    @NotNull private Duration readTimeout = Duration.ofSeconds(60);
}

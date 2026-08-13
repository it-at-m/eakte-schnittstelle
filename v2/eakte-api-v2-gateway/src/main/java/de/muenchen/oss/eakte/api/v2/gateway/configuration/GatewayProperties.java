package de.muenchen.oss.eakte.api.v2.gateway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@ConfigurationProperties("app")
@Validated
public class GatewayProperties {
}

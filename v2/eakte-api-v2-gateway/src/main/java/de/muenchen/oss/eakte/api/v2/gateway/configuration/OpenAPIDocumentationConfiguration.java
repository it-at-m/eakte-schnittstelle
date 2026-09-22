package de.muenchen.oss.eakte.api.v2.gateway.configuration;

import de.muenchen.oss.eakte.api.v2.gateway.configuration.security.SecurityProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenAPIDocumentationConfiguration {
    private final SecurityProperties securityProperties;

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.OPENIDCONNECT)
                                .openIdConnectUrl(securityProperties.getOpenIdConnectUrl())));
    }

}

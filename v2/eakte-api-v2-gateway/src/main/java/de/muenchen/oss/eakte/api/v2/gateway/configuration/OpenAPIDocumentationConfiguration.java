package de.muenchen.oss.eakte.api.v2.gateway.configuration;

import de.muenchen.oss.eakte.api.v2.gateway.configuration.security.SecurityProperties;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenAPIDocumentationConfiguration {
    private final SecurityProperties securityProperties;

    @Bean
    public OpenAPI customOpenAPI(@Value("${spring.application.version:}") final String version) {
        return new OpenAPI()
                .info(new Info()
                        .title("eAkte API V2")
                        .version(version)
                        .description("""
                                 See [the documentation](https://it-at-m.github.io/eakte-schnittstelle/v2/) for further information.
                                 Use `bearerAuth (OAuth2, authorization_code)` for authentication.
                                """))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.OPENIDCONNECT)
                                .openIdConnectUrl(securityProperties.getOpenIdConnectUrl())));
    }

}

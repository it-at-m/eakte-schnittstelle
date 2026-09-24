package de.muenchen.oss.eakte.api.v2.gateway;

import de.muenchen.oss.eakte.api.v2.gateway.configuration.security.SecurityProperties;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

/**
 * Configures a mocked JwtDecoder as Spring bean to test authorization via roles.
 */
@TestConfiguration
@RequiredArgsConstructor
public class TestSecurityConfiguration {
    public static final String USER = "authenticatedUser";
    public static final String USER_IMPERSONATE = "impersonateUser";
    private static final Map<String, List<String>> USER_ROLES = Map.of(
            USER, List.of(),
            USER_IMPERSONATE, List.of("impersonate"));

    private final SecurityProperties securityProperties;

    @Bean
    public JwtDecoder mockedJwtDecoder() {
        JwtDecoder mockedJwtDecoder = Mockito.mock(JwtDecoder.class);

        USER_ROLES.forEach((user, roles) -> {
            Mockito.when(mockedJwtDecoder.decode(user))
                    .thenReturn(jwtWithRole(user, roles));
        });

        return mockedJwtDecoder;
    }

    private Jwt jwtWithRole(final String user, final List<String> roles) {
        return Jwt.withTokenValue(user)
                .header("alg", "none")
                .claim("preferred_username", user)
                .claim(
                        "resource_access",
                        Map.of(
                                securityProperties.getClientId(),
                                Map.of("roles", roles)))
                .build();
    }

}

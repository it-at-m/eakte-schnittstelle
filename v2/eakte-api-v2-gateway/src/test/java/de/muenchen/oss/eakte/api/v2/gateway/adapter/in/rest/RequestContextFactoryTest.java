package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ImpersonationForbiddenException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

class RequestContextFactoryTest {
    private static final String TOKEN_VALUE = "token";
    private static final String USERNAME = "authenticated-user";
    private static final String IMPERSONATE_ROLE = "ROLE_impersonate";
    private static final Instant ISSUED_AT = Instant.parse("2026-01-01T00:00:00Z");
    private static final Instant EXPIRES_AT = Instant.parse("2026-01-01T00:01:00Z");
    private static final Jwt AUTHENTICATED_JWT = Jwt.withTokenValue(TOKEN_VALUE)
            .header("alg", "none")
            .claim("preferred_username", USERNAME)
            .issuedAt(ISSUED_AT)
            .expiresAt(EXPIRES_AT)
            .build();
    private static final JwtAuthenticationToken AUTHENTICATED = new JwtAuthenticationToken(
            AUTHENTICATED_JWT,
            List.of());
    private static final JwtAuthenticationToken AUTHENTICATED_WITH_IMPERSONATION = new JwtAuthenticationToken(
            AUTHENTICATED_JWT,
            List.of(new SimpleGrantedAuthority(IMPERSONATE_ROLE)));
    private final RequestContextFactory factory = new RequestContextFactory();

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void givenEmptyUsername_thenUseAuthenticatedUsername() {
        SecurityContextHolder.getContext().setAuthentication(AUTHENTICATED);

        final RequestContext context = factory.create(Optional.empty(), Optional.empty(), Optional.empty());

        assertEquals(new RequestContext(USERNAME, null, null), context);
    }

    @Test
    void givenExplicitUsernameAndImpersonationAuthority_thenCreateContext() {
        SecurityContextHolder.getContext().setAuthentication(AUTHENTICATED_WITH_IMPERSONATION);

        final RequestContext context = factory.create(
                Optional.of("impersonated-user"),
                Optional.of("ou"),
                Optional.of("role"));

        assertEquals(new RequestContext("impersonated-user", "ou", "role"), context);
    }

    @Test
    void givenExplicitUsernameWithoutImpersonationAuthority_thenThrowForbiddenException() {
        SecurityContextHolder.getContext().setAuthentication(AUTHENTICATED);

        assertThrows(ImpersonationForbiddenException.class, () -> factory.create(
                Optional.of("impersonated-user"),
                Optional.empty(),
                Optional.empty()));
    }
}

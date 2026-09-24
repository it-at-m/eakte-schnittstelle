package de.muenchen.oss.eakte.api.v2.gateway.domain.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

class AuthUtilsTest {
    private static final String TOKEN_VALUE = "token";
    private static final String JWT_USERNAME = "jwt-user";
    private static final String BASIC_USERNAME = "basic-user";
    private static final Jwt JWT_WITHOUT_AUDIENCE = Jwt.withTokenValue(TOKEN_VALUE)
            .header("alg", "none")
            .claim("preferred_username", JWT_USERNAME)
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plusSeconds(60))
            .build();
    private static final JwtAuthenticationToken JWT_AUTHENTICATION = new JwtAuthenticationToken(
            JWT_WITHOUT_AUDIENCE,
            List.of());
    private static final UsernamePasswordAuthenticationToken BASIC_AUTHENTICATION = new UsernamePasswordAuthenticationToken(BASIC_USERNAME, null);

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void givenJwtAuthentication_thenGetUsernameFromPreferredUsernameClaim() {
        SecurityContextHolder.getContext().setAuthentication(JWT_AUTHENTICATION);

        assertEquals(JWT_USERNAME, AuthUtils.getUsername());
    }

    @Test
    void givenUsernamePasswordAuthentication_thenGetUsernameFromAuthentication() {
        SecurityContextHolder.getContext().setAuthentication(BASIC_AUTHENTICATION);

        assertEquals(BASIC_USERNAME, AuthUtils.getUsername());
    }

    @Test
    void givenNoAuthentication_thenReturnUnauthenticated() {
        assertEquals("unauthenticated", AuthUtils.getUsername());
    }

    @Test
    void givenJwtWithAudience_thenGetAudience() {
        final List<String> audience = List.of("test");
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(
                Jwt.withTokenValue(TOKEN_VALUE)
                        .header("alg", "none")
                        .claim("preferred_username", JWT_USERNAME)
                        .claim("aud", audience)
                        .issuedAt(Instant.now())
                        .expiresAt(Instant.now().plusSeconds(60))
                        .build(),
                List.of()));

        assertEquals(audience, AuthUtils.getAudience());
    }

    @Test
    void givenJwtWithoutAudience_thenReturnEmptyAudience() {
        SecurityContextHolder.getContext().setAuthentication(JWT_AUTHENTICATION);

        assertEquals(List.of(), AuthUtils.getAudience());
    }

    @Test
    void givenJwtWithMalformedAudience_thenReturnEmptyAudience() {
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(
                Jwt.withTokenValue(TOKEN_VALUE)
                        .header("alg", "none")
                        .claim("preferred_username", JWT_USERNAME)
                        .claim("aud", "local")
                        .issuedAt(Instant.now())
                        .expiresAt(Instant.now().plusSeconds(60))
                        .build(),
                List.of()));

        assertEquals(List.of(), AuthUtils.getAudience());
    }

    @Test
    void givenNoJwtAuthentication_thenReturnEmptyAudience() {
        SecurityContextHolder.getContext().setAuthentication(BASIC_AUTHENTICATION);

        assertEquals(List.of(), AuthUtils.getAudience());
    }

    @Test
    void givenImpersonationAuthority_thenCanImpersonate() {
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(
                JWT_WITHOUT_AUDIENCE,
                List.of(new SimpleGrantedAuthority("ROLE_impersonate"))));

        assertTrue(AuthUtils.canImpersonate());
    }

    @Test
    void givenNoImpersonationAuthority_thenCannotImpersonate() {
        SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(
                JWT_WITHOUT_AUDIENCE));

        assertFalse(AuthUtils.canImpersonate());
    }

}

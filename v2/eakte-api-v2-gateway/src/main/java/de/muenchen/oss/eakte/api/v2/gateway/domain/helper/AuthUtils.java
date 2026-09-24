package de.muenchen.oss.eakte.api.v2.gateway.domain.helper;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

/**
 * Utilities for authentication data.
 */
@Slf4j
public final class AuthUtils {
    private static final String NAME_UNAUTHENTICATED_USER = "unauthenticated";
    private static final String ROLE_IMPERSONATE = "ROLE_impersonate";

    private static final String USER_NAME_CLAIM = "preferred_username";
    private static final String AUD_CLAIM = "aud";

    private AuthUtils() {
    }

    /**
     * Extracts the user name from the existing Spring Security Context via
     * {@link SecurityContextHolder}.
     *
     * @return the username or an "unauthenticated" if no {@link Authentication} exists
     */
    public static String getUsername() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            return (String) jwtAuth.getTokenAttributes().get(USER_NAME_CLAIM);
        } else if (authentication instanceof UsernamePasswordAuthenticationToken usernameAuth) {
            return usernameAuth.getName();
        } else {
            return NAME_UNAUTHENTICATED_USER;
        }
    }

    /**
     * Get the audiences for which the authenticated user's JWT was issued for.
     *
     * @return The audiences. {@code []} if claim can't be found or no JWT auth.
     */
    public static List<String> getAudience() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            final Object audClaim = jwtAuth.getTokenAttributes().get(AUD_CLAIM);
            if (audClaim instanceof List<?> acL) {
                return (List<String>) acL;
            }
            if (audClaim != null) {
                log.warn("Audience claim of unexpected type '{}'. Returned []", audClaim.getClass());
            }
            return List.of();
        }
        return List.of();
    }

    /**
     * If the authenticated user is allowed to impersonate.
     *
     * @return If user is allowed to impersonate.
     */
    public static boolean canImpersonate() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> ROLE_IMPERSONATE.equals(a.getAuthority()));
    }

}

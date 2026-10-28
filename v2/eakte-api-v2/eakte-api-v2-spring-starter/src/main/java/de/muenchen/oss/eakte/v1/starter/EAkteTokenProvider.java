package de.muenchen.oss.eakte.v1.starter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

/**
 * Provides access tokens from the current Spring Security context or a Spring OAuth2 client registration.
 */
@RequiredArgsConstructor
public class EAkteTokenProvider {

    private static final String CLIENT_CREDENTIALS_PRINCIPAL = "eakte-api-v2-client";

    private final String clientRegistrationId;
    private final ObjectProvider<ClientRegistrationRepository> clientRegistrationRepositoryProvider;
    private final ObjectProvider<OAuth2AuthorizedClientService> authorizedClientServiceProvider;
    private OAuth2AuthorizedClientManager authorizedClientManager;

    /**
     * Returns the access token from the current Spring Security JWT authentication.
     *
     * @return the current JWT access token
     * @throws IllegalStateException if the current thread has no JWT authentication
     */
    public String getExistingJwtAccessToken() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            return jwtAuthenticationToken.getToken().getTokenValue();
        }
        throw new IllegalStateException("No JWT is available in the current Spring Security context");
    }

    /**
     * Returns an access token from the configured OAuth2 client-credentials registration.
     *
     * @return the client-credentials access token
     * @throws IllegalStateException if the OAuth2 client is unavailable or authorization returns no client
     */
    public String getClientCredentialsAccessToken() {
        final OAuth2AuthorizedClient authorizedClient = getAuthorizedClientManager().authorize(
                OAuth2AuthorizeRequest.withClientRegistrationId(clientRegistrationId)
                        .principal(CLIENT_CREDENTIALS_PRINCIPAL)
                        .build());
        if (authorizedClient == null) {
            throw new IllegalStateException("Could not acquire an eAkte client-credentials access token");
        }
        return authorizedClient.getAccessToken().getTokenValue();
    }

    private synchronized OAuth2AuthorizedClientManager getAuthorizedClientManager() {
        if (authorizedClientManager == null) {
            final ClientRegistrationRepository clientRegistrationRepository =
                    clientRegistrationRepositoryProvider.getIfAvailable();
            final OAuth2AuthorizedClientService authorizedClientService =
                    authorizedClientServiceProvider.getIfAvailable();
            if (clientRegistrationRepository == null || authorizedClientService == null) {
                throw new IllegalStateException("OAuth2 client credentials are not configured");
            }
            final AuthorizedClientServiceOAuth2AuthorizedClientManager manager =
                    new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                            clientRegistrationRepository, authorizedClientService);
            manager.setAuthorizedClientProvider(
                    OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build());
            authorizedClientManager = manager;
        }
        return authorizedClientManager;
    }
}

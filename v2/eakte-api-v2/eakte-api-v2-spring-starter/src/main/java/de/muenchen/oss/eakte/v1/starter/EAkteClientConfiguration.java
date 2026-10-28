package de.muenchen.oss.eakte.v1.starter;

import de.muenchen.oss.eakte.v2.generated.api.DokumentApi;
import de.muenchen.oss.eakte.v2.generated.api.EingangsdokumentApi;
import de.muenchen.oss.eakte.v2.generated.api.ErledigungApi;
import de.muenchen.oss.eakte.v2.generated.api.InternesDokumentApi;
import de.muenchen.oss.eakte.v2.generated.api.VorgangApi;
import de.muenchen.oss.eakte.v2.generated.dms.ApiClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(EAkteClientProperties.class)
public class EAkteClientConfiguration {

    private static final String CLIENT_CREDENTIALS_PRINCIPAL = "eakte-api-v2-client";

    @Bean
    @ConditionalOnProperty(prefix = "eakte.auth", name = "mode", havingValue = "client-credentials")
    protected OAuth2AuthorizedClientManager eakteAuthorizedClientManager(
            final ClientRegistrationRepository clientRegistrationRepository,
            final OAuth2AuthorizedClientService authorizedClientService) {
        final AuthorizedClientServiceOAuth2AuthorizedClientManager manager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                        clientRegistrationRepository, authorizedClientService);
        manager.setAuthorizedClientProvider(
                OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build());
        return manager;
    }

    @Bean
    protected ApiClient eakteApiClient(
            final EAkteClientProperties clientProperties,
            final ObjectProvider<OAuth2AuthorizedClientManager> authorizedClientManagerProvider) {
        final PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setDefaultConnectionConfig(ConnectionConfig.custom()
                        .setConnectTimeout(Timeout.of(clientProperties.getConnectionTimeout())).build())
                .build();
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setResponseTimeout(Timeout.of(clientProperties.getResponseTimeout()))
                        .build())
                .build();
        final RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();
        final ApiClient apiClient = new ApiClient(restClient);
        apiClient.setBasePath(clientProperties.getBaseUrl());
        if (clientProperties.getAuth().getMode() != EAkteClientProperties.AuthProperties.Mode.CUSTOM) {
            apiClient.setBearerToken(
                    () -> getAccessToken(clientProperties, authorizedClientManagerProvider));
        }
        return apiClient;
    }

    private static String getAccessToken(
            final EAkteClientProperties clientProperties,
            final ObjectProvider<OAuth2AuthorizedClientManager> authorizedClientManagerProvider) {
        final EAkteClientProperties.AuthProperties authProperties = clientProperties.getAuth();
        // client credentials
        if (authProperties.getMode() == EAkteClientProperties.AuthProperties.Mode.CLIENT_CREDENTIALS) {
            final OAuth2AuthorizedClientManager authorizedClientManager =
                    authorizedClientManagerProvider.getIfAvailable();
            if (authorizedClientManager == null) {
                throw new IllegalStateException("OAuth2 client credentials are not configured");
            }
            final OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(
                    OAuth2AuthorizeRequest.withClientRegistrationId(authProperties.getClientRegistrationId())
                            .principal(CLIENT_CREDENTIALS_PRINCIPAL)
                            .build());
            if (authorizedClient == null) {
                throw new IllegalStateException("Could not acquire an eAkte client-credentials access token");
            }
            return authorizedClient.getAccessToken().getTokenValue();
        }
        // existing JWT
        else if (authProperties.getMode() == EAkteClientProperties.AuthProperties.Mode.EXISTING_JWT) {
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
                return jwtAuthenticationToken.getToken().getTokenValue();
            }
            throw new IllegalStateException("eakte.auth.mode is existing-jwt but no JWT is available");
        }
        else if (authProperties.getMode() == EAkteClientProperties.AuthProperties.Mode.CUSTOM) {
            throw new IllegalStateException("Set the bearer token with ApiClient.setBearerToken in custom mode");
        }
        throw new IllegalStateException("eakte.auth.mode must select an authentication mode");
    }

    @Bean
    protected VorgangApi eakteVorgangApi(final ApiClient apiClient) {
        return new VorgangApi(apiClient);
    }

    @Bean
    protected DokumentApi eakteDokumentApi(final ApiClient apiClient) {
        return new DokumentApi(apiClient);
    }

    @Bean
    protected EingangsdokumentApi eakteEingangsdokumentApi(final ApiClient apiClient) {
        return new EingangsdokumentApi(apiClient);
    }

    @Bean
    protected ErledigungApi eakteErledigungApi(final ApiClient apiClient) {
        return new ErledigungApi(apiClient);
    }

    @Bean
    protected InternesDokumentApi eakteInternesDokumentApi(final ApiClient apiClient) {
        return new InternesDokumentApi(apiClient);
    }
}

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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(EAkteClientProperties.class)
public class EAkteClientConfiguration {

    @Bean
    protected ApiClient eakteApiClient(
            final EAkteClientProperties clientProperties, final EAkteTokenProvider tokenProvider) {
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
        switch (clientProperties.getAuth().getMode()) {
            case EXISTING_JWT -> apiClient.setBearerToken(tokenProvider::getExistingJwtAccessToken);
            case CLIENT_CREDENTIALS -> apiClient.setBearerToken(tokenProvider::getClientCredentialsAccessToken);
            case CUSTOM -> {}
        }
        return apiClient;
    }

    @Bean
    protected EAkteTokenProvider eakteTokenProvider(
            final EAkteClientProperties clientProperties,
            final ObjectProvider<ClientRegistrationRepository> clientRegistrationRepositoryProvider,
            final ObjectProvider<OAuth2AuthorizedClientService> authorizedClientServiceProvider) {
        return new EAkteTokenProvider(
                clientProperties.getAuth().getClientRegistrationId(),
                clientRegistrationRepositoryProvider,
                authorizedClientServiceProvider);
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

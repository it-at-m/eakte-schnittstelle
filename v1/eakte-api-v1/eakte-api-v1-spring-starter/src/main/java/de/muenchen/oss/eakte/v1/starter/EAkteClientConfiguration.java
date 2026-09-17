package de.muenchen.oss.eakte.v1.starter;

import de.muenchen.oss.eakte.v1.generated.api.*;
import de.muenchen.oss.eakte.v1.generated.dms.ApiClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(EAkteClientProperties.class)
public class EAkteClientConfiguration {
    @Bean
    protected ApiClient eakteApiClient(final EAkteClientProperties clientProperties) {
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
        apiClient.setUsername(clientProperties.getUsername());
        apiClient.setPassword(clientProperties.getPassword());
        return apiClient;
    }

    @Bean
    protected AccessDefinitionsApi eAkteAccessDefinitionsApi(final ApiClient apiClient) {
        return new AccessDefinitionsApi(apiClient);
    }

    @Bean
    protected AddAddresseesApi eAkteAddAddresseesApi(final ApiClient apiClient) {
        return new AddAddresseesApi(apiClient);
    }

    @Bean
    protected AddresseeApi eAkteAddresseeApi(final ApiClient apiClient) {
        return new AddresseeApi(apiClient);
    }

    @Bean
    protected ApentriesApi eAkteApentriesApi(final ApiClient apiClient) {
        return new ApentriesApi(apiClient);
    }

    @Bean
    protected BusinessDataValueApi eAkteBusinessDataValueApi(final ApiClient apiClient) {
        return new BusinessDataValueApi(apiClient);
    }

    @Bean
    protected CancelObjectsApi eAkteCancelObjectsApi(final ApiClient apiClient) {
        return new CancelObjectsApi(apiClient);
    }

    @Bean
    protected CompleteProcedureBusinessDataApi eAkteCompleteProcedureBusinessDataApi(
            final ApiClient apiClient) {
        return new CompleteProcedureBusinessDataApi(apiClient);
    }

    @Bean
    protected ContentObjectMetaDataApi eAkteContentObjectMetaDataApi(final ApiClient apiClient) {
        return new ContentObjectMetaDataApi(apiClient);
    }

    @Bean
    protected ContentObjectsApi eAkteContentObjectsApi(final ApiClient apiClient) {
        return new ContentObjectsApi(apiClient);
    }

    @Bean
    protected DepositObjectsApi eAkteDepositObjectsApi(final ApiClient apiClient) {
        return new DepositObjectsApi(apiClient);
    }

    @Bean
    protected DisposalScheduleDatesApi eAkteDisposalScheduleDatesApi(final ApiClient apiClient) {
        return new DisposalScheduleDatesApi(apiClient);
    }

    @Bean
    protected DocumentObjectsApi eAkteDocumentObjectsApi(final ApiClient apiClient) {
        return new DocumentObjectsApi(apiClient);
    }

    @Bean
    protected FilesApi eAkteFilesApi(final ApiClient apiClient) {
        return new FilesApi(apiClient);
    }

    @Bean
    protected IncomingFromInboxApi eAkteIncomingFromInboxApi(final ApiClient apiClient) {
        return new IncomingFromInboxApi(apiClient);
    }

    @Bean
    protected IncomingsApi eAkteIncomingsApi(final ApiClient apiClient) {
        return new IncomingsApi(apiClient);
    }

    @Bean
    protected InternalApi eAkteInternalApi(final ApiClient apiClient) {
        return new InternalApi(apiClient);
    }

    @Bean
    protected ObjectAndImportToInboxApi eAkteObjectAndImportToInboxApi(final ApiClient apiClient) {
        return new ObjectAndImportToInboxApi(apiClient);
    }

    @Bean
    protected OutgoingsApi eAkteOutgoingsApi(final ApiClient apiClient) {
        return new OutgoingsApi(apiClient);
    }

    @Bean
    protected ProcedureObjectsApi eAkteProcedureObjectsApi(final ApiClient apiClient) {
        return new ProcedureObjectsApi(apiClient);
    }

    @Bean
    protected ProceduresApi eAkteProceduresApi(final ApiClient apiClient) {
        return new ProceduresApi(apiClient);
    }

    @Bean
    protected ProceduresFromTemplateApi eAkteProceduresFromTemplateApi(final ApiClient apiClient) {
        return new ProceduresFromTemplateApi(apiClient);
    }

    @Bean
    protected ReAssignObjectApi eAkteReAssignObjectApi(final ApiClient apiClient) {
        return new ReAssignObjectApi(apiClient);
    }

    @Bean
    protected ReadDocumentObjectsMetaDataApi eAkteReadDocumentObjectsMetaDataApi(
            final ApiClient apiClient) {
        return new ReadDocumentObjectsMetaDataApi(apiClient);
    }

    @Bean
    protected ReadProcedureObjectsMetaDataApi eAkteReadProcedureObjectsMetaDataApi(
            final ApiClient apiClient) {
        return new ReadProcedureObjectsMetaDataApi(apiClient);
    }

    @Bean
    protected ReadSubjectAreaObjectsMetaDataApi eAkteReadSubjectAreaObjectsMetaDataApi(
            final ApiClient apiClient) {
        return new ReadSubjectAreaObjectsMetaDataApi(apiClient);
    }

    @Bean
    protected RevokeDepositObjectsApi eAkteRevokeDepositObjectsApi(final ApiClient apiClient) {
        return new RevokeDepositObjectsApi(apiClient);
    }

    @Bean
    protected SearchObjNamesApi eAkteSearchObjNamesApi(final ApiClient apiClient) {
        return new SearchObjNamesApi(apiClient);
    }

    @Bean
    protected SetSignatureObjectsApi eAkteSetSignatureObjectsApi(final ApiClient apiClient) {
        return new SetSignatureObjectsApi(apiClient);
    }

    @Bean
    protected StartWorkflowsApi eAkteStartWorkflowsApi(final ApiClient apiClient) {
        return new StartWorkflowsApi(apiClient);
    }

    @Bean
    protected SubjectAreaApi eAkteSubjectAreaApi(final ApiClient apiClient) {
        return new SubjectAreaApi(apiClient);
    }

    @Bean
    protected SubjectAreaFileObjectsApi eAkteSubjectAreaFileObjectsApi(
            final ApiClient apiClient) {
        return new SubjectAreaFileObjectsApi(apiClient);
    }

    @Bean
    protected SubjectAreaUnitsApi eAkteSubjectAreaUnitsApi(final ApiClient apiClient) {
        return new SubjectAreaUnitsApi(apiClient);
    }

    @Bean
    protected SubjectAreasApi eAkteSubjectAreasApi(final ApiClient apiClient) {
        return new SubjectAreasApi(apiClient);
    }

    @Bean
    protected UserFormsDataApi eAkteUserFormsDataApi(final ApiClient apiClient) {
        return new UserFormsDataApi(apiClient);
    }
}

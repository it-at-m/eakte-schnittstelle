package de.muenchen.oss.eakte.v1.starter;

import de.muenchen.oss.eakte.v1.generated.api.*;
import de.muenchen.oss.eakte.v1.generated.dms.ApiClient;
import io.netty.channel.ChannelOption;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableConfigurationProperties({EAkteClientProperties.class})
public class EAkteClientConfiguration {
    @Bean
    protected ApiClient eakteApiClient(final EAkteClientProperties clientProperties) {
        final HttpClient httpClient = HttpClient.create()
                .responseTimeout(clientProperties.getReadTimeout())
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
                        Math.toIntExact(clientProperties.getConnectionTimeout().toMillis()));
        final WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
        final ApiClient apiClient = new ApiClient(webClient);
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

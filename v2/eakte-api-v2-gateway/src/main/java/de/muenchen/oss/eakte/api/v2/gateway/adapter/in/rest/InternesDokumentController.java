package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.InternesDokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.InternesDokumentApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.InternesDokument;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.InternesDokumentListeResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@SuppressWarnings({ "PMD.UseObjectForClearerAPI", "CPD-START" })
public class InternesDokumentController implements InternesDokumentApi {
    private final RequestContextFactory requestContextFactory;
    private final InternesDokumentInPort internesDokumentInPort;
    private final InternesDokumentMapper internesDokumentMapper;

    @Override
    public ResponseEntity<InternesDokument> getInternesDokument(
            final String dokumentId,
            final @Nullable String eakteLoginName,
            final @Nullable String eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final InternesDokumentResponse result = internesDokumentInPort.get(requestContext,
                dokumentId,
                eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of())
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.of(Optional.of(internesDokumentMapper.fromDomain(result)));
    }

    @Override
    public ResponseEntity<InternesDokumentListeResponse> searchInterneDokumente(
            final @Nullable String eakteLoginName,
            final @Nullable String eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final Integer limit,
            final @Nullable String bedingungen,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of()).build();
        final List<InternesDokumentResponse> result = internesDokumentInPort.search(requestContext, request);
        final InternesDokumentListeResponse response = InternesDokumentListeResponse.builder()
                .anzahl(result.size())
                .elemente(internesDokumentMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

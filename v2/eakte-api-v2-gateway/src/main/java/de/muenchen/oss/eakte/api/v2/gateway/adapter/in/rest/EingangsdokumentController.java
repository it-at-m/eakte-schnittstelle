package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.EingangsdokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.EingangsdokumentApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Eingangsdokument;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.EingangsdokumentListeResponse;
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
public class EingangsdokumentController implements EingangsdokumentApi {
    private final RequestContextFactory requestContextFactory;
    private final EingangsdokumentInPort eingangsdokumentInPort;
    private final EingangsdokumentMapper eingangsdokumentMapper;

    @Override
    public ResponseEntity<Eingangsdokument> getEingangsdokument(
            final String eingangsdokumentId,
            final @Nullable String eakteLoginName,
            final @Nullable String eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final EingangsdokumentResponse result = eingangsdokumentInPort.get(requestContext,
                eingangsdokumentId,
                eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of())
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.of(Optional.of(eingangsdokumentMapper.fromDomain(result)));
    }

    @Override
    public ResponseEntity<EingangsdokumentListeResponse> searchEingangsdokumente(
            final @Nullable String eakteLoginName,
            final @Nullable String eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final Integer limit,
            final @Nullable String bedingungen,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        // call
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of()).build();
        final List<EingangsdokumentResponse> result = eingangsdokumentInPort.search(requestContext, request);
        // respond
        final EingangsdokumentListeResponse response = EingangsdokumentListeResponse.builder()
                .anzahl(result.size())
                .elemente(eingangsdokumentMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

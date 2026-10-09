package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.DokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.DokumentApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.DokumentListeResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("PMD.UseObjectForClearerAPI")
public class DokumentController implements DokumentApi {
    private final RequestContextFactory requestContextFactory;
    private final DokumentInPort dokumentInPort;
    private final DokumentMapper dokumentMapper;

    @Override
    public ResponseEntity<DokumentListeResponse> searchVorgangsDokumente(
            final String vorgangsId,
            final String eakteLoginName,
            final String eakteRolle,
            final String eakteOrganisationseinheit,
            final Integer limit,
            final String bedingungen,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of()).build();
        final List<DokumentResponse> result = dokumentInPort.searchBellowVorgang(requestContext, vorgangsId, request);
        // respond
        final DokumentListeResponse response = DokumentListeResponse.builder()
                .anzahl(result.size())
                .elemente(dokumentMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

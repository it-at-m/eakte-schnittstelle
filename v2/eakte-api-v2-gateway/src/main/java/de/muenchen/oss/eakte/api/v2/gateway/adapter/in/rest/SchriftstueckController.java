package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.SchriftstueckInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.SchriftstueckApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Schriftstueck;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.SchriftstueckListeResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Stelle;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@SuppressWarnings({ "PMD.UseObjectForClearerAPI" })
public class SchriftstueckController implements SchriftstueckApi {
    private final RequestContextFactory requestContextFactory;
    private final CommonMapper commonMapper;
    private final SchriftstueckInPort schriftstueckInPort;
    private final SchriftstueckMapper schriftstueckMapper;

    @Override
    public ResponseEntity<Schriftstueck> getSchriftstueck(
            final String schriftstueckId,
            @Nullable final String eakteLoginName,
            @Nullable final Stelle eakteStelle,
            @Nullable final String eakteOrganisationseinheit,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(
                eakteLoginName,
                eakteOrganisationseinheit,
                commonMapper.toDomain(eakteStelle));
        final Optional<SchriftstueckResponse> response = schriftstueckInPort.get(requestContext, schriftstueckId);
        return ResponseEntity.of(response.map(schriftstueckMapper::fromDomain));
    }

    @Override
    public ResponseEntity<SchriftstueckListeResponse> searchDokumentSchriftstuecke(
            final String dokumentId,
            @Nullable final String eakteLoginName,
            @Nullable final Stelle eakteStelle,
            @Nullable final String eakteOrganisationseinheit,
            final Integer limit,
            @Nullable final String bedingungen,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(
                eakteLoginName,
                eakteOrganisationseinheit,
                commonMapper.toDomain(eakteStelle));
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(Set.of()).build();
        final List<SchriftstueckResponse> result = schriftstueckInPort.searchBellowDokument(requestContext, dokumentId, request);
        final SchriftstueckListeResponse response = SchriftstueckListeResponse.builder()
                .anzahl(result.size())
                .elemente(schriftstueckMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

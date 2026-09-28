package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.VorgangApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.DokumentListeResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.VorgangListeResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VorgangController implements VorgangApi {
    private final VorgangInPort vorgangInPort;
    private final VorgangMapper vorgangMapper;
    private final DokumentMapper dokumentMapper;
    private final RequestContextFactory requestContextFactory;

    @Override
    public ResponseEntity<VorgangListeResponse> searchVorgaenge(
            final Optional<String> loginName,
            final Optional<String> stelle,
            final Optional<String> organisationseinheit,
            final Optional<Integer> limit,
            final Optional<String> bedingungen,
            final Optional<List<String>> eigenschaften,
            final HttpServletRequest servletRequest) {
        // call
        final RequestContext requestContext = requestContextFactory.create(loginName, organisationseinheit, stelle);
        final SearchResult result = vorgangInPort.searchVorgang(requestContext,
                limit.orElseThrow(),
                bedingungen.orElse(null),
                eigenschaften.map(HashSet::new).orElse(null));
        // respond
        final VorgangListeResponse response = VorgangListeResponse.builder()
                .anzahl(result.results().size())
                .elemente(vorgangMapper.mapResults(result.results()))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }

    @Override
    public ResponseEntity<Vorgang> getVorgang(
            final String vorgangsId,
            final Optional<String> eakteLoginName,
            final Optional<String> eakteRolle,
            final Optional<String> eakteOrganisationseinheit,
            final Optional<List<String>> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = new RequestContext(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final ResultObject result = vorgangInPort.getVorgang(requestContext,
                vorgangsId,
                eigenschaften.map(HashSet::new).orElse(null))
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.of(Optional.of(vorgangMapper.mapResult(result)));
    }

    @Override
    public ResponseEntity<DokumentListeResponse> searchVorgangsDokumente(
            final String vorgangsId,
            final Optional<String> eakteLoginName,
            final Optional<String> eakteRolle,
            final Optional<String> eakteOrganisationseinheit,
            final Optional<Integer> limit,
            final Optional<String> bedingungen,
            final Optional<List<String>> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final SearchResult result = vorgangInPort.searchVorgangsDokumente(requestContext,
                vorgangsId,
                limit.orElseThrow(),
                bedingungen.orElse(null),
                eigenschaften.map(HashSet::new).orElse(null));
        // respond
        final DokumentListeResponse response = DokumentListeResponse.builder()
                .anzahl(result.results().size())
                .elemente(dokumentMapper.mapResults(result.results()))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

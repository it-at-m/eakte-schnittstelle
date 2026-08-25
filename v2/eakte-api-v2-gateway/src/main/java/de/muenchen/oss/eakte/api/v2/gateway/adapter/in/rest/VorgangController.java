package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.controllers.VorgangApi;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.VorgangListeResponse;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
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

    @Override
    public ResponseEntity<VorgangListeResponse> sucheVorgaenge(
            final Optional<String> loginName,
            final Optional<String> stelle,
            final Optional<String> organisationseinheit,
            final Optional<String> scope,
            final Optional<String> bedingungen,
            final Optional<List<String>> eigenschaften,
            final HttpServletRequest servletRequest) {
        // call
        final RequestContext requestContext = new RequestContext(loginName, organisationseinheit, stelle);
        final SearchResult result = vorgangInPort.searchVorgang(requestContext,
                scope.orElse(null),
                bedingungen.orElseThrow(),
                eigenschaften.map(HashSet::new).orElse(null));
        // respond
        final VorgangListeResponse response = VorgangListeResponse.builder()
                .anzahl(result.results().size())
                .elemente(vorgangMapper.mapResults(result.results()))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

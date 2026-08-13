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
    public ResponseEntity<VorgangListeResponse> sucheVorgang(
            final Optional<String> fachverfahrensID,
            final Optional<String> loginName,
            final Optional<String> stelle,
            final Optional<String> organisationseinheit,
            final Optional<String> scope,
            final Optional<String> bedingungen,
            final Optional<List<String>> attributes,
            final HttpServletRequest servletRequest) {
        // call
        final RequestContext requestContext = new RequestContext(fachverfahrensID, loginName, stelle, organisationseinheit);
        final SearchResult result = vorgangInPort.searchVorgang(requestContext,
                scope.orElse(null),
                bedingungen.orElseThrow(),
                attributes.map(HashSet::new).orElse(null));
        // respond
        final VorgangListeResponse response = new VorgangListeResponse();
        response.anzahl(result.results().size());
        response.elemente(vorgangMapper.mapResults(result.results()));
        return ResponseEntity.of(Optional.of(response));
    }
}

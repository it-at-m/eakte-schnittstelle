package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.VorgangApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.VorgangListeResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings({ "PMD.UseObjectForClearerAPI", "CPD-START" })
public class VorgangController implements VorgangApi {
    private final VorgangInPort vorgangInPort;
    private final VorgangMapper vorgangMapper;
    private final RequestContextFactory requestContextFactory;

    @Override
    public ResponseEntity<VorgangListeResponse> searchVorgaenge(
            @Nullable final String eakteLoginName,
            @Nullable final String eakteRolle,
            @Nullable final String eakteOrganisationseinheit,
            final Integer limit,
            @Nullable final String bedingungen,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        // call
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of()).build();
        final List<VorgangResponse> result = vorgangInPort.search(requestContext, request);
        // respond
        final VorgangListeResponse response = VorgangListeResponse.builder()
                .anzahl(result.size())
                .elemente(vorgangMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }

    @Override
    public ResponseEntity<Vorgang> getVorgang(
            final String vorgangsId,
            @Nullable final String eakteLoginName,
            @Nullable final String eakteRolle,
            @Nullable final String eakteOrganisationseinheit,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final VorgangResponse result = vorgangInPort.get(requestContext,
                vorgangsId,
                eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of())
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.of(Optional.of(vorgangMapper.fromDomain(result)));
    }
}

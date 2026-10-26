package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.ErledigungInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.ErledigungApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Erledigung;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ErledigungListeResponse;
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
public class ErledigungController implements ErledigungApi {
    private final RequestContextFactory requestContextFactory;
    private final ErledigungInPort erledigungInPort;
    private final ErledigungMapper erledigungMapper;

    @Override
    public ResponseEntity<Erledigung> getErledigung(
            final String erledigungId,
            final @Nullable String eakteLoginName,
            final @Nullable String eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final ErledigungResponse result = erledigungInPort.get(requestContext,
                erledigungId,
                eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of())
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.of(Optional.of(erledigungMapper.fromDomain(result)));
    }

    @Override
    public ResponseEntity<ErledigungListeResponse> searchErledigung(
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
        final List<ErledigungResponse> result = erledigungInPort.search(requestContext, request);
        final ErledigungListeResponse response = ErledigungListeResponse.builder()
                .anzahl(result.size())
                .elemente(erledigungMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

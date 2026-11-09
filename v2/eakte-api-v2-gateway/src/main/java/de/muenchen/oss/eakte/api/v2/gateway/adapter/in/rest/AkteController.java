package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.AkteInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.AkteApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.AkteListeResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Rolle;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@SuppressWarnings({ "PMD.UseObjectForClearerAPI", "CPD-START" })
public class AkteController implements AkteApi {
    private final AkteInPort akteInPort;
    private final AkteMapper akteMapper;
    private final RequestContextFactory requestContextFactory;
    private final CommonMapper commonMapper;

    @Override
    public ResponseEntity<AkteListeResponse> searchAktenplaneintragAkten(
            final String aktenplaneintragId,
            final @Nullable String eakteLoginName,
            final @Nullable Rolle eakteRolle,
            final @Nullable String eakteOrganisationseinheit,
            final Integer limit,
            final @Nullable String bedingungen,
            final List<String> eigenschaften,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(
                eakteLoginName,
                eakteOrganisationseinheit,
                commonMapper.toDomain(eakteRolle));
        final SearchRequest request = SearchRequest.builder()
                .limit(limit)
                .query(bedingungen)
                .attributes(eigenschaften != null ? new HashSet<>(eigenschaften) : Set.of()).build();
        final List<AkteResponse> result = akteInPort.searchBellowAktenplan(requestContext, aktenplaneintragId, request);
        // respond
        final AkteListeResponse response = AkteListeResponse.builder()
                .anzahl(result.size())
                .elemente(akteMapper.fromDomain(result))
                .build();
        return ResponseEntity.of(Optional.of(response));
    }
}

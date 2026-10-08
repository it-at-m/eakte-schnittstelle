package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.AkteInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.AkteApi;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.CreateVorgang;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.CreateVorgangResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AkteController implements AkteApi {
    private final RequestContextFactory requestContextFactory;
    private final AkteInPort akteInPort;
    private final CreateVorgangMapper createVorgangMapper;

    @Override
    public ResponseEntity<CreateVorgangResponse> createVorgang(
            final String aktenId,
            final CreateVorgang createVorgang,
            final String eakteLoginName,
            final String eakteRolle,
            final String eakteOrganisationseinheit,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(eakteLoginName, eakteOrganisationseinheit, eakteRolle);
        final CreateVorgangRequest vorgangRequest = createVorgangMapper.toDomain(aktenId, createVorgang);
        final String vorgangId = akteInPort.createVorgang(requestContext, vorgangRequest);
        return ResponseEntity.ok(new CreateVorgangResponse(vorgangId));
    }
}

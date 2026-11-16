package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.BenutzerInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.RequestContextFactory;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.controllers.BenutzerApi;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("CPD-START")
public class BenutzerController implements BenutzerApi {
    private final RequestContextFactory requestContextFactory;
    private final BenutzerInPort userInPort;
    private final BenutzerMapper benutzerMapper;

    @Override
    public ResponseEntity<de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Benutzer> getBenutzerIch(
            @Nullable final String eakteLoginName,
            final HttpServletRequest servletRequest) {
        final RequestContext requestContext = requestContextFactory.create(
                eakteLoginName,
                null,
                null);
        final Benutzer response = userInPort.get(requestContext.impersonationUser());
        return ResponseEntity.ofNullable(benutzerMapper.fromDomain(response));
    }
}

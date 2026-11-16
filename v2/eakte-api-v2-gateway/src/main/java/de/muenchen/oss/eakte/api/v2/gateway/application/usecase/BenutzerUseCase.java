package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.BenutzerInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.BenutzerOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BenutzerUseCase implements BenutzerInPort {
    private final BenutzerOutPort benutzerOutPort;

    @Override
    public Benutzer get(final String username) {
        return benutzerOutPort.get(username);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftUserService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.BenutzerOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabasoftBenutzerAdapter implements BenutzerOutPort {
    private final FabasoftUserService userService;

    @Override
    public Benutzer get(final String username) {
        return userService.getByUsername(username);
    }
}

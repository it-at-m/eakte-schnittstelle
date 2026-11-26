package de.muenchen.oss.eakte.api.v2.gateway.application.port.in;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface BenutzerInPort {
    Benutzer get(@NotBlank String username);
}

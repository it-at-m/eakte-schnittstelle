package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import org.springframework.util.StringUtils;

public record RequestContext(
        @NotBlank String impersonationUser,
        String organisationseinheit,
        Stelle stelle) {
    @AssertTrue(message = "'organisationseinheit' and 'stelle' must both be set or both be absent") public boolean isRolleValid() {
        return StringUtils.hasText(organisationseinheit) == (stelle != null);
    }
}

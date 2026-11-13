package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import org.springframework.util.StringUtils;

public record RequestContext(
        @NotBlank String impersonationUser,
        String ou,
        Position position) {
    @AssertTrue(message = "'ou' and 'position' must both be set or both be absent") public boolean isOuRolePairValid() {
        return StringUtils.hasText(ou) == (position != null);
    }
}

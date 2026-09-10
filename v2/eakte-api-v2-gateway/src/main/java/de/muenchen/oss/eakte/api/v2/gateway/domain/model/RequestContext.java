package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import java.util.Optional;
import org.springframework.util.StringUtils;

public record RequestContext(
        @NotBlank String impersonationUser,
        String ou,
        String role) {
    public RequestContext(final Optional<String> userName,
            final Optional<String> jobOe, final Optional<String> jobPosition) {
        this(userName.orElse(null), jobOe.orElse(null), jobPosition.orElse(null));
    }

    @AssertTrue(message = "'ou' and 'role' must both be set or both be absent") public boolean isOuRolePairValid() {
        return StringUtils.hasText(ou) == StringUtils.hasText(role);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import java.util.Optional;

public record RequestContext(
        String fachverfahren,
        String userName,
        String jobOe,
        String jobPosition) {
    public RequestContext(final Optional<String> fachverfahren, final Optional<String> userName,
            final Optional<String> jobOe, final Optional<String> jobPosition) {
        this(fachverfahren.orElse(null), userName.orElse(null), jobOe.orElse(null), jobPosition.orElse(null));
    }
}

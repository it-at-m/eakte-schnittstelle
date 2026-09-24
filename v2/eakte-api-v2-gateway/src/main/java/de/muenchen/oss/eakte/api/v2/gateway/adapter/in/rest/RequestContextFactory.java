package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ImpersonationForbiddenException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AuthUtils;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Creates request contexts using the current authentication context.
 */
@Component
public class RequestContextFactory {
    /**
     * Creates a request context and validates optional impersonation.
     *
     * @param userName The optional user to impersonate.
     * @param jobOe The optional organisational unit.
     * @param jobPosition The optional role.
     * @return The request context.
     * @throws ImpersonationForbiddenException if an explicit user is requested without permission.
     */
    public RequestContext create(final Optional<String> userName,
            final Optional<String> jobOe, final Optional<String> jobPosition) {
        if (userName.isPresent() && !AuthUtils.canImpersonate()) {
            throw new ImpersonationForbiddenException();
        }
        return new RequestContext(
                userName.orElseGet(AuthUtils::getUsername),
                jobOe.orElse(null),
                jobPosition.orElse(null));
    }
}

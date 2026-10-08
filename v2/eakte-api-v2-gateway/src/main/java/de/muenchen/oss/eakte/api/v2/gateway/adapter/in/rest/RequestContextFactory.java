package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ImpersonationForbiddenException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AuthUtils;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    public RequestContext create(final String userName,
            final String jobOe, final String jobPosition) {
        final boolean usernameSet = StringUtils.hasText(userName);
        if (usernameSet && !AuthUtils.canImpersonate()) {
            throw new ImpersonationForbiddenException();
        }
        return new RequestContext(
                usernameSet ? userName : AuthUtils.getUsername(),
                jobOe,
                jobPosition);
    }
}

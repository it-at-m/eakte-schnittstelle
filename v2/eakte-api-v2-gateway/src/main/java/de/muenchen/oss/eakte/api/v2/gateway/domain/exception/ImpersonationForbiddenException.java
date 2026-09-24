package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

@SuppressWarnings("PMD.MissingSerialVersionUID")
public class ImpersonationForbiddenException extends ErrorResponseException {
    public ImpersonationForbiddenException() {
        super(HttpStatus.FORBIDDEN,
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.FORBIDDEN,
                        "You're not allowed to impersonate other users"),
                null);
    }
}

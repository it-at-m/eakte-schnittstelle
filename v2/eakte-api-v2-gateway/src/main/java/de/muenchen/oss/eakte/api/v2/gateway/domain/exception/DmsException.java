package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

import lombok.Getter;

@Getter
@SuppressWarnings("PMD.MissingSerialVersionUID")
public class DmsException extends RuntimeException {
    public DmsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

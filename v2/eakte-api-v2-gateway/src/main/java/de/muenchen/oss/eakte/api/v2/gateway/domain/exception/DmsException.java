package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

@SuppressWarnings("PMD.MissingSerialVersionUID")
public class DmsException extends RuntimeException {
    public DmsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DmsException(final String message) {
        super(message);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

@SuppressWarnings("PMD.MissingSerialVersionUID")
public class DmsTimeoutException extends DmsException {
    public DmsTimeoutException(final Throwable cause) {
        super("The request to the DMS service timed out", cause);
    }
}

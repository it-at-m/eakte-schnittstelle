package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

@SuppressWarnings("PMD.MissingSerialVersionUID")
public class BadInputException extends DmsException {
    public BadInputException(final String message) {
        super(message);
    }
}

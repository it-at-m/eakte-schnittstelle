package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

@SuppressWarnings("PMD.MissingSerialVersionUID")
public class DmsAbortException extends DmsException {
    public DmsAbortException(final String dmsTransaction, final Throwable cause) {
        super("Aborting transaction failed: %s".formatted(dmsTransaction), cause);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

import lombok.Getter;

@SuppressWarnings("PMD.MissingSerialVersionUID")
@Getter
public class DmsAbortException extends DmsException {
    private final Throwable abortCause;
    private final Throwable originalCause;

    public DmsAbortException(final String dmsTransaction, final Throwable abortCause, final Throwable originalCause) {
        super("Aborting transaction failed: %s".formatted(dmsTransaction), abortCause);
        this.abortCause = abortCause;
        this.originalCause = originalCause;
    }
}

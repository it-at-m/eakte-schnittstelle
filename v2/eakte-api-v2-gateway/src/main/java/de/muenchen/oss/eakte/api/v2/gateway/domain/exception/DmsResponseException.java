package de.muenchen.oss.eakte.api.v2.gateway.domain.exception;

import lombok.Getter;

@Getter
@SuppressWarnings("PMD.MissingSerialVersionUID")
public class DmsResponseException extends DmsException {
    private final String code;

    public DmsResponseException(final String code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
        {
                DmsResponseException.class
        }
    )
    public ErrorResponse handleDmsException(final DmsResponseException ex, final WebRequest request) {
        final HttpStatusCode statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        final ProblemDetail problemDetail = ProblemDetail.forStatus(statusCode);
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("dmsErrorReference", ex.getCode());
        return ErrorResponse.builder(ex, problemDetail).build();
    }
}

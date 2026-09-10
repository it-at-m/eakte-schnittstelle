package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsResponseException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsTimeoutException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Set<String> DMS_CODES_400 = Set.of("COOSYSTEM@1.1:COOERR_INVOBJADDR");

    @ExceptionHandler(
        {
                DmsResponseException.class
        }
    )
    public ErrorResponse handleDmsException(final DmsResponseException ex) {
        final HttpStatusCode statusCode = DMS_CODES_400.contains(ex.getCode()) ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
        final ProblemDetail problemDetail = ProblemDetail.forStatus(statusCode);
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("dmsErrorReference", ex.getCode());
        return ErrorResponse.builder(ex, problemDetail).build();
    }

    @ExceptionHandler({ DmsTimeoutException.class })
    public ErrorResponse handleDmsException(final DmsTimeoutException ex) {
        return ErrorResponse.builder(ex, ProblemDetail.forStatusAndDetail(HttpStatus.GATEWAY_TIMEOUT, ex.getMessage())).build();
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ErrorResponse handleValidationException(final ConstraintViolationException ex) {
        final ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setDetail("The request failed validation. See validationErrors for further information.");
        problemDetail.setProperty("validationErrors", ex.getConstraintViolations().stream().collect(Collectors.groupingBy(
                i -> i.getPropertyPath().toString(),
                Collectors.mapping(ConstraintViolation::getMessage, Collectors.toList()))));
        return ErrorResponse.builder(ex, problemDetail).build();
    }
}

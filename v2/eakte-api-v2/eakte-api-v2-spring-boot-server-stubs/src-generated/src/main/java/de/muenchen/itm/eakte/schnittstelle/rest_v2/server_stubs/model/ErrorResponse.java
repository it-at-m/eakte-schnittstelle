package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EAkteSchnittstelleError;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Container für RFC9457 Fehlermeldung und konkrete Fabasoft Fehlermeldung falls Ursache 
 */

@Schema(name = "ErrorResponse", description = "Container für RFC9457 Fehlermeldung und konkrete Fabasoft Fehlermeldung falls Ursache ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ErrorResponse {

  private Integer status;

  private String error;

  private Optional<String> message = Optional.empty();

  private Optional<EAkteSchnittstelleError> easError = Optional.empty();

  public ErrorResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorResponse(Integer status, String error) {
    this.status = status;
    this.error = error;
  }

  public ErrorResponse status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorResponse error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   */
  @NotNull 
  @Schema(name = "error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  @JsonProperty("error")
  public void setError(String error) {
    this.error = error;
  }

  public ErrorResponse message(String message) {
    this.message = Optional.ofNullable(message);
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public Optional<String> getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(Optional<String> message) {
    this.message = message;
  }

  public ErrorResponse easError(EAkteSchnittstelleError easError) {
    this.easError = Optional.ofNullable(easError);
    return this;
  }

  /**
   * Get easError
   * @return easError
   */
  @Valid 
  @Schema(name = "easError", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("easError")
  public Optional<EAkteSchnittstelleError> getEasError() {
    return easError;
  }

  @JsonProperty("easError")
  public void setEasError(Optional<EAkteSchnittstelleError> easError) {
    this.easError = easError;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.error, errorResponse.error) &&
        Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.easError, errorResponse.easError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, error, message, easError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    easError: ").append(toIndentedString(easError)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}


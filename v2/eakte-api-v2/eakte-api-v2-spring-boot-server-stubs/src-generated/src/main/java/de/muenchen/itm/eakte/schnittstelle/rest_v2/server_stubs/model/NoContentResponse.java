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
 * NoContentResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class NoContentResponse {

  private Boolean success;

  private Optional<EAkteSchnittstelleError> error = Optional.empty();

  public NoContentResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NoContentResponse(Boolean success) {
    this.success = success;
  }

  public NoContentResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
   */
  @NotNull 
  @Schema(name = "success", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  @JsonProperty("success")
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public NoContentResponse error(EAkteSchnittstelleError error) {
    this.error = Optional.ofNullable(error);
    return this;
  }

  /**
   * Get error
   * @return error
   */
  @Valid 
  @Schema(name = "error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public Optional<EAkteSchnittstelleError> getError() {
    return error;
  }

  @JsonProperty("error")
  public void setError(Optional<EAkteSchnittstelleError> error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NoContentResponse noContentResponse = (NoContentResponse) o;
    return Objects.equals(this.success, noContentResponse.success) &&
        Objects.equals(this.error, noContentResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NoContentResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
  
  public static class Builder {

    private NoContentResponse instance;

    public Builder() {
      this(new NoContentResponse());
    }

    protected Builder(NoContentResponse instance) {
      this.instance = instance;
    }

    protected Builder copyOf(NoContentResponse value) { 
      this.instance.setSuccess(value.success);
      this.instance.setError(value.error);
      return this;
    }

    public NoContentResponse.Builder success(Boolean success) {
      this.instance.success(success);
      return this;
    }
    
    public NoContentResponse.Builder error(EAkteSchnittstelleError error) {
      this.instance.error(error);
      return this;
    }
    
    /**
    * returns a built NoContentResponse instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public NoContentResponse build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field (except for the default values).
  */
  public static NoContentResponse.Builder builder() {
    return new NoContentResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public NoContentResponse.Builder toBuilder() {
    NoContentResponse.Builder builder = new NoContentResponse.Builder();
    return builder.copyOf(this);
  }

}


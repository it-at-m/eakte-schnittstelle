package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Akte;
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
 * AkteResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AkteResponse {

  private Boolean success;

  private Optional<EAkteSchnittstelleError> error = Optional.empty();

  private Optional<Akte> akte = Optional.empty();

  public AkteResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AkteResponse(Boolean success) {
    this.success = success;
  }

  public AkteResponse success(Boolean success) {
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

  public AkteResponse error(EAkteSchnittstelleError error) {
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

  public AkteResponse akte(Akte akte) {
    this.akte = Optional.ofNullable(akte);
    return this;
  }

  /**
   * Get akte
   * @return akte
   */
  @Valid 
  @Schema(name = "akte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("akte")
  public Optional<Akte> getAkte() {
    return akte;
  }

  @JsonProperty("akte")
  public void setAkte(Optional<Akte> akte) {
    this.akte = akte;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AkteResponse akteResponse = (AkteResponse) o;
    return Objects.equals(this.success, akteResponse.success) &&
        Objects.equals(this.error, akteResponse.error) &&
        Objects.equals(this.akte, akteResponse.akte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, error, akte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AkteResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    akte: ").append(toIndentedString(akte)).append("\n");
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

    private AkteResponse instance;

    public Builder() {
      this(new AkteResponse());
    }

    protected Builder(AkteResponse instance) {
      this.instance = instance;
    }

    protected Builder copyOf(AkteResponse value) { 
      this.instance.setSuccess(value.success);
      this.instance.setError(value.error);
      this.instance.setAkte(value.akte);
      return this;
    }

    public AkteResponse.Builder success(Boolean success) {
      this.instance.success(success);
      return this;
    }
    
    public AkteResponse.Builder error(EAkteSchnittstelleError error) {
      this.instance.error(error);
      return this;
    }
    
    public AkteResponse.Builder akte(Akte akte) {
      this.instance.akte(akte);
      return this;
    }
    
    /**
    * returns a built AkteResponse instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AkteResponse build() {
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
  public static AkteResponse.Builder builder() {
    return new AkteResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AkteResponse.Builder toBuilder() {
    AkteResponse.Builder builder = new AkteResponse.Builder();
    return builder.copyOf(this);
  }

}


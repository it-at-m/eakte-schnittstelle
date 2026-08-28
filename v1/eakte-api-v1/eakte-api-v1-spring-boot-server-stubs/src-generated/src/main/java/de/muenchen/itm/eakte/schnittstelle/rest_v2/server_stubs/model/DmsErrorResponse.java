package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DmsErrorResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class DmsErrorResponse {

  /**
   * Gets or Sets fehlerQuelle
   */
  public enum FehlerQuelleEnum {
    INTERN("INTERN"),
    
    DMS("DMS");

    private final String value;

    FehlerQuelleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FehlerQuelleEnum fromValue(String value) {
      for (FehlerQuelleEnum b : FehlerQuelleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private Optional<FehlerQuelleEnum> fehlerQuelle = Optional.empty();

  private Optional<Integer> status = Optional.empty();

  private Optional<String> text = Optional.empty();

  public DmsErrorResponse fehlerQuelle(FehlerQuelleEnum fehlerQuelle) {
    this.fehlerQuelle = Optional.ofNullable(fehlerQuelle);
    return this;
  }

  /**
   * Get fehlerQuelle
   * @return fehlerQuelle
   */
  
  @Schema(name = "fehlerQuelle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fehlerQuelle")
  public Optional<FehlerQuelleEnum> getFehlerQuelle() {
    return fehlerQuelle;
  }

  @JsonProperty("fehlerQuelle")
  public void setFehlerQuelle(Optional<FehlerQuelleEnum> fehlerQuelle) {
    this.fehlerQuelle = fehlerQuelle;
  }

  public DmsErrorResponse status(Integer status) {
    this.status = Optional.ofNullable(status);
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Optional<Integer> getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(Optional<Integer> status) {
    this.status = status;
  }

  public DmsErrorResponse text(String text) {
    this.text = Optional.ofNullable(text);
    return this;
  }

  /**
   * Get text
   * @return text
   */
  
  @Schema(name = "text", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("text")
  public Optional<String> getText() {
    return text;
  }

  @JsonProperty("text")
  public void setText(Optional<String> text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DmsErrorResponse dmsErrorResponse = (DmsErrorResponse) o;
    return Objects.equals(this.fehlerQuelle, dmsErrorResponse.fehlerQuelle) &&
        Objects.equals(this.status, dmsErrorResponse.status) &&
        Objects.equals(this.text, dmsErrorResponse.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fehlerQuelle, status, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DmsErrorResponse {\n");
    sb.append("    fehlerQuelle: ").append(toIndentedString(fehlerQuelle)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

    private DmsErrorResponse instance;

    public Builder() {
      this(new DmsErrorResponse());
    }

    protected Builder(DmsErrorResponse instance) {
      this.instance = instance;
    }

    protected Builder copyOf(DmsErrorResponse value) { 
      this.instance.setFehlerQuelle(value.fehlerQuelle);
      this.instance.setStatus(value.status);
      this.instance.setText(value.text);
      return this;
    }

    public DmsErrorResponse.Builder fehlerQuelle(FehlerQuelleEnum fehlerQuelle) {
      this.instance.fehlerQuelle(fehlerQuelle);
      return this;
    }
    
    public DmsErrorResponse.Builder status(Integer status) {
      this.instance.status(status);
      return this;
    }
    
    public DmsErrorResponse.Builder text(String text) {
      this.instance.text(text);
      return this;
    }
    
    /**
    * returns a built DmsErrorResponse instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public DmsErrorResponse build() {
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
  public static DmsErrorResponse.Builder builder() {
    return new DmsErrorResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public DmsErrorResponse.Builder toBuilder() {
    DmsErrorResponse.Builder builder = new DmsErrorResponse.Builder();
    return builder.copyOf(this);
  }

}


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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

  private String title;

  private Optional<String> instance = Optional.empty();

  private Optional<String> detail = Optional.empty();

  private Optional<String> dmsErrorReference = Optional.empty();

  public ErrorResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorResponse(Integer status, String title) {
    this.status = status;
    this.title = title;
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

  public ErrorResponse title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  public ErrorResponse instance(String instance) {
    this.instance = Optional.ofNullable(instance);
    return this;
  }

  /**
   * Get instance
   * @return instance
   */
  
  @Schema(name = "instance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instance")
  public Optional<String> getInstance() {
    return instance;
  }

  @JsonProperty("instance")
  public void setInstance(Optional<String> instance) {
    this.instance = instance;
  }

  public ErrorResponse detail(String detail) {
    this.detail = Optional.ofNullable(detail);
    return this;
  }

  /**
   * Get detail
   * @return detail
   */
  
  @Schema(name = "detail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public Optional<String> getDetail() {
    return detail;
  }

  @JsonProperty("detail")
  public void setDetail(Optional<String> detail) {
    this.detail = detail;
  }

  public ErrorResponse dmsErrorReference(String dmsErrorReference) {
    this.dmsErrorReference = Optional.ofNullable(dmsErrorReference);
    return this;
  }

  /**
   * Get dmsErrorReference
   * @return dmsErrorReference
   */
  
  @Schema(name = "dmsErrorReference", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dmsErrorReference")
  public Optional<String> getDmsErrorReference() {
    return dmsErrorReference;
  }

  @JsonProperty("dmsErrorReference")
  public void setDmsErrorReference(Optional<String> dmsErrorReference) {
    this.dmsErrorReference = dmsErrorReference;
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
        Objects.equals(this.title, errorResponse.title) &&
        Objects.equals(this.instance, errorResponse.instance) &&
        Objects.equals(this.detail, errorResponse.detail) &&
        Objects.equals(this.dmsErrorReference, errorResponse.dmsErrorReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, instance, detail, dmsErrorReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    dmsErrorReference: ").append(toIndentedString(dmsErrorReference)).append("\n");
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

    private ErrorResponse instance;

    public Builder() {
      this(new ErrorResponse());
    }

    protected Builder(ErrorResponse instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ErrorResponse value) { 
      this.instance.setStatus(value.status);
      this.instance.setTitle(value.title);
      this.instance.setInstance(value.instance);
      this.instance.setDetail(value.detail);
      this.instance.setDmsErrorReference(value.dmsErrorReference);
      return this;
    }

    public ErrorResponse.Builder status(Integer status) {
      this.instance.status(status);
      return this;
    }
    
    public ErrorResponse.Builder title(String title) {
      this.instance.title(title);
      return this;
    }
    
    public ErrorResponse.Builder instance(String instance) {
      this.instance.instance(instance);
      return this;
    }
    
    public ErrorResponse.Builder detail(String detail) {
      this.instance.detail(detail);
      return this;
    }
    
    public ErrorResponse.Builder dmsErrorReference(String dmsErrorReference) {
      this.instance.dmsErrorReference(dmsErrorReference);
      return this;
    }
    
    /**
    * returns a built ErrorResponse instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ErrorResponse build() {
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
  public static ErrorResponse.Builder builder() {
    return new ErrorResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ErrorResponse.Builder toBuilder() {
    ErrorResponse.Builder builder = new ErrorResponse.Builder();
    return builder.copyOf(this);
  }

}


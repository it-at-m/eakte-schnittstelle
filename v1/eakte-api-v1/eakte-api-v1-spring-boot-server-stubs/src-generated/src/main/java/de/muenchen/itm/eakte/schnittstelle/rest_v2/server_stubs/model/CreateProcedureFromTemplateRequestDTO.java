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
 * CreateProcedureFromTemplateRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateProcedureFromTemplateRequestDTO {

  private String referrednumber;

  private String template;

  public CreateProcedureFromTemplateRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateProcedureFromTemplateRequestDTO(String referrednumber, String template) {
    this.referrednumber = referrednumber;
    this.template = template;
  }

  public CreateProcedureFromTemplateRequestDTO referrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
    return this;
  }

  /**
   * COO-Addresse der Akte
   * @return referrednumber
   */
  @NotNull 
  @Schema(name = "referrednumber", example = "COO.1.2300.1.847", description = "COO-Addresse der Akte", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("referrednumber")
  public String getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateProcedureFromTemplateRequestDTO template(String template) {
    this.template = template;
    return this;
  }

  /**
   * COO-Addresse der Vorlage
   * @return template
   */
  @NotNull 
  @Schema(name = "template", example = "COO.1.2300.1.73641", description = "COO-Addresse der Vorlage", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("template")
  public String getTemplate() {
    return template;
  }

  @JsonProperty("template")
  public void setTemplate(String template) {
    this.template = template;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateProcedureFromTemplateRequestDTO createProcedureFromTemplateRequestDTO = (CreateProcedureFromTemplateRequestDTO) o;
    return Objects.equals(this.referrednumber, createProcedureFromTemplateRequestDTO.referrednumber) &&
        Objects.equals(this.template, createProcedureFromTemplateRequestDTO.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, template);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateProcedureFromTemplateRequestDTO {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
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

    private CreateProcedureFromTemplateRequestDTO instance;

    public Builder() {
      this(new CreateProcedureFromTemplateRequestDTO());
    }

    protected Builder(CreateProcedureFromTemplateRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateProcedureFromTemplateRequestDTO value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setTemplate(value.template);
      return this;
    }

    public CreateProcedureFromTemplateRequestDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateProcedureFromTemplateRequestDTO.Builder template(String template) {
      this.instance.template(template);
      return this;
    }
    
    /**
    * returns a built CreateProcedureFromTemplateRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateProcedureFromTemplateRequestDTO build() {
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
  public static CreateProcedureFromTemplateRequestDTO.Builder builder() {
    return new CreateProcedureFromTemplateRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateProcedureFromTemplateRequestDTO.Builder toBuilder() {
    CreateProcedureFromTemplateRequestDTO.Builder builder = new CreateProcedureFromTemplateRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


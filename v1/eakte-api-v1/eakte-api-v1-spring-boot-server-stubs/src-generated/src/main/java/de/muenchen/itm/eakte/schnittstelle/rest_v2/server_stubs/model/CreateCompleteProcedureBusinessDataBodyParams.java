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
 * Parameter, die den kompletten Vorgang spezifizieren
 */

@Schema(name = "CreateCompleteProcedureBusinessDataBodyParams", description = "Parameter, die den kompletten Vorgang spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateCompleteProcedureBusinessDataBodyParams {

  private String businessterm;

  private String businessvalue;

  private Optional<String> shortnameprocedure = Optional.empty();

  private Optional<String> shortnamedocument = Optional.empty();

  public CreateCompleteProcedureBusinessDataBodyParams() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateCompleteProcedureBusinessDataBodyParams(String businessterm, String businessvalue) {
    this.businessterm = businessterm;
    this.businessvalue = businessvalue;
  }

  public CreateCompleteProcedureBusinessDataBodyParams businessterm(String businessterm) {
    this.businessterm = businessterm;
    return this;
  }

  /**
   * COO-Adresse des Fachdatum
   * @return businessterm
   */
  @NotNull 
  @Schema(name = "businessterm", example = "COO.1.2301.1.683", description = "COO-Adresse des Fachdatum", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("businessterm")
  public String getBusinessterm() {
    return businessterm;
  }

  @JsonProperty("businessterm")
  public void setBusinessterm(String businessterm) {
    this.businessterm = businessterm;
  }

  public CreateCompleteProcedureBusinessDataBodyParams businessvalue(String businessvalue) {
    this.businessvalue = businessvalue;
    return this;
  }

  /**
   * Wert des Fachdatum
   * @return businessvalue
   */
  @NotNull 
  @Schema(name = "businessvalue", example = "78541235", description = "Wert des Fachdatum", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("businessvalue")
  public String getBusinessvalue() {
    return businessvalue;
  }

  @JsonProperty("businessvalue")
  public void setBusinessvalue(String businessvalue) {
    this.businessvalue = businessvalue;
  }

  public CreateCompleteProcedureBusinessDataBodyParams shortnameprocedure(String shortnameprocedure) {
    this.shortnameprocedure = Optional.ofNullable(shortnameprocedure);
    return this;
  }

  /**
   * Vorgangstitel
   * @return shortnameprocedure
   */
  
  @Schema(name = "shortnameprocedure", example = "2016 Anträge Firma XY", description = "Vorgangstitel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnameprocedure")
  public Optional<String> getShortnameprocedure() {
    return shortnameprocedure;
  }

  @JsonProperty("shortnameprocedure")
  public void setShortnameprocedure(Optional<String> shortnameprocedure) {
    this.shortnameprocedure = shortnameprocedure;
  }

  public CreateCompleteProcedureBusinessDataBodyParams shortnamedocument(String shortnamedocument) {
    this.shortnamedocument = Optional.ofNullable(shortnamedocument);
    return this;
  }

  /**
   * Dokumenttitel
   * @return shortnamedocument
   */
  
  @Schema(name = "shortnamedocument", example = "2016 Anträge Firma XY", description = "Dokumenttitel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnamedocument")
  public Optional<String> getShortnamedocument() {
    return shortnamedocument;
  }

  @JsonProperty("shortnamedocument")
  public void setShortnamedocument(Optional<String> shortnamedocument) {
    this.shortnamedocument = shortnamedocument;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCompleteProcedureBusinessDataBodyParams createCompleteProcedureBusinessDataBodyParams = (CreateCompleteProcedureBusinessDataBodyParams) o;
    return Objects.equals(this.businessterm, createCompleteProcedureBusinessDataBodyParams.businessterm) &&
        Objects.equals(this.businessvalue, createCompleteProcedureBusinessDataBodyParams.businessvalue) &&
        Objects.equals(this.shortnameprocedure, createCompleteProcedureBusinessDataBodyParams.shortnameprocedure) &&
        Objects.equals(this.shortnamedocument, createCompleteProcedureBusinessDataBodyParams.shortnamedocument);
  }

  @Override
  public int hashCode() {
    return Objects.hash(businessterm, businessvalue, shortnameprocedure, shortnamedocument);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCompleteProcedureBusinessDataBodyParams {\n");
    sb.append("    businessterm: ").append(toIndentedString(businessterm)).append("\n");
    sb.append("    businessvalue: ").append(toIndentedString(businessvalue)).append("\n");
    sb.append("    shortnameprocedure: ").append(toIndentedString(shortnameprocedure)).append("\n");
    sb.append("    shortnamedocument: ").append(toIndentedString(shortnamedocument)).append("\n");
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

    private CreateCompleteProcedureBusinessDataBodyParams instance;

    public Builder() {
      this(new CreateCompleteProcedureBusinessDataBodyParams());
    }

    protected Builder(CreateCompleteProcedureBusinessDataBodyParams instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCompleteProcedureBusinessDataBodyParams value) { 
      this.instance.setBusinessterm(value.businessterm);
      this.instance.setBusinessvalue(value.businessvalue);
      this.instance.setShortnameprocedure(value.shortnameprocedure);
      this.instance.setShortnamedocument(value.shortnamedocument);
      return this;
    }

    public CreateCompleteProcedureBusinessDataBodyParams.Builder businessterm(String businessterm) {
      this.instance.businessterm(businessterm);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataBodyParams.Builder businessvalue(String businessvalue) {
      this.instance.businessvalue(businessvalue);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataBodyParams.Builder shortnameprocedure(String shortnameprocedure) {
      this.instance.shortnameprocedure(shortnameprocedure);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataBodyParams.Builder shortnamedocument(String shortnamedocument) {
      this.instance.shortnamedocument(shortnamedocument);
      return this;
    }
    
    /**
    * returns a built CreateCompleteProcedureBusinessDataBodyParams instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCompleteProcedureBusinessDataBodyParams build() {
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
  public static CreateCompleteProcedureBusinessDataBodyParams.Builder builder() {
    return new CreateCompleteProcedureBusinessDataBodyParams.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCompleteProcedureBusinessDataBodyParams.Builder toBuilder() {
    CreateCompleteProcedureBusinessDataBodyParams.Builder builder = new CreateCompleteProcedureBusinessDataBodyParams.Builder();
    return builder.copyOf(this);
  }

}


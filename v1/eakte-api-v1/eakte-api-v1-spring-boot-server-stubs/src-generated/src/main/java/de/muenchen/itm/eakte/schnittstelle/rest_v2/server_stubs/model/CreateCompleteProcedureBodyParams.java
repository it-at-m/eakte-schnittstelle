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

@Schema(name = "CreateCompleteProcedureBodyParams", description = "Parameter, die den kompletten Vorgang spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateCompleteProcedureBodyParams {

  private String file;

  private Optional<String> shortnameprocedure = Optional.empty();

  private Optional<String> shortnamedocument = Optional.empty();

  public CreateCompleteProcedureBodyParams() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateCompleteProcedureBodyParams(String file) {
    this.file = file;
  }

  public CreateCompleteProcedureBodyParams file(String file) {
    this.file = file;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der Sachakte
   * @return file
   */
  @NotNull 
  @Schema(name = "file", example = "COO.1.2301.1.683", description = "Objekt-ID (COO-Adresse) der Sachakte", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("file")
  public String getFile() {
    return file;
  }

  @JsonProperty("file")
  public void setFile(String file) {
    this.file = file;
  }

  public CreateCompleteProcedureBodyParams shortnameprocedure(String shortnameprocedure) {
    this.shortnameprocedure = Optional.ofNullable(shortnameprocedure);
    return this;
  }

  /**
   * Titel
   * @return shortnameprocedure
   */
  
  @Schema(name = "shortnameprocedure", example = "2016 Anträge Firma XY", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnameprocedure")
  public Optional<String> getShortnameprocedure() {
    return shortnameprocedure;
  }

  @JsonProperty("shortnameprocedure")
  public void setShortnameprocedure(Optional<String> shortnameprocedure) {
    this.shortnameprocedure = shortnameprocedure;
  }

  public CreateCompleteProcedureBodyParams shortnamedocument(String shortnamedocument) {
    this.shortnamedocument = Optional.ofNullable(shortnamedocument);
    return this;
  }

  /**
   * Titel
   * @return shortnamedocument
   */
  
  @Schema(name = "shortnamedocument", example = "2016 Anträge Firma XY", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    CreateCompleteProcedureBodyParams createCompleteProcedureBodyParams = (CreateCompleteProcedureBodyParams) o;
    return Objects.equals(this.file, createCompleteProcedureBodyParams.file) &&
        Objects.equals(this.shortnameprocedure, createCompleteProcedureBodyParams.shortnameprocedure) &&
        Objects.equals(this.shortnamedocument, createCompleteProcedureBodyParams.shortnamedocument);
  }

  @Override
  public int hashCode() {
    return Objects.hash(file, shortnameprocedure, shortnamedocument);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCompleteProcedureBodyParams {\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
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

    private CreateCompleteProcedureBodyParams instance;

    public Builder() {
      this(new CreateCompleteProcedureBodyParams());
    }

    protected Builder(CreateCompleteProcedureBodyParams instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCompleteProcedureBodyParams value) { 
      this.instance.setFile(value.file);
      this.instance.setShortnameprocedure(value.shortnameprocedure);
      this.instance.setShortnamedocument(value.shortnamedocument);
      return this;
    }

    public CreateCompleteProcedureBodyParams.Builder file(String file) {
      this.instance.file(file);
      return this;
    }
    
    public CreateCompleteProcedureBodyParams.Builder shortnameprocedure(String shortnameprocedure) {
      this.instance.shortnameprocedure(shortnameprocedure);
      return this;
    }
    
    public CreateCompleteProcedureBodyParams.Builder shortnamedocument(String shortnamedocument) {
      this.instance.shortnamedocument(shortnamedocument);
      return this;
    }
    
    /**
    * returns a built CreateCompleteProcedureBodyParams instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCompleteProcedureBodyParams build() {
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
  public static CreateCompleteProcedureBodyParams.Builder builder() {
    return new CreateCompleteProcedureBodyParams.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCompleteProcedureBodyParams.Builder toBuilder() {
    CreateCompleteProcedureBodyParams.Builder builder = new CreateCompleteProcedureBodyParams.Builder();
    return builder.copyOf(this);
  }

}


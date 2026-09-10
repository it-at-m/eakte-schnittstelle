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
 * Parameter, die die komplette Akte beschreiben
 */

@Schema(name = "CreateCompleteFileBodyParams", description = "Parameter, die die komplette Akte beschreiben")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateCompleteFileBodyParams {

  private Optional<String> apentry = Optional.empty();

  private Optional<String> shortnamefile = Optional.empty();

  private Optional<String> shortnameprocedure = Optional.empty();

  private Optional<String> shortnamedocument = Optional.empty();

  private Optional<String> fileouobj = Optional.empty();

  public CreateCompleteFileBodyParams apentry(String apentry) {
    this.apentry = Optional.ofNullable(apentry);
    return this;
  }

  /**
   * Objekt-ID der Betreffseinheit
   * @return apentry
   */
  
  @Schema(name = "apentry", example = "COO.1.2301.1.683", description = "Objekt-ID der Betreffseinheit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("apentry")
  public Optional<String> getApentry() {
    return apentry;
  }

  @JsonProperty("apentry")
  public void setApentry(Optional<String> apentry) {
    this.apentry = apentry;
  }

  public CreateCompleteFileBodyParams shortnamefile(String shortnamefile) {
    this.shortnamefile = Optional.ofNullable(shortnamefile);
    return this;
  }

  /**
   * Titel der Akte
   * @return shortnamefile
   */
  
  @Schema(name = "shortnamefile", example = "2016 Anträge Firma XY", description = "Titel der Akte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnamefile")
  public Optional<String> getShortnamefile() {
    return shortnamefile;
  }

  @JsonProperty("shortnamefile")
  public void setShortnamefile(Optional<String> shortnamefile) {
    this.shortnamefile = shortnamefile;
  }

  public CreateCompleteFileBodyParams shortnameprocedure(String shortnameprocedure) {
    this.shortnameprocedure = Optional.ofNullable(shortnameprocedure);
    return this;
  }

  /**
   * Titel des Vorgangs
   * @return shortnameprocedure
   */
  
  @Schema(name = "shortnameprocedure", example = "Bauantrag Seestraße", description = "Titel des Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnameprocedure")
  public Optional<String> getShortnameprocedure() {
    return shortnameprocedure;
  }

  @JsonProperty("shortnameprocedure")
  public void setShortnameprocedure(Optional<String> shortnameprocedure) {
    this.shortnameprocedure = shortnameprocedure;
  }

  public CreateCompleteFileBodyParams shortnamedocument(String shortnamedocument) {
    this.shortnamedocument = Optional.ofNullable(shortnamedocument);
    return this;
  }

  /**
   * Titel des Dokuments
   * @return shortnamedocument
   */
  
  @Schema(name = "shortnamedocument", example = "Antragsformular mit Anlagen", description = "Titel des Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortnamedocument")
  public Optional<String> getShortnamedocument() {
    return shortnamedocument;
  }

  @JsonProperty("shortnamedocument")
  public void setShortnamedocument(Optional<String> shortnamedocument) {
    this.shortnamedocument = shortnamedocument;
  }

  public CreateCompleteFileBodyParams fileouobj(String fileouobj) {
    this.fileouobj = Optional.ofNullable(fileouobj);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der aktenführenden Organisationseinheit.<br> Als Organisationseinheit der Akte wird die Organisationseinheit des darüber liegenden Aktenplankennzeichens gesetzt.<br> Sofern keine Organisationseinheit auf dem Aktenplankennzeichen definiert ist, wird die Organisationseinheit der ersten Rolle des Benutzers verwendet. 
   * @return fileouobj
   */
  
  @Schema(name = "fileouobj", example = "COO.1.2300.1.847", description = "Objekt-ID (COO-Adresse) der aktenführenden Organisationseinheit.<br> Als Organisationseinheit der Akte wird die Organisationseinheit des darüber liegenden Aktenplankennzeichens gesetzt.<br> Sofern keine Organisationseinheit auf dem Aktenplankennzeichen definiert ist, wird die Organisationseinheit der ersten Rolle des Benutzers verwendet. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileouobj")
  public Optional<String> getFileouobj() {
    return fileouobj;
  }

  @JsonProperty("fileouobj")
  public void setFileouobj(Optional<String> fileouobj) {
    this.fileouobj = fileouobj;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCompleteFileBodyParams createCompleteFileBodyParams = (CreateCompleteFileBodyParams) o;
    return Objects.equals(this.apentry, createCompleteFileBodyParams.apentry) &&
        Objects.equals(this.shortnamefile, createCompleteFileBodyParams.shortnamefile) &&
        Objects.equals(this.shortnameprocedure, createCompleteFileBodyParams.shortnameprocedure) &&
        Objects.equals(this.shortnamedocument, createCompleteFileBodyParams.shortnamedocument) &&
        Objects.equals(this.fileouobj, createCompleteFileBodyParams.fileouobj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apentry, shortnamefile, shortnameprocedure, shortnamedocument, fileouobj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCompleteFileBodyParams {\n");
    sb.append("    apentry: ").append(toIndentedString(apentry)).append("\n");
    sb.append("    shortnamefile: ").append(toIndentedString(shortnamefile)).append("\n");
    sb.append("    shortnameprocedure: ").append(toIndentedString(shortnameprocedure)).append("\n");
    sb.append("    shortnamedocument: ").append(toIndentedString(shortnamedocument)).append("\n");
    sb.append("    fileouobj: ").append(toIndentedString(fileouobj)).append("\n");
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

    private CreateCompleteFileBodyParams instance;

    public Builder() {
      this(new CreateCompleteFileBodyParams());
    }

    protected Builder(CreateCompleteFileBodyParams instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCompleteFileBodyParams value) { 
      this.instance.setApentry(value.apentry);
      this.instance.setShortnamefile(value.shortnamefile);
      this.instance.setShortnameprocedure(value.shortnameprocedure);
      this.instance.setShortnamedocument(value.shortnamedocument);
      this.instance.setFileouobj(value.fileouobj);
      return this;
    }

    public CreateCompleteFileBodyParams.Builder apentry(String apentry) {
      this.instance.apentry(apentry);
      return this;
    }
    
    public CreateCompleteFileBodyParams.Builder shortnamefile(String shortnamefile) {
      this.instance.shortnamefile(shortnamefile);
      return this;
    }
    
    public CreateCompleteFileBodyParams.Builder shortnameprocedure(String shortnameprocedure) {
      this.instance.shortnameprocedure(shortnameprocedure);
      return this;
    }
    
    public CreateCompleteFileBodyParams.Builder shortnamedocument(String shortnamedocument) {
      this.instance.shortnamedocument(shortnamedocument);
      return this;
    }
    
    public CreateCompleteFileBodyParams.Builder fileouobj(String fileouobj) {
      this.instance.fileouobj(fileouobj);
      return this;
    }
    
    /**
    * returns a built CreateCompleteFileBodyParams instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCompleteFileBodyParams build() {
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
  public static CreateCompleteFileBodyParams.Builder builder() {
    return new CreateCompleteFileBodyParams.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCompleteFileBodyParams.Builder toBuilder() {
    CreateCompleteFileBodyParams.Builder builder = new CreateCompleteFileBodyParams.Builder();
    return builder.copyOf(this);
  }

}


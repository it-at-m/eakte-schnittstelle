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
 * CreateCompleteFileResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateCompleteFileResponseDTO {

  private Optional<String> objidfile = Optional.empty();

  private Optional<String> objnamefile = Optional.empty();

  private Optional<String> objidprocedure = Optional.empty();

  private Optional<String> objnameprocedure = Optional.empty();

  private Optional<String> objiddocument = Optional.empty();

  private Optional<String> objnamedocument = Optional.empty();

  private Optional<String> objidcontent = Optional.empty();

  private Optional<String> objnamecontent = Optional.empty();

  public CreateCompleteFileResponseDTO objidfile(String objidfile) {
    this.objidfile = Optional.ofNullable(objidfile);
    return this;
  }

  /**
   * Objekt-ID der erzeugten/gefundenen Sachakte
   * @return objidfile
   */
  
  @Schema(name = "objidfile", example = "COO.1.2301.1.1042406", description = "Objekt-ID der erzeugten/gefundenen Sachakte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objidfile")
  public Optional<String> getObjidfile() {
    return objidfile;
  }

  @JsonProperty("objidfile")
  public void setObjidfile(Optional<String> objidfile) {
    this.objidfile = objidfile;
  }

  public CreateCompleteFileResponseDTO objnamefile(String objnamefile) {
    this.objnamefile = Optional.ofNullable(objnamefile);
    return this;
  }

  /**
   * Objektname der erzeugten/gefundenen Sachakte
   * @return objnamefile
   */
  
  @Schema(name = "objnamefile", example = "0010 A20 011-2016 Anträge Firma XY-4", description = "Objektname der erzeugten/gefundenen Sachakte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnamefile")
  public Optional<String> getObjnamefile() {
    return objnamefile;
  }

  @JsonProperty("objnamefile")
  public void setObjnamefile(Optional<String> objnamefile) {
    this.objnamefile = objnamefile;
  }

  public CreateCompleteFileResponseDTO objidprocedure(String objidprocedure) {
    this.objidprocedure = Optional.ofNullable(objidprocedure);
    return this;
  }

  /**
   * Objekt-ID des erzeugten/gefundenen Vorgangs
   * @return objidprocedure
   */
  
  @Schema(name = "objidprocedure", example = "COO.1.2301.1.1042406", description = "Objekt-ID des erzeugten/gefundenen Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objidprocedure")
  public Optional<String> getObjidprocedure() {
    return objidprocedure;
  }

  @JsonProperty("objidprocedure")
  public void setObjidprocedure(Optional<String> objidprocedure) {
    this.objidprocedure = objidprocedure;
  }

  public CreateCompleteFileResponseDTO objnameprocedure(String objnameprocedure) {
    this.objnameprocedure = Optional.ofNullable(objnameprocedure);
    return this;
  }

  /**
   * Objektname des erzeugten/gefundenen Vorgangs
   * @return objnameprocedure
   */
  
  @Schema(name = "objnameprocedure", example = "0010 A20 011-2016 Anträge Firma XY-4", description = "Objektname des erzeugten/gefundenen Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnameprocedure")
  public Optional<String> getObjnameprocedure() {
    return objnameprocedure;
  }

  @JsonProperty("objnameprocedure")
  public void setObjnameprocedure(Optional<String> objnameprocedure) {
    this.objnameprocedure = objnameprocedure;
  }

  public CreateCompleteFileResponseDTO objiddocument(String objiddocument) {
    this.objiddocument = Optional.ofNullable(objiddocument);
    return this;
  }

  /**
   * Objekt-ID des erzeugten/gefundenen Dokuments
   * @return objiddocument
   */
  
  @Schema(name = "objiddocument", example = "COO.1.2301.1.1042406", description = "Objekt-ID des erzeugten/gefundenen Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objiddocument")
  public Optional<String> getObjiddocument() {
    return objiddocument;
  }

  @JsonProperty("objiddocument")
  public void setObjiddocument(Optional<String> objiddocument) {
    this.objiddocument = objiddocument;
  }

  public CreateCompleteFileResponseDTO objnamedocument(String objnamedocument) {
    this.objnamedocument = Optional.ofNullable(objnamedocument);
    return this;
  }

  /**
   * Objektname des erzeugten/gefundenen Dokuments
   * @return objnamedocument
   */
  
  @Schema(name = "objnamedocument", example = "0010 A20 011-2016 Anträge Firma XY-4", description = "Objektname des erzeugten/gefundenen Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnamedocument")
  public Optional<String> getObjnamedocument() {
    return objnamedocument;
  }

  @JsonProperty("objnamedocument")
  public void setObjnamedocument(Optional<String> objnamedocument) {
    this.objnamedocument = objnamedocument;
  }

  public CreateCompleteFileResponseDTO objidcontent(String objidcontent) {
    this.objidcontent = Optional.ofNullable(objidcontent);
    return this;
  }

  /**
   * Objekt-ID des erzeugten/gefundenen Schriftstücks
   * @return objidcontent
   */
  
  @Schema(name = "objidcontent", example = "COO.1.2301.1.1042406", description = "Objekt-ID des erzeugten/gefundenen Schriftstücks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objidcontent")
  public Optional<String> getObjidcontent() {
    return objidcontent;
  }

  @JsonProperty("objidcontent")
  public void setObjidcontent(Optional<String> objidcontent) {
    this.objidcontent = objidcontent;
  }

  public CreateCompleteFileResponseDTO objnamecontent(String objnamecontent) {
    this.objnamecontent = Optional.ofNullable(objnamecontent);
    return this;
  }

  /**
   * Objektname des erzeugten/gefundenen Schriftstücks
   * @return objnamecontent
   */
  
  @Schema(name = "objnamecontent", example = "0010 A20 011-2016 Anträge Firma XY-4", description = "Objektname des erzeugten/gefundenen Schriftstücks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnamecontent")
  public Optional<String> getObjnamecontent() {
    return objnamecontent;
  }

  @JsonProperty("objnamecontent")
  public void setObjnamecontent(Optional<String> objnamecontent) {
    this.objnamecontent = objnamecontent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCompleteFileResponseDTO createCompleteFileResponseDTO = (CreateCompleteFileResponseDTO) o;
    return Objects.equals(this.objidfile, createCompleteFileResponseDTO.objidfile) &&
        Objects.equals(this.objnamefile, createCompleteFileResponseDTO.objnamefile) &&
        Objects.equals(this.objidprocedure, createCompleteFileResponseDTO.objidprocedure) &&
        Objects.equals(this.objnameprocedure, createCompleteFileResponseDTO.objnameprocedure) &&
        Objects.equals(this.objiddocument, createCompleteFileResponseDTO.objiddocument) &&
        Objects.equals(this.objnamedocument, createCompleteFileResponseDTO.objnamedocument) &&
        Objects.equals(this.objidcontent, createCompleteFileResponseDTO.objidcontent) &&
        Objects.equals(this.objnamecontent, createCompleteFileResponseDTO.objnamecontent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objidfile, objnamefile, objidprocedure, objnameprocedure, objiddocument, objnamedocument, objidcontent, objnamecontent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCompleteFileResponseDTO {\n");
    sb.append("    objidfile: ").append(toIndentedString(objidfile)).append("\n");
    sb.append("    objnamefile: ").append(toIndentedString(objnamefile)).append("\n");
    sb.append("    objidprocedure: ").append(toIndentedString(objidprocedure)).append("\n");
    sb.append("    objnameprocedure: ").append(toIndentedString(objnameprocedure)).append("\n");
    sb.append("    objiddocument: ").append(toIndentedString(objiddocument)).append("\n");
    sb.append("    objnamedocument: ").append(toIndentedString(objnamedocument)).append("\n");
    sb.append("    objidcontent: ").append(toIndentedString(objidcontent)).append("\n");
    sb.append("    objnamecontent: ").append(toIndentedString(objnamecontent)).append("\n");
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

    private CreateCompleteFileResponseDTO instance;

    public Builder() {
      this(new CreateCompleteFileResponseDTO());
    }

    protected Builder(CreateCompleteFileResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCompleteFileResponseDTO value) { 
      this.instance.setObjidfile(value.objidfile);
      this.instance.setObjnamefile(value.objnamefile);
      this.instance.setObjidprocedure(value.objidprocedure);
      this.instance.setObjnameprocedure(value.objnameprocedure);
      this.instance.setObjiddocument(value.objiddocument);
      this.instance.setObjnamedocument(value.objnamedocument);
      this.instance.setObjidcontent(value.objidcontent);
      this.instance.setObjnamecontent(value.objnamecontent);
      return this;
    }

    public CreateCompleteFileResponseDTO.Builder objidfile(String objidfile) {
      this.instance.objidfile(objidfile);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objnamefile(String objnamefile) {
      this.instance.objnamefile(objnamefile);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objidprocedure(String objidprocedure) {
      this.instance.objidprocedure(objidprocedure);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objnameprocedure(String objnameprocedure) {
      this.instance.objnameprocedure(objnameprocedure);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objiddocument(String objiddocument) {
      this.instance.objiddocument(objiddocument);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objnamedocument(String objnamedocument) {
      this.instance.objnamedocument(objnamedocument);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objidcontent(String objidcontent) {
      this.instance.objidcontent(objidcontent);
      return this;
    }
    
    public CreateCompleteFileResponseDTO.Builder objnamecontent(String objnamecontent) {
      this.instance.objnamecontent(objnamecontent);
      return this;
    }
    
    /**
    * returns a built CreateCompleteFileResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCompleteFileResponseDTO build() {
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
  public static CreateCompleteFileResponseDTO.Builder builder() {
    return new CreateCompleteFileResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCompleteFileResponseDTO.Builder toBuilder() {
    CreateCompleteFileResponseDTO.Builder builder = new CreateCompleteFileResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


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
 * CreateCompleteProcedureBusinessDataResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateCompleteProcedureBusinessDataResponseDTO {

  private Optional<String> objidprocedure = Optional.empty();

  private Optional<String> objnameprocedure = Optional.empty();

  private Optional<String> objiddocument = Optional.empty();

  private Optional<String> objnamedocument = Optional.empty();

  private Optional<String> objidcontent = Optional.empty();

  private Optional<String> objnamecontent = Optional.empty();

  public CreateCompleteProcedureBusinessDataResponseDTO objidprocedure(String objidprocedure) {
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

  public CreateCompleteProcedureBusinessDataResponseDTO objnameprocedure(String objnameprocedure) {
    this.objnameprocedure = Optional.ofNullable(objnameprocedure);
    return this;
  }

  /**
   * Objektname des erzeugten/gefundenen Vorgangs\\ Der Name wird in der eAkte gebildet aus dem \"Titel des Vorgangs\"  (\"Aktenplankennzeichen des Aktenplankennzeichens, in dem die Akte liegt\"- \"laufende Nummer der Akte innerhalb des Aktenplaneintrags\"- laufende Nummer des Vorgangs innerhalb des Akte\") 
   * @return objnameprocedure
   */
  
  @Schema(name = "objnameprocedure", example = "2026-05-28 Anträge Firma XY-4 (2002-10-0004)", description = "Objektname des erzeugten/gefundenen Vorgangs\\ Der Name wird in der eAkte gebildet aus dem \"Titel des Vorgangs\"  (\"Aktenplankennzeichen des Aktenplankennzeichens, in dem die Akte liegt\"- \"laufende Nummer der Akte innerhalb des Aktenplaneintrags\"- laufende Nummer des Vorgangs innerhalb des Akte\") ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnameprocedure")
  public Optional<String> getObjnameprocedure() {
    return objnameprocedure;
  }

  @JsonProperty("objnameprocedure")
  public void setObjnameprocedure(Optional<String> objnameprocedure) {
    this.objnameprocedure = objnameprocedure;
  }

  public CreateCompleteProcedureBusinessDataResponseDTO objiddocument(String objiddocument) {
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

  public CreateCompleteProcedureBusinessDataResponseDTO objnamedocument(String objnamedocument) {
    this.objnamedocument = Optional.ofNullable(objnamedocument);
    return this;
  }

  /**
   * Objektname des erzeugten/gefundenen Dokuments
   * @return objnamedocument
   */
  
  @Schema(name = "objnamedocument", example = "0010 A20 011-2016 Anträge Frima XY-4", description = "Objektname des erzeugten/gefundenen Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objnamedocument")
  public Optional<String> getObjnamedocument() {
    return objnamedocument;
  }

  @JsonProperty("objnamedocument")
  public void setObjnamedocument(Optional<String> objnamedocument) {
    this.objnamedocument = objnamedocument;
  }

  public CreateCompleteProcedureBusinessDataResponseDTO objidcontent(String objidcontent) {
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

  public CreateCompleteProcedureBusinessDataResponseDTO objnamecontent(String objnamecontent) {
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
    CreateCompleteProcedureBusinessDataResponseDTO createCompleteProcedureBusinessDataResponseDTO = (CreateCompleteProcedureBusinessDataResponseDTO) o;
    return Objects.equals(this.objidprocedure, createCompleteProcedureBusinessDataResponseDTO.objidprocedure) &&
        Objects.equals(this.objnameprocedure, createCompleteProcedureBusinessDataResponseDTO.objnameprocedure) &&
        Objects.equals(this.objiddocument, createCompleteProcedureBusinessDataResponseDTO.objiddocument) &&
        Objects.equals(this.objnamedocument, createCompleteProcedureBusinessDataResponseDTO.objnamedocument) &&
        Objects.equals(this.objidcontent, createCompleteProcedureBusinessDataResponseDTO.objidcontent) &&
        Objects.equals(this.objnamecontent, createCompleteProcedureBusinessDataResponseDTO.objnamecontent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objidprocedure, objnameprocedure, objiddocument, objnamedocument, objidcontent, objnamecontent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCompleteProcedureBusinessDataResponseDTO {\n");
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

    private CreateCompleteProcedureBusinessDataResponseDTO instance;

    public Builder() {
      this(new CreateCompleteProcedureBusinessDataResponseDTO());
    }

    protected Builder(CreateCompleteProcedureBusinessDataResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCompleteProcedureBusinessDataResponseDTO value) { 
      this.instance.setObjidprocedure(value.objidprocedure);
      this.instance.setObjnameprocedure(value.objnameprocedure);
      this.instance.setObjiddocument(value.objiddocument);
      this.instance.setObjnamedocument(value.objnamedocument);
      this.instance.setObjidcontent(value.objidcontent);
      this.instance.setObjnamecontent(value.objnamecontent);
      return this;
    }

    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objidprocedure(String objidprocedure) {
      this.instance.objidprocedure(objidprocedure);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objnameprocedure(String objnameprocedure) {
      this.instance.objnameprocedure(objnameprocedure);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objiddocument(String objiddocument) {
      this.instance.objiddocument(objiddocument);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objnamedocument(String objnamedocument) {
      this.instance.objnamedocument(objnamedocument);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objidcontent(String objidcontent) {
      this.instance.objidcontent(objidcontent);
      return this;
    }
    
    public CreateCompleteProcedureBusinessDataResponseDTO.Builder objnamecontent(String objnamecontent) {
      this.instance.objnamecontent(objnamecontent);
      return this;
    }
    
    /**
    * returns a built CreateCompleteProcedureBusinessDataResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCompleteProcedureBusinessDataResponseDTO build() {
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
  public static CreateCompleteProcedureBusinessDataResponseDTO.Builder builder() {
    return new CreateCompleteProcedureBusinessDataResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCompleteProcedureBusinessDataResponseDTO.Builder toBuilder() {
    CreateCompleteProcedureBusinessDataResponseDTO.Builder builder = new CreateCompleteProcedureBusinessDataResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


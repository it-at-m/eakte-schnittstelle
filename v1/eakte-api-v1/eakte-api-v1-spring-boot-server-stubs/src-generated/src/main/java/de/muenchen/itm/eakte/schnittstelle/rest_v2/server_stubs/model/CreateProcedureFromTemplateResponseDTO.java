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
 * CreateProcedureFromTemplateResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateProcedureFromTemplateResponseDTO {

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  public CreateProcedureFromTemplateResponseDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Objekt-ID des erzeugten Vorgangs
   * @return objid
   */
  
  @Schema(name = "objid", example = "COO.1.2301.1.1042432", description = "Objekt-ID des erzeugten Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public CreateProcedureFromTemplateResponseDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Name des erzeugten Vorgangs
   * @return objname
   */
  
  @Schema(name = "objname", example = "2016 Anträge Firma XY", description = "Name des erzeugten Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateProcedureFromTemplateResponseDTO createProcedureFromTemplateResponseDTO = (CreateProcedureFromTemplateResponseDTO) o;
    return Objects.equals(this.objid, createProcedureFromTemplateResponseDTO.objid) &&
        Objects.equals(this.objname, createProcedureFromTemplateResponseDTO.objname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid, objname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateProcedureFromTemplateResponseDTO {\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
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

    private CreateProcedureFromTemplateResponseDTO instance;

    public Builder() {
      this(new CreateProcedureFromTemplateResponseDTO());
    }

    protected Builder(CreateProcedureFromTemplateResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateProcedureFromTemplateResponseDTO value) { 
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      return this;
    }

    public CreateProcedureFromTemplateResponseDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public CreateProcedureFromTemplateResponseDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    /**
    * returns a built CreateProcedureFromTemplateResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateProcedureFromTemplateResponseDTO build() {
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
  public static CreateProcedureFromTemplateResponseDTO.Builder builder() {
    return new CreateProcedureFromTemplateResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateProcedureFromTemplateResponseDTO.Builder toBuilder() {
    CreateProcedureFromTemplateResponseDTO.Builder builder = new CreateProcedureFromTemplateResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


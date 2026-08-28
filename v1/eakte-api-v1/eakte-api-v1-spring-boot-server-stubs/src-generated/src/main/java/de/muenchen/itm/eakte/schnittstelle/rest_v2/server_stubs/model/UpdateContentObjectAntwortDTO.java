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
 * UpdateContentObjectAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateContentObjectAntwortDTO {

  private Optional<String> contentobjid = Optional.empty();

  private Optional<String> contentobjname = Optional.empty();

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  public UpdateContentObjectAntwortDTO contentobjid(String contentobjid) {
    this.contentobjid = Optional.ofNullable(contentobjid);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des ersetzten Schriftstücks
   * @return contentobjid
   */
  
  @Schema(name = "contentobjid", example = "COO.1.2301.1.1042466", description = "Objekt-ID (COO-Adresse) des ersetzten Schriftstücks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentobjid")
  public Optional<String> getContentobjid() {
    return contentobjid;
  }

  @JsonProperty("contentobjid")
  public void setContentobjid(Optional<String> contentobjid) {
    this.contentobjid = contentobjid;
  }

  public UpdateContentObjectAntwortDTO contentobjname(String contentobjname) {
    this.contentobjname = Optional.ofNullable(contentobjname);
    return this;
  }

  /**
   * Objektname des ersetzten Schriftstücks
   * @return contentobjname
   */
  
  @Schema(name = "contentobjname", example = "LHM Schreiben Extern vom 11.11.2016 v101", description = "Objektname des ersetzten Schriftstücks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentobjname")
  public Optional<String> getContentobjname() {
    return contentobjname;
  }

  @JsonProperty("contentobjname")
  public void setContentobjname(Optional<String> contentobjname) {
    this.contentobjname = contentobjname;
  }

  public UpdateContentObjectAntwortDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Zugehöriges Dokument, Objekt-ID (COO-Adresse) des Dokuments, in dem das Schriftstück ersetzt worden ist. 
   * @return objid
   */
  
  @Schema(name = "objid", example = "COO.1.2301.1.1042465", description = "Zugehöriges Dokument, Objekt-ID (COO-Adresse) des Dokuments, in dem das Schriftstück ersetzt worden ist. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public UpdateContentObjectAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Objektname des Schriftgutobjekts (COOSYSTEM@1.1:objname) 
   * @return objname
   */
  
  @Schema(name = "objname", example = "Ausgangsschreiben zum Antrag auf Baugenehmigung Firma Mustermann (0010 A20 011-4-0006-0006)", description = "Objektname des Schriftgutobjekts (COOSYSTEM@1.1:objname) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UpdateContentObjectAntwortDTO updateContentObjectAntwortDTO = (UpdateContentObjectAntwortDTO) o;
    return Objects.equals(this.contentobjid, updateContentObjectAntwortDTO.contentobjid) &&
        Objects.equals(this.contentobjname, updateContentObjectAntwortDTO.contentobjname) &&
        Objects.equals(this.objid, updateContentObjectAntwortDTO.objid) &&
        Objects.equals(this.objname, updateContentObjectAntwortDTO.objname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentobjid, contentobjname, objid, objname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateContentObjectAntwortDTO {\n");
    sb.append("    contentobjid: ").append(toIndentedString(contentobjid)).append("\n");
    sb.append("    contentobjname: ").append(toIndentedString(contentobjname)).append("\n");
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

    private UpdateContentObjectAntwortDTO instance;

    public Builder() {
      this(new UpdateContentObjectAntwortDTO());
    }

    protected Builder(UpdateContentObjectAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateContentObjectAntwortDTO value) { 
      this.instance.setContentobjid(value.contentobjid);
      this.instance.setContentobjname(value.contentobjname);
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      return this;
    }

    public UpdateContentObjectAntwortDTO.Builder contentobjid(String contentobjid) {
      this.instance.contentobjid(contentobjid);
      return this;
    }
    
    public UpdateContentObjectAntwortDTO.Builder contentobjname(String contentobjname) {
      this.instance.contentobjname(contentobjname);
      return this;
    }
    
    public UpdateContentObjectAntwortDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public UpdateContentObjectAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    /**
    * returns a built UpdateContentObjectAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateContentObjectAntwortDTO build() {
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
  public static UpdateContentObjectAntwortDTO.Builder builder() {
    return new UpdateContentObjectAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateContentObjectAntwortDTO.Builder toBuilder() {
    UpdateContentObjectAntwortDTO.Builder builder = new UpdateContentObjectAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


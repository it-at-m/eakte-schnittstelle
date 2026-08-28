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
 * SetDisposalScheduleDateAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SetDisposalScheduleDateAntwortDTO {

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  public SetDisposalScheduleDateAntwortDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Objekts
   * @return objid
   */
  
  @Schema(name = "objid", example = "COO.1.2301.1.1042441", description = "Objekt-ID (COO-Adresse) des Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public SetDisposalScheduleDateAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Objektname des Objekts
   * @return objname
   */
  
  @Schema(name = "objname", example = "Eingangspost vom 21.10.2016 (0010 A20 011-4-0006-0001)", description = "Objektname des Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    SetDisposalScheduleDateAntwortDTO setDisposalScheduleDateAntwortDTO = (SetDisposalScheduleDateAntwortDTO) o;
    return Objects.equals(this.objid, setDisposalScheduleDateAntwortDTO.objid) &&
        Objects.equals(this.objname, setDisposalScheduleDateAntwortDTO.objname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid, objname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetDisposalScheduleDateAntwortDTO {\n");
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

    private SetDisposalScheduleDateAntwortDTO instance;

    public Builder() {
      this(new SetDisposalScheduleDateAntwortDTO());
    }

    protected Builder(SetDisposalScheduleDateAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SetDisposalScheduleDateAntwortDTO value) { 
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      return this;
    }

    public SetDisposalScheduleDateAntwortDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public SetDisposalScheduleDateAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    /**
    * returns a built SetDisposalScheduleDateAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SetDisposalScheduleDateAntwortDTO build() {
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
  public static SetDisposalScheduleDateAntwortDTO.Builder builder() {
    return new SetDisposalScheduleDateAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SetDisposalScheduleDateAntwortDTO.Builder toBuilder() {
    SetDisposalScheduleDateAntwortDTO.Builder builder = new SetDisposalScheduleDateAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


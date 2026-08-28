package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Objektreferenz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateIncomingAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateIncomingAntwortDTO {

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  @Valid
  private List<@Valid Objektreferenz> giobjecttype = new ArrayList<>();

  public CreateIncomingAntwortDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des erzeugten Objekts
   * @return objid
   */
  
  @Schema(name = "objid", description = "Objekt-ID (COO-Adresse) des erzeugten Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public CreateIncomingAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Objektname des erzeugten Objekts
   * @return objname
   */
  
  @Schema(name = "objname", description = "Objektname des erzeugten Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public CreateIncomingAntwortDTO giobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
    return this;
  }

  public CreateIncomingAntwortDTO addGiobjecttypeItem(Objektreferenz giobjecttypeItem) {
    if (this.giobjecttype == null) {
      this.giobjecttype = new ArrayList<>();
    }
    this.giobjecttype.add(giobjecttypeItem);
    return this;
  }

  /**
   * Auflistung aller Objekte, auf die der Suchstring zutrifft.\\ Rückgabe der Eigenschaften, die im Datentyp GIObjectType definiert sind  (Objektname und COO-Adresse) 
   * @return giobjecttype
   */
  @Valid 
  @Schema(name = "giobjecttype", example = "LHM-Sitzung 14.10.2016 COO.1.2301.1.1041875", description = "Auflistung aller Objekte, auf die der Suchstring zutrifft.\\ Rückgabe der Eigenschaften, die im Datentyp GIObjectType definiert sind  (Objektname und COO-Adresse) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("giobjecttype")
  public List<@Valid Objektreferenz> getGiobjecttype() {
    return giobjecttype;
  }

  @JsonProperty("giobjecttype")
  public void setGiobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateIncomingAntwortDTO createIncomingAntwortDTO = (CreateIncomingAntwortDTO) o;
    return Objects.equals(this.objid, createIncomingAntwortDTO.objid) &&
        Objects.equals(this.objname, createIncomingAntwortDTO.objname) &&
        Objects.equals(this.giobjecttype, createIncomingAntwortDTO.giobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid, objname, giobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateIncomingAntwortDTO {\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    giobjecttype: ").append(toIndentedString(giobjecttype)).append("\n");
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

    private CreateIncomingAntwortDTO instance;

    public Builder() {
      this(new CreateIncomingAntwortDTO());
    }

    protected Builder(CreateIncomingAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateIncomingAntwortDTO value) { 
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      this.instance.setGiobjecttype(value.giobjecttype);
      return this;
    }

    public CreateIncomingAntwortDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public CreateIncomingAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public CreateIncomingAntwortDTO.Builder giobjecttype(List<Objektreferenz> giobjecttype) {
      this.instance.giobjecttype(giobjecttype);
      return this;
    }
    
    /**
    * returns a built CreateIncomingAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateIncomingAntwortDTO build() {
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
  public static CreateIncomingAntwortDTO.Builder builder() {
    return new CreateIncomingAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateIncomingAntwortDTO.Builder toBuilder() {
    CreateIncomingAntwortDTO.Builder builder = new CreateIncomingAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


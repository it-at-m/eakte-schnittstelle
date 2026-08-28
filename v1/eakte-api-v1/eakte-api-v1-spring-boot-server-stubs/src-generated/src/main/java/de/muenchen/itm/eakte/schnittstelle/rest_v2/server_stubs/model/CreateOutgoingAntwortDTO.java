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
 * CreateOutgoingAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateOutgoingAntwortDTO {

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  @Valid
  private List<@Valid Objektreferenz> giobjecttype = new ArrayList<>();

  public CreateOutgoingAntwortDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der erzeugten Erledigung.
   * @return objid
   */
  
  @Schema(name = "objid", example = "COO.1.2301.1.1042465", description = "Objekt-ID (COO-Adresse) der erzeugten Erledigung.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public CreateOutgoingAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Objektname des angelegten Erledigungsdokuments
   * @return objname
   */
  
  @Schema(name = "objname", example = "Ausgangsschreiben zum Antrag auf Baugenehmigung Firma Mustermann (0010 A20 011-4-0006-0006)", description = "Objektname des angelegten Erledigungsdokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public CreateOutgoingAntwortDTO giobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
    return this;
  }

  public CreateOutgoingAntwortDTO addGiobjecttypeItem(Objektreferenz giobjecttypeItem) {
    if (this.giobjecttype == null) {
      this.giobjecttype = new ArrayList<>();
    }
    this.giobjecttype.add(giobjecttypeItem);
    return this;
  }

  /**
   * Liste der Objektadressen und Namen der Schriftstücke im Dokument.
   * @return giobjecttype
   */
  @Valid 
  @Schema(name = "giobjecttype", description = "Liste der Objektadressen und Namen der Schriftstücke im Dokument.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    CreateOutgoingAntwortDTO createOutgoingAntwortDTO = (CreateOutgoingAntwortDTO) o;
    return Objects.equals(this.objid, createOutgoingAntwortDTO.objid) &&
        Objects.equals(this.objname, createOutgoingAntwortDTO.objname) &&
        Objects.equals(this.giobjecttype, createOutgoingAntwortDTO.giobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid, objname, giobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOutgoingAntwortDTO {\n");
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

    private CreateOutgoingAntwortDTO instance;

    public Builder() {
      this(new CreateOutgoingAntwortDTO());
    }

    protected Builder(CreateOutgoingAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateOutgoingAntwortDTO value) { 
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      this.instance.setGiobjecttype(value.giobjecttype);
      return this;
    }

    public CreateOutgoingAntwortDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public CreateOutgoingAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public CreateOutgoingAntwortDTO.Builder giobjecttype(List<Objektreferenz> giobjecttype) {
      this.instance.giobjecttype(giobjecttype);
      return this;
    }
    
    /**
    * returns a built CreateOutgoingAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateOutgoingAntwortDTO build() {
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
  public static CreateOutgoingAntwortDTO.Builder builder() {
    return new CreateOutgoingAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateOutgoingAntwortDTO.Builder toBuilder() {
    CreateOutgoingAntwortDTO.Builder builder = new CreateOutgoingAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


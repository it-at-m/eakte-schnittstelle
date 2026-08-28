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
 * DmsObjektResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class DmsObjektResponse {

  private Optional<String> objid = Optional.empty();

  private Optional<String> objname = Optional.empty();

  public DmsObjektResponse objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * COO-Adresse
   * @return objid
   */
  
  @Schema(name = "objid", description = "COO-Adresse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  public DmsObjektResponse objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Name des Objekts
   * @return objname
   */
  
  @Schema(name = "objname", description = "Name des Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    DmsObjektResponse dmsObjektResponse = (DmsObjektResponse) o;
    return Objects.equals(this.objid, dmsObjektResponse.objid) &&
        Objects.equals(this.objname, dmsObjektResponse.objname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid, objname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DmsObjektResponse {\n");
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

    private DmsObjektResponse instance;

    public Builder() {
      this(new DmsObjektResponse());
    }

    protected Builder(DmsObjektResponse instance) {
      this.instance = instance;
    }

    protected Builder copyOf(DmsObjektResponse value) { 
      this.instance.setObjid(value.objid);
      this.instance.setObjname(value.objname);
      return this;
    }

    public DmsObjektResponse.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    public DmsObjektResponse.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    /**
    * returns a built DmsObjektResponse instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public DmsObjektResponse build() {
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
  public static DmsObjektResponse.Builder builder() {
    return new DmsObjektResponse.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public DmsObjektResponse.Builder toBuilder() {
    DmsObjektResponse.Builder builder = new DmsObjektResponse.Builder();
    return builder.copyOf(this);
  }

}


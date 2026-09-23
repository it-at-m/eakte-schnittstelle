package de.muenchen.itm.eakte.schnittstelle.rest_v1.server_stubs.model;

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
 * Name und ID (COO-Adresse) des Schriftgutobjekts
 */

@Schema(name = "Objektreferenz", description = "Name und ID (COO-Adresse) des Schriftgutobjekts")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Objektreferenz {

  private Optional<String> objname = Optional.empty();

  private Optional<String> objaddress = Optional.empty();

  public Objektreferenz objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Get objname
   * @return objname
   */
  
  @Schema(name = "objname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public Objektreferenz objaddress(String objaddress) {
    this.objaddress = Optional.ofNullable(objaddress);
    return this;
  }

  /**
   * Get objaddress
   * @return objaddress
   */
  
  @Schema(name = "objaddress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objaddress")
  public Optional<String> getObjaddress() {
    return objaddress;
  }

  @JsonProperty("objaddress")
  public void setObjaddress(Optional<String> objaddress) {
    this.objaddress = objaddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Objektreferenz objektreferenz = (Objektreferenz) o;
    return Objects.equals(this.objname, objektreferenz.objname) &&
        Objects.equals(this.objaddress, objektreferenz.objaddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objname, objaddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Objektreferenz {\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    objaddress: ").append(toIndentedString(objaddress)).append("\n");
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

    private Objektreferenz instance;

    public Builder() {
      this(new Objektreferenz());
    }

    protected Builder(Objektreferenz instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Objektreferenz value) { 
      this.instance.setObjname(value.objname);
      this.instance.setObjaddress(value.objaddress);
      return this;
    }

    public Objektreferenz.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public Objektreferenz.Builder objaddress(String objaddress) {
      this.instance.objaddress(objaddress);
      return this;
    }
    
    /**
    * returns a built Objektreferenz instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Objektreferenz build() {
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
  public static Objektreferenz.Builder builder() {
    return new Objektreferenz.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Objektreferenz.Builder toBuilder() {
    Objektreferenz.Builder builder = new Objektreferenz.Builder();
    return builder.copyOf(this);
  }

}


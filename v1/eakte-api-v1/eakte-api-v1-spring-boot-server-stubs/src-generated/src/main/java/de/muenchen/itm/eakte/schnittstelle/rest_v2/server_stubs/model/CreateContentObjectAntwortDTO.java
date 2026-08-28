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
 * CreateContentObjectAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateContentObjectAntwortDTO {

  private Optional<String> objid = Optional.empty();

  public CreateContentObjectAntwortDTO objid(String objid) {
    this.objid = Optional.ofNullable(objid);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des erzeugten Schriftstückes.
   * @return objid
   */
  
  @Schema(name = "objid", example = "COO.1.2301.1.1042465", description = "Objekt-ID (COO-Adresse) des erzeugten Schriftstückes.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objid")
  public Optional<String> getObjid() {
    return objid;
  }

  @JsonProperty("objid")
  public void setObjid(Optional<String> objid) {
    this.objid = objid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateContentObjectAntwortDTO createContentObjectAntwortDTO = (CreateContentObjectAntwortDTO) o;
    return Objects.equals(this.objid, createContentObjectAntwortDTO.objid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateContentObjectAntwortDTO {\n");
    sb.append("    objid: ").append(toIndentedString(objid)).append("\n");
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

    private CreateContentObjectAntwortDTO instance;

    public Builder() {
      this(new CreateContentObjectAntwortDTO());
    }

    protected Builder(CreateContentObjectAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateContentObjectAntwortDTO value) { 
      this.instance.setObjid(value.objid);
      return this;
    }

    public CreateContentObjectAntwortDTO.Builder objid(String objid) {
      this.instance.objid(objid);
      return this;
    }
    
    /**
    * returns a built CreateContentObjectAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateContentObjectAntwortDTO build() {
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
  public static CreateContentObjectAntwortDTO.Builder builder() {
    return new CreateContentObjectAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateContentObjectAntwortDTO.Builder toBuilder() {
    CreateContentObjectAntwortDTO.Builder builder = new CreateContentObjectAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


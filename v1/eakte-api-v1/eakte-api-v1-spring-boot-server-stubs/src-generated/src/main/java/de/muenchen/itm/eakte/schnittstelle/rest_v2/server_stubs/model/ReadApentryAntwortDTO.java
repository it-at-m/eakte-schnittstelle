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
 * ReadApentryAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadApentryAntwortDTO {

  @Valid
  private List<@Valid Objektreferenz> giobjecttype = new ArrayList<>();

  public ReadApentryAntwortDTO giobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
    return this;
  }

  public ReadApentryAntwortDTO addGiobjecttypeItem(Objektreferenz giobjecttypeItem) {
    if (this.giobjecttype == null) {
      this.giobjecttype = new ArrayList<>();
    }
    this.giobjecttype.add(giobjecttypeItem);
    return this;
  }

  /**
   * Liste der untergeordneten Aktenplaneinträge eines Aktenplaneintrags mit jeweils Bezeichner (Name) und COO-Adresse (ID) des Objekts 
   * @return giobjecttype
   */
  @Valid 
  @Schema(name = "giobjecttype", description = "Liste der untergeordneten Aktenplaneinträge eines Aktenplaneintrags mit jeweils Bezeichner (Name) und COO-Adresse (ID) des Objekts ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ReadApentryAntwortDTO readApentryAntwortDTO = (ReadApentryAntwortDTO) o;
    return Objects.equals(this.giobjecttype, readApentryAntwortDTO.giobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(giobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadApentryAntwortDTO {\n");
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

    private ReadApentryAntwortDTO instance;

    public Builder() {
      this(new ReadApentryAntwortDTO());
    }

    protected Builder(ReadApentryAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadApentryAntwortDTO value) { 
      this.instance.setGiobjecttype(value.giobjecttype);
      return this;
    }

    public ReadApentryAntwortDTO.Builder giobjecttype(List<Objektreferenz> giobjecttype) {
      this.instance.giobjecttype(giobjecttype);
      return this;
    }
    
    /**
    * returns a built ReadApentryAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadApentryAntwortDTO build() {
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
  public static ReadApentryAntwortDTO.Builder builder() {
    return new ReadApentryAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadApentryAntwortDTO.Builder toBuilder() {
    ReadApentryAntwortDTO.Builder builder = new ReadApentryAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Letzte Änderung von (Login-String des Benutzers) (COOSYSTEM@1.1:objchangedby)
 */

@Schema(name = "ObjChangedBy", description = "Letzte Änderung von (Login-String des Benutzers) (COOSYSTEM@1.1:objchangedby)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ObjChangedBy {

  @Valid
  private List<String> string = new ArrayList<>();

  public ObjChangedBy string(List<String> string) {
    this.string = string;
    return this;
  }

  public ObjChangedBy addStringItem(String stringItem) {
    if (this.string == null) {
      this.string = new ArrayList<>();
    }
    this.string.add(stringItem);
    return this;
  }

  /**
   * Get string
   * @return string
   */
  
  @Schema(name = "string", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("string")
  public List<String> getString() {
    return string;
  }

  @JsonProperty("string")
  public void setString(List<String> string) {
    this.string = string;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjChangedBy objChangedBy = (ObjChangedBy) o;
    return Objects.equals(this.string, objChangedBy.string);
  }

  @Override
  public int hashCode() {
    return Objects.hash(string);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjChangedBy {\n");
    sb.append("    string: ").append(toIndentedString(string)).append("\n");
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

    private ObjChangedBy instance;

    public Builder() {
      this(new ObjChangedBy());
    }

    protected Builder(ObjChangedBy instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ObjChangedBy value) { 
      this.instance.setString(value.string);
      return this;
    }

    public ObjChangedBy.Builder string(List<String> string) {
      this.instance.string(string);
      return this;
    }
    
    /**
    * returns a built ObjChangedBy instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ObjChangedBy build() {
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
  public static ObjChangedBy.Builder builder() {
    return new ObjChangedBy.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ObjChangedBy.Builder toBuilder() {
    ObjChangedBy.Builder builder = new ObjChangedBy.Builder();
    return builder.copyOf(this);
  }

}


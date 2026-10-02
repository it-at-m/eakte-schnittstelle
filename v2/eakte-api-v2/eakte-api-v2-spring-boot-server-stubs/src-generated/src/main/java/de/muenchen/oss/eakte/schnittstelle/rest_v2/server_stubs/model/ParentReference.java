package de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ParentReference
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ParentReference {

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    VORGANG("Vorgang"),
    
    POSTKORB("Postkorb"),
    
    ARBEITSVORRAT("Arbeitsvorrat");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private String id;

  public ParentReference() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ParentReference(TypeEnum type, String id) {
    this.type = type;
    this.id = id;
  }

  public ParentReference type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ParentReference id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParentReference parentReference = (ParentReference) o;
    return Objects.equals(this.type, parentReference.type) &&
        Objects.equals(this.id, parentReference.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParentReference {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

    private ParentReference instance;

    public Builder() {
      this(new ParentReference());
    }

    protected Builder(ParentReference instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ParentReference value) { 
      this.instance.setType(value.type);
      this.instance.setId(value.id);
      return this;
    }

    public ParentReference.Builder type(TypeEnum type) {
      this.instance.type(type);
      return this;
    }
    
    public ParentReference.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    /**
    * returns a built ParentReference instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ParentReference build() {
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
  public static ParentReference.Builder builder() {
    return new ParentReference.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ParentReference.Builder toBuilder() {
    ParentReference.Builder builder = new ParentReference.Builder();
    return builder.copyOf(this);
  }

}


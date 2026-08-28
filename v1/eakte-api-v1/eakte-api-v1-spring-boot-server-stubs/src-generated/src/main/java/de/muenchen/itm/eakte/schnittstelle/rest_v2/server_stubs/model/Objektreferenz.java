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
 * Name und ID (COO-Adresse) des Schriftgutobjekts
 */

@Schema(name = "Objektreferenz", description = "Name und ID (COO-Adresse) des Schriftgutobjekts")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Objektreferenz {

  private Optional<String> name = Optional.empty();

  private Optional<String> id = Optional.empty();

  public Objektreferenz name(String name) {
    this.name = Optional.ofNullable(name);
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(Optional<String> name) {
    this.name = name;
  }

  public Objektreferenz id(String id) {
    this.id = Optional.ofNullable(id);
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Optional<String> id) {
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
    Objektreferenz objektreferenz = (Objektreferenz) o;
    return Objects.equals(this.name, objektreferenz.name) &&
        Objects.equals(this.id, objektreferenz.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Objektreferenz {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

    private Objektreferenz instance;

    public Builder() {
      this(new Objektreferenz());
    }

    protected Builder(Objektreferenz instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Objektreferenz value) { 
      this.instance.setName(value.name);
      this.instance.setId(value.id);
      return this;
    }

    public Objektreferenz.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public Objektreferenz.Builder id(String id) {
      this.instance.id(id);
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


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AttributSchriftstueckURI
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributSchriftstueckURI extends AttributUriUndWert {

  private String attributWert;

  public AttributSchriftstueckURI() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributSchriftstueckURI(String attributWert, String attributURI, String datenTyp) {
    super(attributURI, datenTyp);
    this.attributWert = attributWert;
  }

  public AttributSchriftstueckURI attributWert(String attributWert) {
    this.attributWert = attributWert;
    return this;
  }

  /**
   * Das ist die URI für den Verweis auf ein Schriftstück  Dies kann auch einen Query-Parameter 'bedingungen' enthalten und auf diese Weise auf eine dynamische Ergebnisliste einer bestimmten Ressourcenklasse verweisen (z.B. alle Vorgänge, deren Parent eine bestimmte Akte ist - dadurch kann auf eine ganze Liste von Ressourcen mit einer URI verwiesen werden). 
   * @return attributWert
   */
  @NotNull 
  @Schema(name = "attributWert", description = "Das ist die URI für den Verweis auf ein Schriftstück  Dies kann auch einen Query-Parameter 'bedingungen' enthalten und auf diese Weise auf eine dynamische Ergebnisliste einer bestimmten Ressourcenklasse verweisen (z.B. alle Vorgänge, deren Parent eine bestimmte Akte ist - dadurch kann auf eine ganze Liste von Ressourcen mit einer URI verwiesen werden). ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributWert")
  public String getAttributWert() {
    return attributWert;
  }

  @JsonProperty("attributWert")
  public void setAttributWert(String attributWert) {
    this.attributWert = attributWert;
  }


  public AttributSchriftstueckURI attributURI(String attributURI) {
    super.attributURI(attributURI);
    return this;
  }

  public AttributSchriftstueckURI datenTyp(String datenTyp) {
    super.datenTyp(datenTyp);
    return this;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributSchriftstueckURI attributSchriftstueckURI = (AttributSchriftstueckURI) o;
    return Objects.equals(this.attributWert, attributSchriftstueckURI.attributWert) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributWert, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributSchriftstueckURI {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    attributWert: ").append(toIndentedString(attributWert)).append("\n");
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
  
  public static class Builder extends AttributUriUndWert.Builder {

    private AttributSchriftstueckURI instance;

    public Builder() {
      this(new AttributSchriftstueckURI());
    }

    protected Builder(AttributSchriftstueckURI instance) {
      super(instance); // the parent builder shares the same instance
      this.instance = instance;
    }

    protected Builder copyOf(AttributSchriftstueckURI value) { 
      super.copyOf(value);
      this.instance.setAttributWert(value.attributWert);
      return this;
    }

    public AttributSchriftstueckURI.Builder attributWert(String attributWert) {
      this.instance.attributWert(attributWert);
      return this;
    }
    
    @Override
    public AttributSchriftstueckURI.Builder attributURI(String attributURI) {
      this.instance.attributURI(attributURI);
      return this;
    }
    
    @Override
    public AttributSchriftstueckURI.Builder datenTyp(String datenTyp) {
      this.instance.datenTyp(datenTyp);
      return this;
    }
    
    /**
    * returns a built AttributSchriftstueckURI instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AttributSchriftstueckURI build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        super.build();
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
  public static AttributSchriftstueckURI.Builder builder() {
    return new AttributSchriftstueckURI.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AttributSchriftstueckURI.Builder toBuilder() {
    AttributSchriftstueckURI.Builder builder = new AttributSchriftstueckURI.Builder();
    return builder.copyOf(this);
  }

}


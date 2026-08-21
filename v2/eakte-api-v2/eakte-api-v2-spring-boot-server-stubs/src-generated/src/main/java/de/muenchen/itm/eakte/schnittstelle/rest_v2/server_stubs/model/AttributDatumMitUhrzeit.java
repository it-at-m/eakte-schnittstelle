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
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AttributDatumMitUhrzeit
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributDatumMitUhrzeit extends AttributUriUndWert {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime attributWert;

  public AttributDatumMitUhrzeit() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributDatumMitUhrzeit(OffsetDateTime attributWert, String attributURI, String datenTyp) {
    super(attributURI, datenTyp);
    this.attributWert = attributWert;
  }

  public AttributDatumMitUhrzeit attributWert(OffsetDateTime attributWert) {
    this.attributWert = attributWert;
    return this;
  }

  /**
   * Get attributWert
   * @return attributWert
   */
  @NotNull @Valid 
  @Schema(name = "attributWert", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributWert")
  public OffsetDateTime getAttributWert() {
    return attributWert;
  }

  @JsonProperty("attributWert")
  public void setAttributWert(OffsetDateTime attributWert) {
    this.attributWert = attributWert;
  }


  public AttributDatumMitUhrzeit attributURI(String attributURI) {
    super.attributURI(attributURI);
    return this;
  }

  public AttributDatumMitUhrzeit datenTyp(String datenTyp) {
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
    AttributDatumMitUhrzeit attributDatumMitUhrzeit = (AttributDatumMitUhrzeit) o;
    return Objects.equals(this.attributWert, attributDatumMitUhrzeit.attributWert) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributWert, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributDatumMitUhrzeit {\n");
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

    private AttributDatumMitUhrzeit instance;

    public Builder() {
      this(new AttributDatumMitUhrzeit());
    }

    protected Builder(AttributDatumMitUhrzeit instance) {
      super(instance); // the parent builder shares the same instance
      this.instance = instance;
    }

    protected Builder copyOf(AttributDatumMitUhrzeit value) { 
      super.copyOf(value);
      this.instance.setAttributWert(value.attributWert);
      return this;
    }

    public AttributDatumMitUhrzeit.Builder attributWert(OffsetDateTime attributWert) {
      this.instance.attributWert(attributWert);
      return this;
    }
    
    @Override
    public AttributDatumMitUhrzeit.Builder attributURI(String attributURI) {
      this.instance.attributURI(attributURI);
      return this;
    }
    
    @Override
    public AttributDatumMitUhrzeit.Builder datenTyp(String datenTyp) {
      this.instance.datenTyp(datenTyp);
      return this;
    }
    
    /**
    * returns a built AttributDatumMitUhrzeit instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AttributDatumMitUhrzeit build() {
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
  public static AttributDatumMitUhrzeit.Builder builder() {
    return new AttributDatumMitUhrzeit.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AttributDatumMitUhrzeit.Builder toBuilder() {
    AttributDatumMitUhrzeit.Builder builder = new AttributDatumMitUhrzeit.Builder();
    return builder.copyOf(this);
  }

}


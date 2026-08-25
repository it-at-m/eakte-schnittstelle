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
 * AttributBase64EncodedContent
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributBase64EncodedContent extends AttributUriUndWert {

  private String attributWert;

  public AttributBase64EncodedContent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributBase64EncodedContent(String attributWert, String attributURI, String datenTyp) {
    super(attributURI, datenTyp);
    this.attributWert = attributWert;
  }

  public AttributBase64EncodedContent attributWert(String attributWert) {
    this.attributWert = attributWert;
    return this;
  }

  /**
   * Das sind Binärdaten, die Base64-kodiert sind. 
   * @return attributWert
   */
  @NotNull 
  @Schema(name = "attributWert", description = "Das sind Binärdaten, die Base64-kodiert sind. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributWert")
  public String getAttributWert() {
    return attributWert;
  }

  @JsonProperty("attributWert")
  public void setAttributWert(String attributWert) {
    this.attributWert = attributWert;
  }


  public AttributBase64EncodedContent attributURI(String attributURI) {
    super.attributURI(attributURI);
    return this;
  }

  public AttributBase64EncodedContent datenTyp(String datenTyp) {
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
    AttributBase64EncodedContent attributBase64EncodedContent = (AttributBase64EncodedContent) o;
    return Objects.equals(this.attributWert, attributBase64EncodedContent.attributWert) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributWert, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributBase64EncodedContent {\n");
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

    private AttributBase64EncodedContent instance;

    public Builder() {
      this(new AttributBase64EncodedContent());
    }

    protected Builder(AttributBase64EncodedContent instance) {
      super(instance); // the parent builder shares the same instance
      this.instance = instance;
    }

    protected Builder copyOf(AttributBase64EncodedContent value) { 
      super.copyOf(value);
      this.instance.setAttributWert(value.attributWert);
      return this;
    }

    public AttributBase64EncodedContent.Builder attributWert(String attributWert) {
      this.instance.attributWert(attributWert);
      return this;
    }
    
    @Override
    public AttributBase64EncodedContent.Builder attributURI(String attributURI) {
      this.instance.attributURI(attributURI);
      return this;
    }
    
    @Override
    public AttributBase64EncodedContent.Builder datenTyp(String datenTyp) {
      this.instance.datenTyp(datenTyp);
      return this;
    }
    
    /**
    * returns a built AttributBase64EncodedContent instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AttributBase64EncodedContent build() {
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
  public static AttributBase64EncodedContent.Builder builder() {
    return new AttributBase64EncodedContent.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AttributBase64EncodedContent.Builder toBuilder() {
    AttributBase64EncodedContent.Builder builder = new AttributBase64EncodedContent.Builder();
    return builder.copyOf(this);
  }

}


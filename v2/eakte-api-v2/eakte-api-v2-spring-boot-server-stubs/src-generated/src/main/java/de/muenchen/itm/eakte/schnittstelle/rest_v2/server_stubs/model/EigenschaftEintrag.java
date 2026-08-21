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
 * EigenschaftEintrag
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class EigenschaftEintrag {

  private String reference;

  private Object value;

  public EigenschaftEintrag() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EigenschaftEintrag(String reference, Object value) {
    this.reference = reference;
    this.value = value;
  }

  public EigenschaftEintrag reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
   */
  @NotNull 
  @Schema(name = "reference", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }

  @JsonProperty("reference")
  public void setReference(String reference) {
    this.reference = reference;
  }

  public EigenschaftEintrag value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   */
  @NotNull 
  @Schema(name = "value", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EigenschaftEintrag eigenschaftEintrag = (EigenschaftEintrag) o;
    return Objects.equals(this.reference, eigenschaftEintrag.reference) &&
        Objects.equals(this.value, eigenschaftEintrag.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EigenschaftEintrag {\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

    private EigenschaftEintrag instance;

    public Builder() {
      this(new EigenschaftEintrag());
    }

    protected Builder(EigenschaftEintrag instance) {
      this.instance = instance;
    }

    protected Builder copyOf(EigenschaftEintrag value) { 
      this.instance.setReference(value.reference);
      this.instance.setValue(value.value);
      return this;
    }

    public EigenschaftEintrag.Builder reference(String reference) {
      this.instance.reference(reference);
      return this;
    }
    
    public EigenschaftEintrag.Builder value(Object value) {
      this.instance.value(value);
      return this;
    }
    
    /**
    * returns a built EigenschaftEintrag instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public EigenschaftEintrag build() {
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
  public static EigenschaftEintrag.Builder builder() {
    return new EigenschaftEintrag.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public EigenschaftEintrag.Builder toBuilder() {
    EigenschaftEintrag.Builder builder = new EigenschaftEintrag.Builder();
    return builder.copyOf(this);
  }

}


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
 * AttributEintrag
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributEintrag {

  private String reference;

  private Object value;

  public AttributEintrag() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributEintrag(String reference, Object value) {
    this.reference = reference;
    this.value = value;
  }

  public AttributEintrag reference(String reference) {
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

  public AttributEintrag value(Object value) {
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
    AttributEintrag attributEintrag = (AttributEintrag) o;
    return Objects.equals(this.reference, attributEintrag.reference) &&
        Objects.equals(this.value, attributEintrag.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributEintrag {\n");
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
}


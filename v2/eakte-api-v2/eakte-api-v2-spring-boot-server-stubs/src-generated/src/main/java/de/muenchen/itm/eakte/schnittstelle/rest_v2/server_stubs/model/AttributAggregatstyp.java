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
 * AttributAggregatstyp
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributAggregatstyp extends AttributUriUndWert {

  @Valid
  private List<@Valid AttributUriUndWert> attributWert = new ArrayList<>();

  public AttributAggregatstyp() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributAggregatstyp(List<@Valid AttributUriUndWert> attributWert, String attributURI, String datenTyp) {
    super(attributURI, datenTyp);
    this.attributWert = attributWert;
  }

  public AttributAggregatstyp attributWert(List<@Valid AttributUriUndWert> attributWert) {
    this.attributWert = attributWert;
    return this;
  }

  public AttributAggregatstyp addAttributWertItem(AttributUriUndWert attributWertItem) {
    if (this.attributWert == null) {
      this.attributWert = new ArrayList<>();
    }
    this.attributWert.add(attributWertItem);
    return this;
  }

  /**
   * Get attributWert
   * @return attributWert
   */
  @NotNull @Valid 
  @Schema(name = "attributWert", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributWert")
  public List<@Valid AttributUriUndWert> getAttributWert() {
    return attributWert;
  }

  @JsonProperty("attributWert")
  public void setAttributWert(List<@Valid AttributUriUndWert> attributWert) {
    this.attributWert = attributWert;
  }


  public AttributAggregatstyp attributURI(String attributURI) {
    super.attributURI(attributURI);
    return this;
  }

  public AttributAggregatstyp datenTyp(String datenTyp) {
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
    AttributAggregatstyp attributAggregatstyp = (AttributAggregatstyp) o;
    return Objects.equals(this.attributWert, attributAggregatstyp.attributWert) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributWert, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributAggregatstyp {\n");
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
}


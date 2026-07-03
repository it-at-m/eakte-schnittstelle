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
import java.time.LocalDate;
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
 * AttributDatum
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributDatum extends AttributUriUndWert {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate attributWert;

  public AttributDatum() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributDatum(LocalDate attributWert, String attributURI, String datenTyp) {
    super(attributURI, datenTyp);
    this.attributWert = attributWert;
  }

  public AttributDatum attributWert(LocalDate attributWert) {
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
  public LocalDate getAttributWert() {
    return attributWert;
  }

  @JsonProperty("attributWert")
  public void setAttributWert(LocalDate attributWert) {
    this.attributWert = attributWert;
  }


  public AttributDatum attributURI(String attributURI) {
    super.attributURI(attributURI);
    return this;
  }

  public AttributDatum datenTyp(String datenTyp) {
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
    AttributDatum attributDatum = (AttributDatum) o;
    return Objects.equals(this.attributWert, attributDatum.attributWert) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributWert, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributDatum {\n");
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


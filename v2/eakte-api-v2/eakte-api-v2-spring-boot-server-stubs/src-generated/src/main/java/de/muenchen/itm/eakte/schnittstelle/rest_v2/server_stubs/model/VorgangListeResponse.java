package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
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
 * VorgangListeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class VorgangListeResponse {

  private Optional<Integer> anzahl = Optional.empty();

  @Valid
  private List<@Valid Vorgang> elemente = new ArrayList<>();

  public VorgangListeResponse anzahl(Integer anzahl) {
    this.anzahl = Optional.ofNullable(anzahl);
    return this;
  }

  /**
   * Anzahl der Elemente in einer Liste von Ressourcen 
   * @return anzahl
   */
  
  @Schema(name = "anzahl", example = "3", description = "Anzahl der Elemente in einer Liste von Ressourcen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anzahl")
  public Optional<Integer> getAnzahl() {
    return anzahl;
  }

  @JsonProperty("anzahl")
  public void setAnzahl(Optional<Integer> anzahl) {
    this.anzahl = anzahl;
  }

  public VorgangListeResponse elemente(List<@Valid Vorgang> elemente) {
    this.elemente = elemente;
    return this;
  }

  public VorgangListeResponse addElementeItem(Vorgang elementeItem) {
    if (this.elemente == null) {
      this.elemente = new ArrayList<>();
    }
    this.elemente.add(elementeItem);
    return this;
  }

  /**
   * Liste von Vorgängen
   * @return elemente
   */
  @Valid 
  @Schema(name = "elemente", description = "Liste von Vorgängen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elemente")
  public List<@Valid Vorgang> getElemente() {
    return elemente;
  }

  @JsonProperty("elemente")
  public void setElemente(List<@Valid Vorgang> elemente) {
    this.elemente = elemente;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VorgangListeResponse vorgangListeResponse = (VorgangListeResponse) o;
    return Objects.equals(this.anzahl, vorgangListeResponse.anzahl) &&
        Objects.equals(this.elemente, vorgangListeResponse.elemente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(anzahl, elemente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VorgangListeResponse {\n");
    sb.append("    anzahl: ").append(toIndentedString(anzahl)).append("\n");
    sb.append("    elemente: ").append(toIndentedString(elemente)).append("\n");
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


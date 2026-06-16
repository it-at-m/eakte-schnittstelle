package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EAkteSchnittstelleError;
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
 * AttributbeschreibungenListeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttributbeschreibungenListeResponse {

  private Boolean success;

  private Optional<EAkteSchnittstelleError> error = Optional.empty();

  private Optional<Integer> anzahlAttributbeschreibungen = Optional.empty();

  @Valid
  private List<@Valid Attributbeschreibung> attributbeschreibungenListe = new ArrayList<>();

  public AttributbeschreibungenListeResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AttributbeschreibungenListeResponse(Boolean success) {
    this.success = success;
  }

  public AttributbeschreibungenListeResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
   */
  @NotNull 
  @Schema(name = "success", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  @JsonProperty("success")
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public AttributbeschreibungenListeResponse error(EAkteSchnittstelleError error) {
    this.error = Optional.ofNullable(error);
    return this;
  }

  /**
   * Get error
   * @return error
   */
  @Valid 
  @Schema(name = "error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public Optional<EAkteSchnittstelleError> getError() {
    return error;
  }

  @JsonProperty("error")
  public void setError(Optional<EAkteSchnittstelleError> error) {
    this.error = error;
  }

  public AttributbeschreibungenListeResponse anzahlAttributbeschreibungen(Integer anzahlAttributbeschreibungen) {
    this.anzahlAttributbeschreibungen = Optional.ofNullable(anzahlAttributbeschreibungen);
    return this;
  }

  /**
   * Anzahl der Elemente in einer Liste von Ressourcen 
   * @return anzahlAttributbeschreibungen
   */
  
  @Schema(name = "anzahlAttributbeschreibungen", example = "3", description = "Anzahl der Elemente in einer Liste von Ressourcen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anzahlAttributbeschreibungen")
  public Optional<Integer> getAnzahlAttributbeschreibungen() {
    return anzahlAttributbeschreibungen;
  }

  @JsonProperty("anzahlAttributbeschreibungen")
  public void setAnzahlAttributbeschreibungen(Optional<Integer> anzahlAttributbeschreibungen) {
    this.anzahlAttributbeschreibungen = anzahlAttributbeschreibungen;
  }

  public AttributbeschreibungenListeResponse attributbeschreibungenListe(List<@Valid Attributbeschreibung> attributbeschreibungenListe) {
    this.attributbeschreibungenListe = attributbeschreibungenListe;
    return this;
  }

  public AttributbeschreibungenListeResponse addAttributbeschreibungenListeItem(Attributbeschreibung attributbeschreibungenListeItem) {
    if (this.attributbeschreibungenListe == null) {
      this.attributbeschreibungenListe = new ArrayList<>();
    }
    this.attributbeschreibungenListe.add(attributbeschreibungenListeItem);
    return this;
  }

  /**
   * List von Attributbeschreibungen 
   * @return attributbeschreibungenListe
   */
  @Valid 
  @Schema(name = "attributbeschreibungenListe", description = "List von Attributbeschreibungen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributbeschreibungenListe")
  public List<@Valid Attributbeschreibung> getAttributbeschreibungenListe() {
    return attributbeschreibungenListe;
  }

  @JsonProperty("attributbeschreibungenListe")
  public void setAttributbeschreibungenListe(List<@Valid Attributbeschreibung> attributbeschreibungenListe) {
    this.attributbeschreibungenListe = attributbeschreibungenListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributbeschreibungenListeResponse attributbeschreibungenListeResponse = (AttributbeschreibungenListeResponse) o;
    return Objects.equals(this.success, attributbeschreibungenListeResponse.success) &&
        Objects.equals(this.error, attributbeschreibungenListeResponse.error) &&
        Objects.equals(this.anzahlAttributbeschreibungen, attributbeschreibungenListeResponse.anzahlAttributbeschreibungen) &&
        Objects.equals(this.attributbeschreibungenListe, attributbeschreibungenListeResponse.attributbeschreibungenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, error, anzahlAttributbeschreibungen, attributbeschreibungenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttributbeschreibungenListeResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    anzahlAttributbeschreibungen: ").append(toIndentedString(anzahlAttributbeschreibungen)).append("\n");
    sb.append("    attributbeschreibungenListe: ").append(toIndentedString(attributbeschreibungenListe)).append("\n");
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


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Akte;
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
 * AktenListeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AktenListeResponse {

  private Boolean success;

  private Optional<EAkteSchnittstelleError> error = Optional.empty();

  private Optional<Integer> anzahlAkten = Optional.empty();

  @Valid
  private List<@Valid Akte> aktenListe = new ArrayList<>();

  public AktenListeResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AktenListeResponse(Boolean success) {
    this.success = success;
  }

  public AktenListeResponse success(Boolean success) {
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

  public AktenListeResponse error(EAkteSchnittstelleError error) {
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

  public AktenListeResponse anzahlAkten(Integer anzahlAkten) {
    this.anzahlAkten = Optional.ofNullable(anzahlAkten);
    return this;
  }

  /**
   * Anzahl der Elemente in einer Liste von Ressourcen 
   * @return anzahlAkten
   */
  
  @Schema(name = "anzahlAkten", example = "3", description = "Anzahl der Elemente in einer Liste von Ressourcen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anzahlAkten")
  public Optional<Integer> getAnzahlAkten() {
    return anzahlAkten;
  }

  @JsonProperty("anzahlAkten")
  public void setAnzahlAkten(Optional<Integer> anzahlAkten) {
    this.anzahlAkten = anzahlAkten;
  }

  public AktenListeResponse aktenListe(List<@Valid Akte> aktenListe) {
    this.aktenListe = aktenListe;
    return this;
  }

  public AktenListeResponse addAktenListeItem(Akte aktenListeItem) {
    if (this.aktenListe == null) {
      this.aktenListe = new ArrayList<>();
    }
    this.aktenListe.add(aktenListeItem);
    return this;
  }

  /**
   * Liste von Akten
   * @return aktenListe
   */
  @Valid 
  @Schema(name = "aktenListe", description = "Liste von Akten", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("aktenListe")
  public List<@Valid Akte> getAktenListe() {
    return aktenListe;
  }

  @JsonProperty("aktenListe")
  public void setAktenListe(List<@Valid Akte> aktenListe) {
    this.aktenListe = aktenListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AktenListeResponse aktenListeResponse = (AktenListeResponse) o;
    return Objects.equals(this.success, aktenListeResponse.success) &&
        Objects.equals(this.error, aktenListeResponse.error) &&
        Objects.equals(this.anzahlAkten, aktenListeResponse.anzahlAkten) &&
        Objects.equals(this.aktenListe, aktenListeResponse.aktenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, error, anzahlAkten, aktenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AktenListeResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    anzahlAkten: ").append(toIndentedString(anzahlAkten)).append("\n");
    sb.append("    aktenListe: ").append(toIndentedString(aktenListe)).append("\n");
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


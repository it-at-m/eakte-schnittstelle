package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;
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
 * DefinitionenFuerVerfahrenListeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class DefinitionenFuerVerfahrenListeResponse {

  private Boolean success;

  private Optional<EAkteSchnittstelleError> error = Optional.empty();

  private Optional<Integer> anzahlDefinitionenFuerVerfahren = Optional.empty();

  @Valid
  private List<@Valid DefinitionFuerVerfahren> definitionenFuerVerfahrenListe = new ArrayList<>();

  public DefinitionenFuerVerfahrenListeResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DefinitionenFuerVerfahrenListeResponse(Boolean success) {
    this.success = success;
  }

  public DefinitionenFuerVerfahrenListeResponse success(Boolean success) {
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

  public DefinitionenFuerVerfahrenListeResponse error(EAkteSchnittstelleError error) {
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

  public DefinitionenFuerVerfahrenListeResponse anzahlDefinitionenFuerVerfahren(Integer anzahlDefinitionenFuerVerfahren) {
    this.anzahlDefinitionenFuerVerfahren = Optional.ofNullable(anzahlDefinitionenFuerVerfahren);
    return this;
  }

  /**
   * Anzahl der Elemente in einer Liste von Ressourcen 
   * @return anzahlDefinitionenFuerVerfahren
   */
  
  @Schema(name = "anzahlDefinitionenFuerVerfahren", example = "3", description = "Anzahl der Elemente in einer Liste von Ressourcen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("anzahlDefinitionenFuerVerfahren")
  public Optional<Integer> getAnzahlDefinitionenFuerVerfahren() {
    return anzahlDefinitionenFuerVerfahren;
  }

  @JsonProperty("anzahlDefinitionenFuerVerfahren")
  public void setAnzahlDefinitionenFuerVerfahren(Optional<Integer> anzahlDefinitionenFuerVerfahren) {
    this.anzahlDefinitionenFuerVerfahren = anzahlDefinitionenFuerVerfahren;
  }

  public DefinitionenFuerVerfahrenListeResponse definitionenFuerVerfahrenListe(List<@Valid DefinitionFuerVerfahren> definitionenFuerVerfahrenListe) {
    this.definitionenFuerVerfahrenListe = definitionenFuerVerfahrenListe;
    return this;
  }

  public DefinitionenFuerVerfahrenListeResponse addDefinitionenFuerVerfahrenListeItem(DefinitionFuerVerfahren definitionenFuerVerfahrenListeItem) {
    if (this.definitionenFuerVerfahrenListe == null) {
      this.definitionenFuerVerfahrenListe = new ArrayList<>();
    }
    this.definitionenFuerVerfahrenListe.add(definitionenFuerVerfahrenListeItem);
    return this;
  }

  /**
   * List von Verfahrensdefinitionen 
   * @return definitionenFuerVerfahrenListe
   */
  @Valid 
  @Schema(name = "definitionenFuerVerfahrenListe", description = "List von Verfahrensdefinitionen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("definitionenFuerVerfahrenListe")
  public List<@Valid DefinitionFuerVerfahren> getDefinitionenFuerVerfahrenListe() {
    return definitionenFuerVerfahrenListe;
  }

  @JsonProperty("definitionenFuerVerfahrenListe")
  public void setDefinitionenFuerVerfahrenListe(List<@Valid DefinitionFuerVerfahren> definitionenFuerVerfahrenListe) {
    this.definitionenFuerVerfahrenListe = definitionenFuerVerfahrenListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefinitionenFuerVerfahrenListeResponse definitionenFuerVerfahrenListeResponse = (DefinitionenFuerVerfahrenListeResponse) o;
    return Objects.equals(this.success, definitionenFuerVerfahrenListeResponse.success) &&
        Objects.equals(this.error, definitionenFuerVerfahrenListeResponse.error) &&
        Objects.equals(this.anzahlDefinitionenFuerVerfahren, definitionenFuerVerfahrenListeResponse.anzahlDefinitionenFuerVerfahren) &&
        Objects.equals(this.definitionenFuerVerfahrenListe, definitionenFuerVerfahrenListeResponse.definitionenFuerVerfahrenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, error, anzahlDefinitionenFuerVerfahren, definitionenFuerVerfahrenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefinitionenFuerVerfahrenListeResponse {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    anzahlDefinitionenFuerVerfahren: ").append(toIndentedString(anzahlDefinitionenFuerVerfahren)).append("\n");
    sb.append("    definitionenFuerVerfahrenListe: ").append(toIndentedString(definitionenFuerVerfahrenListe)).append("\n");
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


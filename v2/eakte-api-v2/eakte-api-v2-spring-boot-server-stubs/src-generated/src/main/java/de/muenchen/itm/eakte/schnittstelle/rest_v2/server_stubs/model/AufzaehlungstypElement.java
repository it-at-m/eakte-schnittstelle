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
 * beachte, dass Aufzählungswerte im Fachverfahren nur angezeigt und per Schlüssel selektiert werden müssen, jedoch nie der Wert dort erzeugt wird, sondern nur per Schlüssel aus der vorgegebenenWertemenge selektiert wrd 
 */

@Schema(name = "AufzaehlungstypElement", description = "beachte, dass Aufzählungswerte im Fachverfahren nur angezeigt und per Schlüssel selektiert werden müssen, jedoch nie der Wert dort erzeugt wird, sondern nur per Schlüssel aus der vorgegebenenWertemenge selektiert wrd ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AufzaehlungstypElement {

  private Optional<String> schluessel = Optional.empty();

  private Optional<String> kurzbezeichnungDesWerts = Optional.empty();

  public AufzaehlungstypElement schluessel(String schluessel) {
    this.schluessel = Optional.ofNullable(schluessel);
    return this;
  }

  /**
   * alphanumerischer Schlüssel, der als Attributwert verwendet wird und den (ggf. komplexen) Aufzählungswert eindeutig identifiziert 
   * @return schluessel
   */
  
  @Schema(name = "schluessel", example = "4711", description = "alphanumerischer Schlüssel, der als Attributwert verwendet wird und den (ggf. komplexen) Aufzählungswert eindeutig identifiziert ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("schluessel")
  public Optional<String> getSchluessel() {
    return schluessel;
  }

  @JsonProperty("schluessel")
  public void setSchluessel(Optional<String> schluessel) {
    this.schluessel = schluessel;
  }

  public AufzaehlungstypElement kurzbezeichnungDesWerts(String kurzbezeichnungDesWerts) {
    this.kurzbezeichnungDesWerts = Optional.ofNullable(kurzbezeichnungDesWerts);
    return this;
  }

  /**
   * Kurzbezeichnung des Wertes.\\ Der Wert kann in der eAkte ein komplexer (zusammengesetzter) Wert sein, also ein Objekt. Für die Selektion reicht aber auf Fachverfahrensseite aus, eine Kurzbezeichnung zu sehen. 
   * @return kurzbezeichnungDesWerts
   */
  
  @Schema(name = "kurzbezeichnungDesWerts", example = "Pizza Napoli", description = "Kurzbezeichnung des Wertes.\\ Der Wert kann in der eAkte ein komplexer (zusammengesetzter) Wert sein, also ein Objekt. Für die Selektion reicht aber auf Fachverfahrensseite aus, eine Kurzbezeichnung zu sehen. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kurzbezeichnungDesWerts")
  public Optional<String> getKurzbezeichnungDesWerts() {
    return kurzbezeichnungDesWerts;
  }

  @JsonProperty("kurzbezeichnungDesWerts")
  public void setKurzbezeichnungDesWerts(Optional<String> kurzbezeichnungDesWerts) {
    this.kurzbezeichnungDesWerts = kurzbezeichnungDesWerts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AufzaehlungstypElement aufzaehlungstypElement = (AufzaehlungstypElement) o;
    return Objects.equals(this.schluessel, aufzaehlungstypElement.schluessel) &&
        Objects.equals(this.kurzbezeichnungDesWerts, aufzaehlungstypElement.kurzbezeichnungDesWerts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schluessel, kurzbezeichnungDesWerts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AufzaehlungstypElement {\n");
    sb.append("    schluessel: ").append(toIndentedString(schluessel)).append("\n");
    sb.append("    kurzbezeichnungDesWerts: ").append(toIndentedString(kurzbezeichnungDesWerts)).append("\n");
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


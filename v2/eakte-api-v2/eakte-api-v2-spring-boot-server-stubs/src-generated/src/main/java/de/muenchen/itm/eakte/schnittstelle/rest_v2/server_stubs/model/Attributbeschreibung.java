package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatenTyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AufzaehlungstypElement;
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
 * beschreibt die Metadaten eines Attributs
 */

@Schema(name = "Attributbeschreibung", description = "beschreibt die Metadaten eines Attributs")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Attributbeschreibung {

  private Optional<String> eigeneUrl = Optional.empty();

  private String referenzSchriftgutObjektklasseOderFormular;

  private String referenzAttribut;

  private String bezeichnung;

  private Optional<String> beschreibung = Optional.empty();

  private AttributDatenTyp datentyp;

  private Boolean pflichtFeld;

  private Integer maximaleTextLaenge = 0;

  @Valid
  private List<@Valid AufzaehlungstypElement> aufzaehlungswerte = new ArrayList<>();

  public Attributbeschreibung() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Attributbeschreibung(String referenzSchriftgutObjektklasseOderFormular, String referenzAttribut, String bezeichnung, AttributDatenTyp datentyp, Boolean pflichtFeld, Integer maximaleTextLaenge) {
    this.referenzSchriftgutObjektklasseOderFormular = referenzSchriftgutObjektklasseOderFormular;
    this.referenzAttribut = referenzAttribut;
    this.bezeichnung = bezeichnung;
    this.datentyp = datentyp;
    this.pflichtFeld = pflichtFeld;
    this.maximaleTextLaenge = maximaleTextLaenge;
  }

  public Attributbeschreibung eigeneUrl(String eigeneUrl) {
    this.eigeneUrl = Optional.ofNullable(eigeneUrl);
    return this;
  }

  /**
   * Eigene URI einer Ressource (Zeiger auf sich selbst) oder  URI einer referenzierten Ressource.\\ \\ URI = \"Uniform Resource Locator\" (siehe z.B. https://de.wikipedia.org/wiki/Uniform_Resource_Identifier)\\ \\ URIs sollen auf Seite des Service-Clients nicht interpretiert und auch nicht konstruiert werden. Sie werden so wie sie in einer vorhergehenden Service-Antwort enthalten waren unverändert  in einer neuen Service-Anfrage verwendet (als Request-URL oder in den Daten als Referenz-URI) 
   * @return eigeneUrl
   */
  
  @Schema(name = "eigeneUrl", example = "/v2/Ressourcen/ressourcenId", description = "Eigene URI einer Ressource (Zeiger auf sich selbst) oder  URI einer referenzierten Ressource.\\ \\ URI = \"Uniform Resource Locator\" (siehe z.B. https://de.wikipedia.org/wiki/Uniform_Resource_Identifier)\\ \\ URIs sollen auf Seite des Service-Clients nicht interpretiert und auch nicht konstruiert werden. Sie werden so wie sie in einer vorhergehenden Service-Antwort enthalten waren unverändert  in einer neuen Service-Anfrage verwendet (als Request-URL oder in den Daten als Referenz-URI) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eigeneUrl")
  public Optional<String> getEigeneUrl() {
    return eigeneUrl;
  }

  @JsonProperty("eigeneUrl")
  public void setEigeneUrl(Optional<String> eigeneUrl) {
    this.eigeneUrl = eigeneUrl;
  }

  public Attributbeschreibung referenzSchriftgutObjektklasseOderFormular(String referenzSchriftgutObjektklasseOderFormular) {
    this.referenzSchriftgutObjektklasseOderFormular = referenzSchriftgutObjektklasseOderFormular;
    return this;
  }

  /**
   * Referenz auf dir Stelle, wo das Attribut definiert bzw. zugeordnet wurde. Entweder eines aus { \"Aktenplaneintrag\", \"Akte\", \"Vorgang\", \"Dokument\", Schriftstück\" } oder  die COO-Adresse eines Formulars (\"category\" in Fabasoft-Terminologie) aus einer Definition für Verfahren 
   * @return referenzSchriftgutObjektklasseOderFormular
   */
  @NotNull 
  @Schema(name = "referenzSchriftgutObjektklasseOderFormular", example = "Akte", description = "Referenz auf dir Stelle, wo das Attribut definiert bzw. zugeordnet wurde. Entweder eines aus { \"Aktenplaneintrag\", \"Akte\", \"Vorgang\", \"Dokument\", Schriftstück\" } oder  die COO-Adresse eines Formulars (\"category\" in Fabasoft-Terminologie) aus einer Definition für Verfahren ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("referenzSchriftgutObjektklasseOderFormular")
  public String getReferenzSchriftgutObjektklasseOderFormular() {
    return referenzSchriftgutObjektklasseOderFormular;
  }

  @JsonProperty("referenzSchriftgutObjektklasseOderFormular")
  public void setReferenzSchriftgutObjektklasseOderFormular(String referenzSchriftgutObjektklasseOderFormular) {
    this.referenzSchriftgutObjektklasseOderFormular = referenzSchriftgutObjektklasseOderFormular;
  }

  public Attributbeschreibung referenzAttribut(String referenzAttribut) {
    this.referenzAttribut = referenzAttribut;
    return this;
  }

  /**
   * Referenz des Attributs in der eGov-Suite 
   * @return referenzAttribut
   */
  @NotNull 
  @Schema(name = "referenzAttribut", example = "COOELAK@1.1001:fielouobj", description = "Referenz des Attributs in der eGov-Suite ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("referenzAttribut")
  public String getReferenzAttribut() {
    return referenzAttribut;
  }

  @JsonProperty("referenzAttribut")
  public void setReferenzAttribut(String referenzAttribut) {
    this.referenzAttribut = referenzAttribut;
  }

  public Attributbeschreibung bezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
    return this;
  }

  /**
   * Deutsche Bezeichnung des Attributs 
   * @return bezeichnung
   */
  @NotNull 
  @Schema(name = "bezeichnung", example = "Aktenführenden Organisationseinheit", description = "Deutsche Bezeichnung des Attributs ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bezeichnung")
  public String getBezeichnung() {
    return bezeichnung;
  }

  @JsonProperty("bezeichnung")
  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public Attributbeschreibung beschreibung(String beschreibung) {
    this.beschreibung = Optional.ofNullable(beschreibung);
    return this;
  }

  /**
   * Beschreibung des Attributs 
   * @return beschreibung
   */
  
  @Schema(name = "beschreibung", example = "Beschreibung der Semantik des Attributs (umfänglich, ggf. mehrzeilig).", description = "Beschreibung des Attributs ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("beschreibung")
  public Optional<String> getBeschreibung() {
    return beschreibung;
  }

  @JsonProperty("beschreibung")
  public void setBeschreibung(Optional<String> beschreibung) {
    this.beschreibung = beschreibung;
  }

  public Attributbeschreibung datentyp(AttributDatenTyp datentyp) {
    this.datentyp = datentyp;
    return this;
  }

  /**
   * Get datentyp
   * @return datentyp
   */
  @NotNull @Valid 
  @Schema(name = "datentyp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("datentyp")
  public AttributDatenTyp getDatentyp() {
    return datentyp;
  }

  @JsonProperty("datentyp")
  public void setDatentyp(AttributDatenTyp datentyp) {
    this.datentyp = datentyp;
  }

  public Attributbeschreibung pflichtFeld(Boolean pflichtFeld) {
    this.pflichtFeld = pflichtFeld;
    return this;
  }

  /**
   * notwendiges Attribut
   * @return pflichtFeld
   */
  @NotNull 
  @Schema(name = "pflichtFeld", description = "notwendiges Attribut", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pflichtFeld")
  public Boolean getPflichtFeld() {
    return pflichtFeld;
  }

  @JsonProperty("pflichtFeld")
  public void setPflichtFeld(Boolean pflichtFeld) {
    this.pflichtFeld = pflichtFeld;
  }

  public Attributbeschreibung maximaleTextLaenge(Integer maximaleTextLaenge) {
    this.maximaleTextLaenge = maximaleTextLaenge;
    return this;
  }

  /**
   * zulässige Länge bei String-Datentypen (in UTF-8 Zeichen, nicht in Bytes!) 
   * @return maximaleTextLaenge
   */
  @NotNull 
  @Schema(name = "maximaleTextLaenge", description = "zulässige Länge bei String-Datentypen (in UTF-8 Zeichen, nicht in Bytes!) ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maximaleTextLaenge")
  public Integer getMaximaleTextLaenge() {
    return maximaleTextLaenge;
  }

  @JsonProperty("maximaleTextLaenge")
  public void setMaximaleTextLaenge(Integer maximaleTextLaenge) {
    this.maximaleTextLaenge = maximaleTextLaenge;
  }

  public Attributbeschreibung aufzaehlungswerte(List<@Valid AufzaehlungstypElement> aufzaehlungswerte) {
    this.aufzaehlungswerte = aufzaehlungswerte;
    return this;
  }

  public Attributbeschreibung addAufzaehlungswerteItem(AufzaehlungstypElement aufzaehlungswerteItem) {
    if (this.aufzaehlungswerte == null) {
      this.aufzaehlungswerte = new ArrayList<>();
    }
    this.aufzaehlungswerte.add(aufzaehlungswerteItem);
    return this;
  }

  /**
   * Get aufzaehlungswerte
   * @return aufzaehlungswerte
   */
  @Valid 
  @Schema(name = "aufzaehlungswerte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("aufzaehlungswerte")
  public List<@Valid AufzaehlungstypElement> getAufzaehlungswerte() {
    return aufzaehlungswerte;
  }

  @JsonProperty("aufzaehlungswerte")
  public void setAufzaehlungswerte(List<@Valid AufzaehlungstypElement> aufzaehlungswerte) {
    this.aufzaehlungswerte = aufzaehlungswerte;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attributbeschreibung attributbeschreibung = (Attributbeschreibung) o;
    return Objects.equals(this.eigeneUrl, attributbeschreibung.eigeneUrl) &&
        Objects.equals(this.referenzSchriftgutObjektklasseOderFormular, attributbeschreibung.referenzSchriftgutObjektklasseOderFormular) &&
        Objects.equals(this.referenzAttribut, attributbeschreibung.referenzAttribut) &&
        Objects.equals(this.bezeichnung, attributbeschreibung.bezeichnung) &&
        Objects.equals(this.beschreibung, attributbeschreibung.beschreibung) &&
        Objects.equals(this.datentyp, attributbeschreibung.datentyp) &&
        Objects.equals(this.pflichtFeld, attributbeschreibung.pflichtFeld) &&
        Objects.equals(this.maximaleTextLaenge, attributbeschreibung.maximaleTextLaenge) &&
        Objects.equals(this.aufzaehlungswerte, attributbeschreibung.aufzaehlungswerte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eigeneUrl, referenzSchriftgutObjektklasseOderFormular, referenzAttribut, bezeichnung, beschreibung, datentyp, pflichtFeld, maximaleTextLaenge, aufzaehlungswerte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attributbeschreibung {\n");
    sb.append("    eigeneUrl: ").append(toIndentedString(eigeneUrl)).append("\n");
    sb.append("    referenzSchriftgutObjektklasseOderFormular: ").append(toIndentedString(referenzSchriftgutObjektklasseOderFormular)).append("\n");
    sb.append("    referenzAttribut: ").append(toIndentedString(referenzAttribut)).append("\n");
    sb.append("    bezeichnung: ").append(toIndentedString(bezeichnung)).append("\n");
    sb.append("    beschreibung: ").append(toIndentedString(beschreibung)).append("\n");
    sb.append("    datentyp: ").append(toIndentedString(datentyp)).append("\n");
    sb.append("    pflichtFeld: ").append(toIndentedString(pflichtFeld)).append("\n");
    sb.append("    maximaleTextLaenge: ").append(toIndentedString(maximaleTextLaenge)).append("\n");
    sb.append("    aufzaehlungswerte: ").append(toIndentedString(aufzaehlungswerte)).append("\n");
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


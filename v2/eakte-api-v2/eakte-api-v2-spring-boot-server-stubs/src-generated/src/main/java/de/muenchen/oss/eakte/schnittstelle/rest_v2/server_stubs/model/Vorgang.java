package de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Repräsentation eines Vorgangs.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \&quot;Definition von Verfahren\&quot;) werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Vorgangsebene sowie die Standard-Attribute des Vorgangs zu erfahren, kann über den Endpunkt &#39;/v2/Attribute&#39; eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters &#39;Schriftgutebene&#x3D;Vorgang&#39;). 
 */

@Schema(name = "Vorgang", description = "Repräsentation eines Vorgangs.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \"Definition von Verfahren\") werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Vorgangsebene sowie die Standard-Attribute des Vorgangs zu erfahren, kann über den Endpunkt '/v2/Attribute' eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters 'Schriftgutebene=Vorgang'). ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Vorgang {

  private String id;

  private String sachakteId;

  private String name;

  private String langname;

  private Optional<String> betreff = Optional.empty();

  private Optional<String> geschaeftsgangvermerk = Optional.empty();

  /**
   * Gets or Sets originalMedium
   */
  public enum OriginalMediumEnum {
    ELEKTRONISCH("elektronisch"),
    
    HYBRID("hybrid"),
    
    PAPIER("papier");

    private final String value;

    OriginalMediumEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OriginalMediumEnum fromValue(String value) {
      for (OriginalMediumEnum b : OriginalMediumEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private OriginalMediumEnum originalMedium;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    IN_BEARBEITUNG("In Bearbeitung"),
    
    SUSPENDIERT("Suspendiert"),
    
    ABGESCHLOSSEN("Abgeschlossen"),
    
    STORNIERT("Storniert"),
    
    ARCHIVIERT("Archiviert");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private String bearbeitungsstatus;

  private String zugriffsdefinition;

  private String organisationseinheit;

  @Valid
  private Map<String, Object> eigenschaftenMap = new HashMap<>();

  @Valid
  private List<@Valid EigenschaftEintrag> eigenschaftenListe = new ArrayList<>();

  public Vorgang() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Vorgang(String id, String sachakteId, String name, String langname, OriginalMediumEnum originalMedium, StatusEnum status, String bearbeitungsstatus, String zugriffsdefinition, String organisationseinheit, Map<String, Object> eigenschaftenMap, List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.id = id;
    this.sachakteId = sachakteId;
    this.name = name;
    this.langname = langname;
    this.originalMedium = originalMedium;
    this.status = status;
    this.bearbeitungsstatus = bearbeitungsstatus;
    this.zugriffsdefinition = zugriffsdefinition;
    this.organisationseinheit = organisationseinheit;
    this.eigenschaftenMap = eigenschaftenMap;
    this.eigenschaftenListe = eigenschaftenListe;
  }

  public Vorgang id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public Vorgang sachakteId(String sachakteId) {
    this.sachakteId = sachakteId;
    return this;
  }

  /**
   * Get sachakteId
   * @return sachakteId
   */
  @NotNull 
  @Schema(name = "sachakteId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sachakteId")
  public String getSachakteId() {
    return sachakteId;
  }

  @JsonProperty("sachakteId")
  public void setSachakteId(String sachakteId) {
    this.sachakteId = sachakteId;
  }

  public Vorgang name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public Vorgang langname(String langname) {
    this.langname = langname;
    return this;
  }

  /**
   * Get langname
   * @return langname
   */
  @NotNull 
  @Schema(name = "langname", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("langname")
  public String getLangname() {
    return langname;
  }

  @JsonProperty("langname")
  public void setLangname(String langname) {
    this.langname = langname;
  }

  public Vorgang betreff(String betreff) {
    this.betreff = Optional.ofNullable(betreff);
    return this;
  }

  /**
   * Get betreff
   * @return betreff
   */
  
  @Schema(name = "betreff", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("betreff")
  public Optional<String> getBetreff() {
    return betreff;
  }

  @JsonProperty("betreff")
  public void setBetreff(Optional<String> betreff) {
    this.betreff = betreff;
  }

  public Vorgang geschaeftsgangvermerk(String geschaeftsgangvermerk) {
    this.geschaeftsgangvermerk = Optional.ofNullable(geschaeftsgangvermerk);
    return this;
  }

  /**
   * Geschäftsgangvermerk für Prozessverantwortlichen
   * @return geschaeftsgangvermerk
   */
  
  @Schema(name = "geschaeftsgangvermerk", example = "Warte auf Rückmeldung", description = "Geschäftsgangvermerk für Prozessverantwortlichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("geschaeftsgangvermerk")
  public Optional<String> getGeschaeftsgangvermerk() {
    return geschaeftsgangvermerk;
  }

  @JsonProperty("geschaeftsgangvermerk")
  public void setGeschaeftsgangvermerk(Optional<String> geschaeftsgangvermerk) {
    this.geschaeftsgangvermerk = geschaeftsgangvermerk;
  }

  public Vorgang originalMedium(OriginalMediumEnum originalMedium) {
    this.originalMedium = originalMedium;
    return this;
  }

  /**
   * Get originalMedium
   * @return originalMedium
   */
  @NotNull 
  @Schema(name = "originalMedium", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("originalMedium")
  public OriginalMediumEnum getOriginalMedium() {
    return originalMedium;
  }

  @JsonProperty("originalMedium")
  public void setOriginalMedium(OriginalMediumEnum originalMedium) {
    this.originalMedium = originalMedium;
  }

  public Vorgang status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Vorgang bearbeitungsstatus(String bearbeitungsstatus) {
    this.bearbeitungsstatus = bearbeitungsstatus;
    return this;
  }

  /**
   * Get bearbeitungsstatus
   * @return bearbeitungsstatus
   */
  @NotNull 
  @Schema(name = "bearbeitungsstatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bearbeitungsstatus")
  public String getBearbeitungsstatus() {
    return bearbeitungsstatus;
  }

  @JsonProperty("bearbeitungsstatus")
  public void setBearbeitungsstatus(String bearbeitungsstatus) {
    this.bearbeitungsstatus = bearbeitungsstatus;
  }

  public Vorgang zugriffsdefinition(String zugriffsdefinition) {
    this.zugriffsdefinition = zugriffsdefinition;
    return this;
  }

  /**
   * Get zugriffsdefinition
   * @return zugriffsdefinition
   */
  @NotNull 
  @Schema(name = "zugriffsdefinition", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("zugriffsdefinition")
  public String getZugriffsdefinition() {
    return zugriffsdefinition;
  }

  @JsonProperty("zugriffsdefinition")
  public void setZugriffsdefinition(String zugriffsdefinition) {
    this.zugriffsdefinition = zugriffsdefinition;
  }

  public Vorgang organisationseinheit(String organisationseinheit) {
    this.organisationseinheit = organisationseinheit;
    return this;
  }

  /**
   * Get organisationseinheit
   * @return organisationseinheit
   */
  @NotNull 
  @Schema(name = "organisationseinheit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organisationseinheit")
  public String getOrganisationseinheit() {
    return organisationseinheit;
  }

  @JsonProperty("organisationseinheit")
  public void setOrganisationseinheit(String organisationseinheit) {
    this.organisationseinheit = organisationseinheit;
  }

  public Vorgang eigenschaftenMap(Map<String, Object> eigenschaftenMap) {
    this.eigenschaftenMap = eigenschaftenMap;
    return this;
  }

  public Vorgang putEigenschaftenMapItem(String key, Object eigenschaftenMapItem) {
    if (this.eigenschaftenMap == null) {
      this.eigenschaftenMap = new HashMap<>();
    }
    this.eigenschaftenMap.put(key, eigenschaftenMapItem);
    return this;
  }

  /**
   * Get eigenschaftenMap
   * @return eigenschaftenMap
   */
  @NotNull 
  @Schema(name = "eigenschaftenMap", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaftenMap")
  public Map<String, Object> getEigenschaftenMap() {
    return eigenschaftenMap;
  }

  @JsonProperty("eigenschaftenMap")
  public void setEigenschaftenMap(Map<String, Object> eigenschaftenMap) {
    this.eigenschaftenMap = eigenschaftenMap;
  }

  public Vorgang eigenschaftenListe(List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.eigenschaftenListe = eigenschaftenListe;
    return this;
  }

  public Vorgang addEigenschaftenListeItem(EigenschaftEintrag eigenschaftenListeItem) {
    if (this.eigenschaftenListe == null) {
      this.eigenschaftenListe = new ArrayList<>();
    }
    this.eigenschaftenListe.add(eigenschaftenListeItem);
    return this;
  }

  /**
   * Get eigenschaftenListe
   * @return eigenschaftenListe
   */
  @NotNull @Valid 
  @Schema(name = "eigenschaftenListe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaftenListe")
  public List<@Valid EigenschaftEintrag> getEigenschaftenListe() {
    return eigenschaftenListe;
  }

  @JsonProperty("eigenschaftenListe")
  public void setEigenschaftenListe(List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.eigenschaftenListe = eigenschaftenListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vorgang vorgang = (Vorgang) o;
    return Objects.equals(this.id, vorgang.id) &&
        Objects.equals(this.sachakteId, vorgang.sachakteId) &&
        Objects.equals(this.name, vorgang.name) &&
        Objects.equals(this.langname, vorgang.langname) &&
        Objects.equals(this.betreff, vorgang.betreff) &&
        Objects.equals(this.geschaeftsgangvermerk, vorgang.geschaeftsgangvermerk) &&
        Objects.equals(this.originalMedium, vorgang.originalMedium) &&
        Objects.equals(this.status, vorgang.status) &&
        Objects.equals(this.bearbeitungsstatus, vorgang.bearbeitungsstatus) &&
        Objects.equals(this.zugriffsdefinition, vorgang.zugriffsdefinition) &&
        Objects.equals(this.organisationseinheit, vorgang.organisationseinheit) &&
        Objects.equals(this.eigenschaftenMap, vorgang.eigenschaftenMap) &&
        Objects.equals(this.eigenschaftenListe, vorgang.eigenschaftenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sachakteId, name, langname, betreff, geschaeftsgangvermerk, originalMedium, status, bearbeitungsstatus, zugriffsdefinition, organisationseinheit, eigenschaftenMap, eigenschaftenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vorgang {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sachakteId: ").append(toIndentedString(sachakteId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    langname: ").append(toIndentedString(langname)).append("\n");
    sb.append("    betreff: ").append(toIndentedString(betreff)).append("\n");
    sb.append("    geschaeftsgangvermerk: ").append(toIndentedString(geschaeftsgangvermerk)).append("\n");
    sb.append("    originalMedium: ").append(toIndentedString(originalMedium)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    bearbeitungsstatus: ").append(toIndentedString(bearbeitungsstatus)).append("\n");
    sb.append("    zugriffsdefinition: ").append(toIndentedString(zugriffsdefinition)).append("\n");
    sb.append("    organisationseinheit: ").append(toIndentedString(organisationseinheit)).append("\n");
    sb.append("    eigenschaftenMap: ").append(toIndentedString(eigenschaftenMap)).append("\n");
    sb.append("    eigenschaftenListe: ").append(toIndentedString(eigenschaftenListe)).append("\n");
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

    private Vorgang instance;

    public Builder() {
      this(new Vorgang());
    }

    protected Builder(Vorgang instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Vorgang value) { 
      this.instance.setId(value.id);
      this.instance.setSachakteId(value.sachakteId);
      this.instance.setName(value.name);
      this.instance.setLangname(value.langname);
      this.instance.setBetreff(value.betreff);
      this.instance.setGeschaeftsgangvermerk(value.geschaeftsgangvermerk);
      this.instance.setOriginalMedium(value.originalMedium);
      this.instance.setStatus(value.status);
      this.instance.setBearbeitungsstatus(value.bearbeitungsstatus);
      this.instance.setZugriffsdefinition(value.zugriffsdefinition);
      this.instance.setOrganisationseinheit(value.organisationseinheit);
      this.instance.setEigenschaftenMap(value.eigenschaftenMap);
      this.instance.setEigenschaftenListe(value.eigenschaftenListe);
      return this;
    }

    public Vorgang.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    public Vorgang.Builder sachakteId(String sachakteId) {
      this.instance.sachakteId(sachakteId);
      return this;
    }
    
    public Vorgang.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public Vorgang.Builder langname(String langname) {
      this.instance.langname(langname);
      return this;
    }
    
    public Vorgang.Builder betreff(String betreff) {
      this.instance.betreff(betreff);
      return this;
    }
    
    public Vorgang.Builder geschaeftsgangvermerk(String geschaeftsgangvermerk) {
      this.instance.geschaeftsgangvermerk(geschaeftsgangvermerk);
      return this;
    }
    
    public Vorgang.Builder originalMedium(OriginalMediumEnum originalMedium) {
      this.instance.originalMedium(originalMedium);
      return this;
    }
    
    public Vorgang.Builder status(StatusEnum status) {
      this.instance.status(status);
      return this;
    }
    
    public Vorgang.Builder bearbeitungsstatus(String bearbeitungsstatus) {
      this.instance.bearbeitungsstatus(bearbeitungsstatus);
      return this;
    }
    
    public Vorgang.Builder zugriffsdefinition(String zugriffsdefinition) {
      this.instance.zugriffsdefinition(zugriffsdefinition);
      return this;
    }
    
    public Vorgang.Builder organisationseinheit(String organisationseinheit) {
      this.instance.organisationseinheit(organisationseinheit);
      return this;
    }
    
    public Vorgang.Builder eigenschaftenMap(Map<String, Object> eigenschaftenMap) {
      this.instance.eigenschaftenMap(eigenschaftenMap);
      return this;
    }
    
    public Vorgang.Builder eigenschaftenListe(List<EigenschaftEintrag> eigenschaftenListe) {
      this.instance.eigenschaftenListe(eigenschaftenListe);
      return this;
    }
    
    /**
    * returns a built Vorgang instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Vorgang build() {
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
  public static Vorgang.Builder builder() {
    return new Vorgang.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Vorgang.Builder toBuilder() {
    Vorgang.Builder builder = new Vorgang.Builder();
    return builder.copyOf(this);
  }

}


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributEintrag;
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
 * Repräsentation eines Vorgangs.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \&quot;Definition von Verfahren\&quot;) werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. Um eine einheitliche Behandlung von Standard- und Custom-Attributen zu ermöglichen,  werden auch die Standard-Attribute in der &#39;attributListe&#39; zurückgegeben.\\ \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Vorgangsebene sowie die Standard-Attribute des Vorgangs zu erfahren, kann über den Endpunkt &#39;/v2/Attribute&#39; eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters &#39;Schriftgutebene&#x3D;Vorgang&#39;). 
 */

@Schema(name = "Vorgang", description = "Repräsentation eines Vorgangs.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \"Definition von Verfahren\") werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. Um eine einheitliche Behandlung von Standard- und Custom-Attributen zu ermöglichen,  werden auch die Standard-Attribute in der 'attributListe' zurückgegeben.\\ \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Vorgangsebene sowie die Standard-Attribute des Vorgangs zu erfahren, kann über den Endpunkt '/v2/Attribute' eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters 'Schriftgutebene=Vorgang'). ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Vorgang {

  private String id;

  private String sachakteId;

  private String name;

  private Optional<String> betreff = Optional.empty();

  @Valid
  private Map<String, Object> attributeMap = new HashMap<>();

  @Valid
  private List<@Valid AttributEintrag> attributeListe = new ArrayList<>();

  public Vorgang() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Vorgang(String id, String sachakteId, String name, Map<String, Object> attributeMap, List<@Valid AttributEintrag> attributeListe) {
    this.id = id;
    this.sachakteId = sachakteId;
    this.name = name;
    this.attributeMap = attributeMap;
    this.attributeListe = attributeListe;
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
  @Schema(name = "sachakte_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sachakte_id")
  public String getSachakteId() {
    return sachakteId;
  }

  @JsonProperty("sachakte_id")
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

  public Vorgang attributeMap(Map<String, Object> attributeMap) {
    this.attributeMap = attributeMap;
    return this;
  }

  public Vorgang putAttributeMapItem(String key, Object attributeMapItem) {
    if (this.attributeMap == null) {
      this.attributeMap = new HashMap<>();
    }
    this.attributeMap.put(key, attributeMapItem);
    return this;
  }

  /**
   * Get attributeMap
   * @return attributeMap
   */
  @NotNull 
  @Schema(name = "attributeMap", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributeMap")
  public Map<String, Object> getAttributeMap() {
    return attributeMap;
  }

  @JsonProperty("attributeMap")
  public void setAttributeMap(Map<String, Object> attributeMap) {
    this.attributeMap = attributeMap;
  }

  public Vorgang attributeListe(List<@Valid AttributEintrag> attributeListe) {
    this.attributeListe = attributeListe;
    return this;
  }

  public Vorgang addAttributeListeItem(AttributEintrag attributeListeItem) {
    if (this.attributeListe == null) {
      this.attributeListe = new ArrayList<>();
    }
    this.attributeListe.add(attributeListeItem);
    return this;
  }

  /**
   * Get attributeListe
   * @return attributeListe
   */
  @NotNull @Valid 
  @Schema(name = "attributeListe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributeListe")
  public List<@Valid AttributEintrag> getAttributeListe() {
    return attributeListe;
  }

  @JsonProperty("attributeListe")
  public void setAttributeListe(List<@Valid AttributEintrag> attributeListe) {
    this.attributeListe = attributeListe;
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
        Objects.equals(this.betreff, vorgang.betreff) &&
        Objects.equals(this.attributeMap, vorgang.attributeMap) &&
        Objects.equals(this.attributeListe, vorgang.attributeListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sachakteId, name, betreff, attributeMap, attributeListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vorgang {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sachakteId: ").append(toIndentedString(sachakteId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    betreff: ").append(toIndentedString(betreff)).append("\n");
    sb.append("    attributeMap: ").append(toIndentedString(attributeMap)).append("\n");
    sb.append("    attributeListe: ").append(toIndentedString(attributeListe)).append("\n");
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


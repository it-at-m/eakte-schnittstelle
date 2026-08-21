package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
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
  private Map<String, Object> eigenschaftenMap = new HashMap<>();

  @Valid
  private List<@Valid EigenschaftEintrag> eigenschaftenListe = new ArrayList<>();

  public Vorgang() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Vorgang(String id, String sachakteId, String name, Map<String, Object> eigenschaftenMap, List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.id = id;
    this.sachakteId = sachakteId;
    this.name = name;
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
  @Schema(name = "eigenschaften_map", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaften_map")
  public Map<String, Object> getEigenschaftenMap() {
    return eigenschaftenMap;
  }

  @JsonProperty("eigenschaften_map")
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
  @Schema(name = "eigenschaften_liste", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaften_liste")
  public List<@Valid EigenschaftEintrag> getEigenschaftenListe() {
    return eigenschaftenListe;
  }

  @JsonProperty("eigenschaften_liste")
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
        Objects.equals(this.betreff, vorgang.betreff) &&
        Objects.equals(this.eigenschaftenMap, vorgang.eigenschaftenMap) &&
        Objects.equals(this.eigenschaftenListe, vorgang.eigenschaftenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sachakteId, name, betreff, eigenschaftenMap, eigenschaftenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vorgang {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sachakteId: ").append(toIndentedString(sachakteId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    betreff: ").append(toIndentedString(betreff)).append("\n");
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
      this.instance.setBetreff(value.betreff);
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
    
    public Vorgang.Builder betreff(String betreff) {
      this.instance.betreff(betreff);
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


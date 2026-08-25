package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
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
 * Repräsentation einer Akte.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \&quot;Definition von Verfahren\&quot;) werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. Um eine einheitliche Behandlung von Standard- und Custom-Attributen zu ermöglichen,  werden auch die Standard-Attribute in der &#39;attributListe&#39; zurückgegeben.\\ \\ Beachte, dass für alle gespeicherten Akten das Attribut &#39;eigeneUrl&#39; garantiert  zurückgeliefert wird. Es ist nur deshalb nicht als Pflichtattribut deklariert, damit diese Ressourcendefinition auch für das Anlegen einer neuen Akte verwendet werden kann, wenn noch keine URL vom System vergeben wurde.  \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Aktenebene sowie die Standard-Attribute der Akte zu erfahren, kann über den Endpunkt &#39;/v2/Attribute&#39; eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters &#39;Schriftgutebene&#x3D;Akte&#39;). 
 */

@Schema(name = "Akte", description = "Repräsentation einer Akte.\\ Aufgrund der Konfigurierbarkeit der Attribute (verfahrensabhängige Metadaten, siehe Fabasoft eGov-Suite \"Definition von Verfahren\") werden diese in einer dynamisch  aufgebauten Liste geführt und nichts als Felder in einer fixen (JSON-) Datenstruktur. Um eine einheitliche Behandlung von Standard- und Custom-Attributen zu ermöglichen,  werden auch die Standard-Attribute in der 'attributListe' zurückgegeben.\\ \\ Beachte, dass für alle gespeicherten Akten das Attribut 'eigeneUrl' garantiert  zurückgeliefert wird. Es ist nur deshalb nicht als Pflichtattribut deklariert, damit diese Ressourcendefinition auch für das Anlegen einer neuen Akte verwendet werden kann, wenn noch keine URL vom System vergeben wurde.  \\ Um die innerhalb einer bestimmten Betreffseinheit verfügbaren Custom-Attribute auf Aktenebene sowie die Standard-Attribute der Akte zu erfahren, kann über den Endpunkt '/v2/Attribute' eine Abfrage (GET-Methode) getätigt werden (s. Spezifikation dieses Endpunktes, in diesem Fall die Verwendung des Filters 'Schriftgutebene=Akte'). ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Akte {

  private Optional<String> eigeneUrl = Optional.empty();

  @Valid
  private List<@Valid AttributUriUndWert> attributListe = new ArrayList<>();

  public Akte() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Akte(List<@Valid AttributUriUndWert> attributListe) {
    this.attributListe = attributListe;
  }

  public Akte eigeneUrl(String eigeneUrl) {
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

  public Akte attributListe(List<@Valid AttributUriUndWert> attributListe) {
    this.attributListe = attributListe;
    return this;
  }

  public Akte addAttributListeItem(AttributUriUndWert attributListeItem) {
    if (this.attributListe == null) {
      this.attributListe = new ArrayList<>();
    }
    this.attributListe.add(attributListeItem);
    return this;
  }

  /**
   * Get attributListe
   * @return attributListe
   */
  @NotNull @Valid 
  @Schema(name = "attributListe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("attributListe")
  public List<@Valid AttributUriUndWert> getAttributListe() {
    return attributListe;
  }

  @JsonProperty("attributListe")
  public void setAttributListe(List<@Valid AttributUriUndWert> attributListe) {
    this.attributListe = attributListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Akte akte = (Akte) o;
    return Objects.equals(this.eigeneUrl, akte.eigeneUrl) &&
        Objects.equals(this.attributListe, akte.attributListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eigeneUrl, attributListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Akte {\n");
    sb.append("    eigeneUrl: ").append(toIndentedString(eigeneUrl)).append("\n");
    sb.append("    attributListe: ").append(toIndentedString(attributListe)).append("\n");
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

    private Akte instance;

    public Builder() {
      this(new Akte());
    }

    protected Builder(Akte instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Akte value) { 
      this.instance.setEigeneUrl(value.eigeneUrl);
      this.instance.setAttributListe(value.attributListe);
      return this;
    }

    public Akte.Builder eigeneUrl(String eigeneUrl) {
      this.instance.eigeneUrl(eigeneUrl);
      return this;
    }
    
    public Akte.Builder attributListe(List<AttributUriUndWert> attributListe) {
      this.instance.attributListe(attributListe);
      return this;
    }
    
    /**
    * returns a built Akte instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Akte build() {
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
  public static Akte.Builder builder() {
    return new Akte.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Akte.Builder toBuilder() {
    Akte.Builder builder = new Akte.Builder();
    return builder.copyOf(this);
  }

}


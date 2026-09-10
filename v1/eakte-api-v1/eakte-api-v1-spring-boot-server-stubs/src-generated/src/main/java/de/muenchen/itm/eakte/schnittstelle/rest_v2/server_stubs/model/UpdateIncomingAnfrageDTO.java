package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Parameter, die den Eingang spezifizieren
 */

@Schema(name = "UpdateIncomingAnfrageDTO", description = "Parameter, die den Eingang spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateIncomingAnfrageDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private Optional<String> foreignnr = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> delivery = Optional.empty();

  private Optional<String> documentremarks = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  public UpdateIncomingAnfrageDTO shortname(String shortname) {
    this.shortname = Optional.ofNullable(shortname);
    return this;
  }

  /**
   * Titel
   * @return shortname
   */
  
  @Schema(name = "shortname", example = "2016 Anträge Firma XY", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortname")
  public Optional<String> getShortname() {
    return shortname;
  }

  @JsonProperty("shortname")
  public void setShortname(Optional<String> shortname) {
    this.shortname = shortname;
  }

  public UpdateIncomingAnfrageDTO filesubj(String filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Betreff (mehrzeilig)<br> Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &amp;#10; in Abfragen unterstützt. 
   * @return filesubj
   */
  
  @Schema(name = "filesubj", example = "Alle Anträge der Firma XY aus dem Jahr 2016", description = "Betreff (mehrzeilig)<br> Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &amp;#10; in Abfragen unterstützt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public Optional<String> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(Optional<String> filesubj) {
    this.filesubj = filesubj;
  }

  public UpdateIncomingAnfrageDTO objterms(String objterms) {
    this.objterms = Optional.ofNullable(objterms);
    return this;
  }

  /**
   * Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben.  Hinweis:<br> Aktuell ist es für Benutzer*innen nicht möglich, Schlagworte über die Schnittstelle anzulegen oder zu ändern. Bereits vorhandene Schlagworte in der eAkte können verwendet werden.<br> Dazu gibt es einen gemeinsamen Katalog von Schlagworten für Akten, Vorgänge,  die je OE durch Sachbearbeiter in der GUI angelegt werden können.<br> Wenn übergebene Schlagworte nicht gefunden werden, wird keine Fehlermeldung zurückgegeben. Das Anlegen erfolgt dann ohne die angegebenen Schlagworte.  Es ist in der Fachabteilung zu klären, ob und welche Schlagworte im Fachverfahren genutzt werden,  damit sie in der Akte vorab angelegt werden.<br> Für die Schnittstelle kann eine spezifische Schlagwortliste (Oberbegriff, z.B. \"Koi-Schlagworte\")  über die generische Suche abgerufen werden und  für die Verschlagwortung von Schriftgutobjekten im Fachverfahren verwendet werden. 
   * @return objterms
   */
  
  @Schema(name = "objterms", example = "Firma XY; Anträge; Anträge 2016", description = "Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben.  Hinweis:<br> Aktuell ist es für Benutzer*innen nicht möglich, Schlagworte über die Schnittstelle anzulegen oder zu ändern. Bereits vorhandene Schlagworte in der eAkte können verwendet werden.<br> Dazu gibt es einen gemeinsamen Katalog von Schlagworten für Akten, Vorgänge,  die je OE durch Sachbearbeiter in der GUI angelegt werden können.<br> Wenn übergebene Schlagworte nicht gefunden werden, wird keine Fehlermeldung zurückgegeben. Das Anlegen erfolgt dann ohne die angegebenen Schlagworte.  Es ist in der Fachabteilung zu klären, ob und welche Schlagworte im Fachverfahren genutzt werden,  damit sie in der Akte vorab angelegt werden.<br> Für die Schnittstelle kann eine spezifische Schlagwortliste (Oberbegriff, z.B. \"Koi-Schlagworte\")  über die generische Suche abgerufen werden und  für die Verschlagwortung von Schriftgutobjekten im Fachverfahren verwendet werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objterms")
  public Optional<String> getObjterms() {
    return objterms;
  }

  @JsonProperty("objterms")
  public void setObjterms(Optional<String> objterms) {
    this.objterms = objterms;
  }

  public UpdateIncomingAnfrageDTO accdef(String accdef) {
    this.accdef = Optional.ofNullable(accdef);
    return this;
  }

  /**
   * Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). Wenn eine Akte über die SST angelegt wird und  am Aktenplaneintrag zusätzlich berechtigte OE's eingetragen wurden  (im Reiter \"Sicherheitseinstellungen\" des Aktenplaneintrags),  dann wird die Zugriffsdefinition \"Aktengebunden\" automatisch für Vorgänge gesetzt. 
   * @return accdef
   */
  
  @Schema(name = "accdef", example = "Eigener Mandant", description = "Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). Wenn eine Akte über die SST angelegt wird und  am Aktenplaneintrag zusätzlich berechtigte OE's eingetragen wurden  (im Reiter \"Sicherheitseinstellungen\" des Aktenplaneintrags),  dann wird die Zugriffsdefinition \"Aktengebunden\" automatisch für Vorgänge gesetzt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accdef")
  public Optional<String> getAccdef() {
    return accdef;
  }

  @JsonProperty("accdef")
  public void setAccdef(Optional<String> accdef) {
    this.accdef = accdef;
  }

  public UpdateIncomingAnfrageDTO foreignnr(String foreignnr) {
    this.foreignnr = Optional.ofNullable(foreignnr);
    return this;
  }

  /**
   * Fremdes Geschäftszeichen<br> In diesem Feld kann - falls erforderlich - das Geschäftszeichen einer anderen Organisation eingetragen werden. 
   * @return foreignnr
   */
  
  @Schema(name = "foreignnr", example = "A2016-10-2016-Landeshauptstadt-München", description = "Fremdes Geschäftszeichen<br> In diesem Feld kann - falls erforderlich - das Geschäftszeichen einer anderen Organisation eingetragen werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("foreignnr")
  public Optional<String> getForeignnr() {
    return foreignnr;
  }

  @JsonProperty("foreignnr")
  public void setForeignnr(Optional<String> foreignnr) {
    this.foreignnr = foreignnr;
  }

  public UpdateIncomingAnfrageDTO delivery(OffsetDateTime delivery) {
    this.delivery = Optional.ofNullable(delivery);
    return this;
  }

  /**
   * Eingangsdatum des Objekts<br> In diesem Feld wird vermerkt, wann das Dokument eingegangen ist. 
   * @return delivery
   */
  @Valid 
  @Schema(name = "delivery", description = "Eingangsdatum des Objekts<br> In diesem Feld wird vermerkt, wann das Dokument eingegangen ist. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("delivery")
  public Optional<OffsetDateTime> getDelivery() {
    return delivery;
  }

  @JsonProperty("delivery")
  public void setDelivery(Optional<OffsetDateTime> delivery) {
    this.delivery = delivery;
  }

  public UpdateIncomingAnfrageDTO documentremarks(String documentremarks) {
    this.documentremarks = Optional.ofNullable(documentremarks);
    return this;
  }

  /**
   * Dokumentbezogene Hinweise
   * @return documentremarks
   */
  
  @Schema(name = "documentremarks", example = "Antrag auf Baugenehmigung", description = "Dokumentbezogene Hinweise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentremarks")
  public Optional<String> getDocumentremarks() {
    return documentremarks;
  }

  @JsonProperty("documentremarks")
  public void setDocumentremarks(Optional<String> documentremarks) {
    this.documentremarks = documentremarks;
  }

  public UpdateIncomingAnfrageDTO incattachments(String incattachments) {
    this.incattachments = Optional.ofNullable(incattachments);
    return this;
  }

  /**
   * Sonstige Anlagen
   * @return incattachments
   */
  
  @Schema(name = "incattachments", example = "Bebauungsplan", description = "Sonstige Anlagen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incattachments")
  public Optional<String> getIncattachments() {
    return incattachments;
  }

  @JsonProperty("incattachments")
  public void setIncattachments(Optional<String> incattachments) {
    this.incattachments = incattachments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateIncomingAnfrageDTO updateIncomingAnfrageDTO = (UpdateIncomingAnfrageDTO) o;
    return Objects.equals(this.shortname, updateIncomingAnfrageDTO.shortname) &&
        Objects.equals(this.filesubj, updateIncomingAnfrageDTO.filesubj) &&
        Objects.equals(this.objterms, updateIncomingAnfrageDTO.objterms) &&
        Objects.equals(this.accdef, updateIncomingAnfrageDTO.accdef) &&
        Objects.equals(this.foreignnr, updateIncomingAnfrageDTO.foreignnr) &&
        Objects.equals(this.delivery, updateIncomingAnfrageDTO.delivery) &&
        Objects.equals(this.documentremarks, updateIncomingAnfrageDTO.documentremarks) &&
        Objects.equals(this.incattachments, updateIncomingAnfrageDTO.incattachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, foreignnr, delivery, documentremarks, incattachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateIncomingAnfrageDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    foreignnr: ").append(toIndentedString(foreignnr)).append("\n");
    sb.append("    delivery: ").append(toIndentedString(delivery)).append("\n");
    sb.append("    documentremarks: ").append(toIndentedString(documentremarks)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
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

    private UpdateIncomingAnfrageDTO instance;

    public Builder() {
      this(new UpdateIncomingAnfrageDTO());
    }

    protected Builder(UpdateIncomingAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateIncomingAnfrageDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setForeignnr(value.foreignnr);
      this.instance.setDelivery(value.delivery);
      this.instance.setDocumentremarks(value.documentremarks);
      this.instance.setIncattachments(value.incattachments);
      return this;
    }

    public UpdateIncomingAnfrageDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder foreignnr(String foreignnr) {
      this.instance.foreignnr(foreignnr);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder delivery(OffsetDateTime delivery) {
      this.instance.delivery(delivery);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder documentremarks(String documentremarks) {
      this.instance.documentremarks(documentremarks);
      return this;
    }
    
    public UpdateIncomingAnfrageDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    /**
    * returns a built UpdateIncomingAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateIncomingAnfrageDTO build() {
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
  public static UpdateIncomingAnfrageDTO.Builder builder() {
    return new UpdateIncomingAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateIncomingAnfrageDTO.Builder toBuilder() {
    UpdateIncomingAnfrageDTO.Builder builder = new UpdateIncomingAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


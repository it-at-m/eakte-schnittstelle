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
 * Parameter die den Ausgang spezifizieren
 */

@Schema(name = "UpdateOutgoingRequestDTO", description = "Parameter die den Ausgang spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateOutgoingRequestDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private Optional<String> referredincoming = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> outgoingdate = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  public UpdateOutgoingRequestDTO shortname(String shortname) {
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

  public UpdateOutgoingRequestDTO filesubj(String filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Betreff (mehrzeilig)\\ Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &#10; in Abfragen unterstützt. 
   * @return filesubj
   */
  
  @Schema(name = "filesubj", example = "Alle Anträge der Firma XY aus dem Jahr 2016", description = "Betreff (mehrzeilig)\\ Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &#10; in Abfragen unterstützt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public Optional<String> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(Optional<String> filesubj) {
    this.filesubj = filesubj;
  }

  public UpdateOutgoingRequestDTO objterms(String objterms) {
    this.objterms = Optional.ofNullable(objterms);
    return this;
  }

  /**
   * Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben.  Hinweis:\\ Aktuell ist es für Benutzer*innen nicht möglich, Schlagworte über die Schnittstelle anzulegen oder zu ändern. Bereits vorhandene Schlagworte in der eAkte können verwendet werden.\\ Dazu gibt es einen gemeinsamen Katalog von Schlagworten für Akten, Vorgänge,  die je OE durch Sachbearbeiter in der GUI angelegt werden können.\\ Wenn übergebene Schlagworte nicht gefunden werden, wird keine Fehlermeldung zurückgegeben. Das Anlegen erfolgt dann ohne die angegebenen Schlagworte.  Es ist in der Fachabteilung zu klären, ob und welche Schlagworte im Fachverfahren genutzt werden,  damit sie in der Akte vorab angelegt werden.\\ Für die Schnittstelle kann eine spezifische Schlagwortliste (Oberbegriff, z.B. \"Koi-Schlagworte\")  über die generische Suche abgerufen werden und  für die Verschlagwortung von Schriftgutobjekten im Fachverfahren verwendet werden. 
   * @return objterms
   */
  
  @Schema(name = "objterms", example = "Firma XY; Anträge; Anträge 2016", description = "Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben.  Hinweis:\\ Aktuell ist es für Benutzer*innen nicht möglich, Schlagworte über die Schnittstelle anzulegen oder zu ändern. Bereits vorhandene Schlagworte in der eAkte können verwendet werden.\\ Dazu gibt es einen gemeinsamen Katalog von Schlagworten für Akten, Vorgänge,  die je OE durch Sachbearbeiter in der GUI angelegt werden können.\\ Wenn übergebene Schlagworte nicht gefunden werden, wird keine Fehlermeldung zurückgegeben. Das Anlegen erfolgt dann ohne die angegebenen Schlagworte.  Es ist in der Fachabteilung zu klären, ob und welche Schlagworte im Fachverfahren genutzt werden,  damit sie in der Akte vorab angelegt werden.\\ Für die Schnittstelle kann eine spezifische Schlagwortliste (Oberbegriff, z.B. \"Koi-Schlagworte\")  über die generische Suche abgerufen werden und  für die Verschlagwortung von Schriftgutobjekten im Fachverfahren verwendet werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objterms")
  public Optional<String> getObjterms() {
    return objterms;
  }

  @JsonProperty("objterms")
  public void setObjterms(Optional<String> objterms) {
    this.objterms = objterms;
  }

  public UpdateOutgoingRequestDTO accdef(String accdef) {
    this.accdef = Optional.ofNullable(accdef);
    return this;
  }

  /**
   * Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). 
   * @return accdef
   */
  
  @Schema(name = "accdef", example = "Eigener Mandant", description = "Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accdef")
  public Optional<String> getAccdef() {
    return accdef;
  }

  @JsonProperty("accdef")
  public void setAccdef(Optional<String> accdef) {
    this.accdef = accdef;
  }

  public UpdateOutgoingRequestDTO referredincoming(String referredincoming) {
    this.referredincoming = Optional.ofNullable(referredincoming);
    return this;
  }

  /**
   * Bezug zum Eingang\\ Bei Bedarf kann die COO-Adresse des Eingangs geändert werden, damit ein direkter Bezug zwischen Eingang und Erledigung hergestellt werden kann. 
   * @return referredincoming
   */
  
  @Schema(name = "referredincoming", example = "COO.1.2301.1.1042441", description = "Bezug zum Eingang\\ Bei Bedarf kann die COO-Adresse des Eingangs geändert werden, damit ein direkter Bezug zwischen Eingang und Erledigung hergestellt werden kann. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referredincoming")
  public Optional<String> getReferredincoming() {
    return referredincoming;
  }

  @JsonProperty("referredincoming")
  public void setReferredincoming(Optional<String> referredincoming) {
    this.referredincoming = referredincoming;
  }

  public UpdateOutgoingRequestDTO outgoingdate(OffsetDateTime outgoingdate) {
    this.outgoingdate = Optional.ofNullable(outgoingdate);
    return this;
  }

  /**
   * Versanddatum (Datum/Uhrzeit)
   * @return outgoingdate
   */
  @Valid 
  @Schema(name = "outgoingdate", example = "2016-10-26T18:48:01+01:00", description = "Versanddatum (Datum/Uhrzeit)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("outgoingdate")
  public Optional<OffsetDateTime> getOutgoingdate() {
    return outgoingdate;
  }

  @JsonProperty("outgoingdate")
  public void setOutgoingdate(Optional<OffsetDateTime> outgoingdate) {
    this.outgoingdate = outgoingdate;
  }

  public UpdateOutgoingRequestDTO incattachments(String incattachments) {
    this.incattachments = Optional.ofNullable(incattachments);
    return this;
  }

  /**
   * sonstige Anlagen
   * @return incattachments
   */
  
  @Schema(name = "incattachments", example = "Ausfüllhilfe Antrag auf Baugenehmigung", description = "sonstige Anlagen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UpdateOutgoingRequestDTO updateOutgoingRequestDTO = (UpdateOutgoingRequestDTO) o;
    return Objects.equals(this.shortname, updateOutgoingRequestDTO.shortname) &&
        Objects.equals(this.filesubj, updateOutgoingRequestDTO.filesubj) &&
        Objects.equals(this.objterms, updateOutgoingRequestDTO.objterms) &&
        Objects.equals(this.accdef, updateOutgoingRequestDTO.accdef) &&
        Objects.equals(this.referredincoming, updateOutgoingRequestDTO.referredincoming) &&
        Objects.equals(this.outgoingdate, updateOutgoingRequestDTO.outgoingdate) &&
        Objects.equals(this.incattachments, updateOutgoingRequestDTO.incattachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, referredincoming, outgoingdate, incattachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOutgoingRequestDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    referredincoming: ").append(toIndentedString(referredincoming)).append("\n");
    sb.append("    outgoingdate: ").append(toIndentedString(outgoingdate)).append("\n");
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

    private UpdateOutgoingRequestDTO instance;

    public Builder() {
      this(new UpdateOutgoingRequestDTO());
    }

    protected Builder(UpdateOutgoingRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateOutgoingRequestDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setReferredincoming(value.referredincoming);
      this.instance.setOutgoingdate(value.outgoingdate);
      this.instance.setIncattachments(value.incattachments);
      return this;
    }

    public UpdateOutgoingRequestDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder referredincoming(String referredincoming) {
      this.instance.referredincoming(referredincoming);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder outgoingdate(OffsetDateTime outgoingdate) {
      this.instance.outgoingdate(outgoingdate);
      return this;
    }
    
    public UpdateOutgoingRequestDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    /**
    * returns a built UpdateOutgoingRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateOutgoingRequestDTO build() {
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
  public static UpdateOutgoingRequestDTO.Builder builder() {
    return new UpdateOutgoingRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateOutgoingRequestDTO.Builder toBuilder() {
    UpdateOutgoingRequestDTO.Builder builder = new UpdateOutgoingRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


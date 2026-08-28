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
 * UpdateProcedureDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateProcedureDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimefrom = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimetill = Optional.empty();

  private Optional<String> procremark = Optional.empty();

  private Optional<String> filetype = Optional.empty();

  private Optional<String> filearchivetimeOffltdeadline = Optional.empty();

  private Optional<String> filelifetimeOffltdeadline = Optional.empty();

  private Optional<String> offltdispstate = Optional.empty();

  public UpdateProcedureDTO shortname(String shortname) {
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

  public UpdateProcedureDTO filesubj(String filesubj) {
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

  public UpdateProcedureDTO objterms(String objterms) {
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

  public UpdateProcedureDTO accdef(String accdef) {
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

  public UpdateProcedureDTO fileruntimefrom(OffsetDateTime fileruntimefrom) {
    this.fileruntimefrom = Optional.ofNullable(fileruntimefrom);
    return this;
  }

  /**
   * Laufzeitbeginn\\ Tatsächliches Datum der Anlage der Akte (unabhängig von der Anlage der Akte im eAkte-System). Kann z.B. gesetzt werden, wenn das erste Schriftstück zu der neuen Akte bereits vor der Anlage der Akte im eAkte-System eingegangen ist.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. 
   * @return fileruntimefrom
   */
  @Valid 
  @Schema(name = "fileruntimefrom", example = "2017-01-13T17:09:42.411+01:00", description = "Laufzeitbeginn\\ Tatsächliches Datum der Anlage der Akte (unabhängig von der Anlage der Akte im eAkte-System). Kann z.B. gesetzt werden, wenn das erste Schriftstück zu der neuen Akte bereits vor der Anlage der Akte im eAkte-System eingegangen ist.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileruntimefrom")
  public Optional<OffsetDateTime> getFileruntimefrom() {
    return fileruntimefrom;
  }

  @JsonProperty("fileruntimefrom")
  public void setFileruntimefrom(Optional<OffsetDateTime> fileruntimefrom) {
    this.fileruntimefrom = fileruntimefrom;
  }

  public UpdateProcedureDTO fileruntimetill(OffsetDateTime fileruntimetill) {
    this.fileruntimetill = Optional.ofNullable(fileruntimetill);
    return this;
  }

  /**
   * Laufzeitende\\ Geplanter Abschluss der Akte.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. 
   * @return fileruntimetill
   */
  @Valid 
  @Schema(name = "fileruntimetill", example = "2017-01-13T17:09:42.411+01:00", description = "Laufzeitende\\ Geplanter Abschluss der Akte.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileruntimetill")
  public Optional<OffsetDateTime> getFileruntimetill() {
    return fileruntimetill;
  }

  @JsonProperty("fileruntimetill")
  public void setFileruntimetill(Optional<OffsetDateTime> fileruntimetill) {
    this.fileruntimetill = fileruntimetill;
  }

  public UpdateProcedureDTO procremark(String procremark) {
    this.procremark = Optional.ofNullable(procremark);
    return this;
  }

  /**
   * Bemerkung für Prozessverantwortliche
   * @return procremark
   */
  
  @Schema(name = "procremark", example = "Warte auf Rückmeldung", description = "Bemerkung für Prozessverantwortliche", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("procremark")
  public Optional<String> getProcremark() {
    return procremark;
  }

  @JsonProperty("procremark")
  public void setProcremark(Optional<String> procremark) {
    this.procremark = procremark;
  }

  public UpdateProcedureDTO filetype(String filetype) {
    this.filetype = Optional.ofNullable(filetype);
    return this;
  }

  /**
   * Art des originalen Typs des Vorgangs (COOELAK@1.1001:filetype) Einer der drei Typen kann beim Anlegen eines Vorgangs angegeben werden: * Elektronisch * Papier * Hybrid  Wird ein falscher Wert angegeben, wird eine Fehlermeldung zurückgegeben:\\  Status -1 und \"Art des Vorgangs\" enthält einen ungültigen Wert.“\\ Wenn kein Wert eingetragen wird, wird „Elektronisch“ hinterlegt. 
   * @return filetype
   */
  
  @Schema(name = "filetype", example = "Elektronisch", description = "Art des originalen Typs des Vorgangs (COOELAK@1.1001:filetype) Einer der drei Typen kann beim Anlegen eines Vorgangs angegeben werden: * Elektronisch * Papier * Hybrid  Wird ein falscher Wert angegeben, wird eine Fehlermeldung zurückgegeben:\\  Status -1 und \"Art des Vorgangs\" enthält einen ungültigen Wert.“\\ Wenn kein Wert eingetragen wird, wird „Elektronisch“ hinterlegt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filetype")
  public Optional<String> getFiletype() {
    return filetype;
  }

  @JsonProperty("filetype")
  public void setFiletype(Optional<String> filetype) {
    this.filetype = filetype;
  }

  public UpdateProcedureDTO filearchivetimeOffltdeadline(String filearchivetimeOffltdeadline) {
    this.filearchivetimeOffltdeadline = Optional.ofNullable(filearchivetimeOffltdeadline);
    return this;
  }

  /**
   * Transferfrist/ Wird bei der LHM nicht ausgewertet (Beschreibung siehe Lebenszyklus der Akte) 
   * @return filearchivetimeOffltdeadline
   */
  
  @Schema(name = "filearchivetimeOffltdeadline", example = "10 Jahre", description = "Transferfrist/ Wird bei der LHM nicht ausgewertet (Beschreibung siehe Lebenszyklus der Akte) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filearchivetimeOffltdeadline")
  public Optional<String> getFilearchivetimeOffltdeadline() {
    return filearchivetimeOffltdeadline;
  }

  @JsonProperty("filearchivetimeOffltdeadline")
  public void setFilearchivetimeOffltdeadline(Optional<String> filearchivetimeOffltdeadline) {
    this.filearchivetimeOffltdeadline = filearchivetimeOffltdeadline;
  }

  public UpdateProcedureDTO filelifetimeOffltdeadline(String filelifetimeOffltdeadline) {
    this.filelifetimeOffltdeadline = Optional.ofNullable(filelifetimeOffltdeadline);
    return this;
  }

  /**
   * Aufbewahrungsfrist
   * @return filelifetimeOffltdeadline
   */
  
  @Schema(name = "filelifetimeOffltdeadline", example = "10 Jahre", description = "Aufbewahrungsfrist", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filelifetimeOffltdeadline")
  public Optional<String> getFilelifetimeOffltdeadline() {
    return filelifetimeOffltdeadline;
  }

  @JsonProperty("filelifetimeOffltdeadline")
  public void setFilelifetimeOffltdeadline(Optional<String> filelifetimeOffltdeadline) {
    this.filelifetimeOffltdeadline = filelifetimeOffltdeadline;
  }

  public UpdateProcedureDTO offltdispstate(String offltdispstate) {
    this.offltdispstate = Optional.ofNullable(offltdispstate);
    return this;
  }

  /**
   * Folgende Aussonderungsarten sind möglich * „DISPSTATE_ARCHIVE“ - für „ A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „ V - Vernichten“ * „DISPSTATE_DM_B“ für „ B - Bewerten“  Ergänzende Erläuterungen: * „A - Archivwürdig“ - Dokumente, Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Dokumente, Vorgänge oder Akten können nach Ablauf der Aufbewahrungsfrist vernichtet werden. * „B - Bewerten“ - Bewerten von Dokumenten, Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Hinweis:\\ Wird nicht beim Anlegen, sondern nur beim Ändern einer Betreffseinheit, Akte oder Vorgang gesetzt. 
   * @return offltdispstate
   */
  
  @Schema(name = "offltdispstate", example = "DISPSTATE_ARCHIVE", description = "Folgende Aussonderungsarten sind möglich * „DISPSTATE_ARCHIVE“ - für „ A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „ V - Vernichten“ * „DISPSTATE_DM_B“ für „ B - Bewerten“  Ergänzende Erläuterungen: * „A - Archivwürdig“ - Dokumente, Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Dokumente, Vorgänge oder Akten können nach Ablauf der Aufbewahrungsfrist vernichtet werden. * „B - Bewerten“ - Bewerten von Dokumenten, Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Hinweis:\\ Wird nicht beim Anlegen, sondern nur beim Ändern einer Betreffseinheit, Akte oder Vorgang gesetzt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("offltdispstate")
  public Optional<String> getOffltdispstate() {
    return offltdispstate;
  }

  @JsonProperty("offltdispstate")
  public void setOffltdispstate(Optional<String> offltdispstate) {
    this.offltdispstate = offltdispstate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateProcedureDTO updateProcedureDTO = (UpdateProcedureDTO) o;
    return Objects.equals(this.shortname, updateProcedureDTO.shortname) &&
        Objects.equals(this.filesubj, updateProcedureDTO.filesubj) &&
        Objects.equals(this.objterms, updateProcedureDTO.objterms) &&
        Objects.equals(this.accdef, updateProcedureDTO.accdef) &&
        Objects.equals(this.fileruntimefrom, updateProcedureDTO.fileruntimefrom) &&
        Objects.equals(this.fileruntimetill, updateProcedureDTO.fileruntimetill) &&
        Objects.equals(this.procremark, updateProcedureDTO.procremark) &&
        Objects.equals(this.filetype, updateProcedureDTO.filetype) &&
        Objects.equals(this.filearchivetimeOffltdeadline, updateProcedureDTO.filearchivetimeOffltdeadline) &&
        Objects.equals(this.filelifetimeOffltdeadline, updateProcedureDTO.filelifetimeOffltdeadline) &&
        Objects.equals(this.offltdispstate, updateProcedureDTO.offltdispstate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, fileruntimefrom, fileruntimetill, procremark, filetype, filearchivetimeOffltdeadline, filelifetimeOffltdeadline, offltdispstate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateProcedureDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    fileruntimefrom: ").append(toIndentedString(fileruntimefrom)).append("\n");
    sb.append("    fileruntimetill: ").append(toIndentedString(fileruntimetill)).append("\n");
    sb.append("    procremark: ").append(toIndentedString(procremark)).append("\n");
    sb.append("    filetype: ").append(toIndentedString(filetype)).append("\n");
    sb.append("    filearchivetimeOffltdeadline: ").append(toIndentedString(filearchivetimeOffltdeadline)).append("\n");
    sb.append("    filelifetimeOffltdeadline: ").append(toIndentedString(filelifetimeOffltdeadline)).append("\n");
    sb.append("    offltdispstate: ").append(toIndentedString(offltdispstate)).append("\n");
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

    private UpdateProcedureDTO instance;

    public Builder() {
      this(new UpdateProcedureDTO());
    }

    protected Builder(UpdateProcedureDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateProcedureDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setFileruntimefrom(value.fileruntimefrom);
      this.instance.setFileruntimetill(value.fileruntimetill);
      this.instance.setProcremark(value.procremark);
      this.instance.setFiletype(value.filetype);
      this.instance.setFilearchivetimeOffltdeadline(value.filearchivetimeOffltdeadline);
      this.instance.setFilelifetimeOffltdeadline(value.filelifetimeOffltdeadline);
      this.instance.setOffltdispstate(value.offltdispstate);
      return this;
    }

    public UpdateProcedureDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public UpdateProcedureDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public UpdateProcedureDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public UpdateProcedureDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public UpdateProcedureDTO.Builder fileruntimefrom(OffsetDateTime fileruntimefrom) {
      this.instance.fileruntimefrom(fileruntimefrom);
      return this;
    }
    
    public UpdateProcedureDTO.Builder fileruntimetill(OffsetDateTime fileruntimetill) {
      this.instance.fileruntimetill(fileruntimetill);
      return this;
    }
    
    public UpdateProcedureDTO.Builder procremark(String procremark) {
      this.instance.procremark(procremark);
      return this;
    }
    
    public UpdateProcedureDTO.Builder filetype(String filetype) {
      this.instance.filetype(filetype);
      return this;
    }
    
    public UpdateProcedureDTO.Builder filearchivetimeOffltdeadline(String filearchivetimeOffltdeadline) {
      this.instance.filearchivetimeOffltdeadline(filearchivetimeOffltdeadline);
      return this;
    }
    
    public UpdateProcedureDTO.Builder filelifetimeOffltdeadline(String filelifetimeOffltdeadline) {
      this.instance.filelifetimeOffltdeadline(filelifetimeOffltdeadline);
      return this;
    }
    
    public UpdateProcedureDTO.Builder offltdispstate(String offltdispstate) {
      this.instance.offltdispstate(offltdispstate);
      return this;
    }
    
    /**
    * returns a built UpdateProcedureDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateProcedureDTO build() {
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
  public static UpdateProcedureDTO.Builder builder() {
    return new UpdateProcedureDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateProcedureDTO.Builder toBuilder() {
    UpdateProcedureDTO.Builder builder = new UpdateProcedureDTO.Builder();
    return builder.copyOf(this);
  }

}


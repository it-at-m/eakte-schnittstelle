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
 * UpdateFileDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateFileDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimefrom = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimetill = Optional.empty();

  private Optional<String> filearchivetimeOffltdeadline = Optional.empty();

  private Optional<String> filelifetimeOffltdeadline = Optional.empty();

  private Optional<String> offltdispstate = Optional.empty();

  private Optional<String> procedureaccdef = Optional.empty();

  public UpdateFileDTO shortname(String shortname) {
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

  public UpdateFileDTO filesubj(String filesubj) {
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

  public UpdateFileDTO objterms(String objterms) {
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

  public UpdateFileDTO fileruntimefrom(OffsetDateTime fileruntimefrom) {
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

  public UpdateFileDTO fileruntimetill(OffsetDateTime fileruntimetill) {
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

  public UpdateFileDTO filearchivetimeOffltdeadline(String filearchivetimeOffltdeadline) {
    this.filearchivetimeOffltdeadline = Optional.ofNullable(filearchivetimeOffltdeadline);
    return this;
  }

  /**
   * Transferfrist  Die Transferfrist beginnt gleichzeitig mit der Aufbewahrungsfrist, endet aber meist früher.  Während der Transferfrist können Vorgänge wieder aufleben und fortgeführt werden.\\ Die Vorgänge müssen nach Ende der Arbeiten erneut abgeschlossen werden und  die Aufbewahrungs- und die Transferfrist fangen wieder von Beginn an zu laufen.  Häufig werden Akten auf einen internen Langzeitspeicher oder in das Zwischenarchiv des Bundesarchivs ausgelagert.\\ Bei der LHM wird die Transferfrist nicht eingesetzt, da die Akten bis zur Übergabe an das Stadtarchiv in der eAkte verbleiben!\\ Die Fabasoft eGov Suite erlaubt auch nach Ablauf der Transferfrist bis zum Ende der Aufbewahrungsfrist \"z.A. aufheben\", um die Akte wieder bearbeiten zu können.\\ Daher wird die Transferfrist gleich der Aufbewahrungsfrist gesetzt und im Lebenszyklus nicht beachtet (auch keine Änderung der Zugriffsrechte). 
   * @return filearchivetimeOffltdeadline
   */
  
  @Schema(name = "filearchivetimeOffltdeadline", example = "10 Jahre", description = "Transferfrist  Die Transferfrist beginnt gleichzeitig mit der Aufbewahrungsfrist, endet aber meist früher.  Während der Transferfrist können Vorgänge wieder aufleben und fortgeführt werden.\\ Die Vorgänge müssen nach Ende der Arbeiten erneut abgeschlossen werden und  die Aufbewahrungs- und die Transferfrist fangen wieder von Beginn an zu laufen.  Häufig werden Akten auf einen internen Langzeitspeicher oder in das Zwischenarchiv des Bundesarchivs ausgelagert.\\ Bei der LHM wird die Transferfrist nicht eingesetzt, da die Akten bis zur Übergabe an das Stadtarchiv in der eAkte verbleiben!\\ Die Fabasoft eGov Suite erlaubt auch nach Ablauf der Transferfrist bis zum Ende der Aufbewahrungsfrist \"z.A. aufheben\", um die Akte wieder bearbeiten zu können.\\ Daher wird die Transferfrist gleich der Aufbewahrungsfrist gesetzt und im Lebenszyklus nicht beachtet (auch keine Änderung der Zugriffsrechte). ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filearchivetimeOffltdeadline")
  public Optional<String> getFilearchivetimeOffltdeadline() {
    return filearchivetimeOffltdeadline;
  }

  @JsonProperty("filearchivetimeOffltdeadline")
  public void setFilearchivetimeOffltdeadline(Optional<String> filearchivetimeOffltdeadline) {
    this.filearchivetimeOffltdeadline = filearchivetimeOffltdeadline;
  }

  public UpdateFileDTO filelifetimeOffltdeadline(String filelifetimeOffltdeadline) {
    this.filelifetimeOffltdeadline = Optional.ofNullable(filelifetimeOffltdeadline);
    return this;
  }

  /**
   * Aufbewahrungsfrist  Die Aufbewahrungsfrist bestimmt den Zeitraum, in dem Vorgänge und Akten nach der Bearbeitung aufzubewahren sind.  Nach Ablauf dieser Frist erfolgt die Aussonderung,  d.h. Vorgänge oder Akten werden entweder vernichtet oder an das zuständige Archiv übermittelt.  Für Vorgänge und Akten, deren Archivwürdigkeit nicht durch eine Vorabentscheidung im Bewertungsverzeichnis festgelegt ist oder für die kein Bewertungsverzeichnis vorliegt,  wird „B - Bewerten“ hinterlegt.  Hinweis:\\ In der eAkte wird beim Anlegen einer neuen Akte die definierte Aufbewahrungsfrist verwendet.  Wenn die Frist vom Standard abweichen soll,  muss sie in den Eigenschaften der Akte überschrieben werden (Anwendungsfall \"Akte Eigenschaften bearbeiten\").  Folgende Werte sind auswählbar:\\ 1 Jahr, 6 Monate, 3 Monate, 1 Monat, 1 Woche, 1 Tag,\\ 3, 5, 7, 10, 15, 20, 25, 30 Jahre,\\ 40, 50, 60, 70, 80, 90, 100, 110 Jahre\\ Die im System verwendeten Fristen finden Sie in der Suche auf dem Schreibtisch der eAkte,  wenn sie nach der Frist (Komponentenbjekt) suchen 
   * @return filelifetimeOffltdeadline
   */
  
  @Schema(name = "filelifetimeOffltdeadline", example = "5 Jahre", description = "Aufbewahrungsfrist  Die Aufbewahrungsfrist bestimmt den Zeitraum, in dem Vorgänge und Akten nach der Bearbeitung aufzubewahren sind.  Nach Ablauf dieser Frist erfolgt die Aussonderung,  d.h. Vorgänge oder Akten werden entweder vernichtet oder an das zuständige Archiv übermittelt.  Für Vorgänge und Akten, deren Archivwürdigkeit nicht durch eine Vorabentscheidung im Bewertungsverzeichnis festgelegt ist oder für die kein Bewertungsverzeichnis vorliegt,  wird „B - Bewerten“ hinterlegt.  Hinweis:\\ In der eAkte wird beim Anlegen einer neuen Akte die definierte Aufbewahrungsfrist verwendet.  Wenn die Frist vom Standard abweichen soll,  muss sie in den Eigenschaften der Akte überschrieben werden (Anwendungsfall \"Akte Eigenschaften bearbeiten\").  Folgende Werte sind auswählbar:\\ 1 Jahr, 6 Monate, 3 Monate, 1 Monat, 1 Woche, 1 Tag,\\ 3, 5, 7, 10, 15, 20, 25, 30 Jahre,\\ 40, 50, 60, 70, 80, 90, 100, 110 Jahre\\ Die im System verwendeten Fristen finden Sie in der Suche auf dem Schreibtisch der eAkte,  wenn sie nach der Frist (Komponentenbjekt) suchen ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filelifetimeOffltdeadline")
  public Optional<String> getFilelifetimeOffltdeadline() {
    return filelifetimeOffltdeadline;
  }

  @JsonProperty("filelifetimeOffltdeadline")
  public void setFilelifetimeOffltdeadline(Optional<String> filelifetimeOffltdeadline) {
    this.filelifetimeOffltdeadline = filelifetimeOffltdeadline;
  }

  public UpdateFileDTO offltdispstate(String offltdispstate) {
    this.offltdispstate = Optional.ofNullable(offltdispstate);
    return this;
  }

  /**
   * Gewünschte Aussonderungsart * „DISPSTATE_ARCHIVE“ - für „A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „V - Vernichten“ * „DISPSTATE_DM_B“ für „B - Bewerten“  Ergänzungen zu den Aussonderungsarten: * „A - Archivwürdig“ - Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Vorgänge oder Akten werden nach Ablauf der Aufbewahrungsfrist vernichtet. * „B - Bewerten“ - Bewerten von Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Die Aussonderungsart wird üblicherweise über die Aussonderungsart im Aktenplaneintrag gesetzt. 
   * @return offltdispstate
   */
  
  @Schema(name = "offltdispstate", example = "DISPSTATE_ARCHIVE", description = "Gewünschte Aussonderungsart * „DISPSTATE_ARCHIVE“ - für „A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „V - Vernichten“ * „DISPSTATE_DM_B“ für „B - Bewerten“  Ergänzungen zu den Aussonderungsarten: * „A - Archivwürdig“ - Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Vorgänge oder Akten werden nach Ablauf der Aufbewahrungsfrist vernichtet. * „B - Bewerten“ - Bewerten von Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Die Aussonderungsart wird üblicherweise über die Aussonderungsart im Aktenplaneintrag gesetzt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("offltdispstate")
  public Optional<String> getOffltdispstate() {
    return offltdispstate;
  }

  @JsonProperty("offltdispstate")
  public void setOffltdispstate(Optional<String> offltdispstate) {
    this.offltdispstate = offltdispstate;
  }

  public UpdateFileDTO procedureaccdef(String procedureaccdef) {
    this.procedureaccdef = Optional.ofNullable(procedureaccdef);
    return this;
  }

  /**
   * Folgende Zugriffsdefinitionen für neue Vorgänge der Akte sind möglich: * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur bei Vorgängen)  Wenn kein Wert übergeben wird, wird die auf der Akte hinterlegte Zugriffsdefinition übernommen (empfohlen). Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten aus der übergeordneten Akte übernehmen sollen, muss \"Aktengebunden\" angegeben werden. 
   * @return procedureaccdef
   */
  
  @Schema(name = "procedureaccdef", example = "Aktengebunden", description = "Folgende Zugriffsdefinitionen für neue Vorgänge der Akte sind möglich: * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur bei Vorgängen)  Wenn kein Wert übergeben wird, wird die auf der Akte hinterlegte Zugriffsdefinition übernommen (empfohlen). Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten aus der übergeordneten Akte übernehmen sollen, muss \"Aktengebunden\" angegeben werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("procedureaccdef")
  public Optional<String> getProcedureaccdef() {
    return procedureaccdef;
  }

  @JsonProperty("procedureaccdef")
  public void setProcedureaccdef(Optional<String> procedureaccdef) {
    this.procedureaccdef = procedureaccdef;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateFileDTO updateFileDTO = (UpdateFileDTO) o;
    return Objects.equals(this.shortname, updateFileDTO.shortname) &&
        Objects.equals(this.filesubj, updateFileDTO.filesubj) &&
        Objects.equals(this.objterms, updateFileDTO.objterms) &&
        Objects.equals(this.fileruntimefrom, updateFileDTO.fileruntimefrom) &&
        Objects.equals(this.fileruntimetill, updateFileDTO.fileruntimetill) &&
        Objects.equals(this.filearchivetimeOffltdeadline, updateFileDTO.filearchivetimeOffltdeadline) &&
        Objects.equals(this.filelifetimeOffltdeadline, updateFileDTO.filelifetimeOffltdeadline) &&
        Objects.equals(this.offltdispstate, updateFileDTO.offltdispstate) &&
        Objects.equals(this.procedureaccdef, updateFileDTO.procedureaccdef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, fileruntimefrom, fileruntimetill, filearchivetimeOffltdeadline, filelifetimeOffltdeadline, offltdispstate, procedureaccdef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateFileDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    fileruntimefrom: ").append(toIndentedString(fileruntimefrom)).append("\n");
    sb.append("    fileruntimetill: ").append(toIndentedString(fileruntimetill)).append("\n");
    sb.append("    filearchivetimeOffltdeadline: ").append(toIndentedString(filearchivetimeOffltdeadline)).append("\n");
    sb.append("    filelifetimeOffltdeadline: ").append(toIndentedString(filelifetimeOffltdeadline)).append("\n");
    sb.append("    offltdispstate: ").append(toIndentedString(offltdispstate)).append("\n");
    sb.append("    procedureaccdef: ").append(toIndentedString(procedureaccdef)).append("\n");
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

    private UpdateFileDTO instance;

    public Builder() {
      this(new UpdateFileDTO());
    }

    protected Builder(UpdateFileDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateFileDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setFileruntimefrom(value.fileruntimefrom);
      this.instance.setFileruntimetill(value.fileruntimetill);
      this.instance.setFilearchivetimeOffltdeadline(value.filearchivetimeOffltdeadline);
      this.instance.setFilelifetimeOffltdeadline(value.filelifetimeOffltdeadline);
      this.instance.setOffltdispstate(value.offltdispstate);
      this.instance.setProcedureaccdef(value.procedureaccdef);
      return this;
    }

    public UpdateFileDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public UpdateFileDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public UpdateFileDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public UpdateFileDTO.Builder fileruntimefrom(OffsetDateTime fileruntimefrom) {
      this.instance.fileruntimefrom(fileruntimefrom);
      return this;
    }
    
    public UpdateFileDTO.Builder fileruntimetill(OffsetDateTime fileruntimetill) {
      this.instance.fileruntimetill(fileruntimetill);
      return this;
    }
    
    public UpdateFileDTO.Builder filearchivetimeOffltdeadline(String filearchivetimeOffltdeadline) {
      this.instance.filearchivetimeOffltdeadline(filearchivetimeOffltdeadline);
      return this;
    }
    
    public UpdateFileDTO.Builder filelifetimeOffltdeadline(String filelifetimeOffltdeadline) {
      this.instance.filelifetimeOffltdeadline(filelifetimeOffltdeadline);
      return this;
    }
    
    public UpdateFileDTO.Builder offltdispstate(String offltdispstate) {
      this.instance.offltdispstate(offltdispstate);
      return this;
    }
    
    public UpdateFileDTO.Builder procedureaccdef(String procedureaccdef) {
      this.instance.procedureaccdef(procedureaccdef);
      return this;
    }
    
    /**
    * returns a built UpdateFileDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateFileDTO build() {
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
  public static UpdateFileDTO.Builder builder() {
    return new UpdateFileDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateFileDTO.Builder toBuilder() {
    UpdateFileDTO.Builder builder = new UpdateFileDTO.Builder();
    return builder.copyOf(this);
  }

}


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.UserFormsReferenz;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * CreateFileDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateFileDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private String apentry;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimefrom = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimetill = Optional.empty();

  private Optional<String> fileouobj = Optional.empty();

  private Optional<String> procedureaccdef = Optional.empty();

  private Optional<String> definition = Optional.empty();

  @Valid
  private List<@Valid UserFormsReferenz> userformsdata = new ArrayList<>();

  public CreateFileDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateFileDTO(String apentry) {
    this.apentry = apentry;
  }

  public CreateFileDTO shortname(String shortname) {
    this.shortname = Optional.ofNullable(shortname);
    return this;
  }

  /**
   * Der Name wird in der eAkte gebildet aus dem \"Titel der Akte\"  (\"Aktenplankennzeichen des Aktenplankennzeichens, in dem die Akte liegt\"- \"laufende Nummer der Akte innerhalb des Aktenplaneintrags\") 
   * @return shortname
   */
  
  @Schema(name = "shortname", example = "2016 Anträge Firma XY (1001-47)", description = "Der Name wird in der eAkte gebildet aus dem \"Titel der Akte\"  (\"Aktenplankennzeichen des Aktenplankennzeichens, in dem die Akte liegt\"- \"laufende Nummer der Akte innerhalb des Aktenplaneintrags\") ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortname")
  public Optional<String> getShortname() {
    return shortname;
  }

  @JsonProperty("shortname")
  public void setShortname(Optional<String> shortname) {
    this.shortname = shortname;
  }

  public CreateFileDTO filesubj(String filesubj) {
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

  public CreateFileDTO objterms(String objterms) {
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

  public CreateFileDTO accdef(String accdef) {
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

  public CreateFileDTO apentry(String apentry) {
    this.apentry = apentry;
    return this;
  }

  /**
   * Aktenplankennzeichen (Objekt-ID des APl-Kennzeichens)
   * @return apentry
   */
  @NotNull 
  @Schema(name = "apentry", example = "COO.1.2301.1.683", description = "Aktenplankennzeichen (Objekt-ID des APl-Kennzeichens)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("apentry")
  public String getApentry() {
    return apentry;
  }

  @JsonProperty("apentry")
  public void setApentry(String apentry) {
    this.apentry = apentry;
  }

  public CreateFileDTO fileruntimefrom(OffsetDateTime fileruntimefrom) {
    this.fileruntimefrom = Optional.ofNullable(fileruntimefrom);
    return this;
  }

  /**
   * Laufzeitbeginn<br> Tatsächliches Datum der Anlage der Akte (unabhängig von der Anlage der Akte im eAkte-System). Kann z.B. gesetzt werden, wenn das erste Schriftstück zu der neuen Akte bereits vor der Anlage der Akte im eAkte-System eingegangen ist.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. 
   * @return fileruntimefrom
   */
  @Valid 
  @Schema(name = "fileruntimefrom", example = "2017-01-13T17:09:42.411+01:00", description = "Laufzeitbeginn<br> Tatsächliches Datum der Anlage der Akte (unabhängig von der Anlage der Akte im eAkte-System). Kann z.B. gesetzt werden, wenn das erste Schriftstück zu der neuen Akte bereits vor der Anlage der Akte im eAkte-System eingegangen ist.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileruntimefrom")
  public Optional<OffsetDateTime> getFileruntimefrom() {
    return fileruntimefrom;
  }

  @JsonProperty("fileruntimefrom")
  public void setFileruntimefrom(Optional<OffsetDateTime> fileruntimefrom) {
    this.fileruntimefrom = fileruntimefrom;
  }

  public CreateFileDTO fileruntimetill(OffsetDateTime fileruntimetill) {
    this.fileruntimetill = Optional.ofNullable(fileruntimetill);
    return this;
  }

  /**
   * Laufzeitende<br> Geplanter Abschluss der Akte.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. 
   * @return fileruntimetill
   */
  @Valid 
  @Schema(name = "fileruntimetill", example = "2017-01-13T17:09:42.411+01:00", description = "Laufzeitende<br> Geplanter Abschluss der Akte.  Das Datum hat keine Auswirkungen im System, sondern dient nur zur Information. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileruntimetill")
  public Optional<OffsetDateTime> getFileruntimetill() {
    return fileruntimetill;
  }

  @JsonProperty("fileruntimetill")
  public void setFileruntimetill(Optional<OffsetDateTime> fileruntimetill) {
    this.fileruntimetill = fileruntimetill;
  }

  public CreateFileDTO fileouobj(String fileouobj) {
    this.fileouobj = Optional.ofNullable(fileouobj);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der aktenführenden Organisationseinheit.<br> Als Organisationseinheit der Akte wird die Organisationseinheit des darüber liegenden Aktenplankennzeichens gesetzt.<br> Sofern keine Organisationseinheit auf dem Aktenplankennzeichen definiert ist, wird die Organisationseinheit der ersten Rolle des Benutzers verwendet. 
   * @return fileouobj
   */
  
  @Schema(name = "fileouobj", example = "COO.1.2300.1.847", description = "Objekt-ID (COO-Adresse) der aktenführenden Organisationseinheit.<br> Als Organisationseinheit der Akte wird die Organisationseinheit des darüber liegenden Aktenplankennzeichens gesetzt.<br> Sofern keine Organisationseinheit auf dem Aktenplankennzeichen definiert ist, wird die Organisationseinheit der ersten Rolle des Benutzers verwendet. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileouobj")
  public Optional<String> getFileouobj() {
    return fileouobj;
  }

  @JsonProperty("fileouobj")
  public void setFileouobj(Optional<String> fileouobj) {
    this.fileouobj = fileouobj;
  }

  public CreateFileDTO procedureaccdef(String procedureaccdef) {
    this.procedureaccdef = Optional.ofNullable(procedureaccdef);
    return this;
  }

  /**
   * Folgende Zugriffsdefinitionen für neue Vorgänge der Akte sind möglich: * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur bei Vorgängen)  Wenn kein Wert übergeben wird, wird die auf der Akte hinterlegte Zugriffsdefinition übernommen (empfohlen). Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten aus der übergeordneten Akte übernehmen sollen, muss \"Aktengebunden\" angegeben werden.<br> Wenn eine Akte über die SST angelegt wird und  am Aktenplaneintrag zusätzlich berechtigte OE's eingetragen wurden  (im Reiter \"Sicherheitseinstellungen\" des Aktenplaneintrags),  dann wird die Zugriffsdefinition \"Aktengebunden\" automatisch bei der Akte für Vorgänge gesetzt.<br> Der Parameter procedureaccdef wird in solchen Fällen nicht berücksichtigt. 
   * @return procedureaccdef
   */
  
  @Schema(name = "procedureaccdef", example = "Aktengebunden", description = "Folgende Zugriffsdefinitionen für neue Vorgänge der Akte sind möglich: * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur bei Vorgängen)  Wenn kein Wert übergeben wird, wird die auf der Akte hinterlegte Zugriffsdefinition übernommen (empfohlen). Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten aus der übergeordneten Akte übernehmen sollen, muss \"Aktengebunden\" angegeben werden.<br> Wenn eine Akte über die SST angelegt wird und  am Aktenplaneintrag zusätzlich berechtigte OE's eingetragen wurden  (im Reiter \"Sicherheitseinstellungen\" des Aktenplaneintrags),  dann wird die Zugriffsdefinition \"Aktengebunden\" automatisch bei der Akte für Vorgänge gesetzt.<br> Der Parameter procedureaccdef wird in solchen Fällen nicht berücksichtigt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("procedureaccdef")
  public Optional<String> getProcedureaccdef() {
    return procedureaccdef;
  }

  @JsonProperty("procedureaccdef")
  public void setProcedureaccdef(Optional<String> procedureaccdef) {
    this.procedureaccdef = procedureaccdef;
  }

  public CreateFileDTO definition(String definition) {
    this.definition = Optional.ofNullable(definition);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der Definition für Verfahren
   * @return definition
   */
  
  @Schema(name = "definition", description = "Objekt-ID (COO-Adresse) der Definition für Verfahren", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("definition")
  public Optional<String> getDefinition() {
    return definition;
  }

  @JsonProperty("definition")
  public void setDefinition(Optional<String> definition) {
    this.definition = definition;
  }

  public CreateFileDTO userformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
    return this;
  }

  public CreateFileDTO addUserformsdataItem(UserFormsReferenz userformsdataItem) {
    if (this.userformsdata == null) {
      this.userformsdata = new ArrayList<>();
    }
    this.userformsdata.add(userformsdataItem);
    return this;
  }

  /**
   * Get userformsdata
   * @return userformsdata
   */
  @Valid 
  @Schema(name = "userformsdata", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userformsdata")
  public List<@Valid UserFormsReferenz> getUserformsdata() {
    return userformsdata;
  }

  @JsonProperty("userformsdata")
  public void setUserformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateFileDTO createFileDTO = (CreateFileDTO) o;
    return Objects.equals(this.shortname, createFileDTO.shortname) &&
        Objects.equals(this.filesubj, createFileDTO.filesubj) &&
        Objects.equals(this.objterms, createFileDTO.objterms) &&
        Objects.equals(this.accdef, createFileDTO.accdef) &&
        Objects.equals(this.apentry, createFileDTO.apentry) &&
        Objects.equals(this.fileruntimefrom, createFileDTO.fileruntimefrom) &&
        Objects.equals(this.fileruntimetill, createFileDTO.fileruntimetill) &&
        Objects.equals(this.fileouobj, createFileDTO.fileouobj) &&
        Objects.equals(this.procedureaccdef, createFileDTO.procedureaccdef) &&
        Objects.equals(this.definition, createFileDTO.definition) &&
        Objects.equals(this.userformsdata, createFileDTO.userformsdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, apentry, fileruntimefrom, fileruntimetill, fileouobj, procedureaccdef, definition, userformsdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFileDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    apentry: ").append(toIndentedString(apentry)).append("\n");
    sb.append("    fileruntimefrom: ").append(toIndentedString(fileruntimefrom)).append("\n");
    sb.append("    fileruntimetill: ").append(toIndentedString(fileruntimetill)).append("\n");
    sb.append("    fileouobj: ").append(toIndentedString(fileouobj)).append("\n");
    sb.append("    procedureaccdef: ").append(toIndentedString(procedureaccdef)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
    sb.append("    userformsdata: ").append(toIndentedString(userformsdata)).append("\n");
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

    private CreateFileDTO instance;

    public Builder() {
      this(new CreateFileDTO());
    }

    protected Builder(CreateFileDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateFileDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setApentry(value.apentry);
      this.instance.setFileruntimefrom(value.fileruntimefrom);
      this.instance.setFileruntimetill(value.fileruntimetill);
      this.instance.setFileouobj(value.fileouobj);
      this.instance.setProcedureaccdef(value.procedureaccdef);
      this.instance.setDefinition(value.definition);
      this.instance.setUserformsdata(value.userformsdata);
      return this;
    }

    public CreateFileDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public CreateFileDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public CreateFileDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public CreateFileDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public CreateFileDTO.Builder apentry(String apentry) {
      this.instance.apentry(apentry);
      return this;
    }
    
    public CreateFileDTO.Builder fileruntimefrom(OffsetDateTime fileruntimefrom) {
      this.instance.fileruntimefrom(fileruntimefrom);
      return this;
    }
    
    public CreateFileDTO.Builder fileruntimetill(OffsetDateTime fileruntimetill) {
      this.instance.fileruntimetill(fileruntimetill);
      return this;
    }
    
    public CreateFileDTO.Builder fileouobj(String fileouobj) {
      this.instance.fileouobj(fileouobj);
      return this;
    }
    
    public CreateFileDTO.Builder procedureaccdef(String procedureaccdef) {
      this.instance.procedureaccdef(procedureaccdef);
      return this;
    }
    
    public CreateFileDTO.Builder definition(String definition) {
      this.instance.definition(definition);
      return this;
    }
    
    public CreateFileDTO.Builder userformsdata(List<UserFormsReferenz> userformsdata) {
      this.instance.userformsdata(userformsdata);
      return this;
    }
    
    /**
    * returns a built CreateFileDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateFileDTO build() {
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
  public static CreateFileDTO.Builder builder() {
    return new CreateFileDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateFileDTO.Builder toBuilder() {
    CreateFileDTO.Builder builder = new CreateFileDTO.Builder();
    return builder.copyOf(this);
  }

}


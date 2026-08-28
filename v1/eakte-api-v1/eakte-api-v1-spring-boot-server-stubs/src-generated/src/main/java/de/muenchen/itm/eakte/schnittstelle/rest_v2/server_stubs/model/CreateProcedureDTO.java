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
 * CreateProcedureDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateProcedureDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimefrom = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> fileruntimetill = Optional.empty();

  private Optional<String> procremark = Optional.empty();

  private String referrednumber;

  private Optional<String> filetype = Optional.empty();

  private Optional<String> definition = Optional.empty();

  @Valid
  private List<@Valid UserFormsReferenz> userformsdata = new ArrayList<>();

  public CreateProcedureDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateProcedureDTO(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateProcedureDTO shortname(String shortname) {
    this.shortname = Optional.ofNullable(shortname);
    return this;
  }

  /**
   * Der Titel bildet zusammen mit dem Geschäftszeichen den Namen des Vorgangs.
   * @return shortname
   */
  
  @Schema(name = "shortname", example = "2016 Anträge Firma XY", description = "Der Titel bildet zusammen mit dem Geschäftszeichen den Namen des Vorgangs.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortname")
  public Optional<String> getShortname() {
    return shortname;
  }

  @JsonProperty("shortname")
  public void setShortname(Optional<String> shortname) {
    this.shortname = shortname;
  }

  public CreateProcedureDTO filesubj(String filesubj) {
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

  public CreateProcedureDTO objterms(String objterms) {
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

  public CreateProcedureDTO accdef(String accdef) {
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

  public CreateProcedureDTO fileruntimefrom(OffsetDateTime fileruntimefrom) {
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

  public CreateProcedureDTO fileruntimetill(OffsetDateTime fileruntimetill) {
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

  public CreateProcedureDTO procremark(String procremark) {
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

  public CreateProcedureDTO referrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der Sachakte
   * @return referrednumber
   */
  @NotNull 
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042406", description = "Objekt-ID (COO-Adresse) der Sachakte", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("referrednumber")
  public String getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateProcedureDTO filetype(String filetype) {
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

  public CreateProcedureDTO definition(String definition) {
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

  public CreateProcedureDTO userformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
    return this;
  }

  public CreateProcedureDTO addUserformsdataItem(UserFormsReferenz userformsdataItem) {
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
    CreateProcedureDTO createProcedureDTO = (CreateProcedureDTO) o;
    return Objects.equals(this.shortname, createProcedureDTO.shortname) &&
        Objects.equals(this.filesubj, createProcedureDTO.filesubj) &&
        Objects.equals(this.objterms, createProcedureDTO.objterms) &&
        Objects.equals(this.accdef, createProcedureDTO.accdef) &&
        Objects.equals(this.fileruntimefrom, createProcedureDTO.fileruntimefrom) &&
        Objects.equals(this.fileruntimetill, createProcedureDTO.fileruntimetill) &&
        Objects.equals(this.procremark, createProcedureDTO.procremark) &&
        Objects.equals(this.referrednumber, createProcedureDTO.referrednumber) &&
        Objects.equals(this.filetype, createProcedureDTO.filetype) &&
        Objects.equals(this.definition, createProcedureDTO.definition) &&
        Objects.equals(this.userformsdata, createProcedureDTO.userformsdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, fileruntimefrom, fileruntimetill, procremark, referrednumber, filetype, definition, userformsdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateProcedureDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    fileruntimefrom: ").append(toIndentedString(fileruntimefrom)).append("\n");
    sb.append("    fileruntimetill: ").append(toIndentedString(fileruntimetill)).append("\n");
    sb.append("    procremark: ").append(toIndentedString(procremark)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    filetype: ").append(toIndentedString(filetype)).append("\n");
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

    private CreateProcedureDTO instance;

    public Builder() {
      this(new CreateProcedureDTO());
    }

    protected Builder(CreateProcedureDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateProcedureDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setFileruntimefrom(value.fileruntimefrom);
      this.instance.setFileruntimetill(value.fileruntimetill);
      this.instance.setProcremark(value.procremark);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setFiletype(value.filetype);
      this.instance.setDefinition(value.definition);
      this.instance.setUserformsdata(value.userformsdata);
      return this;
    }

    public CreateProcedureDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public CreateProcedureDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public CreateProcedureDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public CreateProcedureDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public CreateProcedureDTO.Builder fileruntimefrom(OffsetDateTime fileruntimefrom) {
      this.instance.fileruntimefrom(fileruntimefrom);
      return this;
    }
    
    public CreateProcedureDTO.Builder fileruntimetill(OffsetDateTime fileruntimetill) {
      this.instance.fileruntimetill(fileruntimetill);
      return this;
    }
    
    public CreateProcedureDTO.Builder procremark(String procremark) {
      this.instance.procremark(procremark);
      return this;
    }
    
    public CreateProcedureDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateProcedureDTO.Builder filetype(String filetype) {
      this.instance.filetype(filetype);
      return this;
    }
    
    public CreateProcedureDTO.Builder definition(String definition) {
      this.instance.definition(definition);
      return this;
    }
    
    public CreateProcedureDTO.Builder userformsdata(List<UserFormsReferenz> userformsdata) {
      this.instance.userformsdata(userformsdata);
      return this;
    }
    
    /**
    * returns a built CreateProcedureDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateProcedureDTO build() {
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
  public static CreateProcedureDTO.Builder builder() {
    return new CreateProcedureDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateProcedureDTO.Builder toBuilder() {
    CreateProcedureDTO.Builder builder = new CreateProcedureDTO.Builder();
    return builder.copyOf(this);
  }

}


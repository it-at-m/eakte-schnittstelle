package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Objektreferenz;
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
 * ReadProcedureResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadProcedureResponseDTO {

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

  private Optional<String> objname = Optional.empty();

  private Optional<String> objdocstate = Optional.empty();

  private Optional<String> bostate = Optional.empty();

  private Optional<String> objowngroup = Optional.empty();

  @Valid
  private List<@Valid Objektreferenz> giobjecttype = new ArrayList<>();

  public ReadProcedureResponseDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReadProcedureResponseDTO(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public ReadProcedureResponseDTO shortname(String shortname) {
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

  public ReadProcedureResponseDTO filesubj(String filesubj) {
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

  public ReadProcedureResponseDTO objterms(String objterms) {
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

  public ReadProcedureResponseDTO accdef(String accdef) {
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

  public ReadProcedureResponseDTO fileruntimefrom(OffsetDateTime fileruntimefrom) {
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

  public ReadProcedureResponseDTO fileruntimetill(OffsetDateTime fileruntimetill) {
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

  public ReadProcedureResponseDTO procremark(String procremark) {
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

  public ReadProcedureResponseDTO referrednumber(String referrednumber) {
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

  public ReadProcedureResponseDTO filetype(String filetype) {
    this.filetype = Optional.ofNullable(filetype);
    return this;
  }

  /**
   * Art des originalen Typs des Vorgangs (COOELAK@1.1001:filetype) Einer der drei Typen kann beim Anlegen eines Vorgangs angegeben werden: * Elektronisch * Papier * Hybrid  Wird ein falscher Wert angegeben, wird eine Fehlermeldung zurückgegeben:<br> Status -1 und \"Art des Vorgangs\" enthält einen ungültigen Wert.“<br> Wenn kein Wert eingetragen wird, wird „Elektronisch“ hinterlegt. 
   * @return filetype
   */
  
  @Schema(name = "filetype", example = "Elektronisch", description = "Art des originalen Typs des Vorgangs (COOELAK@1.1001:filetype) Einer der drei Typen kann beim Anlegen eines Vorgangs angegeben werden: * Elektronisch * Papier * Hybrid  Wird ein falscher Wert angegeben, wird eine Fehlermeldung zurückgegeben:<br> Status -1 und \"Art des Vorgangs\" enthält einen ungültigen Wert.“<br> Wenn kein Wert eingetragen wird, wird „Elektronisch“ hinterlegt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filetype")
  public Optional<String> getFiletype() {
    return filetype;
  }

  @JsonProperty("filetype")
  public void setFiletype(Optional<String> filetype) {
    this.filetype = filetype;
  }

  public ReadProcedureResponseDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Vorgangskennzeichen
   * @return objname
   */
  
  @Schema(name = "objname", example = "Anfrage Baugenehmigung (0010 A20 011-4-0006)", description = "Vorgangskennzeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public ReadProcedureResponseDTO objdocstate(String objdocstate) {
    this.objdocstate = Optional.ofNullable(objdocstate);
    return this;
  }

  /**
   * Aktueller Bearbeitungsstatus (z.B. in Bearbeitung, Suspendiert, Abgeschlossen, Storniert)
   * @return objdocstate
   */
  
  @Schema(name = "objdocstate", example = "In Bearbeitung", description = "Aktueller Bearbeitungsstatus (z.B. in Bearbeitung, Suspendiert, Abgeschlossen, Storniert)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objdocstate")
  public Optional<String> getObjdocstate() {
    return objdocstate;
  }

  @JsonProperty("objdocstate")
  public void setObjdocstate(Optional<String> objdocstate) {
    this.objdocstate = objdocstate;
  }

  public ReadProcedureResponseDTO bostate(String bostate) {
    this.bostate = Optional.ofNullable(bostate);
    return this;
  }

  /**
   * Zu jedem Bearbeitungsstatus können weitere Status definiert sein (z.B. erstellt, erledigt, weggelegt, z.A. verfügt)
   * @return bostate
   */
  
  @Schema(name = "bostate", example = "Erstellt", description = "Zu jedem Bearbeitungsstatus können weitere Status definiert sein (z.B. erstellt, erledigt, weggelegt, z.A. verfügt)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bostate")
  public Optional<String> getBostate() {
    return bostate;
  }

  @JsonProperty("bostate")
  public void setBostate(Optional<String> bostate) {
    this.bostate = bostate;
  }

  public ReadProcedureResponseDTO objowngroup(String objowngroup) {
    this.objowngroup = Optional.ofNullable(objowngroup);
    return this;
  }

  /**
   * Objektname der zuständigen OE
   * @return objowngroup
   */
  
  @Schema(name = "objowngroup", example = "SG A1 0001 (Sachgebiet A1 0001)", description = "Objektname der zuständigen OE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objowngroup")
  public Optional<String> getObjowngroup() {
    return objowngroup;
  }

  @JsonProperty("objowngroup")
  public void setObjowngroup(Optional<String> objowngroup) {
    this.objowngroup = objowngroup;
  }

  public ReadProcedureResponseDTO giobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
    return this;
  }

  public ReadProcedureResponseDTO addGiobjecttypeItem(Objektreferenz giobjecttypeItem) {
    if (this.giobjecttype == null) {
      this.giobjecttype = new ArrayList<>();
    }
    this.giobjecttype.add(giobjecttypeItem);
    return this;
  }

  /**
   * Auflistung aller Objekte, auf die der Suchstring zutrifft.
   * @return giobjecttype
   */
  @Valid 
  @Schema(name = "giobjecttype", example = "[{\"name\":\"Beispielname\",\"id\":\"COO.2150.9151.1.1206000\"}]", description = "Auflistung aller Objekte, auf die der Suchstring zutrifft.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("giobjecttype")
  public List<@Valid Objektreferenz> getGiobjecttype() {
    return giobjecttype;
  }

  @JsonProperty("giobjecttype")
  public void setGiobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadProcedureResponseDTO readProcedureResponseDTO = (ReadProcedureResponseDTO) o;
    return Objects.equals(this.shortname, readProcedureResponseDTO.shortname) &&
        Objects.equals(this.filesubj, readProcedureResponseDTO.filesubj) &&
        Objects.equals(this.objterms, readProcedureResponseDTO.objterms) &&
        Objects.equals(this.accdef, readProcedureResponseDTO.accdef) &&
        Objects.equals(this.fileruntimefrom, readProcedureResponseDTO.fileruntimefrom) &&
        Objects.equals(this.fileruntimetill, readProcedureResponseDTO.fileruntimetill) &&
        Objects.equals(this.procremark, readProcedureResponseDTO.procremark) &&
        Objects.equals(this.referrednumber, readProcedureResponseDTO.referrednumber) &&
        Objects.equals(this.filetype, readProcedureResponseDTO.filetype) &&
        Objects.equals(this.objname, readProcedureResponseDTO.objname) &&
        Objects.equals(this.objdocstate, readProcedureResponseDTO.objdocstate) &&
        Objects.equals(this.bostate, readProcedureResponseDTO.bostate) &&
        Objects.equals(this.objowngroup, readProcedureResponseDTO.objowngroup) &&
        Objects.equals(this.giobjecttype, readProcedureResponseDTO.giobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, fileruntimefrom, fileruntimetill, procremark, referrednumber, filetype, objname, objdocstate, bostate, objowngroup, giobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadProcedureResponseDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    fileruntimefrom: ").append(toIndentedString(fileruntimefrom)).append("\n");
    sb.append("    fileruntimetill: ").append(toIndentedString(fileruntimetill)).append("\n");
    sb.append("    procremark: ").append(toIndentedString(procremark)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    filetype: ").append(toIndentedString(filetype)).append("\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    objdocstate: ").append(toIndentedString(objdocstate)).append("\n");
    sb.append("    bostate: ").append(toIndentedString(bostate)).append("\n");
    sb.append("    objowngroup: ").append(toIndentedString(objowngroup)).append("\n");
    sb.append("    giobjecttype: ").append(toIndentedString(giobjecttype)).append("\n");
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

    private ReadProcedureResponseDTO instance;

    public Builder() {
      this(new ReadProcedureResponseDTO());
    }

    protected Builder(ReadProcedureResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadProcedureResponseDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setFileruntimefrom(value.fileruntimefrom);
      this.instance.setFileruntimetill(value.fileruntimetill);
      this.instance.setProcremark(value.procremark);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setFiletype(value.filetype);
      this.instance.setObjname(value.objname);
      this.instance.setObjdocstate(value.objdocstate);
      this.instance.setBostate(value.bostate);
      this.instance.setObjowngroup(value.objowngroup);
      this.instance.setGiobjecttype(value.giobjecttype);
      return this;
    }

    public ReadProcedureResponseDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder fileruntimefrom(OffsetDateTime fileruntimefrom) {
      this.instance.fileruntimefrom(fileruntimefrom);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder fileruntimetill(OffsetDateTime fileruntimetill) {
      this.instance.fileruntimetill(fileruntimetill);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder procremark(String procremark) {
      this.instance.procremark(procremark);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder filetype(String filetype) {
      this.instance.filetype(filetype);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder objdocstate(String objdocstate) {
      this.instance.objdocstate(objdocstate);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder bostate(String bostate) {
      this.instance.bostate(bostate);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder objowngroup(String objowngroup) {
      this.instance.objowngroup(objowngroup);
      return this;
    }
    
    public ReadProcedureResponseDTO.Builder giobjecttype(List<Objektreferenz> giobjecttype) {
      this.instance.giobjecttype(giobjecttype);
      return this;
    }
    
    /**
    * returns a built ReadProcedureResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadProcedureResponseDTO build() {
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
  public static ReadProcedureResponseDTO.Builder builder() {
    return new ReadProcedureResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadProcedureResponseDTO.Builder toBuilder() {
    ReadProcedureResponseDTO.Builder builder = new ReadProcedureResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


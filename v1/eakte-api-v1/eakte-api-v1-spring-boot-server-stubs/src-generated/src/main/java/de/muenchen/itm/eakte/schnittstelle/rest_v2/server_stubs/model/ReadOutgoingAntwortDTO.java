package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.MetadataReferenz;
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
 * ReadOutgoingAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadOutgoingAntwortDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private Optional<String> objname = Optional.empty();

  private Optional<String> referrednumber = Optional.empty();

  private Optional<String> referredincoming = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> outgoingdate = Optional.empty();

  private Optional<String> subfiletype = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  @Valid
  private List<@Valid MetadataReferenz> gimetadatatype = new ArrayList<>();

  private Optional<String> searchalso = Optional.empty();

  private Optional<String> businessapp = Optional.empty();

  public ReadOutgoingAntwortDTO shortname(String shortname) {
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

  public ReadOutgoingAntwortDTO filesubj(String filesubj) {
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

  public ReadOutgoingAntwortDTO objterms(String objterms) {
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

  public ReadOutgoingAntwortDTO accdef(String accdef) {
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

  public ReadOutgoingAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Erledigungskennzeichen
   * @return objname
   */
  
  @Schema(name = "objname", example = "Ausgangsschreiben zum Antrag auf Baugenehmigung Firma Mustermann (0010 A20011-4-0006-0006)", description = "Erledigungskennzeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public ReadOutgoingAntwortDTO referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Vorgangs
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042432", description = "Objekt-ID (COO-Adresse) des Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public ReadOutgoingAntwortDTO referredincoming(String referredincoming) {
    this.referredincoming = Optional.ofNullable(referredincoming);
    return this;
  }

  /**
   * Bezug zum Eingang
   * @return referredincoming
   */
  
  @Schema(name = "referredincoming", example = "COO.1.2301.1.1042441", description = "Bezug zum Eingang", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referredincoming")
  public Optional<String> getReferredincoming() {
    return referredincoming;
  }

  @JsonProperty("referredincoming")
  public void setReferredincoming(Optional<String> referredincoming) {
    this.referredincoming = referredincoming;
  }

  public ReadOutgoingAntwortDTO outgoingdate(OffsetDateTime outgoingdate) {
    this.outgoingdate = Optional.ofNullable(outgoingdate);
    return this;
  }

  /**
   * Versanddatum (Datum/Uhrzeit)
   * @return outgoingdate
   */
  @Valid 
  @Schema(name = "outgoingdate", example = "2016-10-26T18:16:29+01:00", description = "Versanddatum (Datum/Uhrzeit)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("outgoingdate")
  public Optional<OffsetDateTime> getOutgoingdate() {
    return outgoingdate;
  }

  @JsonProperty("outgoingdate")
  public void setOutgoingdate(Optional<OffsetDateTime> outgoingdate) {
    this.outgoingdate = outgoingdate;
  }

  public ReadOutgoingAntwortDTO subfiletype(String subfiletype) {
    this.subfiletype = Optional.ofNullable(subfiletype);
    return this;
  }

  /**
   * Dokumenttyp (COOELAK@1.1001:subfiletyp)<br> Plausibilitätsprüfung: Der Name eines im System vorhandenen Dokumenttyps muss angegeben werden.<br> Eine dazugehörige Vorlage (doctemplate) muss nicht verwendet werden.<br> Es können auch finalisierte Schriftstücke der Fachanwendung  über GiAttachmentType übertragen und verwendet werden. 
   * @return subfiletype
   */
  
  @Schema(name = "subfiletype", example = "Vorlagen", description = "Dokumenttyp (COOELAK@1.1001:subfiletyp)<br> Plausibilitätsprüfung: Der Name eines im System vorhandenen Dokumenttyps muss angegeben werden.<br> Eine dazugehörige Vorlage (doctemplate) muss nicht verwendet werden.<br> Es können auch finalisierte Schriftstücke der Fachanwendung  über GiAttachmentType übertragen und verwendet werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subfiletype")
  public Optional<String> getSubfiletype() {
    return subfiletype;
  }

  @JsonProperty("subfiletype")
  public void setSubfiletype(Optional<String> subfiletype) {
    this.subfiletype = subfiletype;
  }

  public ReadOutgoingAntwortDTO incattachments(String incattachments) {
    this.incattachments = Optional.ofNullable(incattachments);
    return this;
  }

  /**
   * Sonstige Anlagen
   * @return incattachments
   */
  
  @Schema(name = "incattachments", example = "Ausfüllhilfe Antrag auf Baugenehmigung", description = "Sonstige Anlagen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incattachments")
  public Optional<String> getIncattachments() {
    return incattachments;
  }

  @JsonProperty("incattachments")
  public void setIncattachments(Optional<String> incattachments) {
    this.incattachments = incattachments;
  }

  public ReadOutgoingAntwortDTO gimetadatatype(List<@Valid MetadataReferenz> gimetadatatype) {
    this.gimetadatatype = gimetadatatype;
    return this;
  }

  public ReadOutgoingAntwortDTO addGimetadatatypeItem(MetadataReferenz gimetadatatypeItem) {
    if (this.gimetadatatype == null) {
      this.gimetadatatype = new ArrayList<>();
    }
    this.gimetadatatype.add(gimetadatatypeItem);
    return this;
  }

  /**
   * Datei
   * @return gimetadatatype
   */
  @Valid 
  @Schema(name = "gimetadatatype", example = "{\"objaddress\":\"COO.1.2301.1.1041875\",\"filename\":\"Antrag auf Baugenehmigung\",\"fileextension\":\"pdf\",\"objclass\":\"PDF-Dokument\",\"contsize\":\"243\",\"objcreatedby\":{\"string\":[\"musterfraum\"]},\"objcreatedat\":\"2018-07-23T08:59:52+01:00\",\"objchangedby\":{\"string\":[\"mustermannm\"]},\"objmodifiedat\":\"2018-07-23T09:23:52+01:00\"}", description = "Datei", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gimetadatatype")
  public List<@Valid MetadataReferenz> getGimetadatatype() {
    return gimetadatatype;
  }

  @JsonProperty("gimetadatatype")
  public void setGimetadatatype(List<@Valid MetadataReferenz> gimetadatatype) {
    this.gimetadatatype = gimetadatatype;
  }

  public ReadOutgoingAntwortDTO searchalso(String searchalso) {
    this.searchalso = Optional.ofNullable(searchalso);
    return this;
  }

  /**
   * Dieser Parameter wird nicht genutzt
   * @return searchalso
   */
  
  @Schema(name = "searchalso", description = "Dieser Parameter wird nicht genutzt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("searchalso")
  public Optional<String> getSearchalso() {
    return searchalso;
  }

  @JsonProperty("searchalso")
  public void setSearchalso(Optional<String> searchalso) {
    this.searchalso = searchalso;
  }

  public ReadOutgoingAntwortDTO businessapp(String businessapp) {
    this.businessapp = Optional.ofNullable(businessapp);
    return this;
  }

  /**
   * Bezeichnung der Fachanwendung/ Dieser Parameter wird nicht weiter unterstützt, sondern über Header-Parameter x-application 
   * @return businessapp
   */
  
  @Schema(name = "businessapp", example = "Fachanwendung xyz", description = "Bezeichnung der Fachanwendung/ Dieser Parameter wird nicht weiter unterstützt, sondern über Header-Parameter x-application ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessapp")
  public Optional<String> getBusinessapp() {
    return businessapp;
  }

  @JsonProperty("businessapp")
  public void setBusinessapp(Optional<String> businessapp) {
    this.businessapp = businessapp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadOutgoingAntwortDTO readOutgoingAntwortDTO = (ReadOutgoingAntwortDTO) o;
    return Objects.equals(this.shortname, readOutgoingAntwortDTO.shortname) &&
        Objects.equals(this.filesubj, readOutgoingAntwortDTO.filesubj) &&
        Objects.equals(this.objterms, readOutgoingAntwortDTO.objterms) &&
        Objects.equals(this.accdef, readOutgoingAntwortDTO.accdef) &&
        Objects.equals(this.objname, readOutgoingAntwortDTO.objname) &&
        Objects.equals(this.referrednumber, readOutgoingAntwortDTO.referrednumber) &&
        Objects.equals(this.referredincoming, readOutgoingAntwortDTO.referredincoming) &&
        Objects.equals(this.outgoingdate, readOutgoingAntwortDTO.outgoingdate) &&
        Objects.equals(this.subfiletype, readOutgoingAntwortDTO.subfiletype) &&
        Objects.equals(this.incattachments, readOutgoingAntwortDTO.incattachments) &&
        Objects.equals(this.gimetadatatype, readOutgoingAntwortDTO.gimetadatatype) &&
        Objects.equals(this.searchalso, readOutgoingAntwortDTO.searchalso) &&
        Objects.equals(this.businessapp, readOutgoingAntwortDTO.businessapp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, objname, referrednumber, referredincoming, outgoingdate, subfiletype, incattachments, gimetadatatype, searchalso, businessapp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadOutgoingAntwortDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    referredincoming: ").append(toIndentedString(referredincoming)).append("\n");
    sb.append("    outgoingdate: ").append(toIndentedString(outgoingdate)).append("\n");
    sb.append("    subfiletype: ").append(toIndentedString(subfiletype)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
    sb.append("    gimetadatatype: ").append(toIndentedString(gimetadatatype)).append("\n");
    sb.append("    searchalso: ").append(toIndentedString(searchalso)).append("\n");
    sb.append("    businessapp: ").append(toIndentedString(businessapp)).append("\n");
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

    private ReadOutgoingAntwortDTO instance;

    public Builder() {
      this(new ReadOutgoingAntwortDTO());
    }

    protected Builder(ReadOutgoingAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadOutgoingAntwortDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setObjname(value.objname);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setReferredincoming(value.referredincoming);
      this.instance.setOutgoingdate(value.outgoingdate);
      this.instance.setSubfiletype(value.subfiletype);
      this.instance.setIncattachments(value.incattachments);
      this.instance.setGimetadatatype(value.gimetadatatype);
      this.instance.setSearchalso(value.searchalso);
      this.instance.setBusinessapp(value.businessapp);
      return this;
    }

    public ReadOutgoingAntwortDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder referredincoming(String referredincoming) {
      this.instance.referredincoming(referredincoming);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder outgoingdate(OffsetDateTime outgoingdate) {
      this.instance.outgoingdate(outgoingdate);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder subfiletype(String subfiletype) {
      this.instance.subfiletype(subfiletype);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder gimetadatatype(List<MetadataReferenz> gimetadatatype) {
      this.instance.gimetadatatype(gimetadatatype);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder searchalso(String searchalso) {
      this.instance.searchalso(searchalso);
      return this;
    }
    
    public ReadOutgoingAntwortDTO.Builder businessapp(String businessapp) {
      this.instance.businessapp(businessapp);
      return this;
    }
    
    /**
    * returns a built ReadOutgoingAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadOutgoingAntwortDTO build() {
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
  public static ReadOutgoingAntwortDTO.Builder builder() {
    return new ReadOutgoingAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadOutgoingAntwortDTO.Builder toBuilder() {
    ReadOutgoingAntwortDTO.Builder builder = new ReadOutgoingAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


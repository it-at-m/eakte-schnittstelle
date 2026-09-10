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
 * Parameter, die das Interne Dokument spezifizieren
 */

@Schema(name = "CreateInternalBodyParams", description = "Parameter, die das Interne Dokument spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateInternalBodyParams {

  private Optional<String> referrednumber = Optional.empty();

  private Optional<String> shortname = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> deliverydate = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> subfiletype = Optional.empty();

  private Optional<String> doctemplate = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> definition = Optional.empty();

  @Valid
  private List<@Valid UserFormsReferenz> userformsdata = new ArrayList<>();

  public CreateInternalBodyParams referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Vorgangs<br> Zugehöriger Vorgang (COOELAK@1.1001:referrednumber)<br> Wenn kein Vorgang angegeben wird, soll das erzeugte interne Dokument am Schreibtisch des Benutzers abgelegt werden. 
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042432", description = "Objekt-ID (COO-Adresse) des Vorgangs<br> Zugehöriger Vorgang (COOELAK@1.1001:referrednumber)<br> Wenn kein Vorgang angegeben wird, soll das erzeugte interne Dokument am Schreibtisch des Benutzers abgelegt werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateInternalBodyParams shortname(String shortname) {
    this.shortname = Optional.ofNullable(shortname);
    return this;
  }

  /**
   * Titel
   * @return shortname
   */
  
  @Schema(name = "shortname", example = "Ausgangsschreiben zum Antrag auf Baugenehmigung Firma", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortname")
  public Optional<String> getShortname() {
    return shortname;
  }

  @JsonProperty("shortname")
  public void setShortname(Optional<String> shortname) {
    this.shortname = shortname;
  }

  public CreateInternalBodyParams accdef(String accdef) {
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

  public CreateInternalBodyParams deliverydate(OffsetDateTime deliverydate) {
    this.deliverydate = Optional.ofNullable(deliverydate);
    return this;
  }

  /**
   * Zustelldatum
   * @return deliverydate
   */
  @Valid 
  @Schema(name = "deliverydate", description = "Zustelldatum", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deliverydate")
  public Optional<OffsetDateTime> getDeliverydate() {
    return deliverydate;
  }

  @JsonProperty("deliverydate")
  public void setDeliverydate(Optional<OffsetDateTime> deliverydate) {
    this.deliverydate = deliverydate;
  }

  public CreateInternalBodyParams filesubj(String filesubj) {
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

  public CreateInternalBodyParams subfiletype(String subfiletype) {
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

  public CreateInternalBodyParams doctemplate(String doctemplate) {
    this.doctemplate = Optional.ofNullable(doctemplate);
    return this;
  }

  /**
   * Vorlage<br> Der Name einer im System vorhandenen Vorlage kann angegeben werden.<br> In dieser Vorlage können beispielsweise Metadaten  automatisiert über DocProperty ausgegeben werden.<br> Die angegebene Vorlage muss im angegebenen Dokumenttyp enthalten sein.  Alternativ können finalisierte Schriftstücke auch über GiAttachmentType übertragen werden. 
   * @return doctemplate
   */
  
  @Schema(name = "doctemplate", example = "LHM Schreiben Extern", description = "Vorlage<br> Der Name einer im System vorhandenen Vorlage kann angegeben werden.<br> In dieser Vorlage können beispielsweise Metadaten  automatisiert über DocProperty ausgegeben werden.<br> Die angegebene Vorlage muss im angegebenen Dokumenttyp enthalten sein.  Alternativ können finalisierte Schriftstücke auch über GiAttachmentType übertragen werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("doctemplate")
  public Optional<String> getDoctemplate() {
    return doctemplate;
  }

  @JsonProperty("doctemplate")
  public void setDoctemplate(Optional<String> doctemplate) {
    this.doctemplate = doctemplate;
  }

  public CreateInternalBodyParams incattachments(String incattachments) {
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

  public CreateInternalBodyParams objterms(String objterms) {
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

  public CreateInternalBodyParams definition(String definition) {
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

  public CreateInternalBodyParams userformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
    return this;
  }

  public CreateInternalBodyParams addUserformsdataItem(UserFormsReferenz userformsdataItem) {
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
    CreateInternalBodyParams createInternalBodyParams = (CreateInternalBodyParams) o;
    return Objects.equals(this.referrednumber, createInternalBodyParams.referrednumber) &&
        Objects.equals(this.shortname, createInternalBodyParams.shortname) &&
        Objects.equals(this.accdef, createInternalBodyParams.accdef) &&
        Objects.equals(this.deliverydate, createInternalBodyParams.deliverydate) &&
        Objects.equals(this.filesubj, createInternalBodyParams.filesubj) &&
        Objects.equals(this.subfiletype, createInternalBodyParams.subfiletype) &&
        Objects.equals(this.doctemplate, createInternalBodyParams.doctemplate) &&
        Objects.equals(this.incattachments, createInternalBodyParams.incattachments) &&
        Objects.equals(this.objterms, createInternalBodyParams.objterms) &&
        Objects.equals(this.definition, createInternalBodyParams.definition) &&
        Objects.equals(this.userformsdata, createInternalBodyParams.userformsdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, shortname, accdef, deliverydate, filesubj, subfiletype, doctemplate, incattachments, objterms, definition, userformsdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateInternalBodyParams {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    deliverydate: ").append(toIndentedString(deliverydate)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    subfiletype: ").append(toIndentedString(subfiletype)).append("\n");
    sb.append("    doctemplate: ").append(toIndentedString(doctemplate)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
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

    private CreateInternalBodyParams instance;

    public Builder() {
      this(new CreateInternalBodyParams());
    }

    protected Builder(CreateInternalBodyParams instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateInternalBodyParams value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setShortname(value.shortname);
      this.instance.setAccdef(value.accdef);
      this.instance.setDeliverydate(value.deliverydate);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setSubfiletype(value.subfiletype);
      this.instance.setDoctemplate(value.doctemplate);
      this.instance.setIncattachments(value.incattachments);
      this.instance.setObjterms(value.objterms);
      this.instance.setDefinition(value.definition);
      this.instance.setUserformsdata(value.userformsdata);
      return this;
    }

    public CreateInternalBodyParams.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateInternalBodyParams.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public CreateInternalBodyParams.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public CreateInternalBodyParams.Builder deliverydate(OffsetDateTime deliverydate) {
      this.instance.deliverydate(deliverydate);
      return this;
    }
    
    public CreateInternalBodyParams.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public CreateInternalBodyParams.Builder subfiletype(String subfiletype) {
      this.instance.subfiletype(subfiletype);
      return this;
    }
    
    public CreateInternalBodyParams.Builder doctemplate(String doctemplate) {
      this.instance.doctemplate(doctemplate);
      return this;
    }
    
    public CreateInternalBodyParams.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    public CreateInternalBodyParams.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public CreateInternalBodyParams.Builder definition(String definition) {
      this.instance.definition(definition);
      return this;
    }
    
    public CreateInternalBodyParams.Builder userformsdata(List<UserFormsReferenz> userformsdata) {
      this.instance.userformsdata(userformsdata);
      return this;
    }
    
    /**
    * returns a built CreateInternalBodyParams instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateInternalBodyParams build() {
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
  public static CreateInternalBodyParams.Builder builder() {
    return new CreateInternalBodyParams.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateInternalBodyParams.Builder toBuilder() {
    CreateInternalBodyParams.Builder builder = new CreateInternalBodyParams.Builder();
    return builder.copyOf(this);
  }

}


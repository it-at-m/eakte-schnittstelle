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
 * Parameter, die die Erledigung spezifizieren
 */

@Schema(name = "CreateOutgoingAnfrageDTO", description = "Parameter, die die Erledigung spezifizieren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateOutgoingAnfrageDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private String referrednumber;

  private Optional<String> referredincoming = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> outgoingdate = Optional.empty();

  private Optional<String> subfiletype = Optional.empty();

  private Optional<String> doctemplate = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  private Optional<String> definition = Optional.empty();

  @Valid
  private List<@Valid UserFormsReferenz> userformsdata = new ArrayList<>();

  public CreateOutgoingAnfrageDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateOutgoingAnfrageDTO(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateOutgoingAnfrageDTO shortname(String shortname) {
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

  public CreateOutgoingAnfrageDTO filesubj(String filesubj) {
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

  public CreateOutgoingAnfrageDTO objterms(String objterms) {
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

  public CreateOutgoingAnfrageDTO accdef(String accdef) {
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

  public CreateOutgoingAnfrageDTO referrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Vorgangs\\ Wenn kein Vorgang angegeben wird, soll das erzeugte Erledigungsdokument am Schreibtisch des Benutzers abgelegt werden. 
   * @return referrednumber
   */
  @NotNull 
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042432", description = "Objekt-ID (COO-Adresse) des Vorgangs\\ Wenn kein Vorgang angegeben wird, soll das erzeugte Erledigungsdokument am Schreibtisch des Benutzers abgelegt werden. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("referrednumber")
  public String getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(String referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateOutgoingAnfrageDTO referredincoming(String referredincoming) {
    this.referredincoming = Optional.ofNullable(referredincoming);
    return this;
  }

  /**
   * Bezug zum Eingang\\ Bei Bedarf kann die COO-Adresse des Eingangs angegeben werden, damit ein direkter Bezug zwischen Eingang und Erledigung hergestellt werden kann. 
   * @return referredincoming
   */
  
  @Schema(name = "referredincoming", example = "COO.1.2301.1.1042441", description = "Bezug zum Eingang\\ Bei Bedarf kann die COO-Adresse des Eingangs angegeben werden, damit ein direkter Bezug zwischen Eingang und Erledigung hergestellt werden kann. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referredincoming")
  public Optional<String> getReferredincoming() {
    return referredincoming;
  }

  @JsonProperty("referredincoming")
  public void setReferredincoming(Optional<String> referredincoming) {
    this.referredincoming = referredincoming;
  }

  public CreateOutgoingAnfrageDTO outgoingdate(OffsetDateTime outgoingdate) {
    this.outgoingdate = Optional.ofNullable(outgoingdate);
    return this;
  }

  /**
   * Versanddatum (Datum/Uhrzeit)
   * @return outgoingdate
   */
  @Valid 
  @Schema(name = "outgoingdate", description = "Versanddatum (Datum/Uhrzeit)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("outgoingdate")
  public Optional<OffsetDateTime> getOutgoingdate() {
    return outgoingdate;
  }

  @JsonProperty("outgoingdate")
  public void setOutgoingdate(Optional<OffsetDateTime> outgoingdate) {
    this.outgoingdate = outgoingdate;
  }

  public CreateOutgoingAnfrageDTO subfiletype(String subfiletype) {
    this.subfiletype = Optional.ofNullable(subfiletype);
    return this;
  }

  /**
   * Dokumenttyp (COOELAK@1.1001:subfiletyp)\\ Plausibilitätsprüfung: Der Name eines im System vorhandenen Dokumenttyps muss angegeben werden.\\ Eine dazugehörige Vorlage (doctemplate) muss nicht verwendet werden.\\ Es können auch finalisierte Schriftstücke der Fachanwendung  über GiAttachmentType übertragen und verwendet werden. 
   * @return subfiletype
   */
  
  @Schema(name = "subfiletype", example = "Vorlagen", description = "Dokumenttyp (COOELAK@1.1001:subfiletyp)\\ Plausibilitätsprüfung: Der Name eines im System vorhandenen Dokumenttyps muss angegeben werden.\\ Eine dazugehörige Vorlage (doctemplate) muss nicht verwendet werden.\\ Es können auch finalisierte Schriftstücke der Fachanwendung  über GiAttachmentType übertragen und verwendet werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subfiletype")
  public Optional<String> getSubfiletype() {
    return subfiletype;
  }

  @JsonProperty("subfiletype")
  public void setSubfiletype(Optional<String> subfiletype) {
    this.subfiletype = subfiletype;
  }

  public CreateOutgoingAnfrageDTO doctemplate(String doctemplate) {
    this.doctemplate = Optional.ofNullable(doctemplate);
    return this;
  }

  /**
   * Der Name einer im System vorhandenen Vorlage kann angegeben werden (COOELAK@1.1001:doctemplate).\\ In dieser Vorlage können beispielsweise Metadaten automatisiert über DocProperty ausgegeben werden.\\ Die angegebene Vorlage muss im angegebenen Dokumenttyp enthalten sein. Alternativ können finalisierte Schriftstücke auch über GiAttachmentType übertragen werden. 
   * @return doctemplate
   */
  
  @Schema(name = "doctemplate", example = "LHM Schreiben Extern", description = "Der Name einer im System vorhandenen Vorlage kann angegeben werden (COOELAK@1.1001:doctemplate).\\ In dieser Vorlage können beispielsweise Metadaten automatisiert über DocProperty ausgegeben werden.\\ Die angegebene Vorlage muss im angegebenen Dokumenttyp enthalten sein. Alternativ können finalisierte Schriftstücke auch über GiAttachmentType übertragen werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("doctemplate")
  public Optional<String> getDoctemplate() {
    return doctemplate;
  }

  @JsonProperty("doctemplate")
  public void setDoctemplate(Optional<String> doctemplate) {
    this.doctemplate = doctemplate;
  }

  public CreateOutgoingAnfrageDTO incattachments(String incattachments) {
    this.incattachments = Optional.ofNullable(incattachments);
    return this;
  }

  /**
   * Sonstige Anlagen\\ Freitextfeld, um zusätzliche Anlagen zu benennen, die nicht elektronisch erfasst wurden (z.B. Baupläne) 
   * @return incattachments
   */
  
  @Schema(name = "incattachments", example = "Ausfüllhilfe Antrag auf Baugenehmigung", description = "Sonstige Anlagen\\ Freitextfeld, um zusätzliche Anlagen zu benennen, die nicht elektronisch erfasst wurden (z.B. Baupläne) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incattachments")
  public Optional<String> getIncattachments() {
    return incattachments;
  }

  @JsonProperty("incattachments")
  public void setIncattachments(Optional<String> incattachments) {
    this.incattachments = incattachments;
  }

  public CreateOutgoingAnfrageDTO definition(String definition) {
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

  public CreateOutgoingAnfrageDTO userformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
    return this;
  }

  public CreateOutgoingAnfrageDTO addUserformsdataItem(UserFormsReferenz userformsdataItem) {
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
    CreateOutgoingAnfrageDTO createOutgoingAnfrageDTO = (CreateOutgoingAnfrageDTO) o;
    return Objects.equals(this.shortname, createOutgoingAnfrageDTO.shortname) &&
        Objects.equals(this.filesubj, createOutgoingAnfrageDTO.filesubj) &&
        Objects.equals(this.objterms, createOutgoingAnfrageDTO.objterms) &&
        Objects.equals(this.accdef, createOutgoingAnfrageDTO.accdef) &&
        Objects.equals(this.referrednumber, createOutgoingAnfrageDTO.referrednumber) &&
        Objects.equals(this.referredincoming, createOutgoingAnfrageDTO.referredincoming) &&
        Objects.equals(this.outgoingdate, createOutgoingAnfrageDTO.outgoingdate) &&
        Objects.equals(this.subfiletype, createOutgoingAnfrageDTO.subfiletype) &&
        Objects.equals(this.doctemplate, createOutgoingAnfrageDTO.doctemplate) &&
        Objects.equals(this.incattachments, createOutgoingAnfrageDTO.incattachments) &&
        Objects.equals(this.definition, createOutgoingAnfrageDTO.definition) &&
        Objects.equals(this.userformsdata, createOutgoingAnfrageDTO.userformsdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, referrednumber, referredincoming, outgoingdate, subfiletype, doctemplate, incattachments, definition, userformsdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOutgoingAnfrageDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    referredincoming: ").append(toIndentedString(referredincoming)).append("\n");
    sb.append("    outgoingdate: ").append(toIndentedString(outgoingdate)).append("\n");
    sb.append("    subfiletype: ").append(toIndentedString(subfiletype)).append("\n");
    sb.append("    doctemplate: ").append(toIndentedString(doctemplate)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
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

    private CreateOutgoingAnfrageDTO instance;

    public Builder() {
      this(new CreateOutgoingAnfrageDTO());
    }

    protected Builder(CreateOutgoingAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateOutgoingAnfrageDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setReferredincoming(value.referredincoming);
      this.instance.setOutgoingdate(value.outgoingdate);
      this.instance.setSubfiletype(value.subfiletype);
      this.instance.setDoctemplate(value.doctemplate);
      this.instance.setIncattachments(value.incattachments);
      this.instance.setDefinition(value.definition);
      this.instance.setUserformsdata(value.userformsdata);
      return this;
    }

    public CreateOutgoingAnfrageDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder referredincoming(String referredincoming) {
      this.instance.referredincoming(referredincoming);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder outgoingdate(OffsetDateTime outgoingdate) {
      this.instance.outgoingdate(outgoingdate);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder subfiletype(String subfiletype) {
      this.instance.subfiletype(subfiletype);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder doctemplate(String doctemplate) {
      this.instance.doctemplate(doctemplate);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder definition(String definition) {
      this.instance.definition(definition);
      return this;
    }
    
    public CreateOutgoingAnfrageDTO.Builder userformsdata(List<UserFormsReferenz> userformsdata) {
      this.instance.userformsdata(userformsdata);
      return this;
    }
    
    /**
    * returns a built CreateOutgoingAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateOutgoingAnfrageDTO build() {
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
  public static CreateOutgoingAnfrageDTO.Builder builder() {
    return new CreateOutgoingAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateOutgoingAnfrageDTO.Builder toBuilder() {
    CreateOutgoingAnfrageDTO.Builder builder = new CreateOutgoingAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


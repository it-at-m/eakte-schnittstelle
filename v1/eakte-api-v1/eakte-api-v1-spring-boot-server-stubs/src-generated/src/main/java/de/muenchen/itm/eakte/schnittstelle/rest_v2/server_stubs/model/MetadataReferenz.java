package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ArrayOfstring;
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
 * MetadataReferenz
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class MetadataReferenz {

  private Optional<String> objaddress = Optional.empty();

  private Optional<String> filename = Optional.empty();

  private Optional<String> fileextension = Optional.empty();

  private Optional<String> objclass = Optional.empty();

  private Optional<String> contsize = Optional.empty();

  private Optional<ArrayOfstring> objcreatedby = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> objcreatedat = Optional.empty();

  private Optional<ArrayOfstring> objchangedby = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> objmodifiedat = Optional.empty();

  public MetadataReferenz objaddress(String objaddress) {
    this.objaddress = Optional.ofNullable(objaddress);
    return this;
  }

  /**
   * COO-Adresse des Objekts
   * @return objaddress
   */
  
  @Schema(name = "objaddress", example = "COO.1.2301.1.1041875", description = "COO-Adresse des Objekts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objaddress")
  public Optional<String> getObjaddress() {
    return objaddress;
  }

  @JsonProperty("objaddress")
  public void setObjaddress(Optional<String> objaddress) {
    this.objaddress = objaddress;
  }

  public MetadataReferenz filename(String filename) {
    this.filename = Optional.ofNullable(filename);
    return this;
  }

  /**
   * Dateiname
   * @return filename
   */
  
  @Schema(name = "filename", example = "Brief an Dr. Müller", description = "Dateiname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filename")
  public Optional<String> getFilename() {
    return filename;
  }

  @JsonProperty("filename")
  public void setFilename(Optional<String> filename) {
    this.filename = filename;
  }

  public MetadataReferenz fileextension(String fileextension) {
    this.fileextension = Optional.ofNullable(fileextension);
    return this;
  }

  /**
   * Dateiendung
   * @return fileextension
   */
  
  @Schema(name = "fileextension", example = "txt", description = "Dateiendung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileextension")
  public Optional<String> getFileextension() {
    return fileextension;
  }

  @JsonProperty("fileextension")
  public void setFileextension(Optional<String> fileextension) {
    this.fileextension = fileextension;
  }

  public MetadataReferenz objclass(String objclass) {
    this.objclass = Optional.ofNullable(objclass);
    return this;
  }

  /**
   * Name der Objektklasse (COOSYSTEM@1.1:objclass) * Aktenplan (COOELAK@1.1001:Fileplan) * Aktenplaneintrag (COOELAK@1.1001:SubjectArea) * Erledigung (COOELAK@1.1001:Outgoing) * AutoCAD Zeichnung (FSCAUTOCAD@1.1001:Drawing) * Benutzer (COOSYSTEM@1.1:User) * Bericht (FSCAREXT@1.1001:Report) * Bild (FSCWEBCONT@1.1001:ImageObject) * Dokumentkategorie (FSCFOLIO@1.1001:DocumentCategory) * Dokumenttyp (COOELAK@1.1001:Subject) * Dokument (COOELAK@1.1001:SubFileDocument)  (bei Angabe dieser Objektklasse, sollten Eingangs-, und Erledigungsdokumente angezeigt werden) * E-Mail (Microsoft Office Outlook) (COOMAPI@1.1:MailObject) * E-Mail (MIME) FSCMIME(@1.1001:MIMEObject) * Eingangsdokument (COOELAK@1.1001:Incoming) * Freemind Mindmap (CFGMUENCHEN@15.1700:FreemindMindmap) * Frist (ELAKGOV@1.1001:Deadline) * GIF-Objekt (FSCWEBCONT@1.1001:GIFObject) * Hewlett Packard Graphic Language (CFGMUENCHEN@15.1700:HPGraphicLanguage) * Inhalt (erweitert) (CFGMUENCHEN@15.1700:GenericContent) * Inhalt (unbekannter Typ) (GENCONT@1.1:ContentObject) * JPEG-Objekt (FSCWEBCONT@1.1001:JPEGObject) * Kostenstelle (CFGMUENCHEN@15.1700:CostCenter) * Medieninhalt (FSCDIGITALASSET@1.1001:DigitalAsset) * Microsoft Excel-Arbeitsblatt (COOMSOFFICE@1.1:ExcelObject) * Microsoft PowerPoint-Präsentation (COOMSOFFICE@1.1:PowerPointObject) * Microsoft Project-Objekt (COOMSPROJECT@1.1001:MSProject)        t * Microsoft Visio-Zeichnung (VISIO@1.1:VisioObject) * Microsoft Word-Objekt (COOMSOFFICE@1.1:WinWordObject) * OpenDocument Formel (FSCOOFFICE@1.1001:OOorgMathObject) * OpenOffice.org Vorlage (CFGMUENCHEN@15.1700:OOorgTemplateObject) * Ordner (COODESK@1.1:Folder) * Organisation (FSCFOLIO@1.1001:Organisation) * Organisationseinheit (COOSYSTEM@1.1:Group) * PDF-Dokument (FSCACROBAT@1.1:PDFObject) * Person (FSCFOLIO@1.1001:Person) * Personenakte (CFGMUENCHEN@15.1700:PersonalSubjectAreaFile) * PNG-Objekt (FSCWEBCONT@1.1001:PNGObject) * Postkorb (FSCVGOV@1.1001:Inbox) * Präsentation (FSCOOFFICE@1.1001:OOorgPresObject) * Projektordner (COOELAK@1.1001:ProjectFolder) * Rechnungsposition (CFGMUENCHEN@15.1700:InvoiceItem) * Rich Text Format (CFGMUENCHEN@15.1700:RichTextFormat) * Sachakte (DEPRECONFIG@15.1001:SubjectAreaFile) * Schlagwort (FSCTERM@1.1001:Term) * Schmierzettel (ELAKGOV@1.1001:FileMemo) * Schriftstück (COOSYSTEM@1.1:ContentObject) * Serena OpenProj Projekt (CFGMUENCHEN@15.1700:SerenaOpenProj) * Suchordner (COOQBOL@1.1:GenericStoredQBOL) * Tabelle (FSCOOFFICE@1.1001:OOorgCalcObject) * Teamroom (FSCTEAMROOM@1.1001:TeamRoom) * Text-Dokument (NOTE@1.1:NoteObject) * Textbaustein (COOAR@1.1:BasicTextModuleEx_Web) * Textdokument (FSCOOFFICE@1.1001:OOorgTextObject) * TIFF-Objekt (FSCWEBCONT@1.1001:TIFFObject) * Verteiler (COOELAK@1.1001:DistributionList) * Verteilerliste (COOWF@1.1:ParticipantInstance) * Vorgang (DEPRECONFIG@15.1001:Procedure) * Vorlagenkategorie (COOTC@1.1001:TemplateCategory) * XDOMEA Paket (FSCGOVXMLDE@1.1001:XDOMEAPackage) * Zeichnung (FSCOOFFICE@1.1001:OOorgDrawObject) * Zip-Archiv (WINZIP@1.1001:WinZipObject) 
   * @return objclass
   */
  
  @Schema(name = "objclass", example = "Erledigung", description = "Name der Objektklasse (COOSYSTEM@1.1:objclass) * Aktenplan (COOELAK@1.1001:Fileplan) * Aktenplaneintrag (COOELAK@1.1001:SubjectArea) * Erledigung (COOELAK@1.1001:Outgoing) * AutoCAD Zeichnung (FSCAUTOCAD@1.1001:Drawing) * Benutzer (COOSYSTEM@1.1:User) * Bericht (FSCAREXT@1.1001:Report) * Bild (FSCWEBCONT@1.1001:ImageObject) * Dokumentkategorie (FSCFOLIO@1.1001:DocumentCategory) * Dokumenttyp (COOELAK@1.1001:Subject) * Dokument (COOELAK@1.1001:SubFileDocument)  (bei Angabe dieser Objektklasse, sollten Eingangs-, und Erledigungsdokumente angezeigt werden) * E-Mail (Microsoft Office Outlook) (COOMAPI@1.1:MailObject) * E-Mail (MIME) FSCMIME(@1.1001:MIMEObject) * Eingangsdokument (COOELAK@1.1001:Incoming) * Freemind Mindmap (CFGMUENCHEN@15.1700:FreemindMindmap) * Frist (ELAKGOV@1.1001:Deadline) * GIF-Objekt (FSCWEBCONT@1.1001:GIFObject) * Hewlett Packard Graphic Language (CFGMUENCHEN@15.1700:HPGraphicLanguage) * Inhalt (erweitert) (CFGMUENCHEN@15.1700:GenericContent) * Inhalt (unbekannter Typ) (GENCONT@1.1:ContentObject) * JPEG-Objekt (FSCWEBCONT@1.1001:JPEGObject) * Kostenstelle (CFGMUENCHEN@15.1700:CostCenter) * Medieninhalt (FSCDIGITALASSET@1.1001:DigitalAsset) * Microsoft Excel-Arbeitsblatt (COOMSOFFICE@1.1:ExcelObject) * Microsoft PowerPoint-Präsentation (COOMSOFFICE@1.1:PowerPointObject) * Microsoft Project-Objekt (COOMSPROJECT@1.1001:MSProject)        t * Microsoft Visio-Zeichnung (VISIO@1.1:VisioObject) * Microsoft Word-Objekt (COOMSOFFICE@1.1:WinWordObject) * OpenDocument Formel (FSCOOFFICE@1.1001:OOorgMathObject) * OpenOffice.org Vorlage (CFGMUENCHEN@15.1700:OOorgTemplateObject) * Ordner (COODESK@1.1:Folder) * Organisation (FSCFOLIO@1.1001:Organisation) * Organisationseinheit (COOSYSTEM@1.1:Group) * PDF-Dokument (FSCACROBAT@1.1:PDFObject) * Person (FSCFOLIO@1.1001:Person) * Personenakte (CFGMUENCHEN@15.1700:PersonalSubjectAreaFile) * PNG-Objekt (FSCWEBCONT@1.1001:PNGObject) * Postkorb (FSCVGOV@1.1001:Inbox) * Präsentation (FSCOOFFICE@1.1001:OOorgPresObject) * Projektordner (COOELAK@1.1001:ProjectFolder) * Rechnungsposition (CFGMUENCHEN@15.1700:InvoiceItem) * Rich Text Format (CFGMUENCHEN@15.1700:RichTextFormat) * Sachakte (DEPRECONFIG@15.1001:SubjectAreaFile) * Schlagwort (FSCTERM@1.1001:Term) * Schmierzettel (ELAKGOV@1.1001:FileMemo) * Schriftstück (COOSYSTEM@1.1:ContentObject) * Serena OpenProj Projekt (CFGMUENCHEN@15.1700:SerenaOpenProj) * Suchordner (COOQBOL@1.1:GenericStoredQBOL) * Tabelle (FSCOOFFICE@1.1001:OOorgCalcObject) * Teamroom (FSCTEAMROOM@1.1001:TeamRoom) * Text-Dokument (NOTE@1.1:NoteObject) * Textbaustein (COOAR@1.1:BasicTextModuleEx_Web) * Textdokument (FSCOOFFICE@1.1001:OOorgTextObject) * TIFF-Objekt (FSCWEBCONT@1.1001:TIFFObject) * Verteiler (COOELAK@1.1001:DistributionList) * Verteilerliste (COOWF@1.1:ParticipantInstance) * Vorgang (DEPRECONFIG@15.1001:Procedure) * Vorlagenkategorie (COOTC@1.1001:TemplateCategory) * XDOMEA Paket (FSCGOVXMLDE@1.1001:XDOMEAPackage) * Zeichnung (FSCOOFFICE@1.1001:OOorgDrawObject) * Zip-Archiv (WINZIP@1.1001:WinZipObject) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objclass")
  public Optional<String> getObjclass() {
    return objclass;
  }

  @JsonProperty("objclass")
  public void setObjclass(Optional<String> objclass) {
    this.objclass = objclass;
  }

  public MetadataReferenz contsize(String contsize) {
    this.contsize = Optional.ofNullable(contsize);
    return this;
  }

  /**
   * Größe der Inhalte (in KB)
   * @return contsize
   */
  
  @Schema(name = "contsize", example = "5", description = "Größe der Inhalte (in KB)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contsize")
  public Optional<String> getContsize() {
    return contsize;
  }

  @JsonProperty("contsize")
  public void setContsize(Optional<String> contsize) {
    this.contsize = contsize;
  }

  public MetadataReferenz objcreatedby(ArrayOfstring objcreatedby) {
    this.objcreatedby = Optional.ofNullable(objcreatedby);
    return this;
  }

  /**
   * Get objcreatedby
   * @return objcreatedby
   */
  @Valid 
  @Schema(name = "objcreatedby", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objcreatedby")
  public Optional<ArrayOfstring> getObjcreatedby() {
    return objcreatedby;
  }

  @JsonProperty("objcreatedby")
  public void setObjcreatedby(Optional<ArrayOfstring> objcreatedby) {
    this.objcreatedby = objcreatedby;
  }

  public MetadataReferenz objcreatedat(OffsetDateTime objcreatedat) {
    this.objcreatedat = Optional.ofNullable(objcreatedat);
    return this;
  }

  /**
   * erzeugt am/um  Datumsformat: YYYY-MM-DDTHH:MM:SS+HH:MM\\ - = Trenner zusammengehörende Werte\\ YYYY = 4 Stellen für das Jahr\\ MM = 2 Stellen für den Monat\\ DD = 4 Stellen für das Jahr\\ T = Trenner Datum und Uhrzeit\\ HH = 2 Stellen für die Stunden\\ MM = 2 Stellen für die Minuten\\ SS = 2 Stellen für die Sekunden\\ + = Trenner Uhrzeit und Zeitzone\\ TH = Zeitzone in Stunden\\ TM = Zeitzone in Minuten 
   * @return objcreatedat
   */
  @Valid 
  @Schema(name = "objcreatedat", example = "2018-07-23T08:59:52+01:00", description = "erzeugt am/um  Datumsformat: YYYY-MM-DDTHH:MM:SS+HH:MM\\ - = Trenner zusammengehörende Werte\\ YYYY = 4 Stellen für das Jahr\\ MM = 2 Stellen für den Monat\\ DD = 4 Stellen für das Jahr\\ T = Trenner Datum und Uhrzeit\\ HH = 2 Stellen für die Stunden\\ MM = 2 Stellen für die Minuten\\ SS = 2 Stellen für die Sekunden\\ + = Trenner Uhrzeit und Zeitzone\\ TH = Zeitzone in Stunden\\ TM = Zeitzone in Minuten ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objcreatedat")
  public Optional<OffsetDateTime> getObjcreatedat() {
    return objcreatedat;
  }

  @JsonProperty("objcreatedat")
  public void setObjcreatedat(Optional<OffsetDateTime> objcreatedat) {
    this.objcreatedat = objcreatedat;
  }

  public MetadataReferenz objchangedby(ArrayOfstring objchangedby) {
    this.objchangedby = Optional.ofNullable(objchangedby);
    return this;
  }

  /**
   * Get objchangedby
   * @return objchangedby
   */
  @Valid 
  @Schema(name = "objchangedby", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objchangedby")
  public Optional<ArrayOfstring> getObjchangedby() {
    return objchangedby;
  }

  @JsonProperty("objchangedby")
  public void setObjchangedby(Optional<ArrayOfstring> objchangedby) {
    this.objchangedby = objchangedby;
  }

  public MetadataReferenz objmodifiedat(OffsetDateTime objmodifiedat) {
    this.objmodifiedat = Optional.ofNullable(objmodifiedat);
    return this;
  }

  /**
   * Letzte Änderung am/um
   * @return objmodifiedat
   */
  @Valid 
  @Schema(name = "objmodifiedat", example = "2018-07-23T10:39:32+01:00", description = "Letzte Änderung am/um", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objmodifiedat")
  public Optional<OffsetDateTime> getObjmodifiedat() {
    return objmodifiedat;
  }

  @JsonProperty("objmodifiedat")
  public void setObjmodifiedat(Optional<OffsetDateTime> objmodifiedat) {
    this.objmodifiedat = objmodifiedat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataReferenz metadataReferenz = (MetadataReferenz) o;
    return Objects.equals(this.objaddress, metadataReferenz.objaddress) &&
        Objects.equals(this.filename, metadataReferenz.filename) &&
        Objects.equals(this.fileextension, metadataReferenz.fileextension) &&
        Objects.equals(this.objclass, metadataReferenz.objclass) &&
        Objects.equals(this.contsize, metadataReferenz.contsize) &&
        Objects.equals(this.objcreatedby, metadataReferenz.objcreatedby) &&
        Objects.equals(this.objcreatedat, metadataReferenz.objcreatedat) &&
        Objects.equals(this.objchangedby, metadataReferenz.objchangedby) &&
        Objects.equals(this.objmodifiedat, metadataReferenz.objmodifiedat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objaddress, filename, fileextension, objclass, contsize, objcreatedby, objcreatedat, objchangedby, objmodifiedat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataReferenz {\n");
    sb.append("    objaddress: ").append(toIndentedString(objaddress)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    fileextension: ").append(toIndentedString(fileextension)).append("\n");
    sb.append("    objclass: ").append(toIndentedString(objclass)).append("\n");
    sb.append("    contsize: ").append(toIndentedString(contsize)).append("\n");
    sb.append("    objcreatedby: ").append(toIndentedString(objcreatedby)).append("\n");
    sb.append("    objcreatedat: ").append(toIndentedString(objcreatedat)).append("\n");
    sb.append("    objchangedby: ").append(toIndentedString(objchangedby)).append("\n");
    sb.append("    objmodifiedat: ").append(toIndentedString(objmodifiedat)).append("\n");
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

    private MetadataReferenz instance;

    public Builder() {
      this(new MetadataReferenz());
    }

    protected Builder(MetadataReferenz instance) {
      this.instance = instance;
    }

    protected Builder copyOf(MetadataReferenz value) { 
      this.instance.setObjaddress(value.objaddress);
      this.instance.setFilename(value.filename);
      this.instance.setFileextension(value.fileextension);
      this.instance.setObjclass(value.objclass);
      this.instance.setContsize(value.contsize);
      this.instance.setObjcreatedby(value.objcreatedby);
      this.instance.setObjcreatedat(value.objcreatedat);
      this.instance.setObjchangedby(value.objchangedby);
      this.instance.setObjmodifiedat(value.objmodifiedat);
      return this;
    }

    public MetadataReferenz.Builder objaddress(String objaddress) {
      this.instance.objaddress(objaddress);
      return this;
    }
    
    public MetadataReferenz.Builder filename(String filename) {
      this.instance.filename(filename);
      return this;
    }
    
    public MetadataReferenz.Builder fileextension(String fileextension) {
      this.instance.fileextension(fileextension);
      return this;
    }
    
    public MetadataReferenz.Builder objclass(String objclass) {
      this.instance.objclass(objclass);
      return this;
    }
    
    public MetadataReferenz.Builder contsize(String contsize) {
      this.instance.contsize(contsize);
      return this;
    }
    
    public MetadataReferenz.Builder objcreatedby(ArrayOfstring objcreatedby) {
      this.instance.objcreatedby(objcreatedby);
      return this;
    }
    
    public MetadataReferenz.Builder objcreatedat(OffsetDateTime objcreatedat) {
      this.instance.objcreatedat(objcreatedat);
      return this;
    }
    
    public MetadataReferenz.Builder objchangedby(ArrayOfstring objchangedby) {
      this.instance.objchangedby(objchangedby);
      return this;
    }
    
    public MetadataReferenz.Builder objmodifiedat(OffsetDateTime objmodifiedat) {
      this.instance.objmodifiedat(objmodifiedat);
      return this;
    }
    
    /**
    * returns a built MetadataReferenz instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public MetadataReferenz build() {
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
  public static MetadataReferenz.Builder builder() {
    return new MetadataReferenz.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public MetadataReferenz.Builder toBuilder() {
    MetadataReferenz.Builder builder = new MetadataReferenz.Builder();
    return builder.copyOf(this);
  }

}


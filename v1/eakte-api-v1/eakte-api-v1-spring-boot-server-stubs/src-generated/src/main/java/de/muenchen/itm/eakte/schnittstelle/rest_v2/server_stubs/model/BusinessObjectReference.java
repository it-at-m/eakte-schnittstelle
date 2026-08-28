package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ArrayOfstring;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ObjChangedBy;
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
 * Liste der Dokumente mit Metadaten eines Vorgangs auslesen
 */

@Schema(name = "BusinessObjectReference", description = "Liste der Dokumente mit Metadaten eines Vorgangs auslesen")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class BusinessObjectReference {

  private Optional<String> objname = Optional.empty();

  private Optional<String> objaddress = Optional.empty();

  private Optional<String> objclass = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> objcreatedat = Optional.empty();

  private Optional<ArrayOfstring> objcreatedby = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> objmodifiedat = Optional.empty();

  private Optional<ObjChangedBy> objchangedby = Optional.empty();

  private Optional<String> objowner = Optional.empty();

  private Optional<String> objou = Optional.empty();

  private Optional<String> fileextension = Optional.empty();

  private Optional<String> contsize = Optional.empty();

  public BusinessObjectReference objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Get objname
   * @return objname
   */
  
  @Schema(name = "objname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public BusinessObjectReference objaddress(String objaddress) {
    this.objaddress = Optional.ofNullable(objaddress);
    return this;
  }

  /**
   * Get objaddress
   * @return objaddress
   */
  
  @Schema(name = "objaddress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objaddress")
  public Optional<String> getObjaddress() {
    return objaddress;
  }

  @JsonProperty("objaddress")
  public void setObjaddress(Optional<String> objaddress) {
    this.objaddress = objaddress;
  }

  public BusinessObjectReference objclass(String objclass) {
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

  public BusinessObjectReference objcreatedat(OffsetDateTime objcreatedat) {
    this.objcreatedat = Optional.ofNullable(objcreatedat);
    return this;
  }

  /**
   * Get objcreatedat
   * @return objcreatedat
   */
  @Valid 
  @Schema(name = "objcreatedat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objcreatedat")
  public Optional<OffsetDateTime> getObjcreatedat() {
    return objcreatedat;
  }

  @JsonProperty("objcreatedat")
  public void setObjcreatedat(Optional<OffsetDateTime> objcreatedat) {
    this.objcreatedat = objcreatedat;
  }

  public BusinessObjectReference objcreatedby(ArrayOfstring objcreatedby) {
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

  public BusinessObjectReference objmodifiedat(OffsetDateTime objmodifiedat) {
    this.objmodifiedat = Optional.ofNullable(objmodifiedat);
    return this;
  }

  /**
   * Get objmodifiedat
   * @return objmodifiedat
   */
  @Valid 
  @Schema(name = "objmodifiedat", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objmodifiedat")
  public Optional<OffsetDateTime> getObjmodifiedat() {
    return objmodifiedat;
  }

  @JsonProperty("objmodifiedat")
  public void setObjmodifiedat(Optional<OffsetDateTime> objmodifiedat) {
    this.objmodifiedat = objmodifiedat;
  }

  public BusinessObjectReference objchangedby(ObjChangedBy objchangedby) {
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
  public Optional<ObjChangedBy> getObjchangedby() {
    return objchangedby;
  }

  @JsonProperty("objchangedby")
  public void setObjchangedby(Optional<ObjChangedBy> objchangedby) {
    this.objchangedby = objchangedby;
  }

  public BusinessObjectReference objowner(String objowner) {
    this.objowner = Optional.ofNullable(objowner);
    return this;
  }

  /**
   * Get objowner
   * @return objowner
   */
  
  @Schema(name = "objowner", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objowner")
  public Optional<String> getObjowner() {
    return objowner;
  }

  @JsonProperty("objowner")
  public void setObjowner(Optional<String> objowner) {
    this.objowner = objowner;
  }

  public BusinessObjectReference objou(String objou) {
    this.objou = Optional.ofNullable(objou);
    return this;
  }

  /**
   * Get objou
   * @return objou
   */
  
  @Schema(name = "objou", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objou")
  public Optional<String> getObjou() {
    return objou;
  }

  @JsonProperty("objou")
  public void setObjou(Optional<String> objou) {
    this.objou = objou;
  }

  public BusinessObjectReference fileextension(String fileextension) {
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

  public BusinessObjectReference contsize(String contsize) {
    this.contsize = Optional.ofNullable(contsize);
    return this;
  }

  /**
   * Get contsize
   * @return contsize
   */
  
  @Schema(name = "contsize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contsize")
  public Optional<String> getContsize() {
    return contsize;
  }

  @JsonProperty("contsize")
  public void setContsize(Optional<String> contsize) {
    this.contsize = contsize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessObjectReference businessObjectReference = (BusinessObjectReference) o;
    return Objects.equals(this.objname, businessObjectReference.objname) &&
        Objects.equals(this.objaddress, businessObjectReference.objaddress) &&
        Objects.equals(this.objclass, businessObjectReference.objclass) &&
        Objects.equals(this.objcreatedat, businessObjectReference.objcreatedat) &&
        Objects.equals(this.objcreatedby, businessObjectReference.objcreatedby) &&
        Objects.equals(this.objmodifiedat, businessObjectReference.objmodifiedat) &&
        Objects.equals(this.objchangedby, businessObjectReference.objchangedby) &&
        Objects.equals(this.objowner, businessObjectReference.objowner) &&
        Objects.equals(this.objou, businessObjectReference.objou) &&
        Objects.equals(this.fileextension, businessObjectReference.fileextension) &&
        Objects.equals(this.contsize, businessObjectReference.contsize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objname, objaddress, objclass, objcreatedat, objcreatedby, objmodifiedat, objchangedby, objowner, objou, fileextension, contsize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessObjectReference {\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    objaddress: ").append(toIndentedString(objaddress)).append("\n");
    sb.append("    objclass: ").append(toIndentedString(objclass)).append("\n");
    sb.append("    objcreatedat: ").append(toIndentedString(objcreatedat)).append("\n");
    sb.append("    objcreatedby: ").append(toIndentedString(objcreatedby)).append("\n");
    sb.append("    objmodifiedat: ").append(toIndentedString(objmodifiedat)).append("\n");
    sb.append("    objchangedby: ").append(toIndentedString(objchangedby)).append("\n");
    sb.append("    objowner: ").append(toIndentedString(objowner)).append("\n");
    sb.append("    objou: ").append(toIndentedString(objou)).append("\n");
    sb.append("    fileextension: ").append(toIndentedString(fileextension)).append("\n");
    sb.append("    contsize: ").append(toIndentedString(contsize)).append("\n");
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

    private BusinessObjectReference instance;

    public Builder() {
      this(new BusinessObjectReference());
    }

    protected Builder(BusinessObjectReference instance) {
      this.instance = instance;
    }

    protected Builder copyOf(BusinessObjectReference value) { 
      this.instance.setObjname(value.objname);
      this.instance.setObjaddress(value.objaddress);
      this.instance.setObjclass(value.objclass);
      this.instance.setObjcreatedat(value.objcreatedat);
      this.instance.setObjcreatedby(value.objcreatedby);
      this.instance.setObjmodifiedat(value.objmodifiedat);
      this.instance.setObjchangedby(value.objchangedby);
      this.instance.setObjowner(value.objowner);
      this.instance.setObjou(value.objou);
      this.instance.setFileextension(value.fileextension);
      this.instance.setContsize(value.contsize);
      return this;
    }

    public BusinessObjectReference.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public BusinessObjectReference.Builder objaddress(String objaddress) {
      this.instance.objaddress(objaddress);
      return this;
    }
    
    public BusinessObjectReference.Builder objclass(String objclass) {
      this.instance.objclass(objclass);
      return this;
    }
    
    public BusinessObjectReference.Builder objcreatedat(OffsetDateTime objcreatedat) {
      this.instance.objcreatedat(objcreatedat);
      return this;
    }
    
    public BusinessObjectReference.Builder objcreatedby(ArrayOfstring objcreatedby) {
      this.instance.objcreatedby(objcreatedby);
      return this;
    }
    
    public BusinessObjectReference.Builder objmodifiedat(OffsetDateTime objmodifiedat) {
      this.instance.objmodifiedat(objmodifiedat);
      return this;
    }
    
    public BusinessObjectReference.Builder objchangedby(ObjChangedBy objchangedby) {
      this.instance.objchangedby(objchangedby);
      return this;
    }
    
    public BusinessObjectReference.Builder objowner(String objowner) {
      this.instance.objowner(objowner);
      return this;
    }
    
    public BusinessObjectReference.Builder objou(String objou) {
      this.instance.objou(objou);
      return this;
    }
    
    public BusinessObjectReference.Builder fileextension(String fileextension) {
      this.instance.fileextension(fileextension);
      return this;
    }
    
    public BusinessObjectReference.Builder contsize(String contsize) {
      this.instance.contsize(contsize);
      return this;
    }
    
    /**
    * returns a built BusinessObjectReference instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public BusinessObjectReference build() {
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
  public static BusinessObjectReference.Builder builder() {
    return new BusinessObjectReference.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public BusinessObjectReference.Builder toBuilder() {
    BusinessObjectReference.Builder builder = new BusinessObjectReference.Builder();
    return builder.copyOf(this);
  }

}


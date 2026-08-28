package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SearchObjNameAnfrageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SearchObjNameAnfrageDTO {

  private String searchstring;

  private String objclass;

  private Optional<String> reference = Optional.empty();

  private Optional<String> value = Optional.empty();

  public SearchObjNameAnfrageDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SearchObjNameAnfrageDTO(String searchstring, String objclass) {
    this.searchstring = searchstring;
    this.objclass = objclass;
  }

  public SearchObjNameAnfrageDTO searchstring(String searchstring) {
    this.searchstring = searchstring;
    return this;
  }

  /**
   * Suchstring für Objektname  Hinweise zum Suchstring:  Der Suchstring kann folgenden Operatoren verwendet werden: * „*“ oder „%“ Der Stern „*“ steht für eine beliebige Zeichenfolge.\\ Optional zum Zeichen „*“ kann auch das Prozentzeichen „%“ verwendet werden.\\ Beispiel: \\ Eine Suche nach „*berg“ liefert Ergebnisse, die eine beliebige  Zeichenfolge gefolgt von der Zeichenfolge „berg“ enthalten – „Eisberg“, „Zauberberg“, „Erzberg“.\\ Eine Suche nach „Berg*“ liefert Ergebnisse, die „Berg“ gefolgt von einer beliebigen Zeichenfolge enthalten – „Berger“,  „Bergsteiger“, „Berghotel“.\\ Eine Suche nach „Ber*er“ liefert Ergebnisse, die „Ber“ gefolgt von einer  beliebigen Zeichenfolge sowie gefolgt von „er“ enthalten – „Berger“, „Bergsteiger“, „Berliner“. * „?“ oder „_“\\ Das Fragezeichen „?“ steht für exakt ein Zeichen.\\ Optional zum Zeichen „?“ kann auch das Zeichen Unterstrich „_“ verwendet werden.\\ Beispiel: Eine Suche nach „_atterbauer“ liefert Ergebnisse, die  exakt ein (beliebiges) Zeichen gefolgt von der Zeichenkette „atterbauer“ enthalten – „Katterbauer“, „Patterbauer“, „Natterbauer“. * „~“ Die Tilde „~“ (erreichbar über die Tastenkombination AltGr +)\\ steht für eine phonetische Suche.\\  Es werden alle Objekte gefunden, bei denen die Aussprache der im Suchkriterium angegebenen Zeichenkette  ähnlich ist. Eine Tilde muss genau am Beginn des Suchkriteriums eingegeben werden.\\ Beispiel: Eine Suche nach „~Maier“ liefert ähnlich klingende Ergebnisse wie „Maier“ und „Meier“. * „[ ] „ Für mehrere Zeichen, von denen genau eines vorhanden sein muss, können eckige Klammern „[ ]“  verwendet werden.\\ Die in Frage kommenden Zeichen werden ohne Leerzeichen und ohne Komma eingegeben\\ Hinweis: Die genaue Funktionalität hängt von der verwendeten Datenbank ab.\\ Wenn ein Leerzeichen zwischen Zeichen eingegeben wird,  so wird auch das Leerzeichen als mögliches Zeichen gewertet.\\ Beispiel: Es werden Word-Objekte gesucht, deren Name entweder „Test-Eingangsstück“, „Tast-Eingangsstück“ oder  „T st-Eingangsstück“ ist. Dazu wird als Suchstring eingegeben: „T[e a]st-Eingangsstück“. 
   * @return searchstring
   */
  @NotNull 
  @Schema(name = "searchstring", example = "Test*", description = "Suchstring für Objektname  Hinweise zum Suchstring:  Der Suchstring kann folgenden Operatoren verwendet werden: * „*“ oder „%“ Der Stern „*“ steht für eine beliebige Zeichenfolge.\\ Optional zum Zeichen „*“ kann auch das Prozentzeichen „%“ verwendet werden.\\ Beispiel: \\ Eine Suche nach „*berg“ liefert Ergebnisse, die eine beliebige  Zeichenfolge gefolgt von der Zeichenfolge „berg“ enthalten – „Eisberg“, „Zauberberg“, „Erzberg“.\\ Eine Suche nach „Berg*“ liefert Ergebnisse, die „Berg“ gefolgt von einer beliebigen Zeichenfolge enthalten – „Berger“,  „Bergsteiger“, „Berghotel“.\\ Eine Suche nach „Ber*er“ liefert Ergebnisse, die „Ber“ gefolgt von einer  beliebigen Zeichenfolge sowie gefolgt von „er“ enthalten – „Berger“, „Bergsteiger“, „Berliner“. * „?“ oder „_“\\ Das Fragezeichen „?“ steht für exakt ein Zeichen.\\ Optional zum Zeichen „?“ kann auch das Zeichen Unterstrich „_“ verwendet werden.\\ Beispiel: Eine Suche nach „_atterbauer“ liefert Ergebnisse, die  exakt ein (beliebiges) Zeichen gefolgt von der Zeichenkette „atterbauer“ enthalten – „Katterbauer“, „Patterbauer“, „Natterbauer“. * „~“ Die Tilde „~“ (erreichbar über die Tastenkombination AltGr +)\\ steht für eine phonetische Suche.\\  Es werden alle Objekte gefunden, bei denen die Aussprache der im Suchkriterium angegebenen Zeichenkette  ähnlich ist. Eine Tilde muss genau am Beginn des Suchkriteriums eingegeben werden.\\ Beispiel: Eine Suche nach „~Maier“ liefert ähnlich klingende Ergebnisse wie „Maier“ und „Meier“. * „[ ] „ Für mehrere Zeichen, von denen genau eines vorhanden sein muss, können eckige Klammern „[ ]“  verwendet werden.\\ Die in Frage kommenden Zeichen werden ohne Leerzeichen und ohne Komma eingegeben\\ Hinweis: Die genaue Funktionalität hängt von der verwendeten Datenbank ab.\\ Wenn ein Leerzeichen zwischen Zeichen eingegeben wird,  so wird auch das Leerzeichen als mögliches Zeichen gewertet.\\ Beispiel: Es werden Word-Objekte gesucht, deren Name entweder „Test-Eingangsstück“, „Tast-Eingangsstück“ oder  „T st-Eingangsstück“ ist. Dazu wird als Suchstring eingegeben: „T[e a]st-Eingangsstück“. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("searchstring")
  public String getSearchstring() {
    return searchstring;
  }

  @JsonProperty("searchstring")
  public void setSearchstring(String searchstring) {
    this.searchstring = searchstring;
  }

  public SearchObjNameAnfrageDTO objclass(String objclass) {
    this.objclass = objclass;
    return this;
  }

  /**
   * Referenz der Objektklasse * Aktenplan COOELAK@1.1001:Fileplan * Aktenplaneintrag COOELAK@1.1001:SubjectArea * Erledigung COOELAK@1.1001:Outgoing * AutoCAD Zeichnung FSCAUTOCAD@1.1001:Drawing * Benutzer COOSYSTEM@1.1:User * Bericht FSCAREXT@1.1001:Report * Bild FSCWEBCONT@1.1001:ImageObject * Dokumentkategorie FSCFOLIO@1.1001:DocumentCategory * Dokumenttyp COOELAK@1.1001:Subject * Dokument  COOELAK@1.1001:SubFileDocument (bei Angabe dieser Objektklasse, sollten Eingangs-, und Erledigungsdokumente angezeigt werden) * E-Mail (Microsoft Office Outlook) COOMAPI@1.1:MailObject * E-Mail (MIME) FSCMIME@1.1001:MIMEObject * Eingang COOELAK@1.1001:Incoming * Freemind Mindmap CFGMUENCHEN@15.1700:FreemindMindmap * Frist ELAKGOV@1.1001:Deadline * GIF-Objekt FSCWEBCONT@1.1001:GIFObject * Hewlett Packard Graphic Language  CFGMUENCHEN@15.1700:HPGraphicLanguage * Inhalt (erweitert) CFGMUENCHEN@15.1700:GenericContent * Inhalt (unbekannter Typ) GENCONT@1.1:ContentObject * JPEG-Objekt FSCWEBCONT@1.1001:JPEGObject * Kostenstelle CFGMUENCHEN@15.1700:CostCenter * Medieninhalt FSCDIGITALASSET@1.1001:DigitalAsset * Microsoft Excel-Arbeitsblatt COOMSOFFICE@1.1:ExcelObject * Microsoft PowerPoint-Präsentation COOMSOFFICE@1.1:PowerPointObject * Microsoft Project-Objekt COOMSPROJECT@1.1001:MSProject * Microsoft Visio-Zeichnung VISIO@1.1:VisioObject * Microsoft Word-Objekt COOMSOFFICE@1.1:WinWordObject * OpenDocument Formel FSCOOFFICE@1.1001:OOorgMathObject * OpenOffice.org Vorlage CFGMUENCHEN@15.1700:OOorgTemplateObject * Ordner COODESK@1.1:Folder * Organisation FSCFOLIO@1.1001:Organisation * Organisationseinheit COOSYSTEM@1.1:Group * PDF-Dokument FSCACROBAT@1.1:PDFObject * Person FSCFOLIO@1.1001:Person * Personenakte CFGMUENCHEN@15.1700:PersonalSubjectAreaFile * PNG-Objekt FSCWEBCONT@1.1001:PNGObject * Postkorb FSCVGOV@1.1001:Inbox * Präsentation FSCOOFFICE@1.1001:OOorgPresObject * Projektordner COOELAK@1.1001:ProjectFolder * Rechnungsposition CFGMUENCHEN@15.1700:InvoiceItem * Rich Text Format CFGMUENCHEN@15.1700:RichTextFormat * Sachakte DEPRECONFIG@15.1001:SubjectAreaFile * Schlagwort FSCTERM@1.1001:Term * Schmierzettel ELAKGOV@1.1001:FileMemo * Schriftstück COOSYSTEM@1.1:ContentObject * Serena OpenProj Projekt CFGMUENCHEN@15.1700:SerenaOpenProj * Suchordner COOQBOL@1.1:GenericStoredQBOL * Tabelle FSCOOFFICE@1.1001:OOorgCalcObject * Teamroom FSCTEAMROOM@1.1001:TeamRoom * Text-Dokument NOTE@1.1:NoteObject * Textbaustein COOAR@1.1:BasicTextModuleEx_Web * Textdokument FSCOOFFICE@1.1001:OOorgTextObject * TIFF-Objekt FSCWEBCONT@1.1001:TIFFObject * Verteiler COOELAK@1.1001:DistributionList * Verteilerliste COOWF@1.1:ParticipantInstance * Vorgang DEPRECONFIG@15.1001:Procedure * Vorlagenkategorie COOTC@1.1001:TemplateCategory * XDOMEA Paket FSCGOVXMLDE@1.1001:XDOMEAPackage * Zeichnung FSCOOFFICE@1.1001:OOorgDrawObject * Zip-Archiv WINZIP@1.1001:WinZipObject (Alle Objekte von Objektklassen, nach denen ein Sachbearbeiter suchen kann.) 
   * @return objclass
   */
  @NotNull 
  @Schema(name = "objclass", example = "FSCACROBAT@1.1:PDF Object", description = "Referenz der Objektklasse * Aktenplan COOELAK@1.1001:Fileplan * Aktenplaneintrag COOELAK@1.1001:SubjectArea * Erledigung COOELAK@1.1001:Outgoing * AutoCAD Zeichnung FSCAUTOCAD@1.1001:Drawing * Benutzer COOSYSTEM@1.1:User * Bericht FSCAREXT@1.1001:Report * Bild FSCWEBCONT@1.1001:ImageObject * Dokumentkategorie FSCFOLIO@1.1001:DocumentCategory * Dokumenttyp COOELAK@1.1001:Subject * Dokument  COOELAK@1.1001:SubFileDocument (bei Angabe dieser Objektklasse, sollten Eingangs-, und Erledigungsdokumente angezeigt werden) * E-Mail (Microsoft Office Outlook) COOMAPI@1.1:MailObject * E-Mail (MIME) FSCMIME@1.1001:MIMEObject * Eingang COOELAK@1.1001:Incoming * Freemind Mindmap CFGMUENCHEN@15.1700:FreemindMindmap * Frist ELAKGOV@1.1001:Deadline * GIF-Objekt FSCWEBCONT@1.1001:GIFObject * Hewlett Packard Graphic Language  CFGMUENCHEN@15.1700:HPGraphicLanguage * Inhalt (erweitert) CFGMUENCHEN@15.1700:GenericContent * Inhalt (unbekannter Typ) GENCONT@1.1:ContentObject * JPEG-Objekt FSCWEBCONT@1.1001:JPEGObject * Kostenstelle CFGMUENCHEN@15.1700:CostCenter * Medieninhalt FSCDIGITALASSET@1.1001:DigitalAsset * Microsoft Excel-Arbeitsblatt COOMSOFFICE@1.1:ExcelObject * Microsoft PowerPoint-Präsentation COOMSOFFICE@1.1:PowerPointObject * Microsoft Project-Objekt COOMSPROJECT@1.1001:MSProject * Microsoft Visio-Zeichnung VISIO@1.1:VisioObject * Microsoft Word-Objekt COOMSOFFICE@1.1:WinWordObject * OpenDocument Formel FSCOOFFICE@1.1001:OOorgMathObject * OpenOffice.org Vorlage CFGMUENCHEN@15.1700:OOorgTemplateObject * Ordner COODESK@1.1:Folder * Organisation FSCFOLIO@1.1001:Organisation * Organisationseinheit COOSYSTEM@1.1:Group * PDF-Dokument FSCACROBAT@1.1:PDFObject * Person FSCFOLIO@1.1001:Person * Personenakte CFGMUENCHEN@15.1700:PersonalSubjectAreaFile * PNG-Objekt FSCWEBCONT@1.1001:PNGObject * Postkorb FSCVGOV@1.1001:Inbox * Präsentation FSCOOFFICE@1.1001:OOorgPresObject * Projektordner COOELAK@1.1001:ProjectFolder * Rechnungsposition CFGMUENCHEN@15.1700:InvoiceItem * Rich Text Format CFGMUENCHEN@15.1700:RichTextFormat * Sachakte DEPRECONFIG@15.1001:SubjectAreaFile * Schlagwort FSCTERM@1.1001:Term * Schmierzettel ELAKGOV@1.1001:FileMemo * Schriftstück COOSYSTEM@1.1:ContentObject * Serena OpenProj Projekt CFGMUENCHEN@15.1700:SerenaOpenProj * Suchordner COOQBOL@1.1:GenericStoredQBOL * Tabelle FSCOOFFICE@1.1001:OOorgCalcObject * Teamroom FSCTEAMROOM@1.1001:TeamRoom * Text-Dokument NOTE@1.1:NoteObject * Textbaustein COOAR@1.1:BasicTextModuleEx_Web * Textdokument FSCOOFFICE@1.1001:OOorgTextObject * TIFF-Objekt FSCWEBCONT@1.1001:TIFFObject * Verteiler COOELAK@1.1001:DistributionList * Verteilerliste COOWF@1.1:ParticipantInstance * Vorgang DEPRECONFIG@15.1001:Procedure * Vorlagenkategorie COOTC@1.1001:TemplateCategory * XDOMEA Paket FSCGOVXMLDE@1.1001:XDOMEAPackage * Zeichnung FSCOOFFICE@1.1001:OOorgDrawObject * Zip-Archiv WINZIP@1.1001:WinZipObject (Alle Objekte von Objektklassen, nach denen ein Sachbearbeiter suchen kann.) ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("objclass")
  public String getObjclass() {
    return objclass;
  }

  @JsonProperty("objclass")
  public void setObjclass(String objclass) {
    this.objclass = objclass;
  }

  public SearchObjNameAnfrageDTO reference(String reference) {
    this.reference = Optional.ofNullable(reference);
    return this;
  }

  /**
   * Referenz des Fachdatum
   * @return reference
   */
  
  @Schema(name = "reference", example = "data_dognumber", description = "Referenz des Fachdatum", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reference")
  public Optional<String> getReference() {
    return reference;
  }

  @JsonProperty("reference")
  public void setReference(Optional<String> reference) {
    this.reference = reference;
  }

  public SearchObjNameAnfrageDTO value(String value) {
    this.value = Optional.ofNullable(value);
    return this;
  }

  /**
   * Wert des Fachdatum
   * @return value
   */
  
  @Schema(name = "value", example = "458965", description = "Wert des Fachdatum", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Optional<String> value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchObjNameAnfrageDTO searchObjNameAnfrageDTO = (SearchObjNameAnfrageDTO) o;
    return Objects.equals(this.searchstring, searchObjNameAnfrageDTO.searchstring) &&
        Objects.equals(this.objclass, searchObjNameAnfrageDTO.objclass) &&
        Objects.equals(this.reference, searchObjNameAnfrageDTO.reference) &&
        Objects.equals(this.value, searchObjNameAnfrageDTO.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchstring, objclass, reference, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchObjNameAnfrageDTO {\n");
    sb.append("    searchstring: ").append(toIndentedString(searchstring)).append("\n");
    sb.append("    objclass: ").append(toIndentedString(objclass)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

    private SearchObjNameAnfrageDTO instance;

    public Builder() {
      this(new SearchObjNameAnfrageDTO());
    }

    protected Builder(SearchObjNameAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SearchObjNameAnfrageDTO value) { 
      this.instance.setSearchstring(value.searchstring);
      this.instance.setObjclass(value.objclass);
      this.instance.setReference(value.reference);
      this.instance.setValue(value.value);
      return this;
    }

    public SearchObjNameAnfrageDTO.Builder searchstring(String searchstring) {
      this.instance.searchstring(searchstring);
      return this;
    }
    
    public SearchObjNameAnfrageDTO.Builder objclass(String objclass) {
      this.instance.objclass(objclass);
      return this;
    }
    
    public SearchObjNameAnfrageDTO.Builder reference(String reference) {
      this.instance.reference(reference);
      return this;
    }
    
    public SearchObjNameAnfrageDTO.Builder value(String value) {
      this.instance.value(value);
      return this;
    }
    
    /**
    * returns a built SearchObjNameAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SearchObjNameAnfrageDTO build() {
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
  public static SearchObjNameAnfrageDTO.Builder builder() {
    return new SearchObjNameAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SearchObjNameAnfrageDTO.Builder toBuilder() {
    SearchObjNameAnfrageDTO.Builder builder = new SearchObjNameAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


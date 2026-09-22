package de.muenchen.itm.eakte.schnittstelle.rest_v1.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v1.server_stubs.model.MetadataReferenz;
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
 * ReadIncomingAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadIncomingAntwortDTO {

  private Optional<String> shortname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  private Optional<String> accdef = Optional.empty();

  private Optional<String> objname = Optional.empty();

  private Optional<String> referrednumber = Optional.empty();

  private Optional<String> foreignnr = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> delivery = Optional.empty();

  private Optional<String> documentremarks = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  @Valid
  private List<@Valid MetadataReferenz> gimetadatatype = new ArrayList<>();

  public ReadIncomingAntwortDTO shortname(String shortname) {
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

  public ReadIncomingAntwortDTO filesubj(String filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Betreff (mehrzeilig) Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &amp;#10; in Abfragen unterstützt. 
   * @return filesubj
   */
  
  @Schema(name = "filesubj", example = "Alle Anträge der Firma XY aus dem Jahr 2016", description = "Betreff (mehrzeilig) Mehrzeilige Felder werden mit Zeilenumbrüchen oder HTML Kodierung &amp;#10; in Abfragen unterstützt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public Optional<String> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(Optional<String> filesubj) {
    this.filesubj = filesubj;
  }

  public ReadIncomingAntwortDTO objterms(String objterms) {
    this.objterms = Optional.ofNullable(objterms);
    return this;
  }

  /**
   * Schlagworte, Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben. 
   * @return objterms
   */
  
  @Schema(name = "objterms", example = "Firma XY; Anträge; Anträge 2016", description = "Schlagworte, Angabe der Schlagworte getrennt mit „;“. Kein Semikola am Ende angeben. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objterms")
  public Optional<String> getObjterms() {
    return objterms;
  }

  @JsonProperty("objterms")
  public void setObjterms(Optional<String> objterms) {
    this.objterms = objterms;
  }

  public ReadIncomingAntwortDTO accdef(String accdef) {
    this.accdef = Optional.ofNullable(accdef);
    return this;
  }

  /**
   * Zugriffsdefinition Eindeutiger Name der Zugriffsdefinition. z.B.: • Zugriffsdefinition für Schriftgutobjekte (allgemein lesbar) • Zugriffsdefinition für Schriftgutobjekte der Organisationseinheit • Zugriffsdefinition für Schriftgutobjekte der Organisationseinheit und Zentralregistratur • Zugriffsdefinition für Schriftgutobjekte des Eigentümers Hinweis: Hierbei kann die gewünschte Zugriffsdefinition der Akte gesetzt werden. Wenn kein Wert übergeben wird, wird die auf dem Aktenplaneintrag hinterlegte Zugriffsdefinition initialisiert.
   * @return accdef
   */
  
  @Schema(name = "accdef", example = "Zugriffsdefinition für Schriftgutobjekte (allgemein lesbar)", description = "Zugriffsdefinition Eindeutiger Name der Zugriffsdefinition. z.B.: • Zugriffsdefinition für Schriftgutobjekte (allgemein lesbar) • Zugriffsdefinition für Schriftgutobjekte der Organisationseinheit • Zugriffsdefinition für Schriftgutobjekte der Organisationseinheit und Zentralregistratur • Zugriffsdefinition für Schriftgutobjekte des Eigentümers Hinweis: Hierbei kann die gewünschte Zugriffsdefinition der Akte gesetzt werden. Wenn kein Wert übergeben wird, wird die auf dem Aktenplaneintrag hinterlegte Zugriffsdefinition initialisiert.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accdef")
  public Optional<String> getAccdef() {
    return accdef;
  }

  @JsonProperty("accdef")
  public void setAccdef(Optional<String> accdef) {
    this.accdef = accdef;
  }

  public ReadIncomingAntwortDTO objname(String objname) {
    this.objname = Optional.ofNullable(objname);
    return this;
  }

  /**
   * Eingangskennzeichen
   * @return objname
   */
  
  @Schema(name = "objname", example = "Eingangspost vom 21.10.2016 (0010 A20 011-4-0006-0001)", description = "Eingangskennzeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objname")
  public Optional<String> getObjname() {
    return objname;
  }

  @JsonProperty("objname")
  public void setObjname(Optional<String> objname) {
    this.objname = objname;
  }

  public ReadIncomingAntwortDTO referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) der zugehörigen Vorgangs
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042432", description = "Objekt-ID (COO-Adresse) der zugehörigen Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public ReadIncomingAntwortDTO foreignnr(String foreignnr) {
    this.foreignnr = Optional.ofNullable(foreignnr);
    return this;
  }

  /**
   * Fremdes Geschäftszeichen
   * @return foreignnr
   */
  
  @Schema(name = "foreignnr", example = "A2016-10-2016-Landeshauptstadt-München", description = "Fremdes Geschäftszeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("foreignnr")
  public Optional<String> getForeignnr() {
    return foreignnr;
  }

  @JsonProperty("foreignnr")
  public void setForeignnr(Optional<String> foreignnr) {
    this.foreignnr = foreignnr;
  }

  public ReadIncomingAntwortDTO delivery(OffsetDateTime delivery) {
    this.delivery = Optional.ofNullable(delivery);
    return this;
  }

  /**
   * Termin (Datum/Uhrzeit)
   * @return delivery
   */
  @Valid 
  @Schema(name = "delivery", example = "2016-10-26T18:16:29+01:00", description = "Termin (Datum/Uhrzeit)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("delivery")
  public Optional<OffsetDateTime> getDelivery() {
    return delivery;
  }

  @JsonProperty("delivery")
  public void setDelivery(Optional<OffsetDateTime> delivery) {
    this.delivery = delivery;
  }

  public ReadIncomingAntwortDTO documentremarks(String documentremarks) {
    this.documentremarks = Optional.ofNullable(documentremarks);
    return this;
  }

  /**
   * Dokumentbezogene Hinweise
   * @return documentremarks
   */
  
  @Schema(name = "documentremarks", example = "Antrag auf Baugenehmigung", description = "Dokumentbezogene Hinweise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentremarks")
  public Optional<String> getDocumentremarks() {
    return documentremarks;
  }

  @JsonProperty("documentremarks")
  public void setDocumentremarks(Optional<String> documentremarks) {
    this.documentremarks = documentremarks;
  }

  public ReadIncomingAntwortDTO incattachments(String incattachments) {
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

  public ReadIncomingAntwortDTO gimetadatatype(List<@Valid MetadataReferenz> gimetadatatype) {
    this.gimetadatatype = gimetadatatype;
    return this;
  }

  public ReadIncomingAntwortDTO addGimetadatatypeItem(MetadataReferenz gimetadatatypeItem) {
    if (this.gimetadatatype == null) {
      this.gimetadatatype = new ArrayList<>();
    }
    this.gimetadatatype.add(gimetadatatypeItem);
    return this;
  }

  /**
   * Schriftstücke
   * @return gimetadatatype
   */
  @Valid 
  @Schema(name = "gimetadatatype", example = "{\"objaddress\":\"COO.1.2301.1.1041875\",\"filename\":\"Antrag auf Baugenehmigung\",\"fileextension\":\"pdf\",\"objclass\":\"PDF-Dokument\",\"contsize\":\"243\",\"objcreatedby\":{\"string\":[\"musterfraum\"]},\"objcreatedat\":\"2018-07-23T08:59:52+01:00\",\"objchangedby\":{\"string\":[\"mustermannm\"]},\"objmodifiedat\":\"2018-07-23T09:23:52+01:00\"}", description = "Schriftstücke", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gimetadatatype")
  public List<@Valid MetadataReferenz> getGimetadatatype() {
    return gimetadatatype;
  }

  @JsonProperty("gimetadatatype")
  public void setGimetadatatype(List<@Valid MetadataReferenz> gimetadatatype) {
    this.gimetadatatype = gimetadatatype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadIncomingAntwortDTO readIncomingAntwortDTO = (ReadIncomingAntwortDTO) o;
    return Objects.equals(this.shortname, readIncomingAntwortDTO.shortname) &&
        Objects.equals(this.filesubj, readIncomingAntwortDTO.filesubj) &&
        Objects.equals(this.objterms, readIncomingAntwortDTO.objterms) &&
        Objects.equals(this.accdef, readIncomingAntwortDTO.accdef) &&
        Objects.equals(this.objname, readIncomingAntwortDTO.objname) &&
        Objects.equals(this.referrednumber, readIncomingAntwortDTO.referrednumber) &&
        Objects.equals(this.foreignnr, readIncomingAntwortDTO.foreignnr) &&
        Objects.equals(this.delivery, readIncomingAntwortDTO.delivery) &&
        Objects.equals(this.documentremarks, readIncomingAntwortDTO.documentremarks) &&
        Objects.equals(this.incattachments, readIncomingAntwortDTO.incattachments) &&
        Objects.equals(this.gimetadatatype, readIncomingAntwortDTO.gimetadatatype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortname, filesubj, objterms, accdef, objname, referrednumber, foreignnr, delivery, documentremarks, incattachments, gimetadatatype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadIncomingAntwortDTO {\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
    sb.append("    accdef: ").append(toIndentedString(accdef)).append("\n");
    sb.append("    objname: ").append(toIndentedString(objname)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    foreignnr: ").append(toIndentedString(foreignnr)).append("\n");
    sb.append("    delivery: ").append(toIndentedString(delivery)).append("\n");
    sb.append("    documentremarks: ").append(toIndentedString(documentremarks)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
    sb.append("    gimetadatatype: ").append(toIndentedString(gimetadatatype)).append("\n");
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

    private ReadIncomingAntwortDTO instance;

    public Builder() {
      this(new ReadIncomingAntwortDTO());
    }

    protected Builder(ReadIncomingAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadIncomingAntwortDTO value) { 
      this.instance.setShortname(value.shortname);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setObjterms(value.objterms);
      this.instance.setAccdef(value.accdef);
      this.instance.setObjname(value.objname);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setForeignnr(value.foreignnr);
      this.instance.setDelivery(value.delivery);
      this.instance.setDocumentremarks(value.documentremarks);
      this.instance.setIncattachments(value.incattachments);
      this.instance.setGimetadatatype(value.gimetadatatype);
      return this;
    }

    public ReadIncomingAntwortDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder accdef(String accdef) {
      this.instance.accdef(accdef);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder objname(String objname) {
      this.instance.objname(objname);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder foreignnr(String foreignnr) {
      this.instance.foreignnr(foreignnr);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder delivery(OffsetDateTime delivery) {
      this.instance.delivery(delivery);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder documentremarks(String documentremarks) {
      this.instance.documentremarks(documentremarks);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    public ReadIncomingAntwortDTO.Builder gimetadatatype(List<MetadataReferenz> gimetadatatype) {
      this.instance.gimetadatatype(gimetadatatype);
      return this;
    }
    
    /**
    * returns a built ReadIncomingAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadIncomingAntwortDTO build() {
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
  public static ReadIncomingAntwortDTO.Builder builder() {
    return new ReadIncomingAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadIncomingAntwortDTO.Builder toBuilder() {
    ReadIncomingAntwortDTO.Builder builder = new ReadIncomingAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


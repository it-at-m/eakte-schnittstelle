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
 * CreateIncomingFromInboxRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateIncomingFromInboxRequestDTO {

  private String inboxid;

  private Optional<String> referrednumber = Optional.empty();

  private String contentid;

  private Optional<String> shortname = Optional.empty();

  private Optional<String> foreignnr = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  private Optional<String> documentremarks = Optional.empty();

  private Optional<String> incattachments = Optional.empty();

  private Optional<String> objterms = Optional.empty();

  public CreateIncomingFromInboxRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateIncomingFromInboxRequestDTO(String inboxid, String contentid) {
    this.inboxid = inboxid;
    this.contentid = contentid;
  }

  public CreateIncomingFromInboxRequestDTO inboxid(String inboxid) {
    this.inboxid = inboxid;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Postkorbs
   * @return inboxid
   */
  @NotNull 
  @Schema(name = "inboxid", example = "COO.1.2301.4.191", description = "Objekt-ID (COO-Adresse) des Postkorbs", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("inboxid")
  public String getInboxid() {
    return inboxid;
  }

  @JsonProperty("inboxid")
  public void setInboxid(String inboxid) {
    this.inboxid = inboxid;
  }

  public CreateIncomingFromInboxRequestDTO referrednumber(String referrednumber) {
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

  public CreateIncomingFromInboxRequestDTO contentid(String contentid) {
    this.contentid = contentid;
    return this;
  }

  /**
   * COO-Adressse eines Schriftstücks aus dem Postkorb
   * @return contentid
   */
  @NotNull 
  @Schema(name = "contentid", example = "COO.1.2301.1.1042446", description = "COO-Adressse eines Schriftstücks aus dem Postkorb", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contentid")
  public String getContentid() {
    return contentid;
  }

  @JsonProperty("contentid")
  public void setContentid(String contentid) {
    this.contentid = contentid;
  }

  public CreateIncomingFromInboxRequestDTO shortname(String shortname) {
    this.shortname = Optional.ofNullable(shortname);
    return this;
  }

  /**
   * Titel
   * @return shortname
   */
  
  @Schema(name = "shortname", example = "Eingangspost vom 21.10.2016", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortname")
  public Optional<String> getShortname() {
    return shortname;
  }

  @JsonProperty("shortname")
  public void setShortname(Optional<String> shortname) {
    this.shortname = shortname;
  }

  public CreateIncomingFromInboxRequestDTO foreignnr(String foreignnr) {
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

  public CreateIncomingFromInboxRequestDTO filesubj(String filesubj) {
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

  public CreateIncomingFromInboxRequestDTO documentremarks(String documentremarks) {
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

  public CreateIncomingFromInboxRequestDTO incattachments(String incattachments) {
    this.incattachments = Optional.ofNullable(incattachments);
    return this;
  }

  /**
   * Sonstige Anlagen
   * @return incattachments
   */
  
  @Schema(name = "incattachments", example = "Bebauungsplan", description = "Sonstige Anlagen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("incattachments")
  public Optional<String> getIncattachments() {
    return incattachments;
  }

  @JsonProperty("incattachments")
  public void setIncattachments(Optional<String> incattachments) {
    this.incattachments = incattachments;
  }

  public CreateIncomingFromInboxRequestDTO objterms(String objterms) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateIncomingFromInboxRequestDTO createIncomingFromInboxRequestDTO = (CreateIncomingFromInboxRequestDTO) o;
    return Objects.equals(this.inboxid, createIncomingFromInboxRequestDTO.inboxid) &&
        Objects.equals(this.referrednumber, createIncomingFromInboxRequestDTO.referrednumber) &&
        Objects.equals(this.contentid, createIncomingFromInboxRequestDTO.contentid) &&
        Objects.equals(this.shortname, createIncomingFromInboxRequestDTO.shortname) &&
        Objects.equals(this.foreignnr, createIncomingFromInboxRequestDTO.foreignnr) &&
        Objects.equals(this.filesubj, createIncomingFromInboxRequestDTO.filesubj) &&
        Objects.equals(this.documentremarks, createIncomingFromInboxRequestDTO.documentremarks) &&
        Objects.equals(this.incattachments, createIncomingFromInboxRequestDTO.incattachments) &&
        Objects.equals(this.objterms, createIncomingFromInboxRequestDTO.objterms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inboxid, referrednumber, contentid, shortname, foreignnr, filesubj, documentremarks, incattachments, objterms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateIncomingFromInboxRequestDTO {\n");
    sb.append("    inboxid: ").append(toIndentedString(inboxid)).append("\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    contentid: ").append(toIndentedString(contentid)).append("\n");
    sb.append("    shortname: ").append(toIndentedString(shortname)).append("\n");
    sb.append("    foreignnr: ").append(toIndentedString(foreignnr)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
    sb.append("    documentremarks: ").append(toIndentedString(documentremarks)).append("\n");
    sb.append("    incattachments: ").append(toIndentedString(incattachments)).append("\n");
    sb.append("    objterms: ").append(toIndentedString(objterms)).append("\n");
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

    private CreateIncomingFromInboxRequestDTO instance;

    public Builder() {
      this(new CreateIncomingFromInboxRequestDTO());
    }

    protected Builder(CreateIncomingFromInboxRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateIncomingFromInboxRequestDTO value) { 
      this.instance.setInboxid(value.inboxid);
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setContentid(value.contentid);
      this.instance.setShortname(value.shortname);
      this.instance.setForeignnr(value.foreignnr);
      this.instance.setFilesubj(value.filesubj);
      this.instance.setDocumentremarks(value.documentremarks);
      this.instance.setIncattachments(value.incattachments);
      this.instance.setObjterms(value.objterms);
      return this;
    }

    public CreateIncomingFromInboxRequestDTO.Builder inboxid(String inboxid) {
      this.instance.inboxid(inboxid);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder contentid(String contentid) {
      this.instance.contentid(contentid);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder shortname(String shortname) {
      this.instance.shortname(shortname);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder foreignnr(String foreignnr) {
      this.instance.foreignnr(foreignnr);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder documentremarks(String documentremarks) {
      this.instance.documentremarks(documentremarks);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder incattachments(String incattachments) {
      this.instance.incattachments(incattachments);
      return this;
    }
    
    public CreateIncomingFromInboxRequestDTO.Builder objterms(String objterms) {
      this.instance.objterms(objterms);
      return this;
    }
    
    /**
    * returns a built CreateIncomingFromInboxRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateIncomingFromInboxRequestDTO build() {
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
  public static CreateIncomingFromInboxRequestDTO.Builder builder() {
    return new CreateIncomingFromInboxRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateIncomingFromInboxRequestDTO.Builder toBuilder() {
    CreateIncomingFromInboxRequestDTO.Builder builder = new CreateIncomingFromInboxRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


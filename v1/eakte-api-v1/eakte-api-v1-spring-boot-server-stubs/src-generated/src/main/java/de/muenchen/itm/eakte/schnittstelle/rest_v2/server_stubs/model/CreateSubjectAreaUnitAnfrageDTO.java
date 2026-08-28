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
 * CreateSubjectAreaUnitAnfrageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateSubjectAreaUnitAnfrageDTO {

  private String objaddress;

  private String basenr;

  private Optional<String> subjareaspecreference = Optional.empty();

  private Optional<String> shortterm = Optional.empty();

  private Optional<String> subjarchiveschedule = Optional.empty();

  private Optional<String> subjschedule = Optional.empty();

  private Optional<String> subjdispstate = Optional.empty();

  private Optional<String> fileaccessdefinition = Optional.empty();

  public CreateSubjectAreaUnitAnfrageDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSubjectAreaUnitAnfrageDTO(String objaddress, String basenr) {
    this.objaddress = objaddress;
    this.basenr = basenr;
  }

  public CreateSubjectAreaUnitAnfrageDTO objaddress(String objaddress) {
    this.objaddress = objaddress;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des übergeordneten Aktenplaneintrags
   * @return objaddress
   */
  @NotNull 
  @Schema(name = "objaddress", example = "COO.1.2302.1.8", description = "Objekt-ID (COO-Adresse) des übergeordneten Aktenplaneintrags", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("objaddress")
  public String getObjaddress() {
    return objaddress;
  }

  @JsonProperty("objaddress")
  public void setObjaddress(String objaddress) {
    this.objaddress = objaddress;
  }

  public CreateSubjectAreaUnitAnfrageDTO basenr(String basenr) {
    this.basenr = basenr;
    return this;
  }

  /**
   * Aktenplankennzeichen der Betreffseinheit
   * @return basenr
   */
  @NotNull 
  @Schema(name = "basenr", example = "0001 B10 000", description = "Aktenplankennzeichen der Betreffseinheit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("basenr")
  public String getBasenr() {
    return basenr;
  }

  @JsonProperty("basenr")
  public void setBasenr(String basenr) {
    this.basenr = basenr;
  }

  public CreateSubjectAreaUnitAnfrageDTO subjareaspecreference(String subjareaspecreference) {
    this.subjareaspecreference = Optional.ofNullable(subjareaspecreference);
    return this;
  }

  /**
   * Ableitung
   * @return subjareaspecreference
   */
  
  @Schema(name = "subjareaspecreference", example = "1", description = "Ableitung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subjareaspecreference")
  public Optional<String> getSubjareaspecreference() {
    return subjareaspecreference;
  }

  @JsonProperty("subjareaspecreference")
  public void setSubjareaspecreference(Optional<String> subjareaspecreference) {
    this.subjareaspecreference = subjareaspecreference;
  }

  public CreateSubjectAreaUnitAnfrageDTO shortterm(String shortterm) {
    this.shortterm = Optional.ofNullable(shortterm);
    return this;
  }

  /**
   * Kurzbezeichnung
   * @return shortterm
   */
  
  @Schema(name = "shortterm", example = "Betreffseinheit B", description = "Kurzbezeichnung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shortterm")
  public Optional<String> getShortterm() {
    return shortterm;
  }

  @JsonProperty("shortterm")
  public void setShortterm(Optional<String> shortterm) {
    this.shortterm = shortterm;
  }

  public CreateSubjectAreaUnitAnfrageDTO subjarchiveschedule(String subjarchiveschedule) {
    this.subjarchiveschedule = Optional.ofNullable(subjarchiveschedule);
    return this;
  }

  /**
   * Standardmäßige Transferfrist für alle Objekte unterhalb der Betreffseinheit\\ Hinweis zur Transferfrist: siehe bei POST /files (Anlegen von Akten) 
   * @return subjarchiveschedule
   */
  
  @Schema(name = "subjarchiveschedule", example = "10 Jahre", description = "Standardmäßige Transferfrist für alle Objekte unterhalb der Betreffseinheit\\ Hinweis zur Transferfrist: siehe bei POST /files (Anlegen von Akten) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subjarchiveschedule")
  public Optional<String> getSubjarchiveschedule() {
    return subjarchiveschedule;
  }

  @JsonProperty("subjarchiveschedule")
  public void setSubjarchiveschedule(Optional<String> subjarchiveschedule) {
    this.subjarchiveschedule = subjarchiveschedule;
  }

  public CreateSubjectAreaUnitAnfrageDTO subjschedule(String subjschedule) {
    this.subjschedule = Optional.ofNullable(subjschedule);
    return this;
  }

  /**
   * Standardmäßige Aufbewahrungsfrist für alle Objekte unterhalb der Betreffseinheit
   * @return subjschedule
   */
  
  @Schema(name = "subjschedule", example = "10 Jahre", description = "Standardmäßige Aufbewahrungsfrist für alle Objekte unterhalb der Betreffseinheit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subjschedule")
  public Optional<String> getSubjschedule() {
    return subjschedule;
  }

  @JsonProperty("subjschedule")
  public void setSubjschedule(Optional<String> subjschedule) {
    this.subjschedule = subjschedule;
  }

  public CreateSubjectAreaUnitAnfrageDTO subjdispstate(String subjdispstate) {
    this.subjdispstate = Optional.ofNullable(subjdispstate);
    return this;
  }

  /**
   * Gewünschte Aussonderungsart für alle Objete unterhalb der Betreffseinheit * „DISPSTATE_ARCHIVE“ - für „A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „V - Vernichten“ * „DISPSTATE_DM_B“ für „B - Bewerten“  Erläuterungen zu den Aussonderungsarten: * „A - Archivwürdig“ - Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Vorgänge oder Akten werden nach Ablauf der Aufbewahrungsfrist vernichtet. * „B - Bewerten“ - Bewerten von Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Die Aussonderungsart wird üblicherweise über die Aussonderungsart im Aktenplaneintrag gesetzt. 
   * @return subjdispstate
   */
  
  @Schema(name = "subjdispstate", example = "A – Archivwürdig", description = "Gewünschte Aussonderungsart für alle Objete unterhalb der Betreffseinheit * „DISPSTATE_ARCHIVE“ - für „A - Archivwürdig“ * „DISPSTATE_DESTROY“ - für „V - Vernichten“ * „DISPSTATE_DM_B“ für „B - Bewerten“  Erläuterungen zu den Aussonderungsarten: * „A - Archivwürdig“ - Vorgänge oder Akten sind nach Ablauf der Aufbewahrungsfrist dem zuständigen Archiv als archivwürdig zu übermitteln. * „V - Vernichten“ - Vorgänge oder Akten werden nach Ablauf der Aufbewahrungsfrist vernichtet. * „B - Bewerten“ - Bewerten von Vorgängen oder Akten, deren Archivwürdigkeit nicht durch eine Vorentscheidung festgelegt ist.  Die Aussonderungsart wird üblicherweise über die Aussonderungsart im Aktenplaneintrag gesetzt. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subjdispstate")
  public Optional<String> getSubjdispstate() {
    return subjdispstate;
  }

  @JsonProperty("subjdispstate")
  public void setSubjdispstate(Optional<String> subjdispstate) {
    this.subjdispstate = subjdispstate;
  }

  public CreateSubjectAreaUnitAnfrageDTO fileaccessdefinition(String fileaccessdefinition) {
    this.fileaccessdefinition = Optional.ofNullable(fileaccessdefinition);
    return this;
  }

  /**
   * Zugriffsdefinition für untergeordnete Akten
   * @return fileaccessdefinition
   */
  
  @Schema(name = "fileaccessdefinition", example = "allgemein bearbeitbar", description = "Zugriffsdefinition für untergeordnete Akten", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileaccessdefinition")
  public Optional<String> getFileaccessdefinition() {
    return fileaccessdefinition;
  }

  @JsonProperty("fileaccessdefinition")
  public void setFileaccessdefinition(Optional<String> fileaccessdefinition) {
    this.fileaccessdefinition = fileaccessdefinition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSubjectAreaUnitAnfrageDTO createSubjectAreaUnitAnfrageDTO = (CreateSubjectAreaUnitAnfrageDTO) o;
    return Objects.equals(this.objaddress, createSubjectAreaUnitAnfrageDTO.objaddress) &&
        Objects.equals(this.basenr, createSubjectAreaUnitAnfrageDTO.basenr) &&
        Objects.equals(this.subjareaspecreference, createSubjectAreaUnitAnfrageDTO.subjareaspecreference) &&
        Objects.equals(this.shortterm, createSubjectAreaUnitAnfrageDTO.shortterm) &&
        Objects.equals(this.subjarchiveschedule, createSubjectAreaUnitAnfrageDTO.subjarchiveschedule) &&
        Objects.equals(this.subjschedule, createSubjectAreaUnitAnfrageDTO.subjschedule) &&
        Objects.equals(this.subjdispstate, createSubjectAreaUnitAnfrageDTO.subjdispstate) &&
        Objects.equals(this.fileaccessdefinition, createSubjectAreaUnitAnfrageDTO.fileaccessdefinition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objaddress, basenr, subjareaspecreference, shortterm, subjarchiveschedule, subjschedule, subjdispstate, fileaccessdefinition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSubjectAreaUnitAnfrageDTO {\n");
    sb.append("    objaddress: ").append(toIndentedString(objaddress)).append("\n");
    sb.append("    basenr: ").append(toIndentedString(basenr)).append("\n");
    sb.append("    subjareaspecreference: ").append(toIndentedString(subjareaspecreference)).append("\n");
    sb.append("    shortterm: ").append(toIndentedString(shortterm)).append("\n");
    sb.append("    subjarchiveschedule: ").append(toIndentedString(subjarchiveschedule)).append("\n");
    sb.append("    subjschedule: ").append(toIndentedString(subjschedule)).append("\n");
    sb.append("    subjdispstate: ").append(toIndentedString(subjdispstate)).append("\n");
    sb.append("    fileaccessdefinition: ").append(toIndentedString(fileaccessdefinition)).append("\n");
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

    private CreateSubjectAreaUnitAnfrageDTO instance;

    public Builder() {
      this(new CreateSubjectAreaUnitAnfrageDTO());
    }

    protected Builder(CreateSubjectAreaUnitAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateSubjectAreaUnitAnfrageDTO value) { 
      this.instance.setObjaddress(value.objaddress);
      this.instance.setBasenr(value.basenr);
      this.instance.setSubjareaspecreference(value.subjareaspecreference);
      this.instance.setShortterm(value.shortterm);
      this.instance.setSubjarchiveschedule(value.subjarchiveschedule);
      this.instance.setSubjschedule(value.subjschedule);
      this.instance.setSubjdispstate(value.subjdispstate);
      this.instance.setFileaccessdefinition(value.fileaccessdefinition);
      return this;
    }

    public CreateSubjectAreaUnitAnfrageDTO.Builder objaddress(String objaddress) {
      this.instance.objaddress(objaddress);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder basenr(String basenr) {
      this.instance.basenr(basenr);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder subjareaspecreference(String subjareaspecreference) {
      this.instance.subjareaspecreference(subjareaspecreference);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder shortterm(String shortterm) {
      this.instance.shortterm(shortterm);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder subjarchiveschedule(String subjarchiveschedule) {
      this.instance.subjarchiveschedule(subjarchiveschedule);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder subjschedule(String subjschedule) {
      this.instance.subjschedule(subjschedule);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder subjdispstate(String subjdispstate) {
      this.instance.subjdispstate(subjdispstate);
      return this;
    }
    
    public CreateSubjectAreaUnitAnfrageDTO.Builder fileaccessdefinition(String fileaccessdefinition) {
      this.instance.fileaccessdefinition(fileaccessdefinition);
      return this;
    }
    
    /**
    * returns a built CreateSubjectAreaUnitAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateSubjectAreaUnitAnfrageDTO build() {
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
  public static CreateSubjectAreaUnitAnfrageDTO.Builder builder() {
    return new CreateSubjectAreaUnitAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateSubjectAreaUnitAnfrageDTO.Builder toBuilder() {
    CreateSubjectAreaUnitAnfrageDTO.Builder builder = new CreateSubjectAreaUnitAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


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
 * SearchProcedureRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SearchProcedureRequestDTO {

  private Optional<String> referrednumber = Optional.empty();

  private Optional<String> filereference = Optional.empty();

  private Optional<String> objmlname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  public SearchProcedureRequestDTO referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * COO-Adresse der Akte
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2300.1.847", description = "COO-Adresse der Akte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public SearchProcedureRequestDTO filereference(String filereference) {
    this.filereference = Optional.ofNullable(filereference);
    return this;
  }

  /**
   * eindeutiges Geschäfts-/Aktenzeichen\\ Wird im eAkte-System automatisch gebildet aus dem Aktenplaneintrag  und einer fortlaufenden Nummer der Akte  (oder \"Aktenplankennzeichen\".\"fortlaufende Nummer der Betreffseinheit\"-\"fortlaufende Nummer der Akte\" wie im Beispiel) 
   * @return filereference
   */
  
  @Schema(name = "filereference", example = "2002.1-36", description = "eindeutiges Geschäfts-/Aktenzeichen\\ Wird im eAkte-System automatisch gebildet aus dem Aktenplaneintrag  und einer fortlaufenden Nummer der Akte  (oder \"Aktenplankennzeichen\".\"fortlaufende Nummer der Betreffseinheit\"-\"fortlaufende Nummer der Akte\" wie im Beispiel) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filereference")
  public Optional<String> getFilereference() {
    return filereference;
  }

  @JsonProperty("filereference")
  public void setFilereference(Optional<String> filereference) {
    this.filereference = filereference;
  }

  public SearchProcedureRequestDTO objmlname(String objmlname) {
    this.objmlname = Optional.ofNullable(objmlname);
    return this;
  }

  /**
   * Titel des Vorgangs
   * @return objmlname
   */
  
  @Schema(name = "objmlname", example = "Vorgang Eins Name", description = "Titel des Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objmlname")
  public Optional<String> getObjmlname() {
    return objmlname;
  }

  @JsonProperty("objmlname")
  public void setObjmlname(Optional<String> objmlname) {
    this.objmlname = objmlname;
  }

  public SearchProcedureRequestDTO filesubj(String filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Betreff des Vorgangs
   * @return filesubj
   */
  
  @Schema(name = "filesubj", example = "Vorgang Eins", description = "Betreff des Vorgangs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public Optional<String> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(Optional<String> filesubj) {
    this.filesubj = filesubj;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchProcedureRequestDTO searchProcedureRequestDTO = (SearchProcedureRequestDTO) o;
    return Objects.equals(this.referrednumber, searchProcedureRequestDTO.referrednumber) &&
        Objects.equals(this.filereference, searchProcedureRequestDTO.filereference) &&
        Objects.equals(this.objmlname, searchProcedureRequestDTO.objmlname) &&
        Objects.equals(this.filesubj, searchProcedureRequestDTO.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, filereference, objmlname, filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchProcedureRequestDTO {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    filereference: ").append(toIndentedString(filereference)).append("\n");
    sb.append("    objmlname: ").append(toIndentedString(objmlname)).append("\n");
    sb.append("    filesubj: ").append(toIndentedString(filesubj)).append("\n");
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

    private SearchProcedureRequestDTO instance;

    public Builder() {
      this(new SearchProcedureRequestDTO());
    }

    protected Builder(SearchProcedureRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SearchProcedureRequestDTO value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setFilereference(value.filereference);
      this.instance.setObjmlname(value.objmlname);
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public SearchProcedureRequestDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public SearchProcedureRequestDTO.Builder filereference(String filereference) {
      this.instance.filereference(filereference);
      return this;
    }
    
    public SearchProcedureRequestDTO.Builder objmlname(String objmlname) {
      this.instance.objmlname(objmlname);
      return this;
    }
    
    public SearchProcedureRequestDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built SearchProcedureRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SearchProcedureRequestDTO build() {
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
  public static SearchProcedureRequestDTO.Builder builder() {
    return new SearchProcedureRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SearchProcedureRequestDTO.Builder toBuilder() {
    SearchProcedureRequestDTO.Builder builder = new SearchProcedureRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


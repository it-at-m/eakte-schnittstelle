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
 * SearchFileRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SearchFileRequestDTO {

  private Optional<String> apentry = Optional.empty();

  private Optional<String> filereference = Optional.empty();

  private Optional<String> objmlname = Optional.empty();

  private Optional<String> filesubj = Optional.empty();

  public SearchFileRequestDTO apentry(String apentry) {
    this.apentry = Optional.ofNullable(apentry);
    return this;
  }

  /**
   * COO-Adresse des Aktenplankennzeichen
   * @return apentry
   */
  
  @Schema(name = "apentry", example = "COO.1.2300.1.847", description = "COO-Adresse des Aktenplankennzeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("apentry")
  public Optional<String> getApentry() {
    return apentry;
  }

  @JsonProperty("apentry")
  public void setApentry(Optional<String> apentry) {
    this.apentry = apentry;
  }

  public SearchFileRequestDTO filereference(String filereference) {
    this.filereference = Optional.ofNullable(filereference);
    return this;
  }

  /**
   * eindeutiges Geschäfts-/Aktenzeichen\\ Wird im eAkte-System automatisch gebildet aus dem Aktenplaneintrag und  einer fortlaufenden Nummer der Akte  (bei Ableitungen mit .fortlaufende Nummer der Betreffseinheit im Aktenplan (siehe Beispiel)\\ 
   * @return filereference
   */
  
  @Schema(name = "filereference", example = "2002.1-36", description = "eindeutiges Geschäfts-/Aktenzeichen\\ Wird im eAkte-System automatisch gebildet aus dem Aktenplaneintrag und  einer fortlaufenden Nummer der Akte  (bei Ableitungen mit .fortlaufende Nummer der Betreffseinheit im Aktenplan (siehe Beispiel)\\ ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filereference")
  public Optional<String> getFilereference() {
    return filereference;
  }

  @JsonProperty("filereference")
  public void setFilereference(Optional<String> filereference) {
    this.filereference = filereference;
  }

  public SearchFileRequestDTO objmlname(String objmlname) {
    this.objmlname = Optional.ofNullable(objmlname);
    return this;
  }

  /**
   * Name
   * @return objmlname
   */
  
  @Schema(name = "objmlname", example = "Akte1", description = "Name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("objmlname")
  public Optional<String> getObjmlname() {
    return objmlname;
  }

  @JsonProperty("objmlname")
  public void setObjmlname(Optional<String> objmlname) {
    this.objmlname = objmlname;
  }

  public SearchFileRequestDTO filesubj(String filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Betreff
   * @return filesubj
   */
  
  @Schema(name = "filesubj", example = "Betreff der Akte", description = "Betreff", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    SearchFileRequestDTO searchFileRequestDTO = (SearchFileRequestDTO) o;
    return Objects.equals(this.apentry, searchFileRequestDTO.apentry) &&
        Objects.equals(this.filereference, searchFileRequestDTO.filereference) &&
        Objects.equals(this.objmlname, searchFileRequestDTO.objmlname) &&
        Objects.equals(this.filesubj, searchFileRequestDTO.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apentry, filereference, objmlname, filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchFileRequestDTO {\n");
    sb.append("    apentry: ").append(toIndentedString(apentry)).append("\n");
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

    private SearchFileRequestDTO instance;

    public Builder() {
      this(new SearchFileRequestDTO());
    }

    protected Builder(SearchFileRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SearchFileRequestDTO value) { 
      this.instance.setApentry(value.apentry);
      this.instance.setFilereference(value.filereference);
      this.instance.setObjmlname(value.objmlname);
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public SearchFileRequestDTO.Builder apentry(String apentry) {
      this.instance.apentry(apentry);
      return this;
    }
    
    public SearchFileRequestDTO.Builder filereference(String filereference) {
      this.instance.filereference(filereference);
      return this;
    }
    
    public SearchFileRequestDTO.Builder objmlname(String objmlname) {
      this.instance.objmlname(objmlname);
      return this;
    }
    
    public SearchFileRequestDTO.Builder filesubj(String filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built SearchFileRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SearchFileRequestDTO build() {
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
  public static SearchFileRequestDTO.Builder builder() {
    return new SearchFileRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SearchFileRequestDTO.Builder toBuilder() {
    SearchFileRequestDTO.Builder builder = new SearchFileRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


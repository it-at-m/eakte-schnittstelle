package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Parameter, die den Postkorb beschreiben
 */

@Schema(name = "CreateObjectAndImportToInboxDTO", description = "Parameter, die den Postkorb beschreiben")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateObjectAndImportToInboxDTO {

  private String objaddress;

  @Valid
  private List<List<String>> filesubj = new ArrayList<>();

  public CreateObjectAndImportToInboxDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateObjectAndImportToInboxDTO(String objaddress) {
    this.objaddress = objaddress;
  }

  public CreateObjectAndImportToInboxDTO objaddress(String objaddress) {
    this.objaddress = objaddress;
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des Postkorb
   * @return objaddress
   */
  @NotNull 
  @Schema(name = "objaddress", example = "COO.1.2302.1.8", description = "Objekt-ID (COO-Adresse) des Postkorb", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("objaddress")
  public String getObjaddress() {
    return objaddress;
  }

  @JsonProperty("objaddress")
  public void setObjaddress(String objaddress) {
    this.objaddress = objaddress;
  }

  public CreateObjectAndImportToInboxDTO filesubj(List<List<String>> filesubj) {
    this.filesubj = filesubj;
    return this;
  }

  public CreateObjectAndImportToInboxDTO addFilesubjItem(List<String> filesubjItem) {
    if (this.filesubj == null) {
      this.filesubj = new ArrayList<>();
    }
    this.filesubj.add(filesubjItem);
    return this;
  }

  /**
   * Betreff für die Datei
   * @return filesubj
   */
  @Valid 
  @Schema(name = "filesubj", description = "Betreff für die Datei", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public List<List<String>> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(List<List<String>> filesubj) {
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
    CreateObjectAndImportToInboxDTO createObjectAndImportToInboxDTO = (CreateObjectAndImportToInboxDTO) o;
    return Objects.equals(this.objaddress, createObjectAndImportToInboxDTO.objaddress) &&
        Objects.equals(this.filesubj, createObjectAndImportToInboxDTO.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objaddress, filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateObjectAndImportToInboxDTO {\n");
    sb.append("    objaddress: ").append(toIndentedString(objaddress)).append("\n");
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

    private CreateObjectAndImportToInboxDTO instance;

    public Builder() {
      this(new CreateObjectAndImportToInboxDTO());
    }

    protected Builder(CreateObjectAndImportToInboxDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateObjectAndImportToInboxDTO value) { 
      this.instance.setObjaddress(value.objaddress);
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public CreateObjectAndImportToInboxDTO.Builder objaddress(String objaddress) {
      this.instance.objaddress(objaddress);
      return this;
    }
    
    public CreateObjectAndImportToInboxDTO.Builder filesubj(List<List<String>> filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built CreateObjectAndImportToInboxDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateObjectAndImportToInboxDTO build() {
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
  public static CreateObjectAndImportToInboxDTO.Builder builder() {
    return new CreateObjectAndImportToInboxDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateObjectAndImportToInboxDTO.Builder toBuilder() {
    CreateObjectAndImportToInboxDTO.Builder builder = new CreateObjectAndImportToInboxDTO.Builder();
    return builder.copyOf(this);
  }

}


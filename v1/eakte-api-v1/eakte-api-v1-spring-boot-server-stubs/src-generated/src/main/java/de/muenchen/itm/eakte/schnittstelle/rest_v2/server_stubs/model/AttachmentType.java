package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ArrayOfstring;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AttachmentType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AttachmentType {

  private Optional<String> fileName = Optional.empty();

  private Optional<String> fileExtention = Optional.empty();

  private Optional<String> fileContent = Optional.empty();

  private Optional<String> fileContsize = Optional.empty();

  private Optional<ArrayOfstring> filesubj = Optional.empty();

  public AttachmentType fileName(String fileName) {
    this.fileName = Optional.ofNullable(fileName);
    return this;
  }

  /**
   * Get fileName
   * @return fileName
   */
  
  @Schema(name = "fileName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileName")
  public Optional<String> getFileName() {
    return fileName;
  }

  @JsonProperty("fileName")
  public void setFileName(Optional<String> fileName) {
    this.fileName = fileName;
  }

  public AttachmentType fileExtention(String fileExtention) {
    this.fileExtention = Optional.ofNullable(fileExtention);
    return this;
  }

  /**
   * Dateiendung
   * @return fileExtention
   */
  
  @Schema(name = "fileExtention", example = "txt", description = "Dateiendung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileExtention")
  public Optional<String> getFileExtention() {
    return fileExtention;
  }

  @JsonProperty("fileExtention")
  public void setFileExtention(Optional<String> fileExtention) {
    this.fileExtention = fileExtention;
  }

  public AttachmentType fileContent(String fileContent) {
    this.fileContent = Optional.ofNullable(fileContent);
    return this;
  }

  /**
   * Inhalt der Datei  (Base64 kodierter Inhalt) 
   * @return fileContent
   */
  
  @Schema(name = "fileContent", example = "SGFsbG8K (Hallo in Base64)", description = "Inhalt der Datei  (Base64 kodierter Inhalt) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileContent")
  public Optional<String> getFileContent() {
    return fileContent;
  }

  @JsonProperty("fileContent")
  public void setFileContent(Optional<String> fileContent) {
    this.fileContent = fileContent;
  }

  public AttachmentType fileContsize(String fileContsize) {
    this.fileContsize = Optional.ofNullable(fileContsize);
    return this;
  }

  /**
   * Größe der Inhalte (in KB)
   * @return fileContsize
   */
  
  @Schema(name = "fileContsize", example = "5", description = "Größe der Inhalte (in KB)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileContsize")
  public Optional<String> getFileContsize() {
    return fileContsize;
  }

  @JsonProperty("fileContsize")
  public void setFileContsize(Optional<String> fileContsize) {
    this.fileContsize = fileContsize;
  }

  public AttachmentType filesubj(ArrayOfstring filesubj) {
    this.filesubj = Optional.ofNullable(filesubj);
    return this;
  }

  /**
   * Get filesubj
   * @return filesubj
   */
  @Valid 
  @Schema(name = "filesubj", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public Optional<ArrayOfstring> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(Optional<ArrayOfstring> filesubj) {
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
    AttachmentType attachmentType = (AttachmentType) o;
    return Objects.equals(this.fileName, attachmentType.fileName) &&
        Objects.equals(this.fileExtention, attachmentType.fileExtention) &&
        Objects.equals(this.fileContent, attachmentType.fileContent) &&
        Objects.equals(this.fileContsize, attachmentType.fileContsize) &&
        Objects.equals(this.filesubj, attachmentType.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, fileExtention, fileContent, fileContsize, filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentType {\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileExtention: ").append(toIndentedString(fileExtention)).append("\n");
    sb.append("    fileContent: ").append(toIndentedString(fileContent)).append("\n");
    sb.append("    fileContsize: ").append(toIndentedString(fileContsize)).append("\n");
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

    private AttachmentType instance;

    public Builder() {
      this(new AttachmentType());
    }

    protected Builder(AttachmentType instance) {
      this.instance = instance;
    }

    protected Builder copyOf(AttachmentType value) { 
      this.instance.setFileName(value.fileName);
      this.instance.setFileExtention(value.fileExtention);
      this.instance.setFileContent(value.fileContent);
      this.instance.setFileContsize(value.fileContsize);
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public AttachmentType.Builder fileName(String fileName) {
      this.instance.fileName(fileName);
      return this;
    }
    
    public AttachmentType.Builder fileExtention(String fileExtention) {
      this.instance.fileExtention(fileExtention);
      return this;
    }
    
    public AttachmentType.Builder fileContent(String fileContent) {
      this.instance.fileContent(fileContent);
      return this;
    }
    
    public AttachmentType.Builder fileContsize(String fileContsize) {
      this.instance.fileContsize(fileContsize);
      return this;
    }
    
    public AttachmentType.Builder filesubj(ArrayOfstring filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built AttachmentType instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AttachmentType build() {
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
  public static AttachmentType.Builder builder() {
    return new AttachmentType.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AttachmentType.Builder toBuilder() {
    AttachmentType.Builder builder = new AttachmentType.Builder();
    return builder.copyOf(this);
  }

}


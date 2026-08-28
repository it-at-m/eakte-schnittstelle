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
 * UpdateContentObjectDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateContentObjectDTO {

  @Valid
  private List<String> filesubj = new ArrayList<>();

  public UpdateContentObjectDTO filesubj(List<String> filesubj) {
    this.filesubj = filesubj;
    return this;
  }

  public UpdateContentObjectDTO addFilesubjItem(String filesubjItem) {
    if (this.filesubj == null) {
      this.filesubj = new ArrayList<>();
    }
    this.filesubj.add(filesubjItem);
    return this;
  }

  /**
   * Get filesubj
   * @return filesubj
   */
  
  @Schema(name = "filesubj", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filesubj")
  public List<String> getFilesubj() {
    return filesubj;
  }

  @JsonProperty("filesubj")
  public void setFilesubj(List<String> filesubj) {
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
    UpdateContentObjectDTO updateContentObjectDTO = (UpdateContentObjectDTO) o;
    return Objects.equals(this.filesubj, updateContentObjectDTO.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateContentObjectDTO {\n");
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

    private UpdateContentObjectDTO instance;

    public Builder() {
      this(new UpdateContentObjectDTO());
    }

    protected Builder(UpdateContentObjectDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateContentObjectDTO value) { 
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public UpdateContentObjectDTO.Builder filesubj(List<String> filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built UpdateContentObjectDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateContentObjectDTO build() {
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
  public static UpdateContentObjectDTO.Builder builder() {
    return new UpdateContentObjectDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateContentObjectDTO.Builder toBuilder() {
    UpdateContentObjectDTO.Builder builder = new UpdateContentObjectDTO.Builder();
    return builder.copyOf(this);
  }

}


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
 * Parameter, die das  Schriftstück beschreiben
 */

@Schema(name = "CreateContentObjectAnfrageDTO", description = "Parameter, die das  Schriftstück beschreiben")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateContentObjectAnfrageDTO {

  private Optional<String> referrednumber = Optional.empty();

  @Valid
  private List<String> filesubj = new ArrayList<>();

  public CreateContentObjectAnfrageDTO referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des zugehörigen Dokuments
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042432", description = "Objekt-ID (COO-Adresse) des zugehörigen Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public CreateContentObjectAnfrageDTO filesubj(List<String> filesubj) {
    this.filesubj = filesubj;
    return this;
  }

  public CreateContentObjectAnfrageDTO addFilesubjItem(String filesubjItem) {
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
    CreateContentObjectAnfrageDTO createContentObjectAnfrageDTO = (CreateContentObjectAnfrageDTO) o;
    return Objects.equals(this.referrednumber, createContentObjectAnfrageDTO.referrednumber) &&
        Objects.equals(this.filesubj, createContentObjectAnfrageDTO.filesubj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, filesubj);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateContentObjectAnfrageDTO {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
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

    private CreateContentObjectAnfrageDTO instance;

    public Builder() {
      this(new CreateContentObjectAnfrageDTO());
    }

    protected Builder(CreateContentObjectAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateContentObjectAnfrageDTO value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setFilesubj(value.filesubj);
      return this;
    }

    public CreateContentObjectAnfrageDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public CreateContentObjectAnfrageDTO.Builder filesubj(List<String> filesubj) {
      this.instance.filesubj(filesubj);
      return this;
    }
    
    /**
    * returns a built CreateContentObjectAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateContentObjectAnfrageDTO build() {
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
  public static CreateContentObjectAnfrageDTO.Builder builder() {
    return new CreateContentObjectAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateContentObjectAnfrageDTO.Builder toBuilder() {
    CreateContentObjectAnfrageDTO.Builder builder = new CreateContentObjectAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


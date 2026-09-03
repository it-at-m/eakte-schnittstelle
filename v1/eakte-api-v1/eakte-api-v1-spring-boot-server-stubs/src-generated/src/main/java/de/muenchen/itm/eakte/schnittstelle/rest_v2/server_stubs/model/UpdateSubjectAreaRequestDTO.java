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
 * UpdateSubjectAreaRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateSubjectAreaRequestDTO {

  private String subjareascope;

  public UpdateSubjectAreaRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateSubjectAreaRequestDTO(String subjareascope) {
    this.subjareascope = subjareascope;
  }

  public UpdateSubjectAreaRequestDTO subjareascope(String subjareascope) {
    this.subjareascope = subjareascope;
    return this;
  }

  /**
   * Der neue Aktenplaneintragstyp.<br> Folgende Werte sind möglich: * Hauptgruppe * Obergruppe * Gruppe * Untergruppe * Betreffseinheit.  Eine Änderung darf nur erfolgen wenn der Aktenplaneintragstyp leer ist. 
   * @return subjareascope
   */
  @NotNull 
  @Schema(name = "subjareascope", example = "\"subjareascope\": \"Betreffseinheit\"", description = "Der neue Aktenplaneintragstyp.<br> Folgende Werte sind möglich: * Hauptgruppe * Obergruppe * Gruppe * Untergruppe * Betreffseinheit.  Eine Änderung darf nur erfolgen wenn der Aktenplaneintragstyp leer ist. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subjareascope")
  public String getSubjareascope() {
    return subjareascope;
  }

  @JsonProperty("subjareascope")
  public void setSubjareascope(String subjareascope) {
    this.subjareascope = subjareascope;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSubjectAreaRequestDTO updateSubjectAreaRequestDTO = (UpdateSubjectAreaRequestDTO) o;
    return Objects.equals(this.subjareascope, updateSubjectAreaRequestDTO.subjareascope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subjareascope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSubjectAreaRequestDTO {\n");
    sb.append("    subjareascope: ").append(toIndentedString(subjareascope)).append("\n");
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

    private UpdateSubjectAreaRequestDTO instance;

    public Builder() {
      this(new UpdateSubjectAreaRequestDTO());
    }

    protected Builder(UpdateSubjectAreaRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateSubjectAreaRequestDTO value) { 
      this.instance.setSubjareascope(value.subjareascope);
      return this;
    }

    public UpdateSubjectAreaRequestDTO.Builder subjareascope(String subjareascope) {
      this.instance.subjareascope(subjareascope);
      return this;
    }
    
    /**
    * returns a built UpdateSubjectAreaRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateSubjectAreaRequestDTO build() {
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
  public static UpdateSubjectAreaRequestDTO.Builder builder() {
    return new UpdateSubjectAreaRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateSubjectAreaRequestDTO.Builder toBuilder() {
    UpdateSubjectAreaRequestDTO.Builder builder = new UpdateSubjectAreaRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


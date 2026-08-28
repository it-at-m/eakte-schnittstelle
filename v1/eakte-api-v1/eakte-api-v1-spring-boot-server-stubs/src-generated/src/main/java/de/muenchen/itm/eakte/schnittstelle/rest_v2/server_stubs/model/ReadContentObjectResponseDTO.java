package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttachmentType;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReadContentObjectResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadContentObjectResponseDTO {

  private Optional<String> referrednumber = Optional.empty();

  private Optional<AttachmentType> giattachmenttype = Optional.empty();

  public ReadContentObjectResponseDTO referrednumber(String referrednumber) {
    this.referrednumber = Optional.ofNullable(referrednumber);
    return this;
  }

  /**
   * Objekt-ID (COO-Adresse) des zugehörigen Dokuments
   * @return referrednumber
   */
  
  @Schema(name = "referrednumber", example = "COO.1.2301.1.1042465", description = "Objekt-ID (COO-Adresse) des zugehörigen Dokuments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referrednumber")
  public Optional<String> getReferrednumber() {
    return referrednumber;
  }

  @JsonProperty("referrednumber")
  public void setReferrednumber(Optional<String> referrednumber) {
    this.referrednumber = referrednumber;
  }

  public ReadContentObjectResponseDTO giattachmenttype(AttachmentType giattachmenttype) {
    this.giattachmenttype = Optional.ofNullable(giattachmenttype);
    return this;
  }

  /**
   * Get giattachmenttype
   * @return giattachmenttype
   */
  @Valid 
  @Schema(name = "giattachmenttype", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("giattachmenttype")
  public Optional<AttachmentType> getGiattachmenttype() {
    return giattachmenttype;
  }

  @JsonProperty("giattachmenttype")
  public void setGiattachmenttype(Optional<AttachmentType> giattachmenttype) {
    this.giattachmenttype = giattachmenttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadContentObjectResponseDTO readContentObjectResponseDTO = (ReadContentObjectResponseDTO) o;
    return Objects.equals(this.referrednumber, readContentObjectResponseDTO.referrednumber) &&
        Objects.equals(this.giattachmenttype, readContentObjectResponseDTO.giattachmenttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, giattachmenttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadContentObjectResponseDTO {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    giattachmenttype: ").append(toIndentedString(giattachmenttype)).append("\n");
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

    private ReadContentObjectResponseDTO instance;

    public Builder() {
      this(new ReadContentObjectResponseDTO());
    }

    protected Builder(ReadContentObjectResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadContentObjectResponseDTO value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setGiattachmenttype(value.giattachmenttype);
      return this;
    }

    public ReadContentObjectResponseDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public ReadContentObjectResponseDTO.Builder giattachmenttype(AttachmentType giattachmenttype) {
      this.instance.giattachmenttype(giattachmenttype);
      return this;
    }
    
    /**
    * returns a built ReadContentObjectResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadContentObjectResponseDTO build() {
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
  public static ReadContentObjectResponseDTO.Builder builder() {
    return new ReadContentObjectResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadContentObjectResponseDTO.Builder toBuilder() {
    ReadContentObjectResponseDTO.Builder builder = new ReadContentObjectResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


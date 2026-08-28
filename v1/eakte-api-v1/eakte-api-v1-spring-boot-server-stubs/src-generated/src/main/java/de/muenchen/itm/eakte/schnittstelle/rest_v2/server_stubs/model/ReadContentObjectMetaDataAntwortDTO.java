package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.MetadataReferenz;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ReadContentObjectMetaDataAntwortDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadContentObjectMetaDataAntwortDTO {

  private Optional<String> referrednumber = Optional.empty();

  private Optional<MetadataReferenz> gimetadatatype = Optional.empty();

  public ReadContentObjectMetaDataAntwortDTO referrednumber(String referrednumber) {
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

  public ReadContentObjectMetaDataAntwortDTO gimetadatatype(MetadataReferenz gimetadatatype) {
    this.gimetadatatype = Optional.ofNullable(gimetadatatype);
    return this;
  }

  /**
   * Get gimetadatatype
   * @return gimetadatatype
   */
  @Valid 
  @Schema(name = "gimetadatatype", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gimetadatatype")
  public Optional<MetadataReferenz> getGimetadatatype() {
    return gimetadatatype;
  }

  @JsonProperty("gimetadatatype")
  public void setGimetadatatype(Optional<MetadataReferenz> gimetadatatype) {
    this.gimetadatatype = gimetadatatype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadContentObjectMetaDataAntwortDTO readContentObjectMetaDataAntwortDTO = (ReadContentObjectMetaDataAntwortDTO) o;
    return Objects.equals(this.referrednumber, readContentObjectMetaDataAntwortDTO.referrednumber) &&
        Objects.equals(this.gimetadatatype, readContentObjectMetaDataAntwortDTO.gimetadatatype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referrednumber, gimetadatatype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadContentObjectMetaDataAntwortDTO {\n");
    sb.append("    referrednumber: ").append(toIndentedString(referrednumber)).append("\n");
    sb.append("    gimetadatatype: ").append(toIndentedString(gimetadatatype)).append("\n");
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

    private ReadContentObjectMetaDataAntwortDTO instance;

    public Builder() {
      this(new ReadContentObjectMetaDataAntwortDTO());
    }

    protected Builder(ReadContentObjectMetaDataAntwortDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadContentObjectMetaDataAntwortDTO value) { 
      this.instance.setReferrednumber(value.referrednumber);
      this.instance.setGimetadatatype(value.gimetadatatype);
      return this;
    }

    public ReadContentObjectMetaDataAntwortDTO.Builder referrednumber(String referrednumber) {
      this.instance.referrednumber(referrednumber);
      return this;
    }
    
    public ReadContentObjectMetaDataAntwortDTO.Builder gimetadatatype(MetadataReferenz gimetadatatype) {
      this.instance.gimetadatatype(gimetadatatype);
      return this;
    }
    
    /**
    * returns a built ReadContentObjectMetaDataAntwortDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadContentObjectMetaDataAntwortDTO build() {
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
  public static ReadContentObjectMetaDataAntwortDTO.Builder builder() {
    return new ReadContentObjectMetaDataAntwortDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadContentObjectMetaDataAntwortDTO.Builder toBuilder() {
    ReadContentObjectMetaDataAntwortDTO.Builder builder = new ReadContentObjectMetaDataAntwortDTO.Builder();
    return builder.copyOf(this);
  }

}


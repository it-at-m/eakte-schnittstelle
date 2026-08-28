package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.BusinessObjectReference;
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
 * ReadDocumentObjectMetaDataResponseDTO1
 */

@JsonTypeName("ReadDocumentObjectMetaDataResponseDTO_1")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadDocumentObjectMetaDataResponseDTO1 {

  @Valid
  private List<@Valid BusinessObjectReference> businessobjecttype = new ArrayList<>();

  public ReadDocumentObjectMetaDataResponseDTO1 businessobjecttype(List<@Valid BusinessObjectReference> businessobjecttype) {
    this.businessobjecttype = businessobjecttype;
    return this;
  }

  public ReadDocumentObjectMetaDataResponseDTO1 addBusinessobjecttypeItem(BusinessObjectReference businessobjecttypeItem) {
    if (this.businessobjecttype == null) {
      this.businessobjecttype = new ArrayList<>();
    }
    this.businessobjecttype.add(businessobjecttypeItem);
    return this;
  }

  /**
   * Liste der Dokumente mit Metadaten eines Vorgangs auslesen
   * @return businessobjecttype
   */
  @Valid 
  @Schema(name = "businessobjecttype", example = "BusinessObjectType", description = "Liste der Dokumente mit Metadaten eines Vorgangs auslesen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessobjecttype")
  public List<@Valid BusinessObjectReference> getBusinessobjecttype() {
    return businessobjecttype;
  }

  @JsonProperty("businessobjecttype")
  public void setBusinessobjecttype(List<@Valid BusinessObjectReference> businessobjecttype) {
    this.businessobjecttype = businessobjecttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadDocumentObjectMetaDataResponseDTO1 readDocumentObjectMetaDataResponseDTO1 = (ReadDocumentObjectMetaDataResponseDTO1) o;
    return Objects.equals(this.businessobjecttype, readDocumentObjectMetaDataResponseDTO1.businessobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(businessobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadDocumentObjectMetaDataResponseDTO1 {\n");
    sb.append("    businessobjecttype: ").append(toIndentedString(businessobjecttype)).append("\n");
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

    private ReadDocumentObjectMetaDataResponseDTO1 instance;

    public Builder() {
      this(new ReadDocumentObjectMetaDataResponseDTO1());
    }

    protected Builder(ReadDocumentObjectMetaDataResponseDTO1 instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadDocumentObjectMetaDataResponseDTO1 value) { 
      this.instance.setBusinessobjecttype(value.businessobjecttype);
      return this;
    }

    public ReadDocumentObjectMetaDataResponseDTO1.Builder businessobjecttype(List<BusinessObjectReference> businessobjecttype) {
      this.instance.businessobjecttype(businessobjecttype);
      return this;
    }
    
    /**
    * returns a built ReadDocumentObjectMetaDataResponseDTO1 instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadDocumentObjectMetaDataResponseDTO1 build() {
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
  public static ReadDocumentObjectMetaDataResponseDTO1.Builder builder() {
    return new ReadDocumentObjectMetaDataResponseDTO1.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadDocumentObjectMetaDataResponseDTO1.Builder toBuilder() {
    ReadDocumentObjectMetaDataResponseDTO1.Builder builder = new ReadDocumentObjectMetaDataResponseDTO1.Builder();
    return builder.copyOf(this);
  }

}


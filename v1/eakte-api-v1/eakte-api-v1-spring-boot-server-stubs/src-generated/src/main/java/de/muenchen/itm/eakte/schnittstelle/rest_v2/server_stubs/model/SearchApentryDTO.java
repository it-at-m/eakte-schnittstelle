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
 * SearchApentryDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SearchApentryDTO {

  private Optional<String> basenr = Optional.empty();

  private Optional<String> subjareaspecreference = Optional.empty();

  public SearchApentryDTO basenr(String basenr) {
    this.basenr = Optional.ofNullable(basenr);
    return this;
  }

  /**
   * Aktenplankennzeichen
   * @return basenr
   */
  
  @Schema(name = "basenr", example = "A1 01 01 01 01", description = "Aktenplankennzeichen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("basenr")
  public Optional<String> getBasenr() {
    return basenr;
  }

  @JsonProperty("basenr")
  public void setBasenr(Optional<String> basenr) {
    this.basenr = basenr;
  }

  public SearchApentryDTO subjareaspecreference(String subjareaspecreference) {
    this.subjareaspecreference = Optional.ofNullable(subjareaspecreference);
    return this;
  }

  /**
   * Ableitung
   * @return subjareaspecreference
   */
  
  @Schema(name = "subjareaspecreference", example = "Ableitung1", description = "Ableitung", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subjareaspecreference")
  public Optional<String> getSubjareaspecreference() {
    return subjareaspecreference;
  }

  @JsonProperty("subjareaspecreference")
  public void setSubjareaspecreference(Optional<String> subjareaspecreference) {
    this.subjareaspecreference = subjareaspecreference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchApentryDTO searchApentryDTO = (SearchApentryDTO) o;
    return Objects.equals(this.basenr, searchApentryDTO.basenr) &&
        Objects.equals(this.subjareaspecreference, searchApentryDTO.subjareaspecreference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(basenr, subjareaspecreference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchApentryDTO {\n");
    sb.append("    basenr: ").append(toIndentedString(basenr)).append("\n");
    sb.append("    subjareaspecreference: ").append(toIndentedString(subjareaspecreference)).append("\n");
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

    private SearchApentryDTO instance;

    public Builder() {
      this(new SearchApentryDTO());
    }

    protected Builder(SearchApentryDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SearchApentryDTO value) { 
      this.instance.setBasenr(value.basenr);
      this.instance.setSubjareaspecreference(value.subjareaspecreference);
      return this;
    }

    public SearchApentryDTO.Builder basenr(String basenr) {
      this.instance.basenr(basenr);
      return this;
    }
    
    public SearchApentryDTO.Builder subjareaspecreference(String subjareaspecreference) {
      this.instance.subjareaspecreference(subjareaspecreference);
      return this;
    }
    
    /**
    * returns a built SearchApentryDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SearchApentryDTO build() {
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
  public static SearchApentryDTO.Builder builder() {
    return new SearchApentryDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SearchApentryDTO.Builder toBuilder() {
    SearchApentryDTO.Builder builder = new SearchApentryDTO.Builder();
    return builder.copyOf(this);
  }

}


package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Objektreferenz;
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
 * SearchApentryResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SearchApentryResponseDTO {

  @Valid
  private List<@Valid Objektreferenz> giobjecttype = new ArrayList<>();

  public SearchApentryResponseDTO giobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
    return this;
  }

  public SearchApentryResponseDTO addGiobjecttypeItem(Objektreferenz giobjecttypeItem) {
    if (this.giobjecttype == null) {
      this.giobjecttype = new ArrayList<>();
    }
    this.giobjecttype.add(giobjecttypeItem);
    return this;
  }

  /**
   * Auflistung aller Objekte, auf die der Suchstring zutrifft.<br> Rückgabe der Eigenschaften, die im Datentyp GIObjectType definiert sind. 
   * @return giobjecttype
   */
  @Valid 
  @Schema(name = "giobjecttype", description = "Auflistung aller Objekte, auf die der Suchstring zutrifft.<br> Rückgabe der Eigenschaften, die im Datentyp GIObjectType definiert sind. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("giobjecttype")
  public List<@Valid Objektreferenz> getGiobjecttype() {
    return giobjecttype;
  }

  @JsonProperty("giobjecttype")
  public void setGiobjecttype(List<@Valid Objektreferenz> giobjecttype) {
    this.giobjecttype = giobjecttype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchApentryResponseDTO searchApentryResponseDTO = (SearchApentryResponseDTO) o;
    return Objects.equals(this.giobjecttype, searchApentryResponseDTO.giobjecttype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(giobjecttype);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchApentryResponseDTO {\n");
    sb.append("    giobjecttype: ").append(toIndentedString(giobjecttype)).append("\n");
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

    private SearchApentryResponseDTO instance;

    public Builder() {
      this(new SearchApentryResponseDTO());
    }

    protected Builder(SearchApentryResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SearchApentryResponseDTO value) { 
      this.instance.setGiobjecttype(value.giobjecttype);
      return this;
    }

    public SearchApentryResponseDTO.Builder giobjecttype(List<Objektreferenz> giobjecttype) {
      this.instance.giobjecttype(giobjecttype);
      return this;
    }
    
    /**
    * returns a built SearchApentryResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SearchApentryResponseDTO build() {
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
  public static SearchApentryResponseDTO.Builder builder() {
    return new SearchApentryResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SearchApentryResponseDTO.Builder toBuilder() {
    SearchApentryResponseDTO.Builder builder = new SearchApentryResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


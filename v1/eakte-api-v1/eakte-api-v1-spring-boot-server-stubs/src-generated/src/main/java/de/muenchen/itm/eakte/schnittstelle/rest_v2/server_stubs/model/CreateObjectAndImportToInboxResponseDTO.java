package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.MetadataReferenz;
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
 * CreateObjectAndImportToInboxResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class CreateObjectAndImportToInboxResponseDTO {

  @Valid
  private List<@Valid MetadataReferenz> listcontents = new ArrayList<>();

  public CreateObjectAndImportToInboxResponseDTO listcontents(List<@Valid MetadataReferenz> listcontents) {
    this.listcontents = listcontents;
    return this;
  }

  public CreateObjectAndImportToInboxResponseDTO addListcontentsItem(MetadataReferenz listcontentsItem) {
    if (this.listcontents == null) {
      this.listcontents = new ArrayList<>();
    }
    this.listcontents.add(listcontentsItem);
    return this;
  }

  /**
   * Get listcontents
   * @return listcontents
   */
  @Valid 
  @Schema(name = "listcontents", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("listcontents")
  public List<@Valid MetadataReferenz> getListcontents() {
    return listcontents;
  }

  @JsonProperty("listcontents")
  public void setListcontents(List<@Valid MetadataReferenz> listcontents) {
    this.listcontents = listcontents;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateObjectAndImportToInboxResponseDTO createObjectAndImportToInboxResponseDTO = (CreateObjectAndImportToInboxResponseDTO) o;
    return Objects.equals(this.listcontents, createObjectAndImportToInboxResponseDTO.listcontents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listcontents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateObjectAndImportToInboxResponseDTO {\n");
    sb.append("    listcontents: ").append(toIndentedString(listcontents)).append("\n");
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

    private CreateObjectAndImportToInboxResponseDTO instance;

    public Builder() {
      this(new CreateObjectAndImportToInboxResponseDTO());
    }

    protected Builder(CreateObjectAndImportToInboxResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateObjectAndImportToInboxResponseDTO value) { 
      this.instance.setListcontents(value.listcontents);
      return this;
    }

    public CreateObjectAndImportToInboxResponseDTO.Builder listcontents(List<MetadataReferenz> listcontents) {
      this.instance.listcontents(listcontents);
      return this;
    }
    
    /**
    * returns a built CreateObjectAndImportToInboxResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateObjectAndImportToInboxResponseDTO build() {
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
  public static CreateObjectAndImportToInboxResponseDTO.Builder builder() {
    return new CreateObjectAndImportToInboxResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateObjectAndImportToInboxResponseDTO.Builder toBuilder() {
    CreateObjectAndImportToInboxResponseDTO.Builder builder = new CreateObjectAndImportToInboxResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


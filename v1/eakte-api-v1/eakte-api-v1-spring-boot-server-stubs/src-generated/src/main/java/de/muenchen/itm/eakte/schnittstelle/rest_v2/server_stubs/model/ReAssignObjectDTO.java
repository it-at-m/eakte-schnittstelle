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
 * ReAssignObjectDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReAssignObjectDTO {

  private String newtarget;

  private Optional<String> newoe = Optional.empty();

  public ReAssignObjectDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReAssignObjectDTO(String newtarget) {
    this.newtarget = newtarget;
  }

  public ReAssignObjectDTO newtarget(String newtarget) {
    this.newtarget = newtarget;
    return this;
  }

  /**
   * COO-Adresse des neuen darüberliegenden Objektes (Betreffseinheit oder Akte) 
   * @return newtarget
   */
  @NotNull 
  @Schema(name = "newtarget", example = "COO.1.2302.1.76", description = "COO-Adresse des neuen darüberliegenden Objektes (Betreffseinheit oder Akte) ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newtarget")
  public String getNewtarget() {
    return newtarget;
  }

  @JsonProperty("newtarget")
  public void setNewtarget(String newtarget) {
    this.newtarget = newtarget;
  }

  public ReAssignObjectDTO newoe(String newoe) {
    this.newoe = Optional.ofNullable(newoe);
    return this;
  }

  /**
   * COO-Adresse der Organisationseinheit
   * @return newoe
   */
  
  @Schema(name = "newoe", example = "COO.1.23.10.8854", description = "COO-Adresse der Organisationseinheit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("newoe")
  public Optional<String> getNewoe() {
    return newoe;
  }

  @JsonProperty("newoe")
  public void setNewoe(Optional<String> newoe) {
    this.newoe = newoe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReAssignObjectDTO reAssignObjectDTO = (ReAssignObjectDTO) o;
    return Objects.equals(this.newtarget, reAssignObjectDTO.newtarget) &&
        Objects.equals(this.newoe, reAssignObjectDTO.newoe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newtarget, newoe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReAssignObjectDTO {\n");
    sb.append("    newtarget: ").append(toIndentedString(newtarget)).append("\n");
    sb.append("    newoe: ").append(toIndentedString(newoe)).append("\n");
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

    private ReAssignObjectDTO instance;

    public Builder() {
      this(new ReAssignObjectDTO());
    }

    protected Builder(ReAssignObjectDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReAssignObjectDTO value) { 
      this.instance.setNewtarget(value.newtarget);
      this.instance.setNewoe(value.newoe);
      return this;
    }

    public ReAssignObjectDTO.Builder newtarget(String newtarget) {
      this.instance.newtarget(newtarget);
      return this;
    }
    
    public ReAssignObjectDTO.Builder newoe(String newoe) {
      this.instance.newoe(newoe);
      return this;
    }
    
    /**
    * returns a built ReAssignObjectDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReAssignObjectDTO build() {
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
  public static ReAssignObjectDTO.Builder builder() {
    return new ReAssignObjectDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReAssignObjectDTO.Builder toBuilder() {
    ReAssignObjectDTO.Builder builder = new ReAssignObjectDTO.Builder();
    return builder.copyOf(this);
  }

}


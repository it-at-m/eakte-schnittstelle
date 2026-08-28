package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.UserFormsReferenz;
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
 * UpdateUserFormsDataRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateUserFormsDataRequestDTO {

  @Valid
  private List<@Valid UserFormsReferenz> userformsdata = new ArrayList<>();

  public UpdateUserFormsDataRequestDTO userformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
    return this;
  }

  public UpdateUserFormsDataRequestDTO addUserformsdataItem(UserFormsReferenz userformsdataItem) {
    if (this.userformsdata == null) {
      this.userformsdata = new ArrayList<>();
    }
    this.userformsdata.add(userformsdataItem);
    return this;
  }

  /**
   * Get userformsdata
   * @return userformsdata
   */
  @Valid 
  @Schema(name = "userformsdata", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userformsdata")
  public List<@Valid UserFormsReferenz> getUserformsdata() {
    return userformsdata;
  }

  @JsonProperty("userformsdata")
  public void setUserformsdata(List<@Valid UserFormsReferenz> userformsdata) {
    this.userformsdata = userformsdata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserFormsDataRequestDTO updateUserFormsDataRequestDTO = (UpdateUserFormsDataRequestDTO) o;
    return Objects.equals(this.userformsdata, updateUserFormsDataRequestDTO.userformsdata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userformsdata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserFormsDataRequestDTO {\n");
    sb.append("    userformsdata: ").append(toIndentedString(userformsdata)).append("\n");
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

    private UpdateUserFormsDataRequestDTO instance;

    public Builder() {
      this(new UpdateUserFormsDataRequestDTO());
    }

    protected Builder(UpdateUserFormsDataRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateUserFormsDataRequestDTO value) { 
      this.instance.setUserformsdata(value.userformsdata);
      return this;
    }

    public UpdateUserFormsDataRequestDTO.Builder userformsdata(List<UserFormsReferenz> userformsdata) {
      this.instance.userformsdata(userformsdata);
      return this;
    }
    
    /**
    * returns a built UpdateUserFormsDataRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateUserFormsDataRequestDTO build() {
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
  public static UpdateUserFormsDataRequestDTO.Builder builder() {
    return new UpdateUserFormsDataRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateUserFormsDataRequestDTO.Builder toBuilder() {
    UpdateUserFormsDataRequestDTO.Builder builder = new UpdateUserFormsDataRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


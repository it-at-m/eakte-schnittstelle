package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ArrayOfint;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.ArrayOfstring;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Rückgabe der Verfahrenseigenschaft bestehend aus * dem Wert (oder Werteliste) der Verfahrenseigenschaft * der internen lfd. Nummer des Wertes der Verfahrenseigenschaft (bei einer Liste jeweils die lfdNr. aller Werte) * dem zugehörigen Referenznamen zur lfd. Nummer des Wertes der Verfahrenseigenschaft (bei einer Liste die Referenznamen aller Werte) 
 */

@Schema(name = "ReadUserFormsDataResponseDTO", description = "Rückgabe der Verfahrenseigenschaft bestehend aus * dem Wert (oder Werteliste) der Verfahrenseigenschaft * der internen lfd. Nummer des Wertes der Verfahrenseigenschaft (bei einer Liste jeweils die lfdNr. aller Werte) * dem zugehörigen Referenznamen zur lfd. Nummer des Wertes der Verfahrenseigenschaft (bei einer Liste die Referenznamen aller Werte) ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class ReadUserFormsDataResponseDTO {

  private Optional<String> value = Optional.empty();

  private Optional<ArrayOfint> enuminteger = Optional.empty();

  private Optional<ArrayOfstring> enumreference = Optional.empty();

  public ReadUserFormsDataResponseDTO value(String value) {
    this.value = Optional.ofNullable(value);
    return this;
  }

  /**
   * Wert(e) der Verfahreneigenschaft als String
   * @return value
   */
  
  @Schema(name = "value", example = "Direktorium IT-Referat, Personal- und Organisationsreferat", description = "Wert(e) der Verfahreneigenschaft als String", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Optional<String> value) {
    this.value = value;
  }

  public ReadUserFormsDataResponseDTO enuminteger(ArrayOfint enuminteger) {
    this.enuminteger = Optional.ofNullable(enuminteger);
    return this;
  }

  /**
   * Get enuminteger
   * @return enuminteger
   */
  @Valid 
  @Schema(name = "enuminteger", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enuminteger")
  public Optional<ArrayOfint> getEnuminteger() {
    return enuminteger;
  }

  @JsonProperty("enuminteger")
  public void setEnuminteger(Optional<ArrayOfint> enuminteger) {
    this.enuminteger = enuminteger;
  }

  public ReadUserFormsDataResponseDTO enumreference(ArrayOfstring enumreference) {
    this.enumreference = Optional.ofNullable(enumreference);
    return this;
  }

  /**
   * Get enumreference
   * @return enumreference
   */
  @Valid 
  @Schema(name = "enumreference", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enumreference")
  public Optional<ArrayOfstring> getEnumreference() {
    return enumreference;
  }

  @JsonProperty("enumreference")
  public void setEnumreference(Optional<ArrayOfstring> enumreference) {
    this.enumreference = enumreference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadUserFormsDataResponseDTO readUserFormsDataResponseDTO = (ReadUserFormsDataResponseDTO) o;
    return Objects.equals(this.value, readUserFormsDataResponseDTO.value) &&
        Objects.equals(this.enuminteger, readUserFormsDataResponseDTO.enuminteger) &&
        Objects.equals(this.enumreference, readUserFormsDataResponseDTO.enumreference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, enuminteger, enumreference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadUserFormsDataResponseDTO {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    enuminteger: ").append(toIndentedString(enuminteger)).append("\n");
    sb.append("    enumreference: ").append(toIndentedString(enumreference)).append("\n");
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

    private ReadUserFormsDataResponseDTO instance;

    public Builder() {
      this(new ReadUserFormsDataResponseDTO());
    }

    protected Builder(ReadUserFormsDataResponseDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ReadUserFormsDataResponseDTO value) { 
      this.instance.setValue(value.value);
      this.instance.setEnuminteger(value.enuminteger);
      this.instance.setEnumreference(value.enumreference);
      return this;
    }

    public ReadUserFormsDataResponseDTO.Builder value(String value) {
      this.instance.value(value);
      return this;
    }
    
    public ReadUserFormsDataResponseDTO.Builder enuminteger(ArrayOfint enuminteger) {
      this.instance.enuminteger(enuminteger);
      return this;
    }
    
    public ReadUserFormsDataResponseDTO.Builder enumreference(ArrayOfstring enumreference) {
      this.instance.enumreference(enumreference);
      return this;
    }
    
    /**
    * returns a built ReadUserFormsDataResponseDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ReadUserFormsDataResponseDTO build() {
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
  public static ReadUserFormsDataResponseDTO.Builder builder() {
    return new ReadUserFormsDataResponseDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ReadUserFormsDataResponseDTO.Builder toBuilder() {
    ReadUserFormsDataResponseDTO.Builder builder = new ReadUserFormsDataResponseDTO.Builder();
    return builder.copyOf(this);
  }

}


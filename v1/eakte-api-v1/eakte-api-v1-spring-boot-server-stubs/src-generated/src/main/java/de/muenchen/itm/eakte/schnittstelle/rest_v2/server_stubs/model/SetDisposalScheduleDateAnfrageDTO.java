package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SetDisposalScheduleDateAnfrageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SetDisposalScheduleDateAnfrageDTO {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime offltscheduled;

  public SetDisposalScheduleDateAnfrageDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SetDisposalScheduleDateAnfrageDTO(OffsetDateTime offltscheduled) {
    this.offltscheduled = offltscheduled;
  }

  public SetDisposalScheduleDateAnfrageDTO offltscheduled(OffsetDateTime offltscheduled) {
    this.offltscheduled = offltscheduled;
    return this;
  }

  /**
   * Hier kann das Datum neu gesetzt werden, bis wann die Aufbewahrung dauern soll.<br> Nach Ablauf dieses Datums startet der Aussonderungsprozess und  die Akte / Vorgang können nicht mehr durch Sachbearbeitungen bearbeitet werden. 
   * @return offltscheduled
   */
  @NotNull @Valid 
  @Schema(name = "offltscheduled", description = "Hier kann das Datum neu gesetzt werden, bis wann die Aufbewahrung dauern soll.<br> Nach Ablauf dieses Datums startet der Aussonderungsprozess und  die Akte / Vorgang können nicht mehr durch Sachbearbeitungen bearbeitet werden. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("offltscheduled")
  public OffsetDateTime getOffltscheduled() {
    return offltscheduled;
  }

  @JsonProperty("offltscheduled")
  public void setOffltscheduled(OffsetDateTime offltscheduled) {
    this.offltscheduled = offltscheduled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetDisposalScheduleDateAnfrageDTO setDisposalScheduleDateAnfrageDTO = (SetDisposalScheduleDateAnfrageDTO) o;
    return Objects.equals(this.offltscheduled, setDisposalScheduleDateAnfrageDTO.offltscheduled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offltscheduled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetDisposalScheduleDateAnfrageDTO {\n");
    sb.append("    offltscheduled: ").append(toIndentedString(offltscheduled)).append("\n");
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

    private SetDisposalScheduleDateAnfrageDTO instance;

    public Builder() {
      this(new SetDisposalScheduleDateAnfrageDTO());
    }

    protected Builder(SetDisposalScheduleDateAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SetDisposalScheduleDateAnfrageDTO value) { 
      this.instance.setOffltscheduled(value.offltscheduled);
      return this;
    }

    public SetDisposalScheduleDateAnfrageDTO.Builder offltscheduled(OffsetDateTime offltscheduled) {
      this.instance.offltscheduled(offltscheduled);
      return this;
    }
    
    /**
    * returns a built SetDisposalScheduleDateAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SetDisposalScheduleDateAnfrageDTO build() {
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
  public static SetDisposalScheduleDateAnfrageDTO.Builder builder() {
    return new SetDisposalScheduleDateAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SetDisposalScheduleDateAnfrageDTO.Builder toBuilder() {
    SetDisposalScheduleDateAnfrageDTO.Builder builder = new SetDisposalScheduleDateAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


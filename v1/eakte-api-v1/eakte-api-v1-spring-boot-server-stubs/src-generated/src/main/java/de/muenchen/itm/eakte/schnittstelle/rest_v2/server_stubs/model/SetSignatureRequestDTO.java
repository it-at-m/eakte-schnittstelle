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
 * SetSignatureRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class SetSignatureRequestDTO {

  private String signaturetype;

  private Optional<String> remark = Optional.empty();

  public SetSignatureRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SetSignatureRequestDTO(String signaturetype) {
    this.signaturetype = signaturetype;
  }

  public SetSignatureRequestDTO signaturetype(String signaturetype) {
    this.signaturetype = signaturetype;
    return this;
  }

  /**
   * COO-Adresse der Unterschriftenart<br> Anmerkung:<br> Titel ist nicht eindeutig, da es im System mehrere Unterschriftenarten mit dem gleichen Namen/Titel gibt.<br> In den jeweiligen Anwendungsfällen  (z.B. Vorgang stornieren, Eingang sperren, Eingang weglegen, Erledigung unterschreiben)  sind die Referenzen für Unterschriftsarten (signaturetype) definiert 
   * @return signaturetype
   */
  @NotNull 
  @Schema(name = "signaturetype", example = "COO.1.1001.1.6485", description = "COO-Adresse der Unterschriftenart<br> Anmerkung:<br> Titel ist nicht eindeutig, da es im System mehrere Unterschriftenarten mit dem gleichen Namen/Titel gibt.<br> In den jeweiligen Anwendungsfällen  (z.B. Vorgang stornieren, Eingang sperren, Eingang weglegen, Erledigung unterschreiben)  sind die Referenzen für Unterschriftsarten (signaturetype) definiert ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("signaturetype")
  public String getSignaturetype() {
    return signaturetype;
  }

  @JsonProperty("signaturetype")
  public void setSignaturetype(String signaturetype) {
    this.signaturetype = signaturetype;
  }

  public SetSignatureRequestDTO remark(String remark) {
    this.remark = Optional.ofNullable(remark);
    return this;
  }

  /**
   * Bemerkung zur Unterschrift
   * @return remark
   */
  
  @Schema(name = "remark", example = "String", description = "Bemerkung zur Unterschrift", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remark")
  public Optional<String> getRemark() {
    return remark;
  }

  @JsonProperty("remark")
  public void setRemark(Optional<String> remark) {
    this.remark = remark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetSignatureRequestDTO setSignatureRequestDTO = (SetSignatureRequestDTO) o;
    return Objects.equals(this.signaturetype, setSignatureRequestDTO.signaturetype) &&
        Objects.equals(this.remark, setSignatureRequestDTO.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signaturetype, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetSignatureRequestDTO {\n");
    sb.append("    signaturetype: ").append(toIndentedString(signaturetype)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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

    private SetSignatureRequestDTO instance;

    public Builder() {
      this(new SetSignatureRequestDTO());
    }

    protected Builder(SetSignatureRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(SetSignatureRequestDTO value) { 
      this.instance.setSignaturetype(value.signaturetype);
      this.instance.setRemark(value.remark);
      return this;
    }

    public SetSignatureRequestDTO.Builder signaturetype(String signaturetype) {
      this.instance.signaturetype(signaturetype);
      return this;
    }
    
    public SetSignatureRequestDTO.Builder remark(String remark) {
      this.instance.remark(remark);
      return this;
    }
    
    /**
    * returns a built SetSignatureRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public SetSignatureRequestDTO build() {
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
  public static SetSignatureRequestDTO.Builder builder() {
    return new SetSignatureRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public SetSignatureRequestDTO.Builder toBuilder() {
    SetSignatureRequestDTO.Builder builder = new SetSignatureRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


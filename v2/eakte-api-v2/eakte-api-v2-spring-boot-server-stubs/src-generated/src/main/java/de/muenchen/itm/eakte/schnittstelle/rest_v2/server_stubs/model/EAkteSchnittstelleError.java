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
 * Container für konkrete Fehlermeldungen, die während der Kommunikation von eAkte-Interface zu Fabasoft eGov-Suite auftreten können. 
 */

@Schema(name = "EAkteSchnittstelleError", description = "Container für konkrete Fehlermeldungen, die während der Kommunikation von eAkte-Interface zu Fabasoft eGov-Suite auftreten können. ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class EAkteSchnittstelleError {

  private Integer easFehlercode;

  private String easFehler;

  private Optional<String> easDetail = Optional.empty();

  public EAkteSchnittstelleError() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EAkteSchnittstelleError(Integer easFehlercode, String easFehler) {
    this.easFehlercode = easFehlercode;
    this.easFehler = easFehler;
  }

  public EAkteSchnittstelleError easFehlercode(Integer easFehlercode) {
    this.easFehlercode = easFehlercode;
    return this;
  }

  /**
   * Get easFehlercode
   * @return easFehlercode
   */
  @NotNull 
  @Schema(name = "easFehlercode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("easFehlercode")
  public Integer getEasFehlercode() {
    return easFehlercode;
  }

  @JsonProperty("easFehlercode")
  public void setEasFehlercode(Integer easFehlercode) {
    this.easFehlercode = easFehlercode;
  }

  public EAkteSchnittstelleError easFehler(String easFehler) {
    this.easFehler = easFehler;
    return this;
  }

  /**
   * Get easFehler
   * @return easFehler
   */
  @NotNull 
  @Schema(name = "easFehler", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("easFehler")
  public String getEasFehler() {
    return easFehler;
  }

  @JsonProperty("easFehler")
  public void setEasFehler(String easFehler) {
    this.easFehler = easFehler;
  }

  public EAkteSchnittstelleError easDetail(String easDetail) {
    this.easDetail = Optional.ofNullable(easDetail);
    return this;
  }

  /**
   * Get easDetail
   * @return easDetail
   */
  
  @Schema(name = "easDetail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("easDetail")
  public Optional<String> getEasDetail() {
    return easDetail;
  }

  @JsonProperty("easDetail")
  public void setEasDetail(Optional<String> easDetail) {
    this.easDetail = easDetail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EAkteSchnittstelleError eakteSchnittstelleError = (EAkteSchnittstelleError) o;
    return Objects.equals(this.easFehlercode, eakteSchnittstelleError.easFehlercode) &&
        Objects.equals(this.easFehler, eakteSchnittstelleError.easFehler) &&
        Objects.equals(this.easDetail, eakteSchnittstelleError.easDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(easFehlercode, easFehler, easDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EAkteSchnittstelleError {\n");
    sb.append("    easFehlercode: ").append(toIndentedString(easFehlercode)).append("\n");
    sb.append("    easFehler: ").append(toIndentedString(easFehler)).append("\n");
    sb.append("    easDetail: ").append(toIndentedString(easDetail)).append("\n");
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

    private EAkteSchnittstelleError instance;

    public Builder() {
      this(new EAkteSchnittstelleError());
    }

    protected Builder(EAkteSchnittstelleError instance) {
      this.instance = instance;
    }

    protected Builder copyOf(EAkteSchnittstelleError value) { 
      this.instance.setEasFehlercode(value.easFehlercode);
      this.instance.setEasFehler(value.easFehler);
      this.instance.setEasDetail(value.easDetail);
      return this;
    }

    public EAkteSchnittstelleError.Builder easFehlercode(Integer easFehlercode) {
      this.instance.easFehlercode(easFehlercode);
      return this;
    }
    
    public EAkteSchnittstelleError.Builder easFehler(String easFehler) {
      this.instance.easFehler(easFehler);
      return this;
    }
    
    public EAkteSchnittstelleError.Builder easDetail(String easDetail) {
      this.instance.easDetail(easDetail);
      return this;
    }
    
    /**
    * returns a built EAkteSchnittstelleError instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public EAkteSchnittstelleError build() {
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
  public static EAkteSchnittstelleError.Builder builder() {
    return new EAkteSchnittstelleError.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public EAkteSchnittstelleError.Builder toBuilder() {
    EAkteSchnittstelleError.Builder builder = new EAkteSchnittstelleError.Builder();
    return builder.copyOf(this);
  }

}


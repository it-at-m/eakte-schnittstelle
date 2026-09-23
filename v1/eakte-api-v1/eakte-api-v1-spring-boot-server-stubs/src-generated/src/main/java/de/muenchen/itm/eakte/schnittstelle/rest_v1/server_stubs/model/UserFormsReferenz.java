package de.muenchen.itm.eakte.schnittstelle.rest_v1.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Referenz der Verfahrenseigenschaft und der entsprechende Wert.&lt;br&gt; Folgende Typen für Verfahrenseigenschaft werden unterstützt: * Zeichenkette und Zeichenkettenliste (Textfeld) * Datum (und Zeit), z.B. \&quot;01.02.2003 12:00:00\&quot; * Boolean (\&quot;ja\&quot; für true) * Integer und Float (z.B. \&quot;3,14\&quot;) * Währung, z.B. \&quot;99,90\&quot; (\&quot;EUR\&quot; wir implizit mitgesetzt) * Aufzählungen (bzw. Optionsfelder) mittels Integer-Wert, wobei geprüft wird, ob der Integer Wert auch vorhanden ist. * Objektzeiger und Objektlisten mittels COO-Adresse 
 */

@Schema(name = "UserFormsReferenz", description = "Referenz der Verfahrenseigenschaft und der entsprechende Wert.<br> Folgende Typen für Verfahrenseigenschaft werden unterstützt: * Zeichenkette und Zeichenkettenliste (Textfeld) * Datum (und Zeit), z.B. \"01.02.2003 12:00:00\" * Boolean (\"ja\" für true) * Integer und Float (z.B. \"3,14\") * Währung, z.B. \"99,90\" (\"EUR\" wir implizit mitgesetzt) * Aufzählungen (bzw. Optionsfelder) mittels Integer-Wert, wobei geprüft wird, ob der Integer Wert auch vorhanden ist. * Objektzeiger und Objektlisten mittels COO-Adresse ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UserFormsReferenz {

  private Optional<String> lhMBAI151700Ufreference = Optional.empty();

  @Valid
  private List<String> lhMBAI151700Ufvalue = new ArrayList<>();

  public UserFormsReferenz lhMBAI151700Ufreference(String lhMBAI151700Ufreference) {
    this.lhMBAI151700Ufreference = Optional.ofNullable(lhMBAI151700Ufreference);
    return this;
  }

  /**
   * Programmiername der Verfahrenseigenschaft
   * @return lhMBAI151700Ufreference
   */
  
  @Schema(name = "LHMBAI_15_1700_ufreference", description = "Programmiername der Verfahrenseigenschaft", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("LHMBAI_15_1700_ufreference")
  public Optional<String> getLhMBAI151700Ufreference() {
    return lhMBAI151700Ufreference;
  }

  @JsonProperty("LHMBAI_15_1700_ufreference")
  public void setLhMBAI151700Ufreference(Optional<String> lhMBAI151700Ufreference) {
    this.lhMBAI151700Ufreference = lhMBAI151700Ufreference;
  }

  public UserFormsReferenz lhMBAI151700Ufvalue(List<String> lhMBAI151700Ufvalue) {
    this.lhMBAI151700Ufvalue = lhMBAI151700Ufvalue;
    return this;
  }

  public UserFormsReferenz addLhMBAI151700UfvalueItem(String lhMBAI151700UfvalueItem) {
    if (this.lhMBAI151700Ufvalue == null) {
      this.lhMBAI151700Ufvalue = new ArrayList<>();
    }
    this.lhMBAI151700Ufvalue.add(lhMBAI151700UfvalueItem);
    return this;
  }

  /**
   * Wert(e) der Verfahrenseigenschaft
   * @return lhMBAI151700Ufvalue
   */
  
  @Schema(name = "LHMBAI_15_1700_ufvalue", description = "Wert(e) der Verfahrenseigenschaft", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("LHMBAI_15_1700_ufvalue")
  public List<String> getLhMBAI151700Ufvalue() {
    return lhMBAI151700Ufvalue;
  }

  @JsonProperty("LHMBAI_15_1700_ufvalue")
  public void setLhMBAI151700Ufvalue(List<String> lhMBAI151700Ufvalue) {
    this.lhMBAI151700Ufvalue = lhMBAI151700Ufvalue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserFormsReferenz userFormsReferenz = (UserFormsReferenz) o;
    return Objects.equals(this.lhMBAI151700Ufreference, userFormsReferenz.lhMBAI151700Ufreference) &&
        Objects.equals(this.lhMBAI151700Ufvalue, userFormsReferenz.lhMBAI151700Ufvalue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lhMBAI151700Ufreference, lhMBAI151700Ufvalue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserFormsReferenz {\n");
    sb.append("    lhMBAI151700Ufreference: ").append(toIndentedString(lhMBAI151700Ufreference)).append("\n");
    sb.append("    lhMBAI151700Ufvalue: ").append(toIndentedString(lhMBAI151700Ufvalue)).append("\n");
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

    private UserFormsReferenz instance;

    public Builder() {
      this(new UserFormsReferenz());
    }

    protected Builder(UserFormsReferenz instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UserFormsReferenz value) { 
      this.instance.setLhMBAI151700Ufreference(value.lhMBAI151700Ufreference);
      this.instance.setLhMBAI151700Ufvalue(value.lhMBAI151700Ufvalue);
      return this;
    }

    public UserFormsReferenz.Builder lhMBAI151700Ufreference(String lhMBAI151700Ufreference) {
      this.instance.lhMBAI151700Ufreference(lhMBAI151700Ufreference);
      return this;
    }
    
    public UserFormsReferenz.Builder lhMBAI151700Ufvalue(List<String> lhMBAI151700Ufvalue) {
      this.instance.lhMBAI151700Ufvalue(lhMBAI151700Ufvalue);
      return this;
    }
    
    /**
    * returns a built UserFormsReferenz instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UserFormsReferenz build() {
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
  public static UserFormsReferenz.Builder builder() {
    return new UserFormsReferenz.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UserFormsReferenz.Builder toBuilder() {
    UserFormsReferenz.Builder builder = new UserFormsReferenz.Builder();
    return builder.copyOf(this);
  }

}


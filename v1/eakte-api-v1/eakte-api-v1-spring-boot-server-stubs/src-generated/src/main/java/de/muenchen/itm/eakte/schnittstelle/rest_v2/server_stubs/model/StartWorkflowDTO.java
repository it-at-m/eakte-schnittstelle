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
 * StartWorkflowDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class StartWorkflowDTO {

  private String workflowpattern;

  public StartWorkflowDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public StartWorkflowDTO(String workflowpattern) {
    this.workflowpattern = workflowpattern;
  }

  public StartWorkflowDTO workflowpattern(String workflowpattern) {
    this.workflowpattern = workflowpattern;
    return this;
  }

  /**
   * COO-Adresse der Muster für Verfügung (COOWF@1.1:PrescriptionTemplate)<br> Die COO-Adresse findet man über die GUI der eAkte, wenn man im Schreibtisch \"Suche\" ausführt, nach Muster für Verfügungen sucht.  In den Eigenschaften (im Tab Erstellung) der entsprechenden Mustervorlage steht die COO-Adresse.  Anmerkung: <br> Der Titel ist nicht eindeutig, da es im System mehrere „Muster für Verfügung“ mit dem gleichen Namen geben kann. 
   * @return workflowpattern
   */
  @NotNull 
  @Schema(name = "workflowpattern", example = "COO.1.1001.1.6485", description = "COO-Adresse der Muster für Verfügung (COOWF@1.1:PrescriptionTemplate)<br> Die COO-Adresse findet man über die GUI der eAkte, wenn man im Schreibtisch \"Suche\" ausführt, nach Muster für Verfügungen sucht.  In den Eigenschaften (im Tab Erstellung) der entsprechenden Mustervorlage steht die COO-Adresse.  Anmerkung: <br> Der Titel ist nicht eindeutig, da es im System mehrere „Muster für Verfügung“ mit dem gleichen Namen geben kann. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workflowpattern")
  public String getWorkflowpattern() {
    return workflowpattern;
  }

  @JsonProperty("workflowpattern")
  public void setWorkflowpattern(String workflowpattern) {
    this.workflowpattern = workflowpattern;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartWorkflowDTO startWorkflowDTO = (StartWorkflowDTO) o;
    return Objects.equals(this.workflowpattern, startWorkflowDTO.workflowpattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workflowpattern);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartWorkflowDTO {\n");
    sb.append("    workflowpattern: ").append(toIndentedString(workflowpattern)).append("\n");
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

    private StartWorkflowDTO instance;

    public Builder() {
      this(new StartWorkflowDTO());
    }

    protected Builder(StartWorkflowDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(StartWorkflowDTO value) { 
      this.instance.setWorkflowpattern(value.workflowpattern);
      return this;
    }

    public StartWorkflowDTO.Builder workflowpattern(String workflowpattern) {
      this.instance.workflowpattern(workflowpattern);
      return this;
    }
    
    /**
    * returns a built StartWorkflowDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public StartWorkflowDTO build() {
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
  public static StartWorkflowDTO.Builder builder() {
    return new StartWorkflowDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public StartWorkflowDTO.Builder toBuilder() {
    StartWorkflowDTO.Builder builder = new StartWorkflowDTO.Builder();
    return builder.copyOf(this);
  }

}


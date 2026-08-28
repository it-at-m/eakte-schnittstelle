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
 * UpdateAccessDefinitionObjectAnfrageDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateAccessDefinitionObjectAnfrageDTO {

  private String objaccdef;

  private Optional<Integer> authinheritance = Optional.empty();

  public UpdateAccessDefinitionObjectAnfrageDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateAccessDefinitionObjectAnfrageDTO(String objaccdef) {
    this.objaccdef = objaccdef;
  }

  public UpdateAccessDefinitionObjectAnfrageDTO objaccdef(String objaccdef) {
    this.objaccdef = objaccdef;
    return this;
  }

  /**
   * Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). 
   * @return objaccdef
   */
  @NotNull 
  @Schema(name = "objaccdef", example = "Eigener Mandant", description = "Folgende Zugriffsdefinitionen sind möglich:  * \"Eigene Organisationseinheit und Linienorganisation\" * \"Eigener Mandant\" * \"Eigene Organisationseinheit und Vorgesetzte\" * \"Eigene Organisationseinheit und Vorgesetzte (ohne Zentralregistratur)\" * \"Eigene Organisationseinheit\" * \"Persönlich und Vorgesetzte\" * \"Persönlich\" (für Verschlusssachen) * \"Aktengebunden\" (nur für untergeordnete Vorgänge einer Akte)  Die Zugriffsdefinition wird jeweils auf die darunterliegenden Objekte vererbt,  d.h.  * wenn ein Wert für den Aktenplaneintrag eingetragen wird (empfohlen),  dann gilt dieser automatisch für alle darunter liegenden Akten,  * entsprechend für alle Vorgänge einer Akte,  wenn die Zugriffsdefinition bei der Akte eingetragen wurde und  * entsprechend bei allen Dokumenten eines Vorgangs,  wenn die Zugriffsdefinition bei dem Vorgang eingetragen wurde.  Wenn kein Wert übergeben wird,  wird die auf dem jeweils höheren Objekt hinterlegte Zugriffsdefinition initialisiert. Wurde auf dem Aktenplaneintrag keine Zugriffsdefinition festgelegt,  wird die im System eingestellte Definition verwendet - \"Eigener Mandant\".  Wenn Vorgänge die Zugriffsdefinition und zusätzlich berechtigte Organisationseinheiten  aus der übergeordneten Akte übernehmen sollen,  muss \"Aktengebunden\" für Vorgänge bei der Akte angegeben werden (procaccdef). ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("objaccdef")
  public String getObjaccdef() {
    return objaccdef;
  }

  @JsonProperty("objaccdef")
  public void setObjaccdef(String objaccdef) {
    this.objaccdef = objaccdef;
  }

  public UpdateAccessDefinitionObjectAnfrageDTO authinheritance(Integer authinheritance) {
    this.authinheritance = Optional.ofNullable(authinheritance);
    return this;
  }

  /**
   * Rechtevererbung\\ Mögliche Werte: null,0,1,2  0 oder leer (null): Die Rechtevererbung aus dem Standardprodukt wird verwendet.\\ Der neue Wert wird rekursiv gesetzt in Abhängigkeit von den jeweiligen aktuell gesetzten Werten der untergeordneten Objekte.  1: Änderung der Zugriffsdefinition auf dem Objekt und rekursive Vererbung  auf alle untergeordneten Objekte unabhängig von den jeweiligen aktuell gesetzten Werten der untergeordneten Objekte.  2: Änderung der Zugriffsdefinition nur auf dem Objekt  Hinweis:\\  Beim übergeben des Werts 1 auf einer Sachakte vererbt sich die Zugriffsdefinition auf alle in der Akte enthaltenen Vorgänge und wieder auf alle Dokumente,  die in den Vorgängen enthalten sind.\\ Bei einer großen Anzahl von untergeordneten Objekten kann es zu Abbrüchen  aufgrund Objektsperren oder durch Timeouts kommen. 
   * @return authinheritance
   */
  
  @Schema(name = "authinheritance", example = "1", description = "Rechtevererbung\\ Mögliche Werte: null,0,1,2  0 oder leer (null): Die Rechtevererbung aus dem Standardprodukt wird verwendet.\\ Der neue Wert wird rekursiv gesetzt in Abhängigkeit von den jeweiligen aktuell gesetzten Werten der untergeordneten Objekte.  1: Änderung der Zugriffsdefinition auf dem Objekt und rekursive Vererbung  auf alle untergeordneten Objekte unabhängig von den jeweiligen aktuell gesetzten Werten der untergeordneten Objekte.  2: Änderung der Zugriffsdefinition nur auf dem Objekt  Hinweis:\\  Beim übergeben des Werts 1 auf einer Sachakte vererbt sich die Zugriffsdefinition auf alle in der Akte enthaltenen Vorgänge und wieder auf alle Dokumente,  die in den Vorgängen enthalten sind.\\ Bei einer großen Anzahl von untergeordneten Objekten kann es zu Abbrüchen  aufgrund Objektsperren oder durch Timeouts kommen. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authinheritance")
  public Optional<Integer> getAuthinheritance() {
    return authinheritance;
  }

  @JsonProperty("authinheritance")
  public void setAuthinheritance(Optional<Integer> authinheritance) {
    this.authinheritance = authinheritance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAccessDefinitionObjectAnfrageDTO updateAccessDefinitionObjectAnfrageDTO = (UpdateAccessDefinitionObjectAnfrageDTO) o;
    return Objects.equals(this.objaccdef, updateAccessDefinitionObjectAnfrageDTO.objaccdef) &&
        Objects.equals(this.authinheritance, updateAccessDefinitionObjectAnfrageDTO.authinheritance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objaccdef, authinheritance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAccessDefinitionObjectAnfrageDTO {\n");
    sb.append("    objaccdef: ").append(toIndentedString(objaccdef)).append("\n");
    sb.append("    authinheritance: ").append(toIndentedString(authinheritance)).append("\n");
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

    private UpdateAccessDefinitionObjectAnfrageDTO instance;

    public Builder() {
      this(new UpdateAccessDefinitionObjectAnfrageDTO());
    }

    protected Builder(UpdateAccessDefinitionObjectAnfrageDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateAccessDefinitionObjectAnfrageDTO value) { 
      this.instance.setObjaccdef(value.objaccdef);
      this.instance.setAuthinheritance(value.authinheritance);
      return this;
    }

    public UpdateAccessDefinitionObjectAnfrageDTO.Builder objaccdef(String objaccdef) {
      this.instance.objaccdef(objaccdef);
      return this;
    }
    
    public UpdateAccessDefinitionObjectAnfrageDTO.Builder authinheritance(Integer authinheritance) {
      this.instance.authinheritance(authinheritance);
      return this;
    }
    
    /**
    * returns a built UpdateAccessDefinitionObjectAnfrageDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateAccessDefinitionObjectAnfrageDTO build() {
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
  public static UpdateAccessDefinitionObjectAnfrageDTO.Builder builder() {
    return new UpdateAccessDefinitionObjectAnfrageDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateAccessDefinitionObjectAnfrageDTO.Builder toBuilder() {
    UpdateAccessDefinitionObjectAnfrageDTO.Builder builder = new UpdateAccessDefinitionObjectAnfrageDTO.Builder();
    return builder.copyOf(this);
  }

}


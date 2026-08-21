package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

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
 * beschreibt die Metadaten einer Definition fuer Verfahren
 */

@Schema(name = "DefinitionFuerVerfahren", description = "beschreibt die Metadaten einer Definition fuer Verfahren")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class DefinitionFuerVerfahren {

  private Optional<String> eigeneUrl = Optional.empty();

  private String name;

  private Optional<Boolean> istEntwurf = Optional.empty();

  @Valid
  private List<String> attributURIs = new ArrayList<>();

  public DefinitionFuerVerfahren() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DefinitionFuerVerfahren(String name) {
    this.name = name;
  }

  public DefinitionFuerVerfahren eigeneUrl(String eigeneUrl) {
    this.eigeneUrl = Optional.ofNullable(eigeneUrl);
    return this;
  }

  /**
   * Eigene URI einer Ressource (Zeiger auf sich selbst) oder  URI einer referenzierten Ressource.\\ \\ URI = \"Uniform Resource Locator\" (siehe z.B. https://de.wikipedia.org/wiki/Uniform_Resource_Identifier)\\ \\ URIs sollen auf Seite des Service-Clients nicht interpretiert und auch nicht konstruiert werden. Sie werden so wie sie in einer vorhergehenden Service-Antwort enthalten waren unverändert  in einer neuen Service-Anfrage verwendet (als Request-URL oder in den Daten als Referenz-URI) 
   * @return eigeneUrl
   */
  
  @Schema(name = "eigeneUrl", example = "/v2/Ressourcen/ressourcenId", description = "Eigene URI einer Ressource (Zeiger auf sich selbst) oder  URI einer referenzierten Ressource.\\ \\ URI = \"Uniform Resource Locator\" (siehe z.B. https://de.wikipedia.org/wiki/Uniform_Resource_Identifier)\\ \\ URIs sollen auf Seite des Service-Clients nicht interpretiert und auch nicht konstruiert werden. Sie werden so wie sie in einer vorhergehenden Service-Antwort enthalten waren unverändert  in einer neuen Service-Anfrage verwendet (als Request-URL oder in den Daten als Referenz-URI) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eigeneUrl")
  public Optional<String> getEigeneUrl() {
    return eigeneUrl;
  }

  @JsonProperty("eigeneUrl")
  public void setEigeneUrl(Optional<String> eigeneUrl) {
    this.eigeneUrl = eigeneUrl;
  }

  public DefinitionFuerVerfahren name(String name) {
    this.name = name;
    return this;
  }

  /**
   * xxx 
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Akte", description = "xxx ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public DefinitionFuerVerfahren istEntwurf(Boolean istEntwurf) {
    this.istEntwurf = Optional.ofNullable(istEntwurf);
    return this;
  }

  /**
   * kennzeichnet, ob es sich um die Entwurtfsversion des Formulars handelt 
   * @return istEntwurf
   */
  
  @Schema(name = "istEntwurf", example = "false", description = "kennzeichnet, ob es sich um die Entwurtfsversion des Formulars handelt ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("istEntwurf")
  public Optional<Boolean> getIstEntwurf() {
    return istEntwurf;
  }

  @JsonProperty("istEntwurf")
  public void setIstEntwurf(Optional<Boolean> istEntwurf) {
    this.istEntwurf = istEntwurf;
  }

  public DefinitionFuerVerfahren attributURIs(List<String> attributURIs) {
    this.attributURIs = attributURIs;
    return this;
  }

  public DefinitionFuerVerfahren addAttributURIsItem(String attributURIsItem) {
    if (this.attributURIs == null) {
      this.attributURIs = new ArrayList<>();
    }
    this.attributURIs.add(attributURIsItem);
    return this;
  }

  /**
   * Get attributURIs
   * @return attributURIs
   */
  
  @Schema(name = "attributURIs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributURIs")
  public List<String> getAttributURIs() {
    return attributURIs;
  }

  @JsonProperty("attributURIs")
  public void setAttributURIs(List<String> attributURIs) {
    this.attributURIs = attributURIs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefinitionFuerVerfahren definitionFuerVerfahren = (DefinitionFuerVerfahren) o;
    return Objects.equals(this.eigeneUrl, definitionFuerVerfahren.eigeneUrl) &&
        Objects.equals(this.name, definitionFuerVerfahren.name) &&
        Objects.equals(this.istEntwurf, definitionFuerVerfahren.istEntwurf) &&
        Objects.equals(this.attributURIs, definitionFuerVerfahren.attributURIs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eigeneUrl, name, istEntwurf, attributURIs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefinitionFuerVerfahren {\n");
    sb.append("    eigeneUrl: ").append(toIndentedString(eigeneUrl)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    istEntwurf: ").append(toIndentedString(istEntwurf)).append("\n");
    sb.append("    attributURIs: ").append(toIndentedString(attributURIs)).append("\n");
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

    private DefinitionFuerVerfahren instance;

    public Builder() {
      this(new DefinitionFuerVerfahren());
    }

    protected Builder(DefinitionFuerVerfahren instance) {
      this.instance = instance;
    }

    protected Builder copyOf(DefinitionFuerVerfahren value) { 
      this.instance.setEigeneUrl(value.eigeneUrl);
      this.instance.setName(value.name);
      this.instance.setIstEntwurf(value.istEntwurf);
      this.instance.setAttributURIs(value.attributURIs);
      return this;
    }

    public DefinitionFuerVerfahren.Builder eigeneUrl(String eigeneUrl) {
      this.instance.eigeneUrl(eigeneUrl);
      return this;
    }
    
    public DefinitionFuerVerfahren.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public DefinitionFuerVerfahren.Builder istEntwurf(Boolean istEntwurf) {
      this.instance.istEntwurf(istEntwurf);
      return this;
    }
    
    public DefinitionFuerVerfahren.Builder attributURIs(List<String> attributURIs) {
      this.instance.attributURIs(attributURIs);
      return this;
    }
    
    /**
    * returns a built DefinitionFuerVerfahren instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public DefinitionFuerVerfahren build() {
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
  public static DefinitionFuerVerfahren.Builder builder() {
    return new DefinitionFuerVerfahren.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public DefinitionFuerVerfahren.Builder toBuilder() {
    DefinitionFuerVerfahren.Builder builder = new DefinitionFuerVerfahren.Builder();
    return builder.copyOf(this);
  }

}


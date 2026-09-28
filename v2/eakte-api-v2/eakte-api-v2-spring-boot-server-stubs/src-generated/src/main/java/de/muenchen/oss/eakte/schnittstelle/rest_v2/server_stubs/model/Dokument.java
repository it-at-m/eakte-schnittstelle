package de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ParentReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Dokument
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class Dokument {

  /**
   * Gets or Sets klasse
   */
  public enum KlasseEnum {
    EINGANG("Eingang"),
    
    ERLEDIGUNG("Erledigung"),
    
    INTERN("Intern");

    private final String value;

    KlasseEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KlasseEnum fromValue(String value) {
      for (KlasseEnum b : KlasseEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private KlasseEnum klasse;

  private String id;

  private ParentReference parent;

  private String name;

  private String langname;

  private Optional<String> betreff = Optional.empty();

  @Valid
  private List<String> schlagworte = new ArrayList<>();

  private String acl;

  private String organisationseinheit;

  @Valid
  private Map<String, Object> eigenschaftenMap = new HashMap<>();

  @Valid
  private List<@Valid EigenschaftEintrag> eigenschaftenListe = new ArrayList<>();

  public Dokument() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Dokument(KlasseEnum klasse, String id, ParentReference parent, String name, String langname, String acl, String organisationseinheit, Map<String, Object> eigenschaftenMap, List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.klasse = klasse;
    this.id = id;
    this.parent = parent;
    this.name = name;
    this.langname = langname;
    this.acl = acl;
    this.organisationseinheit = organisationseinheit;
    this.eigenschaftenMap = eigenschaftenMap;
    this.eigenschaftenListe = eigenschaftenListe;
  }

  public Dokument klasse(KlasseEnum klasse) {
    this.klasse = klasse;
    return this;
  }

  /**
   * Get klasse
   * @return klasse
   */
  @NotNull 
  @Schema(name = "klasse", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("klasse")
  public KlasseEnum getKlasse() {
    return klasse;
  }

  @JsonProperty("klasse")
  public void setKlasse(KlasseEnum klasse) {
    this.klasse = klasse;
  }

  public Dokument id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public Dokument parent(ParentReference parent) {
    this.parent = parent;
    return this;
  }

  /**
   * Get parent
   * @return parent
   */
  @NotNull @Valid 
  @Schema(name = "parent", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parent")
  public ParentReference getParent() {
    return parent;
  }

  @JsonProperty("parent")
  public void setParent(ParentReference parent) {
    this.parent = parent;
  }

  public Dokument name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public Dokument langname(String langname) {
    this.langname = langname;
    return this;
  }

  /**
   * Get langname
   * @return langname
   */
  @NotNull 
  @Schema(name = "langname", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("langname")
  public String getLangname() {
    return langname;
  }

  @JsonProperty("langname")
  public void setLangname(String langname) {
    this.langname = langname;
  }

  public Dokument betreff(String betreff) {
    this.betreff = Optional.ofNullable(betreff);
    return this;
  }

  /**
   * Get betreff
   * @return betreff
   */
  
  @Schema(name = "betreff", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("betreff")
  public Optional<String> getBetreff() {
    return betreff;
  }

  @JsonProperty("betreff")
  public void setBetreff(Optional<String> betreff) {
    this.betreff = betreff;
  }

  public Dokument schlagworte(List<String> schlagworte) {
    this.schlagworte = schlagworte;
    return this;
  }

  public Dokument addSchlagworteItem(String schlagworteItem) {
    if (this.schlagworte == null) {
      this.schlagworte = new ArrayList<>();
    }
    this.schlagworte.add(schlagworteItem);
    return this;
  }

  /**
   * Get schlagworte
   * @return schlagworte
   */
  
  @Schema(name = "schlagworte", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("schlagworte")
  public List<String> getSchlagworte() {
    return schlagworte;
  }

  @JsonProperty("schlagworte")
  public void setSchlagworte(List<String> schlagworte) {
    this.schlagworte = schlagworte;
  }

  public Dokument acl(String acl) {
    this.acl = acl;
    return this;
  }

  /**
   * Get acl
   * @return acl
   */
  @NotNull 
  @Schema(name = "acl", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("acl")
  public String getAcl() {
    return acl;
  }

  @JsonProperty("acl")
  public void setAcl(String acl) {
    this.acl = acl;
  }

  public Dokument organisationseinheit(String organisationseinheit) {
    this.organisationseinheit = organisationseinheit;
    return this;
  }

  /**
   * Get organisationseinheit
   * @return organisationseinheit
   */
  @NotNull 
  @Schema(name = "organisationseinheit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("organisationseinheit")
  public String getOrganisationseinheit() {
    return organisationseinheit;
  }

  @JsonProperty("organisationseinheit")
  public void setOrganisationseinheit(String organisationseinheit) {
    this.organisationseinheit = organisationseinheit;
  }

  public Dokument eigenschaftenMap(Map<String, Object> eigenschaftenMap) {
    this.eigenschaftenMap = eigenschaftenMap;
    return this;
  }

  public Dokument putEigenschaftenMapItem(String key, Object eigenschaftenMapItem) {
    if (this.eigenschaftenMap == null) {
      this.eigenschaftenMap = new HashMap<>();
    }
    this.eigenschaftenMap.put(key, eigenschaftenMapItem);
    return this;
  }

  /**
   * Get eigenschaftenMap
   * @return eigenschaftenMap
   */
  @NotNull 
  @Schema(name = "eigenschaftenMap", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaftenMap")
  public Map<String, Object> getEigenschaftenMap() {
    return eigenschaftenMap;
  }

  @JsonProperty("eigenschaftenMap")
  public void setEigenschaftenMap(Map<String, Object> eigenschaftenMap) {
    this.eigenschaftenMap = eigenschaftenMap;
  }

  public Dokument eigenschaftenListe(List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.eigenschaftenListe = eigenschaftenListe;
    return this;
  }

  public Dokument addEigenschaftenListeItem(EigenschaftEintrag eigenschaftenListeItem) {
    if (this.eigenschaftenListe == null) {
      this.eigenschaftenListe = new ArrayList<>();
    }
    this.eigenschaftenListe.add(eigenschaftenListeItem);
    return this;
  }

  /**
   * Get eigenschaftenListe
   * @return eigenschaftenListe
   */
  @NotNull @Valid 
  @Schema(name = "eigenschaftenListe", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("eigenschaftenListe")
  public List<@Valid EigenschaftEintrag> getEigenschaftenListe() {
    return eigenschaftenListe;
  }

  @JsonProperty("eigenschaftenListe")
  public void setEigenschaftenListe(List<@Valid EigenschaftEintrag> eigenschaftenListe) {
    this.eigenschaftenListe = eigenschaftenListe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dokument dokument = (Dokument) o;
    return Objects.equals(this.klasse, dokument.klasse) &&
        Objects.equals(this.id, dokument.id) &&
        Objects.equals(this.parent, dokument.parent) &&
        Objects.equals(this.name, dokument.name) &&
        Objects.equals(this.langname, dokument.langname) &&
        Objects.equals(this.betreff, dokument.betreff) &&
        Objects.equals(this.schlagworte, dokument.schlagworte) &&
        Objects.equals(this.acl, dokument.acl) &&
        Objects.equals(this.organisationseinheit, dokument.organisationseinheit) &&
        Objects.equals(this.eigenschaftenMap, dokument.eigenschaftenMap) &&
        Objects.equals(this.eigenschaftenListe, dokument.eigenschaftenListe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(klasse, id, parent, name, langname, betreff, schlagworte, acl, organisationseinheit, eigenschaftenMap, eigenschaftenListe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dokument {\n");
    sb.append("    klasse: ").append(toIndentedString(klasse)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    langname: ").append(toIndentedString(langname)).append("\n");
    sb.append("    betreff: ").append(toIndentedString(betreff)).append("\n");
    sb.append("    schlagworte: ").append(toIndentedString(schlagworte)).append("\n");
    sb.append("    acl: ").append(toIndentedString(acl)).append("\n");
    sb.append("    organisationseinheit: ").append(toIndentedString(organisationseinheit)).append("\n");
    sb.append("    eigenschaftenMap: ").append(toIndentedString(eigenschaftenMap)).append("\n");
    sb.append("    eigenschaftenListe: ").append(toIndentedString(eigenschaftenListe)).append("\n");
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

    private Dokument instance;

    public Builder() {
      this(new Dokument());
    }

    protected Builder(Dokument instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Dokument value) { 
      this.instance.setKlasse(value.klasse);
      this.instance.setId(value.id);
      this.instance.setParent(value.parent);
      this.instance.setName(value.name);
      this.instance.setLangname(value.langname);
      this.instance.setBetreff(value.betreff);
      this.instance.setSchlagworte(value.schlagworte);
      this.instance.setAcl(value.acl);
      this.instance.setOrganisationseinheit(value.organisationseinheit);
      this.instance.setEigenschaftenMap(value.eigenschaftenMap);
      this.instance.setEigenschaftenListe(value.eigenschaftenListe);
      return this;
    }

    public Dokument.Builder klasse(KlasseEnum klasse) {
      this.instance.klasse(klasse);
      return this;
    }
    
    public Dokument.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    public Dokument.Builder parent(ParentReference parent) {
      this.instance.parent(parent);
      return this;
    }
    
    public Dokument.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public Dokument.Builder langname(String langname) {
      this.instance.langname(langname);
      return this;
    }
    
    public Dokument.Builder betreff(String betreff) {
      this.instance.betreff(betreff);
      return this;
    }
    
    public Dokument.Builder schlagworte(List<String> schlagworte) {
      this.instance.schlagworte(schlagworte);
      return this;
    }
    
    public Dokument.Builder acl(String acl) {
      this.instance.acl(acl);
      return this;
    }
    
    public Dokument.Builder organisationseinheit(String organisationseinheit) {
      this.instance.organisationseinheit(organisationseinheit);
      return this;
    }
    
    public Dokument.Builder eigenschaftenMap(Map<String, Object> eigenschaftenMap) {
      this.instance.eigenschaftenMap(eigenschaftenMap);
      return this;
    }
    
    public Dokument.Builder eigenschaftenListe(List<EigenschaftEintrag> eigenschaftenListe) {
      this.instance.eigenschaftenListe(eigenschaftenListe);
      return this;
    }
    
    /**
    * returns a built Dokument instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Dokument build() {
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
  public static Dokument.Builder builder() {
    return new Dokument.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Dokument.Builder toBuilder() {
    Dokument.Builder builder = new Dokument.Builder();
    return builder.copyOf(this);
  }

}


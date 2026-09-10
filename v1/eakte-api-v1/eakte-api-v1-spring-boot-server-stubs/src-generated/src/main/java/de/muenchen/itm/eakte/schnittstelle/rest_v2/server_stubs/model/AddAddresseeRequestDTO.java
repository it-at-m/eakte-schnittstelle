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
 * AddAddresseeRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class AddAddresseeRequestDTO {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> addrdate = Optional.empty();

  private Optional<String> addrtransmedia = Optional.empty();

  private Optional<String> addrorgname = Optional.empty();

  private Optional<String> addrtitle = Optional.empty();

  private Optional<String> addrfirstname = Optional.empty();

  private Optional<String> addrname = Optional.empty();

  private Optional<String> addrstreet = Optional.empty();

  private Optional<String> addrstreetnumber = Optional.empty();

  private Optional<String> addrzipcode = Optional.empty();

  private Optional<String> addrcity = Optional.empty();

  private Optional<String> addrcountry = Optional.empty();

  private Optional<String> addremail = Optional.empty();

  private Optional<String> addradditional5 = Optional.empty();

  public AddAddresseeRequestDTO addrdate(OffsetDateTime addrdate) {
    this.addrdate = Optional.ofNullable(addrdate);
    return this;
  }

  /**
   * Briefdatum des Objektes
   * @return addrdate
   */
  @Valid 
  @Schema(name = "addrdate", description = "Briefdatum des Objektes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrdate")
  public Optional<OffsetDateTime> getAddrdate() {
    return addrdate;
  }

  @JsonProperty("addrdate")
  public void setAddrdate(Optional<OffsetDateTime> addrdate) {
    this.addrdate = addrdate;
  }

  public AddAddresseeRequestDTO addrtransmedia(String addrtransmedia) {
    this.addrtransmedia = Optional.ofNullable(addrtransmedia);
    return this;
  }

  /**
   * Versandart für den jeweiligen Adressaten<br> Folgende Werte sind möglich: * Papier * E-Fax * E-Mail * XML-Dokument * Intern Wenn kein Wert übertragen wird, soll Papier eingetragen werden. 
   * @return addrtransmedia
   */
  
  @Schema(name = "addrtransmedia", example = "Papier", description = "Versandart für den jeweiligen Adressaten<br> Folgende Werte sind möglich: * Papier * E-Fax * E-Mail * XML-Dokument * Intern Wenn kein Wert übertragen wird, soll Papier eingetragen werden. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrtransmedia")
  public Optional<String> getAddrtransmedia() {
    return addrtransmedia;
  }

  @JsonProperty("addrtransmedia")
  public void setAddrtransmedia(Optional<String> addrtransmedia) {
    this.addrtransmedia = addrtransmedia;
  }

  public AddAddresseeRequestDTO addrorgname(String addrorgname) {
    this.addrorgname = Optional.ofNullable(addrorgname);
    return this;
  }

  /**
   * Organisationsname
   * @return addrorgname
   */
  
  @Schema(name = "addrorgname", example = "Staatskanzlei Bayern", description = "Organisationsname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrorgname")
  public Optional<String> getAddrorgname() {
    return addrorgname;
  }

  @JsonProperty("addrorgname")
  public void setAddrorgname(Optional<String> addrorgname) {
    this.addrorgname = addrorgname;
  }

  public AddAddresseeRequestDTO addrtitle(String addrtitle) {
    this.addrtitle = Optional.ofNullable(addrtitle);
    return this;
  }

  /**
   * Titel
   * @return addrtitle
   */
  
  @Schema(name = "addrtitle", example = "Dr.", description = "Titel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrtitle")
  public Optional<String> getAddrtitle() {
    return addrtitle;
  }

  @JsonProperty("addrtitle")
  public void setAddrtitle(Optional<String> addrtitle) {
    this.addrtitle = addrtitle;
  }

  public AddAddresseeRequestDTO addrfirstname(String addrfirstname) {
    this.addrfirstname = Optional.ofNullable(addrfirstname);
    return this;
  }

  /**
   * Vorname
   * @return addrfirstname
   */
  
  @Schema(name = "addrfirstname", example = "Thomas", description = "Vorname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrfirstname")
  public Optional<String> getAddrfirstname() {
    return addrfirstname;
  }

  @JsonProperty("addrfirstname")
  public void setAddrfirstname(Optional<String> addrfirstname) {
    this.addrfirstname = addrfirstname;
  }

  public AddAddresseeRequestDTO addrname(String addrname) {
    this.addrname = Optional.ofNullable(addrname);
    return this;
  }

  /**
   * Nachname
   * @return addrname
   */
  
  @Schema(name = "addrname", example = "Mayer", description = "Nachname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrname")
  public Optional<String> getAddrname() {
    return addrname;
  }

  @JsonProperty("addrname")
  public void setAddrname(Optional<String> addrname) {
    this.addrname = addrname;
  }

  public AddAddresseeRequestDTO addrstreet(String addrstreet) {
    this.addrstreet = Optional.ofNullable(addrstreet);
    return this;
  }

  /**
   * Straße
   * @return addrstreet
   */
  
  @Schema(name = "addrstreet", example = "Maximilianstraße", description = "Straße", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrstreet")
  public Optional<String> getAddrstreet() {
    return addrstreet;
  }

  @JsonProperty("addrstreet")
  public void setAddrstreet(Optional<String> addrstreet) {
    this.addrstreet = addrstreet;
  }

  public AddAddresseeRequestDTO addrstreetnumber(String addrstreetnumber) {
    this.addrstreetnumber = Optional.ofNullable(addrstreetnumber);
    return this;
  }

  /**
   * Hausnummer
   * @return addrstreetnumber
   */
  
  @Schema(name = "addrstreetnumber", example = "3", description = "Hausnummer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrstreetnumber")
  public Optional<String> getAddrstreetnumber() {
    return addrstreetnumber;
  }

  @JsonProperty("addrstreetnumber")
  public void setAddrstreetnumber(Optional<String> addrstreetnumber) {
    this.addrstreetnumber = addrstreetnumber;
  }

  public AddAddresseeRequestDTO addrzipcode(String addrzipcode) {
    this.addrzipcode = Optional.ofNullable(addrzipcode);
    return this;
  }

  /**
   * Postleitzahl
   * @return addrzipcode
   */
  
  @Schema(name = "addrzipcode", example = "80200", description = "Postleitzahl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrzipcode")
  public Optional<String> getAddrzipcode() {
    return addrzipcode;
  }

  @JsonProperty("addrzipcode")
  public void setAddrzipcode(Optional<String> addrzipcode) {
    this.addrzipcode = addrzipcode;
  }

  public AddAddresseeRequestDTO addrcity(String addrcity) {
    this.addrcity = Optional.ofNullable(addrcity);
    return this;
  }

  /**
   * Ort
   * @return addrcity
   */
  
  @Schema(name = "addrcity", example = "München", description = "Ort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrcity")
  public Optional<String> getAddrcity() {
    return addrcity;
  }

  @JsonProperty("addrcity")
  public void setAddrcity(Optional<String> addrcity) {
    this.addrcity = addrcity;
  }

  public AddAddresseeRequestDTO addrcountry(String addrcountry) {
    this.addrcountry = Optional.ofNullable(addrcountry);
    return this;
  }

  /**
   * Land
   * @return addrcountry
   */
  
  @Schema(name = "addrcountry", example = "Deutschland", description = "Land", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addrcountry")
  public Optional<String> getAddrcountry() {
    return addrcountry;
  }

  @JsonProperty("addrcountry")
  public void setAddrcountry(Optional<String> addrcountry) {
    this.addrcountry = addrcountry;
  }

  public AddAddresseeRequestDTO addremail(String addremail) {
    this.addremail = Optional.ofNullable(addremail);
    return this;
  }

  /**
   * E-Mail-Adresse
   * @return addremail
   */
  
  @Schema(name = "addremail", example = "staatskanzlei@muenchen.de", description = "E-Mail-Adresse", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addremail")
  public Optional<String> getAddremail() {
    return addremail;
  }

  @JsonProperty("addremail")
  public void setAddremail(Optional<String> addremail) {
    this.addremail = addremail;
  }

  public AddAddresseeRequestDTO addradditional5(String addradditional5) {
    this.addradditional5 = Optional.ofNullable(addradditional5);
    return this;
  }

  /**
   * E-Fax
   * @return addradditional5
   */
  
  @Schema(name = "addradditional5", example = "00498524885", description = "E-Fax", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("addradditional5")
  public Optional<String> getAddradditional5() {
    return addradditional5;
  }

  @JsonProperty("addradditional5")
  public void setAddradditional5(Optional<String> addradditional5) {
    this.addradditional5 = addradditional5;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddAddresseeRequestDTO addAddresseeRequestDTO = (AddAddresseeRequestDTO) o;
    return Objects.equals(this.addrdate, addAddresseeRequestDTO.addrdate) &&
        Objects.equals(this.addrtransmedia, addAddresseeRequestDTO.addrtransmedia) &&
        Objects.equals(this.addrorgname, addAddresseeRequestDTO.addrorgname) &&
        Objects.equals(this.addrtitle, addAddresseeRequestDTO.addrtitle) &&
        Objects.equals(this.addrfirstname, addAddresseeRequestDTO.addrfirstname) &&
        Objects.equals(this.addrname, addAddresseeRequestDTO.addrname) &&
        Objects.equals(this.addrstreet, addAddresseeRequestDTO.addrstreet) &&
        Objects.equals(this.addrstreetnumber, addAddresseeRequestDTO.addrstreetnumber) &&
        Objects.equals(this.addrzipcode, addAddresseeRequestDTO.addrzipcode) &&
        Objects.equals(this.addrcity, addAddresseeRequestDTO.addrcity) &&
        Objects.equals(this.addrcountry, addAddresseeRequestDTO.addrcountry) &&
        Objects.equals(this.addremail, addAddresseeRequestDTO.addremail) &&
        Objects.equals(this.addradditional5, addAddresseeRequestDTO.addradditional5);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addrdate, addrtransmedia, addrorgname, addrtitle, addrfirstname, addrname, addrstreet, addrstreetnumber, addrzipcode, addrcity, addrcountry, addremail, addradditional5);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAddresseeRequestDTO {\n");
    sb.append("    addrdate: ").append(toIndentedString(addrdate)).append("\n");
    sb.append("    addrtransmedia: ").append(toIndentedString(addrtransmedia)).append("\n");
    sb.append("    addrorgname: ").append(toIndentedString(addrorgname)).append("\n");
    sb.append("    addrtitle: ").append(toIndentedString(addrtitle)).append("\n");
    sb.append("    addrfirstname: ").append(toIndentedString(addrfirstname)).append("\n");
    sb.append("    addrname: ").append(toIndentedString(addrname)).append("\n");
    sb.append("    addrstreet: ").append(toIndentedString(addrstreet)).append("\n");
    sb.append("    addrstreetnumber: ").append(toIndentedString(addrstreetnumber)).append("\n");
    sb.append("    addrzipcode: ").append(toIndentedString(addrzipcode)).append("\n");
    sb.append("    addrcity: ").append(toIndentedString(addrcity)).append("\n");
    sb.append("    addrcountry: ").append(toIndentedString(addrcountry)).append("\n");
    sb.append("    addremail: ").append(toIndentedString(addremail)).append("\n");
    sb.append("    addradditional5: ").append(toIndentedString(addradditional5)).append("\n");
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

    private AddAddresseeRequestDTO instance;

    public Builder() {
      this(new AddAddresseeRequestDTO());
    }

    protected Builder(AddAddresseeRequestDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(AddAddresseeRequestDTO value) { 
      this.instance.setAddrdate(value.addrdate);
      this.instance.setAddrtransmedia(value.addrtransmedia);
      this.instance.setAddrorgname(value.addrorgname);
      this.instance.setAddrtitle(value.addrtitle);
      this.instance.setAddrfirstname(value.addrfirstname);
      this.instance.setAddrname(value.addrname);
      this.instance.setAddrstreet(value.addrstreet);
      this.instance.setAddrstreetnumber(value.addrstreetnumber);
      this.instance.setAddrzipcode(value.addrzipcode);
      this.instance.setAddrcity(value.addrcity);
      this.instance.setAddrcountry(value.addrcountry);
      this.instance.setAddremail(value.addremail);
      this.instance.setAddradditional5(value.addradditional5);
      return this;
    }

    public AddAddresseeRequestDTO.Builder addrdate(OffsetDateTime addrdate) {
      this.instance.addrdate(addrdate);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrtransmedia(String addrtransmedia) {
      this.instance.addrtransmedia(addrtransmedia);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrorgname(String addrorgname) {
      this.instance.addrorgname(addrorgname);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrtitle(String addrtitle) {
      this.instance.addrtitle(addrtitle);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrfirstname(String addrfirstname) {
      this.instance.addrfirstname(addrfirstname);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrname(String addrname) {
      this.instance.addrname(addrname);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrstreet(String addrstreet) {
      this.instance.addrstreet(addrstreet);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrstreetnumber(String addrstreetnumber) {
      this.instance.addrstreetnumber(addrstreetnumber);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrzipcode(String addrzipcode) {
      this.instance.addrzipcode(addrzipcode);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrcity(String addrcity) {
      this.instance.addrcity(addrcity);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addrcountry(String addrcountry) {
      this.instance.addrcountry(addrcountry);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addremail(String addremail) {
      this.instance.addremail(addremail);
      return this;
    }
    
    public AddAddresseeRequestDTO.Builder addradditional5(String addradditional5) {
      this.instance.addradditional5(addradditional5);
      return this;
    }
    
    /**
    * returns a built AddAddresseeRequestDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public AddAddresseeRequestDTO build() {
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
  public static AddAddresseeRequestDTO.Builder builder() {
    return new AddAddresseeRequestDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public AddAddresseeRequestDTO.Builder toBuilder() {
    AddAddresseeRequestDTO.Builder builder = new AddAddresseeRequestDTO.Builder();
    return builder.copyOf(this);
  }

}


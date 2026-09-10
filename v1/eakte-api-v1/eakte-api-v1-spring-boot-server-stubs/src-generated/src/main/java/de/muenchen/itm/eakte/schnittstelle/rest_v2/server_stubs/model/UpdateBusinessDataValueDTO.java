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
 * UpdateBusinessDataValueDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public class UpdateBusinessDataValueDTO {

  private String reference;

  private Optional<String> value = Optional.empty();

  public UpdateBusinessDataValueDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateBusinessDataValueDTO(String reference) {
    this.reference = reference;
  }

  public UpdateBusinessDataValueDTO reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Referenz des Fachdatums<br> Hier kann die einfache Referenz des Komponentenobjektes angeführt werden (\"FD_Position\" anstelle \"COOSYSTEM@1.1:FD_Position\".<br> Die Komponentenobjekte können sowohl von Fabasoft in der CFGMUENCHEN-Komponente  sowie von Domänenadministratoren in einer lokalen Softwarekomponenten erzeugt werden.  Wenn das Fachdaten-Komponentenobjekt gefunden wird,  wird diese unabhängig von der darüberliegenden Konfiguration gesetzt  d.h. eine zusätzliche Prüfung, ob diese in den darüberliegenden Aktenplaneinträgen vorgesehen ist,  kann nicht erfolgen. Dafür gibt es die neue Funktion /userFormsData, mit der Verfahrensdaten abgespeichert werden.<br> Für vorhandene Schnittstellen werden ab MUCS26 Fachdaten automatisch in den Verfahrensdaten abgespeichert. 
   * @return reference
   */
  @NotNull 
  @Schema(name = "reference", example = "data_dognumber", description = "Referenz des Fachdatums<br> Hier kann die einfache Referenz des Komponentenobjektes angeführt werden (\"FD_Position\" anstelle \"COOSYSTEM@1.1:FD_Position\".<br> Die Komponentenobjekte können sowohl von Fabasoft in der CFGMUENCHEN-Komponente  sowie von Domänenadministratoren in einer lokalen Softwarekomponenten erzeugt werden.  Wenn das Fachdaten-Komponentenobjekt gefunden wird,  wird diese unabhängig von der darüberliegenden Konfiguration gesetzt  d.h. eine zusätzliche Prüfung, ob diese in den darüberliegenden Aktenplaneinträgen vorgesehen ist,  kann nicht erfolgen. Dafür gibt es die neue Funktion /userFormsData, mit der Verfahrensdaten abgespeichert werden.<br> Für vorhandene Schnittstellen werden ab MUCS26 Fachdaten automatisch in den Verfahrensdaten abgespeichert. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }

  @JsonProperty("reference")
  public void setReference(String reference) {
    this.reference = reference;
  }

  public UpdateBusinessDataValueDTO value(String value) {
    this.value = Optional.ofNullable(value);
    return this;
  }

  /**
   * Wert des Fachdatums  Der Wert kann nur gesetzt werden,  wenn auch das Fachdatum-Komponenten-Objekt (mit dem Referenznamen) gefunden wurde.<br> Folgende Fachdaten-Typen können übergeben werden –  je nach Datentyp, müssen die Werte im vorab definierten Format übergeben werden: * Zeichenkettentyp: String wird übergeben und direkt bei der Akte eingetragen * Liste von Zeichenketten: String wird übergeben und bei der Akte eingetragen (es kann lediglich eine Zeile/String übergeben werden) * Objekt: Die eindeutige COO-Adresse muss angegeben werden. * Objektliste: Liste von COO-Adressen kann übergeben werden * Boolescher Typ: Die möglichen Angaben in der Datenquelle sind „Ja“, oder „Nein“.  Wenn nichts übergeben wird, wird automatsich \"Nein\" gesetzt * Typ für Datum und Zeit: Das Datumsformat ist in folgendem Format zu übergeben: \"DD.MM.YYYY\" * Währungstyp: Die Zahlenwert kann übergeben werden z.B. „53,89“ – der Wert wird automatisch immer in EUR eingetragen * Zahlentyp: Es dürfen nur ganze Zahlen übergeben werden z.B.“5“ * Aufzählungstyp: Hier muss der entsprechende Zahlenwert übergeben werden.  Wenn ein Zahlenwert übergeben wird, der nicht in den Aufzählungseigenschaft enthalten ist,  wird folgende Fehlermeldung zurückgegeben: „Übergebenes Element ist im Aufzählungstyp nicht vorhanden.“ * Gleitkommazahlentyp: Es können auch Gleitkommazahlen übergeben werden  z.B. „14,51“ (standardmäßig erlaubt die Fabasoft eGov-Suite nicht mehr als zwei Kommastellen) 
   * @return value
   */
  
  @Schema(name = "value", example = "458965", description = "Wert des Fachdatums  Der Wert kann nur gesetzt werden,  wenn auch das Fachdatum-Komponenten-Objekt (mit dem Referenznamen) gefunden wurde.<br> Folgende Fachdaten-Typen können übergeben werden –  je nach Datentyp, müssen die Werte im vorab definierten Format übergeben werden: * Zeichenkettentyp: String wird übergeben und direkt bei der Akte eingetragen * Liste von Zeichenketten: String wird übergeben und bei der Akte eingetragen (es kann lediglich eine Zeile/String übergeben werden) * Objekt: Die eindeutige COO-Adresse muss angegeben werden. * Objektliste: Liste von COO-Adressen kann übergeben werden * Boolescher Typ: Die möglichen Angaben in der Datenquelle sind „Ja“, oder „Nein“.  Wenn nichts übergeben wird, wird automatsich \"Nein\" gesetzt * Typ für Datum und Zeit: Das Datumsformat ist in folgendem Format zu übergeben: \"DD.MM.YYYY\" * Währungstyp: Die Zahlenwert kann übergeben werden z.B. „53,89“ – der Wert wird automatisch immer in EUR eingetragen * Zahlentyp: Es dürfen nur ganze Zahlen übergeben werden z.B.“5“ * Aufzählungstyp: Hier muss der entsprechende Zahlenwert übergeben werden.  Wenn ein Zahlenwert übergeben wird, der nicht in den Aufzählungseigenschaft enthalten ist,  wird folgende Fehlermeldung zurückgegeben: „Übergebenes Element ist im Aufzählungstyp nicht vorhanden.“ * Gleitkommazahlentyp: Es können auch Gleitkommazahlen übergeben werden  z.B. „14,51“ (standardmäßig erlaubt die Fabasoft eGov-Suite nicht mehr als zwei Kommastellen) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Optional<String> value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBusinessDataValueDTO updateBusinessDataValueDTO = (UpdateBusinessDataValueDTO) o;
    return Objects.equals(this.reference, updateBusinessDataValueDTO.reference) &&
        Objects.equals(this.value, updateBusinessDataValueDTO.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBusinessDataValueDTO {\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

    private UpdateBusinessDataValueDTO instance;

    public Builder() {
      this(new UpdateBusinessDataValueDTO());
    }

    protected Builder(UpdateBusinessDataValueDTO instance) {
      this.instance = instance;
    }

    protected Builder copyOf(UpdateBusinessDataValueDTO value) { 
      this.instance.setReference(value.reference);
      this.instance.setValue(value.value);
      return this;
    }

    public UpdateBusinessDataValueDTO.Builder reference(String reference) {
      this.instance.reference(reference);
      return this;
    }
    
    public UpdateBusinessDataValueDTO.Builder value(String value) {
      this.instance.value(value);
      return this;
    }
    
    /**
    * returns a built UpdateBusinessDataValueDTO instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public UpdateBusinessDataValueDTO build() {
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
  public static UpdateBusinessDataValueDTO.Builder builder() {
    return new UpdateBusinessDataValueDTO.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public UpdateBusinessDataValueDTO.Builder toBuilder() {
    UpdateBusinessDataValueDTO.Builder builder = new UpdateBusinessDataValueDTO.Builder();
    return builder.copyOf(this);
  }

}


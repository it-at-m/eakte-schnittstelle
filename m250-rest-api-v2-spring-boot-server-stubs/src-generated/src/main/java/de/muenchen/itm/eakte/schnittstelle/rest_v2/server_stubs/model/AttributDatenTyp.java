package de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AttributDatenTyp
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.21.0")
public enum AttributDatenTyp {
  
  ZEICHENKETTE("Zeichenkette"),
  
  GANZZAHL("Ganzzahl"),
  
  FLIESSKOMMAZAHL("Fliesskommazahl"),
  
  BOOLESCHER_WERT("BoolescherWert"),
  
  DATUM("Datum"),
  
  DATUM_MIT_UHRZEIT("DatumMitUhrzeit"),
  
  AUFZAEHLUNGSTYP("Aufzaehlungstyp"),
  
  BASE64_ENCODED_CONTENT("Base64EncodedContent"),
  
  AGGREGATSTYP("Aggregatstyp"),
  
  UNSPEZIFISCHE_RESSOURCEN_URI("UnspezifischeRessourcenURI"),
  
  AKTENPLANEINTRAGS_URI("AktenplaneintragsURI"),
  
  AKTEN_URI("AktenURI"),
  
  VORGANGS_URI("VorgangsURI"),
  
  SCHRIFTSTUECK_URI("SchriftstueckURI"),
  
  ORGANISATIONSEINHEITS_URI("OrganisationseinheitsURI"),
  
  BENUTZER_URI("BenutzerURI"),
  
  SPRACHEN_URI("SprachenURI"),
  
  ZUGRIFFSDEFINITIONS_URI("ZugriffsdefinitionsURI");

  private final String value;

  AttributDatenTyp(String value) {
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
  public static AttributDatenTyp fromValue(String value) {
    for (AttributDatenTyp b : AttributDatenTyp.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


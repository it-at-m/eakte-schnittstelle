package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client;

import com.fabasoft.schemas.bai.search.AGGREGATEType;
import com.fabasoft.schemas.bai.search.BOOLEANType;
import com.fabasoft.schemas.bai.search.CONTENTType;
import com.fabasoft.schemas.bai.search.DATETIMEType;
import com.fabasoft.schemas.bai.search.DATEType;
import com.fabasoft.schemas.bai.search.ENUMType;
import com.fabasoft.schemas.bai.search.FLOATType;
import com.fabasoft.schemas.bai.search.INTEGERType;
import com.fabasoft.schemas.bai.search.OBJECTPointerType;
import com.fabasoft.schemas.bai.search.ObjectType;
import com.fabasoft.schemas.bai.search.STRINGType;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAggregatstyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAktenURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAktenplaneintragsURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAufzaehlungstyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBase64EncodedContent;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBenutzerURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBoolescherWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatenTyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatum;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatumMitUhrzeit;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributFliesskommazahl;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributGanzzahl;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributOrganisationseinheitsURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributSchriftstueckURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributSprachenURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUnspezifischeRessourcenURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributVorgangsURI;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributZeichenkette;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributZugriffsdefinitionsURI;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Slf4j
@Getter
public class AttributeCollector {

  private final ArrayList<AttributUriUndWert> attributes = new ArrayList<>();

  private static String createAttributURI(String id) {
    return "/Attributbeschreibungen/" + id;
  }

  private static String createBenutzerURI(String id) {
    return "/Benutzer/" + id;
  }

  private static String createOrganisationseinheitsURI(String id) {
    return "/Organisationseinheiten/" + id;
  }

  private static String createZugriffsdefinitionsURI(String id) {
    return "/Zugriffsdefinitionen/" + id;
  }

  private static String createSprachenURI(String id) {
    return "/Sprachen/" + id;
  }

  private void logOneAttribute(AttributUriUndWert attributUriUndWert) {
    log.trace("  - uri: " + attributUriUndWert.getAttributURI());
    log.trace("    typ: " + attributUriUndWert.getDatenTyp());

    // nicht sehr schön und vielleicht geht es auch anders - OpenAPI Generator generiert keine Sealed interfaces,
    // aber it der parallel gepflegten enum haben wir check auf exhaustiveness
    // Alternative: Mustache-Templates von Spring Generator erweitern
    AttributDatenTyp attributDatenTyp = AttributDatenTyp.fromValue(attributUriUndWert.getDatenTyp());
    switch (attributDatenTyp) {
      case AttributDatenTyp.AGGREGATSTYP:
        log.trace("    wert: ");
        ((AttributAggregatstyp) attributUriUndWert).getAttributWert().forEach(this::logOneAttribute);
        break;
      case AttributDatenTyp.AKTENPLANEINTRAGS_URI:
        log.trace("    wert: " + ((AttributAktenplaneintragsURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.AKTEN_URI:
        log.trace("    wert: " + ((AttributAktenURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.AUFZAEHLUNGSTYP:
        log.trace("    wert: " + ((AttributAufzaehlungstyp) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.BASE64_ENCODED_CONTENT:
        log.trace("    wert: " + ((AttributBase64EncodedContent) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.BENUTZER_URI:
        log.trace("    wert: " + ((AttributBenutzerURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.BOOLESCHER_WERT:
        log.trace("    wert: " + ((AttributBoolescherWert) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.DATUM:
        log.trace("    wert: " + ((AttributDatum) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.DATUM_MIT_UHRZEIT:
        log.trace("    wert: " + ((AttributDatumMitUhrzeit) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.FLIESSKOMMAZAHL:
        log.trace("    wert: " + ((AttributFliesskommazahl) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.GANZZAHL:
        log.trace("    wert: " + ((AttributGanzzahl) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.ORGANISATIONSEINHEITS_URI:
        log.trace("    wert: " + ((AttributOrganisationseinheitsURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.SCHRIFTSTUECK_URI:
        log.trace("    wert: " + ((AttributSchriftstueckURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.SPRACHEN_URI:
        log.trace("    wert: " + ((AttributSprachenURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.UNSPEZIFISCHE_RESSOURCEN_URI:
        log.trace("    wert: " + ((AttributUnspezifischeRessourcenURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.VORGANGS_URI:
        log.trace("    wert: " + ((AttributVorgangsURI) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.ZEICHENKETTE:
        log.trace("    wert: " + ((AttributZeichenkette) attributUriUndWert).getAttributWert());
        break;
      case AttributDatenTyp.ZUGRIFFSDEFINITIONS_URI:
        log.trace("    wert: " + ((AttributZugriffsdefinitionsURI) attributUriUndWert).getAttributWert());
        break;
    }
  }

  public AttributeCollector logAllAttributes() {
    log.trace("logAllAttributes:");
    attributes.forEach(this::logOneAttribute);
    return this;
  }

  private AttributeCollector addAttribute(AttributUriUndWert attributUriUndWert) {
    ///log.trace("addAttribute");
    //logOneAttribute(attributUriUndWert);
    attributes.add(attributUriUndWert);
    return this;
  }

  public AttributeCollector processObjectType(ObjectType element) {
    processBOOLEANList(element.getAttrlist().getBOOLEAN());
    processOBJECTPointerList(element.getAttrlist().getOBJECT());
    processAGGREGATEList(element.getAttrlist().getAGGREGATE());
    processDATEList(element.getAttrlist().getDATE());
    processDATETIMEList(element.getAttrlist().getDATETIME());
    processENUMList(element.getAttrlist().getENUM());
    processFLOATList(element.getAttrlist().getFLOAT());
    processINTEGERList(element.getAttrlist().getINTEGER());
    processSTRINGList(element.getAttrlist().getSTRING());
    processCONTENTList(element.getAttrlist().getCONTENT());
    return this;
  }

  public AttributeCollector processAGGREGATEList(List<AGGREGATEType> list) {
    for (AGGREGATEType element : list) {
      // wir brauchen einen neuen Kollektor für die im Aggregat liegenden Attribute,
      // dort könnten evtl. die gleichen Attribute vorkommen wie auf der aktuellen Ebene:
      AttributeCollector aggregatsAttributKollektor = new AttributeCollector();
      aggregatsAttributKollektor.processAGGREGATE(element);
      this.addAttribute(
        new AttributAggregatstyp()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.AGGREGATSTYP.getValue())
          .attributWert(aggregatsAttributKollektor.attributes)
      );
    }
    return this;
  }

  public AttributeCollector processAGGREGATE(AGGREGATEType element) {
    processBOOLEANList(element.getBOOLEAN());
    processOBJECTPointerList(element.getOBJECT());
    processAGGREGATEList(element.getAGGREGATE());
    processDATEList(element.getDATE());
    processDATETIMEList(element.getDATETIME());
    processENUMList(element.getENUM());
    processFLOATList(element.getFLOAT());
    processINTEGERList(element.getINTEGER());
    processSTRINGList(element.getSTRING());
    processCONTENTList(element.getCONTENT());
    return this;
  }

  public AttributeCollector processOBJECTPointerList(List<OBJECTPointerType> list) {
    for (OBJECTPointerType element : list) {
      // ToDo: Wie könnnen wir an dieser Stelle entscheiden, wohin der Pointer verweist,
      // d.h. auf welchen Datentyp verwiesen wird?
      // das ist kontextabhängig, kann aber wahrscheinlich
      // aus der Attribut-Reference abgeleitet werden (oder dem Schriftguttyp, der abgerufen wird)
      // Dadurch kann über den Datentyp der Hinweis gegeben werden, was hinter einem Link steht,
      // z.B. auf welche Bearbeitungsmaske gepsrungen wird, oder wie der Titel einer Spalte oder
      // das Label eines Feldes sein müssen.

      // Anstatt explizit mit String-Literal zu prüfen, besser lookup des Typs in Attributbeschreibungen!
      AttributUriUndWert neuesAttribut = switch (element.getReference()) {
        case "COOELAK@1.1001:fileouobj" -> new AttributOrganisationseinheitsURI()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.ORGANISATIONSEINHEITS_URI.getValue())
          .attributWert(createOrganisationseinheitsURI(element.getValue()));
        case "COOSYSTEM@1.1:objowner" -> new AttributBenutzerURI()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.BENUTZER_URI.getValue())
          .attributWert(createBenutzerURI(element.getValue()));
        case "FSCFOLIO@1.1001:objaccdef" -> new AttributZugriffsdefinitionsURI()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.ZUGRIFFSDEFINITIONS_URI.getValue())  // wir haben noch keine Ressource für Zugriffsdefinitionen definiert!
          .attributWert(createZugriffsdefinitionsURI(element.getValue()));
        case "COOSYSTEM@1.1:language" -> new AttributSprachenURI()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.SPRACHEN_URI.getValue())  // wir haben noch keine Ressource für Language definiert!
          .attributWert(createSprachenURI(element.getValue()));
        default -> new AttributUnspezifischeRessourcenURI()
          .attributURI(createAttributURI(element.getReference()))
          .datenTyp(AttributDatenTyp.UNSPEZIFISCHE_RESSOURCEN_URI.getValue())
          .attributWert(element.getValue());
      };
      addAttribute(neuesAttribut);
    }
    return this;
  }

  public AttributeCollector processENUMList(List<ENUMType> list) {
    for (ENUMType element : list) {
      String formattedValue = element.getValue().toString();   // das ist seitens eGov-Suite der Index, bei uns die URI des Aufzaehlungstyp-Elements!
      addAttribute(new AttributAufzaehlungstyp()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.AUFZAEHLUNGSTYP.getValue())
        .attributWert(formattedValue));  // enums seem to be BigIntegers
    }
    return this;
  }

  public AttributeCollector processFLOATList(List<FLOATType> list) {
    for (FLOATType element : list) {
      BigDecimal value = new BigDecimal(Float.toString(element.getValue()));
      addAttribute(new AttributFliesskommazahl()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.FLIESSKOMMAZAHL.getValue())
        .attributWert(value));
    }
    return this;
  }

  public AttributeCollector processINTEGERList(List<INTEGERType> list) {
    for (INTEGERType element : list) {
      int value = element.getValue().intValue();
      addAttribute(new AttributGanzzahl()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.GANZZAHL.getValue())
        .attributWert(value));
    }
    return this;
  }

  public AttributeCollector processBOOLEANList(List<BOOLEANType> list) {
    for (BOOLEANType element : list) {
      addAttribute(new AttributBoolescherWert()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.BOOLESCHER_WERT.getValue())
        .attributWert(element.isValue()));
    }
    return this;
  }

  public AttributeCollector processSTRINGList(List<STRINGType> list) {
    for (STRINGType element : list) {
      addAttribute(new AttributZeichenkette()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.ZEICHENKETTE.getValue())
        .attributWert(element.getValue()));
    }
    return this;
  }

  public AttributeCollector processCONTENTList(List<CONTENTType> list) {
    for (CONTENTType element : list) {
      String formattedValue = Base64.getEncoder().encodeToString(element.getValue());
      addAttribute(new AttributBase64EncodedContent()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.BASE64_ENCODED_CONTENT.getValue())
        .attributWert(formattedValue));
    }
    return this;
  }

  public AttributeCollector processDATEList(List<DATEType> list) {
    for (DATEType element : list) {
      LocalDate localDate = element.getValue().toGregorianCalendar()
        .toZonedDateTime()
        .toLocalDate();
      addAttribute(new AttributDatum()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.DATUM.getValue())
        .attributWert(localDate));
    }
    return this;
  }

  public AttributeCollector processDATETIMEList(List<DATETIMEType> list) {
    for (DATETIMEType element : list) {
      OffsetDateTime offsetDateTime = element.getValue().toGregorianCalendar()
        .toZonedDateTime()
        .toOffsetDateTime();
      addAttribute(new AttributDatumMitUhrzeit()
        .attributURI(createAttributURI(element.getReference()))
        .datenTyp(AttributDatenTyp.DATUM_MIT_UHRZEIT.getValue())
        .attributWert(offsetDateTime));
    }
    return this;
  }
}
 

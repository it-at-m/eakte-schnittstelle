package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl;

import com.fabasoft.schemas.bai.search.ObjectType;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.AttributeCollector;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBoolescherWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatenTyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributGanzzahl;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributZeichenkette;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class FSObjectType2Attributbeschreibung
  implements ResultsetMapper<Attributbeschreibung> {

  private static Optional<AttributUriUndWert> findAttribute(AttributeCollector attributeCollector, String attributUrl) {
    return attributeCollector.getAttributes().stream()
      .filter(x -> attributUrl.equals(x.getAttributURI()))
      .findFirst();
  }

  @Override
  public Attributbeschreibung createDomainObjectFromFabasoftObjectType(ObjectType fabasoftResultset) {
    AttributeCollector attributeCollector = new AttributeCollector().processObjectType(fabasoftResultset);
    attributeCollector.logAllAttributes();
    // bei den Metadaten der Attribute haben wir feste Felder (sonst bräuchten wir wieder metadaten für die Metadaten-Attribute!)
    // also holen wir aus den ebenfalls dynamisch vorliegenden Attributen der Attribute die paar Werte raus, die wir wollen
    Attributbeschreibung attributbeschreibung = new Attributbeschreibung();

    // Bezeichnung:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:objname";
      Optional<AttributUriUndWert> bezeichnung = findAttribute(attributeCollector, fabasoftAttrPath);
      if (bezeichnung.isPresent()) {
        String fabasoftWert = ((AttributZeichenkette) bezeichnung.get()).getAttributWert();
        attributbeschreibung.setBezeichnung(fabasoftWert);
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // Datentyp:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:objname";
      Optional<AttributUriUndWert> datentyp = findAttribute(attributeCollector, fabasoftAttrPath);
      if (datentyp.isPresent()) {
        String fabasoftWert = ((AttributZeichenkette) datentyp.get()).getAttributWert();
        switch (fabasoftWert) {
          case "Ganze Zahl":
            attributbeschreibung.setDatentyp(AttributDatenTyp.GANZZAHL);
            break;
          case "Zeichenkette":
            attributbeschreibung.setDatentyp(AttributDatenTyp.ZEICHENKETTE);
            break;
          default:
            log.error("unrecognized Fabasoft datatype: {}", fabasoftWert);
            break;
        }
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // Attributlänge:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:attrlength";
      Optional<AttributUriUndWert> attrLength = findAttribute(attributeCollector, fabasoftAttrPath);
      if (attrLength.isPresent()) {
        int wert = ((AttributGanzzahl) attrLength.get()).getAttributWert();
        attributbeschreibung.setMaximaleTextLaenge(wert);
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // Pflichtfeld:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:attrmustbedef";
      Optional<AttributUriUndWert> mandatory = findAttribute(attributeCollector, fabasoftAttrPath);
      if (mandatory.isPresent()) {
        boolean wert = ((AttributBoolescherWert) mandatory.get()).getAttributWert();
        attributbeschreibung.setPflichtFeld(wert);
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // Fabasoft Attribut-Referenz:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:reference";
      Optional<AttributUriUndWert> attrReference = findAttribute(attributeCollector, fabasoftAttrPath);
      if (attrReference.isPresent()) {
        String wert = ((AttributZeichenkette) attrReference.get()).getAttributWert();
        attributbeschreibung.setReferenzAttribut(wert);
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // Objekt, in dem das Attribut definiert wurde (DfV-Kategorie/Formular, oder Objektklasse):
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/??? das ist nicht im Attribut verfügbar und müsste durch 2. Query nachgetragen werden!";
      Optional<AttributUriUndWert> formReference = findAttribute(attributeCollector, fabasoftAttrPath);
      if (formReference.isPresent()) {
        String wert = ((AttributZeichenkette) formReference.get()).getAttributWert();
        attributbeschreibung.setReferenzSchriftgutObjektklasseOderFormular(wert);
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    // eigene URL: verwende COO-Adresse
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:objaddress";
      Optional<AttributUriUndWert> cooAddress = findAttribute(attributeCollector, fabasoftAttrPath);
      if (cooAddress.isPresent()) {
        String wert = ((AttributZeichenkette) cooAddress.get()).getAttributWert();
        attributbeschreibung.setEigeneUrl(Optional.of("/Attributbescheibungen/" + wert));  // COO-Adressen sind "gutmütig", müssen niht URLEcoded werden
      } else {
        log.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    return attributbeschreibung;
  }

}

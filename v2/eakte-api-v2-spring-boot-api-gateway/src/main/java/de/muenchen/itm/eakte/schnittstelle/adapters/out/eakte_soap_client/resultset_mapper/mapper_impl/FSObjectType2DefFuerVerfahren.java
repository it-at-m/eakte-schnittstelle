package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl;

import com.fabasoft.schemas.bai.search.ObjectType;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.AttributeCollector;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributZeichenkette;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@AllArgsConstructor
public class FSObjectType2DefFuerVerfahren
  implements ResultsetMapper<DefinitionFuerVerfahren> {

  private static final Logger logger = LoggerFactory.getLogger(FSObjectType2DefFuerVerfahren.class);

  private static Optional<AttributUriUndWert> findAttribute(AttributeCollector attributeCollector, String attributUrl) {
    return attributeCollector.getAttributes().stream()
      .filter(x -> attributUrl.equals(x.getAttributURI()))
      .findFirst();
  }

  @Override
  public DefinitionFuerVerfahren createDomainObjectFromFabasoftObjectType(ObjectType fabasoftResultset) {
    AttributeCollector attributeCollector = new AttributeCollector().processObjectType(fabasoftResultset);
    attributeCollector.logAllAttributes();
    // bei den Metadaten der Attribute haben wir feste Felder (sonst bräuchten wir wieder metadaten für die Metadaten-Attribute!)
    // also holen wir aus den ebenfalls dynamisch vorliegenden Attributen der Attribute die paar Werte raus, die wir wollen
    DefinitionFuerVerfahren definitionFuerVerfahren = new DefinitionFuerVerfahren();

    // Name:
    {
      String fabasoftAttrPath = "/Attributbeschreibungen/COOSYSTEM@1.1:objname";
      Optional<AttributUriUndWert> bezeichnung = findAttribute(attributeCollector, fabasoftAttrPath);
      if (bezeichnung.isPresent()) {
        String fabasoftWert = ((AttributZeichenkette) bezeichnung.get()).getAttributWert();
        definitionFuerVerfahren.name(fabasoftWert);
      } else {
        logger.error("Metadaten-Attribut nicht gefunden: {}", fabasoftAttrPath);
      }
    }

    return definitionFuerVerfahren;
  }

}

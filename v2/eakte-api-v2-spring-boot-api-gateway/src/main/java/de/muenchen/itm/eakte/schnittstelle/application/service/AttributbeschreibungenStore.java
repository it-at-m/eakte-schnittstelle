package de.muenchen.itm.eakte.schnittstelle.application.service;

import de.muenchen.itm.eakte.schnittstelle.config.PredefinedAppDataConfig;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.FabasoftObjectClass;
import de.muenchen.itm.eakte.schnittstelle.domain.AttributeDefinitionQuery;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@Service
@AllArgsConstructor
@Slf4j
public class AttributbeschreibungenStore {

  private final TreeMap<String, Attributbeschreibung> allAttributes = new TreeMap<>();

  private final PredefinedAppDataConfig config;
  private final AttributeDefinitionQuery attributeDefinitionQuery;

  private Optional<Long> lastUpdateTimeStamp = Optional.empty();

  private AttributbeschreibungenStore addToMap(List<Attributbeschreibung> attributes) {
    attributes.stream()
      .filter(attr -> attr.getEigeneUrl().isPresent())
      .forEach(attr -> this.allAttributes.put(attr.getEigeneUrl().get(), attr));
    return this;
  }

  private void rebuildAttributeList() {
    Try<List<Attributbeschreibung>> dynamicAttributes = attributeDefinitionQuery.queryDynamicAttributes(config.getFunktionsUsername(), config.getFunktionsPassword());
    if (dynamicAttributes.isSuccess()) {
      this.allAttributes.clear();
      // add static attributes:
      addToMap(config.getAttributbeschreibungen());
      // add dynamic attributes:
      log.trace("Number of dynamic attributes: " + dynamicAttributes.get().size());
      dynamicAttributes.get().forEach(da -> log.trace(da.toString()));
      addToMap(dynamicAttributes.get());
    } else {
      // im Fehlerfalle: bisherigen Stand belassen, nur Fehler loggen (Gefahr exzessiver Retries)
      log.error(dynamicAttributes.failed().get().getMessage());
      throw new RuntimeException(dynamicAttributes.failed().get());
    }
    lastUpdateTimeStamp = Optional.of(System.currentTimeMillis()/1000);
  }

  public List<Attributbeschreibung> getAllAttributes() {
    // check and update cached Attributbeschreibungen:
    synchronized (this.allAttributes) {
      if (lastUpdateTimeStamp.isEmpty() || (System.currentTimeMillis()/1000 - lastUpdateTimeStamp.get()) > config.getAttributeCacheMaxTimeToLiveInSeconds()) {
        rebuildAttributeList();
      }
    }
    return allAttributes.values().stream().toList();
  }

  public List<Attributbeschreibung> getAttributesForObjectClass(FabasoftObjectClass fabasoftObjectClass) {
    return getAllAttributes().stream()
      .filter(ab -> fabasoftObjectClass.getFabasoftClassSpecfier().equals(ab.getReferenzSchriftgutObjektklasseOderFormular()))
      .toList();
  }

}

package de.muenchen.itm.eakte.schnittstelle.application.service;

import de.muenchen.itm.eakte.schnittstelle.config.PredefinedAppDataConfig;
import de.muenchen.itm.eakte.schnittstelle.domain.DfVQuery;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DfVStore {

  private static final Logger logger = LoggerFactory.getLogger(DfVStore.class);

  private final List<DefinitionFuerVerfahren> allDfVs = new ArrayList<>();

  private final PredefinedAppDataConfig config;
  private final DfVQuery dfvQuery;

  private Optional<Long> lastUpdateTimeStamp = Optional.empty();

  private DfVStore addToList(List<DefinitionFuerVerfahren> attributes) {
    attributes.stream()
      .filter(dfv -> dfv.getEigeneUrl().isPresent())
      .forEach(this.allDfVs::add);
    return this;
  }

  private void rebuildDfVList() {
    Try<List<DefinitionFuerVerfahren>> dfvs = dfvQuery.queryDfVs(config.getFunktionsUsername(), config.getFunktionsPassword());
    if (dfvs.isSuccess()) {
      this.allDfVs.clear();
      logger.info("Number of dfvs found: " + dfvs.get().size());
      dfvs.get().forEach(dfv -> logger.info(dfv.toString()));
      allDfVs.addAll(dfvs.get());
    } else {
      // im Fehlerfalle: bisherigen Stand belassen, nur Fehler loggen (Achtung: möglicherweise Gefahr exzessiver Retries)
      logger.error(dfvs.failed().get().getMessage());
      throw new RuntimeException(dfvs.failed().get());
    }
    lastUpdateTimeStamp = Optional.of(System.currentTimeMillis()/1000);
  }

  public List<DefinitionFuerVerfahren> getAllDfVs() {
    // check and update cached Attributbeschreibungen:
    synchronized (this.allDfVs) {
      if (lastUpdateTimeStamp.isEmpty() || (System.currentTimeMillis()/1000 - lastUpdateTimeStamp.get()) > config.getAttributeCacheMaxTimeToLiveInSeconds()) {
        rebuildDfVList();
      }
    }
    return allDfVs;
  }

}

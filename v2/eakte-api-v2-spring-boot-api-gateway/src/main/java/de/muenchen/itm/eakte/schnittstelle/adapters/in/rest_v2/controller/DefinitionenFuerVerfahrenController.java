package de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.controller;

import de.muenchen.itm.eakte.schnittstelle.config.PredefinedAppDataConfig;
import de.muenchen.itm.eakte.schnittstelle.domain.DfVQuery;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.controllers.DefinitionenFuerVerfahrenApi;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionenFuerVerfahrenListeResponse;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EAkteSchnittstelleError;
import io.vavr.control.Try;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DefinitionenFuerVerfahrenController
  implements DefinitionenFuerVerfahrenApi {

  private final PredefinedAppDataConfig config;
  private final DfVQuery dfvQuery;

  @Override
  public ResponseEntity<@NotNull DefinitionenFuerVerfahrenListeResponse> leseDefinitionenFuerVerfahren(Optional<String> fachverfahrensID,
                                                                                                       Optional<String> loginName,
                                                                                                       Optional<String> stelle,
                                                                                                       Optional<String> organisationseinheit,
                                                                                                       HttpServletRequest servletRequest) {
    Try<List< DefinitionFuerVerfahren>> definitionenFuerVerfahren = dfvQuery.queryDfVs(config.getFunktionsUsername(), config.getFunktionsPassword());
    DefinitionenFuerVerfahrenListeResponse response;
    if (definitionenFuerVerfahren.isSuccess()) {
      response = new DefinitionenFuerVerfahrenListeResponse()
        .success(true)
        .definitionenFuerVerfahrenListe(definitionenFuerVerfahren.get())
        .anzahlDefinitionenFuerVerfahren(definitionenFuerVerfahren.get().size());
    } else {
      response = new DefinitionenFuerVerfahrenListeResponse()
        .error(new EAkteSchnittstelleError().easFehlercode(100).easFehler(definitionenFuerVerfahren.failed().getCause().getMessage()));
    }
    return ResponseEntity.ok(response);

  }
}

package de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.controller;

import de.muenchen.itm.eakte.schnittstelle.application.service.AttributbeschreibungenStore;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.controllers.AttributbeschreibungenApi;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AttributbeschreibungenController
  implements AttributbeschreibungenApi {

  private final AttributbeschreibungenStore attributbeschreibungenStore;

  @Override
  public ResponseEntity<@NotNull AttributbeschreibungenListeResponse> leseAttributebeschreibungen(Optional<String> fachverfahrensID,
                                                                                                  Optional<String> loginName,
                                                                                                  Optional<String> stelle,
                                                                                                  Optional<String> organisationseinheit,
                                                                                                  HttpServletRequest servletRequest) {
    List<Attributbeschreibung> attributBeschreibungen = attributbeschreibungenStore.getAllAttributes();
    AttributbeschreibungenListeResponse response = new AttributbeschreibungenListeResponse()
      .success(true)
      .attributbeschreibungenListe(attributBeschreibungen)
      .anzahlAttributbeschreibungen(attributBeschreibungen.size());
    return ResponseEntity.ok(response);

  }
}

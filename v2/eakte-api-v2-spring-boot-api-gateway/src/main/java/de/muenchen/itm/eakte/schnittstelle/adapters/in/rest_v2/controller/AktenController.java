package de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.controller;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.FabasoftObjectClass;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.MapperFactory;
import de.muenchen.itm.eakte.schnittstelle.application.service.AttributbeschreibungenStore;
import de.muenchen.itm.eakte.schnittstelle.domain.service.SearchServiceImpl;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.controllers.AktenApi;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Akte;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AktenListeResponse;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EAkteSchnittstelleError;
import io.vavr.control.Try;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@RestController
public class AktenController
  implements AktenApi {

  private static final Logger logger = LoggerFactory.getLogger(AktenController.class);

  private final SearchServiceImpl searchService;
  private final AttributbeschreibungenStore attributbeschreibungenStore;


  @Override
  public ResponseEntity<@NotNull AktenListeResponse> sucheAkten(Optional<String> fachverfahrensID,
                                                                Optional<String> loginName,
                                                                Optional<String> stelle,
                                                                Optional<String> organisationseinheit,
                                                                Optional<String> bedingungen,
                                                                HttpServletRequest servletRequest) {

    RequestContext requestContext = new RequestContext(fachverfahrensID, loginName, stelle, organisationseinheit,
        Optional.ofNullable(servletRequest.getHeader("Authorization")));
    logger.info("request context: {}", requestContext);
    Optional<String> zusatzBedingungen = Optional.of(".${Eigentuemer} = 'COO.2150.8800.1.230497'");   // ,,,fh muss diskutiert werden (Einschränkung auf Mandanten, ...)
    Try<List<Akte>> trefferListe = searchService.search(requestContext, FabasoftObjectClass.AKTE, bedingungen, zusatzBedingungen, MapperFactory.getAkteMapper(), Optional.of(100), true);
    if (trefferListe.isSuccess()) {
      return ResponseEntity.ok(new AktenListeResponse().success(true).aktenListe(trefferListe.get()).anzahlAkten(trefferListe.get().size()));
    } else {
      //logger.error("sucheAkten has thrown an exception", trefferListe.failed().get());
      return ResponseEntity.internalServerError().body(new AktenListeResponse().success(false).error(new EAkteSchnittstelleError().easDetail(trefferListe.failed().get().getMessage())));
    }
  }

}

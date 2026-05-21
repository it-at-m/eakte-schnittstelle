package de.muenchen.itm.eakte.schnittstelle.domain.service;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.FabasoftObjectClass;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.SoapSearchWrapper;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.application.ports.in.SearchService;
import de.muenchen.itm.eakte.schnittstelle.application.service.AttributbeschreibungenStore;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.FabasoftQueryLanguageBuilder;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SearchServiceImpl
  implements SearchService {

  private static final Logger log =  LoggerFactory.getLogger(SearchServiceImpl.class);

  @Autowired
  private final SoapSearchWrapper soapSearchWrapper;

  @Autowired
  private final AttributbeschreibungenStore attributbeschreibungenStore;

  /**
   * dieser Search-call macht Folgendes zusätzlich zu dem aufgerufenen soapSearchWrapper.search:
   * - Attributliste automatisch generiert aus dem attributbeschreibungenStore
   * - query zusammengesetzt aus Einzelteilen (fabasoftObjectClass, Bedingungungen, limit, nocheck)
   * - zusätzlich die Maksos in den Bedingungen expandiert (mit Lookup aus attributbeschreibungenStore)
   *
   */
  public <T> Try<List<T>> search(RequestContext requestContext,
                                 FabasoftObjectClass fabasoftObjectClass,
                                 Optional<String> bedingungen,
                                 Optional<String> zusatzBedingungen,
                                 ResultsetMapper<T> resourceCreationMapper,
                                 Optional<Integer> limit,
                                 boolean nocheck) {

    log.info("building query");
    log.info("bedingungen: {}", bedingungen);
    List<Attributbeschreibung> attributes = attributbeschreibungenStore.getAttributesForObjectClass(fabasoftObjectClass);
    FabasoftQueryLanguageBuilder fabasoftQueryLanguageBuilder = new FabasoftQueryLanguageBuilder(attributes);
    String fabasoftQLQuery = fabasoftQueryLanguageBuilder.createQueryString(fabasoftObjectClass, bedingungen, zusatzBedingungen, limit, nocheck);
    List<String> fabasoftQLAttrList = attributes.stream().map(Attributbeschreibung::getReferenzAttribut).toList();
    log.info("submitting SOAP query:\n{}", fabasoftQueryLanguageBuilder.createFullSoapRequest(fabasoftQLQuery, fabasoftQLAttrList));
    return soapSearchWrapper.search(requestContext, fabasoftQLQuery, fabasoftQLAttrList, resourceCreationMapper);
  }

}
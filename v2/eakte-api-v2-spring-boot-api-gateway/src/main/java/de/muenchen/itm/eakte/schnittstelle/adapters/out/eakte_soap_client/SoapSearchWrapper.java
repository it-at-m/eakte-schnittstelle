package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client;

import com.fabasoft.schemas.bai.search.AttrListType;
import com.fabasoft.schemas.bai.search.QueryResultType;
import com.fabasoft.schemas.bai.search.SOAPSearchRequestType;
import com.fabasoft.schemas.bai.search.SOAPSearchResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.TXContext;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.application.ports.out.DmsSearchService;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import io.vavr.control.Try;
import jakarta.xml.ws.Holder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SoapSearchWrapper
implements DmsSearchService {

  private final EgovClientProxyPool proxyPool;

  public <T> Try<List<T>> search(RequestContext requestContext,
                                 String fabasoftQLQuery,
                                 List<String> fabasoftQLAttrList,
                                 ResultsetMapper<T> resourceCreationMapper) {

    final FSCGOVXML11001DefaultWebServiceDefinitionSoap webService4User;

    // verschiedene Möglichkeiten der Authentisierung gegenüber dem eAkte-System:
    // 1) Weiterleiten von BasicAuth
    // 2) "Trusted Application Login" mit username aus validierten JWT Token
    Optional<RequestContext.AuthCredentials> authCredentials = requestContext.getAuthCredentials();
    if (authCredentials.isEmpty()) {
      return Try.failure(new Exception("No auth credentials found. Please check the authentication header."));
    }
    switch (authCredentials.get()) {
      case RequestContext.BasicAuthCredentials basicAuthCredentials:
        webService4User = proxyPool.getProxy(basicAuthCredentials.username(), basicAuthCredentials.password());
        //webService4User = proxyPool.getSoapClient(requestContext.getUsername().orElse("<MISSING>"), requestContext.getPassword().orElse("<MISSING>"));
        break;
      case RequestContext.BearerAuthCredentials bearerAuthCredentials:
        return Try.failure(new Exception("JWT Auth not yet implemented to forward bearerAuthCredentials: " + bearerAuthCredentials));
    }

    // erzeuge den SOAP-Netzwerk-Request mit den nötigen Parametern:
    SOAPSearchRequestType request = new SOAPSearchRequestType();
    request.setQuery(fabasoftQLQuery);
    request.setAttrlist(new AttrListType());
    request.getAttrlist().getAttr().addAll(fabasoftQLAttrList);
    TXContext txContext = null;
    Holder<TXContext> holder = new Holder<>(txContext);

    // mache den Call:
    log.trace("sending request to: {}", proxyPool.getWsdlUrl());
    try {
      SOAPSearchResponseType response = webService4User.soapSearch(request, holder);

      // werte das Ergebnis des Calls aus:
      QueryResultType queryResult = response.getQueryresult();
      if (queryResult != null) {
        List<T> typedList = queryResult.getObject().stream().map(resourceCreationMapper::createDomainObjectFromFabasoftObjectType).toList();
        return Try.success(typedList);
      } else {
        // eAkte liefert null value zurück und keine leere Liste, wenn nichts gefunden wurde,
        // also erzeugen wir halt als Sonderfall eine leere Liste, da mit null die obige
        // Lambda chain nicht aufgerufen werden kann
        List<T> emptyList = new ArrayList<>();
        return Try.success(emptyList);
      }
    }
    catch (Exception exc) {
      return Try.failure(exc);
    }
  }

}
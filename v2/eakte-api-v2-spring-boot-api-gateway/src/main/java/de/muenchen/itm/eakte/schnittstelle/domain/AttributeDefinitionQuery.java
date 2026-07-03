package de.muenchen.itm.eakte.schnittstelle.domain;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.SoapSearchWrapper;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.MapperFactory;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Getter
@Service
@AllArgsConstructor
public class AttributeDefinitionQuery {

  private final SoapSearchWrapper soapSearchWrapper;

  private static final String query = """
        LIMIT 1000
        SELECT *
        FROM COOSYSTEM@1.1:AttributeDefinition
      """;

  private static final List<String> attrListForAttributeQuery = List.of(
    "COOSYSTEM@1.1:objname",
    "COOSYSTEM@1.1:objaddress",
    "COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:objname",
    "COOSYSTEM@1.1:attrmustbedef",
    "COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:objname",
    //"COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:mlname",
    "COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:objaddress",
    "COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:reference",
    "COOSYSTEM@1.1:attrtype.COOSYSTEM@1.1:typeenumvalues",
    "COOSYSTEM@1.1:attrlength"
  );

  public Try<List<Attributbeschreibung>> queryDynamicAttributes(String username, String password) {
    RequestContext requestContext = RequestContext.builder()
      .fachverfahrensID(Optional.of("INTERNAL-CALL FROM EAI"))
      .authHeader(Optional.of("Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8))))
      .build();
    //query = query + "\nWHERE .COOSYSTEM@1.1:objname like 'fh%'";  // ,,,fh for test
    return soapSearchWrapper.search(requestContext, query, attrListForAttributeQuery, MapperFactory.getAttributbeschreibungMapper());
  }

}
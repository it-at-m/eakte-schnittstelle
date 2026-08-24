package de.muenchen.itm.eakte.schnittstelle.domain;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.SoapSearchWrapper;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.MapperFactory;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;
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
public class DfVQuery {

  private final SoapSearchWrapper soapSearchWrapper;

  private static final String query = """
        LIMIT 1000
        SELECT *
        FROM EGOVTEMPLATE@15.1001:Definition
      """;

  private static final List<String> attrListForDfVQuery = List.of(
    "COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:definitionclass.COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:availabledefinitions.COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:definitionuseform.COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:draftcategory.COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:draftcategory.COOTC@1.1001:categoryattributes.COOSYSTEM@1.1:objname",
    "EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOSYSTEM@1.1:objname"
  );

  public Try<List<DefinitionFuerVerfahren>> queryDfVs(String username, String password) {
    RequestContext requestContext = RequestContext.builder()
      .fachverfahrensID(Optional.of("INTERNAL-CALL FROM EAI"))
      .authHeader(Optional.of("Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8))))
      .build();
    return soapSearchWrapper.search(requestContext, query, attrListForDfVQuery, MapperFactory.getDfVMapper());
  }

}
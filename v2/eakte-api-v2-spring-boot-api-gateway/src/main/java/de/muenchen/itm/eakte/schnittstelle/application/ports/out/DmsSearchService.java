package de.muenchen.itm.eakte.schnittstelle.application.ports.out;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import io.vavr.control.Try;

import java.util.List;

public interface DmsSearchService {

  <T> Try<List<T>> search(RequestContext requestContext,
                                 String fabasoftQLQuery,
                                 List<String> fabasoftQLAttrList,
                                 ResultsetMapper<T> resourceCreationMapper);
  }

package de.muenchen.itm.eakte.schnittstelle.application.ports.in;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.FabasoftObjectClass;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.identity_propagation.RequestContext;
import io.vavr.control.Try;

import java.util.List;
import java.util.Optional;

public interface SearchService {

  <T> Try<List<T>> search(RequestContext requestContext,
                          FabasoftObjectClass fabasoftObjectClass,
                          Optional<String> bedingungen,
                          Optional<String> zusatzBedingungen,
                          ResultsetMapper<T> resourceCreationMapper,
                          Optional<Integer> limit,
                          boolean nocheck);
}

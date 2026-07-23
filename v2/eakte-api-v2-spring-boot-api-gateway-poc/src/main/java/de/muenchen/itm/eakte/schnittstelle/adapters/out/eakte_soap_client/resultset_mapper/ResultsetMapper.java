package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper;

import com.fabasoft.schemas.bai.search.ObjectType;

@FunctionalInterface
public interface ResultsetMapper<T> {

  public T createDomainObjectFromFabasoftObjectType(ObjectType objectType);

}

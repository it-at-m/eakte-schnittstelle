package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl;

import com.fabasoft.schemas.bai.search.ObjectType;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.AttributeCollector;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.ResultsetMapper;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Akte;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AkteFromFabasoftObjectType implements ResultsetMapper<Akte> {

  @Override
  public Akte createDomainObjectFromFabasoftObjectType(ObjectType fabasoftResultset) {
    AttributeCollector attributeCollector = new AttributeCollector();
    attributeCollector.processObjectType(fabasoftResultset);
    return new Akte()
      .attributListe(attributeCollector.getAttributes())
      .eigeneUrl("/Akten/" + fabasoftResultset.getObjaddress());
  };

}

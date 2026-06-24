package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper;

import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl.AkteFromFabasoftObjectType;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl.FSObjectType2Attributbeschreibung;
import de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client.resultset_mapper.mapper_impl.FSObjectType2DefFuerVerfahren;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Akte;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.DefinitionFuerVerfahren;

public final class MapperFactory {

  private MapperFactory() {
  }

  public static ResultsetMapper<Akte> getAkteMapper() {
    return new AkteFromFabasoftObjectType();
  }

  public static ResultsetMapper<Attributbeschreibung> getAttributbeschreibungMapper() {
    return new FSObjectType2Attributbeschreibung();
  }

  public static ResultsetMapper<DefinitionFuerVerfahren> getDfVMapper() {
    return new FSObjectType2DefFuerVerfahren();
  }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Dokument;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = { AttributeMapper.class })
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.ERROR)
interface DokumentMapper {
    Dokument fromDomain(DokumentResponse response);

    Dokument.KlasseEnum fromDomain(DokumentKlasse klasse);

    List<Dokument> fromDomain(List<DokumentResponse> response);
}

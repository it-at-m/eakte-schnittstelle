package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Schriftstueck;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.ERROR)
interface SchriftstueckMapper {
    Schriftstueck fromDomain(SchriftstueckResponse schriftstueck);

    List<Schriftstueck> fromDomain(Collection<SchriftstueckResponse> responses);
}

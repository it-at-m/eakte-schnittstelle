package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = { AttributeMapper.class })
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.ERROR)
interface VorgangMapper {
    Vorgang fromDomain(VorgangResponse response);

    List<Vorgang> fromDomain(Collection<VorgangResponse> responses);
}

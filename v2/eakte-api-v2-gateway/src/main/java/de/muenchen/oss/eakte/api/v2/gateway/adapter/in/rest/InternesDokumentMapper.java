package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.InternesDokument;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = { AttributeMapper.class })
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface InternesDokumentMapper {
    InternesDokument fromDomain(InternesDokumentResponse response);

    List<InternesDokument> fromDomain(Collection<InternesDokumentResponse> responses);
}

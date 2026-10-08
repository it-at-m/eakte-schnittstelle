package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.CreateVorgang;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreateVorgangMapper {
    @Mapping(source = "vorgang.zugriffsdefinition", target = "zugriffsdefinitionText")
    CreateVorgangRequest toDomain(String aktenId, CreateVorgang vorgang);
}

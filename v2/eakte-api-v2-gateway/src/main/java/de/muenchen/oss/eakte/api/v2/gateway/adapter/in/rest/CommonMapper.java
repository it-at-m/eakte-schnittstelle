package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper
public interface CommonMapper {
    Role toDomain(de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Rolle role);
}

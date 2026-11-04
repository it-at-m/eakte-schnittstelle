package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftRole;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Role;
import org.mapstruct.Mapper;

@Mapper
public interface FabasoftCommonMapper {
    FabasoftRole fromDomain(Role role);
}

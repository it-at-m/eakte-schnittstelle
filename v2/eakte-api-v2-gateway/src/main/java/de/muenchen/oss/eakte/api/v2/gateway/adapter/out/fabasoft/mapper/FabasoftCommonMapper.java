package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftPosition;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Stelle;
import org.mapstruct.Mapper;

@Mapper
public interface FabasoftCommonMapper {
    FabasoftPosition fromDomain(Stelle position);

    Stelle toDomain(FabasoftPosition position);
}

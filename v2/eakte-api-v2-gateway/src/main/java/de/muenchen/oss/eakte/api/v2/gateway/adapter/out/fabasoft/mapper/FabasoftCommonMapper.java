package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftPosition;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Position;
import org.mapstruct.Mapper;

@Mapper
public interface FabasoftCommonMapper {
    FabasoftPosition fromDomain(Position position);

    Position toDomain(FabasoftPosition position);
}

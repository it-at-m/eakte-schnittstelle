package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftStelle;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Stelle;
import org.mapstruct.Mapper;

@Mapper
public interface FabasoftCommonMapper {
    FabasoftStelle fromDomain(Stelle stelle);

    Stelle toDomain(FabasoftStelle stelle);
}

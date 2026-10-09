package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface AttributeMapper {
    EigenschaftEintrag fromDomain(Attribute attribute);

    List<EigenschaftEintrag> fromDomain(List<Attribute> attributes);
}

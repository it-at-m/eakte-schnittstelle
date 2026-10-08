package de.muenchen.oss.eakte.api.v2.gateway.application.port.out;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;

import java.util.List;

public interface AttributesOutPort {
    void setAttributes(RequestContext requestContext, String objectId, List<Attribute> attributes);
}

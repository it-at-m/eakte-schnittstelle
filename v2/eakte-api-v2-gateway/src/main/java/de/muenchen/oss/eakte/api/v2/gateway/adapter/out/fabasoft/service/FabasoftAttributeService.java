package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.schemas.universal.ObjectType;
import com.fabasoft.schemas.universal.SetResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.AttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FabasoftAttributeService {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftRequestHandler requestHandler;
    private final AttributeMapper attributeMapper;

    public void setAttributes(final RequestContext requestContext, final String objectId, final List<FabasoftAttribute> attributes) {
        final ObjectType request = attributeMapper.fromFabasoftAttribute(attributes);
        request.setObjaddress(objectId);
        // TODO transaktion
        log.debug("#setAttributes {}", attributes);
        final SetResponseType response = requestHandler.handleRequest("setAttributes", requestContext,
                () -> soapClient.soapGenericSetProperties(request, null));
        // TODO check response
        if (response.getFailed() != null && !response.getFailed().getAttr().isEmpty()) {
            throw new DmsException("#setAttributes failed: %s".formatted(response));
        }
        log.info("#setAttributes on {}", objectId);
    }
}

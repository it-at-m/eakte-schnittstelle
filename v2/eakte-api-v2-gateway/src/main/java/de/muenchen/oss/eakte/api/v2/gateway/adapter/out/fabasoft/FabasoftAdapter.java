package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import com.fabasoft.editions.schemas.gov.createsubfile.CreateSubFileRequestType;
import com.fabasoft.editions.schemas.gov.createsubfile.CreateSubFileResponseType;
import com.fabasoft.schemas.universal.ObjectType;
import com.fabasoft.schemas.universal.SetResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.AttributesOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SubFileOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FabasoftAdapter implements SubFileOutPort, AttributesOutPort {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftAttributeOutMapper attributeOutMapper;
    private final FabasoftRequestHandler requestHandler;

    @Override
    public String createSubFile(final RequestContext requestContext, final SubFileRequest request) {
        final CreateSubFileRequestType requestType = new CreateSubFileRequestType();
        requestType.setObjclass(request.type().getCoo());
        requestType.setReferrednumber(request.referredId());
        requestType.setObjmlname(request.name());
        // TODO
        requestType.getFilesubj().addAll(List.of(request.betreff().split("\n")));
        requestType.setCreatedfromdefinition(request.vorlagenId());
        // TODO transaktion
        log.debug("#createSubFile for {}", request);
        final CreateSubFileResponseType response = requestHandler.handleRequest("createSubFile", requestContext,
                () -> soapClient.soapCreateSubFile(requestType, null));
        if (response != null && response.getSubfile() != null) {
            final String objectId = response.getSubfile().getObjaddress();
            log.info("#createSubFile created {} {}", request.type().getFabasoftReference(), objectId);
            return objectId;
        }
        throw new DmsException("#createSubFile empty response");
    }

    @Override
    public void setAttributes(final RequestContext requestContext, final String objectId, final List<Attribute> attributes) {
        final ObjectType request = attributeOutMapper.fromAttributes(attributes);
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

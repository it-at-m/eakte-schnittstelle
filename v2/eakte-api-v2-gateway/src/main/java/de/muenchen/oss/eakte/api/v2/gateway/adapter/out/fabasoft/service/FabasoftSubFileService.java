package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.editions.schemas.gov.createsubfile.CreateSubFileRequestType;
import com.fabasoft.editions.schemas.gov.createsubfile.CreateSubFileResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FabasoftSubFileService {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftRequestHandler requestHandler;

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
}

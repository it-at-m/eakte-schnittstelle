package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.editions.schemas.gov.getuserinformation.GetUserInformationRequestType;
import com.fabasoft.editions.schemas.gov.getuserinformation.GetUserInformationResponseType;
import com.fabasoft.editions.schemas.gov.getuserinformation.UserRequestType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftBenutzerMapper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftUserService {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftRequestHandler requestHandler;
    private final FabasoftBenutzerMapper benutzerMapper;

    public Benutzer getByUsername(final String username) {
        final RequestContext requestContext = new RequestContext(username, null, null);
        final GetUserInformationRequestType request = new GetUserInformationRequestType();
        final UserRequestType user = new UserRequestType();
        user.setLogin(username);
        request.setUser(user);
        final GetUserInformationResponseType response = requestHandler.handleRequest("searchObject", requestContext,
                () -> soapClient.soapGetUserInformation(request, null));
        return benutzerMapper.toDomain(response);
    }
}

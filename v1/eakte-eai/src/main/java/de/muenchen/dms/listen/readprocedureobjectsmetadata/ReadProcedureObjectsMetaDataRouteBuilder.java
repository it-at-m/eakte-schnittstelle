package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import de.muenchen.dms.common.route.DmsRouteBuilder;
import de.muenchen.dms.common.route.RestOperationDefinitionFactory;
import de.muenchen.dms.common.route.RouteConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ReadProcedureObjectsMetaDataRouteBuilder extends DmsRouteBuilder {
    @Override
    public void route() throws Exception {
        rest("/readProcedureObjectsMetaData")
                .get("/{" + RouteConstants.PATH_PARAM_OBJADDRESS + "}")
                .id(RouteConstants.ROUTE_ID_READ_PROCEDURE_OBJECTS_META_DATA)
                .description("Liste von Schriftstücken mit Metadaten auslesen")
                .security(RouteConstants.BASIC_AUTH_SECURITY_DEFINITION)
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .params(RestOperationDefinitionFactory.createAuthentificationHeader())
                .params(RestOperationDefinitionFactory.createObjectHeaderReadSubject())
                .responseMessages(
                        RestOperationDefinitionFactory.createBaseResponseMsgDefinition(
                                ReadProcedureObjectsMetaDataResponseDTO.class))
                .to(RouteConstants.DIRECT_READ_PROCEDURE_OBJECTS_META_DATA);
    }
}

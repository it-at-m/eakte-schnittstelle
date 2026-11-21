package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import de.muenchen.dms.common.route.DmsRouteBuilder;
import de.muenchen.dms.common.route.RestOperationDefinitionFactory;
import de.muenchen.dms.common.route.RouteConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ReadSubjectAreaObjectsMetaDataRouteBuilder extends DmsRouteBuilder {
  @Override
  public void route() throws Exception {
    rest("/readSubjectAreaObjectsMetaData")
        .get("/{" + RouteConstants.PATH_PARAM_OBJADDRESS + "}")
        .id(RouteConstants.ROUTE_ID_READ_SUBJECT_AREA_OBJECTS_METADATA)
        .description("Liste von Sachakten mit Metadaten eines Aktenplaneintrags auslesen")
        .security(RouteConstants.BASIC_AUTH_SECURITY_DEFINITION)
        .consumes(MediaType.APPLICATION_JSON_VALUE)
        .produces(MediaType.APPLICATION_JSON_VALUE)
        .params(RestOperationDefinitionFactory.createAuthentificationHeader())
        .params(RestOperationDefinitionFactory.createObjectHeaderReadSubject())
        .responseMessages(
            RestOperationDefinitionFactory.createBaseResponseMsgDefinition(
                ReadSubjectAreaObjectsMetaDataResponseDTO.class))
        .to(RouteConstants.DIRECT_READ_SUBJECT_AREA_OBJECTS_METADATA);
  }
}

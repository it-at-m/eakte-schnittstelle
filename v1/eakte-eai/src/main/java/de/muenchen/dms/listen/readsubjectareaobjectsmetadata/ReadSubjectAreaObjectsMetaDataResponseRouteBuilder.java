package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import de.muenchen.dms.common.route.DmsResponseRouteBuilder;
import de.muenchen.dms.common.route.RouteConstants;
import de.muenchen.dms.common.route.auth.DmsAuthorizationProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReadSubjectAreaObjectsMetaDataResponseRouteBuilder extends DmsResponseRouteBuilder {

  private final ReadSubjectAreaObjectsMetaDataProcessor requestProcessor;
  private final ReadSubjectAreaObjectsMetaDataResponseProcessor responseProcessor;

  public ReadSubjectAreaObjectsMetaDataResponseRouteBuilder(
      DmsAuthorizationProcessor authorizationProcessor,
      ReadSubjectAreaObjectsMetaDataProcessor requestProcessor,
      ReadSubjectAreaObjectsMetaDataResponseProcessor responseProcessor) {
    super(authorizationProcessor);
    this.requestProcessor = requestProcessor;
    this.responseProcessor = responseProcessor;
  }

  @Override
  public void route() throws Exception {
    soap(RouteConstants.DIRECT_READ_SUBJECT_AREA_OBJECTS_METADATA)
        .request(requestProcessor)
        .response(responseProcessor);
  }
}

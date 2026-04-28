package de.muenchen.dms.schriftstueck.eingang.lesen;

import static de.muenchen.dms.common.route.RouteConstants.DIRECT_READ_INCOMING;

import de.muenchen.dms.common.route.DmsResponseRouteBuilder;
import de.muenchen.dms.common.route.auth.DmsAuthorizationProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReadIncomingResponseRouteBuilder extends DmsResponseRouteBuilder {

  private final ReadIncomingProcessor requestProcessor;
  private final ReadIncomingResponseProcessor responseProcessor;

  public ReadIncomingResponseRouteBuilder(
      DmsAuthorizationProcessor authorizationProcessor,
      ReadIncomingProcessor requestProcessor,
      ReadIncomingResponseProcessor responseProcessor) {
    super(authorizationProcessor);
    this.requestProcessor = requestProcessor;
    this.responseProcessor = responseProcessor;
  }

  @Override
  public void route() throws Exception {
    soap(DIRECT_READ_INCOMING).request(requestProcessor).response(responseProcessor);
  }
}

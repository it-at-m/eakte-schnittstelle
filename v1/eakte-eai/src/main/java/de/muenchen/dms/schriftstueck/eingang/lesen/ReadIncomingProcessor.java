package de.muenchen.dms.schriftstueck.eingang.lesen;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadIncomingGI;
import de.muenchen.dms.common.processor.AbstractDMSSoapProcessor;
import de.muenchen.dms.common.route.RouteConstants;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ReadIncomingProcessor extends AbstractDMSSoapProcessor {
  @Override
  public void process(Exchange exchange) throws Exception {
    final String objaddress =
        exchange.getMessage().getHeader(RouteConstants.PATH_PARAM_OBJADDRESS, String.class);
    // Erzeuge eine SOAP-Nachricht
    final ReadIncomingGI parameters =
        readIncomingGI(
            objaddress,
            getNutzer(exchange),
            getOrganisationseinheit(exchange),
            getRolle(exchange),
            getAnwendung(exchange));
    setParameters(exchange, parameters, ReadIncomingGI.class);
  }

  private ReadIncomingGI readIncomingGI(
      final String objaddress,
      final String userlogin,
      final String joboe,
      final String jobposition,
      final String businessapp) {
    final ReadIncomingGI readIncomingGI = objectFactory.createReadIncomingGI();
    readIncomingGI.setUserlogin(userlogin);
    readIncomingGI.setObjaddress(objaddress);
    readIncomingGI.setBusinessapp(businessapp);
    readIncomingGI.setJoboe(joboe);
    readIncomingGI.setJobposition(jobposition);
    return readIncomingGI;
  }
}

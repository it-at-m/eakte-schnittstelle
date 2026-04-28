package de.muenchen.dms.schriftstueck.eingang_lesen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadIncomingGI;
import de.muenchen.dms.common.route.QueryProperties;
import de.muenchen.dms.common.route.RouteConstants;
import de.muenchen.dms.schriftstueck.eingang.lesen.ReadIncomingProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadIncomingProcessorTest {

  @Test
  void testProcess() throws Exception {
    final String AKTENCOOID = "COOID 1212";
    final String NUTZER = "NUTZER";
    final String ANWENDUNG = "ANWENDUNG";

    CamelContext ctx = new DefaultCamelContext();
    Exchange exchange = new DefaultExchange(ctx);

    // Exchange anreichern mit den erforderlichen Daten
    exchange.getIn().setHeader(RouteConstants.PATH_PARAM_OBJADDRESS, AKTENCOOID);
    exchange.setProperty(QueryProperties.PROPERTY_ANWENDUNG, ANWENDUNG);
    exchange.setProperty(QueryProperties.PROPERTY_NUTZER, NUTZER);

    // Methode ausführen
    final ReadIncomingProcessor processor = new ReadIncomingProcessor();
    processor.process(exchange);

    String header = exchange.getMessage().getHeader(CxfConstants.OPERATION_NAME, String.class);
    ReadIncomingGI readIncomingGI = exchange.getMessage().getBody(ReadIncomingGI.class);

    assertThat(header, equalTo(ReadIncomingGI.class.getSimpleName()));
    Assertions.assertNotNull(readIncomingGI, "ReadIncomingGI Objekt ist null");
    Assertions.assertEquals(
        NUTZER, readIncomingGI.getUserlogin(), "Userlogin stimmt nicht überein");
    Assertions.assertEquals(
        ANWENDUNG, readIncomingGI.getBusinessapp(), "Businessapp stimmt nicht überein");
    Assertions.assertEquals(
        AKTENCOOID, readIncomingGI.getObjaddress(), "Objadress stimmt nicht überein");
  }
}

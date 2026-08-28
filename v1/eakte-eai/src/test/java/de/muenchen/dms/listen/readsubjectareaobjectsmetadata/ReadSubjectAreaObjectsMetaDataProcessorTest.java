package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadSubjectAreaGIObjectsMetaData;
import de.muenchen.dms.common.route.QueryProperties;
import de.muenchen.dms.common.route.RouteConstants;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadSubjectAreaObjectsMetaDataProcessorTest {
  @Test
  void testProcess() throws Exception {
    final String OBJADDDRESS = "COO.1.2301.1.1042465";
    final String NUTZER = "NUTZER";
    final String ANWENDUNG = "ANWENDUNG";
    final String BOSTATE = "COO.1.2301.1.679";
    final Integer DOCSTATE = 10;

    CamelContext ctx = new DefaultCamelContext();
    Exchange exchange = new DefaultExchange(ctx);

    exchange.getIn().setHeader(RouteConstants.PATH_PARAM_OBJADDRESS, OBJADDDRESS);
    exchange.setProperty(QueryProperties.PROPERTY_NUTZER, NUTZER);
    exchange.setProperty(QueryProperties.PROPERTY_ANWENDUNG, ANWENDUNG);
    exchange.getIn().setHeader(QueryProperties.PROPERTY_BOSTATE, BOSTATE);
    exchange.getIn().setHeader(QueryProperties.PROPERTY_DOCSTATE, DOCSTATE);

    final ReadSubjectAreaObjectsMetaDataProcessor processor = new ReadSubjectAreaObjectsMetaDataProcessor();
    processor.process(exchange);

    String header = exchange.getMessage().getHeader(CxfConstants.OPERATION_NAME, String.class);
    ReadSubjectAreaGIObjectsMetaData readSubjectAreaGIObjectsMetaData =
        exchange.getMessage().getBody(ReadSubjectAreaGIObjectsMetaData.class);

    assertThat(header, equalTo(ReadSubjectAreaGIObjectsMetaData.class.getSimpleName()));
    assertNotNull(readSubjectAreaGIObjectsMetaData, "ReadSubjectAreaGIObjectsMetaData is null");
    assertEquals(
        NUTZER, readSubjectAreaGIObjectsMetaData.getUserlogin(), "Userlogin stimmt nicht überein");
    assertEquals(
        ANWENDUNG,
        readSubjectAreaGIObjectsMetaData.getBusinessapp(),
        "Businessapp stimmt nicht überein");
    assertEquals(
        OBJADDDRESS,
        readSubjectAreaGIObjectsMetaData.getObjaddress(),
        "Objaddress stimmt nicht überein");
    assertEquals(
        BOSTATE, readSubjectAreaGIObjectsMetaData.getBostate(), "Bostate stimmt nicht überein");
    assertEquals(
        DOCSTATE, readSubjectAreaGIObjectsMetaData.getDocstate(), "Docstate stimmt nicht überein");
  }
}

package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadSubjectAreaGIObjectsMetaData;
import de.muenchen.dms.common.processor.AbstractDMSSoapProcessor;
import de.muenchen.dms.common.route.QueryProperties;
import de.muenchen.dms.common.route.RouteConstants;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ReadSubjectAreaObjectsMetaDataProcessor extends AbstractDMSSoapProcessor {
  @Override
  public void process(Exchange exchange) throws Exception {
    final String objaddress =
        exchange.getMessage().getHeader(RouteConstants.PATH_PARAM_OBJADDRESS, String.class);
    final Integer docstate =
        exchange.getIn().getHeader(QueryProperties.PROPERTY_DOCSTATE, Integer.class);
    final String bostate =
        exchange.getIn().getHeader(QueryProperties.PROPERTY_BOSTATE, String.class);

    final ReadSubjectAreaGIObjectsMetaData parameter =
        readSubjectAreaGIObjectsMetaData(
            objaddress,
            docstate,
            bostate,
            getNutzer(exchange),
            getOrganisationseinheit(exchange),
            getRolle(exchange),
            getAnwendung(exchange));
    setParameters(exchange, parameter, ReadSubjectAreaGIObjectsMetaData.class);
  }

  private ReadSubjectAreaGIObjectsMetaData readSubjectAreaGIObjectsMetaData(
      final String objaddress,
      final Integer docstate,
      final String bostate,
      final String userlogin,
      final String organisationseinheit,
      final String rolle,
      final String anwendung) {
    ReadSubjectAreaGIObjectsMetaData readDocumentGIObjectsMetaData =
        objectFactory.createReadSubjectAreaGIObjectsMetaData();
    readDocumentGIObjectsMetaData.setObjaddress(objaddress);
    readDocumentGIObjectsMetaData.setDocstate(docstate);
    readDocumentGIObjectsMetaData.setBostate(bostate);
    readDocumentGIObjectsMetaData.setUserlogin(userlogin);
    readDocumentGIObjectsMetaData.setJobposition(rolle);
    readDocumentGIObjectsMetaData.setJoboe(organisationseinheit);
    readDocumentGIObjectsMetaData.setBusinessapp(anwendung);
    return readDocumentGIObjectsMetaData;
  }
}

package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadProcedureGIObjectsMetaData;
import de.muenchen.dms.common.processor.AbstractDMSSoapProcessor;
import de.muenchen.dms.common.route.QueryProperties;
import de.muenchen.dms.common.route.RouteConstants;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ReadProcedureObjectsMetaDataProcessor extends AbstractDMSSoapProcessor {
    @Override
    public void process(Exchange exchange) throws Exception {
        final String objaddress = exchange.getIn().getHeader(RouteConstants.PATH_PARAM_OBJADDRESS, String.class);
        final Integer docstate = exchange.getIn().getHeader(QueryProperties.PROPERTY_DOCSTATE, Integer.class);
        final String bostate = exchange.getIn().getHeader(QueryProperties.PROPERTY_BOSTATE, String.class);

        final ReadProcedureGIObjectsMetaData parameter =
                readProcedureGIObjectsMetaData(
                        objaddress,
                        docstate,
                        bostate,
                        getNutzer(exchange),
                        getOrganisationseinheit(exchange),
                        getRolle(exchange),
                        getAnwendung(exchange));
        setParameters(exchange, parameter, ReadProcedureGIObjectsMetaData.class);
    }

    private ReadProcedureGIObjectsMetaData readProcedureGIObjectsMetaData(
            final String objaddress,
            final Integer docstate,
            final String bostate,
            final String userlogin,
            final String joboe,
            final String jobposition,
            final String businessapp) {
        ReadProcedureGIObjectsMetaData readProcedureGIObjectsMetaData =
                objectFactory.createReadProcedureGIObjectsMetaData();
        readProcedureGIObjectsMetaData.setObjaddress(objaddress);
        readProcedureGIObjectsMetaData.setDocstate(docstate);
        readProcedureGIObjectsMetaData.setBostate(bostate);
        readProcedureGIObjectsMetaData.setUserlogin(userlogin);
        readProcedureGIObjectsMetaData.setJobposition(jobposition);
        readProcedureGIObjectsMetaData.setJoboe(joboe);
        readProcedureGIObjectsMetaData.setBusinessapp(businessapp);
        return readProcedureGIObjectsMetaData;
    }
}

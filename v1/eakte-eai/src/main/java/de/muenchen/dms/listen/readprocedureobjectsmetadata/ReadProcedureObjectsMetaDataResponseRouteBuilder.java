package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import de.muenchen.dms.common.route.DmsResponseRouteBuilder;
import de.muenchen.dms.common.route.RouteConstants;
import de.muenchen.dms.common.route.auth.DmsAuthorizationProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReadProcedureObjectsMetaDataResponseRouteBuilder extends DmsResponseRouteBuilder {

    private final ReadProcedureObjectsMetaDataProcessor requestProcessor;
    private final ReadProcedureObjectsMetaDataResponseProcessor responseProcessor;

    public ReadProcedureObjectsMetaDataResponseRouteBuilder(
            DmsAuthorizationProcessor authorizationProcessor,
            ReadProcedureObjectsMetaDataProcessor requestProcessor,
            ReadProcedureObjectsMetaDataResponseProcessor responseProcessor) {
        super(authorizationProcessor);
        this.requestProcessor = requestProcessor;
        this.responseProcessor = responseProcessor;
    }

    @Override
    public void route() throws Exception {
        soap(RouteConstants.DIRECT_READ_PROCEDURE_OBJECTS_META_DATA)
                .request(requestProcessor)
                .response(responseProcessor);
    }
}

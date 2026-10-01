package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadProcedureGIObjectsMetaDataResponse;
import de.muenchen.dms.common.processor.AbstractResponseProcessor;
import de.muenchen.dms.common.util.Umwandlungen;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ReadProcedureObjectsMetaDataResponseProcessor extends AbstractResponseProcessor {
    @Override
    public void process(Exchange exchange) throws Exception {
        final ReadProcedureGIObjectsMetaDataResponse response =
                exchange.getIn().getBody(ReadProcedureGIObjectsMetaDataResponse.class);

        final ReadProcedureObjectsMetaDataResponseDTO objectResponse =
                ReadProcedureObjectsMetaDataResponseDTO.builder()
                        .businessobjecttype(
                                Umwandlungen.wandleBusinessObjectTypeZuBusinessObjectReference(
                                        response.getBusinessobjecttype()
                                )
                        )
                        .build();
        checkResponse(exchange, response.getStatus(), response.getErrormessage(), objectResponse);
    }
}

package de.muenchen.dms.listen.readsubjectareaobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadSubjectAreaGIObjectsMetaDataResponse;
import de.muenchen.dms.common.processor.AbstractResponseProcessor;
import de.muenchen.dms.common.util.Umwandlungen;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReadSubjectAreaObjectsMetaDataResponseProcessor extends AbstractResponseProcessor {
  @Override
  public void process(Exchange exchange) throws Exception {
    ReadSubjectAreaGIObjectsMetaDataResponse response =
        exchange.getIn().getBody(ReadSubjectAreaGIObjectsMetaDataResponse.class);

    final ReadSubjectAreaObjectsMetaDataResponseDTO objectResponse =
        ReadSubjectAreaObjectsMetaDataResponseDTO.builder()
            .businessobjecttype(
                Umwandlungen.wandleBusinessObjectTypeZuBusinessObjectReference(
                    response.getBusinessobjecttype()))
            .build();
    checkResponse(exchange, response.getStatus(), response.getErrormessage(), objectResponse);
  }
}

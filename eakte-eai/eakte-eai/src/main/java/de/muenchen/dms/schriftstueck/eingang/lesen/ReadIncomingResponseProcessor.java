package de.muenchen.dms.schriftstueck.eingang.lesen;

import static de.muenchen.dms.common.util.Umwandlungen.wandleZuOffsetDateTime;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ArrayOfLHMBAI151700GIMetadataType;
import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadIncomingGIResponse;
import de.muenchen.dms.common.model.MetadataReferenz;
import de.muenchen.dms.common.processor.AbstractResponseProcessor;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReadIncomingResponseProcessor extends AbstractResponseProcessor {
  @Override
  public void process(Exchange exchange) throws Exception {
    final ReadIncomingGIResponse response = exchange.getIn().getBody(ReadIncomingGIResponse.class);
    final de.muenchen.dms.schriftstueck.eingang.lesen.ReadIncomingAntwortDTO objectResponse =
        wandleReadIncomingGIZuAkteDTO(response);
    checkResponse(exchange, response.getStatus(), response.getErrormessage(), objectResponse);
  }

  public static de.muenchen.dms.schriftstueck.eingang.lesen.ReadIncomingAntwortDTO
      wandleReadIncomingGIZuAkteDTO(final ReadIncomingGIResponse response) {
    return de.muenchen.dms.schriftstueck.eingang.lesen.ReadIncomingAntwortDTO.builderReadIncoming()
        .objname(response.getObjname())
        .referrednumber(response.getReferrednumber())
        .shortname(response.getShortname())
        .foreignnr(response.getForeignnr())
        .delivery(wandleZuOffsetDateTime(response.getDelivery()))
        .filesubj(response.getFilesubj())
        .documentremarks(response.getDocumentremarks())
        .incattachments(response.getIncattachments())
        .objterms(response.getObjterms())
        .gimetadatatype(wandleGiMetadataTypeZuMetadataReferenzen(response.getGimetadatatype()))
        .accdef(response.getAccdef())
        .build();
  }

  public static List<MetadataReferenz> wandleGiMetadataTypeZuMetadataReferenzen(
      ArrayOfLHMBAI151700GIMetadataType soapArray) {
    List<MetadataReferenz> metadatareferenzen = new ArrayList<>();

    if (soapArray != null && soapArray.getLHMBAI151700GIMetadataType() != null) {
      for (var objectType : soapArray.getLHMBAI151700GIMetadataType()) {
        metadatareferenzen.add(
            MetadataReferenz.builder()
                .objaddress(objectType.getLHMBAI151700Objaddress())
                .filename(objectType.getLHMBAI151700Filename())
                .fileextension(objectType.getLHMBAI151700Fileextension())
                .objclass(objectType.getLHMBAI151700Objclass())
                .contsize(objectType.getLHMBAI151700Contsize())
                .objcreatedby(objectType.getLHMBAI151700Objcreatedby())
                .objcreatedat(objectType.getLHMBAI151700Objcreatedat())
                .objchangedby(objectType.getLHMBAI151700Objchangedby())
                .objmodifiedat(objectType.getLHMBAI151700Objmodifiedat())
                .build());
      }
    }
    return metadatareferenzen;
  }
}

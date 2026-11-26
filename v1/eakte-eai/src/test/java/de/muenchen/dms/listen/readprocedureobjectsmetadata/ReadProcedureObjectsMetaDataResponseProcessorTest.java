package de.muenchen.dms.listen.readprocedureobjectsmetadata;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ArrayOfLHMBAI151700BusinessObjectType;
import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ReadProcedureGIObjectsMetaDataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.muenchen.dms.common.model.BusinessObjectReference;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static de.muenchen.dms.common.TestBeispielErzeuger.erzeugeBeispielBusinessObjectTypeReferenz;
import static de.muenchen.dms.common.TestBeispielErzeuger.erzeugeBeispielListBusinessObjectTypeReferenz;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadProcedureObjectsMetaDataResponseProcessorTest {
    private static final int NO_ERROR_CODE = 0;

    private ReadProcedureObjectsMetaDataResponseProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new ReadProcedureObjectsMetaDataResponseProcessor();
    }

    @Test
    void testeErgebnisOhneFehlermeldung() throws Exception {
        Exchange exchange = erzeugeExchangeObjekt(erzeugeDmsAntwortOhneFehler());

        processor.process(exchange);

        pruefeEAIAnwort(exchange);
    }

    private Exchange erzeugeExchangeObjekt(ReadProcedureGIObjectsMetaDataResponse response) {
        CamelContext context = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(context);
        exchange.getIn().setBody(response);
        return exchange;
    }

    private ReadProcedureGIObjectsMetaDataResponse erzeugeDmsAntwortOhneFehler() {
        ReadProcedureGIObjectsMetaDataResponse response = new ReadProcedureGIObjectsMetaDataResponse();
        response.setStatus(NO_ERROR_CODE);
        response.setErrormessage(null);

        ArrayOfLHMBAI151700BusinessObjectType listObjectType;
        listObjectType =
                erzeugeBeispielListBusinessObjectTypeReferenz(
                        erzeugeBeispielBusinessObjectTypeReferenz(
                                "0002 A20 10.1.1-1",
                                "COO.1.2301.1.1357",
                                null,
                                null,
                                null,
                                null,
                                null,
                                "Mustermann, Max",
                                "SG A1 0001 (Sachgebiet A1 0001)",
                                null,
                                null));
        response.setBusinessobjecttype(listObjectType);
        return response;
    }

    private void pruefeEAIAnwort(Exchange exchange) throws IOException {
        String body = exchange.getIn().getBody(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ReadProcedureObjectsMetaDataResponseDTO antwort =
                mapper.createParser(body).readValueAs(ReadProcedureObjectsMetaDataResponseDTO.class);

        assertThat(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE), is(HttpStatus.OK.value()));
        assertEquals(antwort.getBusinessobjecttype(), erzeugeBeispielObjectReferenz());
    }

    private List<BusinessObjectReference> erzeugeBeispielObjectReferenz() {
        return Collections.singletonList(
                BusinessObjectReference.builder()
                        .objname("0002 A20 10.1.1-1")
                        .objaddress("COO.1.2301.1.1357")
                        .objclass(null)
                        .objcreatedat(null)
                        .objcreatedby(null)
                        .objmodifiedat(null)
                        .objchangedby(null)
                        .objowner("Mustermann, Max")
                        .objou("SG A1 0001 (Sachgebiet A1 0001)")
                        .fileextension(null)
                        .contsize(null)
                        .build());
    }

}

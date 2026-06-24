package de.muenchen.dms.signature.set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.SetSignatureObjectGI;
import de.muenchen.dms.test.TestExchanges;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@DisplayName("Tests the Request Processor for the Endpoint SetSignature")
class SetSignatureProcessorTest {

  @Autowired
  private SetSignatureProcessor processor;

  @BeforeEach
  void setUp() {}

  @Test
  void setSignatureProcessorTest() throws Exception {
    SetSignatureRequestDTO dto = SetSignatureDTOBeispiel.erzeugeSetSignature();
    Exchange exchange = prozessorAusfuehren(dto);

    //TODO: outsource this block to own method
    if (exchange.getIn().getBody() instanceof SetSignatureObjectGI gi) {
      stelleDatentransferAufSoapObjektSicher(dto, gi);
      assertThat(gi.getSignaturetype(), equalTo("COO.15.1400.1.28131"));
    } else {
      Assertions.fail();
    }
  }

  @Test
  void setSignatureProcessorOptionaleWerteNull() throws Exception {
    SetSignatureRequestDTO dto = new SetSignatureRequestDTO();
    Exchange exchange = prozessorAusfuehren(dto);

    //TODO: outsource this block to own method
    if (exchange.getIn().getBody() instanceof SetSignatureObjectGI gi) {
      stelleDatentransferAufSoapObjektSicher(dto, gi);
      assertThat(gi.getSignaturetype(), equalTo(null));
    } else {
      Assertions.fail();
    }
  }

  private Exchange prozessorAusfuehren(SetSignatureRequestDTO dto) throws Exception {
    CamelContext ctx = new DefaultCamelContext();
    Exchange exchange =
        TestExchanges.erzeuge(ctx, dto, SetSignatureRequestDTO.class, SetSignatureObjectGI.class);
    processor.process(exchange);
    return exchange;
  }

  private void stelleDatentransferAufSoapObjektSicher(SetSignatureRequestDTO dto, Object message) {
    if (message instanceof SetSignatureObjectGI gi) {
      assertThat(gi.getUserlogin(), equalTo(TestExchanges.getNutzer()));
      assertThat(gi.getBusinessapp(), equalTo(TestExchanges.getAnwendung()));
      assertThat(gi.getJoboe(), equalTo(TestExchanges.getOrganisationseinheit()));
      assertThat(gi.getJobposition(), equalTo(TestExchanges.getStelle()));
      assertThat(gi.getRemark(), equalTo(dto.getRemark()));
    } else {
      Assertions.fail(message.toString());
    }
  }
}

/* * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik
 * der Landeshauptstadt München, 2023*/

package de.muenchen.dms.akte.anlegen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.CreateFileGI;
import de.muenchen.dms.akte.AkteBasisDTO;
import de.muenchen.dms.common.mapper.FieldValueMappingService;
import de.muenchen.dms.common.util.JacksonData;
import de.muenchen.dms.test.TestExchanges;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Diese Testklasse prüft die Entgegennahme von REST-Anfragen zur Anlage von Akten")
class CreateFileProcessorTest {

  @Autowired
  CreateFileProcessor processor;

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName(
      """
           Prüfe, ob ein gültiges, vollständig gefülltes Rest-Datenobjekt in ein Datenobjekt
           für einen SOAP-Call ohne Fehler umgewandelt werden kann.
           """)
  void testeKonvertierungInSOAPObjektAlleWerteVorhanden() throws Exception {
    CreateFileDTO dto = TestAkteAnlegenBeispiel.erzeugeFehlerlosMitUmlauten();
    Exchange ex = prozessorAusfuehren(dto);

    if (ex.getIn().getBody() instanceof CreateFileGI gi){
      stelleDatentransferAufSoapObjektSicher(dto, gi);
      assertThat(gi.getAccdef(), equalTo("Eigener Mandant"));
    } else {
      Assertions.fail();
    }
  }

  @Test
  @DisplayName(
      """
               Prüfe, ob ein gültiges, nur mit den nötigsten Felder belegtes Rest-Datenobjekt in
               ein SOAP-Objekt umgewandelt werden kann.
               """)
  void testeKonvertierungInSOAPObjektOptionaleWerteNull() throws Exception {
    CreateFileDTO dto = new CreateFileDTO();
    Exchange ex = prozessorAusfuehren(dto);

    if (ex.getIn().getBody() instanceof CreateFileGI gi){
      stelleDatentransferAufSoapObjektSicher(dto, gi);
      assertThat(gi.getAccdef(), equalTo(null));
    } else {
      Assertions.fail();
    }
  }

  private Exchange prozessorAusfuehren(AkteBasisDTO dto) throws Exception {
    CamelContext ctx = new DefaultCamelContext();
    Exchange ex = TestExchanges.erzeuge(ctx, dto, AkteBasisDTO.class, CreateFileGI.class);
    processor.process(ex);
    return ex;
  }

  private void stelleDatentransferAufSoapObjektSicher(AkteBasisDTO dto, Object message)
      throws DatatypeConfigurationException {
    if (message instanceof CreateFileGI gi) {
      assertThat(gi.getUserlogin(), equalTo(TestExchanges.getNutzer()));
      assertThat(gi.getBusinessapp(), equalTo(TestExchanges.getAnwendung()));
      assertThat(gi.getShortname(), equalTo(dto.getShortname()));
      assertThat(gi.getFileouobj(), equalTo(dto.getFileouobj()));
      assertThat(gi.getFilesubj(), equalTo(dto.getFilesubj()));
      assertThat(gi.getProcedureaccdef(), equalTo(dto.getProcedureaccdef()));
      assertThat(gi.getObjterms(), equalTo(dto.getObjterms()));
      assertThat(
          gi.getFileruntimefrom(),
          equalTo(JacksonData.toXMLGregorianCalendar(dto.getFileruntimefrom())));
      assertThat(
          gi.getFileruntimetill(),
          equalTo(JacksonData.toXMLGregorianCalendar(dto.getFileruntimetill())));
      assertThat(gi.getJobposition(), equalTo(TestExchanges.getStelle()));
      assertThat(gi.getJoboe(), equalTo(TestExchanges.getOrganisationseinheit()));
    }
  }
}

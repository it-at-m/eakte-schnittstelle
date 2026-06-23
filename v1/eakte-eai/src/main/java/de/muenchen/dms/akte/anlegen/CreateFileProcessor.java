/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik
 * der Landeshauptstadt München, 2023
 */
package de.muenchen.dms.akte.anlegen;

import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.ArrayOfLHMBAI151700GIUserFormsType;
import com.fabasoft.schemas.websvc.lhmbai_15_1700_giwsd.CreateFileGI;
import com.fasterxml.jackson.core.JsonProcessingException;
import de.muenchen.dms.common.mapper.FieldValueMappingService;
import de.muenchen.dms.common.processor.AbstractDMSSoapProcessor;
import de.muenchen.dms.common.util.JacksonData;
import de.muenchen.dms.common.util.Umwandlungen;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CreateFileProcessor extends AbstractDMSSoapProcessor {

  private final FieldValueMappingService mappingService;

    public CreateFileProcessor(FieldValueMappingService mappingService) {
        this.mappingService = mappingService;
    }


    @Override
  public void process(Exchange exchange)
      throws JsonProcessingException, DatatypeConfigurationException {
    final CreateFileDTO anfrage = exchange.getIn().getBody(CreateFileDTO.class);

    ArrayOfLHMBAI151700GIUserFormsType userFormsType =
        Umwandlungen.wandleUserFormsGIZuUserFormsReferenz(anfrage.getUserformsdata());

    // Create SOAP input.
    final CreateFileGI parameters =
        createCreateFileGI(
            anfrage,
            getNutzer(exchange),
            getOrganisationseinheit(exchange),
            getRolle(exchange),
            getAnwendung(exchange),
            userFormsType);
    setParameters(exchange, parameters, CreateFileGI.class);
  }

  private CreateFileGI createCreateFileGI(
      final CreateFileDTO anfrage,
      final String nutzer,
      final String organisationseinheit,
      final String rolle,
      final String anwendung,
      final ArrayOfLHMBAI151700GIUserFormsType userFormsType)
      throws DatatypeConfigurationException {
    String mappedAccdef = mappingService.map(
            "accdef", anfrage.getAccdef()
    );
    String mappedProcedureaccdef = mappingService.map(
            "accdef", anfrage.getProcedureaccdef()
    );
    final CreateFileGI createFileGI = objectFactory.createCreateFileGI();
    createFileGI.setUserlogin(nutzer);
    createFileGI.setBusinessapp(anwendung);
    createFileGI.setApentry(anfrage.getApentry());
    createFileGI.setShortname(anfrage.getShortname());
    createFileGI.setFilesubj(anfrage.getFilesubj());
    createFileGI.setAccdef(mappedAccdef);
    createFileGI.setObjterms(anfrage.getObjterms());
    createFileGI.setFileouobj(anfrage.getFileouobj());
    createFileGI.setProcedureaccdef(mappedProcedureaccdef);
    createFileGI.setFileruntimefrom(
        JacksonData.toXMLGregorianCalendar(anfrage.getFileruntimefrom()));
    createFileGI.setFileruntimetill(
        JacksonData.toXMLGregorianCalendar(anfrage.getFileruntimetill()));
    createFileGI.setJoboe(organisationseinheit);
    createFileGI.setJobposition(rolle);
    createFileGI.setDefinition(anfrage.getDefinition());
    createFileGI.setUserformsdata(userFormsType);
    return createFileGI;
  }
}

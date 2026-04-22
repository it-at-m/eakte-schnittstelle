package de.muenchen.dms.schriftstueck.eingang.lesen;

import de.muenchen.dms.common.model.DMSContainer;
import de.muenchen.dms.common.model.MetadataReferenz;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadIncomingAntwortDTO extends DMSContainer {

  @Builder(builderMethodName = "builderReadIncoming")
  public ReadIncomingAntwortDTO(
      String objname,
      String referrednumber,
      String shortname,
      OffsetDateTime delivery,
      String foreignnr,
      String filesubj,
      String documentremarks,
      String incattachments,
      String searchalso,
      String objterms,
      List<MetadataReferenz> gimetadatatype,
      String accdef,
      String businessapp) {
    super(shortname, filesubj, objterms, accdef);
    this.objname = objname;
    this.referrednumber = referrednumber;
    this.foreignnr = foreignnr;
    this.delivery = delivery;
    this.documentremarks = documentremarks;
    this.incattachments = incattachments;
    this.gimetadatatype = gimetadatatype;
    this.searchalso = searchalso;
    this.businessapp = businessapp;
  }

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Eingangskennzeichen",
      example =
          "Eingangspost vom 21.10.2016 (0010 A20 011-4-0006-0001)")
  private String objname;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Objekt-ID (COO-Adresse) der zugehörigen Vorgangs",
      example = "COO.1.2301.1.1042432")
  private String referrednumber;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Fremdes Geschäftszeichen",
      example = "A2016-10-2016-Landeshauptstadt-München")
  private String foreignnr;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Termin (Datum/Uhrzeit)",
      example = "2016-10-26T18:16:29+01:00")
  private OffsetDateTime delivery;

  @Schema(
          requiredMode = Schema.RequiredMode.NOT_REQUIRED,
          description = "Dokumentbezogene Hinweise",
          example = "Antrag auf Baugenehmigung")
  private String documentremarks;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Sonstige Anlagen",
      example = "Ausfüllhilfe Antrag auf Baugenehmigung")
  private String incattachments;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Schriftstücke",
      example =
          """
              {
                  "objaddress": "COO.1.2301.1.1041875",
                  "filename": "Antrag auf Baugenehmigung",
                  "fileextension": "pdf",
                  "objclass": "PDF-Dokument",
                  "contsize": "243",
                  "objcreatedby": {
                    "string": [
                      "musterfraum"
                    ]
                  },
                  "objcreatedat": "2018-07-23T08:59:52+01:00",
                  "objchangedby": {
                    "string": [
                      "mustermannm"
                    ]
                  },
                  "objmodifiedat": "2018-07-23T09:23:52+01:00"
                }""")
  private List<MetadataReferenz> gimetadatatype;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Keine Funktion",
      example = "Bescheide Firma Mustermann 2015")
  private String searchalso;

  @Schema(
      requiredMode = Schema.RequiredMode.NOT_REQUIRED,
      description = "Businessapp",
      example = "businessapp")
  private String businessapp;

  public static ReadIncomingAntwortDTO sample() {
    return ReadIncomingAntwortDTO.builderReadIncoming()
        .objname(
            "Eingangspost vom 21.10.2016 (0010 A20 011-4-0006-0001)")
        .referrednumber("COO.1.2301.1.1042432")
        .shortname("Eingangspost vom 21.10.2016")
        .foreignnr("A2016-10-2016-Landeshauptstadt-München")
        .delivery(OffsetDateTime.now().withNano(0))
        .filesubj("Anfrage Firma Mustermann bezüglich Baugenehmigung")
        .documentremarks("Antrag auf Baugenehmigung")
        .incattachments("Bebauungsplan")
        .objterms("Firma XY; Anträge; Anträge 2016")
        .gimetadatatype(erzeugeBeispielMetadataReferenz())
        .accdef("Zugriffsdefinition für Schriftgutobjekte (allgemein lesbar)")
        .build();
  }

  public static List<MetadataReferenz> erzeugeBeispielMetadataReferenz() {
    XMLGregorianCalendar date = null;
    return Collections.singletonList(
        MetadataReferenz.builder()
            .objaddress("COO.1.2301.1.1041875")
            .filename("FileName A")
            .fileextension("pdf")
            .objclass("PDF-Dokument")
            .contsize("1024")
            .objcreatedby(null)
            .objcreatedat(date)
            .objchangedby(null)
            .objmodifiedat(date)
            .build());
  }
}

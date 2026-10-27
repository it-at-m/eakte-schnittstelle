package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.InternesDokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftInternesDokumentMapperTest {
    private static final String DOKUMENT_ID = "coo";

    private final FabasoftAttributeMapper attributeMapper = new FabasoftAttributeMapperImpl();
    private final FabasoftInternesDokumentMapper mapper = new FabasoftInternesDokumentMapper(
            attributeMapper,
            new FabasoftDokumentMapper(attributeMapper));

    @Test
    void givenResultObject_thenMapInternesDokument() {
        final InternesDokumentResponse mapped = mapper.toDomain(resultWithAttributes());

        assertEquals(DOKUMENT_ID, mapped.getId());
        assertEquals(DokumentKlasse.INTERN, mapped.getKlasse());
        assertEquals("vorgang", mapped.getVorgangId());
        assertEquals("name", mapped.getName());
        assertEquals("long name", mapped.getLangname());
        assertEquals("subject", mapped.getBetreff());
        assertEquals("access", mapped.getZugriffsdefinition());
        assertEquals("ou", mapped.getOrganisationseinheit());
        assertEquals(LocalDate.of(2025, 1, 2), mapped.getZustellungsDatum());
        assertEquals("letter", mapped.getDokumententyp());
        assertEquals("additional enclosure", mapped.getAnlagenBeschreibung());
        assertEquals("note", mapped.getHinweis());
        assertEquals(List.of(new Attribute("custom", "value")), mapped.getWeitereEigenschaften());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = resultWithAttributes();

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    private static ResultObject resultWithAttributes() {
        return new ResultObject("long name", DOKUMENT_ID, List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:InternalFile"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.HINWEIS, "note"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(InternesDokumentAttribute.ZUSTELLUNGSDATUM, LocalDate.of(2025, 1, 2)),
                attribute(InternesDokumentAttribute.DOKUMENTENTYP, "letter"),
                attribute(InternesDokumentAttribute.ANLAGEN_BESCHREIBUNG, "additional enclosure"),
                new FabasoftAttribute(AttributeType.STRING, "custom", null, "value")));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }

    private static FabasoftAttribute attribute(final InternesDokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

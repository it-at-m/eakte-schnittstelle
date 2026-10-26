package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ErledigungAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftErledigungMapperTest {
    private final FabasoftAttributeMapper attributeMapper = new FabasoftAttributeMapperImpl();
    private final FabasoftErledigungMapper mapper = new FabasoftErledigungMapper(
            attributeMapper,
            new FabasoftDokumentMapper(attributeMapper));

    @Test
    void givenResultObject_thenMapErledigung() {
        final ResultObject result = resultWithAttributes();

        final ErledigungResponse mapped = mapper.toDomain(result);

        assertEquals("coo", mapped.getId());
        assertEquals(DokumentKlasse.ERLEDIGUNG, mapped.getKlasse());
        assertEquals("vorgang", mapped.getVorgangId());
        assertEquals("name", mapped.getName());
        assertEquals("long name", mapped.getLangname());
        assertEquals("subject", mapped.getBetreff());
        assertEquals("access", mapped.getZugriffsdefinition());
        assertEquals("ou", mapped.getOrganisationseinheit());
        assertEquals("incoming-id", mapped.getBezugEingangsdokument());
        assertEquals("letter", mapped.getDokumententyp());
        assertEquals("enclosures", mapped.getAnlagenBeschreibung());
        assertEquals(List.of(new Attribute("custom", "value")), mapped.getWeitereEigenschaften());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = resultWithAttributes();

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    private static ResultObject resultWithAttributes() {
        return new ResultObject("long name", "coo", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Outgoing"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(ErledigungAttribute.BEZUG_EINGANGSDOKUMENT, "incoming-id"),
                attribute(ErledigungAttribute.DOKUMENTENTYP, "letter"),
                attribute(ErledigungAttribute.ANLAGEN_BESCHREIBUNG, "enclosures"),
                new FabasoftAttribute(AttributeType.STRING, "custom", null, "value")));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }

    private static FabasoftAttribute attribute(final ErledigungAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

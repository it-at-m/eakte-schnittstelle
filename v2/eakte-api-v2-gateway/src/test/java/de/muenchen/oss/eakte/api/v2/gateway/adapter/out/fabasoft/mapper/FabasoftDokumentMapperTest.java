package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftDokumentMapperTest {
    private final FabasoftDokumentMapper mapper = new FabasoftDokumentMapper(new FabasoftAttributeMapperImpl());

    @Test
    void givenResultObject_thenMapDokument() {
        final ResultObject result = new ResultObject("long name", "coo", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Outgoing"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                new FabasoftAttribute(AttributeType.STRING, "custom", null, "value")));

        final DokumentResponse mapped = mapper.toDomain(result);

        assertEquals("coo", mapped.getId());
        assertEquals(DokumentKlasse.ERLEDIGUNG, mapped.getKlasse());
        assertEquals("vorgang", mapped.getVorgangId());
        assertEquals("name", mapped.getName());
        assertEquals("long name", mapped.getLangname());
        assertEquals("subject", mapped.getBetreff());
        assertEquals("access", mapped.getZugriffsdefinition());
        assertEquals("ou", mapped.getOrganisationseinheit());
        assertEquals(List.of(new Attribute("custom", "value")), mapped.getWeitereEigenschaften());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = new ResultObject("name", "id", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Incoming"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou")));

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final String value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

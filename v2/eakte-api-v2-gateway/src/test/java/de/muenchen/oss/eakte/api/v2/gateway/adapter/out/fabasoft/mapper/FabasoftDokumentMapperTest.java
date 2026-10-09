package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentParent;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftDokumentMapperTest {
    private final FabasoftDokumentMapper mapper = new FabasoftDokumentMapper(new AttributeMapper());

    @Test
    void givenResultObject_thenMapDokument() {
        final ResultObject result = new ResultObject("long name", "coo", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Outgoing"),
                attribute(DokumentAttribute.PARENT_ID, "parent"),
                attribute(DokumentAttribute.PARENT_TYPE, "DEPRECONFIG@15.1001:Procedure"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                new FabasoftAttribute(AttributeType.STRING, "custom", null, "value")));

        final DokumentResponse mapped = mapper.toDomain(result);

        assertEquals("coo", mapped.id());
        assertEquals(DokumentKlasse.ERLEDIGUNG, mapped.klasse());
        assertEquals(DokumentParent.VORGANG, mapped.parent().type());
        assertEquals("parent", mapped.parent().id());
        assertEquals("name", mapped.name());
        assertEquals("long name", mapped.langname());
        assertEquals("subject", mapped.betreff());
        assertEquals("access", mapped.zugriffsdefinition());
        assertEquals("ou", mapped.organisationseinheit());
        assertEquals(List.of(new Attribute("custom", "value")), mapped.weitereEigenschaften());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = new ResultObject("name", "id", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Incoming"),
                attribute(DokumentAttribute.PARENT_ID, "parent"),
                attribute(DokumentAttribute.PARENT_TYPE, "DEPRECONFIG@15.1001:Procedure"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou")));

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final String value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

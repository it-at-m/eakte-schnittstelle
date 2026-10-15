package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangStatus;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FabasoftVorgangMapperTest {
    private final FabasoftVorgangMapper mapper = new FabasoftVorgangMapper(new AttributeMapper());

    @Test
    void givenResultObject_thenMapVorgang() {
        final ResultObject result = new ResultObject("long name", "coo", List.of(
                attribute(VorgangAttribute.PARENT_ID, "akte"),
                attribute(VorgangAttribute.NAME, "name"),
                attribute(VorgangAttribute.BETREFF, "subject"),
                attribute(VorgangAttribute.STATUS, BigInteger.valueOf(30)),
                attribute(VorgangAttribute.BEARBEITUNGSSTATUS, "processing"),
                attribute(VorgangAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(VorgangAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(VorgangAttribute.ORIGINAL_MEDIUM, BigInteger.valueOf(2)),
                attribute(VorgangAttribute.GESCHAEFTSGANGVERMERK, "remark"),
                new FabasoftAttribute(AttributeType.STRING, "custom", null, "value")));

        final VorgangResponse mapped = mapper.toDomain(result);

        assertEquals("coo", mapped.id());
        assertEquals("akte", mapped.akteId());
        assertEquals("name", mapped.name());
        assertEquals("long name", mapped.langname());
        assertEquals("subject", mapped.betreff());
        assertEquals("remark", mapped.geschaeftsgangvermerk());
        assertEquals(VorgangMedium.PAPIER, mapped.originalMedium());
        assertEquals(VorgangStatus.ABGESCHLOSSEN, mapped.status());
        assertEquals("processing", mapped.bearbeitungsstatus());
        assertEquals("access", mapped.zugriffsdefinition());
        assertEquals("ou", mapped.organisationseinheit());
        assertEquals(List.of(new Attribute("custom", "value")), mapped.weitereEigenschaften());
    }

    @Test
    void givenResults_thenMapEachResult() {
        final ResultObject result = resultWithRequiredAttributes();

        assertEquals(List.of(mapper.toDomain(result)), mapper.toDomain(List.of(result)));
    }

    @Test
    void givenMediumCode_thenMapMedium() {
        assertEquals(VorgangMedium.HYBRID, mapper.mapMedium(Map.of(
                VorgangAttribute.ORIGINAL_MEDIUM.getReference(), List.of(BigInteger.valueOf(3)))));
    }

    @Test
    void givenStatusCode_thenMapStatus() {
        assertEquals(VorgangStatus.ARCHIVIERT, mapper.mapStatus(Map.of(
                VorgangAttribute.STATUS.getReference(), List.of(BigInteger.valueOf(50)))));
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("name", "id", List.of(
                attribute(VorgangAttribute.NAME, "name"),
                attribute(VorgangAttribute.STATUS, BigInteger.TEN),
                attribute(VorgangAttribute.BEARBEITUNGSSTATUS, "processing"),
                attribute(VorgangAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(VorgangAttribute.ORIGINAL_MEDIUM, BigInteger.ONE)));
    }

    private static FabasoftAttribute attribute(final VorgangAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

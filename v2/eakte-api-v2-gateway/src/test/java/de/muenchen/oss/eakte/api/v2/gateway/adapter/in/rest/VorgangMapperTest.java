package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BEARBEITUNGSSTATUS;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BETREFF;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.GESCHAEFTSGANGVERMERK;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORGANISATIONSEINHEIT;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.SCHLAGWORTE_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.STATUS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VorgangMapperTest {
    private static final BigInteger INDEX = BigInteger.ONE;
    private VorgangMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new VorgangMapper(new AttributeMapper());
    }

    @Test
    void givenCompleteResult_thenMapAllFieldsAndExcludeDefaultAttributes() {
        final Vorgang result = mapper.mapResult(resultWithAttributes(true));

        assertEquals("COO.1.2.3", result.getId());
        assertEquals("procedure-name", result.getLangname());
        assertEquals("short-name", result.getName());
        assertEquals("file-id", result.getSachakteId());
        assertEquals("subject", result.getBetreff().orElseThrow());
        assertEquals(List.of("keyword"), result.getSchlagworte());
        assertEquals("note", result.getGeschaeftsgangvermerk().orElseThrow());
        assertEquals(Vorgang.OriginalMediumEnum.ELEKTRONISCH, result.getOriginalMedium());
        assertEquals("1", result.getStatus());
        assertEquals("processing", result.getBearbeitungsstatus());
        assertEquals("acl", result.getAcl());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals(Map.of("custom.attribute_1", "custom-value"), result.getEigenschaftenMap());
        assertEquals("custom.attribute", result.getEigenschaftenListe().getFirst().getReference());
    }

    @Test
    void givenMissingOptionalAttributes_thenUseOptionalDefaults() {
        final Vorgang result = mapper.mapResult(resultWithAttributes(false));

        assertEquals(List.of(), result.getSchlagworte());
        assertEquals(java.util.Optional.empty(), result.getBetreff());
        assertEquals(java.util.Optional.empty(), result.getGeschaeftsgangvermerk());
    }

    @Test
    void givenMissingRequiredAttribute_thenThrowException() {
        final ResultObject result = new ResultObject(
                "procedure-name", "COO.1.2.3", List.of());

        assertThrows(java.util.NoSuchElementException.class, () -> mapper.mapResult(result));
    }

    @Nested
    class MapMedium {
        @Test
        void givenPaperValue_thenMapPaper() {
            assertEquals(Vorgang.OriginalMediumEnum.PAPIER, mapMedium(2));
        }

        @Test
        void givenHybridValue_thenMapHybrid() {
            assertEquals(Vorgang.OriginalMediumEnum.HYBRID, mapMedium(3));
        }

        @Test
        void givenUnknownValue_thenReturnNull() {
            assertNull(mapMedium(4));
        }

        private Vorgang.OriginalMediumEnum mapMedium(final int value) {
            return mapper.mapMedium(Map.of(ORIGINAL_MEDIUM.getReference(), List.of(BigInteger.valueOf(value))));
        }
    }

    private ResultObject resultWithAttributes(final boolean optionalAttributes) {
        final List<Attribute> attributes = new java.util.ArrayList<>(List.of(
                new Attribute(AttributeType.STRING, PARENT_ID.getReference(), INDEX, "file-id"),
                new Attribute(AttributeType.STRING, NAME.getReference(), INDEX, "short-name"),
                new Attribute(AttributeType.ENUM, STATUS.getReference(), INDEX, BigInteger.ONE),
                new Attribute(AttributeType.STRING, BEARBEITUNGSSTATUS.getReference(), INDEX, "processing"),
                new Attribute(AttributeType.STRING, ACL.getReference(), INDEX, "acl"),
                new Attribute(AttributeType.STRING, ORGANISATIONSEINHEIT.getReference(), INDEX, "ou"),
                new Attribute(AttributeType.ENUM, ORIGINAL_MEDIUM.getReference(), INDEX, BigInteger.ONE),
                new Attribute(AttributeType.STRING, "custom.attribute", INDEX, "custom-value")));
        if (optionalAttributes) {
            attributes.add(new Attribute(AttributeType.STRING, BETREFF.getReference(), INDEX, "subject"));
            attributes.add(new Attribute(AttributeType.STRING, SCHLAGWORTE_NAME.getReference(), INDEX, "keyword"));
            attributes.add(new Attribute(AttributeType.STRING, GESCHAEFTSGANGVERMERK.getReference(), INDEX, "note"));
        }
        return new ResultObject("procedure-name", "COO.1.2.3", attributes);
    }
}

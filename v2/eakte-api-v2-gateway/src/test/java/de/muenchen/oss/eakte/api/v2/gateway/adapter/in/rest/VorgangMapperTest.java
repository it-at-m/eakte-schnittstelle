package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.KEYWORDS_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.OE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PROCESSING_STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PROCESS_NOTE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SHORTNAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.EnumAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
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
        assertEquals(Vorgang.OriginalMediumEnum.ELEKTRONISCH, result.getOriginalMedium().orElseThrow());
        assertEquals("1", result.getStatus());
        assertEquals("processing", result.getBearbeitungsstatus().orElseThrow());
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
        final SearchResult.ResultObject result = new SearchResult.ResultObject(
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

    private SearchResult.ResultObject resultWithAttributes(final boolean optionalAttributes) {
        final List<de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute<?>> attributes = new java.util.ArrayList<>(List.of(
                new StringAttribute(PARENT_ID.getReference(), INDEX, "file-id"),
                new StringAttribute(SHORTNAME.getReference(), INDEX, "short-name"),
                new EnumAttribute(STATE.getReference(), INDEX, BigInteger.ONE),
                new StringAttribute(PROCESSING_STATE.getReference(), INDEX, "processing"),
                new StringAttribute(ACL.getReference(), INDEX, "acl"),
                new StringAttribute(OE.getReference(), INDEX, "ou"),
                new EnumAttribute(ORIGINAL_MEDIUM.getReference(), INDEX, BigInteger.ONE),
                new StringAttribute("custom.attribute", INDEX, "custom-value")));
        if (optionalAttributes) {
            attributes.add(new StringAttribute(SUBJECT.getReference(), INDEX, "subject"));
            attributes.add(new StringAttribute(KEYWORDS_NAME.getReference(), INDEX, "keyword"));
            attributes.add(new StringAttribute(PROCESS_NOTE.getReference(), INDEX, "note"));
        }
        return new SearchResult.ResultObject("procedure-name", "COO.1.2.3", attributes);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.BETREFF;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.KLASSE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.ORGANISATIONSEINHEIT;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute.PARENT_TYPE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentClass.EINGANG;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentClass.ERLEDIGUNG;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentClass.INTERN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Dokument;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ParentReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DokumentMapperTest {
    private static final BigInteger INDEX = BigInteger.ONE;
    private static final String PARENT_TYPE_REFERENCE = "DEPRECONFIG@15.1001:Procedure";

    private DokumentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new DokumentMapper(new AttributeMapper());
    }

    @Test
    void givenCompleteResult_thenMapAllFieldsAndExcludeDefaultAttributes() {
        final Dokument result = mapper.mapResult(resultWithAttributes(true));

        assertEquals("COO.1.2.3", result.getId());
        assertEquals("document-name", result.getLangname());
        assertEquals(Dokument.KlasseEnum.EINGANG, result.getKlasse());
        assertEquals(new ParentReference().id("parent-id").type(ParentReference.TypeEnum.VORGANG), result.getParent());
        assertEquals("short-name", result.getName());
        assertEquals("subject", result.getBetreff().orElseThrow());
        assertEquals("acl", result.getAcl());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals(Map.of("custom.attribute_1", "custom-value"), result.getEigenschaftenMap());
        assertEquals("custom.attribute", result.getEigenschaftenListe().getFirst().getReference());
    }

    @Test
    void givenMissingOptionalAttributes_thenUseOptionalDefaults() {
        final Dokument result = mapper.mapResult(resultWithAttributes(false));

        assertEquals(Optional.empty(), result.getBetreff());
    }

    @Test
    void givenMissingRequiredAttribute_thenThrowException() {
        final ResultObject result = new ResultObject("document-name", "COO.1.2.3", List.of());

        assertThrows(java.util.NoSuchElementException.class, () -> mapper.mapResult(result));
    }

    @Test
    void givenAllKnownDocumentClasses_thenMapClasses() {
        assertEquals(Dokument.KlasseEnum.EINGANG, mapper.mapKlasse(Map.of(KLASSE.getReference(),
                List.of(EINGANG.getReference()))));
        assertEquals(Dokument.KlasseEnum.ERLEDIGUNG, mapper.mapKlasse(Map.of(KLASSE.getReference(),
                List.of(ERLEDIGUNG.getReference()))));
        assertEquals(Dokument.KlasseEnum.INTERN, mapper.mapKlasse(Map.of(KLASSE.getReference(),
                List.of(INTERN.getReference()))));
    }

    private ResultObject resultWithAttributes(final boolean optionalAttributes) {
        final List<Attribute> attributes = new ArrayList<>(List.of(
                new Attribute(AttributeType.STRING, KLASSE.getReference(), INDEX,
                        EINGANG.getReference()),
                new Attribute(AttributeType.STRING, PARENT_ID.getReference(), INDEX, "parent-id"),
                new Attribute(AttributeType.STRING, PARENT_TYPE.getReference(), INDEX, PARENT_TYPE_REFERENCE),
                new Attribute(AttributeType.STRING, NAME.getReference(), INDEX, "short-name"),
                new Attribute(AttributeType.STRING, ACL.getReference(), INDEX, "acl"),
                new Attribute(AttributeType.STRING, ORGANISATIONSEINHEIT.getReference(), INDEX, "ou"),
                new Attribute(AttributeType.STRING, "custom.attribute", INDEX, "custom-value")));
        if (optionalAttributes) {
            attributes.add(new Attribute(AttributeType.STRING, BETREFF.getReference(), INDEX, "subject"));
        }
        return new ResultObject("document-name", "COO.1.2.3", attributes);
    }
}

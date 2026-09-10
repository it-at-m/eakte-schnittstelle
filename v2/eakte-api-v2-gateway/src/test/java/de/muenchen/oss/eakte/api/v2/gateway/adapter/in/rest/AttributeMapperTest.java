package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AttributeMapperTest {
    private static final String REFERENCE = "reference";
    private AttributeMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new AttributeMapper();
    }

    @Test
    void givenAttributesAndExcludedReferences_thenMapAndListExcludeReferences() {
        final List<StringAttribute> attributes = List.of(
                new StringAttribute(REFERENCE, BigInteger.ZERO, "included"),
                new StringAttribute("excluded", BigInteger.ZERO, "ignored"));

        assertEquals(Map.of("reference_0", "included"), mapper.toMap(List.copyOf(attributes), Set.of("excluded")));
        assertEquals("reference", mapper.toList(List.copyOf(attributes), Set.of("excluded")).getFirst().getReference());
        assertEquals("included", mapper.toList(List.copyOf(attributes), Set.of("excluded")).getFirst().getValue());
    }

    @Test
    void givenAttributesWithSameReference_thenGroupValuesByReference() {
        final List<StringAttribute> attributes = List.of(
                new StringAttribute(REFERENCE, BigInteger.ZERO, "first"),
                new StringAttribute(REFERENCE, BigInteger.ONE, "second"));

        assertEquals(Map.of(REFERENCE, List.of("first", "second")), mapper.toReferenceValueMap(List.copyOf(attributes)));
    }

    @Nested
    class GetTypedSingle {
        @Test
        void givenOneMatchingValue_thenReturnValue() {
            final Map<String, List<Object>> values = Map.of(REFERENCE, List.of("value"));

            assertEquals("value", mapper.getTypedSingle(values, REFERENCE, String.class).orElseThrow());
        }

        @Test
        void givenMissingOrEmptyValue_thenReturnEmpty() {
            assertEquals(java.util.Optional.empty(), mapper.getTypedSingle(Map.of(), REFERENCE, String.class));
            assertEquals(java.util.Optional.empty(), mapper.getTypedSingle(Map.of(REFERENCE, List.of()), REFERENCE, String.class));
        }

        @Test
        void givenMultipleOrWrongTypedValues_thenThrowException() {
            assertThrows(IllegalStateException.class,
                    () -> mapper.getTypedSingle(Map.of(REFERENCE, List.of("first", "second")), REFERENCE, String.class));
            assertThrows(IllegalArgumentException.class,
                    () -> mapper.getTypedSingle(Map.of(REFERENCE, List.of(1)), REFERENCE, String.class));
        }
    }

    @Test
    void givenTypedListWithWrongFirstValue_thenThrowException() {
        final Map<String, List<Object>> values = Map.of(REFERENCE, List.of(1, 2));

        assertThrows(IllegalArgumentException.class, () -> mapper.getTypedList(values, REFERENCE, String.class));
    }
}

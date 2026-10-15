package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AttributeMapperTest {
    private final AttributeMapper mapper = new AttributeMapper();

    @Test
    void givenFabasoftAttribute_thenMapToDomain() {
        final Attribute result = mapper.toDomain(new FabasoftAttribute(AttributeType.STRING, "ref", null, "value"));

        assertEquals(new Attribute("ref", "value"), result);
    }

    @Test
    void givenExcludedReference_thenExcludeAttribute() {
        final List<Attribute> result = mapper.toDomain(List.of(
                new FabasoftAttribute(AttributeType.STRING, "included", null, "one"),
                new FabasoftAttribute(AttributeType.STRING, "excluded", null, "two")), Set.of("excluded"));

        assertEquals(List.of(new Attribute("included", "one")), result);
    }

    @Test
    void givenRepeatedReferences_thenGroupValues() {
        final Map<String, List<Object>> result = mapper.toReferenceValueMap(List.of(
                new FabasoftAttribute(AttributeType.STRING, "ref", BigInteger.ONE, "one"),
                new FabasoftAttribute(AttributeType.STRING, "ref", BigInteger.TWO, "two")));

        assertEquals(Map.of("ref", List.of("one", "two")), result);
    }

    @Nested
    class GetTypedSingleTests {
        @Test
        void givenMissingKey_thenReturnEmpty() {
            assertEquals(java.util.Optional.empty(), mapper.getTypedSingle(Map.of(), "missing", String.class));
        }

        @Test
        void givenSingleValueOfExpectedType_thenReturnValue() {
            assertEquals(java.util.Optional.of("value"), mapper.getTypedSingle(Map.of("key", List.of("value")), "key", String.class));
        }

        @Test
        void givenMultipleValues_thenThrowIllegalStateException() {
            assertThrows(IllegalStateException.class,
                    () -> mapper.getTypedSingle(Map.of("key", List.of("one", "two")), "key", String.class));
        }

        @Test
        void givenValueOfUnexpectedType_thenThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class,
                    () -> mapper.getTypedSingle(Map.of("key", List.of(1)), "key", String.class));
        }
    }
}

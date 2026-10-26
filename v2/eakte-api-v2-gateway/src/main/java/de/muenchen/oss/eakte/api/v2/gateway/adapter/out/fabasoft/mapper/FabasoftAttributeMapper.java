package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper
public abstract class FabasoftAttributeMapper {
    public abstract FabasoftObjectType fromDomain(ObjectType objectType);

    protected List<Attribute> toDomain(final List<FabasoftAttribute> attributes, final Set<String> exclude) {
        return attributes.stream()
                .filter(i -> !exclude.contains(i.reference()))
                .map(this::toDomain).toList();
    }

    protected Attribute toDomain(final FabasoftAttribute attribute) {
        return new Attribute(attribute.reference(), attribute.value());
    }

    /**
     * Map attributes to a Map where the key is the {@link FabasoftAttribute#reference()}
     * and the value is the {@link FabasoftAttribute#value()}.
     * <p>
     * See {@link #getTypedSingle} for extracting typed arguments.
     *
     * @param attributes The list of attributes to map.
     * @return The mapped attributes.
     */
    protected Map<String, List<Object>> toReferenceValueMap(
            final List<FabasoftAttribute> attributes) {
        return attributes.stream()
                // map to multi value map
                .collect(Collectors.groupingBy(FabasoftAttribute::reference,
                        Collectors.mapping(FabasoftAttribute::value, Collectors.toList())));
    }

    /**
     * Extracts the typed value for a given key of an attribute map {@link #toReferenceValueMap}.
     *
     * @param valueMap The attribute map.
     * @param key The key to get the value for.
     * @param type The type the value needs to have.
     * @return The value of the key.
     * @throws IllegalArgumentException If the type doesn't match the value.
     * @throws IllegalStateException If there are multiple values for the given key.
     */
    protected <T> Optional<T> getTypedSingle(
            final Map<String, List<Object>> valueMap,
            final String key,
            final Class<T> type) {
        final List<Object> values = valueMap.get(key);
        if (values == null || values.isEmpty()) {
            return Optional.empty();
        }
        if (values.size() > 1) {
            throw new IllegalStateException("Multiple values for expected single value received for key: %s".formatted(key));
        }
        final Object value = values.getFirst();
        if (!type.isInstance(value)) {
            throw new IllegalArgumentException(
                    "Value type mismatch for key: %s. Expected %s but got %s"
                            .formatted(key, type.getName(), value.getClass().getName()));
        }
        return Optional.of(type.cast(value));
    }
}

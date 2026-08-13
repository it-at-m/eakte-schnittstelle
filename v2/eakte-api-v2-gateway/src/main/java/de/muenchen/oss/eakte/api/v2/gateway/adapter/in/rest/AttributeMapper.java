package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributEintrag;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

@Mapper
abstract class AttributeMapper {
    protected Map<String, Object> mapAttributMap(final List<Attribute<?>> attributes) {
        return attributes.stream().collect(Collectors.toMap(
                i -> String.format("%s_%s", i.getReference(), i.getIndex()),
                Attribute::getValue));
    }

    protected abstract List<AttributEintrag> mapAttributEintragListe(List<Attribute<?>> attributes);

    protected AttributEintrag mapAttributEintrag(final Attribute<?> attribute) {
        return new AttributEintrag(attribute.getReference(), attribute.getValue());
    }

    /**
     * Map attributes to a Map where the key is the {@link Attribute#getReference()}
     * and the value is the {@link Attribute#getValue()} while only containing references
     * which are unique in the attributes (references occurring multiple times are filtered out).
     * <p>
     * See {@link #getTyped} for extracting typed arguments.
     *
     * @param attributes The list of attributes to map.
     * @return The mapped attributes.
     */
    protected Map<String, Object> toUniqueReferenceValueMap(
            final List<Attribute<?>> attributes) {
        return attributes.stream()
                // map to multi value map
                .collect(Collectors.groupingBy(Attribute::getReference,
                        Collectors.mapping(i -> i, Collectors.toList())))
                // filter for references which only exist once (are unique)
                .entrySet().stream().filter(i -> i.getValue().size() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, i -> i.getValue().getFirst().getValue()));
    }

    /**
     * Extracts the typed value for a given key of an attribute map {@link #toUniqueReferenceValueMap}.
     *
     * @param valueMap The attribute map.
     * @param key The key to get the value for.
     * @param type The type the value needs to have.
     * @return The value of the key.
     * @throws IllegalArgumentException If the type doesn't match the value.
     */
    protected <T> Optional<T> getTyped(
            final Map<String, Object> valueMap,
            final String key,
            final Class<T> type) {

        final Object value = valueMap.get(key);
        if (value == null) {
            return Optional.empty();
        }
        if (!type.isInstance(value)) {
            throw new IllegalArgumentException(
                    "Value type mismatch for key: %s. Expected %s but got %s"
                            .formatted(key, type.getName(), value.getClass().getName()));
        }
        return Optional.of(type.cast(value));
    }

}

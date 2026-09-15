package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
class AttributeMapper {
    protected Map<String, Object> toMap(final List<Attribute<?>> attributes, final Set<String> exclude) {
        return attributes.stream()
                .filter(i -> !exclude.contains(i.getReference()))
                .collect(Collectors.toMap(
                        i -> String.format("%s_%s", i.getReference(), i.getIndex()),
                        Attribute::getValue));
    }

    protected List<EigenschaftEintrag> toList(final List<Attribute<?>> attributes, final Set<String> exclude) {
        return attributes.stream()
                .filter(i -> !exclude.contains(i.getReference()))
                .map(this::toListEntry).toList();
    }

    protected EigenschaftEintrag toListEntry(final Attribute<?> attribute) {
        return new EigenschaftEintrag(attribute.getReference(), attribute.getValue());
    }

    /**
     * Map attributes to a Map where the key is the {@link Attribute#getReference()}
     * and the value is the {@link Attribute#getValue()}.
     * <p>
     * See {@link #getTypedSingle} for extracting typed arguments.
     *
     * @param attributes The list of attributes to map.
     * @return The mapped attributes.
     */
    protected Map<String, List<Object>> toReferenceValueMap(
            final List<Attribute<?>> attributes) {
        return attributes.stream()
                // map to multi value map
                .collect(Collectors.groupingBy(Attribute::getReference,
                        Collectors.mapping(Attribute::getValue, Collectors.toList())));
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

    /**
     * Extracts a list of a typed value for a given key of an attribute map
     * {@link #toReferenceValueMap}.
     *
     * @param valueMap The attribute map.
     * @param key The key to get the values for.
     * @param type The type the values needs to have (Only first is validated).
     * @return The value of the key.
     * @throws IllegalArgumentException If the type doesn't match the first value.
     */
    protected <T> Optional<List<T>> getTypedList(
            final Map<String, List<Object>> valueMap,
            final String key,
            final Class<T> type) {
        final List<Object> values = valueMap.get(key);
        if (values == null || values.isEmpty()) {
            return Optional.empty();
        }
        if (!type.isInstance(values.getFirst())) {
            throw new IllegalArgumentException(
                    "Value type mismatch for key: %s. Expected %s but got %s"
                            .formatted(key, type.getName(), values.getFirst().getClass().getName()));
        }
        @SuppressWarnings("unchecked")
        final List<T> typedValues = (List<T>) values;
        return Optional.of(typedValues);
    }
}

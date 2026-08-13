package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAggregatstyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributAufzaehlungstyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBase64EncodedContent;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributBoolescherWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatenTyp;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatum;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatumMitUhrzeit;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributEintrag;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributFliesskommazahl;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributGanzzahl;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributUriUndWert;
import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributZeichenkette;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.AggregateAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.BooleanAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.ContentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.DateAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.DatetimeAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.EnumAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.FloatAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.IntegerAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.ObjectAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class AttributeMapper {
    private final Base64.Encoder b64Encoder = Base64.getEncoder();

    Map<String, Object> mapAttributMap(final List<Attribute<?>> attributes) {
        return attributes.stream().collect(Collectors.toMap(
                i -> String.format("%s_%s", i.getReference(), i.getIndex()),
                Attribute::getValue));
    }

    abstract List<AttributEintrag> mapAttributEintragListe(List<Attribute<?>> attributes);

    AttributEintrag mapAttributEintrag(final Attribute<?> attribute) {
        return new AttributEintrag(attribute.getReference(), attribute.getValue());
    }

    abstract List<AttributUriUndWert> mapAttributUriUndWertListe(List<Attribute<?>> attributes);

    AttributUriUndWert mapAttributUriUndWert(final Attribute<?> attribute) {
        return switch (attribute) {
        case StringAttribute i -> mapString(i);
        case BooleanAttribute i -> mapBoolean(i);
        case FloatAttribute i -> mapFloat(i);
        case IntegerAttribute i -> mapInt(i);
        case DateAttribute i -> mapDate(i);
        case DatetimeAttribute i -> mapDatetime(i);
        case EnumAttribute i -> mapEnum(i);
        case ContentAttribute i -> mapContent(i);
        case ObjectAttribute i -> mapObject(i);
        case AggregateAttribute i -> mapAggregate(i);
        default -> throw new IllegalStateException("No response mapper for %s implemented".formatted(attribute.getClass()));
        };
    }

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributZeichenkette mapString(StringAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributBoolescherWert mapBoolean(BooleanAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributFliesskommazahl mapFloat(FloatAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributGanzzahl mapInt(IntegerAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributDatum mapDate(DateAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributDatumMitUhrzeit mapDatetime(DatetimeAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributAufzaehlungstyp mapEnum(EnumAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributBase64EncodedContent mapContent(ContentAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributZeichenkette mapObject(ObjectAttribute attribute);

    @Mapping(source = "value", target = "attributWert")
    @Mapping(source = "reference", target = "attributURI")
    @Mapping(source = "fabasoftType", target = "datenTyp")
    abstract AttributAggregatstyp mapAggregate(AggregateAttribute attribute);

    String mapB64(byte[] data) {
        return b64Encoder.encodeToString(data);
    }

    String mapType(AttributeType type) {
        return switch (type) {
        case STRING -> AttributDatenTyp.ZEICHENKETTE.getValue();
        case BOOLEAN -> AttributDatenTyp.BOOLESCHER_WERT.getValue();
        case INTEGER -> AttributDatenTyp.GANZZAHL.getValue();
        case FLOAT -> AttributDatenTyp.FLIESSKOMMAZAHL.getValue();
        case DATE -> AttributDatenTyp.DATUM.getValue();
        case DATETIME -> AttributDatenTyp.DATUM_MIT_UHRZEIT.getValue();
        case ENUM -> AttributDatenTyp.AUFZAEHLUNGSTYP.getValue();
        case CONTENT -> AttributDatenTyp.BASE64_ENCODED_CONTENT.getValue();
        // TODO correctly map object
        case OBJECT -> AttributDatenTyp.ZEICHENKETTE.getValue();
        case AGGREGATE -> AttributDatenTyp.AGGREGATSTYP.getValue();
        };
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
    public Map<String, Object> toUniqueReferenceValueMap(
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
    public <T> Optional<T> getTyped(
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

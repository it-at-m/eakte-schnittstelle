package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import com.fabasoft.schemas.universal.BooleanType;
import com.fabasoft.schemas.universal.ContentType;
import com.fabasoft.schemas.universal.DateTimeType;
import com.fabasoft.schemas.universal.DateType;
import com.fabasoft.schemas.universal.EnumType;
import com.fabasoft.schemas.universal.FloatType;
import com.fabasoft.schemas.universal.IntegerType;
import com.fabasoft.schemas.universal.ObjectPointerType;
import com.fabasoft.schemas.universal.ObjectType;
import com.fabasoft.schemas.universal.StringType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

@Component
public class AttributeMapper {
    protected List<Attribute> toDomain(final List<FabasoftAttribute> attributes, final Set<String> exclude) {
        return attributes.stream()
                .filter(i -> !exclude.contains(i.reference()))
                .map(this::toDomain).toList();
    }

    protected Attribute toDomain(final FabasoftAttribute attribute) {
        return new Attribute(attribute.reference(), attribute.value());
    }

    public ObjectType fromFabasoftAttribute(final List<FabasoftAttribute> attributes) {
        final ObjectType objectType = new ObjectType();
        for (final FabasoftAttribute attribute : attributes) {
            switch (attribute.fabasoftType()) {
                case STRING -> objectType.getSTRING().add(mapString(attribute));
                case BOOLEAN -> objectType.getBOOLEAN().add(mapBoolean(attribute));
                case INTEGER -> objectType.getINTEGER().add(mapInt(attribute));
                case FLOAT -> objectType.getFLOAT().add(mapFloat(attribute));
                case DATE -> objectType.getDATE().add(mapDate(attribute));
                case DATETIME -> objectType.getDATETIME().add(mapDatetime(attribute));
                case ENUM -> objectType.getENUM().add(mapEnum(attribute));
                case CONTENT -> objectType.getCONTENT().add(mapContent(attribute));
                case OBJECT -> objectType.getOBJECT().add(mapObject(attribute));
                // TODO aggregate
                case AGGREGATE -> throw new IllegalStateException("Not implemented");
            }
        }
        return objectType;
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

    private StringType mapString(final FabasoftAttribute type) {
        final StringType stringType = new StringType();
        stringType.setReference(type.reference());
        stringType.setValue((String) type.value());
        return stringType;
    }

    private BooleanType mapBoolean(FabasoftAttribute type) {
        final BooleanType stringType = new BooleanType();
        stringType.setReference(type.reference());
        stringType.setValue((Boolean) type.value());
        return stringType;
    }

    private FloatType mapFloat(FabasoftAttribute type) {
        final FloatType stringType = new FloatType();
        stringType.setReference(type.reference());
        stringType.setValue((Float) type.value());
        return stringType;
    }

    private IntegerType mapInt(FabasoftAttribute type) {
        final IntegerType stringType = new IntegerType();
        stringType.setReference(type.reference());
        stringType.setValue(BigInteger.valueOf((Integer) type.value()));
        return stringType;
    }

    private DateType mapDate(FabasoftAttribute type) {
        final DateType stringType = new DateType();
        stringType.setReference(type.reference());
        final LocalDate date = (LocalDate) type.value();
        try {
            stringType.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString()));
        } catch (final DatatypeConfigurationException e) {
            // TODO
            throw new RuntimeException(e);
        }
        return stringType;
    }

    private DateTimeType mapDatetime(FabasoftAttribute type) {
        final DateTimeType stringType = new DateTimeType();
        stringType.setReference(type.reference());
        final OffsetDateTime dateTime = (OffsetDateTime) type.value();
        try {
            stringType.setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime.toString()));
        } catch (final DatatypeConfigurationException e) {
            // TODO
            throw new RuntimeException(e);
        }
        return stringType;
    }

    private EnumType mapEnum(FabasoftAttribute type) {
        final EnumType stringType = new EnumType();
        stringType.setReference(type.reference());
        stringType.setValue((BigInteger) type.value());
        return stringType;
    }

    private ContentType mapContent(FabasoftAttribute type) {
        final ContentType stringType = new ContentType();
        stringType.setReference(type.reference());
        stringType.setValue((byte[]) type.value());
        return stringType;
    }

    private ObjectPointerType mapObject(FabasoftAttribute type) {
        final ObjectPointerType stringType = new ObjectPointerType();
        stringType.setReference(type.reference());
        stringType.setValue((String) type.value());
        return stringType;
    }
}

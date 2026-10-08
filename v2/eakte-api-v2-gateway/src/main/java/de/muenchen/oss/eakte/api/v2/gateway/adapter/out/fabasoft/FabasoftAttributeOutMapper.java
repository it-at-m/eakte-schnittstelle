package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

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
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Component
class FabasoftAttributeOutMapper {

    @SuppressWarnings("PMD.CyclomaticComplexity")
    protected ObjectType fromAttributes(final List<Attribute> attributes) {
        final ObjectType objectType = new ObjectType();
        for (final Attribute attribute : attributes) {
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

    private StringType mapString(final Attribute type) {
        final StringType stringType = new StringType();
        stringType.setReference(type.reference());
        stringType.setValue((String) type.value());
        return stringType;
    }

    private BooleanType mapBoolean(Attribute type) {
        final BooleanType stringType = new BooleanType();
        stringType.setReference(type.reference());
        stringType.setValue((Boolean) type.value());
        return stringType;
    }

    private FloatType mapFloat(Attribute type) {
        final FloatType stringType = new FloatType();
        stringType.setReference(type.reference());
        stringType.setValue((Float) type.value());
        return stringType;
    }

    private IntegerType mapInt(Attribute type) {
        final IntegerType stringType = new IntegerType();
        stringType.setReference(type.reference());
        stringType.setValue(BigInteger.valueOf((Integer) type.value()));
        return stringType;
    }

    private DateType mapDate(Attribute type) {
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

    private DateTimeType mapDatetime(Attribute type) {
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

    private EnumType mapEnum(Attribute type) {
        final EnumType stringType = new EnumType();
        stringType.setReference(type.reference());
        stringType.setValue((BigInteger) type.value());
        return stringType;
    }

    private ContentType mapContent(Attribute type) {
        final ContentType stringType = new ContentType();
        stringType.setReference(type.reference());
        stringType.setValue((byte[]) type.value());
        return stringType;
    }

    private ObjectPointerType mapObject(Attribute type) {
        final ObjectPointerType stringType = new ObjectPointerType();
        stringType.setReference(type.reference());
        stringType.setValue((String) type.value());
        return stringType;
    }
}

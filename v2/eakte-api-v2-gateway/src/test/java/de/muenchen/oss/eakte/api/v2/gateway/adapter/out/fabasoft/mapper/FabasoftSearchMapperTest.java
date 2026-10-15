package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fabasoft.schemas.bai.search.AGGREGATEType;
import com.fabasoft.schemas.bai.search.AttrListResultType;
import com.fabasoft.schemas.bai.search.BOOLEANType;
import com.fabasoft.schemas.bai.search.CONTENTType;
import com.fabasoft.schemas.bai.search.DATETIMEType;
import com.fabasoft.schemas.bai.search.DATEType;
import com.fabasoft.schemas.bai.search.ENUMType;
import com.fabasoft.schemas.bai.search.FLOATType;
import com.fabasoft.schemas.bai.search.INTEGERType;
import com.fabasoft.schemas.bai.search.OBJECTPointerType;
import com.fabasoft.schemas.bai.search.STRINGType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.jupiter.api.Test;

class FabasoftSearchMapperTest {
    private final FabasoftSearchMapper mapper = new FabasoftSearchMapperImpl();

    @Test
    void givenAllAttributeTypes_thenParseAttributes() throws Exception {
        final XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar("2026-01-02T03:04:05Z");
        final AttrListResultType attrs = new AttrListResultType();
        attrs.getSTRING().add(string("string", "text"));
        attrs.getBOOLEAN().add(booleanValue("boolean", true));
        attrs.getFLOAT().add(floatValue("float", 1.5f));
        attrs.getINTEGER().add(integerValue("integer", 42));
        attrs.getDATE().add(dateValue("date", calendar));
        attrs.getDATETIME().add(datetime("datetime", calendar));
        attrs.getENUM().add(enumValue("enum", BigInteger.ONE));
        attrs.getCONTENT().add(content("content", new byte[] { 1, 2 }));
        attrs.getOBJECT().add(object("object", "COO.1.2"));

        final List<FabasoftAttribute> result = mapper.parseAttributes(attrs);

        assertEquals(new FabasoftAttribute(AttributeType.STRING, "string", null, "text"), result.get(0));
        assertEquals(new FabasoftAttribute(AttributeType.BOOLEAN, "boolean", null, true), result.get(1));
        assertEquals(new FabasoftAttribute(AttributeType.INTEGER, "integer", null, BigInteger.valueOf(42)), result.get(2));
        assertEquals(new FabasoftAttribute(AttributeType.FLOAT, "float", null, 1.5f), result.get(3));
        assertEquals(new FabasoftAttribute(AttributeType.DATE, "date", null,
                LocalDate.of(2026, 1, 2)), result.get(4));
        assertEquals(new FabasoftAttribute(AttributeType.DATETIME, "datetime", null,
                OffsetDateTime.parse("2026-01-02T03:04:05Z")), result.get(5));
        assertEquals(new FabasoftAttribute(AttributeType.ENUM, "enum", null, BigInteger.ONE), result.get(6));
        assertArrayEquals(new byte[] { 1, 2 }, (byte[]) result.get(7).value());
        assertEquals(new FabasoftAttribute(AttributeType.OBJECT, "object", null, "COO.1.2"), result.get(8));
    }

    @Test
    void givenAggregateAttribute_thenParseNestedAttributes() {
        final AGGREGATEType aggregate = new AGGREGATEType();
        aggregate.setReference("aggregate");
        aggregate.getSTRING().add(string("nested", "value"));
        final AttrListResultType attrs = new AttrListResultType();
        attrs.getAGGREGATE().add(aggregate);

        final FabasoftAttribute result = mapper.parseAttributes(attrs).getFirst();

        assertEquals(new FabasoftAttribute(AttributeType.AGGREGATE, "aggregate", null,
                List.of(new FabasoftAttribute(AttributeType.STRING, "nested", null, "value"))), result);
    }

    private static STRINGType string(final String reference, final String value) {
        final STRINGType type = new STRINGType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static BOOLEANType booleanValue(final String reference, final boolean value) {
        final BOOLEANType type = new BOOLEANType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static FLOATType floatValue(final String reference, final float value) {
        final FLOATType type = new FLOATType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static INTEGERType integerValue(final String reference, final int value) {
        final INTEGERType type = new INTEGERType();
        type.setReference(reference);
        type.setValue(BigInteger.valueOf(value));
        return type;
    }

    private static DATEType dateValue(final String reference,
            final XMLGregorianCalendar value) {
        final DATEType type = new DATEType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static DATETIMEType datetime(final String reference, final XMLGregorianCalendar value) {
        final DATETIMEType type = new DATETIMEType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static ENUMType enumValue(final String reference, final BigInteger value) {
        final ENUMType type = new ENUMType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static CONTENTType content(final String reference, final byte[] value) {
        final CONTENTType type = new CONTENTType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }

    private static OBJECTPointerType object(final String reference, final String value) {
        final OBJECTPointerType type = new OBJECTPointerType();
        type.setReference(reference);
        type.setValue(value);
        return type;
    }
}

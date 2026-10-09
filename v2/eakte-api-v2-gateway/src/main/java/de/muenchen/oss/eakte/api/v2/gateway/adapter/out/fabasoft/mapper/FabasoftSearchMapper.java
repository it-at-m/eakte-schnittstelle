package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

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
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public abstract class FabasoftSearchMapper {
    private static final String FABASOFT_TYPE = "fabasoftType";
    public static final String VALUE = "value";

    public List<FabasoftAttribute> parseAttributes(final AttrListResultType attrs) {
        final List<FabasoftAttribute> result = new ArrayList<>();
        // STRING
        result.addAll(attrs.getSTRING().stream().map(this::mapString).toList());
        // BOOLEAN
        result.addAll(attrs.getBOOLEAN().stream().map(this::mapBoolean).toList());
        // INTEGER
        result.addAll(attrs.getINTEGER().stream().map(this::mapInt).toList());
        // FLOAT
        result.addAll(attrs.getFLOAT().stream().map(this::mapFloat).toList());
        // DATE
        result.addAll(attrs.getDATE().stream().map(this::mapDate).toList());
        // DATETIME
        result.addAll(attrs.getDATETIME().stream().map(this::mapDatetime).toList());
        // ENUM
        result.addAll(attrs.getENUM().stream().map(this::mapEnum).toList());
        // CONTENT
        result.addAll(attrs.getCONTENT().stream().map(this::mapContent).toList());
        // OBJECT
        result.addAll(attrs.getOBJECT().stream().map(this::mapObject).toList());
        // AGGREGATE
        result.addAll(attrs.getAGGREGATE().stream().map(this::mapAggregateType).toList());
        return result;
    }

    private FabasoftAttribute mapAggregateType(final AGGREGATEType aggregateType) {
        final List<FabasoftAttribute> attributes = new ArrayList<>();
        // STRING
        attributes.addAll(aggregateType.getSTRING().stream().map(this::mapString).toList());
        // BOOLEAN
        attributes.addAll(aggregateType.getBOOLEAN().stream().map(this::mapBoolean).toList());
        // INTEGER
        attributes.addAll(aggregateType.getINTEGER().stream().map(this::mapInt).toList());
        // FLOAT
        attributes.addAll(aggregateType.getFLOAT().stream().map(this::mapFloat).toList());
        // DATE
        attributes.addAll(aggregateType.getDATE().stream().map(this::mapDate).toList());
        // DATETIME
        attributes.addAll(aggregateType.getDATETIME().stream().map(this::mapDatetime).toList());
        // ENUM
        attributes.addAll(aggregateType.getENUM().stream().map(this::mapEnum).toList());
        // CONTENT
        attributes.addAll(aggregateType.getCONTENT().stream().map(this::mapContent).toList());
        // OBJECT
        attributes.addAll(aggregateType.getOBJECT().stream().map(this::mapObject).toList());
        // AGGREGATE
        attributes.addAll(aggregateType.getAGGREGATE().stream().map(this::mapAggregateType).toList());
        return new FabasoftAttribute(AttributeType.AGGREGATE, aggregateType.getReference(), aggregateType.getIndex(), attributes);
    }

    @Mapping(target = FABASOFT_TYPE, constant = "STRING")
    protected abstract FabasoftAttribute mapString(STRINGType type);

    @Mapping(target = FABASOFT_TYPE, constant = "BOOLEAN")
    protected abstract FabasoftAttribute mapBoolean(BOOLEANType type);

    @Mapping(target = FABASOFT_TYPE, constant = "FLOAT")
    protected abstract FabasoftAttribute mapFloat(FLOATType type);

    @Mapping(target = FABASOFT_TYPE, constant = "INTEGER")
    protected abstract FabasoftAttribute mapInt(INTEGERType type);

    @Mapping(target = FABASOFT_TYPE, constant = "DATE")
    @Mapping(target = VALUE, source = VALUE, qualifiedByName = "toDate")
    protected abstract FabasoftAttribute mapDate(DATEType type);

    @Mapping(target = FABASOFT_TYPE, constant = "DATETIME")
    @Mapping(target = VALUE, source = VALUE, qualifiedByName = "toDateTime")
    protected abstract FabasoftAttribute mapDatetime(DATETIMEType type);

    @Mapping(target = FABASOFT_TYPE, constant = "ENUM")
    protected abstract FabasoftAttribute mapEnum(ENUMType type);

    @Mapping(target = FABASOFT_TYPE, constant = "CONTENT")
    protected abstract FabasoftAttribute mapContent(CONTENTType type);

    @Mapping(target = FABASOFT_TYPE, constant = "OBJECT")
    protected abstract FabasoftAttribute mapObject(OBJECTPointerType type);

    @Named("toDate")
    protected LocalDate toDate(final XMLGregorianCalendar xmlGregorianCalendar) {
        return toDateTime(xmlGregorianCalendar).toLocalDate();
    }

    @Named("toDateTime")
    protected OffsetDateTime toDateTime(final XMLGregorianCalendar xmlGregorianCalendar) {
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
    }
}

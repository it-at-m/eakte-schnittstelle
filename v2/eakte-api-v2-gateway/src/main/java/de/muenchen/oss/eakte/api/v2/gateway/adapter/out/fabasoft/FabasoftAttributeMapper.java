package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import com.fabasoft.schemas.bai.search.BOOLEANType;
import com.fabasoft.schemas.bai.search.CONTENTType;
import com.fabasoft.schemas.bai.search.DATETIMEType;
import com.fabasoft.schemas.bai.search.DATEType;
import com.fabasoft.schemas.bai.search.ENUMType;
import com.fabasoft.schemas.bai.search.FLOATType;
import com.fabasoft.schemas.bai.search.INTEGERType;
import com.fabasoft.schemas.bai.search.OBJECTPointerType;
import com.fabasoft.schemas.bai.search.STRINGType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import java.time.OffsetDateTime;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class FabasoftAttributeMapper {
    private static final String FABASOFT_TYPE = "fabasoftType";

    @Mapping(target = FABASOFT_TYPE, constant = "STRING")
    protected abstract Attribute mapString(STRINGType type);

    @Mapping(target = FABASOFT_TYPE, constant = "BOOLEAN")
    protected abstract Attribute mapBoolean(BOOLEANType type);

    @Mapping(target = FABASOFT_TYPE, constant = "FLOAT")
    protected abstract Attribute mapFloat(FLOATType type);

    @Mapping(target = FABASOFT_TYPE, constant = "INTEGER")
    protected abstract Attribute mapInt(INTEGERType type);

    @Mapping(target = FABASOFT_TYPE, constant = "DATE")
    protected abstract Attribute mapDate(DATEType type);

    @Mapping(target = FABASOFT_TYPE, constant = "DATETIME")
    protected abstract Attribute mapDatetime(DATETIMEType type);

    @Mapping(target = FABASOFT_TYPE, constant = "ENUM")
    protected abstract Attribute mapEnum(ENUMType type);

    @Mapping(target = FABASOFT_TYPE, constant = "CONTENT")
    protected abstract Attribute mapContent(CONTENTType type);

    @Mapping(target = FABASOFT_TYPE, constant = "OBJECT")
    protected abstract Attribute mapObject(OBJECTPointerType type);

    protected OffsetDateTime mapGregorianCalendar(final XMLGregorianCalendar xmlGregorianCalendar) {
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
    }
}

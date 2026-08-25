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
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.BooleanAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.ContentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.DateAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.DatetimeAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.EnumAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.FloatAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.IntegerAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.ObjectAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import java.time.OffsetDateTime;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mapstruct.Mapper;

@Mapper
public abstract class FabasoftAttributeMapper {
    protected abstract StringAttribute mapString(STRINGType type);

    protected abstract BooleanAttribute mapBoolean(BOOLEANType type);

    protected abstract FloatAttribute mapFloat(FLOATType type);

    protected abstract IntegerAttribute mapInt(INTEGERType type);

    protected abstract DateAttribute mapDate(DATEType type);

    protected abstract DatetimeAttribute mapDatetime(DATETIMEType type);

    protected abstract EnumAttribute mapEnum(ENUMType type);

    protected abstract ContentAttribute mapContent(CONTENTType type);

    protected abstract ObjectAttribute mapObject(OBJECTPointerType type);

    protected OffsetDateTime mapGregorianCalendar(final XMLGregorianCalendar xmlGregorianCalendar) {
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
    }
}

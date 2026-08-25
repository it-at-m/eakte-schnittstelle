package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;
import java.time.OffsetDateTime;

public class DatetimeAttribute extends Attribute<OffsetDateTime> {
    public DatetimeAttribute(final String reference, final BigInteger index, final OffsetDateTime value) {
        super(AttributeType.DATETIME, reference, index, value);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;
import java.time.LocalDate;

public class DateAttribute extends Attribute<LocalDate> {
    public DateAttribute(final String reference, final BigInteger index, final LocalDate value) {
        super(AttributeType.DATE, reference, index, value);
    }
}

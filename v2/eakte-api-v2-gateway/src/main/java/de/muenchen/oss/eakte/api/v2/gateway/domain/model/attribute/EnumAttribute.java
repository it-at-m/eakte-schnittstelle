package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class EnumAttribute extends Attribute<BigInteger> {
    public EnumAttribute(final String reference, final BigInteger index, final BigInteger value) {
        super(AttributeType.ENUM, reference, index, value);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class IntegerAttribute extends Attribute<Integer> {
    public IntegerAttribute(final String reference, final BigInteger index, final int value) {
        super(AttributeType.INTEGER, reference, index, value);
    }
}

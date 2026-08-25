package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class BooleanAttribute extends Attribute<Boolean> {
    public BooleanAttribute(final String reference, final BigInteger index, final Boolean value) {
        super(AttributeType.BOOLEAN, reference, index, value);
    }
}

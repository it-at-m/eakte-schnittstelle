package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class FloatAttribute extends Attribute<Float> {
    public FloatAttribute(final String reference, final BigInteger index, final float value) {
        super(AttributeType.FLOAT, reference, index, value);
    }
}

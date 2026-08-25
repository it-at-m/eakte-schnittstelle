package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class ObjectAttribute extends Attribute<String> {
    public ObjectAttribute(final String reference, final BigInteger index, final String value) {
        super(AttributeType.OBJECT, reference, index, value);
    }
}

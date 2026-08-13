package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class StringAttribute extends Attribute<String> {
    public StringAttribute(final String reference, final BigInteger index, final String value) {
        super(AttributeType.STRING, reference, index, value);
    }
}

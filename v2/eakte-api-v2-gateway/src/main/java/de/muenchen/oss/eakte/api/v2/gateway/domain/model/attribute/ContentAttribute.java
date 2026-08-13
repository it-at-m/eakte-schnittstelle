package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

public class ContentAttribute extends Attribute<byte[]> {
    public ContentAttribute(final String reference, final BigInteger index, final byte[] value) {
        super(AttributeType.DATE, reference, index, value);
    }
}

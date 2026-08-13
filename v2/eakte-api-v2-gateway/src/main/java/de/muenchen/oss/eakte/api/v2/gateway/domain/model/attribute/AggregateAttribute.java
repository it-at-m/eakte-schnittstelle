package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;
import java.util.List;

public class AggregateAttribute extends Attribute<List<Attribute<?>>> {
    public AggregateAttribute(final String reference, final BigInteger index, final List<Attribute<?>> value) {
        super(AttributeType.AGGREGATE, reference, index, value);
    }
}

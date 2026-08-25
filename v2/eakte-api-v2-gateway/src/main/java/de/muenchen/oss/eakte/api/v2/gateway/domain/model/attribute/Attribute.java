package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Attribute<E> {
    private final AttributeType fabasoftType;
    @Setter
    private String reference;
    private final BigInteger index;
    private final E value;
}

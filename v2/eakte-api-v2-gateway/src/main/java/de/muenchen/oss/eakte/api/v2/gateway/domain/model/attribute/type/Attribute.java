package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

public record Attribute(
        @NotNull AttributeType fabasoftType,
        @NotBlank String reference,
        BigInteger index,
        @NotNull Object value) {
    public Attribute {
        Objects.requireNonNull(fabasoftType, "The fabasoftType of an Attribute can't be null");
        Objects.requireNonNull(value, "The value of an Attribute can't be null");
        Objects.requireNonNull(reference, "The reference of an Attribute can't be null");
        if (!fabasoftType.getJavaType().isInstance(value)) {
            throw new IllegalArgumentException("Value for " + reference + " must be of type " + fabasoftType.getJavaType().getName());
        }
    }
}

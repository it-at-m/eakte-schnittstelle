package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AttributeType {
    STRING(String.class),
    BOOLEAN(Boolean.class),
    INTEGER(Integer.class),
    FLOAT(Float.class),
    DATE(LocalDate.class),
    DATETIME(OffsetDateTime.class),
    ENUM(BigInteger.class),
    CONTENT(byte[].class),
    OBJECT(String.class),
    AGGREGATE(List.class);

    private final Class<?> javaType;
}

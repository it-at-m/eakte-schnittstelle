package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AttributeType {
    STRING,
    BOOLEAN,
    INTEGER,
    FLOAT,
    DATE,
    DATETIME,
    ENUM,
    CONTENT,
    OBJECT,
    AGGREGATE
}

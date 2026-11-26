package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.List;

public record ResultObject(
        String name,
        String coo,
        List<FabasoftAttribute> attributes) {
}

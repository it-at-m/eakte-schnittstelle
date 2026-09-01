package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class RequestContextTest {

    @Test
    void givenOptionalValues_thenMapToRequestContextFields() {
        final RequestContext context = new RequestContext(
                Optional.of("user"),
                Optional.of("ou"),
                Optional.of("role"));

        assertEquals(new RequestContext("user", "ou", "role"), context);
    }

    @Test
    void givenEmptyOptionals_thenMapToNullRequestContextFields() {
        final RequestContext context = new RequestContext(
                Optional.empty(),
                Optional.empty(),
                Optional.empty());

        assertEquals(new RequestContext((String) null, null, null), context);
    }
}

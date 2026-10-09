package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.EigenschaftEintrag;
import java.util.List;
import org.junit.jupiter.api.Test;

class AttributeMapperTest {
    private final AttributeMapper mapper = new AttributeMapperImpl();

    @Test
    void givenAttribute_thenMapReferenceAndValue() {
        final EigenschaftEintrag result = mapper.fromDomain(new Attribute("reference", "value"));

        assertEquals("reference", result.getReference());
        assertEquals("value", result.getValue());
    }

    @Test
    void givenAttributes_thenMapAllAttributes() {
        final List<EigenschaftEintrag> result = mapper.fromDomain(List.of(
                new Attribute("first", 1), new Attribute("second", true)));

        assertEquals(2, result.size());
        assertEquals(new EigenschaftEintrag("first", 1), result.getFirst());
        assertEquals(new EigenschaftEintrag("second", true), result.get(1));
    }
}

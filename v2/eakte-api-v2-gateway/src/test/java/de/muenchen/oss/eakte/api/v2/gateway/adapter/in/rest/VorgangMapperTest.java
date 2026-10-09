package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangStatus;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class VorgangMapperTest {
    private final VorgangMapper mapper = mapper();

    @Test
    void givenVorgangResponse_thenMapAllFields() {
        final VorgangResponse response = VorgangResponse.builder()
                .id("id")
                .akteId("akte")
                .name("name")
                .langname("long name")
                .betreff("subject")
                .geschaeftsgangvermerk("remark")
                .originalMedium(VorgangMedium.PAPIER)
                .status(VorgangStatus.ABGESCHLOSSEN)
                .bearbeitungsstatus("processing")
                .zugriffsdefinition("access")
                .organisationseinheit("ou")
                .weitereEigenschaften(List.of(new Attribute("custom", "value")))
                .build();

        final Vorgang result = mapper.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals("akte", result.getAkteId());
        assertEquals("name", result.getName());
        assertEquals("long name", result.getLangname());
        assertEquals("subject", result.getBetreff());
        assertEquals("remark", result.getGeschaeftsgangvermerk());
        assertEquals(Vorgang.OriginalMediumEnum.PAPIER, result.getOriginalMedium());
        assertEquals(Vorgang.StatusEnum.ABGESCHLOSSEN, result.getStatus());
        assertEquals("processing", result.getBearbeitungsstatus());
        assertEquals("access", result.getZugriffsdefinition());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals("custom", result.getWeitereEigenschaften().getFirst().getReference());
    }

    @Test
    void givenVorgangResponses_thenMapAllResponses() {
        final VorgangResponse response = VorgangResponse.builder()
                .id("id")
                .name("name")
                .langname("long name")
                .build();

        final List<Vorgang> result = mapper.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(Vorgang::getId).toList());
    }

    private static VorgangMapper mapper() {
        final VorgangMapper mapper = new VorgangMapperImpl();
        ReflectionTestUtils.setField(mapper, "attributeMapper", new AttributeMapperImpl());
        return mapper;
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ParentReference;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentParent;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Erledigung;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class ErledigungMapperTest {
    private final ErledigungMapper mapper = mapper();

    @Test
    void givenErledigungResponse_thenMapAllFields() {
        final ErledigungResponse response = ErledigungResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.ERLEDIGUNG)
                .parent(new ParentReference<>(DokumentParent.VORGANG, "parent"))
                .name("name")
                .langname("long name")
                .betreff("subject")
                .zugriffsdefinition("access")
                .organisationseinheit("ou")
                .weitereEigenschaften(List.of(new Attribute("custom", "value")))
                .bezugEingangsdokument("incoming-id")
                .dokumententypId("letter")
                .anlagenBeschreibung("enclosures")
                .build();

        final Erledigung result = mapper.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals(Erledigung.KlasseEnum.ERLEDIGUNG, result.getKlasse());
        assertEquals("parent", result.getParent().getId());
        assertEquals(de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ParentReference.TypeEnum.VORGANG,
                result.getParent().getType());
        assertEquals("name", result.getName());
        assertEquals("long name", result.getLangname());
        assertEquals("subject", result.getBetreff());
        assertEquals("access", result.getZugriffsdefinition());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals("custom", result.getWeitereEigenschaften().getFirst().getReference());
        assertEquals("incoming-id", result.getBezugEingangsdokument());
        assertEquals("letter", result.getDokumententypId());
        assertEquals("enclosures", result.getAnlagenBeschreibung());
    }

    @Test
    void givenErledigungResponses_thenMapAllResponses() {
        final ErledigungResponse response = ErledigungResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.ERLEDIGUNG)
                .build();

        final List<Erledigung> result = mapper.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(Erledigung::getId).toList());
    }

    private static ErledigungMapper mapper() {
        final ErledigungMapper mapper = new ErledigungMapperImpl();
        ReflectionTestUtils.setField(mapper, "attributeMapper", new AttributeMapperImpl());
        return mapper;
    }
}

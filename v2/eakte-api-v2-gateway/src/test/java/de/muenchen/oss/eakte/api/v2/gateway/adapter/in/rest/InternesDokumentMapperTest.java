package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.InternesDokument;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class InternesDokumentMapperTest {
    private final InternesDokumentMapper mapper = mapper();

    @Test
    void givenInternesDokumentResponse_thenMapAllFields() {
        final InternesDokumentResponse response = InternesDokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.INTERN)
                .vorgangId("vorgang")
                .name("name")
                .langname("long name")
                .betreff("subject")
                .hinweis("note")
                .zugriffsdefinition("access")
                .organisationseinheit("ou")
                .weitereEigenschaften(List.of(new Attribute("custom", "value")))
                .zustellungsDatum(LocalDate.of(2025, 1, 2))
                .dokumententyp("letter")
                .anlagenBeschreibung("additional enclosure")
                .build();

        final InternesDokument result = mapper.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals(InternesDokument.KlasseEnum.INTERN, result.getKlasse());
        assertEquals("vorgang", result.getVorgangId());
        assertEquals("name", result.getName());
        assertEquals("long name", result.getLangname());
        assertEquals("subject", result.getBetreff());
        assertEquals("note", result.getHinweis());
        assertEquals("access", result.getZugriffsdefinition());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals("custom", result.getWeitereEigenschaften().getFirst().getReference());
        assertEquals("value", result.getWeitereEigenschaften().getFirst().getValue());
        assertEquals("2025-01-02", result.getZustellungsDatum());
        assertEquals("letter", result.getDokumententyp());
        assertEquals("additional enclosure", result.getAnlagenBeschreibung());
    }

    @Test
    void givenInternesDokumentResponses_thenMapAllResponses() {
        final InternesDokumentResponse response = InternesDokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.INTERN)
                .build();

        final List<InternesDokument> result = mapper.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(InternesDokument::getId).toList());
    }

    private static InternesDokumentMapper mapper() {
        final InternesDokumentMapper mapper = new InternesDokumentMapperImpl();
        ReflectionTestUtils.setField(mapper, "attributeMapper", new AttributeMapperImpl());
        return mapper;
    }
}

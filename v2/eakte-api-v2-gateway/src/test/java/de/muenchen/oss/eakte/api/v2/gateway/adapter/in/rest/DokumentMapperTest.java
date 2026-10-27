package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Dokument;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class DokumentMapperTest {
    private final DokumentMapper mapper = mapper();

    @Test
    void givenDokumentResponse_thenMapAllFields() {
        final DokumentResponse response = DokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.ERLEDIGUNG)
                .vorgangId("vorgang")
                .name("name")
                .langname("long name")
                .betreff("subject")
                .hinweis("note")
                .zugriffsdefinition("access")
                .organisationseinheit("ou")
                .weitereEigenschaften(List.of(new Attribute("custom", "value")))
                .build();

        final Dokument result = mapper.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals(Dokument.KlasseEnum.ERLEDIGUNG, result.getKlasse());
        assertEquals("vorgang", result.getVorgangId());
        assertEquals("name", result.getName());
        assertEquals("long name", result.getLangname());
        assertEquals("subject", result.getBetreff());
        assertEquals("note", result.getHinweis());
        assertEquals("access", result.getZugriffsdefinition());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals("custom", result.getWeitereEigenschaften().getFirst().getReference());
    }

    @Test
    void givenDokumentKlasse_thenMapEnumValue() {
        assertEquals(Dokument.KlasseEnum.INTERN, mapper.fromDomain(DokumentKlasse.INTERN));
        assertEquals(Dokument.KlasseEnum.EINGANG, mapper.fromDomain(DokumentKlasse.EINGANG));
        assertEquals(Dokument.KlasseEnum.ERLEDIGUNG, mapper.fromDomain(DokumentKlasse.ERLEDIGUNG));
    }

    @Test
    void givenDokumentResponses_thenMapAllResponses() {
        final DokumentResponse response = DokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.INTERN)
                .name("name")
                .langname("long name")
                .build();

        final List<Dokument> result = mapper.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(Dokument::getId).toList());
    }

    private static DokumentMapper mapper() {
        final DokumentMapper mapper = new DokumentMapperImpl();
        ReflectionTestUtils.setField(mapper, "attributeMapper", new AttributeMapperImpl());
        return mapper;
    }
}

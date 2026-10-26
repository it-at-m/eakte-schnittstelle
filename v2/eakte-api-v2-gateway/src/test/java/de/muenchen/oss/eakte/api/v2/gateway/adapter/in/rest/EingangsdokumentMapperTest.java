package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ParentReference;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentParent;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Eingangsdokument;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class EingangsdokumentMapperTest {
    private final EingangsdokumentMapper mapper = mapper();

    @Test
    void givenEingangsdokumentResponse_thenMapAllFields() {
        final EingangsdokumentResponse response = EingangsdokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.EINGANG)
                .parent(new ParentReference<>(DokumentParent.VORGANG, "parent"))
                .name("name")
                .langname("long name")
                .betreff("subject")
                .zugriffsdefinition("access")
                .organisationseinheit("ou")
                .weitereEigenschaften(List.of(new Attribute("custom", "value")))
                .fremdesGeschaeftszeichen("reference")
                .eingangsdatum(LocalDate.of(2025, 1, 2))
                .hinweis("note")
                .build();

        final Eingangsdokument result = mapper.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals(Eingangsdokument.KlasseEnum.EINGANG, result.getKlasse());
        assertEquals("parent", result.getParent().getId());
        assertEquals(de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ParentReference.TypeEnum.VORGANG,
                result.getParent().getType());
        assertEquals("name", result.getName());
        assertEquals("long name", result.getLangname());
        assertEquals("subject", result.getBetreff());
        assertEquals("access", result.getZugriffsdefinition());
        assertEquals("ou", result.getOrganisationseinheit());
        assertEquals("custom", result.getWeitereEigenschaften().getFirst().getReference());
        assertEquals("reference", result.getFremdesGeschaeftszeichen());
        assertEquals("2025-01-02", result.getEingangsdatum());
        assertEquals("note", result.getHinweis());
    }

    @Test
    void givenEingangsdokumentResponses_thenMapAllResponses() {
        final EingangsdokumentResponse response = EingangsdokumentResponse.builder()
                .id("id")
                .klasse(DokumentKlasse.EINGANG)
                .build();

        final List<Eingangsdokument> result = mapper.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(Eingangsdokument::getId).toList());
    }

    private static EingangsdokumentMapper mapper() {
        final EingangsdokumentMapper mapper = new EingangsdokumentMapperImpl();
        ReflectionTestUtils.setField(mapper, "attributeMapper", new AttributeMapperImpl());
        return mapper;
    }
}

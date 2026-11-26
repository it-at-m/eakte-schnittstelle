package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Schriftstueck;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

class SchriftstueckMapperTest {
    private static final SchriftstueckMapper MAPPER = new SchriftstueckMapperImpl();

    @Test
    void givenSchriftstueckResponse_thenMapAllFields() {
        final SchriftstueckResponse response = SchriftstueckResponse.builder()
                .id("id")
                .dokumentId("dokument")
                .name("name")
                .betreff("subject")
                .dateiEndung("pdf")
                .dateiGroesse(BigInteger.valueOf(1234))
                .build();

        final Schriftstueck result = MAPPER.fromDomain(response);

        assertEquals("id", result.getId());
        assertEquals("dokument", result.getDokumentId());
        assertEquals("name", result.getName());
        assertEquals("subject", result.getBetreff());
        assertEquals("pdf", result.getDateiEndung());
        assertEquals(1234, result.getDateiGroesse());
    }

    @Test
    void givenSchriftstueckResponses_thenMapAllResponses() {
        final SchriftstueckResponse response = SchriftstueckResponse.builder()
                .id("id")
                .dokumentId("dokument")
                .name("name")
                .build();

        final List<Schriftstueck> result = MAPPER.fromDomain(List.of(response));

        assertEquals(List.of("id"), result.stream().map(Schriftstueck::getId).toList());
    }
}

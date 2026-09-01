package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.VorgangListeResponse;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

class VorgangControllerTest {
    private VorgangInPort vorgangInPort;
    private VorgangController controller;

    @BeforeEach
    void setUp() {
        vorgangInPort = mock(VorgangInPort.class);
        controller = new VorgangController(
                vorgangInPort,
                new VorgangMapper(Mappers.getMapper(AttributeMapper.class)));
    }

    @Nested
    class SucheVorgaenge {
        @Test
        void givenSearchParameters_thenForwardContextAndReturnMappedResults() {
            final SearchResult result = new SearchResult(List.of(new SearchResult.ResultObject(
                    "procedure-name",
                    "COO.1.2.3",
                    List.of(
                            new StringAttribute(PARENT_ID.getReference(), BigInteger.ONE, "file-id"),
                            new StringAttribute(SUBJECT.getReference(), BigInteger.ONE, "subject"),
                            new StringAttribute("custom.attribute", BigInteger.ONE, "custom-value")))));
            when(vorgangInPort.searchVorgang(any(), any(), any(), any())).thenReturn(result);

            final VorgangListeResponse response = controller.sucheVorgaenge(
                    Optional.of("login"),
                    Optional.of("role"),
                    Optional.of("ou"),
                    Optional.of("scope"),
                    Optional.of("condition"),
                    Optional.of(List.of("custom.attribute")),
                    null)
                    .getBody();

            final ArgumentCaptor<RequestContext> contextCaptor = ArgumentCaptor.forClass(RequestContext.class);
            verify(vorgangInPort).searchVorgang(
                    contextCaptor.capture(),
                    ArgumentMatchers.eq("scope"),
                    ArgumentMatchers.eq("condition"),
                    ArgumentMatchers.eq(java.util.Set.of("custom.attribute")));
            assertEquals(new RequestContext("login", "ou", "role"), contextCaptor.getValue());
            assertEquals(Optional.of(1), response.getAnzahl());
            assertEquals("COO.1.2.3", response.getElemente().getFirst().getId());
            assertEquals("file-id", response.getElemente().getFirst().getSachakteId());
            assertEquals("procedure-name", response.getElemente().getFirst().getName());
            assertEquals(Optional.of("subject"), response.getElemente().getFirst().getBetreff());
            assertEquals("custom-value",
                    response.getElemente().getFirst().getEigenschaftenMap().get("custom.attribute_1"));
        }
    }
}

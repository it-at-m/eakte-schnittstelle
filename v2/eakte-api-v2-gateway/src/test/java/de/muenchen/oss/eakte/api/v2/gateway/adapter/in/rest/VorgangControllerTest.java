package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.OE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PROCESSING_STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SHORTNAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.EnumAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.VorgangListeResponse;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

class VorgangControllerTest {
    private VorgangInPort vorgangInPort;
    private VorgangController controller;
    private RequestContextFactory contextFactory;

    @BeforeEach
    void setUp() {
        vorgangInPort = mock(VorgangInPort.class);
        contextFactory = mock(RequestContextFactory.class);
        controller = new VorgangController(
                vorgangInPort,
                new VorgangMapper(new AttributeMapper()),
                contextFactory);
    }

    @Nested
    class SucheVorgaenge {
        public static final int EXAMPLE_LIMIT = 123;

        @Test
        void givenSearchParameters_thenForwardContextAndReturnMappedResults() {
            when(contextFactory.create(eq(Optional.of("login")), eq(Optional.of("ou")), eq(Optional.of("role"))))
                    .thenReturn(new RequestContext("login", "ou", "role"));
            final SearchResult result = new SearchResult(List.of(new SearchResult.ResultObject(
                    "procedure-name",
                    "COO.1.2.3",
                    List.of(
                            new StringAttribute(PARENT_ID.getReference(), BigInteger.ZERO, "file-id"),
                            new StringAttribute(SUBJECT.getReference(), BigInteger.ZERO, "subject"),
                            new StringAttribute(SHORTNAME.getReference(), BigInteger.ZERO, "short-name"),
                            new EnumAttribute(STATE.getReference(), BigInteger.ZERO, BigInteger.ONE),
                            new StringAttribute(PROCESSING_STATE.getReference(), BigInteger.ZERO, "processing"),
                            new StringAttribute(ACL.getReference(), BigInteger.ZERO, "acl"),
                            new StringAttribute(OE.getReference(), BigInteger.ZERO, "ou"),
                            new EnumAttribute(ORIGINAL_MEDIUM.getReference(), BigInteger.ZERO, BigInteger.TWO),
                            new StringAttribute("custom.attribute", BigInteger.ZERO, "custom-value")))));
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), any())).thenReturn(result);

            final VorgangListeResponse response = controller.sucheVorgaenge(
                    Optional.of("login"),
                    Optional.of("role"),
                    Optional.of("ou"),
                    Optional.of(EXAMPLE_LIMIT),
                    Optional.of("condition"),
                    Optional.of(List.of("custom.attribute")),
                    null)
                    .getBody();

            final ArgumentCaptor<RequestContext> contextCaptor = ArgumentCaptor.forClass(RequestContext.class);
            verify(contextFactory).create(eq(Optional.of("login")), eq(Optional.of("ou")), eq(Optional.of("role")));
            verify(vorgangInPort).searchVorgang(
                    contextCaptor.capture(),
                    ArgumentMatchers.eq(EXAMPLE_LIMIT),
                    ArgumentMatchers.eq("condition"),
                    ArgumentMatchers.eq(Set.of("custom.attribute")));
            assertEquals(new RequestContext("login", "ou", "role"), contextCaptor.getValue());
            assertEquals(Optional.of(1), response.getAnzahl());
            assertEquals("COO.1.2.3", response.getElemente().getFirst().getId());
            assertEquals("file-id", response.getElemente().getFirst().getSachakteId());
            assertEquals("short-name", response.getElemente().getFirst().getName());
            assertEquals(Optional.of("subject"), response.getElemente().getFirst().getBetreff());
            assertEquals("custom-value",
                    response.getElemente().getFirst().getEigenschaftenMap().get("custom.attribute_0"));
        }

        @Test
        void givenNoClientAttributes_thenForwardNullAndReturnEmptyResponse() {
            when(contextFactory.create(eq(Optional.empty()), eq(Optional.empty()), eq(Optional.empty())))
                    .thenReturn(new RequestContext(null, null, null));
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), isNull())).thenReturn(new SearchResult(List.of()));

            final VorgangListeResponse response = controller.sucheVorgaenge(
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(EXAMPLE_LIMIT),
                    Optional.of("condition"),
                    Optional.empty(),
                    null)
                    .getBody();

            verify(contextFactory).create(eq(Optional.empty()), eq(Optional.empty()), eq(Optional.empty()));
            verify(vorgangInPort).searchVorgang(
                    new RequestContext(null, null, null),
                    EXAMPLE_LIMIT,
                    "condition",
                    null);
            assertEquals(Optional.of(0), response.getAnzahl());
            assertEquals(Collections.emptyList(), response.getElemente());
        }

        @Test
        void givenSearchFailure_thenPropagateException() {
            when(contextFactory.create(eq(Optional.of("login")), eq(Optional.of("ou")), eq(Optional.of("role"))))
                    .thenReturn(new RequestContext("login", "role", "ou"));
            final RuntimeException failure = new RuntimeException("search failed");
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), any())).thenThrow(failure);

            assertThrows(RuntimeException.class, () -> controller.sucheVorgaenge(
                    Optional.of("login"),
                    Optional.of("role"),
                    Optional.of("ou"),
                    Optional.of(EXAMPLE_LIMIT),
                    Optional.of("condition"),
                    Optional.of(List.of("custom.attribute")),
                    null));
            verify(contextFactory).create(eq(Optional.of("login")), eq(Optional.of("ou")), eq(Optional.of("role")));
        }
    }
}

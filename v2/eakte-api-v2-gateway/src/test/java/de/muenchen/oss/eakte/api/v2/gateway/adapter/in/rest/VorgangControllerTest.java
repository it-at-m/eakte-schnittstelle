package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BEARBEITUNGSSTATUS;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BETREFF;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORGANISATIONSEINHEIT;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.STATUS;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ZUGRIFFSDEFINITION;
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
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.ResourceNotFoundException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.enums.DokumentClass;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.DokumentListeResponse;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
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
        final AttributeMapper attributeMapper = new AttributeMapper();
        controller = new VorgangController(
                vorgangInPort,
                new VorgangMapper(attributeMapper),
                new DokumentMapper(attributeMapper),
                contextFactory);
    }

    @Nested
    class SucheVorgaenge {
        public static final int EXAMPLE_LIMIT = 123;

        @Test
        void givenSearchParameters_thenForwardContextAndReturnMappedResults() {
            when(contextFactory.create(eq("login"), eq("ou"), eq("role")))
                    .thenReturn(new RequestContext("login", "ou", "role"));
            final SearchResult result = new SearchResult(List.of(new ResultObject(
                    "procedure-name",
                    "COO.1.2.3",
                    List.of(
                            new Attribute(AttributeType.STRING, PARENT_ID.getReference(), BigInteger.ZERO, "file-id"),
                            new Attribute(AttributeType.STRING, BETREFF.getReference(), BigInteger.ZERO, "subject"),
                            new Attribute(AttributeType.STRING, NAME.getReference(), BigInteger.ZERO, "short-name"),
                            new Attribute(AttributeType.ENUM, STATUS.getReference(), BigInteger.ZERO, BigInteger.valueOf(10)),
                            new Attribute(AttributeType.STRING, BEARBEITUNGSSTATUS.getReference(), BigInteger.ZERO, "processing"),
                            new Attribute(AttributeType.STRING, ZUGRIFFSDEFINITION.getReference(), BigInteger.ZERO, "acl"),
                            new Attribute(AttributeType.STRING, ORGANISATIONSEINHEIT.getReference(), BigInteger.ZERO, "ou"),
                            new Attribute(AttributeType.ENUM, ORIGINAL_MEDIUM.getReference(), BigInteger.ZERO, BigInteger.TWO),
                            new Attribute(AttributeType.STRING, "custom.attribute", BigInteger.ZERO, "custom-value")))));
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), any())).thenReturn(result);

            final VorgangListeResponse response = controller.searchVorgaenge(
                    "login",
                    "role",
                    "ou",
                    EXAMPLE_LIMIT,
                    "condition",
                    List.of("custom.attribute"),
                    null)
                    .getBody();

            final ArgumentCaptor<RequestContext> contextCaptor = ArgumentCaptor.forClass(RequestContext.class);
            verify(contextFactory).create(eq("login"), eq("ou"), eq("role"));
            verify(vorgangInPort).searchVorgang(
                    contextCaptor.capture(),
                    ArgumentMatchers.eq(EXAMPLE_LIMIT),
                    ArgumentMatchers.eq("condition"),
                    ArgumentMatchers.eq(Set.of("custom.attribute")));
            assertEquals(new RequestContext("login", "ou", "role"), contextCaptor.getValue());
            assert response != null;
            assertEquals(1, response.getAnzahl());
            assertEquals("COO.1.2.3", response.getElemente().getFirst().getId());
            assertEquals("file-id", response.getElemente().getFirst().getSachakteId());
            assertEquals("short-name", response.getElemente().getFirst().getName());
            assertEquals("subject", response.getElemente().getFirst().getBetreff());
            assertEquals("custom-value",
                    response.getElemente().getFirst().getEigenschaftenMap().get("custom.attribute_0"));
        }

        @Test
        void givenNoClientAttributes_thenForwardNullAndReturnEmptyResponse() {
            when(contextFactory.create(eq(null), eq(null), eq(null)))
                    .thenReturn(new RequestContext(null, null, null));
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), isNull())).thenReturn(new SearchResult(List.of()));

            final VorgangListeResponse response = controller.searchVorgaenge(
                    null,
                    null,
                    null,
                    EXAMPLE_LIMIT,
                    "condition",
                    null,
                    null)
                    .getBody();

            verify(contextFactory).create(eq(null), eq(null), eq(null));
            verify(vorgangInPort).searchVorgang(
                    new RequestContext(null, null, null),
                    EXAMPLE_LIMIT,
                    "condition",
                    null);
            assert response != null;
            assertEquals(0, response.getAnzahl());
            assertEquals(Collections.emptyList(), response.getElemente());
        }

        @Test
        void givenSearchFailure_thenPropagateException() {
            when(contextFactory.create(eq("login"), eq("ou"), eq("role")))
                    .thenReturn(new RequestContext("login", "role", "ou"));
            final RuntimeException failure = new RuntimeException("search failed");
            when(vorgangInPort.searchVorgang(any(), anyInt(), any(), any())).thenThrow(failure);

            assertThrows(RuntimeException.class, () -> controller.searchVorgaenge(
                    "login",
                    "role",
                    "ou",
                    EXAMPLE_LIMIT,
                    "condition",
                    List.of("custom.attribute"),
                    null));
            verify(contextFactory).create(eq("login"), eq("ou"), eq("role"));
        }
    }

    @Nested
    class SucheVorgangsDokumente {
        private static final int EXAMPLE_LIMIT = 123;

        @Test
        void givenSearchParameters_thenForwardContextAndReturnMappedResults() {
            when(contextFactory.create(eq("login"), eq("ou"), eq("role")))
                    .thenReturn(new RequestContext("login", "ou", "role"));
            final SearchResult result = new SearchResult(List.of(new ResultObject(
                    "document-name",
                    "COO.2.3.4",
                    List.of(
                            new Attribute(AttributeType.STRING, DokumentAttribute.KLASSE.getReference(), BigInteger.ZERO,
                                    DokumentClass.EINGANG.getReference()),
                            new Attribute(AttributeType.STRING, DokumentAttribute.PARENT_ID.getReference(), BigInteger.ZERO, "parent-id"),
                            new Attribute(AttributeType.STRING, DokumentAttribute.PARENT_TYPE.getReference(), BigInteger.ZERO,
                                    "DEPRECONFIG@15.1001:Procedure"),
                            new Attribute(AttributeType.STRING, DokumentAttribute.NAME.getReference(), BigInteger.ZERO, "short-name"),
                            new Attribute(AttributeType.STRING, DokumentAttribute.BETREFF.getReference(), BigInteger.ZERO, "subject"),
                            new Attribute(AttributeType.STRING, DokumentAttribute.ZUGRIFFSDEFINITION.getReference(), BigInteger.ZERO, "acl"),
                            new Attribute(AttributeType.STRING, DokumentAttribute.ORGANISATIONSEINHEIT.getReference(), BigInteger.ZERO, "ou"),
                            new Attribute(AttributeType.STRING, "custom.attribute", BigInteger.ZERO, "custom-value")))));
            when(vorgangInPort.searchVorgangsDokumente(any(), any(), anyInt(), any(), any())).thenReturn(result);

            final DokumentListeResponse response = controller.searchVorgangsDokumente(
                    "vorgang-id",
                    "login",
                    "role",
                    "ou",
                    EXAMPLE_LIMIT,
                    "condition",
                    List.of("custom.attribute"),
                    null)
                    .getBody();

            verify(vorgangInPort).searchVorgangsDokumente(
                    new RequestContext("login", "ou", "role"),
                    "vorgang-id",
                    EXAMPLE_LIMIT,
                    "condition",
                    Set.of("custom.attribute"));
            assert response != null;
            assertEquals(1, response.getAnzahl());
            assertEquals("COO.2.3.4", response.getElemente().getFirst().getId());
            assertEquals("parent-id", response.getElemente().getFirst().getParent().getId());
            assertEquals("custom-value", response.getElemente().getFirst().getEigenschaftenMap().get("custom.attribute_0"));
        }

        @Test
        void givenNoClientAttributes_thenForwardNullAndReturnEmptyResponse() {
            when(contextFactory.create(eq(null), eq(null), eq(null)))
                    .thenReturn(new RequestContext(null, null, null));
            when(vorgangInPort.searchVorgangsDokumente(any(), any(), anyInt(), any(), isNull()))
                    .thenReturn(new SearchResult(List.of()));

            final DokumentListeResponse response = controller.searchVorgangsDokumente(
                    "vorgang-id", null, null, null, EXAMPLE_LIMIT,
                    null, null, null).getBody();

            verify(vorgangInPort).searchVorgangsDokumente(
                    new RequestContext(null, null, null),
                    "vorgang-id", EXAMPLE_LIMIT, null, null);
            assert response != null;
            assertEquals(0, response.getAnzahl());
            assertEquals(Collections.emptyList(), response.getElemente());
        }
    }

    @Nested
    class GetVorgang {
        @Test
        void givenVorgangId_thenForwardContextAndReturnMappedResult() {
            when(contextFactory.create(eq("login"), eq("ou"), eq("role")))
                    .thenReturn(new RequestContext("login", "ou", "role"));
            when(vorgangInPort.getVorgang(any(), any(), any())).thenReturn(
                    Optional.of(vorgangResult()));

            final Vorgang response = controller.getVorgang(
                    "COO.1.2.3",
                    "login",
                    "role",
                    "ou",
                    List.of("custom.attribute"),
                    null)
                    .getBody();

            verify(vorgangInPort).getVorgang(
                    new RequestContext("login", "ou", "role"),
                    "COO.1.2.3",
                    Set.of("custom.attribute"));
            assertEquals("COO.1.2.3", response.getId());
            assertEquals("short-name", response.getName());
        }

        @Test
        void givenUnknownVorgangId_thenThrowNotFoundException() {
            when(vorgangInPort.getVorgang(any(), any(), any())).thenReturn(null);

            assertThrows(ResourceNotFoundException.class, () -> controller.getVorgang(
                    "COO.1.2.3", null, null, null, null, null));
        }
    }

    private ResultObject vorgangResult() {
        return new ResultObject(
                "procedure-name",
                "COO.1.2.3",
                List.of(
                        new Attribute(AttributeType.STRING, PARENT_ID.getReference(), BigInteger.ZERO, "file-id"),
                        new Attribute(AttributeType.STRING, NAME.getReference(), BigInteger.ZERO, "short-name"),
                        new Attribute(AttributeType.ENUM, STATUS.getReference(), BigInteger.ZERO, BigInteger.valueOf(10)),
                        new Attribute(AttributeType.STRING, BEARBEITUNGSSTATUS.getReference(), BigInteger.ZERO, "processing"),
                        new Attribute(AttributeType.STRING, ZUGRIFFSDEFINITION.getReference(), BigInteger.ZERO, "acl"),
                        new Attribute(AttributeType.STRING, ORGANISATIONSEINHEIT.getReference(), BigInteger.ZERO, "ou"),
                        new Attribute(AttributeType.ENUM, ORIGINAL_MEDIUM.getReference(), BigInteger.ZERO, BigInteger.ONE)));
    }
}

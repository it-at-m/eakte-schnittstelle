package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.SearchHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class VorgangUseCaseTest {
    private static final RequestContext REQUEST_CONTEXT = new RequestContext("user", "ou", "role");
    private static final String VORGANG_DFV_FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";
    private static final String DOKUMENT_DFV_FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";

    private SearchOutPort searchOutPort;
    private VorgangUseCase useCase;

    @BeforeEach
    void setUp() {
        searchOutPort = mock(SearchOutPort.class);
        useCase = new VorgangUseCase(searchOutPort, new SearchHelper(searchOutPort));
    }

    @Nested
    class SearchVorgang {
        public static final int EXAMPLE_LIMIT = 123;

        @Test
        void givenClientAttributes_thenSearchWithDefaultAndClientAttributes() {
            final SearchResult expectedResult = new SearchResult(List.of(new ResultObject(
                    "procedure-name", "procedure-address", List.of())));
            when(searchOutPort.searchObject(any(), any())).thenReturn(expectedResult);

            final SearchResult result = useCase.searchVorgang(
                    REQUEST_CONTEXT,
                    EXAMPLE_LIMIT,
                    "query-value",
                    Set.of("custom.attribute"));

            assertSame(expectedResult, result);
            final SearchRequest request = verifySearchRequest();
            assertEquals(REQUEST_CONTEXT, capturedContext());
            assertEquals(EXAMPLE_LIMIT, request.limit());
            assertEquals("query-value", request.query());
            final Set<String> expectedAttrs = new HashSet<>(VorgangAttribute.getReferences());
            expectedAttrs.add("custom.attribute");
            assertEquals(
                    expectedAttrs,
                    request.attributes());
            verify(searchOutPort).searchObject(any(), any());
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesBeforeVorgangSearch() {
            final String dfvAttribute = "custom.dfv.attribute";
            final SearchResult expectedResult = new SearchResult(List.of());
            when(searchOutPort.searchObject(any(), any()))
                    .thenReturn(new SearchResult(List.of(new ResultObject(
                            "subject-area", "subject-area-address", List.of(
                                    new Attribute(AttributeType.STRING, VORGANG_DFV_FULL_REFERENCE, java.math.BigInteger.ONE, dfvAttribute))))),
                            expectedResult);

            final SearchResult result = useCase.searchVorgang(REQUEST_CONTEXT, EXAMPLE_LIMIT, "query-value", null);

            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort, times(2)).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            final List<SearchRequest> requests = requestCaptor.getAllValues();

            assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", requests.get(0).query());
            assertEquals(Set.of(VORGANG_DFV_FULL_REFERENCE),
                    requests.get(0).attributes());
            assertEquals("query-value", requests.get(1).query());
            final Set<String> expectedAttrs = new HashSet<>(VorgangAttribute.getReferences());
            expectedAttrs.add(dfvAttribute);
            assertEquals(expectedAttrs,
                    requests.get(1).attributes());
            assertSame(expectedResult, result);
            verify(searchOutPort, times(2)).searchObject(any(), any());
        }

        private RequestContext capturedContext() {
            final ArgumentCaptor<RequestContext> contextCaptor = ArgumentCaptor.forClass(RequestContext.class);
            verify(searchOutPort).searchObject(contextCaptor.capture(), any());
            return contextCaptor.getValue();
        }

        private SearchRequest verifySearchRequest() {
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(any(), requestCaptor.capture());
            return requestCaptor.getValue();
        }
    }

    @Nested
    class SearchVorgangsDokumente {
        @Test
        void givenClientAttributes_thenSearchDocumentsBelowVorgang() {
            final SearchResult expectedResult = new SearchResult(List.of());
            when(searchOutPort.searchObject(any(), any())).thenReturn(expectedResult);

            final SearchResult result = useCase.searchVorgangsDokumente(
                    REQUEST_CONTEXT, "vorgang-id", 123, "client query", Set.of("custom.attribute"));

            assertSame(expectedResult, result);
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            final SearchRequest request = requestCaptor.getValue();
            assertEquals(SearchType.DOKUMENT, request.type());
            assertEquals(123, request.limit());
            assertEquals("(.COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = 'vorgang-id') AND (client query)",
                    request.query());
            assertTrue(request.attributes().containsAll(DokumentAttribute.getReferences()));
            assertTrue(request.attributes().contains("custom.attribute"));
        }

        @Test
        void givenNoClientAttributes_thenLoadDocumentDfvAttributesBeforeSearch() {
            when(searchOutPort.searchObject(any(), any())).thenReturn(new SearchResult(List.of()));

            useCase.searchVorgangsDokumente(REQUEST_CONTEXT, "vorgang-id", 123, null, null);

            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort, times(2)).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            final List<SearchRequest> requests = requestCaptor.getAllValues();

            assertEquals(SearchType.SUBJECT_AREA, requests.getFirst().type());
            assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", requests.getFirst().query());
            assertEquals(Set.of(DOKUMENT_DFV_FULL_REFERENCE), requests.getFirst().attributes());
            assertEquals(SearchType.DOKUMENT, requests.get(1).type());
            assertEquals(".COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = 'vorgang-id'",
                    requests.get(1).query());
            assertTrue(requests.get(1).attributes().containsAll(DokumentAttribute.getReferences()));
        }
    }

    @Nested
    class GetVorgang {
        @Test
        void givenClientAttributes_thenReturnVorgangAndSearchById() {
            final ResultObject expectedResult = new ResultObject("procedure-name", "COO.1.2.3", List.of());
            when(searchOutPort.searchObject(any(), any())).thenReturn(new SearchResult(List.of(expectedResult)));

            final ResultObject result = useCase.getVorgang(
                    REQUEST_CONTEXT, "COO.1.2.3", Set.of("custom.attribute"))
                    .orElseThrow();

            assertSame(expectedResult, result);
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            assertEquals(SearchType.VORGANG, requestCaptor.getValue().type());
            assertEquals(".COOSYSTEM@1.1:objaddress = 'COO.1.2.3'", requestCaptor.getValue().query());
            assertTrue(requestCaptor.getValue().attributes().containsAll(VorgangAttribute.getReferences()));
            assertTrue(requestCaptor.getValue().attributes().contains("custom.attribute"));
        }
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.SearchHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class VorgangUseCaseTest {
    private static final RequestContext REQUEST_CONTEXT = new RequestContext("user", "ou", "role");

    private SearchOutPort searchOutPort;
    private VorgangUseCase useCase;

    @BeforeEach
    void setUp() {
        searchOutPort = mock(SearchOutPort.class);
        useCase = new VorgangUseCase(searchOutPort, new SearchHelper(searchOutPort));
    }

    @Nested
    class SearchVorgang {
        @Test
        void givenClientAttributes_thenSearchWithDefaultAndClientAttributes() {
            final SearchResult expectedResult = new SearchResult(List.of(new SearchResult.ResultObject(
                    "procedure-name", "procedure-address", List.of())));
            when(searchOutPort.searchObject(any(), any())).thenReturn(expectedResult);

            final SearchResult result = useCase.searchVorgang(
                    REQUEST_CONTEXT,
                    "scope-value",
                    "query-value",
                    Set.of("custom.attribute"));

            assertSame(expectedResult, result);
            final SearchRequest request = verifySearchRequest();
            assertEquals(REQUEST_CONTEXT, capturedContext());
            assertEquals("scope-value", request.scope());
            assertEquals("query-value", request.query());
            assertEquals(
                    Set.of(PARENT_ID.getReference(), SUBJECT.getReference(), "custom.attribute"),
                    request.attributes());
            verify(searchOutPort).searchObject(any(), any());
        }

        @Test
        void givenNoClientAttributes_thenLoadDfVAttributesBeforeVorgangSearch() {
            final String dfvAttribute = "custom.dfv.attribute";
            final String fullReference = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
                    + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
                    + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
                    + "COOSYSTEM@1.1:fullreference";
            final SearchResult expectedResult = new SearchResult(List.of());
            when(searchOutPort.searchObject(any(), any()))
                    .thenReturn(new SearchResult(List.of(new SearchResult.ResultObject(
                            "subject-area", "subject-area-address", List.of(
                                    new StringAttribute(fullReference, java.math.BigInteger.ONE, dfvAttribute))))),
                            expectedResult);

            final SearchResult result = useCase.searchVorgang(REQUEST_CONTEXT, null, "query-value", null);

            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort, times(2)).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            final List<SearchRequest> requests = requestCaptor.getAllValues();

            assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", requests.get(0).query());
            assertEquals(Set.of(fullReference),
                    requests.get(0).attributes());
            assertEquals("query-value", requests.get(1).query());
            assertEquals(Set.of(PARENT_ID.getReference(), SUBJECT.getReference(), dfvAttribute),
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
}

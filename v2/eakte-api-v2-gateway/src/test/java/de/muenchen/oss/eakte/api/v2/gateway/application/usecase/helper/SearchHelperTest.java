package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class SearchHelperTest {
    private static final RequestContext REQUEST_CONTEXT = new RequestContext("user", "ou", "role");
    private static final String FULL_REFERENCE = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
            + "availabledefinitions[0].EGOVTEMPLATE@15.1001:definitionuseform."
            + "FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
            + "COOSYSTEM@1.1:fullreference";

    private SearchOutPort searchOutPort;
    private SearchHelper searchHelper;

    @BeforeEach
    void setUp() {
        searchOutPort = mock(SearchOutPort.class);
        searchHelper = new SearchHelper(searchOutPort);
    }

    @Nested
    class LoadDfvAttributes {
        @Test
        void givenMatchingStringAttributes_thenReturnTheirValues() {
            when(searchOutPort.searchObject(eq(REQUEST_CONTEXT), any()))
                    .thenReturn(new SearchResult(List.of(new ResultObject(
                            "subject-area", "address", List.of(
                                    new Attribute(AttributeType.STRING, FULL_REFERENCE, BigInteger.ONE, "attribute.one"),
                                    new Attribute(AttributeType.STRING, FULL_REFERENCE, BigInteger.TWO, "attribute.two"),
                                    new Attribute(AttributeType.STRING, "other.reference", BigInteger.ONE, "ignored"),
                                    new Attribute(AttributeType.INTEGER, FULL_REFERENCE, BigInteger.ONE, 42))))));

            final List<String> attributes = searchHelper.loadDfVAttributes(REQUEST_CONTEXT, FabasoftType.VORGANG);

            assertEquals(List.of("attribute.one", "attribute.two"), attributes);
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            assertEquals(FabasoftType.SUBJECT_AREA, requestCaptor.getValue().type());
            assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", requestCaptor.getValue().query());
            assertEquals(Set.of(FULL_REFERENCE), requestCaptor.getValue().attributes());
        }

        @Test
        void givenDocumentSearch_thenUseDocumentDfvReference() {
            when(searchOutPort.searchObject(eq(REQUEST_CONTEXT), any()))
                    .thenReturn(new SearchResult(List.of()));

            searchHelper.loadDfVAttributes(REQUEST_CONTEXT, FabasoftType.DOKUMENT);

            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            assertEquals(FabasoftType.SUBJECT_AREA, requestCaptor.getValue().type());
            assertEquals(Set.of("EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
                    + "availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:"
                    + "definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes."
                    + "COOSYSTEM@1.1:fullreference"), requestCaptor.getValue().attributes());
        }
    }

    @Nested
    class ConcatQuery {
        @Test
        void givenBothQueries_thenJoinWithAnd() {
            assertEquals("(first) AND (second)", searchHelper.concatQuery("first", "second"));
        }

        @Test
        void givenOnlyFirstQuery_thenReturnFirstQuery() {
            assertEquals("first", searchHelper.concatQuery("first", null));
        }

        @Test
        void givenOnlySecondQuery_thenReturnSecondQuery() {
            assertEquals("second", searchHelper.concatQuery(null, "second"));
        }

    }

    @Nested
    class BuildAttributes {
        @Test
        void givenDocumentClientAttributes_thenBuildDocumentDefaultsAndClientAttributes() {
            final Set<String> attributes = searchHelper.buildAttributes(
                    REQUEST_CONTEXT, FabasoftType.DOKUMENT, Set.of("custom.attribute"));

            assertTrue(attributes.containsAll(DokumentAttribute.getReferences()));
            assertTrue(attributes.contains("custom.attribute"));
        }
    }

    @Nested
    class GetObject {
        @Test
        void givenOneResult_thenReturnResultAndBuildIdSearchRequest() {
            final ResultObject expectedResult = new ResultObject("name", "COO.1.2.3", List.of());
            when(searchOutPort.searchObject(eq(REQUEST_CONTEXT), any()))
                    .thenReturn(new SearchResult(List.of(expectedResult)));

            final ResultObject result = searchHelper.getObject(
                    REQUEST_CONTEXT, FabasoftType.VORGANG, "COO.1.2.3", Set.of("attribute"))
                    .orElseThrow();

            assertEquals(expectedResult, result);
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            assertEquals(FabasoftType.VORGANG, requestCaptor.getValue().type());
            assertEquals(2, requestCaptor.getValue().limit());
            assertEquals(".COOSYSTEM@1.1:objaddress = 'COO.1.2.3'", requestCaptor.getValue().query());
            assertEquals(Set.of("attribute"), requestCaptor.getValue().attributes());
        }

        @Test
        void givenNoResults_thenReturnEmpty() {
            when(searchOutPort.searchObject(eq(REQUEST_CONTEXT), any()))
                    .thenReturn(new SearchResult(List.of()));

            assertTrue(searchHelper.getObject(REQUEST_CONTEXT, FabasoftType.VORGANG, "COO.1.2.3", Set.of()).isEmpty());
        }

        @Test
        void givenMultipleResults_thenThrowException() {
            final ResultObject result = new ResultObject("name", "COO.1.2.3", List.of());
            when(searchOutPort.searchObject(eq(REQUEST_CONTEXT), any()))
                    .thenReturn(new SearchResult(List.of(result, result)));

            assertThrows(IllegalStateException.class,
                    () -> searchHelper.getObject(REQUEST_CONTEXT, FabasoftType.VORGANG, "COO.1.2.3", Set.of()));
        }
    }
}

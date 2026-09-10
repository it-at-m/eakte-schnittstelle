package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.IntegerAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.StringAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;
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
                    .thenReturn(new SearchResult(List.of(new SearchResult.ResultObject(
                            "subject-area", "address", List.of(
                                    new StringAttribute(FULL_REFERENCE, BigInteger.ONE, "attribute.one"),
                                    new StringAttribute(FULL_REFERENCE, BigInteger.TWO, "attribute.two"),
                                    new StringAttribute("other.reference", BigInteger.ONE, "ignored"),
                                    new IntegerAttribute(FULL_REFERENCE, BigInteger.ONE, 42))))));

            final List<String> attributes = searchHelper.loadDfVAttributes(REQUEST_CONTEXT, SearchType.VORGANG);

            assertEquals(List.of("attribute.one", "attribute.two"), attributes);
            final ArgumentCaptor<SearchRequest> requestCaptor = ArgumentCaptor.forClass(SearchRequest.class);
            verify(searchOutPort).searchObject(eq(REQUEST_CONTEXT), requestCaptor.capture());
            assertEquals(SearchType.SUBJECT_AREA, requestCaptor.getValue().type());
            assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", requestCaptor.getValue().query());
            assertEquals(Set.of(FULL_REFERENCE), requestCaptor.getValue().attributes());
        }
    }
}

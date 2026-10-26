package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftVorgangOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(Set.of("custom.attribute"))
            .build();

    private final FabasoftVorgangMapper vorgangMapper = new FabasoftVorgangMapper(new FabasoftAttributeMapperImpl());

    @Mock
    private FabasoftSearchService searchService;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @Captor
    private ArgumentCaptor<Set<String>> attributesCaptor;

    @Test
    void givenSearchRequest_thenSearchWithDefaultAttributesAndMapResults() {
        final List<ResultObject> result = List.of(resultWithRequiredAttributes());
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.VORGANG), requestCaptor.capture()))
                .thenReturn(result);

        final List<VorgangResponse> actual = new FabasoftVorgangOutAdapter(searchService, vorgangMapper)
                .search(CONTEXT, REQUEST);

        assertEquals(List.of(vorgangMapper.toDomain(result.getFirst())), actual);
        final SearchRequest forwardedRequest = requestCaptor.getValue();
        assertEquals(REQUEST.limit(), forwardedRequest.limit());
        assertEquals(REQUEST.query(), forwardedRequest.query());
        assertTrue(forwardedRequest.attributes().containsAll(REQUEST.attributes()));
        assertTrue(forwardedRequest.attributes().containsAll(VorgangAttribute.getReferences()));
    }

    @Test
    void givenExistingVorgang_thenGetAndMapResult() {
        final ResultObject result = resultWithRequiredAttributes();
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.VORGANG), eq("COO.1.2.3"), attributesCaptor.capture()))
                .thenReturn(Optional.of(result));

        final Optional<VorgangResponse> actual = new FabasoftVorgangOutAdapter(searchService, vorgangMapper)
                .get(CONTEXT, "COO.1.2.3", Set.of("custom.attribute"));

        assertEquals(Optional.of(vorgangMapper.toDomain(result)), actual);
        assertTrue(attributesCaptor.getValue().containsAll(VorgangAttribute.getReferences()));
    }

    @Test
    void givenUnknownVorgang_thenReturnEmpty() {
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.VORGANG), eq("COO.1.2.3"), attributesCaptor.capture()))
                .thenReturn(Optional.empty());

        final Optional<VorgangResponse> actual = new FabasoftVorgangOutAdapter(searchService, vorgangMapper)
                .get(CONTEXT, "COO.1.2.3", Set.of());

        assertTrue(actual.isEmpty());
    }

    @Test
    void givenVorgangId_thenBuildParentQuery() {
        assertEquals(".COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = 'COO.1.2.3'",
                FabasoftVorgangOutAdapter.getParentQuery("COO.1.2.3"));
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("name", "COO.1.2.3", List.of(
                attribute(VorgangAttribute.NAME, "name"),
                attribute(VorgangAttribute.STATUS, BigInteger.TEN),
                attribute(VorgangAttribute.BEARBEITUNGSSTATUS, "processing"),
                attribute(VorgangAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(VorgangAttribute.ORIGINAL_MEDIUM, BigInteger.ONE)));
    }

    private static FabasoftAttribute attribute(final VorgangAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

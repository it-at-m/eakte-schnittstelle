package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SchriftstueckAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftSchriftstueckMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
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
class FabasoftSchriftstueckOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final String DOKUMENT_ID = "COO.1.2.3";
    private static final String SCHRIFTSTUECK_ID = "COO.2.3.4";
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(Set.of("custom.attribute"))
            .build();

    private final FabasoftSchriftstueckMapper schriftstueckMapper = new FabasoftSchriftstueckMapper(new FabasoftAttributeMapperImpl());

    @Mock
    private FabasoftSearchService searchService;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @Test
    void givenSearchRequest_thenSearchBelowDokumentAndMapResults() {
        final List<ResultObject> result = List.of(resultWithRequiredAttributes());
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.SCHRIFTSTUECK), requestCaptor.capture()))
                .thenReturn(result);

        final List<SchriftstueckResponse> actual = new FabasoftSchriftstueckOutAdapter(searchService, schriftstueckMapper)
                .searchBellowDokument(CONTEXT, DOKUMENT_ID, REQUEST);

        assertEquals(List.of(schriftstueckMapper.toDomain(result.getFirst())), actual);
        final SearchRequest forwardedRequest = requestCaptor.getValue();
        assertEquals(REQUEST.limit(), forwardedRequest.limit());
        assertEquals("(where) AND (.COOELAK@1.1001:referrednumber = 'COO.1.2.3')", forwardedRequest.query());
        assertTrue(forwardedRequest.attributes().containsAll(REQUEST.attributes()));
        assertTrue(forwardedRequest.attributes().containsAll(SchriftstueckAttribute.getReferences()));
    }

    @Test
    void givenSearchWithoutQuery_thenKeepDokumentParentQueryOnly() {
        final SearchRequest request = SearchRequest.builder().limit(10).attributes(Set.of()).build();
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.SCHRIFTSTUECK), requestCaptor.capture()))
                .thenReturn(List.of());

        new FabasoftSchriftstueckOutAdapter(searchService, schriftstueckMapper)
                .searchBellowDokument(CONTEXT, DOKUMENT_ID, request);

        assertEquals(".COOELAK@1.1001:referrednumber = 'COO.1.2.3'", requestCaptor.getValue().query());
    }

    @Test
    void givenExistingSchriftstueck_thenGetAndMapResult() {
        final ResultObject result = resultWithRequiredAttributes();
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.SCHRIFTSTUECK), eq(SCHRIFTSTUECK_ID),
                eq(SchriftstueckAttribute.getReferences())))
                .thenReturn(Optional.of(result));

        final Optional<SchriftstueckResponse> actual = new FabasoftSchriftstueckOutAdapter(searchService, schriftstueckMapper)
                .get(CONTEXT, SCHRIFTSTUECK_ID);

        assertEquals(Optional.of(schriftstueckMapper.toDomain(result)), actual);
    }

    @Test
    void givenUnknownSchriftstueck_thenReturnEmpty() {
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.SCHRIFTSTUECK), eq(SCHRIFTSTUECK_ID),
                eq(SchriftstueckAttribute.getReferences())))
                .thenReturn(Optional.empty());

        final Optional<SchriftstueckResponse> actual = new FabasoftSchriftstueckOutAdapter(searchService, schriftstueckMapper)
                .get(CONTEXT, SCHRIFTSTUECK_ID);

        assertTrue(actual.isEmpty());
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("name", SCHRIFTSTUECK_ID, List.of(
                attribute(SchriftstueckAttribute.DOKUMENT_ID, DOKUMENT_ID),
                attribute(SchriftstueckAttribute.BETREFF, "subject"),
                attribute(SchriftstueckAttribute.DATEI_ENDUNG, "pdf"),
                attribute(SchriftstueckAttribute.DATEI_GROESSE, BigInteger.valueOf(1234))));
    }

    private static FabasoftAttribute attribute(final SchriftstueckAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

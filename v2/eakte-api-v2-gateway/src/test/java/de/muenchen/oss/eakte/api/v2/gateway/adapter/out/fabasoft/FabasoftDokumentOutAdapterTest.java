package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftDokumentOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(Set.of("custom.attribute"))
            .build();

    private final FabasoftDokumentMapper dokumentMapper = new FabasoftDokumentMapper(new FabasoftAttributeMapperImpl());

    @Mock
    private FabasoftSearchService searchService;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @Test
    void givenSearchRequest_thenSearchBelowVorgangAndMapResults() {
        final List<ResultObject> result = List.of(resultWithRequiredAttributes());
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.DOKUMENT), requestCaptor.capture()))
                .thenReturn(result);

        final List<DokumentResponse> actual = new FabasoftDokumentOutAdapter(searchService, dokumentMapper)
                .searchBellowVorgang(CONTEXT, "COO.1.2.3", REQUEST);

        assertEquals(List.of(dokumentMapper.toDomain(result.getFirst())), actual);
        final SearchRequest forwardedRequest = requestCaptor.getValue();
        assertEquals(REQUEST.limit(), forwardedRequest.limit());
        assertEquals("(where) AND (.COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = 'COO.1.2.3')",
                forwardedRequest.query());
        assertTrue(forwardedRequest.attributes().containsAll(REQUEST.attributes()));
        assertTrue(forwardedRequest.attributes().containsAll(DokumentAttribute.getReferences()));
    }

    @Test
    void givenSearchWithoutQuery_thenKeepParentQueryOnly() {
        final SearchRequest request = SearchRequest.builder().limit(10).attributes(Set.of()).build();
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.DOKUMENT), requestCaptor.capture()))
                .thenReturn(List.of());

        new FabasoftDokumentOutAdapter(searchService, dokumentMapper)
                .searchBellowVorgang(CONTEXT, "COO.1.2.3", request);

        assertEquals(".COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = 'COO.1.2.3'",
                requestCaptor.getValue().query());
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("document-name", "COO.2.3.4", List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Incoming"),
                attribute(DokumentAttribute.PARENT_ID, "parent-id"),
                attribute(DokumentAttribute.PARENT_TYPE, "DEPRECONFIG@15.1001:Procedure"),
                attribute(DokumentAttribute.NAME, "short-name"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou")));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ErledigungAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftErledigungMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
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
class FabasoftErledigungOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final String ERLEDIGUNG_ID = "COO.1.2.3";
    private static final Set<String> REQUEST_ATTRIBUTES = Set.of("custom.attribute");
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(REQUEST_ATTRIBUTES)
            .build();

    private final FabasoftAttributeMapper attributeMapper = new FabasoftAttributeMapperImpl();
    private final FabasoftErledigungMapper erledigungMapper = new FabasoftErledigungMapper(
            attributeMapper,
            new FabasoftDokumentMapper(attributeMapper));

    @Mock
    private FabasoftSearchService searchService;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @Captor
    private ArgumentCaptor<Set<String>> attributesCaptor;

    @Test
    void givenSearchRequest_thenSearchErledigungenWithRequiredAttributesAndMapResults() {
        final List<ResultObject> result = List.of(resultWithRequiredAttributes());
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.ERLEDIGUNG), requestCaptor.capture()))
                .thenReturn(result);

        final List<ErledigungResponse> actual = new FabasoftErledigungOutAdapter(searchService, erledigungMapper)
                .search(CONTEXT, REQUEST);

        assertEquals(List.of(erledigungMapper.toDomain(result.getFirst())), actual);
        assertEquals("note", actual.getFirst().getHinweis());
        final SearchRequest forwardedRequest = requestCaptor.getValue();
        assertEquals(REQUEST.limit(), forwardedRequest.limit());
        assertEquals(REQUEST.query(), forwardedRequest.query());
        assertTrue(forwardedRequest.attributes().containsAll(REQUEST_ATTRIBUTES));
        assertTrue(forwardedRequest.attributes().containsAll(DokumentAttribute.getReferences()));
        assertTrue(forwardedRequest.attributes().containsAll(ErledigungAttribute.getReferences()));
    }

    @Test
    void givenExistingErledigung_thenGetAndMapResultWithRequiredAttributes() {
        final ResultObject result = resultWithRequiredAttributes();
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.ERLEDIGUNG), eq(ERLEDIGUNG_ID), attributesCaptor.capture()))
                .thenReturn(Optional.of(result));

        final Optional<ErledigungResponse> actual = new FabasoftErledigungOutAdapter(searchService, erledigungMapper)
                .get(CONTEXT, ERLEDIGUNG_ID, REQUEST_ATTRIBUTES);

        assertEquals(Optional.of(erledigungMapper.toDomain(result)), actual);
        assertEquals("note", actual.orElseThrow().getHinweis());
        assertTrue(attributesCaptor.getValue().containsAll(REQUEST_ATTRIBUTES));
        assertTrue(attributesCaptor.getValue().containsAll(DokumentAttribute.getReferences()));
        assertTrue(attributesCaptor.getValue().containsAll(ErledigungAttribute.getReferences()));
    }

    @Test
    void givenUnknownErledigung_thenReturnEmpty() {
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.ERLEDIGUNG), eq(ERLEDIGUNG_ID), attributesCaptor.capture()))
                .thenReturn(Optional.empty());

        final Optional<ErledigungResponse> actual = new FabasoftErledigungOutAdapter(searchService, erledigungMapper)
                .get(CONTEXT, ERLEDIGUNG_ID, Set.of());

        assertTrue(actual.isEmpty());
        assertTrue(attributesCaptor.getValue().containsAll(DokumentAttribute.getReferences()));
        assertTrue(attributesCaptor.getValue().containsAll(ErledigungAttribute.getReferences()));
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("long name", ERLEDIGUNG_ID, List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:Outgoing"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.HINWEIS, "note"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(ErledigungAttribute.BEZUG_EINGANGSDOKUMENT, "incoming-id"),
                attribute(ErledigungAttribute.DOKUMENTENTYP, "letter"),
                attribute(ErledigungAttribute.ANLAGEN_BESCHREIBUNG, "enclosures"),
                new FabasoftAttribute(AttributeType.STRING, "custom.attribute", null, "value")));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }

    private static FabasoftAttribute attribute(final ErledigungAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

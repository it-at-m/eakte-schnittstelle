package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.InternesDokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftInternesDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import java.time.LocalDate;
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
class FabasoftInternesDokumentOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final String DOKUMENT_ID = "COO.1.2.3";
    private static final Set<String> REQUEST_ATTRIBUTES = Set.of("custom.attribute");
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(REQUEST_ATTRIBUTES)
            .build();

    private final FabasoftAttributeMapper attributeMapper = new FabasoftAttributeMapperImpl();
    private final FabasoftInternesDokumentMapper internesDokumentMapper = new FabasoftInternesDokumentMapper(
            attributeMapper,
            new FabasoftDokumentMapper(attributeMapper));

    @Mock
    private FabasoftSearchService searchService;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @Captor
    private ArgumentCaptor<Set<String>> attributesCaptor;

    @Test
    void givenSearchRequest_thenSearchInternalDocumentsWithRequiredAttributesAndMapResults() {
        final List<ResultObject> result = List.of(resultWithRequiredAttributes());
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.INTERNES_DOKUMENT), requestCaptor.capture()))
                .thenReturn(result);

        final List<InternesDokumentResponse> actual = new FabasoftInternesDokumentOutAdapter(searchService, internesDokumentMapper)
                .search(CONTEXT, REQUEST);

        assertEquals(List.of(internesDokumentMapper.toDomain(result.getFirst())), actual);
        final SearchRequest forwardedRequest = requestCaptor.getValue();
        assertEquals(REQUEST.limit(), forwardedRequest.limit());
        assertEquals(REQUEST.query(), forwardedRequest.query());
        assertTrue(forwardedRequest.attributes().containsAll(REQUEST_ATTRIBUTES));
        assertTrue(forwardedRequest.attributes().containsAll(DokumentAttribute.getReferences()));
        assertTrue(forwardedRequest.attributes().containsAll(InternesDokumentAttribute.getReferences()));
    }

    @Test
    void givenExistingInternesDokument_thenGetAndMapResultWithRequiredAttributes() {
        final ResultObject result = resultWithRequiredAttributes();
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.INTERNES_DOKUMENT), eq(DOKUMENT_ID), attributesCaptor.capture()))
                .thenReturn(Optional.of(result));

        final Optional<InternesDokumentResponse> actual = new FabasoftInternesDokumentOutAdapter(searchService, internesDokumentMapper)
                .get(CONTEXT, DOKUMENT_ID, REQUEST_ATTRIBUTES);

        assertEquals(Optional.of(internesDokumentMapper.toDomain(result)), actual);
        assertTrue(attributesCaptor.getValue().containsAll(REQUEST_ATTRIBUTES));
        assertTrue(attributesCaptor.getValue().containsAll(DokumentAttribute.getReferences()));
        assertTrue(attributesCaptor.getValue().containsAll(InternesDokumentAttribute.getReferences()));
    }

    @Test
    void givenUnknownInternesDokument_thenReturnEmpty() {
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.INTERNES_DOKUMENT), eq(DOKUMENT_ID), attributesCaptor.capture()))
                .thenReturn(Optional.empty());

        final Optional<InternesDokumentResponse> actual = new FabasoftInternesDokumentOutAdapter(searchService, internesDokumentMapper)
                .get(CONTEXT, DOKUMENT_ID, Set.of());

        assertTrue(actual.isEmpty());
        assertTrue(attributesCaptor.getValue().containsAll(DokumentAttribute.getReferences()));
        assertTrue(attributesCaptor.getValue().containsAll(InternesDokumentAttribute.getReferences()));
    }

    private static ResultObject resultWithRequiredAttributes() {
        return new ResultObject("long name", DOKUMENT_ID, List.of(
                attribute(DokumentAttribute.KLASSE, "COOELAK@1.1001:InternalFile"),
                attribute(DokumentAttribute.VORGANG_ID, "vorgang"),
                attribute(DokumentAttribute.NAME, "name"),
                attribute(DokumentAttribute.BETREFF, "subject"),
                attribute(DokumentAttribute.HINWEIS, "note"),
                attribute(DokumentAttribute.ZUGRIFFSDEFINITION, "access"),
                attribute(DokumentAttribute.ORGANISATIONSEINHEIT, "ou"),
                attribute(InternesDokumentAttribute.ZUSTELLUNGSDATUM, LocalDate.of(2025, 1, 2)),
                attribute(InternesDokumentAttribute.DOKUMENTENTYP, "letter"),
                attribute(InternesDokumentAttribute.ANLAGEN_BESCHREIBUNG, "additional enclosure")));
    }

    private static FabasoftAttribute attribute(final DokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }

    private static FabasoftAttribute attribute(final InternesDokumentAttribute attribute, final Object value) {
        return new FabasoftAttribute(attribute.getType(), attribute.getReference(), null, value);
    }
}

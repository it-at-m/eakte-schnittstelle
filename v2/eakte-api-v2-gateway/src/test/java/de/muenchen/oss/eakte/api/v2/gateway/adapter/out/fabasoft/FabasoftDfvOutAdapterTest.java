package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftDfvOutAdapterTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);
    private static final String VORGANG_PREFIX = "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0]";
    private static final String DOKUMENT_PREFIX = VORGANG_PREFIX
            + ".EGOVTEMPLATE@15.1001:availabledefinitions[0]";
    private static final String SUFFIX = ".EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes.COOSYSTEM@1.1:fullreference";

    @Mock
    private FabasoftSearchService searchService;

    private FabasoftDfvOutAdapter fabasoftDfvOutAdapter;

    @Captor
    private ArgumentCaptor<SearchRequest> requestCaptor;

    @BeforeEach
    void setUp() {
        this.fabasoftDfvOutAdapter = new FabasoftDfvOutAdapter(searchService, new FabasoftAttributeMapperImpl());
    }

    @Test
    void givenVorgangType_thenLoadMatchingStringAttributes() {
        final String reference = VORGANG_PREFIX + SUFFIX;
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.SUBJECT_AREA), requestCaptor.capture()))
                .thenReturn(List.of(new ResultObject("name", "coo", List.of(
                        new FabasoftAttribute(AttributeType.STRING, reference, BigInteger.ONE, "attribute.one"),
                        new FabasoftAttribute(AttributeType.STRING, reference, BigInteger.TWO, "attribute.two"),
                        new FabasoftAttribute(AttributeType.INTEGER, reference, BigInteger.valueOf(3), BigInteger.TEN),
                        new FabasoftAttribute(AttributeType.STRING, "other", BigInteger.ONE, "ignored")))));

        final Set<String> actual = fabasoftDfvOutAdapter.loadDfVAttributes(CONTEXT, ObjectType.VORGANG);

        assertEquals(Set.of("attribute.one", "attribute.two"), actual);
        assertRequest(requestCaptor.getValue(), reference);
    }

    @Test
    void givenDokumentType_thenUseDokumentAttributePrefix() {
        final String reference = DOKUMENT_PREFIX + SUFFIX;
        when(searchService.searchObject(eq(CONTEXT), eq(FabasoftObjectType.SUBJECT_AREA), requestCaptor.capture()))
                .thenReturn(List.of(new ResultObject("name", "coo", List.of(
                        new FabasoftAttribute(AttributeType.STRING, reference, BigInteger.ONE, "attribute")))));

        final Set<String> actual = fabasoftDfvOutAdapter.loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT);

        assertEquals(Set.of("attribute"), actual);
        assertRequest(requestCaptor.getValue(), reference);
    }

    @Test
    void givenUnsupportedType_thenRejectDfVResolution() {
        assertThrows(IllegalArgumentException.class,
                () -> fabasoftDfvOutAdapter.loadDfVAttributes(CONTEXT, ObjectType.EINGANGSDOKUMENT));
    }

    private static void assertRequest(final SearchRequest request, final String reference) {
        assertEquals(FabasoftSearchService.LIMIT_MAX, request.limit());
        assertEquals("EGOVTEMPLATE@15.1001:availabledefinitions is not null", request.query());
        assertEquals(Set.of(reference), request.attributes());
    }
}

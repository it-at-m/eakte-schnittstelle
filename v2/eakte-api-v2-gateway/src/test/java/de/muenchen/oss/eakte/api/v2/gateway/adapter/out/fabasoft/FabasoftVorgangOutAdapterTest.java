package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangRequestMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangResponseMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftAttributeService;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSubFileService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
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
    private static final String VORGANG_ID = "COO.1.2.3";
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(25)
            .query("where")
            .attributes(Set.of("custom.attribute"))
            .build();

    private final FabasoftVorgangResponseMapper vorgangMapper = FabasoftTestFixtures.vorgangResponseMapper();
    private final FabasoftVorgangRequestMapper requestMapper = FabasoftTestFixtures.vorgangRequestMapper();

    @Mock
    private FabasoftSubFileService subFileService;

    @Mock
    private FabasoftAttributeService attributeService;

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

        final List<VorgangResponse> actual = adapter()
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

        final Optional<VorgangResponse> actual = adapter()
                .get(CONTEXT, "COO.1.2.3", Set.of("custom.attribute"));

        assertEquals(Optional.of(vorgangMapper.toDomain(result)), actual);
        assertTrue(attributesCaptor.getValue().containsAll(VorgangAttribute.getReferences()));
    }

    @Test
    void givenUnknownVorgang_thenReturnEmpty() {
        when(searchService.getObject(eq(CONTEXT), eq(FabasoftObjectType.VORGANG), eq("COO.1.2.3"), attributesCaptor.capture()))
                .thenReturn(Optional.empty());

        final Optional<VorgangResponse> actual = adapter()
                .get(CONTEXT, "COO.1.2.3", Set.of());

        assertTrue(actual.isEmpty());
    }

    @Test
    void givenCreateVorgangRequest_thenCreateSubFileAndSetAttributes() {
        final CreateVorgangRequest request = new CreateVorgangRequest(
                "akte-id", "name", "subject", "template-id", VorgangMedium.PAPIER, false, "remark",
                FabasoftTestFixtures.ACCESS_DEFINITION_TEXT);
        final SubFileRequest subFileRequest = new SubFileRequest(
                FabasoftObjectType.VORGANG, "akte-id", "name", "template-id", "subject");
        final List<FabasoftAttribute> attributes = List.of(
                new FabasoftAttribute(AttributeType.ENUM, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), null, BigInteger.valueOf(2)),
                new FabasoftAttribute(AttributeType.STRING, VorgangAttribute.GESCHAEFTSGANGVERMERK.getReference(), null, "remark"),
                new FabasoftAttribute(AttributeType.OBJECT, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), null,
                        FabasoftTestFixtures.ACCESS_DEFINITION_ID));
        when(subFileService.createSubFile(CONTEXT, subFileRequest)).thenReturn(VORGANG_ID);

        final String actual = adapter().createAkteVorgang(CONTEXT, request);

        assertEquals(VORGANG_ID, actual);
        verify(subFileService).createSubFile(CONTEXT, subFileRequest);
        verify(attributeService).setAttributes(CONTEXT, VORGANG_ID, attributes);
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

    private FabasoftVorgangOutAdapter adapter() {
        return new FabasoftVorgangOutAdapter(searchService, subFileService, attributeService, vorgangMapper, requestMapper);
    }

}

package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.VorgangOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VorgangUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", "role");
    private static final String VORGANG_ID = "vorgang-id";
    private static final String AKTE_ID = "akte-id";
    private static final Set<String> DFV_ATTRIBUTES = Set.of("dfv.one");
    private static final Set<String> EXPLICIT_ATTRIBUTES = Set.of("explicit");

    @Mock
    private VorgangOutPort vorgangOutPort;

    @Mock
    private DfvOutPort dfvOutPort;

    @Mock
    private DfvHelper dfvHelper;

    private VorgangUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new VorgangUseCase(vorgangOutPort, dfvOutPort, dfvHelper);
    }

    @Nested
    class Search {
        @Test
        void givenSearchRequest_thenDelegateEnrichedRequestAndReturnResults() {
            final SearchRequest request = requestWithAttributes(EXPLICIT_ATTRIBUTES);
            final SearchRequest enrichedRequest = requestWithAttributes(DFV_ATTRIBUTES);
            final List<VorgangResponse> expected = List.of(VorgangResponse.builder().id(VORGANG_ID).build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.VORGANG, request)).thenReturn(enrichedRequest);
            when(vorgangOutPort.search(CONTEXT, enrichedRequest)).thenReturn(expected);

            final List<VorgangResponse> result = useCase.search(CONTEXT, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.VORGANG, request);
            verify(vorgangOutPort).search(CONTEXT, enrichedRequest);
        }
    }

    @Nested
    class SearchBellowAkte {
        @Test
        void givenSearchRequest_thenDelegateEnrichedRequestAndReturnResults() {
            final SearchRequest request = requestWithAttributes(EXPLICIT_ATTRIBUTES);
            final SearchRequest enrichedRequest = requestWithAttributes(DFV_ATTRIBUTES);
            final List<VorgangResponse> expected = List.of(VorgangResponse.builder().id(VORGANG_ID).build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.VORGANG, request)).thenReturn(enrichedRequest);
            when(vorgangOutPort.searchBellowAkte(CONTEXT, AKTE_ID, enrichedRequest)).thenReturn(expected);

            final List<VorgangResponse> result = useCase.searchBellowAkte(CONTEXT, AKTE_ID, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.VORGANG, request);
            verify(vorgangOutPort).searchBellowAkte(CONTEXT, AKTE_ID, enrichedRequest);
        }
    }

    @Nested
    class Get {
        @Test
        void givenEmptyAttributes_thenLoadVorgangDfvAttributesAndReturnResult() {
            final Optional<VorgangResponse> expected = Optional.empty();
            when(dfvOutPort.loadDfVAttributes(CONTEXT, ObjectType.VORGANG)).thenReturn(DFV_ATTRIBUTES);
            when(vorgangOutPort.get(CONTEXT, VORGANG_ID, DFV_ATTRIBUTES)).thenReturn(expected);

            final Optional<VorgangResponse> result = useCase.get(CONTEXT, VORGANG_ID, Set.of());

            assertEquals(expected, result);
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, ObjectType.VORGANG);
            verify(vorgangOutPort).get(CONTEXT, VORGANG_ID, DFV_ATTRIBUTES);
        }

        @Test
        void givenExplicitAttributes_thenDelegateAttributesAndReturnResult() {
            final VorgangResponse response = VorgangResponse.builder().id(VORGANG_ID).build();
            final Optional<VorgangResponse> expected = Optional.of(response);
            when(vorgangOutPort.get(CONTEXT, VORGANG_ID, EXPLICIT_ATTRIBUTES)).thenReturn(expected);

            final Optional<VorgangResponse> result = useCase.get(CONTEXT, VORGANG_ID, EXPLICIT_ATTRIBUTES);

            assertEquals(expected, result);
            verify(vorgangOutPort).get(CONTEXT, VORGANG_ID, EXPLICIT_ATTRIBUTES);
            verifyNoInteractions(dfvOutPort);
        }
    }

    private static SearchRequest requestWithAttributes(final Set<String> attributes) {
        return SearchRequest.builder().limit(10).query("query").attributes(attributes).build();
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.ErledigungOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
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
class ErledigungUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", "role");
    private static final String ERLEDIGUNG_ID = "erledigung-id";
    private static final Set<String> DFV_ATTRIBUTES = Set.of("dfv.one");
    private static final Set<String> EXPLICIT_ATTRIBUTES = Set.of("explicit");

    @Mock
    private ErledigungOutPort erledigungOutPort;

    @Mock
    private DfvOutPort dfvOutPort;

    @Mock
    private DfvHelper dfvHelper;

    private ErledigungUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ErledigungUseCase(erledigungOutPort, dfvOutPort, dfvHelper);
    }

    @Nested
    class Search {
        @Test
        void givenSearchRequest_thenDelegateEnrichedRequestAndReturnResults() {
            final SearchRequest request = requestWithAttributes(EXPLICIT_ATTRIBUTES);
            final SearchRequest enrichedRequest = requestWithAttributes(DFV_ATTRIBUTES);
            final List<ErledigungResponse> expected = List.of(ErledigungResponse.builder().id(ERLEDIGUNG_ID).build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request)).thenReturn(enrichedRequest);
            when(erledigungOutPort.search(CONTEXT, enrichedRequest)).thenReturn(expected);

            final List<ErledigungResponse> result = useCase.search(CONTEXT, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request);
            verify(erledigungOutPort).search(CONTEXT, enrichedRequest);
        }
    }

    @Nested
    class Get {
        @Test
        void givenEmptyAttributes_thenLoadDfVAttributesAndReturnResult() {
            final ErledigungResponse response = ErledigungResponse.builder().id(ERLEDIGUNG_ID).build();
            final Optional<ErledigungResponse> expected = Optional.of(response);
            when(dfvOutPort.loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT)).thenReturn(DFV_ATTRIBUTES);
            when(erledigungOutPort.get(CONTEXT, ERLEDIGUNG_ID, DFV_ATTRIBUTES)).thenReturn(expected);

            final Optional<ErledigungResponse> result = useCase.get(CONTEXT, ERLEDIGUNG_ID, Set.of());

            assertEquals(expected, result);
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT);
            verify(erledigungOutPort).get(CONTEXT, ERLEDIGUNG_ID, DFV_ATTRIBUTES);
        }

        @Test
        void givenExplicitAttributes_thenDelegateAttributesAndReturnResult() {
            final ErledigungResponse response = ErledigungResponse.builder().id(ERLEDIGUNG_ID).build();
            final Optional<ErledigungResponse> expected = Optional.of(response);
            when(erledigungOutPort.get(CONTEXT, ERLEDIGUNG_ID, EXPLICIT_ATTRIBUTES)).thenReturn(expected);

            final Optional<ErledigungResponse> result = useCase.get(CONTEXT, ERLEDIGUNG_ID, EXPLICIT_ATTRIBUTES);

            assertEquals(expected, result);
            verify(erledigungOutPort).get(CONTEXT, ERLEDIGUNG_ID, EXPLICIT_ATTRIBUTES);
            verifyNoInteractions(dfvOutPort);
        }
    }

    private static SearchRequest requestWithAttributes(final Set<String> attributes) {
        return SearchRequest.builder().limit(10).query("query").attributes(attributes).build();
    }
}

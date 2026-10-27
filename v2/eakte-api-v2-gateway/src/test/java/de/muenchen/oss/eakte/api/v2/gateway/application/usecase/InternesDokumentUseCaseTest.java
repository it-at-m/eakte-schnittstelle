package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.InternesDokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
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
class InternesDokumentUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", "role");
    private static final String DOKUMENT_ID = "internes-dokument-id";
    private static final Set<String> DFV_ATTRIBUTES = Set.of("dfv.one");
    private static final Set<String> EXPLICIT_ATTRIBUTES = Set.of("explicit");

    @Mock
    private InternesDokumentOutPort internesDokumentOutPort;

    @Mock
    private DfvOutPort dfvOutPort;

    @Mock
    private DfvHelper dfvHelper;

    private InternesDokumentUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new InternesDokumentUseCase(internesDokumentOutPort, dfvOutPort, dfvHelper);
    }

    @Nested
    class Search {
        @Test
        void givenSearchRequest_thenDelegateEnrichedRequestAndReturnResults() {
            final SearchRequest request = requestWithAttributes(EXPLICIT_ATTRIBUTES);
            final SearchRequest enrichedRequest = requestWithAttributes(DFV_ATTRIBUTES);
            final List<InternesDokumentResponse> expected = List.of(InternesDokumentResponse.builder().id(DOKUMENT_ID).build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request)).thenReturn(enrichedRequest);
            when(internesDokumentOutPort.search(CONTEXT, enrichedRequest)).thenReturn(expected);

            final List<InternesDokumentResponse> result = useCase.search(CONTEXT, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request);
            verify(internesDokumentOutPort).search(CONTEXT, enrichedRequest);
        }
    }

    @Nested
    class Get {
        @Test
        void givenEmptyAttributes_thenLoadDfVAttributesAndReturnResult() {
            final InternesDokumentResponse response = InternesDokumentResponse.builder().id(DOKUMENT_ID).build();
            final Optional<InternesDokumentResponse> expected = Optional.of(response);
            when(dfvOutPort.loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT)).thenReturn(DFV_ATTRIBUTES);
            when(internesDokumentOutPort.get(CONTEXT, DOKUMENT_ID, DFV_ATTRIBUTES)).thenReturn(expected);

            final Optional<InternesDokumentResponse> result = useCase.get(CONTEXT, DOKUMENT_ID, Set.of());

            assertEquals(expected, result);
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT);
            verify(internesDokumentOutPort).get(CONTEXT, DOKUMENT_ID, DFV_ATTRIBUTES);
        }

        @Test
        void givenExplicitAttributes_thenDelegateAttributesAndReturnResult() {
            final InternesDokumentResponse response = InternesDokumentResponse.builder().id(DOKUMENT_ID).build();
            final Optional<InternesDokumentResponse> expected = Optional.of(response);
            when(internesDokumentOutPort.get(CONTEXT, DOKUMENT_ID, EXPLICIT_ATTRIBUTES)).thenReturn(expected);

            final Optional<InternesDokumentResponse> result = useCase.get(CONTEXT, DOKUMENT_ID, EXPLICIT_ATTRIBUTES);

            assertEquals(expected, result);
            verify(internesDokumentOutPort).get(CONTEXT, DOKUMENT_ID, EXPLICIT_ATTRIBUTES);
            verifyNoInteractions(dfvOutPort);
        }
    }

    private static SearchRequest requestWithAttributes(final Set<String> attributes) {
        return SearchRequest.builder().limit(10).query("query").attributes(attributes).build();
    }
}

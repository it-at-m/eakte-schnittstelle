package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.EingangsdokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Role;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
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
class EingangsdokumentUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", Role.SACHBEARBEITUNG);
    private static final String EINGANGSDOKUMENT_ID = "eingangsdokument-id";
    private static final Set<String> DFV_ATTRIBUTES = Set.of("dfv.one");
    private static final Set<String> EXPLICIT_ATTRIBUTES = Set.of("explicit");

    @Mock
    private EingangsdokumentOutPort eingangsdokumentOutPort;

    @Mock
    private DfvOutPort dfvOutPort;

    @Mock
    private DfvHelper dfvHelper;

    private EingangsdokumentUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new EingangsdokumentUseCase(eingangsdokumentOutPort, dfvOutPort, dfvHelper);
    }

    @Nested
    class Search {
        @Test
        void givenSearchRequest_thenDelegateEnrichedRequestAndReturnResults() {
            final SearchRequest request = requestWithAttributes(EXPLICIT_ATTRIBUTES);
            final SearchRequest enrichedRequest = requestWithAttributes(DFV_ATTRIBUTES);
            final List<EingangsdokumentResponse> expected = List.of(EingangsdokumentResponse.builder().id(EINGANGSDOKUMENT_ID).build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request)).thenReturn(enrichedRequest);
            when(eingangsdokumentOutPort.search(CONTEXT, enrichedRequest)).thenReturn(expected);

            final List<EingangsdokumentResponse> result = useCase.search(CONTEXT, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request);
            verify(eingangsdokumentOutPort).search(CONTEXT, enrichedRequest);
        }
    }

    @Nested
    class Get {
        @Test
        void givenEmptyAttributes_thenLoadDfVAttributesAndReturnResult() {
            final EingangsdokumentResponse response = EingangsdokumentResponse.builder().id(EINGANGSDOKUMENT_ID).build();
            final Optional<EingangsdokumentResponse> expected = Optional.of(response);
            when(dfvOutPort.loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT)).thenReturn(DFV_ATTRIBUTES);
            when(eingangsdokumentOutPort.get(CONTEXT, EINGANGSDOKUMENT_ID, DFV_ATTRIBUTES)).thenReturn(expected);

            final Optional<EingangsdokumentResponse> result = useCase.get(CONTEXT, EINGANGSDOKUMENT_ID, Set.of());

            assertEquals(expected, result);
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, ObjectType.DOKUMENT);
            verify(eingangsdokumentOutPort).get(CONTEXT, EINGANGSDOKUMENT_ID, DFV_ATTRIBUTES);
        }

        @Test
        void givenExplicitAttributes_thenDelegateAttributesAndReturnResult() {
            final EingangsdokumentResponse response = EingangsdokumentResponse.builder().id(EINGANGSDOKUMENT_ID).build();
            final Optional<EingangsdokumentResponse> expected = Optional.of(response);
            when(eingangsdokumentOutPort.get(CONTEXT, EINGANGSDOKUMENT_ID, EXPLICIT_ATTRIBUTES)).thenReturn(expected);

            final Optional<EingangsdokumentResponse> result = useCase.get(CONTEXT, EINGANGSDOKUMENT_ID, EXPLICIT_ATTRIBUTES);

            assertEquals(expected, result);
            verify(eingangsdokumentOutPort).get(CONTEXT, EINGANGSDOKUMENT_ID, EXPLICIT_ATTRIBUTES);
            verifyNoInteractions(dfvOutPort);
        }
    }

    private static SearchRequest requestWithAttributes(final Set<String> attributes) {
        return SearchRequest.builder().limit(10).query("query").attributes(attributes).build();
    }
}

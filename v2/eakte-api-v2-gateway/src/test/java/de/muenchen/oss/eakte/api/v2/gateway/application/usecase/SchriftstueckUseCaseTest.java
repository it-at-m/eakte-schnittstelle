package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SchriftstueckOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Stelle;
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
class SchriftstueckUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", Stelle.SACHBEARBEITUNG);
    private static final String DOKUMENT_ID = "dokument-id";
    private static final String SCHRIFTSTUECK_ID = "schriftstueck-id";
    private static final SearchRequest REQUEST = SearchRequest.builder()
            .limit(10)
            .query("query")
            .attributes(Set.of())
            .build();

    @Mock
    private SchriftstueckOutPort schriftstueckOutPort;

    private SchriftstueckUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new SchriftstueckUseCase(schriftstueckOutPort);
    }

    @Nested
    class SearchBellowDokument {
        @Test
        void givenSearchRequest_thenDelegateUnchangedRequestAndReturnResults() {
            final List<SchriftstueckResponse> expected = List.of(SchriftstueckResponse.builder()
                    .id(SCHRIFTSTUECK_ID)
                    .build());
            when(schriftstueckOutPort.searchBellowDokument(CONTEXT, DOKUMENT_ID, REQUEST)).thenReturn(expected);

            final List<SchriftstueckResponse> result = useCase.searchBellowDokument(CONTEXT, DOKUMENT_ID, REQUEST);

            assertEquals(expected, result);
        }
    }

    @Nested
    class Get {
        @Test
        void givenSchriftstueckId_thenDelegateAndReturnResultWithoutLoadingDfvAttributes() {
            final Optional<SchriftstueckResponse> expected = Optional.empty();
            when(schriftstueckOutPort.get(CONTEXT, SCHRIFTSTUECK_ID)).thenReturn(expected);

            final Optional<SchriftstueckResponse> result = useCase.get(CONTEXT, SCHRIFTSTUECK_ID);

            assertEquals(expected, result);
        }
    }
}

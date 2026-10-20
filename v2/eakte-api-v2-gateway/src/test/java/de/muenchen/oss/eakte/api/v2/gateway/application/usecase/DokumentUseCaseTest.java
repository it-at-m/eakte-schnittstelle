package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DokumentUseCaseTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", "role");
    private static final String VORGANG_ID = "vorgang-id";

    @Mock
    private DokumentOutPort dokumentOutPort;

    @Mock
    private DfvHelper dfvHelper;

    private DokumentUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new DokumentUseCase(dokumentOutPort, dfvHelper);
    }

    @Nested
    class VorgangDokumente {
        @Test
        void givenSearchRequest_thenDelegateDfvTypeArgumentsAndReturnResults() {
            final SearchRequest request = SearchRequest.builder().limit(10).query("query").attributes(Set.of()).build();
            final SearchRequest enrichedRequest = SearchRequest.builder().limit(10).query("query").attributes(Set.of("dfv.one")).build();
            final List<DokumentResponse> expected = List.of(DokumentResponse.builder().id("document-id").build());
            when(dfvHelper.enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request)).thenReturn(enrichedRequest);
            when(dokumentOutPort.searchBellowVorgang(CONTEXT, VORGANG_ID, enrichedRequest)).thenReturn(expected);

            final List<DokumentResponse> result = useCase.searchBellowVorgang(CONTEXT, VORGANG_ID, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, ObjectType.DOKUMENT, request);
            verify(dokumentOutPort).searchBellowVorgang(CONTEXT, VORGANG_ID, enrichedRequest);
        }
    }
}

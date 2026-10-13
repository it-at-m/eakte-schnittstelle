package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.VorgangOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
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
    private static final CreateVorgangRequest CREATE_REQUEST = new CreateVorgangRequest(
            "akte-id", "name", "subject", "template-id", VorgangMedium.ELEKTRONISCH, true, "remark", "acl");
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
            when(dfvHelper.enrichWithDfv(CONTEXT, FabasoftObjectType.VORGANG, request)).thenReturn(enrichedRequest);
            when(vorgangOutPort.search(CONTEXT, enrichedRequest)).thenReturn(expected);

            final List<VorgangResponse> result = useCase.search(CONTEXT, request);

            assertEquals(expected, result);
            verify(dfvHelper).enrichWithDfv(CONTEXT, FabasoftObjectType.VORGANG, request);
            verify(vorgangOutPort).search(CONTEXT, enrichedRequest);
        }
    }

    @Nested
    class Get {
        @Test
        void givenEmptyAttributes_thenLoadVorgangDfvAttributesAndReturnResult() {
            final Optional<VorgangResponse> expected = Optional.empty();
            when(dfvOutPort.loadDfVAttributes(CONTEXT, FabasoftObjectType.VORGANG)).thenReturn(DFV_ATTRIBUTES);
            when(vorgangOutPort.get(CONTEXT, VORGANG_ID, DFV_ATTRIBUTES)).thenReturn(expected);

            final Optional<VorgangResponse> result = useCase.get(CONTEXT, VORGANG_ID, Set.of());

            assertEquals(expected, result);
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, FabasoftObjectType.VORGANG);
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

    @Nested
    class Create {
        @Test
        void givenCreateRequest_thenDelegateAndReturnVorgangId() {
            when(vorgangOutPort.createAkteVorgang(CONTEXT, CREATE_REQUEST)).thenReturn(VORGANG_ID);

            final String result = useCase.createAkteVorgang(CONTEXT, CREATE_REQUEST);

            assertEquals(VORGANG_ID, result);
            verify(vorgangOutPort).createAkteVorgang(CONTEXT, CREATE_REQUEST);
            verifyNoInteractions(dfvHelper, dfvOutPort);
        }
    }

    private static SearchRequest requestWithAttributes(final Set<String> attributes) {
        return SearchRequest.builder().limit(10).query("query").attributes(attributes).build();
    }
}

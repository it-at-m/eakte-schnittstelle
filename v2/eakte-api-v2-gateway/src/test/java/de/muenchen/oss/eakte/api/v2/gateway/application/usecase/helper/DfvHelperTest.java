package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DfvHelperTest {
    private static final RequestContext CONTEXT = new RequestContext("user", "ou", "role");
    private static final Set<String> DFV_ATTRIBUTES = Set.of("dfv.one", "dfv.two");

    @Mock
    private DfvOutPort dfvOutPort;

    private DfvHelper helper;

    @BeforeEach
    void setUp() {
        helper = new DfvHelper(dfvOutPort);
    }

    @Nested
    class EnrichtWithDfv {
        @Test
        void givenEmptyAttributes_thenLoadAndAddDfvAttributes() {
            final SearchRequest request = SearchRequest.builder()
                    .limit(10)
                    .query("query")
                    .attributes(Set.of())
                    .build();
            when(dfvOutPort.loadDfVAttributes(CONTEXT, FabasoftObjectType.DOKUMENT)).thenReturn(DFV_ATTRIBUTES);

            final SearchRequest result = helper.enrichWithDfv(CONTEXT, FabasoftObjectType.DOKUMENT, request);

            assertEquals(DFV_ATTRIBUTES, result.attributes());
            assertEquals(request.limit(), result.limit());
            assertEquals(request.query(), result.query());
            verify(dfvOutPort).loadDfVAttributes(CONTEXT, FabasoftObjectType.DOKUMENT);
        }

        @Test
        void givenExplicitAttributes_thenReturnOriginalRequest() {
            final SearchRequest request = SearchRequest.builder()
                    .limit(10)
                    .query("query")
                    .attributes(Set.of("explicit"))
                    .build();

            final SearchRequest result = helper.enrichWithDfv(CONTEXT, FabasoftObjectType.VORGANG, request);

            assertSame(request, result);
            verifyNoInteractions(dfvOutPort);
        }
    }
}

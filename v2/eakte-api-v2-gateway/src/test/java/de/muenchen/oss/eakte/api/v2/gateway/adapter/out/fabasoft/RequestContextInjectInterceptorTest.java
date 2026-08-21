package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.List;
import java.util.Map;
import org.apache.cxf.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

@SuppressWarnings("unchecked")
class RequestContextInjectInterceptorTest {
    private static final String USER_HEADER = "X-FSC-Authenticated-User";

    private final RequestContextProvider contextProvider = new RequestContextProvider();
    private RequestContextInjectInterceptor interceptor;

    @BeforeEach
    void setUp() {
        interceptor = new RequestContextInjectInterceptor(contextProvider);
        contextProvider.clear();
    }

    @Test
    void givenNoContext_thenThrowIllegalStateException() {
        final Message message = mock(Message.class);

        assertThrows(IllegalStateException.class, () -> interceptor.handleMessage(message));
    }

    @Test
    void givenNoImpersonationUser_thenLeaveHeadersUnchanged() {
        final Message message = mock(Message.class);
        contextProvider.set(new RequestContext(null, "ou", "role"));

        interceptor.handleMessage(message);

        org.mockito.Mockito.verifyNoInteractions(message);
    }

    @Test
    void givenImpersonationUserAndNoHeaders_thenCreateUserHeader() {
        final Message message = mock(Message.class);
        contextProvider.set(new RequestContext("user", "ou", "role"));

        interceptor.handleMessage(message);

        final ArgumentCaptor<Map<String, List<String>>> headersCaptor = ArgumentCaptor.forClass(Map.class);
        verify(message).put(eq(Message.PROTOCOL_HEADERS), headersCaptor.capture());
        final Map<String, List<String>> headers = headersCaptor.getValue();
        assertEquals(List.of("user"), headers.get(USER_HEADER));
    }

    @Test
    void givenExistingHeaders_thenPreserveHeadersAndSetUserHeader() {
        final Message message = mock(Message.class);
        final Map<String, List<String>> headers = new java.util.HashMap<>();
        headers.put("Existing", List.of("value"));
        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);
        contextProvider.set(new RequestContext("user", "ou", "role"));

        interceptor.handleMessage(message);

        assertEquals(List.of("value"), headers.get("Existing"));
        assertEquals(List.of("user"), headers.get(USER_HEADER));
    }

}

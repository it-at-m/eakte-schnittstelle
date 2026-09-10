package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    private static final String ENDPOINT = "https://example.org/fscgov";

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
        when(message.get(Message.ENDPOINT_ADDRESS)).thenReturn(ENDPOINT);

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
        when(message.get(Message.ENDPOINT_ADDRESS)).thenReturn(ENDPOINT);
        contextProvider.set(new RequestContext("user", "ou", "role"));

        interceptor.handleMessage(message);

        assertEquals(List.of("value"), headers.get("Existing"));
        assertEquals(List.of("user"), headers.get(USER_HEADER));
    }

    @Test
    void givenOuAndRole_thenAppendEncodedQueryParameters() {
        final Message message = mock(Message.class);
        when(message.get(Message.ENDPOINT_ADDRESS)).thenReturn(ENDPOINT);
        contextProvider.set(new RequestContext("user", "ou with space", "role/value"));

        interceptor.handleMessage(message);

        final ArgumentCaptor<String> endpointCaptor = ArgumentCaptor.forClass(String.class);
        verify(message).put(eq(Message.ENDPOINT_ADDRESS), endpointCaptor.capture());
        final String updatedEndpoint = endpointCaptor.getValue();
        assertTrue(updatedEndpoint.startsWith(ENDPOINT + "?"));
        assertTrue(updatedEndpoint.contains("px=role%2Fvalue"));
        assertTrue(updatedEndpoint.contains("gx=ou+with+space"));
    }

    @Test
    void givenExistingQueryParameters_thenAppendContextQueryParameters() {
        final Message message = mock(Message.class);
        final String endpoint = ENDPOINT + "?existing=value";
        when(message.get(Message.ENDPOINT_ADDRESS)).thenReturn(endpoint);
        contextProvider.set(new RequestContext("user", "ou", "role"));

        interceptor.handleMessage(message);

        final ArgumentCaptor<String> endpointCaptor = ArgumentCaptor.forClass(String.class);
        verify(message).put(eq(Message.ENDPOINT_ADDRESS), endpointCaptor.capture());
        final String updatedEndpoint = endpointCaptor.getValue();
        assertTrue(updatedEndpoint.startsWith(endpoint + "&"));
        assertTrue(updatedEndpoint.contains("px=role"));
        assertTrue(updatedEndpoint.contains("gx=ou"));
    }

    @Test
    void givenNoOuAndRole_thenLeaveEndpointUnchanged() {
        final Message message = mock(Message.class);
        when(message.get(Message.ENDPOINT_ADDRESS)).thenReturn(ENDPOINT);
        contextProvider.set(new RequestContext("user", null, null));

        interceptor.handleMessage(message);

        verify(message, org.mockito.Mockito.never()).put(eq(Message.ENDPOINT_ADDRESS), org.mockito.Mockito.any());
    }

}

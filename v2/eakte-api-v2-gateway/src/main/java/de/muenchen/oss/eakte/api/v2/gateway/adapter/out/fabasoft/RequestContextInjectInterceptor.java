package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

/**
 * CXF interceptor to inject {@link RequestContext} into requests.
 * <p>
 * An interceptor is used to allow the reuse of clients (and preserve the client pooling), as
 * otherwise a new client needs to be created for each unique request context.
 * <p>
 * Uses {@link RequestContextProvider} to get a thread scoped context.
 */
@Component
public class RequestContextInjectInterceptor extends AbstractPhaseInterceptor<Message> {
    private static final String USER_HEADER = "X-FSC-Authenticated-User";

    private final RequestContextProvider contextProvider;

    protected RequestContextInjectInterceptor(final RequestContextProvider contextProvider) {
        super(Phase.PREPARE_SEND);
        this.contextProvider = contextProvider;
    }

    @Override
    public void handleMessage(final Message message) {
        final RequestContext context = contextProvider.get();
        if (context == null) {
            throw new IllegalStateException("Request context needs to be set before SOAP requests");
        }
        if (contextProvider.get().impersonationUser() == null) {
            return;
        }

        // HTTP headers
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
        if (headers == null) {
            headers = new HashMap<>();
            message.put(Message.PROTOCOL_HEADERS, headers);
        }
        headers.put(
                USER_HEADER,
                List.of(contextProvider.get().impersonationUser()));

        // TODO include AX BX Headers
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    private static final String ROLE_QUERY_PARAM = "px";
    private static final String OU_QUERY_PARAM = "gx";

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

        injectHttpHeaders(message, context);
        injectQueryParameters(message, context);
    }

    private void injectHttpHeaders(final Message message, final RequestContext context) {
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
        if (headers == null) {
            headers = new HashMap<>();
            message.put(Message.PROTOCOL_HEADERS, headers);
        }
        headers.put(
                USER_HEADER,
                List.of(context.impersonationUser()));
    }

    private void injectQueryParameters(final Message message, final RequestContext context) {
        final String uri = (String) message.get(Message.ENDPOINT_ADDRESS);
        if (!StringUtils.hasText(uri)) {
            throw new IllegalStateException("CXF endpoint URI needs to be present");
        }
        final Map<String, String> params = new HashMap<>();
        if (StringUtils.hasText(contextProvider.get().role())) {
            params.put(ROLE_QUERY_PARAM, context.role());
        }
        if (StringUtils.hasText(contextProvider.get().ou())) {
            params.put(OU_QUERY_PARAM, context.ou());

        }
        if (!params.isEmpty()) {
            final String separator = uri.contains("?") ? "&" : "?";
            final String additionalParams = String.join("&", params.entrySet().stream()
                    .map((i) -> "%s=%s".formatted(i.getKey(), encode(i.getValue()))).toList());
            message.put(Message.ENDPOINT_ADDRESS, uri + separator + additionalParams);
        }
    }

    private String encode(final String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}

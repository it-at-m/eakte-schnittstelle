package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class RequestContextProvider {
    private final ThreadLocal<RequestContext> requestContext = new ThreadLocal<>();

    protected void set(final RequestContext requestContext) {
        this.requestContext.set(requestContext);
    }

    protected RequestContext get() {
        return this.requestContext.get();
    }

    protected void clear() {
        this.requestContext.remove();
    }
}

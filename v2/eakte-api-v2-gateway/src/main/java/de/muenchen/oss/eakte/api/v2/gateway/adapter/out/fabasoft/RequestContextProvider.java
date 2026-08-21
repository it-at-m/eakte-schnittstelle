package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import org.springframework.stereotype.Component;

/**
 * Helper class for {@link RequestContextInjectInterceptor}, which holdes thread scoped
 * {@link RequestContext}s.
 * <p>
 * As a single API request is handled continuously in one thread this class can be used for setting
 * and retrieving the request context via a singleton.
 */
@Component
public class RequestContextProvider {
    private final ThreadLocal<RequestContext> requestContext = new ThreadLocal<>();

    /**
     * Set the request context for the calling thread.
     */
    protected void set(final RequestContext requestContext) {
        this.requestContext.set(requestContext);
    }

    /**
     * Get the request context of the calling thread.
     *
     * @return The request context.
     */
    protected RequestContext get() {
        return this.requestContext.get();
    }

    /**
     * Clear the request context for the current thread.
     */
    protected void clear() {
        this.requestContext.remove();
    }
}

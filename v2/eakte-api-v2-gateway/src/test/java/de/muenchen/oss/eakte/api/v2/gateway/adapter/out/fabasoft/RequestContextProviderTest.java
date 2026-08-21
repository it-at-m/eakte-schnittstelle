package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class RequestContextProviderTest {
    @Test
    void givenContext_thenReturnContextAfterSetAndGet() {
        final RequestContextProvider provider = new RequestContextProvider();
        final RequestContext context = new RequestContext("user", "ou", "role");

        provider.set(context);

        assertEquals(context, provider.get());
    }

    @Test
    void givenContext_thenRemoveContextAfterClear() {
        final RequestContextProvider provider = new RequestContextProvider();
        provider.set(new RequestContext("user", "ou", "role"));

        provider.clear();

        assertNull(provider.get());
    }

    @Test
    void givenDifferentThreads_thenKeepContextsIsolated() throws Exception {
        final RequestContextProvider provider = new RequestContextProvider();
        final RequestContext firstContext = new RequestContext("first", "ou", "role");
        final RequestContext secondContext = new RequestContext("second", "ou", "role");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            final var first = executor.submit(() -> {
                provider.set(firstContext);
                return provider.get();
            });
            final var second = executor.submit(() -> {
                provider.set(secondContext);
                return provider.get();
            });

            assertEquals(firstContext, first.get());
            assertEquals(secondContext, second.get());
        }
    }

    @Test
    void givenContextOnOneThread_thenClearDoesNotAffectAnotherThread() throws Exception {
        final RequestContextProvider provider = new RequestContextProvider();
        final RequestContext context = new RequestContext("user", "ou", "role");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            final var first = executor.submit(() -> {
                provider.set(context);
                provider.clear();
                return provider.get();
            });
            final var second = executor.submit(() -> {
                provider.set(context);
                return provider.get();
            });

            assertNull(first.get());
            assertEquals(context, second.get());
        }
    }

    @Test
    void givenFreshThread_thenReturnNullContext() throws InterruptedException, ExecutionException {
        final RequestContextProvider provider = new RequestContextProvider();
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            assertNull(executor.submit(provider::get).get());
        }
    }
}

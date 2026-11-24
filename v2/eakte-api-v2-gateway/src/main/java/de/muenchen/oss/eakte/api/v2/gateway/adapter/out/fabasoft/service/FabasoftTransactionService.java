package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsAbortException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FabasoftTransactionService {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftRequestHandler requestHandler;

    /**
     * Executes a task in a transaction, committing on success and aborting on failure.
     * If the abort succeeds, the original task exception is rethrown.
     *
     * @param context The request context for commit and abort calls.
     * @param task The task to execute with the transaction.
     * @param <T> The task result type.
     * @return The task result after a successful commit.
     * @throws DmsAbortException If the task fails and the transaction cannot be aborted.
     * @throws RuntimeException The original task exception, if abort succeeds.
     */
    public <T> T execute(final RequestContext context, final Function<FabasoftTransaction, T> task) {
        final FabasoftTransaction transaction = new FabasoftTransaction();
        final T result;
        try {
            result = task.apply(transaction);
        } catch (final Exception exception) {
            try {
                this.abort(context, transaction);
            } catch (final RuntimeException abortException) {
                log.warn("Aborting transaction failed");
                throw new DmsAbortException(
                        transaction.getHolder().value.getTransaction(),
                        abortException, exception);
            }
            throw exception;
        }
        this.commit(context, transaction);
        return result;
    }

    private void commit(final RequestContext requestContext, @NonNull final FabasoftTransaction transaction) {
        requestHandler.handleRequest("transactionCommit", requestContext,
                () -> {
                    soapClient.soapCommit(transaction.getHolder());
                    return null;
                });
        log.info("Transaction commited");
    }

    private void abort(final RequestContext requestContext, @NonNull final FabasoftTransaction transaction) {
        requestHandler.handleRequest("transactionCommit", requestContext,
                () -> {
                    soapClient.soapAbort(transaction.getHolder());
                    return null;
                });
        log.info("Transaction aborted");
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
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
                exception.addSuppressed(abortException);
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

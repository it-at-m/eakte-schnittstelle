package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.RequestContextProvider;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftTransaction;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftTransactionServiceTest {
    private static final RequestContext CONTEXT = new RequestContext("user", null, null);

    @Mock
    private FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;

    private FabasoftTransactionService service;

    @BeforeEach
    void setUp() {
        service = new FabasoftTransactionService(soapClient, new FabasoftRequestHandler(new RequestContextProvider()));
    }

    @Test
    void givenSuccessfulTask_thenCommitTransactionAndReturnResult() {
        final AtomicReference<FabasoftTransaction> transaction = new AtomicReference<>();

        final String result = service.execute(CONTEXT, current -> {
            transaction.set(current);
            assertFalse(current.getHolder().value.isCommit());
            return "result";
        });

        assertEquals("result", result);
        verify(soapClient).soapCommit(transaction.get().getHolder());
        verify(soapClient, never()).soapAbort(any());
    }

    @Test
    void givenTaskFailure_thenAbortTransactionAndRethrowOriginal() {
        final RuntimeException failure = new RuntimeException("task failed");
        final AtomicReference<FabasoftTransaction> transaction = new AtomicReference<>();

        final RuntimeException thrown = assertThrows(RuntimeException.class, () -> service.execute(CONTEXT, current -> {
            transaction.set(current);
            throw failure;
        }));

        assertSame(failure, thrown);
        verify(soapClient).soapAbort(transaction.get().getHolder());
        verify(soapClient, never()).soapCommit(any());
    }

    @Test
    void givenAbortFailure_thenSuppressItOnOriginalTaskFailure() {
        final RuntimeException failure = new RuntimeException("task failed");
        final RuntimeException abortFailure = new RuntimeException("abort failed");
        doThrow(abortFailure).when(soapClient).soapAbort(any());

        final RuntimeException thrown = assertThrows(RuntimeException.class, () -> service.execute(CONTEXT, current -> {
            throw failure;
        }));

        assertSame(failure, thrown);
        assertEquals(1, thrown.getSuppressed().length);
        assertSame(abortFailure, thrown.getSuppressed()[0].getCause());
        verify(soapClient, never()).soapCommit(any());
    }

    @Test
    void givenCommitFailure_thenPropagateFailureWithoutAborting() {
        final RuntimeException failure = new RuntimeException("commit failed");
        doThrow(failure).when(soapClient).soapCommit(any());

        final DmsException thrown = assertThrows(DmsException.class, () -> service.execute(CONTEXT, current -> "result"));

        assertSame(failure, thrown.getCause());
        verify(soapClient, never()).soapAbort(any());
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler.FS_NAMESPACE;
import static de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler.TAG_ERROR_REFERENCE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsResponseException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import jakarta.xml.ws.WebServiceException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapFault;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class FabasoftRequestHandlerTest {
    private static final String CALL_NAME = "searchObject";
    private static final RequestContext REQUEST_CONTEXT = new RequestContext("user", "ou", "role");

    private RequestContextProvider contextProvider;
    private FabasoftRequestHandler errorHandler;

    @BeforeEach
    void setUp() {
        contextProvider = new RequestContextProvider();
        errorHandler = new FabasoftRequestHandler(contextProvider);
    }

    @Test
    void givenSuccessfulTask_thenReturnResultAndClearContext() {
        final String result = errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
            assertSame(REQUEST_CONTEXT, contextProvider.get());
            return "result";
        });

        assertEquals("result", result);
        assertNull(contextProvider.get());
    }

    @Test
    void givenGenericFailure_thenWrapWithCallNameAndClearContext() {
        final Exception cause = new Exception("failure");

        final DmsException exception = assertThrows(DmsException.class,
                () -> errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
                    throw cause;
                }));

        assertEquals("Error occurred during " + CALL_NAME, exception.getMessage());
        assertSame(cause, exception.getCause());
        assertNull(contextProvider.get());
    }

    @Test
    void givenSoapFaultWithErrorReference_thenExtractCodeAndMessage() {
        final SoapFault fault = soapFaultWithDetails("FS-123");
        final WebServiceException cause = new WebServiceException("web service failure", fault);

        final DmsResponseException exception = assertThrows(DmsResponseException.class,
                () -> errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
                    throw cause;
                }));

        assertEquals("FS-123", exception.getCode());
        assertEquals(fault.getMessage(), exception.getMessage());
        assertSame(cause, exception.getCause());
        assertNull(contextProvider.get());
    }

    @Test
    void givenSoapFaultWithoutDetails_thenReturnResponseExceptionWithoutCode() {
        final SoapFault fault = new SoapFault("soap failure", Soap11.getInstance().getFault());
        final WebServiceException cause = new WebServiceException("web service failure", fault);

        final DmsResponseException exception = assertThrows(DmsResponseException.class,
                () -> errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
                    throw cause;
                }));

        assertNull(exception.getCode());
    }

    @Test
    void givenSoapFaultWithMultipleErrorReferences_thenReturnResponseExceptionWithoutCode() {
        final SoapFault fault = soapFaultWithDetails("FS-123", "FS-456");
        final WebServiceException cause = new WebServiceException("web service failure", fault);

        final DmsResponseException exception = assertThrows(DmsResponseException.class,
                () -> errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
                    throw cause;
                }));

        assertNull(exception.getCode());
    }

    @Test
    void givenWebServiceFailureWithoutSoapFault_thenUseFallbackException() {
        final WebServiceException cause = new WebServiceException("web service failure");

        final DmsException exception = assertThrows(DmsException.class,
                () -> errorHandler.handleRequest(CALL_NAME, REQUEST_CONTEXT, () -> {
                    throw cause;
                }));

        assertEquals("Error occurred during " + CALL_NAME, exception.getMessage());
        assertSame(cause, exception.getCause());
        assertNull(contextProvider.get());
    }

    private static SoapFault soapFaultWithDetails(final String... references) {
        try {
            final Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            final Element detail = document.createElement("detail");
            document.appendChild(detail);
            for (final String reference : references) {
                final Element errorReference = document.createElementNS(FS_NAMESPACE, TAG_ERROR_REFERENCE);
                errorReference.setTextContent(reference);
                detail.appendChild(errorReference);
            }
            final SoapFault fault = new SoapFault("soap failure", Soap11.getInstance().getFault());
            fault.setDetail(detail);
            return fault;
        } catch (final Exception e) {
            throw new IllegalStateException("Could not create SOAP fault for test", e);
        }
    }
}

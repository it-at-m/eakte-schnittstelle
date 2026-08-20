package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsResponseException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import jakarta.xml.ws.WebServiceException;
import java.util.concurrent.Callable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

/**
 * Helper class for handling errors which occur during Fabasoft API calls.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class FabasoftErrorHandler {
    public static final String FS_NAMESPACE = "http://schemas.fabasoft.com/faultdetails";
    public static final String TAG_ERROR_REFERENCE = "ErrorReference";

    private final RequestContextProvider contextProvider;

    /**
     * Helper method for executing Fabasoft calls and handle occuring errors by extract response error
     * codes and mapping to
     * {@link DmsException}s.
     *
     * @param name The name of the executing calls, used for clearer error messages.
     * @param requestContext The request context to execute the call under.
     * @param task The method to execute.
     * @return The return of the method.
     * @param <T> The return type of the method.
     */
    public <T> T handleErrors(final String name, final RequestContext requestContext, final Callable<T> task) {
        try {
            contextProvider.set(requestContext);
            return task.call();
        } catch (final WebServiceException e) {
            throw this.handleSoapFault(name, e);
        } catch (final Exception e) {
            // TODO different exceptions (e.g. Timeout, Client vs Server)
            throw fallbackEx(name, e);
        } finally {
            contextProvider.clear();
        }
    }

    /**
     * Method for extracting Fabasoft error codes from error responses.
     *
     * @param name The name of the call which lead to the exception, used of clearer error messages.
     * @param e The exception which contains the error response.
     * @return An exception containing the extracted error response information.
     */
    private DmsResponseException handleSoapFault(final String name, final WebServiceException e) {
        if (e.getCause() instanceof SoapFault sf) {
            if (sf.getDetail() == null) {
                return new DmsResponseException(null, sf.getMessage(), e);
            }
            final NodeList codeNodes = sf.getDetail().getElementsByTagNameNS(FS_NAMESPACE, TAG_ERROR_REFERENCE);
            final String code = codeNodes.getLength() == 1 ? codeNodes.item(0).getTextContent() : null;
            return new DmsResponseException(code, sf.getMessage(), e);
        }
        throw fallbackEx(name, e);
    }

    private DmsException fallbackEx(final String name, final Exception e) {
        return new DmsException("Error occurred during %s".formatted(name), e);
    }
}

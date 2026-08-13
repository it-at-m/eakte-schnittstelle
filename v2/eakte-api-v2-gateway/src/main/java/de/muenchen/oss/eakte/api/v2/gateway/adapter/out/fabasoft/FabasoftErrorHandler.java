package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsException;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.DmsResponseException;
import jakarta.xml.ws.WebServiceException;
import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

@Component
@Slf4j
public class FabasoftErrorHandler {

    public static final String FS_NAMESPACE = "http://schemas.fabasoft.com/faultdetails";
    public static final String TAG_ERROR_REFERENCE = "ErrorReference";

    public DmsResponseException handleSoapFault(final String name, final WebServiceException e) {
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

    public <T> T handleErrors(final String name, final Callable<T> task) {
        try {
            return task.call();
        } catch (final WebServiceException e) {
            throw this.handleSoapFault(name, e);
        } catch (final Exception e) {
            // TODO different exceptions (e.g. Timeout, Client vs Server)
            throw fallbackEx(name, e);
        }
    }

    private DmsException fallbackEx(final String name, final Exception e) {
        return new DmsException("Error occurred during %s".formatted(name), e);
    }
}

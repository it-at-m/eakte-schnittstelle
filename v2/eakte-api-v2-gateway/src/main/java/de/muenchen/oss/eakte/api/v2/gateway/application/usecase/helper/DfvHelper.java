package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DfvHelper {
    private final DfvOutPort dfvOutPort;

    /**
     * Enrich an SearchRequest with DfV attributes if no attributes are already present.
     *
     * @param request The request to enrich.
     * @return The enriched request.
     */
    public SearchRequest enrichWithDfv(final RequestContext context, final ObjectType type, final SearchRequest request) {
        final SearchRequest updatedRequest;
        if (request.attributes().isEmpty()) {
            final Set<String> dfvAttributes = dfvOutPort.loadDfVAttributes(context, type);
            updatedRequest = request.addAttributes(dfvAttributes);
        } else {
            updatedRequest = request;
        }
        return updatedRequest;
    }
}

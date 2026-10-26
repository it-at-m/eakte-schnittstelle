package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.ErledigungInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.ErledigungOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ErledigungUseCase implements ErledigungInPort {
    private final ErledigungOutPort erledigungOutPort;
    private final DfvOutPort dfvOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<ErledigungResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.DOKUMENT, request);
        return erledigungOutPort.search(context, enrichedRequest);
    }

    @Override
    public Optional<ErledigungResponse> get(final RequestContext context, final String erledigungsId, final Set<String> attributes) {
        final Set<String> updatedAttrs = attributes.isEmpty() ? dfvOutPort.loadDfVAttributes(context, ObjectType.DOKUMENT) : attributes;
        return erledigungOutPort.get(context, erledigungsId, updatedAttrs);
    }
}

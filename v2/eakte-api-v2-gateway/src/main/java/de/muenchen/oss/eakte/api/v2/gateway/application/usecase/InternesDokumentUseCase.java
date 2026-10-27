package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.InternesDokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.InternesDokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InternesDokumentUseCase implements InternesDokumentInPort {
    private final InternesDokumentOutPort internesDokumentOutPort;
    private final DfvOutPort dfvOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<InternesDokumentResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.DOKUMENT, request);
        return internesDokumentOutPort.search(context, enrichedRequest);
    }

    @Override
    public Optional<InternesDokumentResponse> get(final RequestContext context, final String dokumentId, final Set<String> attributes) {
        final Set<String> updatedAttrs = attributes.isEmpty() ? dfvOutPort.loadDfVAttributes(context, ObjectType.DOKUMENT) : attributes;
        return internesDokumentOutPort.get(context, dokumentId, updatedAttrs);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.EingangsdokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.EingangsdokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EingangsdokumentUseCase implements EingangsdokumentInPort {
    private final EingangsdokumentOutPort vorgangOutPort;
    private final DfvOutPort dfvOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<EingangsdokumentResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.DOKUMENT, request);
        return vorgangOutPort.search(context, enrichedRequest);
    }

    @Override
    public Optional<EingangsdokumentResponse> get(final RequestContext context, final String eingangsdokumentId, final Set<String> attributes) {
        final Set<String> updatedAttrs = attributes.isEmpty() ? dfvOutPort.loadDfVAttributes(context, ObjectType.DOKUMENT) : attributes;
        return vorgangOutPort.get(context, eingangsdokumentId, updatedAttrs);
    }
}

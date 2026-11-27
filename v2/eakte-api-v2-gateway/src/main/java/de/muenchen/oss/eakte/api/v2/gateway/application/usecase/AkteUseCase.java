package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.AkteInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.AkteOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AkteUseCase implements AkteInPort {
    private final AkteOutPort akteOutPort;
    private final DfvHelper dfvHelper;
    private final DfvOutPort dfvOutPort;

    @Override
    public List<AkteResponse> searchBellowAktenplan(final RequestContext context, final String aktenplaneintragId, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.AKTE, request);
        return akteOutPort.searchBellowAktenplan(context, aktenplaneintragId, enrichedRequest);
    }

    @Override
    public Optional<AkteResponse> get(final RequestContext context, final String aktenId, final Set<String> attributes) {
        final Set<String> updatedAttrs = attributes.isEmpty() ? dfvOutPort.loadDfVAttributes(context, ObjectType.AKTE) : attributes;
        return akteOutPort.get(context, aktenId, updatedAttrs);
    }
}

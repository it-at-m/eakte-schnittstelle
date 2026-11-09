package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.AkteInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.AkteOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AkteUseCase implements AkteInPort {
    private final AkteOutPort akteOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<AkteResponse> searchBellowAktenplan(final RequestContext context, final String aktenplaneintragId, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.AKTE, request);
        return akteOutPort.searchBellowAktenplan(context, aktenplaneintragId, enrichedRequest);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.DokumentInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DokumentUseCase implements DokumentInPort {
    private final DokumentOutPort dokumentOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<DokumentResponse> searchBellowVorgang(final RequestContext context, final String vorgangId, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, ObjectType.DOKUMENT, request);
        return dokumentOutPort.searchBellowVorgang(context, vorgangId, enrichedRequest);
    }
}

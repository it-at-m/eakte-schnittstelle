package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.SchriftstueckInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SchriftstueckOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchriftstueckUseCase implements SchriftstueckInPort {
    private final SchriftstueckOutPort schriftstueckOutPort;

    @Override
    public Optional<SchriftstueckResponse> get(final RequestContext context, final String vorgangId) {
        return schriftstueckOutPort.get(context, vorgangId);
    }

    @Override
    public List<SchriftstueckResponse> searchBellowDokument(final RequestContext context, final String akteId, final SearchRequest request) {
        return schriftstueckOutPort.searchBellowDokument(context, akteId, request);
    }
}

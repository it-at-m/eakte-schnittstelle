package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.VorgangOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.DfvHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VorgangUseCase implements VorgangInPort {
    private final VorgangOutPort vorgangOutPort;
    private final DfvOutPort dfvOutPort;
    private final DfvHelper dfvHelper;

    @Override
    public List<VorgangResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = dfvHelper.enrichWithDfv(context, FabasoftObjectType.VORGANG, request);
        return vorgangOutPort.search(context, enrichedRequest);
    }

    @Override
    public Optional<VorgangResponse> get(final RequestContext context, final String vorgangsId, final Set<String> attributes) {
        final Set<String> updatedAttrs = attributes.isEmpty() ? dfvOutPort.loadDfVAttributes(context, FabasoftObjectType.VORGANG) : attributes;
        return vorgangOutPort.get(context, vorgangsId, updatedAttrs);
    }

    @Override
    public String createAkteVorgang(final RequestContext requestContext, final CreateVorgangRequest vorgang) {
        return vorgangOutPort.createAkteVorgang(requestContext, vorgang);
    }
}

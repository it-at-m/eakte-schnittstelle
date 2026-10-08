package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.AkteInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.AttributesOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SubFileOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.mapper.VorgangMapper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AkteUseCase implements AkteInPort {
    private final SubFileOutPort subFileOutPort;
    private final AttributesOutPort attributesOutPort;
    private final VorgangMapper vorgangMapper;

    @Override
    public String createVorgang(final RequestContext requestContext, final CreateVorgangRequest vorgang) {
        final String vorgangId = subFileOutPort.createSubFile(requestContext, vorgangMapper.toSubFile(vorgang));
        attributesOutPort.setAttributes(requestContext, vorgangId, vorgangMapper.toAttributeList(vorgang));
        return vorgangId;
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AkteAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAkteMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.AkteOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabasoftAkteOutAdapter implements AkteOutPort {
    private static final String PARENT_QUERY = ".COOELAK@1.1001:referrednumber = '%s'";

    private final FabasoftSearchService searchService;
    private final FabasoftAkteMapper akteMapper;

    @Override
    public List<AkteResponse> searchBellowAktenplan(final RequestContext context, final String aktenplaneintragId, final SearchRequest request) {
        final String akteParentQuery = FabasoftAktenplanOutAdapter.getParentQuery(aktenplaneintragId);
        final SearchRequest enrichedRequest = request
                .addAttributes(AkteAttribute.getReferences())
                .concatQuery(akteParentQuery);
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.AKTE, enrichedRequest);
        return akteMapper.toDomain(result);
    }

    public static String getParentQuery(final String id) {
        if (!StringUtils.hasText(id) || !id.matches(FabasoftObjectType.COO_PATTERN)) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        return PARENT_QUERY.formatted(id);
    }
}

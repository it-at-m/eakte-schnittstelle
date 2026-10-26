package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.VorgangOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class FabasoftVorgangOutAdapter implements VorgangOutPort {
    private static final String PARENT_QUERY = ".COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = '%s'";

    private final FabasoftSearchService searchService;
    private final FabasoftVorgangMapper vorgangMapper;

    @Override
    public List<VorgangResponse> search(final RequestContext context, final SearchRequest request) {
        final SearchRequest enrichedRequest = request.addAttributes(VorgangAttribute.getReferences());
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.VORGANG, enrichedRequest);
        return vorgangMapper.toDomain(result);
    }

    @Override
    public Optional<VorgangResponse> get(final RequestContext context, final String vorgangId, final Set<String> attributes) {
        final Set<String> attributesWithDefault = AttributeHelper.combineAttributes(attributes, VorgangAttribute.getReferences());
        final Optional<ResultObject> result = searchService.getObject(context, FabasoftObjectType.VORGANG, vorgangId, attributesWithDefault);
        return result.map(vorgangMapper::toDomain);
    }

    public static String getParentQuery(final String id) {
        if (!StringUtils.hasText(id) || !id.matches(FabasoftObjectType.COO_PATTERN)) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        return PARENT_QUERY.formatted(id);
    }
}

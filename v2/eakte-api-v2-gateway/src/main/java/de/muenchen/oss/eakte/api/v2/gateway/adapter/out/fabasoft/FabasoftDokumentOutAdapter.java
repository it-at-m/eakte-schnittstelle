package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DokumentOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class FabasoftDokumentOutAdapter implements DokumentOutPort {
    private static final String PARENT_QUERY = ".COOELAK@1.1001:referrednumber = '%s'";

    private final FabasoftSearchService searchService;
    private final FabasoftDokumentMapper dokumentMapper;

    @Override
    public List<DokumentResponse> searchBellowVorgang(final RequestContext context, final String vorgangId, final SearchRequest request) {
        final String vorgangParentQuery = FabasoftVorgangOutAdapter.getParentQuery(vorgangId);
        final SearchRequest enrichedRequest = request
                .addAttributes(DokumentAttribute.getReferences())
                .concatQuery(vorgangParentQuery);
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.DOKUMENT, enrichedRequest);
        return dokumentMapper.toDomain(result);
    }

    public static String getBellowDokumentQuery(final String id) {
        if (!StringUtils.hasText(id) || !id.matches(FabasoftObjectType.COO_PATTERN)) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        return PARENT_QUERY.formatted(id);
    }
}

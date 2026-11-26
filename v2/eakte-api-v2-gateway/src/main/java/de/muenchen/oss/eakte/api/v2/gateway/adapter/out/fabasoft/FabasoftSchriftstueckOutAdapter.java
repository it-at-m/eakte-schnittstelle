package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SchriftstueckAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftSchriftstueckMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
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
public class FabasoftSchriftstueckOutAdapter implements SchriftstueckOutPort {
    private final FabasoftSearchService searchService;
    private final FabasoftSchriftstueckMapper schriftstueckMapper;

    @Override
    public List<SchriftstueckResponse> searchBellowDokument(final RequestContext context, final String dokumentId, final SearchRequest request) {
        final String dokumentParentQuery = FabasoftDokumentOutAdapter.getBellowDokumentQuery(dokumentId);
        final SearchRequest enrichedRequest = request
                .addAttributes(SchriftstueckAttribute.getReferences())
                .concatQuery(dokumentParentQuery);
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.SCHRIFTSTUECK, enrichedRequest);
        return schriftstueckMapper.toDomain(result);
    }

    @Override
    public Optional<SchriftstueckResponse> get(final RequestContext context, final String schriftstueckId) {
        final Optional<ResultObject> result = searchService.getObject(context, FabasoftObjectType.SCHRIFTSTUECK, schriftstueckId,
                SchriftstueckAttribute.getReferences());
        return result.map(schriftstueckMapper::toDomain);
    }
}

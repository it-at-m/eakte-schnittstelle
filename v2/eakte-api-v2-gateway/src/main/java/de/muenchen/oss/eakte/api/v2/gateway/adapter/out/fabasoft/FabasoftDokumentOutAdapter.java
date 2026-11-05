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

@Service
@RequiredArgsConstructor
public class FabasoftDokumentOutAdapter implements DokumentOutPort {
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
}

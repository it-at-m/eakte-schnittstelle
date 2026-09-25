package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BEARBEITUNGSSTATUS;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.BETREFF;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.GESCHAEFTSGANGVERMERK;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORGANISATIONSEINHEIT;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.SCHLAGWORTE_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute.STATUS;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.in.VorgangInPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.SearchHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VorgangUseCase implements VorgangInPort {
    private final SearchOutPort searchOutPort;
    private final SearchHelper searchHelper;

    public static final Set<String> DEFAULT_ATTRIBUTES = Set.of(
            PARENT_ID.getReference(), BETREFF.getReference(), NAME.getReference(), STATUS.getReference(),
            BEARBEITUNGSSTATUS.getReference(), SCHLAGWORTE_NAME.getReference(), ACL.getReference(), ORGANISATIONSEINHEIT.getReference(),
            ORIGINAL_MEDIUM.getReference(), GESCHAEFTSGANGVERMERK.getReference());

    @Override
    public SearchResult searchVorgang(final RequestContext context, final int limit, final String query, final Set<String> clientAttrs) {
        // build attributes to load
        final Set<String> attributes = new HashSet<>(DEFAULT_ATTRIBUTES);
        attributes.addAll(clientAttrs != null ? clientAttrs : searchHelper.loadDfVAttributes(context, SearchType.VORGANG));
        // search
        // TODO determine scope from request context
        final SearchRequest request = new SearchRequest(SearchType.VORGANG, null, limit, query, attributes);
        return searchOutPort.searchObject(context, request);
    }
}

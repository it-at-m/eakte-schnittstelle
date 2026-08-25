package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;

import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchHelper {
    private final SearchOutPort searchOutPort;

    /**
     * Load all available DfV attributes for the given context and searchType
     *
     * @param context The context to load the attributes with.
     * @param searchType The resource type to load the attributes for.
     * @return The available attributes.
     */
    public List<String> loadDfVAttributes(final RequestContext context, final SearchType searchType) {
        // build attribute key
        final String attrPrefix = switch (searchType) {
        case VORGANG -> "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0]";
        default -> throw new IllegalArgumentException("Type %s is not supported for DfV resolution".formatted(searchType));
        };
        final String fullreferenceAttr = attrPrefix
                + ".EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes.COOSYSTEM@1.1:fullreference";
        // search for attributes
        final SearchResult result = searchOutPort.searchObject(context, new SearchRequest(
                SearchType.SUBJECT_AREA,
                null,
                "EGOVTEMPLATE@15.1001:availabledefinitions is not null",
                Set.of(fullreferenceAttr)));
        // extract attribute keys from result
        return result.results().stream()
                .flatMap(i -> i.attributes().stream())
                .filter(i -> i.getReference().equals(fullreferenceAttr))
                .filter(i -> i.getFabasoftType().equals(AttributeType.STRING))
                .map(i -> (String) i.getValue()).toList();
    }
}

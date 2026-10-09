package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftSearchService;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.DfvOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FabasoftDfvOutAdapter implements DfvOutPort {
    private final FabasoftSearchService searchService;

    /**
     * Load all available DfV attributes for the given context and searchType
     *
     * @param context The context to load the attributes with.
     * @param searchType The resource type to load the attributes for.
     * @return The available attributes.
     */
    @Override
    public Set<String> loadDfVAttributes(final RequestContext context, final FabasoftObjectType searchType) {
        // build attribute key
        final String attrPrefix = switch (searchType) {
        case VORGANG -> "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0]";
        case DOKUMENT ->
            "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0]";
        default -> throw new IllegalArgumentException("Type %s is not supported for DfV resolution".formatted(searchType));
        };
        final String fullreferenceAttr = attrPrefix
                + ".EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes.COOSYSTEM@1.1:fullreference";
        // search for attributes
        final List<ResultObject> result = searchService.searchObject(context, FabasoftObjectType.SUBJECT_AREA, SearchRequest.builder()
                .limit(FabasoftSearchService.LIMIT_MAX)
                .query("EGOVTEMPLATE@15.1001:availabledefinitions is not null")
                .attributes(Set.of(fullreferenceAttr)).build());
        // extract attribute keys from result
        return result.stream()
                .flatMap(i -> i.attributes().stream())
                .filter(i -> i.reference().equals(fullreferenceAttr))
                .filter(i -> i.fabasoftType().equals(AttributeType.STRING))
                .map(i -> (String) i.value()).collect(Collectors.toSet());
    }
}

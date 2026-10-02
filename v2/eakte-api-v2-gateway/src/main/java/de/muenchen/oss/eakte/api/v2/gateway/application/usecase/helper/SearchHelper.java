package de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class SearchHelper {
    private static final String COO_PATTERN = "^COO[.\\d]+$";
    private static final String ID_QUERY = ".COOSYSTEM@1.1:objaddress = '%s'";
    private static final String PARENT_QUERY = ".COOELAK@1.1001:referrednumber.COOSYSTEM@1.1:objaddress = '%s'";

    private final SearchOutPort searchOutPort;

    /**
     * Build an attribute set to use for searching.
     * Starts with default attributes of the given resource type and loads either DfV attributes or adds
     * client attributes if provided.
     *
     * @param context The context used for DfV load, see {@link #loadDfVAttributes}.
     * @param searchType The resource type the attributes should be built for.
     * @param clientAttrs The attributes which were provided by the client.
     * @return A unified enriched set of client attributes.
     */
    public Set<String> buildAttributes(final RequestContext context, final SearchType searchType, final Set<String> clientAttrs) {
        final Set<String> attributes = new HashSet<>(switch (searchType) {
        case SUBJECT_AREA -> throw new IllegalStateException("Not implemented");
        case VORGANG -> VorgangAttribute.getReferences();
        case DOKUMENT -> DokumentAttribute.getReferences();
        });
        attributes.addAll(clientAttrs != null ? clientAttrs : this.loadDfVAttributes(context, searchType));
        return attributes;
    }

    /**
     * Concat two search queries with AND.
     *
     * @param query1 The first query.
     * @param query2 The second query.
     * @return The concatenated query.
     */
    public String concatQuery(final String query1, final String query2) {
        if (StringUtils.hasText(query1) && !StringUtils.hasText(query2)) {
            return query1;
        }
        if (!StringUtils.hasText(query1) && StringUtils.hasText(query2)) {
            return query2;
        }
        return "(%s) AND (%s)".formatted(query1, query2);
    }

    /**
     * Search for an object of the given resource type and with the given id.
     *
     * @param context The context to execute the search under.
     * @param searchType The type of the resource to search for.
     * @param id The id to search for.
     * @param attrs The attributes to load for the object.
     * @return The found resource.
     */
    public Optional<ResultObject> getObject(final RequestContext context, final SearchType searchType, final String id, final Set<String> attrs) {
        final String query = ID_QUERY.formatted(id);
        // TODO determine scope from request context
        final SearchRequest request = new SearchRequest(searchType, null, 2, query, attrs);
        final SearchResult result = searchOutPort.searchObject(context, request);
        if (result.results().isEmpty()) {
            return Optional.empty();
        }
        if (result.results().size() > 1) {
            throw new IllegalStateException("There shouldn't be more than one result when searching by id.");
        }
        return Optional.of(result.results().getFirst());
    }

    /**
     * Build a query for searching for objects under a given parent id.
     *
     * @param id The parent id.
     * @return The built query.
     */
    public String buildParentIdQuery(@NotBlank @Pattern(regexp = COO_PATTERN) final String id) {
        return PARENT_QUERY.formatted(id);
    }

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
        case DOKUMENT ->
            "EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0].EGOVTEMPLATE@15.1001:availabledefinitions[0]";
        default -> throw new IllegalArgumentException("Type %s is not supported for DfV resolution".formatted(searchType));
        };
        final String fullreferenceAttr = attrPrefix
                + ".EGOVTEMPLATE@15.1001:definitionuseform.FSCUSERFORMS@1.1001:releasecategory.COOTC@1.1001:categoryattributes.COOSYSTEM@1.1:fullreference";
        // search for attributes
        final SearchResult result = searchOutPort.searchObject(context, new SearchRequest(
                SearchType.SUBJECT_AREA,
                null,
                SearchRequest.LIMIT_MAX,
                "EGOVTEMPLATE@15.1001:availabledefinitions is not null",
                Set.of(fullreferenceAttr)));
        // extract attribute keys from result
        return result.results().stream()
                .flatMap(i -> i.attributes().stream())
                .filter(i -> i.reference().equals(fullreferenceAttr))
                .filter(i -> i.fabasoftType().equals(AttributeType.STRING))
                .map(i -> (String) i.value()).toList();
    }
}

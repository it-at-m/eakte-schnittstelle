package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service;

import com.fabasoft.schemas.bai.search.AttrListType;
import com.fabasoft.schemas.bai.search.SOAPSearchRequestType;
import com.fabasoft.schemas.bai.search.SOAPSearchResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.FabasoftRequestHandler;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftSearchMapper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SearchRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class FabasoftSearchService {
    public static final int LIMIT_MAX = 10_000;
    private static final String ID_QUERY = ".COOSYSTEM@1.1:objaddress = '%s'";

    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftSearchMapper attributeMapper;
    private final FabasoftRequestHandler requestHandler;

    /**
     * Search for an object of the given resource type and with the given id.
     *
     * @param context The context to execute the search under.
     * @param searchType The type of the resource to search for.
     * @param id The id to search for.
     * @param attrs The attributes to load for the object.
     * @return The found resource.
     */
    public Optional<ResultObject> getObject(final RequestContext context, final FabasoftObjectType searchType, final String id, final Set<String> attrs) {
        final String query = ID_QUERY.formatted(id);
        final SearchRequest request = new SearchRequest(2, query, attrs);
        final List<ResultObject> result = this.searchObject(context, searchType, request);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        if (result.size() > 1) {
            throw new IllegalStateException("There shouldn't be more than one result when searching by id.");
        }
        return Optional.of(result.getFirst());
    }

    public List<ResultObject> searchObject(final RequestContext requestContext, final FabasoftObjectType type, final SearchRequest request) {
        // build request
        final SOAPSearchRequestType requestType = new SOAPSearchRequestType();
        requestType.setQuery(this.buildQuery(type, request));
        final AttrListType attrList = new AttrListType();
        attrList.getAttr().addAll(request.attributes());
        requestType.setAttrlist(attrList);
        // request
        final SOAPSearchResponseType response = requestHandler.handleRequest("searchObject", requestContext, () -> soapClient.soapSearch(requestType, null));
        // map response
        Objects.requireNonNull(response, "Response can't be null");
        final List<ResultObject> result;
        if (response.getQueryresult() != null) {
            result = response.getQueryresult().getObject().stream()
                    .map(i -> new ResultObject(i.getObjname(), i.getObjaddress(), attributeMapper.parseAttributes(i.getAttrlist())))
                    .toList();
        } else {
            result = List.of();
        }
        return result;
    }

    private String buildQuery(final FabasoftObjectType type, final SearchRequest request) {
        final StringJoiner query = new StringJoiner(" ");
        // TODO can be removed?
        query.add("NOCHECK");
        // TODO scope request?
        query.add("LIMIT %d".formatted(request.limit()));
        query.add("SELECT * FROM %s".formatted(type.getFabasoftReference()));
        if (StringUtils.hasText(request.query())) {
            query.add("WHERE %s".formatted(request.query()));
        }
        return query.toString();
    }
}

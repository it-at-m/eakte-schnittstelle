package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import com.fabasoft.schemas.bai.search.AGGREGATEType;
import com.fabasoft.schemas.bai.search.AttrListResultType;
import com.fabasoft.schemas.bai.search.AttrListType;
import com.fabasoft.schemas.bai.search.SOAPSearchRequestType;
import com.fabasoft.schemas.bai.search.SOAPSearchResponseType;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.SearchOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.AggregateAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class FabasoftSearchAdapter implements SearchOutPort {
    private final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient;
    private final FabasoftAttributeMapper attributeMapper;
    private final FabasoftErrorHandler errorHandler;

    @Override
    public SearchResult searchObject(final RequestContext requestContext, final SearchRequest request) {
        // build request
        final SOAPSearchRequestType requestType = new SOAPSearchRequestType();
        requestType.setQuery(this.buildQuery(request));
        final AttrListType attrList = new AttrListType();
        attrList.getAttr().addAll(request.attributes());
        requestType.setAttrlist(attrList);
        // request
        final SOAPSearchResponseType response = errorHandler.handleErrors("searchObject", () -> soapClient.soapSearch(requestType, null));
        // map response
        Objects.requireNonNull(response, "Response can't be null");
        final List<SearchResult.ResultObject> result;
        if (response.getQueryresult() != null) {
            result = response.getQueryresult().getObject().stream()
                    .map(i -> new SearchResult.ResultObject(i.getObjname(), i.getObjaddress(), this.parseAttributes(i.getAttrlist())))
                    .toList();
        } else {
            result = List.of();
        }
        return new SearchResult(result);
    }

    private String buildQuery(final SearchRequest request) {
        final StringJoiner query = new StringJoiner(" ");
        query.add("NOCHECK SELECT * FROM %s".formatted(request.type().getFabasoftReference()));
        if (StringUtils.hasText(request.scope())) {
            query.add("SCOPE %s".formatted(request.scope()));
        }
        if (StringUtils.hasText(request.query())) {
            query.add("WHERE %s".formatted(request.query()));
        }
        return query.toString();
    }

    private List<Attribute<?>> parseAttributes(final AttrListResultType attrs) {
        final List<Attribute<?>> result = new ArrayList<>();
        // STRING
        result.addAll(attrs.getSTRING().stream().map(attributeMapper::mapString).toList());
        // BOOLEAN
        result.addAll(attrs.getBOOLEAN().stream().map(attributeMapper::mapBoolean).toList());
        // INTEGER
        result.addAll(attrs.getINTEGER().stream().map(attributeMapper::mapInt).toList());
        // FLOAT
        result.addAll(attrs.getFLOAT().stream().map(attributeMapper::mapFloat).toList());
        // DATE
        result.addAll(attrs.getDATE().stream().map(attributeMapper::mapDate).toList());
        // DATETIME
        result.addAll(attrs.getDATETIME().stream().map(attributeMapper::mapDatetime).toList());
        // ENUM
        result.addAll(attrs.getENUM().stream().map(attributeMapper::mapEnum).toList());
        // CONTENT
        result.addAll(attrs.getCONTENT().stream().map(attributeMapper::mapContent).toList());
        // OBJECT
        result.addAll(attrs.getOBJECT().stream().map(attributeMapper::mapObject).toList());
        // AGGREGATE
        result.addAll(attrs.getAGGREGATE().stream().map(this::mapAggregateType).toList());
        return result;
    }

    private AggregateAttribute mapAggregateType(final AGGREGATEType aggregateType) {
        final List<Attribute<?>> attributes = new ArrayList<>();
        // STRING
        attributes.addAll(aggregateType.getSTRING().stream().map(attributeMapper::mapString).toList());
        // BOOLEAN
        attributes.addAll(aggregateType.getBOOLEAN().stream().map(attributeMapper::mapBoolean).toList());
        // INTEGER
        attributes.addAll(aggregateType.getINTEGER().stream().map(attributeMapper::mapInt).toList());
        // FLOAT
        attributes.addAll(aggregateType.getFLOAT().stream().map(attributeMapper::mapFloat).toList());
        // DATE
        attributes.addAll(aggregateType.getDATE().stream().map(attributeMapper::mapDate).toList());
        // DATETIME
        attributes.addAll(aggregateType.getDATETIME().stream().map(attributeMapper::mapDatetime).toList());
        // ENUM
        attributes.addAll(aggregateType.getENUM().stream().map(attributeMapper::mapEnum).toList());
        // CONTENT
        attributes.addAll(aggregateType.getCONTENT().stream().map(attributeMapper::mapContent).toList());
        // OBJECT
        attributes.addAll(aggregateType.getOBJECT().stream().map(attributeMapper::mapObject).toList());
        // AGGREGATE
        attributes.addAll(aggregateType.getAGGREGATE().stream().map(this::mapAggregateType).toList());
        return new AggregateAttribute(aggregateType.getReference(), aggregateType.getIndex(), attributes);
    }
}

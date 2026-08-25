package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VorgangMapper {
    private final AttributeMapper attributeMapper;

    protected List<Vorgang> mapResults(final List<SearchResult.ResultObject> results) {
        return results.stream().map(this::mapResult).toList();
    }

    protected Vorgang mapResult(final SearchResult.ResultObject result) {
        final Map<String, Object> uniqueReferenceValueMap = attributeMapper.toUniqueReferenceValueMap(result.attributes());
        return Vorgang.builder()
                .id(result.coo())
                .name(result.name())
                .sachakteId(attributeMapper.getTyped(uniqueReferenceValueMap, PARENT_ID.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTyped(uniqueReferenceValueMap, SUBJECT.getReference(), String.class).orElse(null))
                // TODO filter out static attributes?
                .eigenschaftenMap(attributeMapper.toMap(result.attributes()))
                .eigenschaftenListe(attributeMapper.toList(result.attributes()))
                .build();
    }
}

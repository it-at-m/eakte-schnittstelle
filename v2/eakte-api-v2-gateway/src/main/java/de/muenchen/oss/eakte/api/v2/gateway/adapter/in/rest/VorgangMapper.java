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
        final Vorgang vorgang = new Vorgang(
                result.coo(),
                attributeMapper.getTyped(uniqueReferenceValueMap, PARENT_ID.getReference(), String.class).orElseThrow(),
                result.name(),
                // TODO filter out static attributes?
                attributeMapper.mapAttributMap(result.attributes()),
                attributeMapper.mapAttributEintragListe(result.attributes()));
        vorgang.setBetreff(attributeMapper.getTyped(uniqueReferenceValueMap, SUBJECT.getReference(), String.class));
        return vorgang;
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ACL;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.KEYWORDS_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.OE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.ORIGINAL_MEDIUM;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PARENT_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PROCESSING_STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.PROCESS_NOTE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SHORTNAME;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.STATE;
import static de.muenchen.oss.eakte.api.v2.gateway.domain.model.FabasoftAttributeReferences.SUBJECT;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.VorgangUseCase;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.SearchResult;
import java.math.BigInteger;
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
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return Vorgang.builder()
                .id(result.coo())
                .sachakteId(attributeMapper.getTypedSingle(referenceValueMap, PARENT_ID.getReference(), String.class).orElseThrow())
                .langname(result.name())
                .name(attributeMapper.getTypedSingle(referenceValueMap, SHORTNAME.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, SUBJECT.getReference(), String.class).orElse(null))
                .schlagworte(attributeMapper.getTypedList(referenceValueMap, KEYWORDS_NAME.getReference(), String.class).orElse(List.of()))
                .geschaeftsgangvermerk(attributeMapper.getTypedSingle(referenceValueMap, PROCESS_NOTE.getReference(), String.class).orElse(null))
                .originalMedium(mapMedium(referenceValueMap))
                .status(attributeMapper.getTypedSingle(referenceValueMap, STATE.getReference(), BigInteger.class).orElseThrow().toString())
                .bearbeitungsstatus(attributeMapper.getTypedSingle(referenceValueMap, PROCESSING_STATE.getReference(), String.class).orElseThrow())
                .acl(attributeMapper.getTypedSingle(referenceValueMap, ACL.getReference(), String.class).orElseThrow())
                .organisationseinheit(attributeMapper.getTypedSingle(referenceValueMap, OE.getReference(), String.class).orElseThrow())
                .eigenschaftenMap(attributeMapper.toMap(result.attributes(), VorgangUseCase.DEFAULT_ATTRIBUTES))
                .eigenschaftenListe(attributeMapper.toList(result.attributes(), VorgangUseCase.DEFAULT_ATTRIBUTES))
                .build();
    }

    protected Vorgang.OriginalMediumEnum mapMedium(final Map<String, List<Object>> uniqueReferenceValueMap) {
        return switch (attributeMapper.getTypedSingle(uniqueReferenceValueMap, ORIGINAL_MEDIUM.getReference(), BigInteger.class).orElseThrow().intValue()) {
        case 1 -> Vorgang.OriginalMediumEnum.ELEKTRONISCH;
        case 2 -> Vorgang.OriginalMediumEnum.PAPIER;
        case 3 -> Vorgang.OriginalMediumEnum.HYBRID;
        default -> null;
        };
    }
}

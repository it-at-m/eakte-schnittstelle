package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.enums.VorgangMedium;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.enums.VorgangStatus;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Vorgang;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VorgangMapper {
    private final AttributeMapper attributeMapper;

    protected List<Vorgang> mapResults(final List<ResultObject> results) {
        return results.stream().map(this::mapResult).toList();
    }

    protected Vorgang mapResult(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return Vorgang.builder()
                .id(result.coo())
                .sachakteId(attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.PARENT_ID.getReference(), String.class).orElseThrow())
                .langname(result.name())
                .name(attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.NAME.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.BETREFF.getReference(), String.class).orElse(null))
                .geschaeftsgangvermerk(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.GESCHAEFTSGANGVERMERK.getReference(), String.class).orElse(null))
                .originalMedium(mapMedium(referenceValueMap))
                .status(mapStatus(referenceValueMap))
                .bearbeitungsstatus(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.BEARBEITUNGSSTATUS.getReference(), String.class).orElseThrow())
                .zugriffsdefinition(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), String.class).orElseThrow())
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .eigenschaftenMap(attributeMapper.toMap(result.attributes(), VorgangAttribute.getReferences()))
                .eigenschaftenListe(attributeMapper.toList(result.attributes(), VorgangAttribute.getReferences()))
                .build();
    }

    protected Vorgang.OriginalMediumEnum mapMedium(final Map<String, List<Object>> referenceValueMap) {
        final BigInteger mediumValue = attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), BigInteger.class)
                .orElseThrow();
        return switch (VorgangMedium.byFabasoftValue(mediumValue.intValue())) {
        case ELEKTRONISCH -> Vorgang.OriginalMediumEnum.ELEKTRONISCH;
        case PAPIER -> Vorgang.OriginalMediumEnum.PAPIER;
        case HYBRID -> Vorgang.OriginalMediumEnum.HYBRID;
        };
    }

    protected Vorgang.StatusEnum mapStatus(final Map<String, List<Object>> referenceValueMap) {
        final BigInteger statusCode = attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.STATUS.getReference(), BigInteger.class).orElseThrow();
        return switch (VorgangStatus.byCode(statusCode.intValue())) {
        case IN_BEARBEITUNG -> Vorgang.StatusEnum.IN_BEARBEITUNG;
        case SUSPENDIERT -> Vorgang.StatusEnum.SUSPENDIERT;
        case ABGESCHLOSSEN -> Vorgang.StatusEnum.ABGESCHLOSSEN;
        case STORNIERT -> Vorgang.StatusEnum.STORNIERT;
        case ARCHIVIERT -> Vorgang.StatusEnum.ARCHIVIERT;
        };
    }
}

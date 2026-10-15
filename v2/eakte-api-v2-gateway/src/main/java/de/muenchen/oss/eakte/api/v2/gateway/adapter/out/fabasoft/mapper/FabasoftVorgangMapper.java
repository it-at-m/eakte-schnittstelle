package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangStatus;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftVorgangMapper {
    private final AttributeMapper attributeMapper;

    public List<VorgangResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public VorgangResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return VorgangResponse.builder()
                .id(result.coo())
                .akteId(attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.PARENT_ID.getReference(), String.class).orElse(null))
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
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), String.class).orElse(null))
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .weitereEigenschaften(attributeMapper.toDomain(result.attributes(), VorgangAttribute.getReferences()))
                .build();
    }

    protected VorgangMedium mapMedium(final Map<String, List<Object>> referenceValueMap) {
        final BigInteger mediumValue = attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), BigInteger.class)
                .orElseThrow();
        return switch (mediumValue.intValue()) {
        case 1 -> VorgangMedium.ELEKTRONISCH;
        case 2 -> VorgangMedium.PAPIER;
        case 3 -> VorgangMedium.HYBRID;
        default -> throw new IllegalStateException("Unexpected value: " + mediumValue.intValue());
        };
    }

    protected VorgangStatus mapStatus(final Map<String, List<Object>> referenceValueMap) {
        final BigInteger statusCode = attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.STATUS.getReference(), BigInteger.class).orElseThrow();
        return switch (statusCode.intValue()) {
        case 10 -> VorgangStatus.IN_BEARBEITUNG;
        case 20 -> VorgangStatus.SUSPENDIERT;
        case 30 -> VorgangStatus.ABGESCHLOSSEN;
        case 40 -> VorgangStatus.STORNIERT;
        case 50 -> VorgangStatus.ARCHIVIERT;
        default -> throw new IllegalStateException("Unexpected value: " + statusCode.intValue());
        };
    }
}

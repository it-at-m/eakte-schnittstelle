package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AkteAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.akte.AkteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FabasoftAkteMapper {
    private final FabasoftAttributeMapper attributeMapper;

    public List<AkteResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public AkteResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return AkteResponse.builder()
                .id(result.coo())
                .aktenplaneintragId(attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.PARENT_ID.getReference(), String.class).orElse(null))
                .name(result.name())
                .titel(attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.TITEL.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.BETREFF.getReference(), String.class).orElse(null))
                .zugriffsdefinition(
                        attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.ZUGRIFFSDEFINITION.getReference(), String.class).orElse(null))
                .zugriffsdefinitionVorgang(
                        attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.ZUGRIFFSDEFINITION_VORGANG.getReference(), String.class).orElse(null))
                .dfvId(attributeMapper.getTypedSingle(referenceValueMap, AkteAttribute.DFV_ID.getReference(), String.class).orElse(null))
                .weitereEigenschaften(attributeMapper.toDomain(result.attributes(), AkteAttribute.getReferences()))
                .build();
    }
}

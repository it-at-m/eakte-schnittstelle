package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SchriftstueckAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SchriftstueckResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftSchriftstueckMapper {
    private final FabasoftAttributeMapper attributeMapper;

    public List<SchriftstueckResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public SchriftstueckResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return SchriftstueckResponse.builder()
                .id(result.coo())
                .dokumentId(attributeMapper.getTypedSingle(referenceValueMap, SchriftstueckAttribute.DOKUMENT_ID.getReference(), String.class).orElse(null))
                .name(result.name())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, SchriftstueckAttribute.BETREFF.getReference(), String.class).orElse(null))
                .dateiEndung(attributeMapper.getTypedSingle(referenceValueMap, SchriftstueckAttribute.DATEI_ENDUNG.getReference(), String.class).orElse(null))
                .dateiGroesse(
                        attributeMapper.getTypedSingle(referenceValueMap, SchriftstueckAttribute.DATEI_GROESSE.getReference(), BigInteger.class).orElse(null))
                .build();
    }
}

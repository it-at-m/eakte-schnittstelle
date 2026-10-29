package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ErledigungAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.ErledigungResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftErledigungMapper {
    private final FabasoftAttributeMapper attributeMapper;
    private final FabasoftDokumentMapper fabasoftDokumentMapper;

    public List<ErledigungResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public ErledigungResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        final Set<String> defaultAttributes = AttributeHelper.combineAttributes(DokumentAttribute.getReferences(), ErledigungAttribute.getReferences());
        final ErledigungResponse.ErledigungResponseBuilder<?, ?> builder = ErledigungResponse.builder();
        fabasoftDokumentMapper.mapDokumentFields(builder, result, referenceValueMap, defaultAttributes);
        return builder
                .bezugEingangsdokument(
                        attributeMapper.getTypedSingle(referenceValueMap, ErledigungAttribute.BEZUG_EINGANGSDOKUMENT.getReference(), String.class).orElse(null))
                .dokumententyp(
                        attributeMapper.getTypedSingle(referenceValueMap, ErledigungAttribute.DOKUMENTENTYP.getReference(), String.class).orElse(null))
                .anlagenBeschreibung(
                        attributeMapper.getTypedSingle(referenceValueMap, ErledigungAttribute.ANLAGEN_BESCHREIBUNG.getReference(), String.class).orElse(null))
                .build();
    }
}

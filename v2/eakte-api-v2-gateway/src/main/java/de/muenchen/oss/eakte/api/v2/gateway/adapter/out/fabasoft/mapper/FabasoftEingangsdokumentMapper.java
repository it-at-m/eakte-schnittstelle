package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.EingangsdokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.EingangsdokumentResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftEingangsdokumentMapper {
    private final FabasoftAttributeMapper attributeMapper;
    private final FabasoftDokumentMapper fabasoftDokumentMapper;

    public List<EingangsdokumentResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public EingangsdokumentResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        final Set<String> defaultAttributes = AttributeHelper.combineAttributes(DokumentAttribute.getReferences(), EingangsdokumentAttribute.getReferences());
        final EingangsdokumentResponse.EingangsdokumentResponseBuilder<?, ?> builder = EingangsdokumentResponse.builder();
        fabasoftDokumentMapper.mapDokumentFields(builder, result, referenceValueMap, defaultAttributes);
        return builder
                .fremdesGeschaeftszeichen(attributeMapper
                        .getTypedSingle(referenceValueMap, EingangsdokumentAttribute.FREMDES_GESCHAEFTSZEICHEN.getReference(), String.class).orElse(null))
                .eingangsdatum(
                        attributeMapper.getTypedSingle(referenceValueMap, EingangsdokumentAttribute.EINGANGSDATUM.getReference(), LocalDate.class).orElse(null))
                .hinweis(attributeMapper.getTypedSingle(referenceValueMap, EingangsdokumentAttribute.HINWEIS.getReference(), String.class).orElse(null))
                .build();
    }
}

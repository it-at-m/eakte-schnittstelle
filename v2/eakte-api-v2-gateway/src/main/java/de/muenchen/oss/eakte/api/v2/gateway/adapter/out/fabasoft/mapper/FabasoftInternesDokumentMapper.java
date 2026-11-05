package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.InternesDokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.helper.AttributeHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.InternesDokumentResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftInternesDokumentMapper {
    private final FabasoftAttributeMapper attributeMapper;
    private final FabasoftDokumentMapper fabasoftDokumentMapper;

    public List<InternesDokumentResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public InternesDokumentResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        final Set<String> defaultAttributes = AttributeHelper.combineAttributes(DokumentAttribute.getReferences(), InternesDokumentAttribute.getReferences());
        final InternesDokumentResponse.InternesDokumentResponseBuilder<?, ?> builder = InternesDokumentResponse.builder();
        fabasoftDokumentMapper.mapDokumentFields(builder, result, referenceValueMap, defaultAttributes);
        return builder
                .zustellungsDatum(
                        attributeMapper.getTypedSingle(referenceValueMap, InternesDokumentAttribute.ZUSTELLUNGSDATUM.getReference(), LocalDate.class)
                                .orElse(null))
                .dokumententyp(
                        attributeMapper.getTypedSingle(referenceValueMap, InternesDokumentAttribute.DOKUMENTENTYP.getReference(), String.class).orElse(null))
                .anlagenBeschreibung(
                        attributeMapper.getTypedSingle(referenceValueMap, InternesDokumentAttribute.ANLAGEN_BESCHREIBUNG.getReference(), String.class)
                                .orElse(null))
                .build();
    }
}

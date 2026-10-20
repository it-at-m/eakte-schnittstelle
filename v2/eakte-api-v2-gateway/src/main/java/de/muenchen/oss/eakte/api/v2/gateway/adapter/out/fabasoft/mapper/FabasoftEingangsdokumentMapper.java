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
        return EingangsdokumentResponse.builder()
                // Dokument
                .id(result.coo())
                .klasse(fabasoftDokumentMapper.mapKlasse(referenceValueMap))
                .parent(fabasoftDokumentMapper.mapParent(referenceValueMap))
                .langname(result.name())
                .name(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.NAME.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.BETREFF.getReference(), String.class).orElse(null))
                .zugriffsdefinition(
                        attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ZUGRIFFSDEFINITION.getReference(), String.class).orElseThrow())
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .weitereEigenschaften(attributeMapper.toDomain(result.attributes(), defaultAttributes))
                // Eingangsdokument
                .fremdesGeschaeftszeichen(attributeMapper
                        .getTypedSingle(referenceValueMap, EingangsdokumentAttribute.FREMDES_GESCHAEFTSZEICHEN.getReference(), String.class).orElse(null))
                .eingangsdatum(
                        attributeMapper.getTypedSingle(referenceValueMap, EingangsdokumentAttribute.EINGANGSDATUM.getReference(), LocalDate.class).orElse(null))
                .hinweis(attributeMapper.getTypedSingle(referenceValueMap, EingangsdokumentAttribute.HINWEIS.getReference(), String.class).orElse(null))
                .build();
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ParentReference;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentKlasse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentParent;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.dokument.DokumentResponse;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftDokumentMapper {
    private final FabasoftAttributeMapper attributeMapper;

    public List<DokumentResponse> toDomain(final List<ResultObject> results) {
        return results.stream().map(this::toDomain).toList();
    }

    public DokumentResponse toDomain(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return DokumentResponse.builder()
                .id(result.coo())
                .klasse(this.mapKlasse(referenceValueMap))
                .parent(this.mapParent(referenceValueMap))
                .langname(result.name())
                .name(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.NAME.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.BETREFF.getReference(), String.class).orElse(null))
                .zugriffsdefinition(
                        attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ZUGRIFFSDEFINITION.getReference(), String.class).orElseThrow())
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .weitereEigenschaften(attributeMapper.toDomain(result.attributes(), DokumentAttribute.getReferences()))
                .build();
    }

    protected ParentReference<DokumentParent> mapParent(final Map<String, List<Object>> referenceValueMap) {
        final String referenceStr = attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.PARENT_TYPE.getReference(), String.class).orElse(null);
        final FabasoftObjectType fabasoftType = FabasoftObjectType.fromFabasoftReference(referenceStr);
        final DokumentParent type = switch (fabasoftType) {
        case VORGANG -> DokumentParent.VORGANG;
        // TODO Inbox & Arbeitsvorrat
        case null, default -> throw new IllegalStateException("Unknown object type: " + fabasoftType);
        };
        return new ParentReference<>(
                type,
                attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.PARENT_ID.getReference(), String.class).orElseThrow());
    }

    protected DokumentKlasse mapKlasse(final Map<String, List<Object>> referenceValueMap) {
        final String referenceStr = attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.KLASSE.getReference(), String.class).orElse(null);
        final FabasoftObjectType fabasoftType = FabasoftObjectType.fromFabasoftReference(referenceStr);
        return switch (fabasoftType) {
        case EINGANGSDOKUMENT -> DokumentKlasse.EINGANG;
        case ERLEDIGUNG -> DokumentKlasse.ERLEDIGUNG;
        case INTERNES_DOKUMENT -> DokumentKlasse.INTERN;
        case null, default -> throw new IllegalStateException("Unexpected value: " + referenceStr);
        };
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.DokumentClass;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.search.ResultObject;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Dokument;
import de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.ParentReference;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DokumentMapper {
    private final AttributeMapper attributeMapper;

    protected List<Dokument> mapResults(final List<ResultObject> results) {
        return results.stream().map(this::mapResult).toList();
    }

    protected Dokument mapResult(final ResultObject result) {
        final Map<String, List<Object>> referenceValueMap = attributeMapper.toReferenceValueMap(result.attributes());
        return Dokument.builder()
                .id(result.coo())
                .klasse(this.mapKlasse(referenceValueMap))
                .parent(this.mapParent(referenceValueMap))
                .langname(result.name())
                .name(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.NAME.getReference(), String.class).orElseThrow())
                .betreff(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.BETREFF.getReference(), String.class).orElse(null))
                .schlagworte(attributeMapper.getTypedList(referenceValueMap, DokumentAttribute.SCHLAGWORTE_NAME.getReference(), String.class).orElse(List.of()))
                .acl(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ACL.getReference(), String.class).orElseThrow())
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .eigenschaftenMap(attributeMapper.toMap(result.attributes(), DokumentAttribute.getReferences()))
                .eigenschaftenListe(attributeMapper.toList(result.attributes(), DokumentAttribute.getReferences()))
                .build();
    }

    protected ParentReference mapParent(final Map<String, List<Object>> referenceValueMap) {
        final String typeStr = attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.PARENT_TYPE.getReference(), String.class).orElseThrow();
        final ParentReference.TypeEnum type = switch (typeStr) {
        case "DEPRECONFIG@15.1001:Procedure" -> ParentReference.TypeEnum.VORGANG;
        // TODO Inbox & Arbeitsvorrat
        default -> null;
        };
        return ParentReference.builder()
                .id(attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.PARENT_ID.getReference(), String.class).orElseThrow())
                .type(type)
                .build();
    }

    protected Dokument.KlasseEnum mapKlasse(final Map<String, List<Object>> referenceValueMap) {
        final String klasseAtr = attributeMapper.getTypedSingle(referenceValueMap, DokumentAttribute.KLASSE.getReference(), String.class).orElseThrow();
        if (DokumentClass.EINGANG.getReference().equals(klasseAtr)) {
            return Dokument.KlasseEnum.EINGANG;
        }
        if (DokumentClass.ERLEDIGUNG.getReference().equals(klasseAtr)) {
            return Dokument.KlasseEnum.ERLEDIGUNG;
        }
        if (DokumentClass.INTERN.getReference().equals(klasseAtr)) {
            return Dokument.KlasseEnum.INTERN;
        }
        return null;
    }
}

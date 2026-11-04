package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.ResultObject;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangResponse;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangStatus;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class FabasoftVorgangMapper {
    private FabasoftAttributeMapper attributeMapper;
    private DefaultAttributeMapper defaultAttributeMapper;

    @Autowired
    public void setDefaultAttributeMapper(final FabasoftAttributeMapper attributeMapper,
            final DefaultAttributeMapper defaultAttributeMapper) {
        this.attributeMapper = attributeMapper;
        this.defaultAttributeMapper = defaultAttributeMapper;
    }

    @Mapping(source = "aktenId", target = "referredId")
    @Mapping(target = "type", constant = "VORGANG")
    public abstract SubFileRequest fromDomain(CreateVorgangRequest request);

    public List<FabasoftAttribute> toAttributeList(final CreateVorgangRequest request) {
        final List<FabasoftAttribute> attributeList = new ArrayList<>();
        if (request.originalMedium() != null) {
            attributeList.add(new FabasoftAttribute(AttributeType.ENUM, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), null,
                    mapOriginalMedium(request.originalMedium())));
        }
        if (request.geschaeftsgangvermerk() != null) {
            attributeList.add(
                    new FabasoftAttribute(AttributeType.STRING, VorgangAttribute.GESCHAEFTSGANGVERMERK.getReference(), null, request.geschaeftsgangvermerk()));
        }
        if (request.zugriffsdefinition() != null) {
            final String zugriffsdefinitionId = defaultAttributeMapper.zugriffsdefinitionToId(request.zugriffsdefinition());
            attributeList.add(new FabasoftAttribute(AttributeType.OBJECT, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), null, zugriffsdefinitionId));
        }
        // TODO laufweg
        // TODO dfv
        return attributeList;
    }

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
                        defaultAttributeMapper.zugriffsdefinitionToText(
                                attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), String.class)
                                        .orElse(null)))
                .organisationseinheit(
                        attributeMapper.getTypedSingle(referenceValueMap, VorgangAttribute.ORGANISATIONSEINHEIT.getReference(), String.class).orElseThrow())
                .weitereEigenschaften(attributeMapper.toDomain(result.attributes(), VorgangAttribute.getReferences()))
                .build();
    }

    private BigInteger mapOriginalMedium(final VorgangMedium vorgangMedium) {
        return switch (vorgangMedium) {
        case ELEKTRONISCH -> BigInteger.valueOf(1);
        case PAPIER -> BigInteger.valueOf(2);
        case HYBRID -> BigInteger.valueOf(3);
        };
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

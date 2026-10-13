package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.AttributeType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.vorgang.VorgangMedium;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class FabasoftVorgangRequestMapper {
    private DefaultAttributeMapper defaultAttributeMapper;

    @Autowired
    public void setDefaultAttributeMapper(final DefaultAttributeMapper defaultAttributeMapper) {
        this.defaultAttributeMapper = defaultAttributeMapper;
    }

    @Mapping(source = "aktenId", target = "referredId")
    @Mapping(target = "type", constant = "VORGANG")
    public abstract SubFileRequest fromDomain(CreateVorgangRequest request);

    public List<FabasoftAttribute> toAttributeList(final CreateVorgangRequest request) {
        final List<FabasoftAttribute> attributeList = new ArrayList<>();
        if (request.originalMedium() != null) {
            attributeList.add(new FabasoftAttribute(AttributeType.ENUM, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), null, mapOriginalMedium(request.originalMedium())));
        }
        if (request.geschaeftsgangvermerk() != null) {
            attributeList.add(new FabasoftAttribute(AttributeType.STRING, VorgangAttribute.GESCHAEFTSGANGVERMERK.getReference(), null, request.geschaeftsgangvermerk()));
        }
        if (request.zugriffsdefinition() != null) {
            final String zugriffsdefinitionId = defaultAttributeMapper.zugriffsdefinitionToId(request.zugriffsdefinition());
            attributeList.add(new FabasoftAttribute(AttributeType.OBJECT, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), null, zugriffsdefinitionId));
        }
        // TODO laufweg
        // TODO dfv
        return attributeList;
    }

    private BigInteger mapOriginalMedium(VorgangMedium  vorgangMedium) {
        return switch (vorgangMedium) {
            case ELEKTRONISCH -> BigInteger.valueOf(1);
            case PAPIER -> BigInteger.valueOf(2);
            case HYBRID -> BigInteger.valueOf(3);
        };
    }
}

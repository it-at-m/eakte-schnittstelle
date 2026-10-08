package de.muenchen.oss.eakte.api.v2.gateway.domain.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.application.usecase.helper.ZugriffsdefinitionHelper;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.CreateVorgangRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.SubFileRequest;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.mapping.VorgangAttribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.Attribute;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.type.AttributeType;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VorgangMapper {
    @Mapping(source = "aktenId", target = "referredId")
    @Mapping(target = "type", constant = "VORGANG")
    SubFileRequest toSubFile(CreateVorgangRequest request);

    default List<Attribute> toAttributeList(final CreateVorgangRequest request) {
        final List<Attribute> attributeList = new ArrayList<>();
        if (request.originalMedium() != null) {
            attributeList.add(new Attribute(AttributeType.ENUM, VorgangAttribute.ORIGINAL_MEDIUM.getReference(), null, BigInteger.valueOf(request.originalMedium().getFabasoftValue())));
        }
        if (request.geschaeftsgangvermerk() != null) {
            attributeList.add(new Attribute(AttributeType.STRING, VorgangAttribute.GESCHAEFTSGANGVERMERK.getReference(), null, request.geschaeftsgangvermerk()));
        }
        if (request.zugriffsdefinitionText() != null) {
            final String zugriffsdefinitionId = ZugriffsdefinitionHelper.textToId(request.zugriffsdefinitionText());
            attributeList.add(new Attribute(AttributeType.OBJECT, VorgangAttribute.ZUGRIFFSDEFINITION.getReference(), null, zugriffsdefinitionId));
        }
        // TODO laufweg
        // TODO dfv
        return attributeList;
    }
}

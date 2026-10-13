package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.config.FabasoftProperties;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.AttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.DefaultAttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangRequestMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangRequestMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangResponseMapper;
import java.util.List;

public final class FabasoftTestFixtures {
    public static final String ACCESS_DEFINITION_TEXT = "Standard Zugriffsdefinition für Dokumente";
    public static final String ACCESS_DEFINITION_ID = "COO.1.1001.1.182601";

    private FabasoftTestFixtures() {
    }

    public static DefaultAttributeMapper defaultAttributeMapper() {
        final FabasoftProperties properties = new FabasoftProperties();
        properties.setZugriffsdefinitionen(List.of(new FabasoftProperties.MappingEntry(
                ACCESS_DEFINITION_TEXT, ACCESS_DEFINITION_ID)));
        return new DefaultAttributeMapper(properties);
    }

    public static FabasoftVorgangResponseMapper vorgangResponseMapper() {
        return new FabasoftVorgangResponseMapper(new AttributeMapper(), defaultAttributeMapper());
    }

    public static FabasoftVorgangRequestMapper vorgangRequestMapper() {
        final FabasoftVorgangRequestMapper mapper = new FabasoftVorgangRequestMapperImpl();
        mapper.setDefaultAttributeMapper(defaultAttributeMapper());
        return mapper;
    }

    public static FabasoftDokumentMapper dokumentMapper() {
        return new FabasoftDokumentMapper(new AttributeMapper(), defaultAttributeMapper());
    }
}

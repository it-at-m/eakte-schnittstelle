package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.config.FabasoftProperties;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.DefaultAttributeMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftAttributeMapperImpl;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftDokumentMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangMapper;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper.FabasoftVorgangMapperImpl;
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

    public static FabasoftVorgangMapper vorgangMapper() {
        final FabasoftVorgangMapper mapper = new FabasoftVorgangMapperImpl();
        mapper.setDefaultAttributeMapper(new FabasoftAttributeMapperImpl(), defaultAttributeMapper());
        return mapper;
    }

    public static FabasoftDokumentMapper dokumentMapper() {
        return new FabasoftDokumentMapper(new FabasoftAttributeMapperImpl(), defaultAttributeMapper());
    }
}

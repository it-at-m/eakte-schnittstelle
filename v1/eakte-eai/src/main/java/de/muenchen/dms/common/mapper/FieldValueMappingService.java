package de.muenchen.dms.common.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FieldValueMappingService {

    private final MappingConfig mappingConfig;

    private final static Logger log = LoggerFactory.getLogger(FieldValueMappingService.class);

    public FieldValueMappingService(MappingConfig mappingConfig){
        this.mappingConfig = mappingConfig;
    }

    public String map(String fieldName, String inputValue) {

        if (inputValue == null) return null;

        log.info("Alle Mappings {}", mappingConfig.getMappings());
        log.info("Suche Mapping für Feld: {}: {}", fieldName, inputValue);

        Map<String, String> fieldMappings = mappingConfig.getMappings().get(fieldName);
        log.info("Gefundene Mappings: {}: {}", fieldName, fieldMappings);
        String normalizedInput = inputValue.replace(" ", "_");
        if (fieldName == null || normalizedInput == null){
            return normalizedInput;
        }

        return fieldMappings.getOrDefault(normalizedInput, inputValue);
    }
}

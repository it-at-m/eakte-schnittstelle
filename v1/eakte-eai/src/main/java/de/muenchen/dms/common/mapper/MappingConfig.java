package de.muenchen.dms.common.mapper;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "eakte")
@Component
public class MappingConfig {
    private Map<String, Map<String, String>> mappings = new HashMap<>();

    @PostConstruct
    public void init() throws IOException{
        Resource resource = new ClassPathResource("application.yml");
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)){
            Yaml yaml = new Yaml();
            Map<String, Object> loaded = yaml.load(reader);
            if (loaded != null){
                Map<String, Object> eakte = (Map<String, Object>) loaded.get("eakte");
                mappings = (Map<String, Map<String, String>>) eakte.get("mappings");
            }
        }
    }

    public Map<String, Map<String, String>> getMappings() {
        return mappings;
    }

    public void setMappings (Map<String, Map<String, String>> mappings) {
        this.mappings = mappings;
    }
}

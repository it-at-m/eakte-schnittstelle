package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.config.FabasoftProperties;
import de.muenchen.oss.eakte.api.v2.gateway.domain.exception.BadInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Mapper for attributes which are used in different objects and require additional mapping.
 */
@Component
@RequiredArgsConstructor
public class DefaultAttributeMapper {
    public static final String UNKNOWN_ZUGRIFFSDEFINITION = "UNBEKANNTE ZUGRIFFSDEFINITION";

    private final FabasoftProperties fabasoftProperties;

    /**
     * Find Zugriffsdefinition text by id.
     *
     * @param id The id to find.
     * @return The text of the found Zugriffsdefinition or {@link #UNKNOWN_ZUGRIFFSDEFINITION}.
     */
    public String zugriffsdefinitionToText(final String id) {
        if (!StringUtils.hasText(id)) {return null;}
        return fabasoftProperties.getZugriffsdefinitionen().stream()
                .filter(i -> i.id().equals(id))
                .map(FabasoftProperties.MappingEntry::text)
                .findFirst().orElse(UNKNOWN_ZUGRIFFSDEFINITION);
    }

    /**
     * Find Zugriffsdefinition id by text.
     *
     * @param text The text to find.
     * @return The id of the Zugriffsdefinition.
     * @throws BadInputException If no Zugriffsdefinition with that text exists.
     */
    public String zugriffsdefinitionToId(final String text) {
        if (!StringUtils.hasText(text)) {return null;}
        return fabasoftProperties.getZugriffsdefinitionen().stream()
                .filter(i -> i.text().equals(text))
                .map(FabasoftProperties.MappingEntry::id)
                .findFirst()
                .orElseThrow(() -> new BadInputException("'%s' is no valid Zugriffsdefinition".formatted(text)));
    }
}

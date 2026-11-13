package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FabasoftPosition {

    SACHBEARBEITUNG("COO.1.1001.1.4328"),
    SEKRETARIAT("COO.1.1001.1.4592"),
    LEITUNG("COO.1.1001.1.4595"),
    REGISTRATUR("COO.1.1001.1.4329"),
    SCHRIFTGUTVERWALTUNG("COO.15.1400.1.28120"),
    VORLAGENVERWALTUNG("COO.15.1400.1.28112"),
    VORLAGENADMINISTRATION("COO.15.1001.1.46551"),
    FACHADMINISTRATION("COO.15.1400.1.28012"),
    OE_ADMINISTRATION("COO.15.1400.1.102008"),
    MITARBEIT("COO.15.1400.1.28066");

    private final String id;

    /**
     * Find {@link FabasoftPosition} by {@link FabasoftPosition#id}.
     *
     * @param fabasoftId The id to find.
     * @return If found the {@link FabasoftObjectType}, else {@code null}.
     */
    public static FabasoftPosition fromFabasoftId(final String fabasoftId) {
        return Arrays.stream(values())
                .filter(i -> i.id.equals(fabasoftId))
                .findFirst().orElse(null);
    }
}

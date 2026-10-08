package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.enums;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum VorgangStatus {
    IN_BEARBEITUNG(10),
    SUSPENDIERT(20),
    ABGESCHLOSSEN(30),
    STORNIERT(40),
    ARCHIVIERT(50);

    private final int fabasoftCode;

    /**
     * Get the {@link VorgangStatus} with the given code.
     *
     * @param code The code to find.
     * @return The found {@link VorgangStatus}.
     * @throws java.util.NoSuchElementException If no {@link VorgangStatus} with the given code exists.
     */
    public static VorgangStatus byCode(final int code) {
        return Arrays.stream(values())
                .filter(i -> i.fabasoftCode == code)
                .findFirst().orElseThrow();
    }
}

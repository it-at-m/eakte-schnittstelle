package de.muenchen.oss.eakte.api.v2.gateway.domain.model.attribute.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum VorgangMedium {
    ELEKTRONISCH(1),
    PAPIER(2),
    HYBRID(3);

    private final int fabasoftValue;

    /**
     * Get the {@link VorgangMedium} with the given fabasoft value.
     *
     * @param code The code to find.
     * @return The found {@link VorgangMedium}.
     * @throws java.util.NoSuchElementException If no {@link VorgangMedium} with the given code exists.
     */
    public static VorgangMedium byFabasoftValue(final int code) {
        return Arrays.stream(values())
                .filter(i -> i.fabasoftValue == code)
                .findFirst().orElseThrow();
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Benutzer(
        String id,
        String username,
        List<Rolle> rollen) {
    @Builder
    public record Rolle(
            String mandant,
            EntityReference organisationseinheit,
            Stelle stelle,
            boolean isDefault) {
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

public record SubFileRequest(
        FabasoftType type,
        String referredId,
        String name,
        String vorlagenId,
        String betreff) {
}

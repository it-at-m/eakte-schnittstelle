package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain;

public record SubFileRequest(
        FabasoftObjectType type,
        String referredId,
        String titel,
        String dfvId,
        String betreff) {
}

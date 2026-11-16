package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import lombok.Builder;

import java.math.BigInteger;

@Builder
public record SchriftstueckResponse(
        String dokumentId,
        String id,
        String name,
        String betreff,
        String dateiEndung,
        BigInteger dateiGroesse) {
}

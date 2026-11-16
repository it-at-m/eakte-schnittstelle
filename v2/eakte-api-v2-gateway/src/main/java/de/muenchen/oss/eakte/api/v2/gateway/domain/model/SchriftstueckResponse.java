package de.muenchen.oss.eakte.api.v2.gateway.domain.model;

import java.math.BigInteger;
import lombok.Builder;

@Builder
public record SchriftstueckResponse(
        String dokumentId,
        String id,
        String name,
        String betreff,
        String dateiEndung,
        BigInteger dateiGroesse) {
}

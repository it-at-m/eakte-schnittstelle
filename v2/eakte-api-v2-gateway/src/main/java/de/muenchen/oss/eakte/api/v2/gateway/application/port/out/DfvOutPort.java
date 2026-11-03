package de.muenchen.oss.eakte.api.v2.gateway.application.port.out;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.ObjectType;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.RequestContext;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import org.springframework.validation.annotation.Validated;

@Validated
public interface DfvOutPort {
    Set<String> loadDfVAttributes(@NotNull @Valid RequestContext context, @NotNull ObjectType searchType);
}

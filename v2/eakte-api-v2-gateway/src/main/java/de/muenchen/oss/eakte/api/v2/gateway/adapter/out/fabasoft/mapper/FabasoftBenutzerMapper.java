package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import com.fabasoft.editions.schemas.gov.getuserinformation.GetUserInformationResponseType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftStelle;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.EntityReference;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FabasoftBenutzerMapper {
    private final FabasoftCommonMapper commonMapper;

    public Benutzer toDomain(final GetUserInformationResponseType response) {
        final List<Benutzer.Rolle> roles = response.getUserrole().stream()
                .map(r -> Benutzer.Rolle.builder()
                        .mandant(r.getClientdomain().getObjname())
                        .organisationseinheit(new EntityReference(r.getGroup().getObjaddress(), r.getGroup().getObjname()))
                        .stelle(commonMapper.toDomain(FabasoftStelle.fromFabasoftId(r.getPosition().getObjaddress())))
                        .isDefault(r.isDefault()).build())
                .filter(i -> i.stelle() != null)
                .toList();
        return Benutzer.builder()
                .id(response.getUser().getObjaddress())
                .username(response.getUser().getLogin().getFirst())
                .rollen(roles)
                .build();
    }
}

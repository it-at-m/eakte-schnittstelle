package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.mapper;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_MANDANT;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fabasoft.editions.schemas.gov.getuserinformation.GetUserInformationResponseType;
import com.fabasoft.editions.schemas.gov.getuserinformation.ObjectType;
import com.fabasoft.editions.schemas.gov.getuserinformation.UserResponseType;
import com.fabasoft.editions.schemas.gov.getuserinformation.UserRoleType;
import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftStelle;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.EntityReference;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Stelle;
import java.util.List;
import org.junit.jupiter.api.Test;

class FabasoftBenutzerMapperTest {
    private final FabasoftBenutzerMapper mapper = new FabasoftBenutzerMapper(new FabasoftCommonMapperImpl());

    @Test
    void givenUserResponseWithSupportedAndUnsupportedRoles_thenMapUserAndFilterUnsupportedRoles() {
        final GetUserInformationResponseType response = new GetUserInformationResponseType();
        final UserResponseType user = new UserResponseType();
        user.setObjaddress(BENUTZER_ID);
        user.getLogin().add(BENUTZER_USERNAME);
        response.setUser(user);
        response.getUserrole().add(userRole(FabasoftStelle.SACHBEARBEITUNG.getId(), true));
        response.getUserrole().add(userRole("unsupported-position", false));

        final Benutzer result = mapper.toDomain(response);

        assertEquals(Benutzer.builder()
                .id(BENUTZER_ID)
                .username(BENUTZER_USERNAME)
                .rollen(List.of(Benutzer.Rolle.builder()
                        .mandant(BENUTZER_MANDANT)
                        .organisationseinheit(new EntityReference(BENUTZER_OE_ID, BENUTZER_OE_NAME))
                        .stelle(Stelle.SACHBEARBEITUNG)
                        .isDefault(true)
                        .build()))
                .build(), result);
    }

    private static UserRoleType userRole(final String positionId, final boolean isDefault) {
        final UserRoleType userRole = new UserRoleType();
        userRole.setPosition(object(null, positionId));
        userRole.setGroup(object(BENUTZER_OE_NAME, BENUTZER_OE_ID));
        userRole.setClientdomain(object(BENUTZER_MANDANT, null));
        userRole.setDefault(isDefault);
        return userRole;
    }

    private static ObjectType object(final String name, final String id) {
        final ObjectType object = new ObjectType();
        object.setObjname(name);
        object.setObjaddress(id);
        return object;
    }
}

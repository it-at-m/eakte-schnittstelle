package de.muenchen.oss.eakte.api.v2.gateway.adapter.in.rest;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_MANDANT;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_OE_NAME;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.EntityReference;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Stelle;
import java.util.List;
import org.junit.jupiter.api.Test;

class BenutzerMapperTest {
    private final BenutzerMapper mapper = new BenutzerMapperImpl();

    @Test
    void givenBenutzer_thenMapAllFields() {
        final Benutzer user = Benutzer.builder()
                .id(BENUTZER_ID)
                .username(BENUTZER_USERNAME)
                .rollen(List.of(Benutzer.Rolle.builder()
                        .mandant(BENUTZER_MANDANT)
                        .organisationseinheit(new EntityReference(BENUTZER_OE_ID, BENUTZER_OE_NAME))
                        .stelle(Stelle.SACHBEARBEITUNG)
                        .isDefault(true)
                        .build()))
                .build();

        final de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Benutzer result = mapper.fromDomain(user);

        assertEquals(BENUTZER_ID, result.getId());
        assertEquals(BENUTZER_USERNAME, result.getUsername());
        assertEquals(1, result.getRollen().size());
        assertEquals(BENUTZER_MANDANT, result.getRollen().getFirst().getMandant());
        assertEquals(BENUTZER_OE_ID, result.getRollen().getFirst().getOrganisationseinheit().getId());
        assertEquals(BENUTZER_OE_NAME, result.getRollen().getFirst().getOrganisationseinheit().getName());
        assertEquals(de.muenchen.oss.eakte.schnittstelle.rest_v2.server_stubs.model.Stelle.SACHBEARBEITUNG,
                result.getRollen().getFirst().getStelle());
        assertTrue(result.getRollen().getFirst().getDefault());
    }
}

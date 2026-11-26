package de.muenchen.oss.eakte.api.v2.gateway.application.usecase;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.application.port.out.BenutzerOutPort;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BenutzerUseCaseTest {
    private static final Benutzer USER = Benutzer.builder().id(BENUTZER_ID).username(BENUTZER_USERNAME).build();

    @Mock
    private BenutzerOutPort benutzerOutPort;

    @Test
    void givenUsername_thenReturnUserFromOutPort() {
        when(benutzerOutPort.get(BENUTZER_USERNAME)).thenReturn(USER);

        final Benutzer result = new BenutzerUseCase(benutzerOutPort).get(BENUTZER_USERNAME);

        assertEquals(USER, result);
        verify(benutzerOutPort).get(BENUTZER_USERNAME);
    }
}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_ID;
import static de.muenchen.oss.eakte.api.v2.gateway.TestConstants.BENUTZER_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.service.FabasoftUserService;
import de.muenchen.oss.eakte.api.v2.gateway.domain.model.Benutzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FabasoftBenutzerAdapterTest {
    private static final Benutzer USER = Benutzer.builder().id(BENUTZER_ID).username(BENUTZER_USERNAME).build();

    @Mock
    private FabasoftUserService userService;

    @Test
    void givenUsername_thenReturnUserFromService() {
        when(userService.getByUsername(BENUTZER_USERNAME)).thenReturn(USER);

        final Benutzer result = new FabasoftBenutzerAdapter(userService).get(BENUTZER_USERNAME);

        assertEquals(USER, result);
        verify(userService).getByUsername(BENUTZER_USERNAME);
    }
}

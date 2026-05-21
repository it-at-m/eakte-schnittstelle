package de.muenchen.itm.eakte.schnittstelle.config;

import de.muenchen.itm.eakte.schnittstelle.application.service.RemoteAuthService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class BasicAuthConfig {

  Logger logger = LoggerFactory.getLogger(BasicAuthConfig.class);

  @Bean
  AuthenticationProvider externalAuthenticationProvider(RemoteAuthService remoteAuthService) {
    return new AuthenticationProvider() {

      @Override
      public Authentication authenticate(@NotNull Authentication authentication) {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        RemoteAuthService.ExternalAuthResult result = remoteAuthService.authenticate(username, password);

        if (!result.authenticated()) {
          throw new BadCredentialsException("Invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(
          username,
          null,
          result.roles().stream()
            .map(SimpleGrantedAuthority::new)
            .toList()
        );
      }

      @Override
      public boolean supports(@NotNull Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
      }
    };
  }

}

package de.muenchen.itm.eakte.schnittstelle.application.service;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RemoteAuthService {

  public record ExternalAuthResult(boolean authenticated, List<String> roles) {}

  //record AuthRequest(String username, String password) {}
  record AuthResponse(boolean valid, List<String> roles) {}

  public ExternalAuthResult authenticate(String username, String password) {
    //AuthRequest request = new AuthRequest(username, password);

//    AuthResponse response = restClient.post()
//      .uri("/api/auth/validate")
//      .body(request)
//      .retrieve()
//      .body(AuthResponse.class);

    // we should make a call to eAkte or LDAP with basicAuth
    boolean success = "ex.hofmann15".equals(username);

    AuthResponse response = new AuthResponse(true, List.of());

    return new ExternalAuthResult(response.valid(), response.roles());
  }

}
package de.muenchen.itm.eakte.schnittstelle.identity_propagation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.Optional;
import java.util.Base64;
import com.nimbusds.jwt.SignedJWT;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@Builder
public class RequestContext {
  private final Optional<String> fachverfahrensID;
  private final Optional<String> loginName;
  private final Optional<String> stelle;
  private final Optional<String> organisationseinheit;
  private final Optional<String> authHeader;

  public sealed interface AuthCredentials permits BasicAuthCredentials, BearerAuthCredentials {}

  public record BasicAuthCredentials(String username, String password) implements AuthCredentials {
    @Override
    public @NotNull String toString() {
      return "Basic Auth credentials{username: " + username + "}";
    }
  }

  public record BearerAuthCredentials(String username, String parsedString) implements AuthCredentials {
    @Override
    public @NotNull String toString() {
      return "Bearer Auth credentials{username: " + username + ", parsedString: " + parsedString + "}";
    }
  }

  private static final String BearerPrefix = "Bearer ";
  private static final String BasicPrefix = "Basic ";

  Logger logger = LoggerFactory.getLogger(RequestContext.class);

  public RequestContext(Optional<String> fachverfahrensID,
                        Optional<String> loginName,
                        Optional<String> stelle,
                        Optional<String> organisationseinheit,
                        Optional<String> authHeader) {
    this.fachverfahrensID = fachverfahrensID;
    this.loginName = loginName;
    this.stelle = stelle;
    this.organisationseinheit = organisationseinheit;
    this.authHeader = authHeader;
  }

  public Optional<AuthCredentials> getAuthCredentials() {
    Optional<AuthCredentials> bearerAuthCredentials = authHeader.filter(h -> h.startsWith(BearerPrefix)).map(this::extractBearerAuthCredentails);
    if (bearerAuthCredentials.isPresent()) {
      return bearerAuthCredentials;
    } else {
      return authHeader.filter(h -> h.startsWith(BasicPrefix)).map(this::extractBasicAuthCredentials);
    }
  }

  private BearerAuthCredentials extractBearerAuthCredentails(String bearerAuthHeader) {
    String headerValue = bearerAuthHeader.substring(BearerPrefix.length());
    // separate parts of the JWT
    String[] parts = headerValue.split("\\.");
    if (parts.length != 3) {
      throw new RuntimeException("JWT corrupted, parts count != 3!");
    }
    // Decode payload
    String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]));
    // Standard claim
    try {
      SignedJWT jwt = SignedJWT.parse(payloadJson);
      return new BearerAuthCredentials(jwt.getJWTClaimsSet().getSubject(), jwt.getParsedString()); // "sub"
    }
    catch (Exception exc) {
      throw new RuntimeException("JWT corrupted, parse error!", exc);
    }
  }

  private BasicAuthCredentials extractBasicAuthCredentials(String basicAutheader) {
    // Remove "Basic "
    String base64Credentials = authHeader.map(h -> h.substring(BasicPrefix.length())).orElseThrow();
    // Decode
    byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
    String credentials = new String(decodedBytes);
    // Split into username:password
    int colonIndex = credentials.indexOf(':');
    if (colonIndex == -1) {
      throw new RuntimeException("Basic Auth header value corrupted, parse error!");
    }
    return new BasicAuthCredentials(credentials.substring(0, colonIndex), credentials.substring(colonIndex + 1));
  }

  public String toString() {
    return String.join("\n",
      "RequestContext {",
      "  fachverfahrensID: " + fachverfahrensID.orElse("./."),
      "  loginName: " + loginName.orElse("./."),
      "  stelle: " + stelle.orElse("./."),
      "  organisationseinheit: " + organisationseinheit.orElse("./."),
      "  auth credentials: " + getAuthCredentials().map(Object::toString).orElse("./."),
      "}"
    );
  }

}

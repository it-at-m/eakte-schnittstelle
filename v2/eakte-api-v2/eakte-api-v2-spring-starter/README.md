# eAkte API v2 Spring Starter

Configure the starter with `eakte.base-url` and select an authentication mode
explicitly with `eakte.auth.mode`.

## Starter Properties

| Property | Required | Default | Description |
| --- | --- | --- | --- |
| `eakte.base-url` | Yes | None | Root URL for the API. Generated paths, including `/api/v2`, are appended. |
| `eakte.connection-timeout` | No | `30s` | Maximum time to establish the API connection. |
| `eakte.response-timeout` | No | `120s` | Maximum time to wait for an API response. |
| `eakte.auth.mode` | Yes | None | Token mode: `existing-jwt`, `client-credentials`, or `custom`. |
| `eakte.auth.client-registration-id` | No | `eakte` | Spring OAuth2 registration ID used only in `client-credentials` mode. |

In `client-credentials` mode, configure the standard Spring OAuth2 client
properties for that registration:

| Spring property | Description |
| --- | --- |
| `spring.security.oauth2.client.registration.<id>.provider` | ID of the OAuth2 provider configuration. |
| `spring.security.oauth2.client.registration.<id>.authorization-grant-type` | Set to `client_credentials`. |
| `spring.security.oauth2.client.registration.<id>.client-id` | OAuth2 client ID. |
| `spring.security.oauth2.client.registration.<id>.client-secret` | OAuth2 client secret; supply it from a secret store or environment variable. |
| `spring.security.oauth2.client.provider.<provider>.issuer-uri` | OIDC issuer used to discover provider endpoints. |

## Forward An Existing JWT

Use this mode when the current call has a Spring Security `JwtAuthenticationToken`.
The starter forwards that access token and fails without making the API request if
no JWT is present. The application must configure Spring Security to authenticate
incoming JWTs.

```yaml
eakte:
  base-url: https://eakte.example
  auth:
    mode: existing-jwt
```

Spring Security's context is thread-local by default. For asynchronous calls that
must retain the caller's identity, propagate the security context to the executor.

## Client Credentials

Use this mode for service/background calls. `client-registration-id` defaults to
`eakte` and must match the Spring OAuth2 client registration. Keep the client
secret in an external secret store or environment variable.

```yaml
eakte:
  base-url: https://eakte.example
  auth:
    mode: client-credentials
    client-registration-id: eakte

spring:
  security:
    oauth2:
      client:
        registration:
          eakte:
            provider: eakte
            authorization-grant-type: client_credentials
            client-id: ${EAKTE_OAUTH_CLIENT_ID}
            client-secret: ${EAKTE_OAUTH_CLIENT_SECRET}
        provider:
          eakte:
            issuer-uri: https://identity.example/realms/eakte
```

The authorized-client service caches the client-credentials token and obtains a
new one after expiry. The selected mode never falls back to the other mode.

## Custom Token

In `custom` mode, the starter leaves the generated `ApiClient` bearer-token
supplier unset. Inject that shared `ApiClient` and configure it before making API
calls:

```java
apiClient.setBearerToken("access-token");
```

For token refresh or per-thread token lookup, use the supplier overload instead:

```java
apiClient.setBearerToken(tokenProvider::getAccessToken);
```

The consumer owns token retrieval, refresh, and thread safety in this mode. Set the
supplier once rather than mutating the shared client around individual requests.

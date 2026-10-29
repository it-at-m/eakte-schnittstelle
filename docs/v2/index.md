# eAkte API V2

::: warning WIP
The initial implementation of the V2 is still ongoing.
:::

This document describes the eAkte API V2, which consists of the following components:

- v2-API: OpenAPI specification of the API, see [Swagger-UI](./swagger-ui.md)
- API-Gateway: An API-gateway implementing the API-spec
- Spring Client/Starter: Spring Boot client for the v2 API, see [Spring Client](#spring-client)

For further details see the [architecture documentation arc42](./arc42/index.md).

## Use

### Auth

As the V2 API uses OpenId-Connect for authentication to use the API an according client is needed.

Generally speaking, there are two scenarios here:
either the application already has a client (because it uses OpenID Connect for authentication itself),
or there is no client yet (the application uses a different technology for authentication, or there is no user context at all).
In the following the steps to make an OpenId-Connect client work with the V2 API are described.

:::info
The following steps may change in the future.
:::

1. Get an OpenId-Connect client (optional if already present)
   - Internally: use ServiceNow formular [Applikation an SSO anbinden](https://it-services.muenchen.de/sp?id=sc_cat_item&sys_id=c82aeff91b072050948e657f7b4bcb40)
   - Use client_credentials for authentication
2. The client name must be communicated to the eAkte-API team (communication channel still unclear)
   - Add `aud`-claim `eakte-apigw-v2`
   - Add `impersonate` role to the client (if technical client_credentials)
3. Update client user mappings (if impersonation is used) (WIP)
   - For advanced security for each client (which uses impersonation) a whitelist of which users can be impersonated is maintained and validated

### Spring Client

For accessing the API the two following java packages are provided to be used with Spring Boot:
- `de.muenchen.oss.eakte:eakte-api-v2-spring-client`: Plain Spring Rest Client without any configuration
- `de.muenchen.oss.eakte:eakte-api-v2-spring-starter`: Beans, properties and configuration for the client

To use one of them, it needs to be added as dependency. 
Further information regarding the starter can be found in the following.

#### Using the Generated API

The starter registers the generated API classes as Spring beans. Inject the API
you need and call its generated methods; the configured authentication mode supplies
the bearer token. The following example reads a Vorgang:

```java
import de.muenchen.oss.eakte.v2.generated.api.VorgangApi;
import de.muenchen.oss.eakte.v2.generated.model.Vorgang;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VorgangService {
    private final VorgangApi vorgangApi;

    public VorgangService(final VorgangApi vorgangApi) {
        this.vorgangApi = vorgangApi;
    }

    public Vorgang getVorgang(
            final String vorgangsId,
            final String loginName) {
        return vorgangApi.getVorgang(
                vorgangsId, loginName, null, null, List.of());
    }
}
```

#### Starter Properties

| Property                            | Required | Default | Description                                                                                  |
|-------------------------------------|----------|---------|----------------------------------------------------------------------------------------------|
| `eakte.base-url`                    | Yes      | None    | Root URL for the API. Generated paths, including `/api/v2`, are appended.                    |
| `eakte.connection-timeout`          | No       | `30s`   | Maximum time to establish the API connection.                                                |
| `eakte.response-timeout`            | No       | `120s`  | Maximum time to wait for an API response.                                                    |
| `eakte.auth.mode`                   | Yes      | None    | Token mode: `existing-jwt`, `client-credentials`, or `custom`.                               |
| `eakte.auth.client-registration-id` | No       | `eakte` | OAuth2 registration ID used for client-credentials tokens, including the custom-mode helper. |

#### Forward An Existing JWT

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

#### Client Credentials

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
new one after expiry.

#### Custom Token

In `custom` mode, the starter leaves the generated `ApiClient` bearer-token
supplier unset. Inject the shared `ApiClient` and `EAkteTokenProvider`, then choose
one of the provider's token methods before making API calls.

To forward the current JWT:

```
apiClient.setBearerToken(tokenProvider::getExistingJwtAccessToken);
```

To use client credentials, configure the standard Spring OAuth2 registration shown
above and use:

```
apiClient.setBearerToken(tokenProvider::getClientCredentialsAccessToken);
```

For a completely application-defined token source, use either overload directly:

```
apiClient.setBearerToken("access-token");
apiClient.setBearerToken(() -> tokenService.getAccessToken());
```

The consumer owns token retrieval, refresh, and thread safety for custom token
sources. Set the supplier once rather than mutating the shared client around
individual requests.

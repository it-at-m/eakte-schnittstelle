# eAkte API V2

::: warning WIP
The initial implementation of the V2 is still ongoing.
:::

This document describes the eAkte API V2, which consists of the following components:

- v2-API: OpenAPI specification of the API, see [Swagger-UI](./swagger-ui.md)
- API-Gateway: An API-gateway implementing the API-spec

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

TBD

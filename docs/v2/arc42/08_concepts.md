# Cross-cutting Concepts

## Language

As a simple guideline, subject-specific terms should be written in German and everything else in English.

## API Conventions

- Prefix endpoints with version (e.g. `/api/v2`)
- Endpoint paths in multiples (e.g. `/vorgaenge`)
- JSON properties in `camelCase`
- Query parameters in `snake_case`
- Headers in `Title-Case`
- Headers start with prefix `EAkte-`

## Auth / Impersonation

For authentication and authorization OpenID Connect is used while the V2 gateway works as a resource server.

In general there are two auth cases which are described in the following.

### Existing JWT

An application which uses OpenId Connect for auth and has an JWT for the according user context.

In this case the JWT can be directly forwarded to the v2 gateway, which uses the user the JWT was issued to for requests to the eAkte.

Impersonation in this case is only done internally and the impersonation header shouldn't be set by the client.

### No existing JWT

The other case is, that either the application uses something different from OpenId Connect or doesn't have any user context at all (e.g. scheduled jobs).

In this case the JWT needs to be retrieved via the `client_credentials` grant type and provide the user which should be impersonated with each request.

### Additional validation

Additional to the default JWT signature validate, the `aud`/audience claim is validated, to restrict which clients can access the gateway.

Also for impersonation the user/client needs to have the `impersonate` role (and be part of the token), which is validated if the impersonation header is present.

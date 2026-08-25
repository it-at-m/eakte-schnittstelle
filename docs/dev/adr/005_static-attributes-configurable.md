# 005 - Configuration of Static Attributes

Status: Accepted
Date: 2026-07-30

## Context

The resources accessible through the API have a set of attributes that are always available (standard Fabasoft attributes), 
but not all of them need or should be available through the API.
Because of that the API needs a defined set of these attributes to return consistently.

Two options are available:
- Maintain a static mapping in the API specification and gateway
- Configure the attributes dynamically through properties and aliases

## Decision

Maintain the static attributes through a static mapping in the API specification and the API gateway. 
This decision was made because every alias needs to be documented in the specification one way or another and then 
there is no advantage over the full static version. Also, the maintenance of the available attributes isn't that much work.

## Consequences

- The returned static attributes are explicit and stable for API clients.
- The mapping must be maintained when static attributes change.

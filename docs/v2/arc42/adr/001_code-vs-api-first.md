# 001 - Code- vs API-First

Status: accepted  
Date: 2026-05-11

## Context

For the eAkte interface, a specification is required that can be communicated and used by client developers to build their software.
The preferred standard for REST services is the "OpenAPI Specification" maintained by the Linux Foundation (<https://www.openapis.org>).

Two approaches are considered to generate this documentation format:

- Code-First: Endpoints and the structure of requests and responses are documented via Java annotations within the REST controller source code. These annotations can be extracted at runtime using an embedded classpath scanner and presented via Swagger-UI.
- API-First: Endpoints and request/response structures are modeled first using an Interface Description Language (IDL), specifically OpenAPI. This model can be used offline and later in a deployed service, with Swagger-UI accessible for documentation.

## Decision

API-First approach will be implemented.

## Consequences

- The API will be treated as an independent artifact with its own lifecycle, ensuring separation of concerns between specification and implementation
- The API will be defined and documented independently of specific implementations
- Development, maintenance, and documentation of the API can be performed by interface specialists who may not be programmers
- Client-side development can begin based on the API specification before the actual service implementation is available
- A centralized, redundancy-free specification of the API data model will be maintained
- This approach supports better flexibility, maintainability, and clarity in API development and documentation

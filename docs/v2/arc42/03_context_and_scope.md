# Context and Scope

## Business Context

## Technical Context

```mermaid
flowchart LR
    FV1 -->|REST| v2
    FV2 -->|REST| v2
    v2[V2 API Gateway] --> |SOAP| fsc[FSCGOV-API] --> dms[Fabasoft Gov Suite]
```

Also see [Reference Architecture](./02_architecture_constraints.md#reference-architecture) and [FSCGOV-API](./02_architecture_constraints.md#fscgov-api) for further details.

# 002 - All Attributes Variable

Status: open  
Date: TBD

## Context

The resources contain both static attributes (required for every instance of a resource) and variable attributes that can differ across instances, tenants, or configurations.
Some variable attributes can be optional in general but required in specific contexts.

There are two architectural approaches for exposing this resources:

1. Mixed model: Keep static attributes explicitly defined and typed in the API specification; expose variable attributes through a generic container (for example, a map<string, object>) and document them separately.
2. All-variable model: Treat every attribute as variable and expose them only through a generic container; the API specification does not enumerate any fields.

## Decision

TBD

## Consequences

- Pros of treating all attributes as variable
  - Adding new fields does not require changes to the API specification (but this is the case for variable fields in both versions).
  - A uniform interface surface, because clients always interact with a single variable-attribute container.

- Cons of treating all attributes as variable
  - The API specification does not reveal which fields are guaranteed or required (but there are also cases where variable fields are conditionally required in specific contexts).
  - Static fields must be documented outside the API specification, which requires reading additional documentation even for the simplest cases.
  - Typical Spring Bean Validation mechanisms cannot be leveraged for static fields. Validation must be implemented as custom runtime logic.
  - Strong typing has to be handled dynamically even for conceptually static attributes.
  - Parsing and mapping of request and response payloads is more complex, even for static attributes, because application code must perform it instead of relying on generated code and compile-time types.

# 008 - Document Resources Versus Subtype Resources

Status: Accepted
Date: 2026-08-17

## Context

The document resource has multiple subtypes (german: Eingang, Erledigung, Intern), which share most but not all attributes.

The API could either have own endpoints for these subtypes or only expose them through one document resource.

## Decision

Provide create, read, and update endpoints for the document subtypes.
Child-resource endpoints (see ADR006) return documents and identify their subtype through the `klasse` attribute.

## Consequences

- Clients can use subtype-specific endpoints for create, read, and update operations.
- The document representation remains shared across subtypes.
- Clients must use `klasse` when they need to distinguish document subtypes.

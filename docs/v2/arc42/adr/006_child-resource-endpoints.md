# 006 - Child Resource Endpoints

Status: Accepted
Date: 2026-08-17

## Context

Some resources are children of other resources, for example procedures belonging to files.
Child resources could either be accessed through dedicated nested endpoints or only through search endpoints.

## Decision

Provide dedicated nested endpoints for child resources, for example `/sachakten/{sachakteId}/vorgaenge`, because
the implementation effort is acceptable compared to the usability benefit.

## Consequences

- Clients get a direct and easy to understand way to access related resources.
- The API requires additional nested endpoint definitions.

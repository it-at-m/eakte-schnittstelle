# 007 - Polymorphic Parent References (DEPRECATED)

Status: Deprecated
Date: 2026-08-17

::: warning Deprecated
Eingangsdokumente only know there parent Vorgang not if they are in a Postkorb/Arbeitsvorrat.
Because of that this ADR can't be applied.
:::

## Context

Some resources can have different parent resource types (polymorphic relationships).
For example, an incoming document may belong to an inbox, a work queue, or a procedure.

## Decision

Use `parent_id` and `parent_type` where a resource can have different parent types.
Where the parent type is fixed, use a specifically named reference such as `sachakte_id`.

## Consequences

- Polymorphic relationships are represented consistently.
- Clients must interpret `parent_id` together with `parent_type` where applicable.
- Fixed parent relationships remain explicit and strongly named.

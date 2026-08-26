# 007 - Polymorphic Parent References

Status: Accepted
Date: 2026-08-17

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

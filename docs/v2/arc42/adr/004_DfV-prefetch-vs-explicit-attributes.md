# 004 - DfV-Prefetch vs explicit Attributes

Status: Accepted
Date: 2026-07-30

## Context

The API needs to support DfV (german: Definition für Verfahren), which are variable attributes that may be available on
resources and can differ between object instances.

The API could support that in two different ways:

- DfV-Prefetch: when getting or searching for a resource all available DfV attributes are returned automatically
  - This could be done by keeping a list of all globally available DfV and always loading them (only available attributes are returned from the Fabasoft API)
- Explicit attributes: each request defines all attributes which should be returned and only that are loaded

## Decision

Prefetch DfV attributes by default, but also provide an attribute argument that disables prefetching and loads only the explicitly requested attributes.

## Consequences

- Clients receive available DfV attributes by default.
- Clients can reduce the response and loading effort by explicitly selecting attributes.
- The default behavior may load more attributes than a specific client needs.
- Caching details for DfV-Prefetch remains open until a separate decision is made.

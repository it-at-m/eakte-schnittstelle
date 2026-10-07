# 009 - Role and OU Mapping

Status: Accepted
Date: 2026-09-

## Context

At different places the user needs to provide references to organizational units (OU) and DMS roles (e.g. headers for request context modification or part of the payload).

In the v1 implementation OUs were represented with COOs and roles with there reference (e.g. `DocumentManager`).

Different alternatives:
- COOs for OU and/or role
  - Differ between environments (only OU)
  - Mapping is unknown when only having the COO
- Names for OU
  - If an OU is renamed all references need to be updated
- Name for role (english reference)
- Name for role (german description)
- External id for OU

## Decision

Use external ID for OU and german name for roles (as enum in spec).

## Consequences

- All OUs with the according external ID need to be loaded and used for mapping
- The available roles are hardcoded into the OpenAPI spec
- On changes to the roles the API spec needs to be modified

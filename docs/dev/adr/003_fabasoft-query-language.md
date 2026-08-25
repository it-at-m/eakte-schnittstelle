# 003 - Use of the Fabasoft Query Language

Status: Accepted
Date: 2026-07-04

## Context

For search endpoints there needs to be a way to define conditions for objects which should be found.
In the previous V1 API the only option was searching for the object name with an `like` comparator, which wasn't enough for some use cases.

So the requirements for the new condition parameter are:
- More comparators like `gt`, `lt`, `eq`, `like`
- All available attributes should be filterable through the condition

Possible alternatives:
- Defining and implementing an own condition language
- Use the Fabasoft query language

## Decision

The Fabasoft Query Language will be used for search endpoints, because the reimplementation only increases the complexity,
while still relying on the FQL and all its particularities.

Only query parts that clients need should be exposed.

## Consequences

- The API supports the required query operators without reimplementing the Fabasoft query language.
- The API is coupled to the Fabasoft query language.

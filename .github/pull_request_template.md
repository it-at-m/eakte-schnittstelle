# Pull Request

<!-- Links -->
[code-quality-link]: https://refarch.oss.muenchen.de/templates/develop#code-quality

## Changes

- ...
- ...

## Reference

Issue: #XXX

## Checklist

**Note**: If some checklist items are not relevant for your PR, just remove them.

### General

- [ ] Met all acceptance criteria of the issue
- [ ] Added meaningful PR title and list of changes in the description
- [ ] Updated documentation

### Code

- [ ] Wrote code and comments in English
- [ ] Added unit tests
- [ ] Removed waste on branch (e.g. `console.log`), see [code quality tooling][code-quality-link]

#### Backend / EAI

- [ ] Added integration tests
- [ ] Updated database migration scripts (if changes to model were made)
- [ ] Added Swagger API annotations (if changes to API was made)
- [ ] Checked Spring Boot version matching Camel version in `pom.xml` (if Camel version was bumped)

### Development Stack

- [ ] Checked functionality of Docker stack (if Docker stack was modified or images were changed)

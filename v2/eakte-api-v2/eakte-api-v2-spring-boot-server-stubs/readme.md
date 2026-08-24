# Code Generation for Spring Boot Server

This submodule creates an artifact with the id
`eakte-api-spring-boot-server` to be added in a server project
configuration as a java dependency without having to cope with the
intricacies of the OpenAPI spec, the code generation tooling and the
code generation parameterization.

The generated library includes both the model classes ("DTOs") and the
http adapter interfaces.

A preliminary decision was made, that for the time being the generated
sources are kept in the tree of versioned files for easy access and
comparison between generations. This ensures also that the sources used
in a build can be visited independently of a functioning build system
(e.g. for stack trace analysis). The respective files can be fopund in
the subdirectory `src-generated` of the module.

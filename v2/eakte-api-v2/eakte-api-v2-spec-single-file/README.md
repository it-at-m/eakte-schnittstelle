# Conversion of multi-file OpenAPI spec to single file

## Mechanism

The openapi generator (used for java code generation) doesn’t offer the
merging functionality to create a single self-contained API
specification document, therefore this separate module makes that
conversion.

## Result

As a result there will be a single OpenAPI spec file in
src/main/resources. We put that under version control for easy access
without running a build, and to be able to reproduce the history of the
file.

This will be packed into a zip file in the `target` directory (because
ordinary files are no supported as maven artifacts):

    eakte-api-single-file-spec-LocalBuild.zip

Due to the inner workings of maven, the (default) jar file is also
generated (which is empty, except for the MANIFEST.MF) but can and
should be ignored. This could be avoided by writing a zip-file maven
plugin and registering 'zip' as a valid packaging type in maven, which
wasn’t considered worth the effort.

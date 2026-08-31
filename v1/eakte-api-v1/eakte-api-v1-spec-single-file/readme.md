# Conversion of multi-file OpenAPI spec to single file

## Whole API specification in a single file

A single-file OpenAPI specification can be found in this module under

```bash
src/main/resources
```

We have put that under version control for easy access
without running a build, and to be able to reproduce the history of the
file. But note that after changing any API-related file in the module 'eakte-open-api-v1'
there needs to run a mavne build to reconstruct the single-file api spec.

The generated single-file spec will be packed into a zip file in the `target` directory 
(because ordinary files are not supported as maven artifacts):

    eakte-api-v1-spec-1.2.7.zip

(the version suffix of course can and will vary).

Due to the inner workings of maven, the (default) jar file is also
generated (which is empty, except for the MANIFEST.MF) but can and
should be ignored. (This could be avoided by writing a zip-file maven
plugin and registering 'zip' as a valid packaging type in maven, which
wasn’t considered worth the effort.)

## Rebuild it

The structured set of yaml-files that comprise the specification of the API
can be transformed into a single yaml-file by issuing a maven build:

````bash
mvn install
````



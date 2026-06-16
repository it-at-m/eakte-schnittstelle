#!/bin/bash

# regenerate the stubs, but re-installing the spec first, because
# the stub generation doesn't consider actual changes in the spec files in the workspace,
# but gets the spec from the m2 repository (referenced as an ordinary maven artifact dependency)

SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd)
cd "${SCRIPT_DIR}" || exit 1
(cd ../eakte-api-v2-spec && mvn install)
mvn clean install

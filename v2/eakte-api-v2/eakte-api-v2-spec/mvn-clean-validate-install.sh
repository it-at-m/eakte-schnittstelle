#!/bin/bash
SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd)
cd "${SCRIPT_DIR}" || exit 1
mvn clean openapi-style-validator:validate install
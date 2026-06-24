#!/bin/bash
SCRIPT_DIR=$(cd "$(dirname "$0")" && pwd)
cd "${SCRIPT_DIR}" || exit 1
tput rmam
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.additional-location=classpath:application-test-credentials.yaml"
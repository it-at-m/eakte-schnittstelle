#!/bin/bash
npx @redocly/cli bundle target/unpacked-dependencies/eakte-rest-api-v2/__ServiceDefinition.yaml -o src/main/resources/eakte-rest-api-v2-spec-single-file.yaml

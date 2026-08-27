# Architecture Constraints

## Reference Architecture

For each development at it@M/LHM, the application should use the [reference architecture](https://refarch.oss.muenchen.de/).

This in general would allow to implement the gateway either with Apache Camel or Spring.
Because Spring is more suitable for REST APIs, especially for multipart handling, using Spring is
treated as a constraint rather than a decision.

## FSCGOV API

For communication with the eAkte, the FSCGOV-API needs to be used, which is based on SOAP.
It replaces the in V1 used MUCS-SOAP which is an LHM-specific implementation.

### Trusted Application Login

For authentication with the FSCGOV-API Trusted-Application-Login must be used which is basically mTLS.
This allows the impersonation of users with a single client cert and therefore the gateway can implement a custom user authentication mapping.

In V1 Relax-Login was used, which is a custom MUCS-SOAP implementation.

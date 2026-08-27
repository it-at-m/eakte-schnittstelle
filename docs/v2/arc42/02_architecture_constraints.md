# Architecture Constraints

## Reference Architecture

As each development at it@M/LHM the application should be implemented with the [reference architecture](https://refarch.oss.muenchen.de/).

This in general would allow to implement the gateway either with Apache Camel or Spring.
As Spring is way more suitable for REST-API (especially because auf Multi-Part handling) the use of Spring for
implementation is regarded as constraint and no decision.

## FSCGOV API

For communication with the eAkte, the FSCGOV-API needs to be used, which is based on SOAP.
It replaces the in V1 used MUCS-SOAP which is an LHM-specific implementation.

### Trusted Application Login

For authentication with the FSCGOV-API Trusted-Application-Login must be used which is basically mTLS.
This allows the impersonation of users with a single client cert and therefore the gateway can implement a custom user authentication mapping.

In V1 Relax-Login was used, which is a custom MUCS-SOAP implementation.

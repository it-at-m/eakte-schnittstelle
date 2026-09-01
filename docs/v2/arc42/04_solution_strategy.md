# Solution Strategy

- Modular monolith (1 API-Gateway as deployable, maybe a separate EAI adapter for support of API v1)
- Development as Open Source Project on GitHub
- REST API following resource-oriented design
- API-first interface design and development, based on OpenAPI-V3 (upstream)
- SOAP communication with DMS (based on manufacturer house standard API "FSCGOVXML")
- Spring Boot based Java development
- Hexagonal / onion architecture for source code organization
- Token-based authentication via JWT/Keycloak
- Deployment on internal OpenShift platform ("CAP")

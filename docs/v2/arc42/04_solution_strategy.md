# Solution Strategy
* Modular monolith (1 API-Gateway as deployable, maybe a separate EAI adapter for support of API v1)
* development as Open Source Project on GitHub
* REST API following resource-oriented design
* API-first interface design and development, based on OpenAPI-V3 (upstream)
* SOAP communication with DMS (based on manufacturer house standard API "FSCGOVXML")
* Spring Boot based Java development
* hexagonal / onion architecture for source code organization
* token-based authentication via JWT/Keycloak
* deployment on internal OpenShift platfrom ("CAP")

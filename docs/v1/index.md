# eAkte Schnittstelle V1

## API-Spezifikation (gemäß OpenAPI-Standard)

- **aktuelle Version:** 1.2.5
- **Source Code der Spec:** [v1/eakte-api](https://github.com/it-at-m/eakte-schnittstelle/tree/main/v1/eakte-api)
- **Swagger-UI zur interaktiven Erkundung:** [SwaggerUI](./swagger-ui.md)

## Beschreibung der Schnittstellen-Anwendungsfälle

[Use Cases](./usecases.md)

## REST-EAI-Adapter

Quelltext und lauffähiges Image des eAkte-EAI-Adapters:

- **Source Code:** [v1/eakte-eai](https://github.com/it-at-m/eakte-schnittstelle/tree/main/v1/eakte-eai])
- **Container Image:** [ghcr.io/it-at-m/eakte-schnittstelle/v1/eakte-eai](https://github.com/it-at-m/eakte-schnittstelle/pkgs/container/eakte-schnittstelle%2Fv1%2Feakte-eai)

## Spring Boot Client

```xml
<dependencies>
    <dependency>de.muenchen.oss.eakte</dependency>
    <dependency>eakte-api-v1-spring-starter</dependency>
    <version>...</version>
</dependencies>
```

### Configuration

```yaml
eakte:
  base-url: https://example.com/api
  username:
  password:
  connection-timeout: 30s # default
  response-timeout: 120s # default
```

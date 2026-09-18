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

## eAkte-Schnittstellen-Aufruf mit Spring Boot Client

Für die Nutzung des bereitgestellten Spring-Boot-Starter-Artefakts muss lediglich eine Abhängigkeit in die Projekt-POM eingetragen werden.

Die gewünschte Version kann über Maven-Central ermittelt werden und die Dependency-Sektion von dort kopiert werden:

<https://central.sonatype.com/search?q=eakte-api-v1-spring-starter>

```xml
<dependencies>
  <dependency>
    <groupId>de.muenchen.oss.eakte</groupId>
    <artifactId>eakte-api-v1-spring-starter</artifactId>
    <version>1.2.7</version>
  </dependency>
</dependencies>
```

Spätere automatische Upgrades auf verfügbare neuere Versionen können, wenn gewünscht, durch Aktivierung des Renovate-Bots bewerkstelligt werden (s. <https://github.com/renovatebot/renovate>).

### Konfiguration der Verbindungsparameter

In die `application.yaml` der Applikation müssen die Parameter für die Verbindung zum eAkte-EAI-Adapter aufgenommen werden:

```yaml
eakte:
  base-url: https://eakte-eai-adapter.your-domain.de
  username: eai-user
  password: eai-password
  connection-timeout: 30s # default
  response-timeout: 120s # default
```

### Ausführung von Schnittstellen-Aufrufen im Java-Code

In der Spring-Boot-basierten Applikation können nun durch Verwendung der Klassen aus dem Spring-Boot-Starter-Modul `eakte-api-v1-spring-starter` (bzw. dem eigentlichen Schnittstellen-Modul `eakte-api-v1-spring-client`) die Aufrufe an die eAkte getätigt werden.

Im Wesentlichen wird dabei die für den betreffenden Endpunkt bzw. die Schriftgutklasse benötigte Api-Klasse injiziert und damit die gewünschte eAkte-Operation aufgerufen.

Beispiel:

```java
package com.acme.eakte.exampleapp;

import de.muenchen.oss.eakte.v1.generated.api.ContentObjectsApi;
import de.muenchen.oss.eakte.v1.generated.model.CreateContentObjectAnfrageDTO;
import de.muenchen.oss.eakte.v1.generated.model.CreateContentObjectAntwortDTO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class EAkteCallExample {

  private final ContentObjectsApi contentObjectsApi;

  public EAkteCallExample(ContentObjectsApi contentObjectsApi) {
    this.contentObjectsApi = contentObjectsApi;
  }

  public String createSampleContentObjectInEAkte() {
    final CreateContentObjectAntwortDTO response = contentObjectsApi.createContentObject(
      "user-login",
      new CreateContentObjectAnfrageDTO().referrednumber("COO.1.2301.1.1042432"),
      "test-application",
      "COO.1.2301.1.ou",
      "Official",
      List.of(new ByteArrayResource("file-content".getBytes(StandardCharsets.UTF_8)) {
        @Override
        public String getFilename() {
          return "test.txt";
        }
      }));
    return response.getObjid();
  }
}
```

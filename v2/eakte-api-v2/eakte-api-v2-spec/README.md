## OpenAPI specification of the DMS API v2

In diesem Maven-Modul befindet sich die Schnittstellendefinition
der eAkte-API-v2, basierend auf der Schnittstellenbeschreibungssprache
"OpenAPI" (V3).

Die Einstiegsdatei ist

````text
    src/main/resources/eakte-rest-api-v2/__ServiceDefinition.yaml
````

Parallel dazu im selben Verzeichnis liegen weitere yaml-Dateien, die verschiedene Endpunkte bzw. verschiedene Datentypen innerhalb der REST-Schnittstelle beschreiben. Diese werden jeweils von der übergeordneten Datei über das Konstrukt mit dem Schlüsselwort '$ref' inkludiert.

Die Aufteilung in mehrere/viele Dateien wurde vorgenommen, weil 
  * die Navigation bei der manuellen Erstellung und Pflege leichter fällt und Fragmente leichter verglichen werden können
  * die Änderungen leichter im Versionierungssystem (Git) im Rahmen von Pull Requests und Versions-Historie nachvollzogen werden können
  * die speziellen syntax-sensitiven Editoren bei einer Single-File-Spezifikation öfter extrem verzögert reagiert haben und teilweise sich aufgehangen haben.

Für Fälle, in denen eine einzige Spezifikationsdatei bevorzugt wird, wird im parallel liegenden Maven-Modul 'eakte-api-v2-spec-single-file' eine solche automatisch generiert.

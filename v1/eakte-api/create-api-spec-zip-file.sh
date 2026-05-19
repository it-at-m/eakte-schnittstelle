#!/bin/bash
set -e -u
read -p "Eingabe Versions-Suffix für die Zip-Datei (z.B. '1.2.5'): " version
if [[ -z "${version}" ]]
then
  echo "Eingabe für Version fehlt, breche ab."
  exit 1
fi
targetFile=snapshots/eakte-api-spec-${version}.zip
if [[ -f "${targetFile}" ]]
then
  echo "Die Datei gibt es schon: ${targetFile}"
  echo "(wenn Ersetzen beabsichtigt, bitte die Datei löschen, sicherheitshalber überschreibt dieses Skript nicht!)"
  exit 1
fi
jar -c -M -f "${targetFile}" -C ./src/main/resources eakte-api-spec
echo "Datei geschrieben: ${targetFile}"

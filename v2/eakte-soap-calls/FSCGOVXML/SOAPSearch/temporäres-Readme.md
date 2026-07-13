
# Evaluierung zu Verfahrensattributen

## Kontext / Aufgabenstellung:

* In der 'attrlist' eines SOAPSearch Calls müssen alle Attribute benannt werden, die
  als Felder in den Ergebnisobjekten zurückgegeben werden sollen (kein "SELECT *" wie bei SQL). Deshalb müssen bei der Generischen Suche insbesondere die für die jeweilige Objektklasse (File, Procedure, Document) verfügbaren - und potentiell befüllten - Custom-Attribute (Attribute aus Definition für Verfahren) übergeben werden.
* Benötigt wird hier die "Vollständige Referenz" (property 'fullreference') des Verfahrensattributs.
* Außer in der 'attrlist' muss diese "Vollständige Referenz" auch verwendet werden, wenn in der WHERE-Klausel der Fabasoft-Query Restriktionen für Verfahrensattribute formuliert werden sollen.
* Die "Vollständige Referenz" wird indirekt auch benötigt, wenn wir in der WHERE-Klause einen sprechenderen Platzhalter ("Makro") ermöglichen wollen. Dies wird aber im Moment zurückgestellt. Bei Abwesenheit eines Platzhalter wird die WHERE-Klausel an die eAkte weitergeben wie übergeben, muss also die Fabasoft-Referenzen beinhalten.

## Zwischenergebnis 10.07.2026

Die bisherige Evaluierung des Fabasoft-Objektmodells bzw. der Fabasoft-Query-Language hat insbesondere zu den beiden folgenden provisorischen Abfragen geführt:

### "SOAPSearch 2026-07-10 - Suche Aktenplaneinträge mit allen untergeordneten DfV-Attributen"
Beginnend beim entsprechenden Aktenplaneintrag werden die Objektklassen über mehrere Ebenen hinweg in einer Query abgefragt: 
* Aktenplaneintrag
* DfV Aktenebene
* DfV Vorgangsebene
* Formularseite
* Kategorie (veröffentlicht)
* Verfahrensattribut

Dadurch können alle für die fachliche und technische Identifikation eines Verfahrensattributs relevanten Namen und Eigenschaften ausgelesen werden bzw. geeignete Filter implementiert werden.

### "SOAPSearch - Suche Vorgang mit DfV-Attribut"

Beispiel für einen SOAPSearch Call unter Verwendung eines Verfahrensattributs. Das Verfahrensattribut wird sowohl in der 'attrlist' als auch in der WHERE-Klause als Suchkriterium benutzt.
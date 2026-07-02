
# 003 - Design Generic Search [DRAFT]

## Status Quo

### Existing Calls with Search Functionality in eAkte Software Component LHMBAI

#### SearchObjNameGI: Searchable Properties

* searchstring "Suchstring für Objektname"
* objclass "Objektklasse" COOSYSTEM@1.1:objclass
* reference "Referenz des Fachdatum" (COOSYSTEM@1.1:reference)
* value "Wert des Fachdatum" (COOELAK@1.1001:value)

#### SearchApentryGI: Searchable Properties

* basenr "Aktenplankennzeichen" (COOELAK@1.1001:basenr)
* subjareaspecreference "Ableitung" (DEPRECONFIG@15.1001:subjareaspecreference)

#### SearchFileGI: Searchable Properties

* apentry "Coo-Adresse des Aktenplankennzeichen" (ELAKGOV@1.1001:apentry)
* filereference "Geschäftszeichen" (COOELAK@1.1001:filereference)
* objmlname "Titel" (COOELAK@1.1001:objmlname)
* filesubj "Betreff" (der Akte) (COOELAK@1.1001:filesubj)

#### SearchProcedureGI: Searchable Properties

* referrednumber "Coo-Adresse des der Akte" (COOELAK@1.1001:referrednumber)
* filereference "Geschäftszeichen" (COOELAK@1.1001:filereference)
* objmlname "Name" (COOELAK@1.1001:objmlname)
* filesubj "Betreff" (des Vorgangs!) (COOELAK@1.1001:filesubj)

### Deficiencies of the existing Search Calls in LHMBAI

* Only very limited set of object properties is searchable
* Criteria matching only by pattern matching for strings, no real comparison operators. e.g. for date ranges
* Only simple matching with one pattern per property (no boolean operators like AND/OR/NOT)
* No search for object class 'Document'
* "Definition für Verfahren" not supported at all

### Existing Calls with Search Functionality in BAY-eAS

#### relevant controller methods (endpoint/operations offered by the eAS server)

```
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheAktenplaneintrag
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheAkte
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheVorgang
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheDokument
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheSchriftstueck
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheOrganisationseinheit
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheBenutzer
de.bayern.itdlz.eakte.eas.ws.EasEndpoint#sucheUmlaufmappe
```

#### relevant processor methods / out-adapter (mapping to used operations of FSCGOVXML)

```
de.bayern.itdlz.eakte.eas.egovclient.EgovClientCxf#searchEgovObject
de.bayern.itdlz.eakte.eas.egovclient.EgovClientCxf#buildQueryString
```

### deficiencies of the existing Search Calls in BAY-eAS 

* only allows a simple list of AND-concatenated criteria expressed by an equality test (=) or a pattern matching (LIKE)

## Overall Design of a true Generic Search

A broadly usable search functionality should support:
* all object properties with the appropriate datatypes thus supporting the related comparison operators (<, >, ...), especially for numbers (including currencies) and dates
* arbitrary boolean combinations of criteria (AND, OR, NOT, parentheses)
* especially supporting dynamic attributes from 'Definition für Verfahren'
* speaking attribute names (not cryptic references or COO-adresses) 
* attribute names that are retained between differens systems / release stages
* 






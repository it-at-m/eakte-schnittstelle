
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
* attribute names (and thus query strings / where conditions) that are retained between differens systems / release stages

## Possible Solutions

* use the search functionality of BAY-eAS (pattern matching, single pattern per attribute), but extend it somehow to cover DfV attributes as well
* create a new search method, that uses the SOAPSearch call of the FSCGOVXML software component (a.k.a. "standard library"), but in a more flexible way as BAY-eAS

## Design Considerations and Decisions

[DRAFT!]

* Searching is done in the context of a certain object class, specifically one of:
  * Aktenplaneinträge
  * Akten
  * Vorgänge
  * Dokumente
  * (Schriftstücke?)
  * Organisationseinheiten
  * Benutzer
  
  Thus the result set is homogenous and (except for the dynamic nature of the DfV attributes) can be processed straight forward without having to check for unknown object classes or unknown attributes.

* Implementation note: As a result of separate class-confined searches, the "FROM" clause of the Fabasoft query string (specifying the object classes to consider in the search) would be constant. The attribute list would be partially constant, if we want to return at least the static set of the previously available attributes (extended by the DfV attributes).

* The search API would include a flexible way to specify restrictions ("WHERE" clause of the Fabasoft QL), allowing for multiple conditions, comparison operators and boolean combinators.

* As syntax of the query specification there are at least two possibilities:
  * create an own suitable syntax and translate this into the internal Fabasoft Query Language
  * use the Fabasoft Query Language

* The use of the Fabasoft QL is to be preferred with respect to the effort and to provide a consistent mechanism between ths eGov-Suite GUI and our API. Thus a developer can evaluate a query in the GUI and then translate this into an API call.

* Security considerations when using Fabasoft QL: it's uncritical because we only allow the WHERE clause to be specified, we only allow read access and all query results are filtered by the Fabasoft kernel according to the roles and permissions of the user context. As far as the Fabasoft documentation (app-ducx manual) goes is no possibility of an equivalent of "SQL injection". The resulting Fabasoft QL will be parsed, translated and executed by the eGov-Suite kernel in a safe manner.

* To shield the external world (the Fachverfahren / API) from the internal workings of the DMS it is recommendable to **not** use internal IDs (COO addresses, 'programming name') of the eGov-Suite, but to use neutral identifiers for the attribute references. These should be (as we are in the context of a RESTful API) the URLs of the attributes, or (maybe more user friendly) the labels of those attributes as they are seen on the Web interface.

* Contrary to the assumption of Herrn Rabis (Fabasoft) it seems that using the query functionality to retrieve single resources or the children of a parent resource is feasable and not necessarily connected with a relevant performance penalty. An internal call of the kernel 'getProperties' would probably do exactly what the explicit query does: perfrom a search where the reference (parent object) is the single restriction.







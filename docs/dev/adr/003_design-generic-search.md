
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
* Criteria matching works only by exakt or pattern matching for strings, no real comparison operators. e.g. for date ranges, numbers of enumeration types
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

## Design Considerations and pending Decisions

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
   * use the Fabasoft Query Language (in a restricted/controlled manner)

* The use of the Fabasoft QL is to be preferred with respect to the effort and to provide a consistent mechanism between ths eGov-Suite GUI and our API. Thus a developer can evaluate a query in the GUI and then translate this into an API call.

* Security considerations when using Fabasoft QL: it's uncritical because we only allow the WHERE clause to be specified, we only allow read access and all query results are filtered by the Fabasoft kernel according to the roles and permissions of the user context. As far as the Fabasoft documentation (app-ducx manual) goes is no possibility of an equivalent of "SQL injection". The resulting Fabasoft QL will be parsed, translated and executed by the eGov-Suite kernel in a safe manner.

* To shield the external world (the Fachverfahren / API) from the internal workings of the DMS it is recommendable to **not** use internal IDs (COO addresses, 'programming name') of the eGov-Suite, but to use neutral identifiers for the attribute references. These should be (as we are in the context of a RESTful API) the URLs of the attributes, or (maybe more user friendly) the labels of those attributes as they are seen on the Web interface.

* Contrary to the assumption of Herrn Rabis (Fabasoft) it seems that using the query functionality to retrieve single resources or the children of a parent resource is feasable and not necessarily connected with a relevant performance penalty. An internal call of the kernel 'getProperties' would probably do exactly what the explicit query does: perfrom a search where the reference (parent object) is the single restriction.

* To enable the developers of API clients to create correct queries they need to know, which attributes are available in the context of a specific subject area (Aktenplaneintrag/Betreffseinheit), what their type is and how to reference them in the query (i.e. which identifier to use). 

  There are two general options to cover this:
  * looking all that up in the eGov-Suite GUI
  * provide a specific endpoint (REST resource) with the attribute metadata 
 The latter seems to be more appropriate, as the structure for the "Definition für Verfahren" in the Fabasoft object model (and in the GUI) is quite complex and should not "spill over" to the development of API clients.

* The query specification should be put into the "query parameter" part of the REST API. This allows 
  * bookmarking queries
  * simple GET requests (executable via browser)
  * putting the whole query request into a JSON field (URL + necessary payload), thus enabling a single string-typed reference to point to a whole collection defined by the query

* API-First strategy: The Query functionality (as well as the whole eAkte API-v2) will be defined and documented as OpenAPI Specification as given in
   * https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.1.0.md
   * https://spec.openapis.org/oas/v3.1.0.html 
  
  Additional norms in that context are
   * OpenAPI Overlay Specification: 
     
     https://github.com/OAI/Overlay-Specification/blob/main/versions/1.0.0.md

  * Specific Markup language supported by OpenAPI in description fields:

     https://spec.commonmark.org/0.27/

* The basic framework for the eAKte-API-v2 will be Spring-Boot v4

* The Spring Boot server stubs will be generated from the OpenAPI specification. The specific generator used can be found in
  https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/java.md

* To verify that the designed API is easily understandable, practically usable and meets the standards and best practices of current client development (simplicity, robustness, etc.) we should implement and provide client libraries. Suggested manifestations: Java (preferably Spring Boot Starter), JavaScript/TypeScript, maybe Python.

* The provided client libraries should be accompanied by some examples and a "getting started" documentation, thus providing a good starting point for newcomers to create new connectivity to the eAkte system. We should be aware that there is a whole spectrum of API users with different focus:
  * manufactururs and external service providers who create and/or sell "Fachverfahren"
  * it@M-internal service owners who need to implement EAI adapters and need to operate and monitor them as well as the connected Fachverfahren
  * it@M software implementers who need to connect to the eAkte (Input management, KOI, internally implemented Fachverfahren)
  * implementers of batch tools (e.g. for import of documents)
  * light-weight Fachverfahren: using the REST API a simple Web page or Single Page Application ("SPA") page can already implement a valuable interactive business support tool without the need to contract expensive external service providers.

* The api endpoints should be prefixed with '/api'. Though there are recommendations to not do this (e.g. because all endpoints are part of the api), it seems comfortable and intuitive to do this for the following reasons:
  * there are resources that are human readable and should be accessed without certain privileges (Swagger-UI, monitoring endpoints). These can reside outside of the '/api' path.
  * it is easy to specify security constraints and request filtering for the api itself as it is all beneath this specific prefix.
  * in an upstream service (e.g. SPA with Web-UI) it is easy to define '/api' as a proxy path that is forwarded to the eAkte API downstream, thus using only a single endpoint in the browser and avoiding fiddling with CORS issues.

* The query specification should be included in a single query parameter, as it can be a considerably complex arithmetic expression and is in text form.

* The query parameter value needs to be encoded with the UUEncode standard. This unfortunately makes the URLs much harder to read, but cannot be avoided because the query language and the restriction values respectively can contain reserved character that mey not be used on a URL unescaped. With the freely available linux tool 'uuencode' this can be mitigated in the practical development work.

## Examples for the suggested Query API

Based on the preliminary assumption that the Fabasoft Query Language WHERE clause is used as a syntax to define query restriction in the API, here a few examples how the URLs for such queries might look. 

It is additionally assumed, that the labels of the attributes are used as identifiers as to avoid the cryptic internal names of the Fabasoft eGov-Suite. It still needs to be investigated whether this can lead to ambiguities. Identical names should be avoided anyway, as those ambiguities would also lead to confusion in the maintenance of the DfV attributes in the Fabasoft Web interface. Coordination with the Workstream "Produkt" should be conducted as the introduction of DfV attributes is not only a interface topic but has a wider scope of documentation, consultancy and implementation procedures.

### Search for all files ("Akten")

No condition given, the collection resource of files (Akten) retrieves just all files, limited by the inherent maximum size of the result set. Note that paging is generally not supported by Fabasoft (no OFFSET parameter, only LIMIT).

http://localhost:8080/api/v2/akten

### Search files by means of a DfV attribute:

The condition in clear text would be:

`${/api/v2/attribut-beschreibungen/lhmdfvpublic-fh_attr_auf_Formularebene}="Orangen"`

The resulting URL with the uuencoded query parameter is then:

http://localhost:8080/api/v2/akten?bedingungen=%24%7B%2FAttributbeschreibungen%2Flhmdfvpublic-fh_attr_auf_Formularebene%7D%3D%22Orangen%22

### inverted condition (files not matching a certain attribute value)

The condition in clear text would be:

`${/api/v2/attribut-beschreibungen/lhmdfvpublic-fh_attr_auf_Formularebene}!="Orangen"`

The resulting URL with the uuencoded query parameter is then:

http://localhost:8080/api/v2/akten?bedingungen=%24%7B%2FAttributbeschreibungen%2Flhmdfvpublic-fh_attr_auf_Formularebene%7D%21%3D%22Orangen%22

### empty result set - no file matches the condition

The condition in clear text would be:

`${/api/v2/attribut-beschreibungen/lhmdfvpublic-fh_attr_auf_Formularebene}="Apfel"`

The resulting URL with the uuencoded query parameter is then:

http://localhost:8080/Akten?bedingungen=%24%7B%2FAttributbeschreibungen%2Flhmdfvpublic-fh_attr_auf_Formularebene%7D%3D%22Orange%22

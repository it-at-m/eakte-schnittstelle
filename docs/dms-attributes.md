# DMS Attributes

In the following the attributes of the different resources in the DMS are described.
For each attribute the reference/key in the Fabasoft system, the german label in the UI, the property name in the V1 API
and the property name in the V2 API is given.

## Aktenplaneintrag/Betreffseinheit (SubjectArea)

| Reference                                 | Label                             | V1  | V1                    | V2  |
| ----------------------------------------- | --------------------------------- | --- | --------------------- | --- |
| ELAKGGOV@1.1001:apentry                   | (übergeordneter Aktenplaneintrag) | W   | objaddress            |     |
| COOELAK@1.1001:basenr                     | Aktenplankennzeichen              | W   | basenr                |     |
| DEPRECONFIG@15.1001:subjareaspecreference | Ableitung                         | W   | subjareaspecreference |     |
| COOELAK@1.1001:shortterm                  | Kurzbezeichnung                   | W   | shortterm             |     |
| ELAKGOV@1.1001:subjarchiveschedule        | Transferfrist                     | W   | subjarchiveschedule   |     |
| ELAKGOV@1.1001:subjschedule               | Aufbewahrungsfrist                | W   | subjschedule          |     |
| ELAKGOV@1.1001:subjdispstate              | Aussonderungsart                  | W   | subjdispstate         |     |
| COOELAK@1.1001:fileaccessdefinition       | Zugriffsdefinition für Akten      | W   | fileaccessdefinition  |     |

## Akte (File)

| Reference                                   | Label                           | V1  | V1              | V2                 |
| ------------------------------------------- | ------------------------------- | --- | --------------- | ------------------ |
| ELAKGGOV@1.1001:apentry                     | Aktenplaneintrag                | RW  | apentry         |                    |
| COOELAK@1.1001:objmlname.langstring         | Titel                           | RW  | shortname       | name               |
| COOSYSTEM@1.1:objname                       | Name (Übersicht)                | R   | objname         | langname           |
| COOELAK@1.1001:filesubj                     | Betreff                         | RW  | filesubj        | betreff            |
| FSCTERM@1.1001:objterms.name                | Schlagworte                     | RW  | objterms        | -                  |
| FSCFOLIO@1.1001:objaccdef.name              | Zugriffsdefinition              | RW  | accdef          | zugriffsdefinition |
| DEPRECONFIG@15.1001:fileruntimefrom         |                                 | RW  | fileruntimefrom | -                  |
| DEPRECONFIG@15.1001:fileruntimetill         |                                 | RW  | fileruntimetill | -                  |
| COOELAK@1.1001:fileouobj                    |                                 | RW  | fileouobj       |                    |
| CFGBAYERN@15.1400:procedureaccessdefinition | Zugriffsdefinition für Vorgänge | RW  | procedureaccdef |                    |
| COOEALK@1.1001:attachments                  | (untergeordnete Vorgänge)       | R   | giobjecttype    | -                  |
|                                             | Vorlage (DfV)                   | W   | definition      |                    |
|                                             | (DfV Daten)                     | W   | userformsdata   |                    |

## Vorgang (Procedure)

| Reference                           | Label                                            | V1   | V1              | V2                    |
| ----------------------------------- | ------------------------------------------------ | ---- | --------------- | --------------------- |
| COOELAK@1.1001:referrednumber       | Akte                                             | RW   | referrednumber  | sachakteId            |
| COOELAK@1.1001:objmlname.langstring | Titel                                            | RW   | shortname       | name                  |
| COOSYSTEM@1.1:objname               | Name (Übersicht)                                 | R    | objname         | langname              |
| COOELAK@1.1001:filesubj             | Betreff                                          | RW   | filesubj        | betreff               |
| FSCTERM@1.1001:objterms.name        | Schlagworte                                      | RW   | objterms        | -                     |
| DEPRECONFIG@15.1001:fileruntimefrom |                                                  | RW   | fileruntimefrom | -                     |
| DEPRECONFIG@15.1001:fileruntimetill |                                                  | RW   | fileruntimetill | -                     |
| COOELAK@1.1001:inchargeremark       | Geschäftsgangvermerk für Prozessverantwortlichen | RW   | procremark      | geschaeftsgangvermerk |
| COOELAK@1.1001:filetype             | Original                                         | RW   | filetype        | originalMedium        |
| FSCFOLIO@1.1001:objdocstate         | Status                                           | R    | objdocstate     | status                |
| FSCFOLIO@1.1001:bostate.name        | Bearbeitungsstatus                               | R    | bostate         | bearbeitungsstatus    |
| FSCFOLIO@1.1001:objaccdef.name      | Zugriffsdefinition                               | RW   | accdef          | zugriffsdefinition    |
| COOSYSTEM@1.1:objowngroup.name      | Organisationseinheit                             | R    | objowngroup     | organisationseinheit  |
| COOEALK@1.1001:attachments          | (untergeordnete Dokumente)                       | R(W) | giobjecttype    | -                     |
|                                     | Vorlage (DfV)                                    | W    | definition      |                       |
|                                     | (DfV Daten)                                      | W    | userformsdata   |                       |

## Dokument (Incoming / Outgoing / Internal)

| Reference                                            | Label                                | V1   | V1             | V2                 |
| ---------------------------------------------------- | ------------------------------------ | ---- | -------------- | ------------------ |
| COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:fullreference   | Objektklasse                         | R    |                | klasse             |
| COOELAK@1.1001:referrednumber                        | Vorgang                              | RW   | referrednumber | parent.id          |
| COOELAK@1.1001:referrednumber.objclass.fullreference | Vorgang                              | R    | -              | parent.type        |
| COOELAK@1.1001:objmlname.langstring                  | Titel                                | RW   | shortname      | name               |
| COOSYSTEM@1.1:objname                                | Name (Übersicht)                     | R    | objname        | langname           |
| COOELAK@1.1001:filesubj                              | Betreff                              | RW   | filesubj       | betreff            |
| FSCTERM@1.1001:objterms.name                         | Schlagworte                          | RW   | objterms       | -                  |
| FSCFOLIO@1.1001:objaccdef.name                       | Zugriffsdefinition                   | RW   | accdef         | zugriffsdefinition |
| COOEALK@1.1001:attachments                           | (untergeordnete Schriftstücke)       | R(W) | gimetadatatype | -                  |
| COOELAK@1.1001:incattachments                        | Alternative Beschreibung der Anlagen | RW   | incattachments | `<TODO>`           |
|                                                      | Vorlage (DfV)                        | W    | definition     |                    |
|                                                      | (DfV Daten)                          | W    | userformsdata  |                    |

[//]: # "TODO incattachments only on Erledigung/Intern?"

### Eingang (Incoming)

| Reference                                 | Label                    | V1  | V1              | V2  |
| ----------------------------------------- | ------------------------ | --- | --------------- | --- |
| COOELAK@1.1001:foreignnr                  | Fremdes Geschäftszeichen | RW  | foreignnr       |     |
| COOELAK@1.1001:delivery                   | Datum                    | RW  | delivery        |     |
| DEPRECONFIG@15.1001:fileaddsubj           | Hinweis                  | RW  | documentremarks |     |
| COOELAK@1.1001:incharge.COOWF@1.1:wfpuser |                          | W   | useou           |     |

### Erledigung / Ausgang (Outgoing)

| Reference                          | Label                     | V1  | V1               | V2  |
| ---------------------------------- | ------------------------- | --- | ---------------- | --- |
| CFGBAYERN@15.1400:referredincoming | Bezug zu Eingangsdokument | RW  | referredincoming |     |
| COOELAK@1.1001:subfiletype         | Dokumententyp             | RW  | subfiletype      |     |
|                                    |                           | -   | searchalso       | -   |
|                                    |                           | -   | businessapp      | -   |
|                                    |                           | W   | doctemplate      |     |

[//]: # "TODO doctemplate only on Intern?"

### Intern (Internal)

| Reference                  | Label       | V1  | V1           | V2  |
| -------------------------- | ----------- | --- | ------------ | --- |
| COOELAK@1.1001:delivery    | Datum       | RW  | deliverydate |     |
| COOELAK@1.1001:subfiletype | Dokumenttyp | RW  | subfiletype  |     |
| COOELAK@1.1001:doctemplate | Vorlage     | W   | doctemplate  |     |

## Schriftstück (ContentObject)

| Reference                           |     | Label                | V1             | V2         |
| ----------------------------------- | --- | -------------------- | -------------- | ---------- |
| COOELAK@1.1001:referrednumber       | RW  | Dokument             | referrednumber | dokumentId |
| COOSYSTEM@1.1:objname               | RW  | Name                 | fileName       | name       |
| COOSYSTEM@1.1:content.contextension | R   | Datei -> Dateiendung | fileExtention  |            |
| COOSYSTEM@1.1:content.contcontent   | RW  | Datei -> Inhalt      | fileContent    |            |
| COOSYSTEM@1.1:content.contsize      | R   | Datei -> Größe       | fileContsize   |            |
| COOELAK@1.1001:filesubj             | RW  | Betreff              | filesubj       | betreff    |

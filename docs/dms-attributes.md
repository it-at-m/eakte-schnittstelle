# DMS Attributes

In the following the attributes of the different resources in the DMS are described.
For each attribute the reference/key in the Fabasoft system, the german label in the UI, the property name in the V1 API
and the property name in the V2 API is given.

## Vorgang

| Reference                           | Label                                            | V1              | V2                    |
| ----------------------------------- | ------------------------------------------------ | --------------- | --------------------- |
| COOELAK@1.1001:referrednumber       | Akte                                             | referrednumber  | sachakteId            |
| COOELAK@1.1001:objmlname.langstring | Titel                                            | shortname       | name                  |
|                                     | Name (Übersicht)                                 | objname         | langname              |
| COOELAK@1.1001:filesubj             | Betreff                                          | filesubj        | betreff               |
| FSCTERM@1.1001:objterms.name        | Schlagworte                                      | objterms        | -                     |
| DEPRECONFIG@15.1001:fileruntimefrom |                                                  | fileruntimefrom | -                     |
| DEPRECONFIG@15.1001:fileruntimetill |                                                  | fileruntimetill | -                     |
| COOELAK@1.1001:inchargeremark       | Geschäftsgangvermerk für Prozessverantwortlichen | procremark      | geschaeftsgangvermerk |
| COOELAK@1.1001:filetype             | Original                                         | filetype        | originalMedium        |
| FSCFOLIO@1.1001:objdocstate         | Status                                           | objdocstate     | status                |
| FSCFOLIO@1.1001:bostate.name        | Bearbeitungsstatus                               | bostate         | bearbeitungsstatus    |
| FSCFOLIO@1.1001:objaccdef.name      | Zugriffsdefinition                               | accdef          | zugriffsdefinition    |
| COOSYSTEM@1.1:objowngroup.name      | Organisationseinheit                             | objowngroup     | organisationseinheit  |
| COOEALK@1.1001:attachments          | (untergeordnete Dokumente)                       | giobjecttype    | -                     |

## Dokument

| Reference                                            | Label                                | V1             | V2                 |
| ---------------------------------------------------- | ------------------------------------ | -------------- | ------------------ |
| COOSYSTEM@1.1:objclass.COOSYSTEM@1.1:fullreference   | Objektklasse                         |                | klasse             |
| COOELAK@1.1001:referrednumber                        | Vorgang                              | referrednumber | parent.id          |
| COOELAK@1.1001:referrednumber.objclass.fullreference | Vorgang                              | -              | parent.type        |
| COOELAK@1.1001:objmlname.langstring                  | Titel                                | shortname      | name               |
|                                                      | Name (Übersicht)                     | objname        | langname           |
| COOELAK@1.1001:filesubj                              | Betreff                              | filesubj       | betreff            |
| FSCTERM@1.1001:objterms.name                         | Schlagworte                          | objterms       | -                  |
| FSCFOLIO@1.1001:objaccdef.name                       | Zugriffsdefinition                   | accdef         | zugriffsdefinition |
| COOEALK@1.1001:attachments                           | (untergeordnete Schriftstücke)       | gimetadatatype | -                  |
| COOELAK@1.1001:incattachments                        | Alternative Beschreibung der Anlagen | incattachments | <TODO>             |

### Eingang

| Reference                       | Label                    | V1              | V2  |
| ------------------------------- | ------------------------ | --------------- | --- |
| COOELAK@1.1001:foreignnr        | Fremdes Geschäftszeichen | foreignnr       |     |
| COOELAK@1.1001:delivery         | Datum                    | delivery        |     |
| DEPRECONFIG@15.1001:fileaddsubj | Hinweis                  | documentremarks |     |

### Erledigung / Ausgang

| Reference                          | Label                     | V1               | V2  |
| ---------------------------------- | ------------------------- | ---------------- | --- |
| CFGBAYERN@15.1400:referredincoming | Bezug zu Eingangsdokument | referredincoming |     |
| COOELAK@1.1001:subfiletype         | Dokumententyp             | subfiletype      |     |
|                                    |                           | searchalso       | -   |
|                                    |                           | businessapp      | -   |

### Internal

| Reference                  | Label       | V1           | V2  |
| -------------------------- | ----------- | ------------ | --- |
| COOELAK@1.1001:delivery    | Datum       | deliverydate |     |
| COOELAK@1.1001:subfiletype | Dokumenttyp | subfiletype  |     |

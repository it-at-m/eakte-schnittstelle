package de.muenchen.oss.eakte.api.v2.gateway.e2e;

public class AkteE2eSupport extends FabasoftE2eSupport {

    protected void stubAktenplanAkteResponse() {
        stubSearchRequestContaining(".ELAKGGOV@1.1001:apentry", akteResponse());
    }

    private String akteResponse() {
        return soapEnvelope("""
                <urn:SOAPSearchResponse>
                  <urn:queryresult>
                    <urn:object>
                      <urn:objname>name</urn:objname>
                      <urn:objaddress>COO.1.2.3</urn:objaddress>
                      <urn:attrlist>
                        <urn:OBJECT urn:reference="ELAKGGOV@1.1001:apentry" urn:index="1">subjectArea-id</urn:OBJECT>
                        <urn:STRING urn:reference="COOELAK@1.1001:objmlname.langstring" urn:index="1">titel</urn:STRING>
                        <urn:STRING urn:reference="COOELAK@1.1001:filesubj" urn:index="1">subject</urn:STRING>
                        <urn:STRING urn:reference="FSCFOLIO@1.1001:objaccdef.name" urn:index="1">acl</urn:STRING>
                        <urn:STRING urn:reference="CFGBAYERN@15.1400:procedureaccessdefinition" urn:index="1">acl-procedure</urn:STRING>
                        <urn:STRING urn:reference="custom.attribute" urn:index="1">custom-value</urn:STRING>
                      </urn:attrlist>
                    </urn:object>
                  </urn:queryresult>
                </urn:SOAPSearchResponse>
                """);
    }

}

package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinition;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPBinding;
import java.util.Map;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FabasoftConfiguration {

    @Bean
    public FSCGOVXML11001DefaultWebServiceDefinition getSoapService() {
        return new FSCGOVXML11001DefaultWebServiceDefinition();
    }

    @Bean
    public FSCGOVXML11001DefaultWebServiceDefinitionSoap getSoapClient(final FSCGOVXML11001DefaultWebServiceDefinition service,
            final FabasoftProperties fabasoftProperties) {
        final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient = service.getFSCGOVXML11001DefaultWebServiceDefinitionSoap();

        final BindingProvider bp = (BindingProvider) soapClient;
        final Map<String, Object> ctx = bp.getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, fabasoftProperties.getUrl());
        ctx.put(BindingProvider.USERNAME_PROPERTY, fabasoftProperties.getUsername());
        ctx.put(BindingProvider.PASSWORD_PROPERTY, fabasoftProperties.getPassword());
        // enable MTOM
        final SOAPBinding binding = (SOAPBinding) ((BindingProvider) soapClient).getBinding();
        binding.setMTOMEnabled(true);
        // configure http client
        @SuppressWarnings("PMD.CloseResource")
        final Client client = ClientProxy.getClient(soapClient);
        final HTTPConduit conduit = (HTTPConduit) client.getConduit();
        final HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(fabasoftProperties.getConnectTimeout().toMillis());
        policy.setReceiveTimeout(fabasoftProperties.getReadTimeout().toMillis());
        conduit.setClient(policy);

        return soapClient;
    }
}

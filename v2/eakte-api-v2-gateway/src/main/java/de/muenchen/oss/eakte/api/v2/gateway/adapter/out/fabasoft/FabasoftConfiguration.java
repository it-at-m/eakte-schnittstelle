package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinition;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
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
            final FabasoftProperties fabasoftProperties,
            final RequestContextInjectInterceptor contextInterceptor) {
        final FSCGOVXML11001DefaultWebServiceDefinitionSoap soapClient = service.getFSCGOVXML11001DefaultWebServiceDefinitionSoap();

        final BindingProvider bp = (BindingProvider) soapClient;
        final Map<String, Object> ctx = bp.getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, fabasoftProperties.getUrl());
        @SuppressWarnings("PMD.CloseResource")
        final Client client = ClientProxy.getClient(soapClient);
        final HTTPConduit conduit = (HTTPConduit) client.getConduit();
        // enable MTOM
        final SOAPBinding binding = (SOAPBinding) ((BindingProvider) soapClient).getBinding();
        binding.setMTOMEnabled(true);
        // configure timeouts
        final HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(fabasoftProperties.getConnectTimeout().toMillis());
        policy.setReceiveTimeout(fabasoftProperties.getReadTimeout().toMillis());
        conduit.setClient(policy);
        // configure mtls
        conduit.setTlsClientParameters(this.buildTlsClientParams(fabasoftProperties));
        // add context interceptor
        client.getOutInterceptors().add(contextInterceptor);

        return soapClient;
    }

    private TLSClientParameters buildTlsClientParams(final FabasoftProperties fabasoftProperties) {
        final TLSClientParameters tlsParams = new TLSClientParameters();
        try {
            final KeyStore keyStore = KeyStore.getInstance("PKCS12");
            try (InputStream is = fabasoftProperties.getKeystoreLocation().getInputStream()) {
                keyStore.load(is, fabasoftProperties.getKeystorePassword().toCharArray());
            }
            final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, fabasoftProperties.getKeystorePassword().toCharArray());
            tlsParams.setKeyManagers(kmf.getKeyManagers());
            return tlsParams;
        } catch (final KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException e) {
            throw new RuntimeException("Error while loading mTLS client keystore", e);
        }
    }
}

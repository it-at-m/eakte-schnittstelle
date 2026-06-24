package de.muenchen.itm.eakte.schnittstelle.adapters.out.eakte_soap_client;

import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinition;
import com.fabasoft.schemas.websvc.fscgovxml_1_1001_defaultwebservicedefinition.FSCGOVXML11001DefaultWebServiceDefinitionSoap;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPBinding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Proxy Pool fuer Apache CXF eGov SOAP Clients
 *
 */
@Service
@Slf4j
public class EgovClientProxyPool {

  @Value("${eakte-connection-parameter.eGovServiceAddress}")
  private String eGovServiceAddress;

  @Value("${eakte-connection-parameter.eGovServicePath}")
  private String eGovServicePath;

  private int connectionTimeout = 3600;
  private int receiveTimeout = 3600;
  private Boolean proxyEnabled = false;
  private String proxyServer = "";
  private String proxyPort = "";

  private Bus bus = null;

  public String getWsdlUrl() {
    return eGovServiceAddress + eGovServicePath;
  }

  public FSCGOVXML11001DefaultWebServiceDefinitionSoap getSoapClient(String username, String password) {
    FSCGOVXML11001DefaultWebServiceDefinition service = new FSCGOVXML11001DefaultWebServiceDefinition();
    FSCGOVXML11001DefaultWebServiceDefinitionSoap port = service.getFSCGOVXML11001DefaultWebServiceDefinitionSoap();

    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, getWsdlUrl());
    ctx.put(BindingProvider.USERNAME_PROPERTY, username);
    ctx.put(BindingProvider.PASSWORD_PROPERTY, password);

    Client client = ClientProxy.getClient(port);
    HTTPConduit conduit = (HTTPConduit) client.getConduit();

    HTTPClientPolicy policy = new HTTPClientPolicy();
    policy.setConnectionTimeout(10_000);
    policy.setReceiveTimeout(30_000);
    conduit.setClient(policy);

    return port;
  }

  /**
   * Liefert für den eGovUser den entsprechenden EGovClientProxy zurück.
   *
   * @return FSCGOVXML11001DefaultWebServiceDefinitionSoap
   */
  public FSCGOVXML11001DefaultWebServiceDefinitionSoap getProxy(String username, String password) {
    Class<FSCGOVXML11001DefaultWebServiceDefinitionSoap> type = FSCGOVXML11001DefaultWebServiceDefinitionSoap.class;
    JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
    jaxWsProxyFactoryBean.setServiceClass(type);

    jaxWsProxyFactoryBean.setAddress(getWsdlUrl());
    jaxWsProxyFactoryBean.setUsername(username);
    jaxWsProxyFactoryBean.setPassword(password);

    //  max text length wird fuer base64 encoded schriftstuecke gebracht
    Map<String, Object> properties = jaxWsProxyFactoryBean.getProperties();
    if (properties == null) {
      properties = new HashMap<>();
    }
    properties.put("org.apache.cxf.stax.maxTextLength", "2147483647");
    properties.put("set-jaxb-validation-event-handler", "false");
    jaxWsProxyFactoryBean.setProperties(properties);

    jaxWsProxyFactoryBean.getFeatures().add(new LoggingFeature());

    //jaxWsProxyFactoryBean.setBus(bus());

    FSCGOVXML11001DefaultWebServiceDefinitionSoap proxyFactoryBean = type.cast(jaxWsProxyFactoryBean.create());

    BindingProvider bp = (BindingProvider) proxyFactoryBean;

    bp.getRequestContext().put("thread.local.request.context", "true");

    SOAPBinding binding = (SOAPBinding) bp.getBinding();
    binding.setMTOMEnabled(false);

    // setting client timeouts
    Client client = ClientProxy.getClient(proxyFactoryBean);
    if (client != null) {
      client.getOutInterceptors().add(new LoggingOutInterceptor());
      client.getInInterceptors().add(new LoggingInInterceptor());

      HTTPConduit conduit = (HTTPConduit) client.getConduit();
      HTTPClientPolicy policy = new HTTPClientPolicy();

      log.debug("set connection timeout to {}", connectionTimeout * 1000);
      policy.setConnectionTimeout(connectionTimeout * 1000L);

      log.debug("set receive timeout to {}", receiveTimeout * 1000);
      policy.setReceiveTimeout(receiveTimeout * 1000L);

      conduit.setClient(policy);
      if (proxyEnabled) {
        conduit.getClient().setProxyServer(proxyServer);
        conduit.getClient().setProxyServerPort(Integer.valueOf(proxyPort));
      }
    }
    //client.getOutInterceptors().add(new CxfMTOMOutInterceptor());
    return proxyFactoryBean;
  }

}

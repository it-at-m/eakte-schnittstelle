package de.muenchen.itm.eakte.schnittstelle;

import de.muenchen.itm.eakte.schnittstelle.config.PredefinedAppDataConfig;
import de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.logging.EndpointDescriptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@SpringBootApplication(scanBasePackages = {"de.muenchen.itm.eakte.schnittstelle"})
@EnableConfigurationProperties(PredefinedAppDataConfig.class)
@Slf4j
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

  @EventListener
  public void handleContextRefresh(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();
    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
      .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
    Map<RequestMappingInfo, HandlerMethod> springEndPointMap = requestMappingHandlerMapping
      .getHandlerMethods();
    log.trace("------- endpoints detected: -------");
    springEndPointMap.entrySet().stream()
      .map(e -> new EndpointDescriptor(e.getKey(), e.getValue()))
      .sorted()
      .forEach(EndpointDescriptor::logToInfo);
  }
}


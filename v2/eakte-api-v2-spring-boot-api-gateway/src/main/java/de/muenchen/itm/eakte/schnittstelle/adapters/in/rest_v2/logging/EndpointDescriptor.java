package de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.logging;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class EndpointDescriptor
  implements Comparable<EndpointDescriptor> {

  private final String fullInfo;
  private final String requestPath;
  private final String httpMethod;
  private final String contentTypeServed;
  private final String controllerMethod;

  public EndpointDescriptor(RequestMappingInfo rmi, HandlerMethod handlerMethod) {
    this.fullInfo = rmi.toString();
    this.requestPath = Optional.ofNullable(rmi.getPathPatternsCondition())
      .map(PathPatternsRequestCondition::getPatterns)
      .flatMap(x -> x.stream().findFirst())
      .map(Object::toString)
      .orElse("");
    this.httpMethod = rmi.getMethodsCondition().getMethods().stream().map(x -> x.asHttpMethod().name()).findFirst().orElse("");
    this.contentTypeServed = rmi.getProducesCondition().getProducibleMediaTypes().stream().map(Object::toString).collect(Collectors.joining("|"));
    this.controllerMethod = handlerMethod.toString();
  }

  public void logToInfo() {
    log.trace(this.toString());
  }

  @Override
  public @NonNull String toString() {
    return String.format("%-35s %-4s %-30s: %s", requestPath, httpMethod, contentTypeServed, controllerMethod);
  }

  @Override
  public int compareTo(@NonNull EndpointDescriptor o) {
    return Comparator
      .comparing((EndpointDescriptor epd) -> epd.requestPath)
      .thenComparing(epd -> epd.httpMethod)
      .thenComparing(epd -> epd.controllerMethod)
      .compare(this, o);
  }
}

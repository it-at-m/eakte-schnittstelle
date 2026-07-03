package de.muenchen.dms.common.processor;

import de.muenchen.dms.common.route.QueryProperties;
import de.muenchen.dms.common.route.RouteConstants;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

@Slf4j
@RequiredArgsConstructor
public class PayloadLogger implements Processor {
  private final String type;

  public void process(Exchange exchange) throws Exception {
    if (RouteConstants.REQ_IN.equals(type)) {
      logRequest(exchange);
    } else if (RouteConstants.REQ_OUT.equals(type)) {
      logHeaders(exchange);
      logBody(exchange);
    } else if (RouteConstants.RESP_IN.equals(type)) {
      logHeaders(exchange);
      logHTTPStatusCode(exchange);
      logBody(exchange);
    }
  }

  private void logRequest(final Exchange exchange) {
    try {
      // request
      final String camelUri = exchange.getIn().getHeader("CamelServletContextPath", String.class);
      final String uriString = exchange.getIn().getHeader(Exchange.HTTP_URI, String.class);
      final URI uri = new URI(uriString);
      final String method = exchange.getIn().getHeader(Exchange.HTTP_METHOD, String.class);
      final List<String> params = getParamsFromQuery(uri.getQuery());
      final Object body = exchange.getIn().getBody();
      final List<String> bodyFields = getKeysFromPojo(body);
      // auth
      final String authUser = exchange.getProperty("AuthenticatedUser", String.class);
      // request context
      final String application =
          exchange.getProperty(QueryProperties.PROPERTY_ANWENDUNG, String.class);
      final String userlogin = exchange.getProperty(QueryProperties.PROPERTY_NUTZER, String.class);
      final String jobOe =
          exchange.getProperty(QueryProperties.PROPERTY_ORGANISATIONSEINHEIT, String.class);
      final String jobPosition = exchange.getProperty(QueryProperties.PROPERTY_ROLLE, String.class);
      log.atInfo()
          .addKeyValue("method", method)
          .addKeyValue("uri", camelUri)
          .addKeyValue("params", params)
          .addKeyValue("bodyFields", bodyFields)
          .addKeyValue("authUser", authUser)
          .addKeyValue("application", application)
          .addKeyValue("userlogin", userlogin)
          .addKeyValue("jobOe", jobOe)
          .addKeyValue("jobPosition", jobPosition)
          .log();
    } catch (final RuntimeException | URISyntaxException e) {
      log.error("Error while logging request");
    }
  }

  private List<String> getParamsFromQuery(final String query) {
    if (query == null) {
      return Collections.emptyList();
    }
    return Arrays.stream(query.split("&"))
        .map(param -> param.split("=", 2))
        .map(i -> URLDecoder.decode(i[0], StandardCharsets.US_ASCII))
        .toList();
  }

  private void logHTTPStatusCode(Exchange exchange) {
    Integer httpResponseCode =
        exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);

    if (httpResponseCode != null) {
      log.info("httpStatus: {}", httpResponseCode);
    } else {
      log.info("No httpStatus");
    }
  }

  private void logHeaders(Exchange exchange) {
    Map<String, Object> headers = exchange.getMessage().getHeaders();
    if (headers != null) {
      if (RouteConstants.REQ_OUT.equals(type)) {
        log.info("REQ_OUT: ");
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
          log.info("{}: {}", entry.getKey(), entry.getValue());
        }
        logUsernameFromAuthHeader(exchange);
      } else if (RouteConstants.RESP_IN.equals(type)) {
        log.info("RESP_IN: ");
        Object object = headers.get("operationName");
        if (object != null) {
          log.info("operationName: {}", object);
        }
      }
    } else {
      log.info("No headers found");
    }
  }

  private void logUsernameFromAuthHeader(Exchange exchange) {

    String username = exchange.getProperty("AuthenticatedUser", String.class);

    if (username != null) {
      log.info("SST-Username: {}", username);
    } else {
      log.info("No authentication found");
    }
  }

  private void logBody(Exchange exchange) {
    Object body = exchange.getIn().getBody();
    if (RouteConstants.REQ_OUT.equals(type)) {
      logAllFromPojo(body);
    } else if (RouteConstants.RESP_IN.equals(type)) {
      logMessageContentsList((MessageContentsList) body);
    }
  }

  private void logAllFromPojo(Object pojo) {
    Class<?> clazz = pojo.getClass();
    Field[] fields = clazz.getDeclaredFields();

    Integer statusValue = null;

    try {
      for (Field field : fields) {
        if ("status".equals(field.getName())) {
          field.setAccessible(true);
          Object value = field.get(pojo);
          if (value instanceof Integer sv) {
            statusValue = sv;
          }
          break;
        }
      }

      boolean statusNotZero = statusValue != null && statusValue != 0;

      for (Field field : fields) {
        field.setAccessible(true);
        Object value = field.get(pojo);
        if (value == null) {
          continue;
        }

        String fieldName = field.getName().toLowerCase();

        if (statusNotZero) {
          log.error("{}: {}", field.getName(), value);
        } else {
          if ("status".equalsIgnoreCase(fieldName) || "userlogin".equalsIgnoreCase(fieldName)) {
            log.info("{}: {}", field.getName(), value);
          }
        }
      }
    } catch (IllegalAccessException e) {
      log.trace("Zugriff nicht möglich");
    }
  }

  private List<String> getKeysFromPojo(final Object object) {
    if (object == null) {
      return Collections.emptyList();
    }
    return Arrays.stream(object.getClass().getDeclaredFields())
        .map(
            field -> {
              field.setAccessible(true);
              try {
                if (field.get(object) != null) {
                  return field.getName();
                }
              } catch (IllegalAccessException ignored) {
              }
              return null;
            })
        .filter(Objects::nonNull)
        .toList();
  }

  private void logMessageContentsList(MessageContentsList messageContentsList) {
    for (Object element : messageContentsList) {
      if (element != null) {
        logAllFromPojo(element);
      } else {
        log.trace("Element is null");
      }
    }
  }
}

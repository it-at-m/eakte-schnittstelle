package de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.requestfilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

public class RequestLoggingFilter implements Filter {

  Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName());

  private String extractAuthInfo(String authHeader) {
    int index1 = authHeader.indexOf(" ");
    if (index1 != -1) {
      String authType = authHeader.substring(0, index1);
      if ("Basic".equals(authType)) {
        String authInfo = new String(Base64.getDecoder().decode(authHeader.substring(index1 + 1)));
        int index2 = authInfo.indexOf(":");
        if (index2 != -1) {
          String username = authInfo.substring(0, index2);
          return "Basic {username: \"" + username + "\"}";
        } else {
          return authType;
        }
      } else if ("Bearer".equals(authHeader)) {
        return "Bearer";
      } else {
        return "Unknown Auth type \"" + authType + "\"";
      }
    } else {
      return "Authorization header is corrupted.";
    }
  }
  @Override
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
    throws IOException, jakarta.servlet.ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    String auth = req.getHeader("Authorization");
    logger.info(
      "[REQUEST] " +
        req.getMethod() + " " +
        req.getRequestURI() + " " +
        //req.getQueryString() + " " +
        "| Auth=" + (auth != null ? extractAuthInfo(auth) : "none")
    );
    chain.doFilter(request, response);
    HttpServletResponse resp = (HttpServletResponse) response;
    logger.info(
      "[RESPONSE] " +
        resp.getStatus() + " " +
        resp.getContentType() + " " +
        resp.getHeader("Content-Length")
    );
  }
}

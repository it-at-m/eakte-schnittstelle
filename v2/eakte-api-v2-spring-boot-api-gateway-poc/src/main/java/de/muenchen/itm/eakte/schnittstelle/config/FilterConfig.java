package de.muenchen.itm.eakte.schnittstelle.config;

import de.muenchen.itm.eakte.schnittstelle.adapters.in.rest_v2.requestfilter.RequestLoggingFilter;
import lombok.NonNull;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<@NonNull RequestLoggingFilter> loggingFilter() {
    FilterRegistrationBean<@NonNull RequestLoggingFilter> reg = new FilterRegistrationBean<>();
    reg.setFilter(new RequestLoggingFilter());
    reg.setOrder(Ordered.HIGHEST_PRECEDENCE); // 👈 VERY IMPORTANT (before Spring Security)
    reg.addUrlPatterns("/*");
    return reg;
  }
}
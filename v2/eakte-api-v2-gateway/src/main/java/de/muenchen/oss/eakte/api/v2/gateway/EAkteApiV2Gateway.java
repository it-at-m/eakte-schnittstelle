package de.muenchen.oss.eakte.api.v2.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Application class for starting the microservice.
 */
@SpringBootApplication
@ConfigurationPropertiesScan
@SuppressWarnings("PMD.UseUtilityClass")
public class EAkteApiV2Gateway {
    public static void main(final String[] args) {
        SpringApplication.run(EAkteApiV2Gateway.class, args);
    }
}

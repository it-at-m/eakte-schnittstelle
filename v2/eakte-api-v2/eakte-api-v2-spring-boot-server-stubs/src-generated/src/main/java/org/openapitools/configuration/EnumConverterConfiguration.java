package org.openapitools.configuration;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.AttributDatenTyp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * This class provides Spring Converter beans for the enum models in the OpenAPI specification.
 *
 * By default, Spring only converts primitive types to enums using Enum::valueOf, which can prevent
 * correct conversion if the OpenAPI specification is using an `enumPropertyNaming` other than
 * `original` or the specification has an integer enum.
 */
@Configuration(value = "org.openapitools.configuration.enumConverterConfiguration")
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.attributDatenTypConverter")
    Converter<String, AttributDatenTyp> attributDatenTypConverter() {
        return new Converter<String, AttributDatenTyp>() {
            @Override
            public AttributDatenTyp convert(String source) {
                return AttributDatenTyp.fromValue(source);
            }
        };
    }

}

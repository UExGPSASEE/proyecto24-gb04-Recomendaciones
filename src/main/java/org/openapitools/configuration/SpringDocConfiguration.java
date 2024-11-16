package org.openapitools.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("TubeFlix - Recomendaciones y Visualizaciones - OpenAPI 3.0")
                                .description("Microservicio de recomendaciones y visualizaciones para TubeFlix. Este servicio proporciona recomendaciones generales, personalizadas y un buscador de videos por título. ")
                                .version("1.0.0")
                )
        ;
    }
}
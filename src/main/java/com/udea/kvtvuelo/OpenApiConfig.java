package com.udea.kvtvuelo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customnOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de gestión de vuelos")
                        .version("1.0.0")
                        .description("Documentación de la API de vuelos para gestionar información de vuelos"));
    }
}

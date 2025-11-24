package com.duocuc.api.app.kotling.apuestas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Apuestas - Usuarios")
                        .description("Documentación de la API de gestión de usuarios en el sistema de apuestas.")
                        .version("1.0.0")
                );
    }
}

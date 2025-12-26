package com.backend.programski_jezici.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Programski jezici API")
                        .description("REST API for programming languages")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("David Kovčo")
                                .email("dk55038@fer.hr"))
                        .license(new License()
                                .name("GNU General Public License v3.0")
                                .url("https://www.gnu.org/licenses/gpl-3.0.html"))
                );
    }
}


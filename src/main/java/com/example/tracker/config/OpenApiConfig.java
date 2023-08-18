package com.example.tracker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Отслеживатель почтовых отправлений",
                description = "Отслеживатель почтовых отправлений", version = "1.0.0",
                contact = @Contact(
                        name = "Mikhail"
                )
        )
)
public class OpenApiConfig {
}

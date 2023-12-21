package com.example.shopeev1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "My API Product",
                version = "1.0.0",
                description = "Desicription of my Produtc API"
        ),
        servers = {
                @Server(url = " http://localhost:8080", description = "Local Development Server")
        }
)
@Configuration
public class OpenApiConfig {

}



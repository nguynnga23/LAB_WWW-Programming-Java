package com.example.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

public class OpenAPIConfiguration {
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:9998");
        server.setDescription("Employee Management REST API Documentation");
        Info information = new Info()
                .title("Employee Management REST API Documentation")
                .version("1.0")
                .description("This API exposes endpoints to manage employees.");
        return new OpenAPI().info(information).servers(List.of(server));
    }
}

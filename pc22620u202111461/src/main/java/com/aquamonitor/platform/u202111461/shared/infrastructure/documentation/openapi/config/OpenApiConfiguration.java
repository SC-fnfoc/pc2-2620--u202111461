package com.aquamonitor.platform.u202111461.shared.infrastructure.documentation.openapi.config;


import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration 
public class OpenApiConfiguration {
    @Bean
    public OpenAPI aquaMonitorOpenAPI() {
        return new OpenAPI().info(new Info ()
    .title("AquaMonitor Platform API")
.description("RESTfulAPI for managing water quality sampling plans")
.version("v1.0.0"));
    }
}

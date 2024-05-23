package com.claurier.habitat.souscription.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig
{

    @Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI().info(new Info().title("Mon Parcours API").version("1.0").description("Documentation de l'API Mon Parcours"));
    }

    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder().group("v1").pathsToMatch("/Produits/**").packagesToScan("com.claurier.monparcours.web").build();
    }
}

package com.hamitmizrak.innova_springboot.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerBean {

    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("Software Developer Muhammed Aksoy")
                .version("V1.0.0")
                //.summary(" for spring boot on react js, auth: "+hashCode())
               // .description("Spring Boot & Angular & Devops")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Muhammed Aksoy")
                        .email("muhammedaksoy577@gmail.com")
                        .url("https://github.com/aksoySoftware")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/aksoySoftware")
                )
        ); //end return new OpenAPI()
    } //end method
} //end class


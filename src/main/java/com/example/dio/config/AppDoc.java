package com.example.dio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class AppDoc {
    @Bean
    OpenAPI openAPI()
    {
        return new OpenAPI().info(info());
    }

    private  Info info() {
        return new Info()
                .title("Dine In Order Api")
                .description("""
                        ## Description
                        **Dine in order** is an api is built using spring boot under Rest Architecture.
                        The api is designed to serve as a backend to a application that deals with in ordering food online.
                        
                        ## Tech-Stack
                        
                        -java 8
                        
                        -Spring Boot
                        
                        -Spring Data JPa
                        
                        -mysql workbench
                        
                        -Spring Security
                        
                        """).version("v1")
                .contact(contact());
    }

        private Contact contact()
        {
          return  new Contact().email("vish@gmail.com")
                    .name("vish")
                    .url("https://google.com");

        }
        }




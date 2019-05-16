package com.diego.reto.proyectoreto.config;

import com.diego.reto.proyectoreto.controller.FamiliesController;
import com.diego.reto.proyectoreto.controller.FamilyMembersController;
import com.diego.reto.proyectoreto.controller.ParentsController;
import com.diego.reto.proyectoreto.controller.StudentsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jcumpale on 16/05/2019.
 */
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = ParentsController.class)
@ComponentScan(basePackageClasses = FamilyMembersController.class)
@ComponentScan(basePackageClasses = FamiliesController.class)
@ComponentScan(basePackageClasses = StudentsController.class)
@Configuration
public class SwaggerConfig   {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "License";
    private static final String tittle = "Reto Api";
    private static final String description = "Microservicio Rest para Reto";

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(tittle)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket testAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/ProyectoReto.*"))
                .build();
    }

}

package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger: librería para la generación de la documentación de la API REST
 * 
 * http://localhost:8080/swagger-ui/ --> HTML
 * http://localhost:8080/v2/api-docs -- JSON
 */
@Configuration // anotacion para todas las clases spring de configuracion
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean // permite que spring invoque este método para obtener un objeto que inyectar donde lo necesite
	public Docket swaggerConfiguration() {
		
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build().apiInfo(apiDetails());
	}
	

	private ApiInfo apiDetails() {

		return new ApiInfo("Awesome API REST", 
				"Pruebas Spring Boot API REST", 
				"1.0", 
				"http://localhost/terms", 
				new Contact("Prueba","Prueba","Prueba"),
				"Prueba",
				"Prueba",
				 Collections.emptyList());
	}
	
	

}

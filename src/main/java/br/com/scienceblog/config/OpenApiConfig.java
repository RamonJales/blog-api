package br.com.scienceblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Restful blog science API with Java 18 and Spring Boot 3")
						.version("v1")
						.description("A blog API with all resources needed to make a website.")
						.termsOfService("https://blog.science.com.br")
						.license(
							new License()
								.name("Apache 2.0")
								.url("https://blog.science.com.br")));
	}
}

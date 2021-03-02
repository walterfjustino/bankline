package com.bankline.bankline;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BanklineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanklineApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.swagger"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"API Bankline",
				"Gama Academy - Projeto final: API - Bankline",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Burndown Team", "https://xpcorp.gama.academy/", "teste@gmail.com"),
				"API License",
				"https://xpcorp.gama.academy/",
				Collections.emptyList());
	}
}
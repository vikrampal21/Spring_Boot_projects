package com.ty.employeeregister;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class Employeeregistration1Application {

	public static void main(String[] args) {
		SpringApplication.run(Employeeregistration1Application.class, args);
	}

//	@Bean
//	public Docket getDocket() {
//		ApiInfo apiInfo=new ApiInfo("Vikram",
//				"swagger demo",
//				"www.testyantra.com", 
//				"0.1",
//				new Contact("vikram","www.testyantra.com" , "vikram@gmail.com")
//				,"Ty-2023",
//				"www.testyantra.com",
//				new ArrayList<>());
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.ty.employeeregister"))
//				.paths(PathSelectors.ant("/insert"))
//				.build()
//				.apiInfo(apiInfo)
//				.useDefaultResponseMessages(false);
//	}
}

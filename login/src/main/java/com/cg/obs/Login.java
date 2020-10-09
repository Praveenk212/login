package com.cg.obs;

import java.util.Collections;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard  
@EnableSwagger2
@ComponentScan("com.cg.obs")
public class Login {

	public static void main(String[] args) {
		SpringApplication.run(Login.class, args);
		BasicConfigurator.configure();
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.cg.obs"))
				.build()
				.apiInfo(myApiInfo());

	}
	private ApiInfo myApiInfo() {
		// TODO Auto-generated method stub
		ApiInfo apiInfo=new ApiInfo(
				"Login Service", 
				"API CREATION", 
				"1.0", 
				"Free to Use", 
				new Contact("Praveen Kumar","/" ,"praveen.bz.kumar@capgemini.com"),
				"API licence",
				"/",
				Collections.emptyList());
		return apiInfo;
	}

}

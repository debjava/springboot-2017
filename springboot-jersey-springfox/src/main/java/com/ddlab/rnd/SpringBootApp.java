package com.ddlab.rnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication(scanBasePackages={"com.ddlab.rnd"})
public class SpringBootApp {
	
//	@Value("${springfox.documentation.swagger.v2.path}")
//	private String swagger2Endpoint;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
	
//	@Bean //best way to use
//    public Docket resourcesApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())   
//                .build()
//                .apiInfo(metaData());
//    }
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.ddlab.rnd"))
//	      .paths(PathSelectors.any()) 
	      .paths(PathSelectors.ant("/api/*"))
	      .build()
	      .apiInfo(metaData());
	}
    
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Hati Ghoda Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("Debadatta Mishra", "https://springframework.org", "deba@ddlab.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }

}

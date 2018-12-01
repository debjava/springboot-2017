package com.ddlab.rnd.springboot.jersey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages={"com.ddlab.*"})
@SpringBootApplication
public class SpringBootJerseyApplication {
	
//	@Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()                                  
//          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())                          
//          .build();                                           
//    }
	
	
//	 @Bean
//	    public Docket swaggerSettings() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.any())
//	                .paths(PathSelectors.any())
//	                .build()
//	                .pathMapping("/");
//	    }
	
	
//	@Bean
//	public Docket api() {                
//	    return new Docket(DocumentationType.SWAGGER_2)          
//	      .select()                                       
//	      .apis(RequestHandlerSelectors.basePackage("com.ddlab.web.resources"))
//	      .paths(PathSelectors.ant("/itc/*"))                     
//	      .build();
//	}
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.ddlab.web.resources"))
	      .paths(PathSelectors.any())    
//	      .paths(PathSelectors.ant("/itc/*"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "My REST API",
	      "Some custom description of API.",
	      "API TOS",
	      "Terms of service",
	      "myeaddress@company.com",
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}
	
	
	 
//	 @Bean
//	    Docket rsApi() {
//	        return new Docket(DocumentationType.SWAGGER_12)
//	            .apiInfo(apiInfo())
//	            .select()
//	                    .apis(RequestHandlerSelectors.any())
//	            .paths(PathSelectors.any())
//	            .build()
////	            .pathMapping('/')
//	            .useDefaultResponseMessages(false);
//	    }

	 
	 
//	 private ApiInfo apiInfo() {
//	        return new ApiInfoBuilder()
//	            .title("Test API")
//	            .description("Test API")
//	            .version("0.0.10.SNAPSHOT")
//	            .termsOfServiceUrl("")
//	            .contact("Test company")
//	            .license("Public")
//	            .licenseUrl("http://example.com/")
//	            .build();
//	    }
	
	
 
  public static void main(String[] args) {
    SpringApplication.run(SpringBootJerseyApplication.class, args);
  }
}
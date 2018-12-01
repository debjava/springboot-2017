package com.ddlab.rnd;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.models.Swagger;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    	
    	super( Endpoint.class);

        BeanConfig swaggerConfig = new BeanConfig();
//        swaggerConfig.setBasePath("/api");//springbootswagger2
        
        swaggerConfig.setDescription("Description");
        swaggerConfig.setContact("contact");
        swaggerConfig.setLicense("license");
        swaggerConfig.setLicenseUrl("www.ddlabinc.com");
        swaggerConfig.setTitle("title");
        
        
        
        swaggerConfig.setBasePath("/springbootswagger3/api");//springbootswagger2
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
    }
    
    
//    @Bean //best way to use
//    public Docket resourcesApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())   
//                .build()
//                .apiInfo(metaData());
//    }
//    
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot REST API",
//                "Spring Boot REST API for Online Store",
//                "1.0",
//                "Terms of service",
//                new Contact("Debadatta Mishra", "https://springframework.org", "deba@ddlab.com"),
//               "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0");
//        return apiInfo;
//    }

}
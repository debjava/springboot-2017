package com.ddlab.rnd.boot.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.boot.resources.Endpoint;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    	
    	super( Endpoint.class);

        BeanConfig swaggerConfig = new BeanConfig();
//        swaggerConfig.setBasePath("/api");//springbootswagger2
        swaggerConfig.setBasePath("/springbootswagger2/api");//springbootswagger2
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
    }

}
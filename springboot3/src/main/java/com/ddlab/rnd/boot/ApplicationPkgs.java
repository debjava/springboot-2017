package com.ddlab.rnd.boot;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;

//To know about WADl : GET http://localhost:8090/springboot3/myitc/application.wadl
@Component // ~~ This is mandatory
@ApplicationPath("myitc") // ~~ Very very important
public class ApplicationPkgs extends ResourceConfig {

	public ApplicationPkgs() {

		// super(
		// ITCResources.class,ITCUploadService.class,ITCDownloadService.class,JacksonFeature.class,MultiPartFeature.class);

		// OR you can write below

		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ITCResources.class);
		classes.add(JacksonFeature.class);
		classes.add(MultiPartFeature.class);
		//For swagger docs
		classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		swaggerConfiguration();
		
		registerClasses(classes);
	}

	private void swaggerConfiguration() {
		
		BeanConfig beanConfig = new BeanConfig();
//	    beanConfig.setHost("localhost:8090");
	    beanConfig.setBasePath("springboot3/myitc");
	    beanConfig.setResourcePackage("com.ddlab.rnd.boot");
	    beanConfig.setScan(true);
		
	}
}

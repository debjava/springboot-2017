package com.ddlab.rnd.springboot.jersey;

import java.util.HashSet;
import java.util.Set;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ddlab.web.resources.ITCDownloadService;
import com.ddlab.web.resources.ITCResources;
import com.ddlab.web.resources.ITCUploadService;

//To know about WADl : GET http://localhost:8090/springbootjersey2/api/application.wadl
@Component //~~ This is mandatory
public class ApplicationPkgs extends ResourceConfig {
	
	public ApplicationPkgs() {
		
//		super( ITCResources.class,ITCUploadService.class,ITCDownloadService.class,JacksonFeature.class,MultiPartFeature.class);
		
		// OR you can write below
		
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ITCResources.class);
		classes.add(ITCUploadService.class);
		classes.add(ITCDownloadService.class);
		classes.add(JacksonFeature.class);
		classes.add(MultiPartFeature.class);
		
		
//		register(io.swagger.jaxrs.listing.ApiListingResource.class);
//		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		registerClasses(classes);
	}
}

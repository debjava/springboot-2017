package com.ddlab.rnd.springboot.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class EndpointResource {

	@GET
	public String message() {
		return "Hello " + "Piku, you got spring with Jersey";
	}

}

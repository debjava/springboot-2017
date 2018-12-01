package com.ddlab.rnd;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/hello")
@Api(value="Spring Boot REST API")
public class Endpoint {

    @GET
    @ApiOperation("Get message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return "Hello";
    }
    
    @ApiOperation(value = "Delete a product")
	@Path("/deleteuser")
	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ResponseEntity delete(@PathVariable int id){
        System.out.println("Deleting some ids");
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }

}
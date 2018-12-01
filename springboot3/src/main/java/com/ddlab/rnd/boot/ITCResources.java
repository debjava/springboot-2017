package com.ddlab.rnd.boot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Path("/itc")
@Api(value="/myitc/itc",tags={"BasicService: This is the basic service.\n It is useful now."})
@SwaggerDefinition(
        info = @Info(
                description = "A basic service for testing",
                version = "v1",
                title = "Basic service api",
                termsOfService = "http://github.com/debjava",
                contact = @Contact(
                   name = "Debadatta Mishra", 
                   email = "deba.java@gmail.com", 
                   url = "http://github.com/debjava"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"text/plain,","application/json", "application/xml"},
        produces = {"text/plain,","application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        tags = {
                @Tag(name = "Private", description = "Tag used to denote operations as private")
        }, 
        externalDocs = @ExternalDocs(value = "No external doc", url = "http://nodoc.html")
)
public class ITCResources {
	
	@GET
	public String message() {
		return "Hello " + "Piku, you got spring with Jersey";
	}
	
	@Path("/user/{id}")
	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	@ApiOperation(value = "get user details by id as path param", notes = "get the user details from id as path param", code = 200)
	@ApiResponses(value={
            @ApiResponse(code=200, message="OK"),
            @ApiResponse(code=500, message="Internal Error")
    })
	public Response getUserById(@PathParam("id") int id) {
		if( id == 0 ) throw new IllegalArgumentException("Id cannot be 0, enter a valid id");
		System.out.println("Got the user response");
		return Response.ok().entity("Got the user response").build();
	}

}

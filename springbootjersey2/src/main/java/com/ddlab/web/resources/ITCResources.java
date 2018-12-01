package com.ddlab.web.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ddlab.entity.User;
import com.ddlab.services.IUserService;

import io.swagger.annotations.Api;

@Path("/itc")
@Api(value = "Hello resource", produces = "application/json")
public class ITCResources extends BaseResource {
	
	@Autowired @Qualifier("userService")
	private IUserService userService;
	
	
	 
	@GET
	public String message() {
		return "Hello " + "Piku, you got spring with Jersey";
	}
	
		//GET http://localhost:8090/springbootjersey2/api/itc/user/0
		//Status Code : 400 Bad Request
		//Response body : Id cannot be 0, enter a valid id
		@Path("/user/{id}")
		@GET
		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public Response getUserById(@PathParam("id") int id) {
			if( id == 0 ) throw createWebappException(new IllegalArgumentException("Id cannot be 0, enter a valid id"));
			User user = new User();
			user.setFirstName("Deb");
			user.setLastName("Mishra");
			user.setId(id);
			return Response.ok().entity(user).build();
		}
		
		//GET http://localhost:8090/springbootjersey2/api/itc/address/USA
		//GET http://localhost:8090/springbootjersey2/api/itc/address/europe
		//Status Code : 200 OK
		@Path("/address/{areaCode}") //USA,EUROPE
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public Response getAddressByCode(@PathParam("areaCode") String areaCode) {
			
			String addressString = null;
			try {
				if (areaCode.equalsIgnoreCase("USA"))
					addressString = "12 North State, Route 17,Suite 303,Paramus,New Jersey,NJ-07652";
				else if (areaCode.equalsIgnoreCase("Europe"))
					addressString =  "Newell Consulting Oy,P.O. Box 16 , Olari,02211 Espoo, Helsinki";
				else if (areaCode.equalsIgnoreCase("Africa"))
					addressString =  "Johannesburg,2nd Floor, West Tower,Nelson Mandela Square,Maude Street, Sandton,Johannesburg, 2196";
				else if (areaCode.equalsIgnoreCase("Asia"))
					addressString =  "ITC Infotech India Limited, 18, Banaswadi Main Rd, Maruthi Sevanagar, Bangalore, 560005";
				else {
					addressString =  "No such area code exists for ITC";
				}
					
			} catch (Exception e) {
				throw createWebappException( new IllegalArgumentException("No such area code exists for ITC"));
			}
			return Response.ok().entity(addressString).build();
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~ @QueryParam ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//GET http://localhost:8090/springbootjersey2/api/itc/regionaladdress/Europe?country=SE
		//Status Code : 200 OK
		@Path("/regionaladdress/{areaCode}") //USA,EUROPE
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public Response getAddressByCountry(@PathParam("areaCode") String areaCode, @QueryParam("country") String country) {
			
			String adrsByCountry = null;
			try {
				if (areaCode.equalsIgnoreCase("USA")
						&& country.equalsIgnoreCase("NJ"))
					adrsByCountry = "12 North State, Route 17,Suite 303,Paramus,New Jersey,NJ-07652";
				else if (areaCode.equalsIgnoreCase("Europe")
						&& country.equalsIgnoreCase("FI"))
					adrsByCountry = "Newell Consulting Oy,P.O. Box 16 , Olari,02211 Espoo, Helsinki";
				else if (areaCode.equalsIgnoreCase("Europe")
						&& country.equalsIgnoreCase("SE"))
					adrsByCountry = "C/o Matrisen AB,Box 22059 , 104 22 Stockholm";
				else if (areaCode.equalsIgnoreCase("Europe")
						&& country.equalsIgnoreCase("DK"))
					adrsByCountry = "Havnegade 39, 3. sal,1058 Copenhagen K";
				else if (areaCode.equalsIgnoreCase("Asia")
						&& country.equalsIgnoreCase("IN"))
					adrsByCountry = "ITC Infotech India Limited, 18, Banaswadi Main Rd, Maruthi Sevanagar, Bangalore, 560005";
				else
					adrsByCountry = "No such area code exists for ITC";
			} catch (Exception e) {
				throw createWebappException( new IllegalArgumentException("No such area code exists for ITC"));
			}
			return Response.ok().entity(adrsByCountry).build();
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~ @MatrixParam ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//GET http://localhost:8090/springbootjersey2/api/itc/itcaddress;country=FI;areacode=europe
		//Status Code : 200 OK
		@Path("/itcaddress")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public Response getITCAddress(@MatrixParam("country") String country, @MatrixParam("areacode") String areaCode) {
			return getAddressByCountry(areaCode, country);
		}
		
		// ~~~~~~~~~~~~~~~~~~~~~~~ @FormParam ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//POST http://localhost:8090/springbootjersey2/api/itc/postaladdress
		//Content-Type : application/x-www-form-urlencoded
		//Body : country=FI&areacode=Europe
		//Status Code : 200 OK
		@Path("/postaladdress")
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		public Response postNGetITCAddress(@FormParam("country") String country,@FormParam("areacode") String areaCode) {
			
			return getAddressByCountry(areaCode, country);
		}

		/*
		 * POST http://localhost:8090/springbootjersey2/api/itc/createuser
		 * Content-Type : application/json
		 * Body : 
		 * {
	  	 *		"firstName" : "Deb",
	  	 *		"lastName" : "Mishra",
	  	 *		"id" : 1
	  	 *	}
	  	 * 
	  	 * Response Status Code: 201 Created
		 */
		
		
//		@ApiOperation(value = "getGreeting", nickname = "getGreeting")
//	    @RequestMapping(method = RequestMethod.GET,  produces = "application/json")
//	    @ApiImplicitParams({
//	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
//	      })
//	    @ApiResponses(value = { 
//	            @ApiResponse(code = 200, message = "Success", response = User.class),
//	            @ApiResponse(code = 401, message = "Unauthorized"),
//	            @ApiResponse(code = 403, message = "Forbidden"),
//	            @ApiResponse(code = 404, message = "Not Found"),
//	            @ApiResponse(code = 500, message = "Failure")}) 
		@Path("/createuser")
		@POST
		@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		public Response createEmp(User user) {
			userService.createUser(user);
			return Response.status(Status.CREATED).entity("User " + user.getFirstName()+" created successfully...").build();
		}
		
		/*
		 * To know the user-agent header
		 * GET http://localhost:8090/springjersey/api/headers/get
		 * 
		 * Response will be
		 * In FireFox
		 * addUser is called, userAgent : Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0
		 * 
		 * In Chrome
		 * addUser is called, userAgent : Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36
		 */
		@GET
		@Path("/headers/get")
		public Response addUser(@HeaderParam("user-agent") String userAgent) {
			String msg = "addUser is called, userAgent : " + userAgent;
			return Response.status(200).entity(msg).build();
		}

}

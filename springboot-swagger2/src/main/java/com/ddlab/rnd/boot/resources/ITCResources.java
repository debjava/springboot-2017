//package com.ddlab.rnd.boot.resources;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
////@RestController
////@RequestMapping("/itc")
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
//@Path("/itc")
//public class ITCResources {
//	
////	@ApiOperation(value = "Delete a product")
////    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
//	
//	@ApiOperation(value = "Delete a product")
//	@Path("/deleteuser")
//	@POST
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//    public ResponseEntity delete(@PathVariable int id){
//        System.out.println("Deleting some ids");
//        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
//
//    }
//
//}

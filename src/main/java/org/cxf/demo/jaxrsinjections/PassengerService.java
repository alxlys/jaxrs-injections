package org.cxf.demo.jaxrsinjections;

import org.cxf.demo.jaxrsinjections.model.Passenger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.List;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml,application/x-www-form-urlencoded")
public interface PassengerService {

   @GET
   @Path("/passengers")
   List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);

   @POST
   @Path("/passengers")
   Passenger addPassenger(Passenger passenger);

   @POST
   @Path("/passengers")
   void addPassenger(@FormParam("firstName") String firstName,
         @FormParam("lastName") String lastName, @HeaderParam("agent") String agent,
         @Context HttpHeaders httpHeaders);

}

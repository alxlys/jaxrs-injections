package org.cxf.demo.jaxrsinjections;

import org.cxf.demo.jaxrsinjections.model.Passenger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml")
public interface PassengerService {

   @GET
   @Path("/passengers")
   List<Passenger> getPassengers();

   @POST
   @Path("/passengers")
   Passenger addPassenger(Passenger passenger);
}

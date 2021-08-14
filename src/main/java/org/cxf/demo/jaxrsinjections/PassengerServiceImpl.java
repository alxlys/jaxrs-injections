package org.cxf.demo.jaxrsinjections;

import org.cxf.demo.jaxrsinjections.model.Passenger;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

/**
 * @author olysenko
 */
@Service
public class PassengerServiceImpl implements PassengerService {

   private final List<Passenger> passengers = new ArrayList<>();
   private int currentId = 1;

   @Override
   public List<Passenger> getPassengers(int start, int size) {
      System.out.println("start = " + start + ", size = " + size);
      return passengers;
   }

   @Override
   public Passenger addPassenger(Passenger passenger) {
      passenger.setId(currentId++);
      passengers.add(passenger);
      return passenger;
   }

   @Override
   public void addPassenger(String firstName, String lastName, String agent,
         HttpHeaders httpHeaders) {
      System.out.println("Agent: " + agent);
      httpHeaders.getRequestHeaders().keySet().forEach(k -> System.out
            .println("headerName: " + k + ", value: " + httpHeaders.getHeaderString(k)));
      System.out.println("***************************************************************");
      httpHeaders.getCookies().keySet().forEach(k -> System.out.println(
            "cookieName: " + k + ", value: " + httpHeaders.getCookies().get(k).getValue()));

      Passenger passenger = new Passenger();
      passenger.setId(currentId++);
      passenger.setName(firstName + " " + lastName);
      passengers.add(passenger);
   }
}

package org.cxf.demo.jaxrsinjections;

import org.cxf.demo.jaxrsinjections.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author olysenko
 */
@Service
public class PassengerServiceImpl implements PassengerService {

   private List<Passenger> passengers;
   private int currentId = 1;

   @Override
   public List<Passenger> getPassengers() {
      return passengers;
   }

   @Override
   public Passenger addPassenger(Passenger passenger) {
      passenger.setId(currentId++);
      passengers.add(passenger);
      return passenger;
   }
}

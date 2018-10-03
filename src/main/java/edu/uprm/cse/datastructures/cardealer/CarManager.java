package edu.uprm.cse.datastructures.cardealer;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import exceptions.*;
import edu.uprm.cse.datastructures.cardealer.model.Car;

@Path("/cars")
public class CarManager {

	private final CopyOnWriteArrayList<Car> cList = MockCarList.getInstance();   
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Car[] getAllCars()
	{
		
		return cList.toArray(new Car[0]);
	}
	
	  @GET
	  @Path("{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Car getCar(@PathParam("id") long id){
	    Optional<Car> match
	        = cList.stream()
	        .filter(c -> c.getId() == id)
	        .findFirst();
	    if (match.isPresent()) {
	      return match.get();
	    } else {
	      throw new NotFoundException(new JsonError("Error", "Car " + id + " not found"));
	    }
	  }     
	  
	   @POST
	    @Path("/add")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response addCarr(Car car){
	      cList.add(car);
	      return Response.status(201).build();
	    }  
	   
	   @PUT
	    @Path("{id}/update")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response updateCustomer(Car car){
	      int matchIdx = 0;
	      Optional<Car> match = cList.stream()
	          .filter(c -> c.getId() == car.getCarId())
	          .findFirst();
	      if (match.isPresent()) {
	        matchIdx = cList.indexOf(match.get());
	        cList.set(matchIdx, car);
	        return Response.status(Response.Status.OK).build();
	      } else {
	        return Response.status(Response.Status.NOT_FOUND).build();      
	      }
	    }
	   
	    @DELETE
	    @Path("/remove/{id}")
	    public void deleteCustomer(@PathParam("id") long id){
	      Predicate<Car> car = c -> c.getId() == id;
	      if (!cList.removeIf(car)) {
	       throw new NotFoundException(new JsonError("Error", "Customer " + id + " not found"));
	      }
	    }       
}

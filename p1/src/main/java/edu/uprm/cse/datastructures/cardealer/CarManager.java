package edu.uprm.cse.datastructures.cardealer;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
//import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import exceptions.JsonError;
import exceptions.NotFoundException;
import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CSDLL;
import edu.uprm.cse.datastructures.cardealer.util.MockCarList;

@Path("/cars")
public class CarManager
{

	private static final CopyOnWriteArrayList<Car> cList = MockCarList.getInstance();   
	private CSDLL<Car> sorting;
	
	
	private void updateList()
	{
		sorting = new CSDLL();
//		int s = cList.size();
//		//System.out.println(s);
//		sorting = new CSDLL();
//		for(int i = 0; i < s ; i++)
//		{
//			sorting.add(cList.remove(0));
//		}
//		//System.out.println(s);
//		
//		s = sorting.size();
//		for(int i = 0; i < s; i++)
//		{
//			cList.add(sorting.get(i));
//		}
//		
//		sorting.clear();
		for(Car a: cList) {
			sorting.add(a);
		}
		cList.clear();
		
		for(int i=0;i<sorting.size();i++) {
			cList.add((Car) sorting.get(i));
			
		}
		//sorting.clear();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Car[] getAllCars()
	{
		updateList();
		return cList.toArray(new Car[0]);
	}
	
	  @GET
	  @Path("/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Car getCar(@PathParam("id") long id){
	    Optional<Car> match
	        = cList.stream()
	        .filter(c->c.getCarId() == id)
	        .findFirst();
	    if (match.isPresent()) {
	    	updateList();
	      return match.get();
	    } else {
	      throw new NotFoundException(new JsonError("Error", "Car " + id + " not found"));
	    }
	 }     
	  
	   @POST
	    @Path("/add")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response addCar(Car car){
	      cList.add(car);
	      updateList();
	      return Response.status(201).build();
	    }  
	   
	   @PUT
	    @Path("/{id}/update")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response updateCar(Car car){
	      int matchIdx = 0;
	      Optional<Car> match = cList.stream()
	          .filter(c->c.getCarId() == car.getCarId())
	          .findFirst();
	      if (match.isPresent()) {
	        matchIdx = cList.indexOf(match.get());
	        cList.set(matchIdx, car);
	        updateList();
	        return Response.status(Response.Status.OK).build();
	      } else {
	        return Response.status(Response.Status.NOT_FOUND).build();      
	      }
	     // return null;
	    }
	   
	    @DELETE
	    @Path("/{id}/delete")
	    public Response deleteCar(@PathParam("id") long id){
	      Predicate<Car> car = (c->c.getCarId() == id);
	      if (!cList.removeIf(car)) {
	       throw new NotFoundException(new JsonError("Error", "Car " + id + " not found"));
	      }
	      else {
	    	  Response temp = Response.status(Response.Status.OK).build();
//	    	  updateList();
	    	  return temp ;
	      }
	    }       
}

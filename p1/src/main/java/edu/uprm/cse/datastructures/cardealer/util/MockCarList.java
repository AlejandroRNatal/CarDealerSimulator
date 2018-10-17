package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import edu.uprm.cse.datastructures.cardealer.model.Car;

public class MockCarList {
	private static final CopyOnWriteArrayList<Car> cList = new CopyOnWriteArrayList<Car>();

// 	private static final String[] brands = new String[10];
// 	private static final String[] models = new String[10];
// 	private static final String[] options = new String[2];
// 	private static Random rand = new Random();
// 	//private CSDLL<Car> list =  new CSDLL();
// 	public static Car[] cars()
// 	{
// 		Car[] cars = new Car[10];
		
// 		for(int i = 0 ; i < 10; i++)
// 		{
// 			//for(int j = 0; j < 2 ; j++)
// 				//cars[i] = new Car((long)i,brands[i],models[i],options[rand.nextInt(2)], rand.nextDouble());
// 				cars[i] = new Car((long)i,brands[rand.nextInt(10)],models[rand.nextInt(10)],options[rand.nextInt(2)], rand.nextDouble());
				
// 		}
		
// 		return cars;
// 	}
// 	private static void models()
// 	{
// 		models[0] = "Civic";
// 		models[1] = "Corolla";
// 		models[2] = "Runner";
// 		models[3] = "Bug";
// 		models[4] = "Soul";
// 		models[5] = "Sentra";
// 		models[6] = "Elantra";
// 		models[7] = "500X";
// 		models[8] = "Continental";
// 		models[9] = "Lancer";
// 	}
	
// 	private static void brands()
// 	{
// 		brands[0] = "Honda";
// 		brands[1] = "Toyota";
// 		brands[2] = "Ford";
// 		brands[3] = "Volkswagen";
// 		brands[4] = "Kia";
// 		brands[5] = "Nissan";
// 		brands[6] = "Hyundai";
// 		brands[7] = "Fiat";
// 		brands[8] = "Lincoln";
// 		brands[9] = "Mitsubishi";
// 	}
	
// 	private static void options()
// 	{
// 		options[0] = "LE";
// 		options[1] = "SE";
// 	}
	
// 	private static void setup()
// 	{
// 		models();
// 		options();
// 		brands();
// 	}
	
	
	  static {
	    // Create list of customers
		  //setup();
		  //for(Car c:  cars())
			 // cList.add(c);

	  }
	  
	  private MockCarList(){}
	  
	  public static CopyOnWriteArrayList<Car> getInstance(){
	    return cList;
	  }
	  
	  public String toString()
	  {
		  StringBuilder str_b = new StringBuilder();
		  
		  str_b.append("{\n");
		  for(Car c :cList)
		  {
			  str_b.append("\t");
			  str_b.append(c.toString());
			  str_b.append("\n");
		  }
		  str_b.append("\n}");
		  return str_b.toString(); 
	  }
}

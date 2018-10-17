package testers;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CSDLL;

public class CSDLListTester
{
	private static final String[] brands = new String[10];
	private static final String[] models = new String[10];
	private static final String[] options = new String[2];
	private Random rand = new Random();
	private CSDLL<Car> list =  new CSDLL();
	public Car[] cars()
	{
		Car[] cars = new Car[10];
		
		for(int i = 0 ; i < 10; i++)
		{
				cars[i] = new Car((long)i,brands[rand.nextInt(10)],models[rand.nextInt(10)],options[rand.nextInt(2)], rand.nextDouble());
				
		}
		
		return cars;
	}
	
	private void models()
	{
		models[0] = "Civic";
		models[1] = "Corolla";
		models[2] = "Runner";
		models[3] = "Bug";
		models[4] = "Soul";
		models[5] = "Sentra";
		models[6] = "Elantra";
		models[7] = "500X";
		models[8] = "Continental";
		models[9] = "Lancer";
	}
	
	private void brands()
	{
		brands[0] = "Honda";
		brands[1] = "Toyota";
		brands[2] = "Ford";
		brands[3] = "Volkswagen";
		brands[4] = "Kia";
		brands[5] = "Nissan";
		brands[6] = "Hyundai";
		brands[7] = "Fiat";
		brands[8] = "Lincoln";
		brands[9] = "Mitsubishi";
	}
	
	private void options()
	{
		options[0] = "LE";
		options[1] = "SE";
	}
	
	private void setup()
	{
		models();
		options();
		brands();
	}
	
	private static void printList(CSDLL li)
	{
		System.out.println("CSDLL: Size("+li.size() +")");
		li.printList();
		System.out.println();
	}
	
	@Test
	public void test()
	{
		setup();
		Car[] cars = cars();
		for(Car c: cars)
		{
			//System.out.println(c);
			list.add(c);
		}
		
		System.out.println("Cars Array: Size("+ cars.length+")");
		for(Car c:cars)
			System.out.println(c);
		System.out.println();
		
		printList(list);
		
		System.out.println();
		int ran = rand.nextInt(10);
		Car temp = list.get(ran);
		assertTrue(list.contains(temp));
		printList(list);
		
		System.out.println("Car to remove:"+temp);
		System.out.println();
		boolean remo = list.remove(temp);
		
		assertTrue(remo);
		printList(list);
		System.out.println();
		
//		for(int i  = 0;  i < cars.length; i++)
//		{
//			System.out.println("["+i+"]"+"Array:" + cars[i]+"\nList:" + list.get(i)+ "\n");
//			//\assertEquals(cars[i], list.get(i));
//		}
		

	}
}

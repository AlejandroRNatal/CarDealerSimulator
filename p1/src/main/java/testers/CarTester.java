package testers;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CSDLL;

public class CarTester {


	Car c  = new Car(0001L, "Toyota", "Corolla" , "SE", 20000.000);
	
	@Test
	public void idTest()
	{
		assertTrue(0001L == c.getCarId());
	}
	
	@Test
	public void brandTest()
	{
		assertEquals(c.getCarBrand(), "Toyota");
	}
	
	@Test
	public void modelTest()
	{
		assertEquals(c.getCarModel(), "Corolla");
	
	}
	
	
	@Test
	public void modelOptionTest()
	{
		assertEquals(c.getCarModelOption(), "SE");
	}
	
	@Test
	public void priceTest()
	{
		assertTrue(c.getCarPrice()== 20000.000);
	}

}

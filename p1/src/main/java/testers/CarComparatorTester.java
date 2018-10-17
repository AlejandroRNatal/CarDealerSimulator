package testers;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.model.CarComparator;

public class CarComparatorTester {
	private Car toyota = new Car(1, "Toyota" , "Corolla","SE",40000.00);
	private Car toyota_y = new Car(4, "Toyota" , "Yaris","SE",33000.00);
	private Car hyundai= new Car(2, "Hyundai" , "Elantra","XE",55000.00);
	private Car hyundai_s= new Car(2, "Hyundai" , "Sonata","SE",60000.00);
	private Car ford= new Car(3, "Ford" , "Runner","v4",70000.00);
	
	private CarComparator comp = new CarComparator();
	
	@Test
	public void test() {
		//assertTrue(comp.compare(toyota,toyota_y) ==-1);
		assertTrue(comp.compare(toyota_y,toyota) ==-1);
	}

}

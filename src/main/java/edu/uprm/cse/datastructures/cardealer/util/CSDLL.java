package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Comparator;
import java.util.Iterator;

import edu.uprm.cse.datastructures.cardealer.model.CarComparator;
import edu.uprm.cse.datastructures.cardealer.model.Car;
public class CSDLL<Car> extends CircularSortedDoublyLinkedList<Car>
{
	public CSDLL()
	{
		super();
	}
	@Override
	public Comparator<Car> comparator()
	{
		return (Comparator<Car>) new CarComparator();
	}
	
	@Override
	public boolean add(Car c)
	{
		boolean addedCar = false;
		if(this.contains(((edu.uprm.cse.datastructures.cardealer.model.Car) c).getCarId()))
			return false;
		if(super.add(c))
			addedCar = true;
		return addedCar;
	}
	public boolean contains(long id)
	{
		boolean hasID = false;
//		Iterator<Car> iter = (Iterator<Car>) iterator();
//		while(iter.hasNext())
		Node<Car> temp = this.getFirstNode();
		for(int i =0 ; i < this.size() ; i++, temp = temp.getNext())
		{
			
			if(((edu.uprm.cse.datastructures.cardealer.model.Car) temp.getElement()).getCarId() == id)
			{
				hasID = true;
				break;
			}
			
		
		}
		
		return hasID;
	}

}

package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Comparator;

import edu.uprm.cse.datastructures.cardealer.model.CarComparator;

public class CSDLL<Car> extends CircularSortedDoublyLinkedList<Object> 
{
	public CSDLL()
	{
		super();
	}
	@Override
	public Comparator comparator()
	{
		return new CarComparator();
	}

}

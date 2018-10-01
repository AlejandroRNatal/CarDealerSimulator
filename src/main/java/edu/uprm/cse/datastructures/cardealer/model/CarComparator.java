package edu.uprm.cse.datastructures.cardealer.model;

import java.util.Comparator;

public class CarComparator implements Comparator{

	
	public int compareModelOption(Car car1, Car car2)
	{
		String car1Model = car1.getCarModelOption();
		String car2Model = car2.getCarModelOption();
		
		if(car1Model==car2Model)
			return 0;
		return car1Model.compareToIgnoreCase(car2Model);
	}
	
	public int compareModels(Car car1, Car car2)
	{
		String car1Model = car1.getCarModel();
		String car2Model = car2.getCarModel();
		
		if(car1Model==car2Model)
			return 0;
//		int n = (car1Brand.length() <= car2Brand.length())? car1Brand.length() : car2Brand.length();
//		for(int i  = 0; i < n ; i++)
//		{
//			if(car1Brand.charAt(i).compare(car2Brand.charAt(i)))//if 2 goes before 1
//				return -1;
//		}
		
		return car1Model.compareToIgnoreCase(car2Model);
	}
	
	public int compareBrands(Car car1, Car car2) {
		
		String car1Brand = car1.getCarBrand();
		String car2Brand = car2.getCarBrand();
		
		if(car1Brand==car2Brand)
			return 0;
//		int n = (car1Brand.length() <= car2Brand.length())? car1Brand.length() : car2Brand.length();
//		for(int i  = 0; i < n ; i++)
//		{
//			if(car1Brand.charAt(i).compare(car2Brand.charAt(i)))//if 2 goes before 1
//				return -1;
//		}
		
		return car1Brand.compareToIgnoreCase(car2Brand);
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		if(compareBrands((Car)o1, (Car)o2) >= compareModels((Car)o1, (Car)o2)  &&
				compareBrands((Car)o1, (Car)o2) >= compareModelOption((Car)o1, (Car)o2)  )
		{
			
			return 1;
		}
		
		if(compareBrands((Car)o1, (Car)o2) == 0 &&
				compareModels((Car)o1, (Car)o2) ==0 &&
				compareModelOption((Car)o1, (Car)o2) ==0 )
		{
			return 0;
		}
		
		return -1;
	}

}

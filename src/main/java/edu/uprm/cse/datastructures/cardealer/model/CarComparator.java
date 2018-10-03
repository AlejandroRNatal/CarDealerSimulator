package edu.uprm.cse.datastructures.cardealer.model;

import java.util.Comparator;

public class CarComparator implements Comparator<Object>
{
	//Assume Objects provided aren't null
	
	public int compareModelOption(Car car1, Car car2)
	{
		String car1ModelOption = car1.getCarModelOption();
		String car2ModelOption = car2.getCarModelOption();
		
		if(car1ModelOption==car2ModelOption)
			return 0;
		return car1ModelOption.compareToIgnoreCase(car2ModelOption);
	}
	
	public int compareModels(Car car1, Car car2)
	{
		String car1Model = car1.getCarModel();
		String car2Model = car2.getCarModel();
		
		if(car1Model==car2Model)
			return 0;
		
		return car1Model.compareToIgnoreCase(car2Model);
	}
	
	public int compareBrands(Car car1, Car car2) 
	{
		
		String car1Brand = car1.getCarBrand();
		String car2Brand = car2.getCarBrand();
		
		if(car1Brand==car2Brand)
			return 0;

		
		return car1Brand.compareToIgnoreCase(car2Brand);
	}

	public int compare(Object o1, Object o2) 
	{
		if(compareBrands((Car)o1,(Car)o2)== 0)
		{
			if(compareModels((Car)o1,(Car)o2)== 0)
			{
				if(compareModelOption((Car)o1, (Car)o2) ==0)
					return 0;
				
				return compareModelOption((Car)o1, (Car)o2);
			}
				
			return compareModels((Car)o1,(Car)o2);
		}
		
		return compareBrands((Car)o1,(Car)o2);
		
	}

}

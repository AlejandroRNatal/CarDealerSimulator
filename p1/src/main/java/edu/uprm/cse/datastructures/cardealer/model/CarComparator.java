package edu.uprm.cse.datastructures.cardealer.model;

import java.util.Comparator;

import edu.uprm.cse.datastructures.cardealer.util.AbstractComparator;

public class CarComparator extends AbstractComparator<Car>
{
	//Assume Objects provided aren't null
	
	public int compareModelOption(Car car1, Car car2)
	{
		if(car1 == null |car2 == null )
			return 0;
		String car1ModelOption = car1.getCarModelOption();
		String car2ModelOption = car2.getCarModelOption();
		
		if(car1ModelOption==car2ModelOption)
			return 0;
		return car1ModelOption.compareToIgnoreCase(car2ModelOption);
	}
	
	public int compareModels(Car car1, Car car2)
	{
		if(car1 == null |car2 == null )
			return 0;
		String car1Model = car1.getCarModel();
		String car2Model = car2.getCarModel();
		
		if(car1Model==car2Model)
			return 0;
		
		return car1Model.compareToIgnoreCase(car2Model);
	}
	
	public int compareBrands(Car car1, Car car2) 
	{
		if(car1 == null |car2 == null )
			return 0;
		
		String car1Brand = car1.getCarBrand();
		String car2Brand = car2.getCarBrand();
		
		if(car1Brand==car2Brand)
			return 0;

		
		return car1Brand.compareToIgnoreCase(car2Brand);
	}

	@Override
	public int compare(Car o1, Car o2) 
	{
//		if(compareBrands((Car)o1,(Car)o2)== 0)
//		{
//			if(compareModels((Car)o1,(Car)o2)== 0)
//			{
//				if(compareModelOption((Car)o1, (Car)o2) ==0)
//					return 0;
//				
//				return compareModelOption((Car)o1, (Car)o2);
//			}
//				
//			return compareModels((Car)o1,(Car)o2);
//		}
//		
//		return compareBrands((Car)o1,(Car)o2);
		if(o1.getCarBrand().compareTo(o2.getCarBrand())!= 0)
			return o1.getCarBrand().compareTo(o2.getCarBrand());
		if(o1.getCarModel().compareTo(o2.getCarModel())!= 0)
			return o1.getCarModel().compareTo(o2.getCarModel());
		else
			return o1.getCarModelOption().compareTo(o2.getCarModelOption());
	}

}

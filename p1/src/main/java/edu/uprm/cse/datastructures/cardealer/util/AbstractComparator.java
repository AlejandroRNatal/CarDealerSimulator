package edu.uprm.cse.datastructures.cardealer.util;

import java.util.Comparator;

public class AbstractComparator<Object> implements Comparator<Object> {


	public int compare(Object arg0, Object arg1) {
		if(arg0.equals(arg1))
			return 0;
		if(!arg0.equals(arg1))
			return 1;
		
		return -1;
	}

}

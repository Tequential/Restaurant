package task11;

import java.util.Comparator;

//implement Comparator interface

public class SortbyLoad implements Comparator<Driver>{

	//sort in ascending order of driver load
	public int compare(Driver a, Driver b) {
		
		return a.driverLoad - b.driverLoad;
	}

}

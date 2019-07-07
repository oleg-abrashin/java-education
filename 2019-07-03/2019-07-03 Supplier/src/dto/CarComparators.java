package dto;

import java.util.Comparator;

public class CarComparators {
	
	public static Comparator<Car> engineCarComparator =
			(c1, c2) -> Double.compare(c1.getEngine(), c2.getEngine());
	
	public static Comparator<Car> yearCarComparator =
			(c1, c2) -> Integer.compare(c1.getYear(), c2.getYear());
			
	public static Comparator<Car> modelCarComparator =
			(c1, c2) -> c1.getModel().compareTo(c2.getModel());
	
	public static Comparator<Car> idCarComparator =
			(c1, c2) -> Integer.compare(c1.getId(), c2.getId());
	
	public static Comparator<Car> naturalCarComparator = 
			modelCarComparator
			.thenComparing(yearCarComparator)
			.thenComparing(engineCarComparator)
			.thenComparing(idCarComparator);

}

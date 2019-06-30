package comparators;

import java.util.Comparator;

import car.Car;

public class ACCarComparator implements Comparator<Car>{

	@Override
	public int compare(Car c1, Car c2) {
	/*	boolean ac1 = c1.isAc();
		boolean ac2 = c2.isAc();
		return ac1 == ac2 ? 0 : (ac1 ? -1 : 1);*/
		return Boolean.compare(c1.isAc(), c2.isAc());
	}

}

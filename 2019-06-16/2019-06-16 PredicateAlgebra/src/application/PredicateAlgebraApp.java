package application;

import java.util.function.Predicate;

import car.Car;
import predicates.Ac;
import predicates.EngineRange;
import predicates.Model;
import predicates.YearRange;

public class PredicateAlgebraApp {
	
	private static final int NUM_CARS = 50;

	public static void main(String[] args) {
		
		Car[] garage = new Car[NUM_CARS];
		for (int i = 0; i < garage.length; i++) garage[i] = Car.randomCar();
		
		for (int i = 0; i < garage.length; i++) System.out.println(garage[i]);
		System.out.println("**************************************");
		
		Predicate<Car> ac = new Ac();
		Predicate<Car> model = new Model("Toyota");
		Predicate<Car> yearRange = new YearRange(1990, 2010);
		Predicate<Car> engineRange = new EngineRange(1.5, 2.0);
		
		//Predicate<Car> combinedPredicate = (yearRange.negate()).and(ac.negate());
		Predicate<Car> combinedPredicate = Predicate.isEqual(garage[4]);
		
		Car[] filtered = filterCar(garage, combinedPredicate);
		
		for (int i = 0; i < filtered.length; i++) System.out.println(filtered[i]);
		System.out.println("**************************************");


	}
	
	public static Car[] filterCar(Car[] arr, Predicate<Car> predicate) {
		Car[] buffer = new Car[arr.length];
		int counter = 0;
		for(int i=0; i < arr.length; i++) {
			if (predicate.test(arr[i])) {
				buffer[counter++] = arr[i];
			}
		}
		
		Car[] result = new Car[counter];
		for (int i = 0; i < counter; i++) result[i] = buffer[i];
		
		return result;
		
	}

}

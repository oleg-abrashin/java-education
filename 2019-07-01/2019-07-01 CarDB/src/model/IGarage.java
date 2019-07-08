package model;

import dto.Car;

import java.util.stream.Stream;

public interface IGarage {
	
	void fill(int numCar);
	
	boolean add(Car car);
	boolean contains(Car car);
	Car remove(int id);
	boolean remove(Car car);
	
	Car getById(int id);
	Iterable<Car> allCars();
	Iterable<Car> allCarsByModel(String model);
	Iterable<Car> allCarsByYearRange(int minYear, int maxYear);
	Iterable<Car> allCarsByEngineRange(double minEngine, double maxEngine);
	Iterable<Car> allCarsByAC(boolean ac);
	
	Iterable<Car> allCarsSortedByModel();
	Iterable<Car> allCarsSortedByYear();
	Iterable<Car> allCarsSortedByEngine();

	Stream<Car> toStream();

}

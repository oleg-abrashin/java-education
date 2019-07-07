package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import dto.Car;
import maplist.TreeListMap;

public class Garage implements IGarage{
	
	private HashMap<Integer, Car> idHM = new HashMap<>();
	
	private TreeListMap<String, Car> modelTM = new TreeListMap<>();
	private TreeListMap<Integer, Car> yearTM = new TreeListMap<>();
	private TreeListMap<Double, Car> engineTM = new TreeListMap<>();

	@Override
	public void fill(int numCar) {
		for (int i=0; i<numCar; i++) add(Car.randomCar());
	}

	@Override
	public boolean add(Car car) {
		int id = car.getId();
		if (idHM.containsKey(id))return false;
		idHM.put(id, car);
		
		modelTM.add(car.getModel(), car);
		yearTM.add(car.getYear(), car);
		engineTM.add(car.getEngine(), car);
		
		return true;
	}

	@Override
	public boolean contains(Car car) {
		return idHM.containsKey(car.getId());
	}

	@Override
	public Car remove(int id) {
		Car result = idHM.get(id);
		remove(result);
		return result;
	}

	@Override
	public boolean remove(Car car) {
		if (car == null) return false;
		
		boolean result = idHM.remove(car.getId()) != null;

		if (result){
			result = modelTM.remove(car.getModel(),car) && result;
			result = yearTM.remove(car.getYear(), car)  && result;
			result = engineTM.remove(car.getEngine(), car)  && result;
		}
		return result;
	}

	@Override
	public Car getById(int id) {
		return idHM.get(id);
	}

	@Override
	public Iterable<Car> allCars() {
		return new TreeSet<Car>(idHM.values());
	}

	@Override
	public Iterable<Car> allCarsByModel(String model) {
		return modelTM.get(model);
	}

	@Override
	public Iterable<Car> allCarsByYearRange(int minYear, int maxYear) {
		return yearTM.getInRange(minYear, maxYear);
	}

	@Override
	public Iterable<Car> allCarsByEngineRange(double minEngine, double maxEngine) {
		return engineTM.getInRange(minEngine, maxEngine);
	}

	@Override
	public Iterable<Car> allCarsByAC(boolean ac) {
		TreeSet<Car> result = new TreeSet<Car>();
		for (Car c : idHM.values()) {
			if (c.isAc() == ac)result.add(c);
		}
		return result;
	}

	@Override
	public Iterable<Car> allCarsSortedByModel() {
		return modelTM.getAll();
	}

	@Override
	public Iterable<Car> allCarsSortedByYear() {
		return yearTM.getAll();
	}

	@Override
	public Iterable<Car> allCarsSortedByEngine() {
		return engineTM.getAll();
	}

}

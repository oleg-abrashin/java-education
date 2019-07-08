package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import dto.Car;

public class Garage implements IGarage{
	
	private HashMap<Integer, Car> idHM = new HashMap<>();
	private TreeMap<String, TreeSet<Car>> modelTM = new TreeMap<>();
	private TreeMap<Integer, TreeSet<Car>> yearTM = new TreeMap<>();
	private TreeMap<Double, TreeSet<Car>> engineTM = new TreeMap<>();

	@Override
	public void fill(int numCar) {
		for (int i=0; i<numCar; i++) add(Car.randomCar());
	}

	@Override
	public boolean add(Car car) {
		int id = car.getId();
		if (idHM.containsKey(id))return false;
		idHM.put(id, car);
		
		String model = car.getModel();
		TreeSet<Car> modelTS = modelTM.get(model);
		if (modelTS == null) modelTS = new TreeSet<Car>();
		modelTS.add(car);
		modelTM.put(model, modelTS);
		
		int year = car.getYear();
		TreeSet<Car> yearTS = yearTM.get(year);
		if (yearTS == null) yearTS = new TreeSet<Car>();
		yearTS.add(car);
		yearTM.put(year, yearTS);
		
		double engine = car.getEngine();
		TreeSet<Car> engineTS = engineTM.get(engine);
		if (engineTS == null) engineTS = new TreeSet<Car>();
		engineTS.add(car);
		engineTM.put(engine, engineTS);
		
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
		
		if (result) {
			modelTM.get(car.getModel()).remove(car);
			yearTM.get(car.getYear()).remove(car);
			engineTM.get(car.getEngine()).remove(car);
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
		TreeSet<Car> result = modelTM.get(model);
		return result == null ? new TreeSet<Car>() : result;
	}

	@Override
	public Iterable<Car> allCarsByYearRange(int minYear, int maxYear) {
		ArrayList<Car> result = new ArrayList<>();
		for(TreeSet<Car> tsc : yearTM.subMap(minYear, true, maxYear, true).values())
			result.addAll(tsc);
		return result;
	}

	@Override
	public Iterable<Car> allCarsByEngineRange(double minEngine, double maxEngine) {
		ArrayList<Car> result = new ArrayList<>();
		for(TreeSet<Car> tsc : engineTM.subMap(minEngine, true, maxEngine, true).values())
			result.addAll(tsc);
		return result;
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
		ArrayList<Car> result = new ArrayList<>();
		for(TreeSet<Car> tsc : modelTM.values()) result.addAll(tsc);
		return result;
	}

	@Override
	public Iterable<Car> allCarsSortedByYear() {
		ArrayList<Car> result = new ArrayList<>();
		for(TreeSet<Car> tsc : yearTM.values()) result.addAll(tsc);
		return result;
	}

	@Override
	public Iterable<Car> allCarsSortedByEngine() {
		ArrayList<Car> result = new ArrayList<>();
		for(TreeSet<Car> tsc : engineTM.values()) result.addAll(tsc);
		return result;
	}

	@Override
	public Stream<Car> toStream() {
		return null;
	}

}

package model;

import dto.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Garage implements IGarage {

    private HashMap<Integer,Car> idHashMap = new HashMap<>();
    private TreeMap<String, TreeSet<Car>> modelTreeMap = new TreeMap<>();
    private TreeMap<String, TreeSet<Car>> yearTreeMap = new TreeMap<>();

    @Override
    public void fill(int numCar) {
        for (int i = 0; i < numCar; i++) {
            add(Car.randomCar());
        }
    }

    @Override
    public boolean add(Car car) {
        int id = car.getId();
        if (idHashMap.containsKey(id))return false;
        idHashMap.put(id,car);

        String model = car.getModel();

        TreeSet<Car> modelTS = modelTreeMap.get(car.getModel());
        if(modelTS == null) modelTS = new TreeSet<Car>();
        modelTS.add(car);
        modelTreeMap.put(model, modelTS);

        int year = car.getYear();

        TreeSet<Car> yearTreeMap = yearTreeMap.get(car.getYear());
        if(modelTS == null) modelTS = new TreeSet<Car>();

        return true;
    }

    @Override
    public boolean contains(Car car) {
        return idHashMap.containsKey(car.getId());
    }

    @Override
    public Car remove(int id) {
        Car result = idHashMap.get(id);
        remove(result);
        return result;
    }



    @Override
    public boolean remove(Car car) {
        if(car == null)return false;
        boolean result = idHashMap.remove(car.getId()) != null;

        if(result){
            modelTreeMap.get(car.getModel()).remove(car);
            yearTreeMap.get(car.getYear()).remove(car);
        }
        return result;
    }

    @Override
    public Car getById(int id) {
        return idHashMap.get(id);
    }

    @Override
    public Iterable<Car> allCars() {
        return new TreeSet<Car>(idHashMap.values());
    }

    @Override
    public Iterable<Car> allCarsByModel(String model) {
        TreeSet<Car> result = modelTreeMap.get(model);
        return result == null ? new TreeSet<>() : result;
    }

    @Override
    public Iterable<Car> allCarsByYearRange(int minYear, int maxYear) {
        return null;
    }

    @Override
    public Iterable<Car> allCarsByEngineRange(double minEngine, double maxEngine) {
        return null;
    }

    @Override
    public Iterable<Car> allCarsByAC(boolean ac) {
        TreeSet<Car> result = new TreeSet<>();
        for(Car c : idHashMap.values()){
            if(c.isAc()== ac)result.add(c);
        }
        return result;
    }

    @Override
    public Iterable<Car> allCarsSortedByModel() {
        ArrayList<Car> result = new ArrayList<>();
        for (TreeSet<Car> tsc:
                modelTreeMap.values()) {
            result.addAll(tsc);
        }
        return result;
    }

    @Override
    public Iterable<Car> allCarsSortedByYear() {
        ArrayList<Car> result = new ArrayList<>();
        for (TreeSet<Car> tsc:
                yearTreeMap.values()) {
            result.addAll(tsc);
        }
        return result;
    }


    @Override
    public Iterable<Car> allCarsSortedByEngine(int minYear, int maxYear) {
        return null;
    }

}

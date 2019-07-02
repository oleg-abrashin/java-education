package model;

import dto.Car;

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
    Iterable<Car> allCarsByAC(boolean isAC);

    Iterable<Car> allCarsSortedByModel();
    Iterable<Car> allCarsSortedByYear();
    Iterable<Car> allCarsSortedByEngine(int minYear, int maxYear);
}

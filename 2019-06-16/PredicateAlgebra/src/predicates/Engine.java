package predicates;

import car.Car;

import java.util.function.Predicate;

public class Engine implements Predicate<Car> {

    private double min, max;

    @Override
    public boolean test(Car car) {
        return car.getEngine() >= min && car.getEngine() <= max;
    }

    public Engine(double min, double max) {
        this.min = min;
        this.max = max;
    }
}

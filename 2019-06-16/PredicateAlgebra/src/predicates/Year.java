package predicates;

import car.Car;

import java.util.function.Predicate;

public class Year implements Predicate<Car> {

    private int min, max;

    @Override
    public boolean test(Car car) {
        return car.getYear() >= min && car.getYear() <= max;
    }

    public Year(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

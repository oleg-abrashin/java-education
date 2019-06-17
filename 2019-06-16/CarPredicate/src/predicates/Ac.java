package predicates;

import car.Car;

import java.util.function.Predicate;

public class Ac implements Predicate<Car> {

    @Override
    public boolean test(Car car) {
        return car.isAc();
    }
}

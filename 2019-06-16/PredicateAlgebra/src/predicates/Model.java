package predicates;

import car.Car;

import java.util.function.Predicate;

public class Model implements Predicate<Car> {

    private String model;

    @Override
    public boolean test(Car car) {
        return car.getModel().equals(model);
    }

    public Model(String model) {
        this.model = model;
    }
}

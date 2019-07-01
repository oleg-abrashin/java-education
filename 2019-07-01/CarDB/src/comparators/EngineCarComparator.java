package comparators;

import dto.Car;

import java.util.Comparator;

public class EngineCarComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return Double.compare(c1.getEngine(),c2.getEngine());
    }
}

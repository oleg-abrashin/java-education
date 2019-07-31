package application;

import accumulators.DoubleAverageAccumulator;
import car.Car;
import reducer.Reducers;

import java.util.ArrayList;

public class GeneralReducerTestApp {
    private static final int NUM_CARS = 10;

    public static void main(String[] args) {

        ArrayList<Car> garage = new ArrayList<>();

        for (int i = 0; i < NUM_CARS; i++) {
            garage.add(Car.randomCar());
        }
        for(Car c:garage) System.out.println(c);
        double averageEngine =
                Reducers.reduce(
                       garage,
                       car -> car.getEngine(),
                        ()-> new DoubleAverageAccumulator(),
                        (accumulator,engine)-> {
                            accumulator.setSum(accumulator.getSum()+engine);
                            accumulator.setCounter(accumulator.getCounter()+1);
                        },
                        accumulator -> accumulator.getSum()/accumulator.getCounter()
                );

        System.out.println(averageEngine);
        System.out.println((double)Math.round(averageEngine * 100d) / 100d);

    }
}

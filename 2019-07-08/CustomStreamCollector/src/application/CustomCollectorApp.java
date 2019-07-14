package application;

import accumulators.DoubleAccumulator;
import dto.Car;

import java.util.stream.Collector;
import java.util.stream.Stream;

public class CustomCollectorApp {
    private static final int NUM_CARS = 20;

    public static void main(String[] args) {

        Collector<Car, DoubleAccumulator, Double> averageEngine =
                Collector.of(
                        DoubleAccumulator::new,
                        (DoubleAccumulator a,Car c)->{
                            a.setSum(a.getSum()+c.getEngine());
                            a.setN(a.getN()+1);
                        },
                        (DoubleAccumulator a1,DoubleAccumulator a2)->{
                            DoubleAccumulator a3 = new DoubleAccumulator();
                            a3.setSum(a1.getSum()+a2.getSum());
                            a3.setN(a1.getN()+a2.getN());
                            return a3;
                        },
                        (DoubleAccumulator a)->a.getSum()/a.getN()
                );
        double averageE = Car.createStream(NUM_CARS)
                            .collect(averageEngine);

        System.out.println(String.format("%.3g%n", averageE));


    }
}

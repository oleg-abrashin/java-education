package application;

import java.util.Arrays;
import java.util.Comparator;

import car.Car;
import comparators.AcCarComparator;
import comparators.EngineCarComparator;
import comparators.ModelCarComparator;
import comparators.YearCarComparator;

public class CarSortingApp {

    private static final int NUM_CARS = 20;

    public static void main(String[] args) {

        Car[] garage = new Car[NUM_CARS];

        for (int i = 0; i < garage.length; i++) {
            garage[i] = Car.randomCar();
        }

        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }

        System.out.println("********************************");

        //Arrays.sort(garage, new EngineCarComparator());

        Comparator<Car> modelComparator = new ModelCarComparator();
        Comparator<Car> yearComparator = new YearCarComparator();
        Comparator<Car> engineComparator = new EngineCarComparator();
        Comparator<Car> acComparator = new AcCarComparator();

        //Arrays.sort(garage,modelComparator.thenComparing(yearComparator.reversed()));

//        Arrays.sort(garage,modelComparator
//                .thenComparing(yearComparator)
//                .thenComparing(engineComparator));

        Arrays.sort(garage, acComparator.reversed()
                .thenComparing(modelComparator)
                .thenComparing(yearComparator)
                .thenComparing(engineComparator));


        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }

    }

}

package application;

import car.Car;
import predicates.Ac;

import java.util.function.Predicate;

public class CarPredicateApp {

    private static final int NUM_CARS = 20;

    public static void main(String[] args) {

        Car[] garage = new Car[NUM_CARS];

        for (int i = 0; i < garage.length; i++) {
            garage[i] = Car.randomCar();
        }

        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }

        System.out.println("йух".repeat(20));

        Car[] filtered = filterCar(garage, new Ac());
        for (int i = 0; i < filtered.length; i++) {
            System.out.println(filtered[i]);
        }

        System.out.println("йух".repeat(20));
    }

    public static Car[] filterCar(Car[] arr, Predicate<Car> predicate) {
        Car[] buffer = new Car[arr.length];
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {

            if (predicate.test(arr[i])) {
                buffer[counter++] = arr[i];
            }
        }

        Car[] result = new Car[counter];

        for (int i = 0; i < counter; i++) {
            result[i] = buffer[i];
        }
        return result;
    }

}

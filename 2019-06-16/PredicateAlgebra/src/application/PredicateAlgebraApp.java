package application;

import car.Car;
import predicates.Ac;
import predicates.Engine;
import predicates.Model;
import predicates.Year;

import java.util.function.Predicate;

public class PredicateAlgebraApp {

    private static final int NUM_CARS = 20;

    public static void main(String[] args) {

        Car[] garage = new Car[NUM_CARS];

        for (int i = 0; i < garage.length; i++) {
            garage[i] = Car.randomCar();
        }

        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }



        Car[] filtered = filterCar(garage, new Ac());
        for (int i = 0; i < filtered.length; i++) {
            System.out.println(filtered[i]);
        }



        Car[] filteredM = filterCar(filtered, new Model("ZAZ"));
        for (int i = 0; i < filteredM.length; i++) {
            System.out.println(filteredM[i]);
        }



        Car[] filteredY = filterCar(filtered, new Year(2000, 2019));
        for (int i = 0; i < filteredY.length; i++) {
            System.out.println(filteredY[i]);
        }



        Car[] filteredE = filterCar(filteredY, new Engine(1., 2.));
        for (int i = 0; i < filteredE.length; i++) {
            System.out.println(filteredE[i]);
        }



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

package application;

import java.util.Arrays;

import car.Car;
import comparators.ModelCarComparator;

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

        Arrays.sort(garage, new ModelCarComparator());

        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }

    }

}

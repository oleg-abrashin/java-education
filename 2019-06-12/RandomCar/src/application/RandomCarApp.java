package application;

import car.Car;

public class RandomCarApp {
    private static final int NUM_CARS = 5;

    public static void main(String[] args) {
        //Car[] garage = new Car[NUM_CARS];

////        //input random cars in garage
//        for (int i = 0; i < garage.length; i++) {
//            garage[i] = Car.randomCar();
//        }

        Car[] garage = Car.getRandomGarageArray(50);

        //output cars from garage
        for (int i = 0; i < garage.length; i++) {
            System.out.println(garage[i]);
        }

    }
}

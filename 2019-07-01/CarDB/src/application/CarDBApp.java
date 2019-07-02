package application;

import dto.Car;
import model.Garage;

public class CarDBApp {
    public static void main(String[] args) {


        Garage garage = new Garage();
        garage.fill(100);
        //for(Car c : garage.allCars())System.out.println(c);
        //for(Car c : garage.allCarsByModel("Sandero"))System.out.println(c);
        //for(Car c : garage.allCarsByAC(true))System.out.println(c);
        //for(Car c : garage.allCarsSortedByModel())System.out.println(c);
        for(Car c : garage.allCarsSortedByYear())System.out.println(c);

    }
}

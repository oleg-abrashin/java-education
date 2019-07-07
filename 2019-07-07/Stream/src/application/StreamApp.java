package application;

import dto.Car;
import dto.CarComparators;
import model.Garage;
import randomlib.RandomLib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamApp {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.fill(20);


        Builder<Car> garageBuilder = Stream.builder();
        for(Car c : garage.allCars())garageBuilder.accept(c);
        ArrayList<Car> listCar = garageBuilder.build()
        //garageBuilder.build()
                     .filter(c -> c.getModel().equals("Toyota"))
                     .sorted(CarComparators.engineCarComparator)
                     //.forEach((c)-> System.out.println(c));
                    .collect(Collectors.toCollection(()->new ArrayList<Car>()));
        System.out.println(listCar);
    }
}

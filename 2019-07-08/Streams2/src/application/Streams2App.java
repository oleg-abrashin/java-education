package application;


import dto.Car;
import comparators.*;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.generate;

public class Streams2App {
    public static void main(String[] args) {



        HashSet<Car> car = Car.createStream(20)
                .collect(Collectors.toCollection(HashSet::new));


        System.out.println(car);
    }
}

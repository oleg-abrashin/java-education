package application;


import dto.Car;
import comparators.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.generate;

public class Streams2App {
    public static void main(String[] args) {



        LinkedHashSet<String> hsc = Car.createStream(20)
                .map(Car::getModel)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));


        System.out.println(hsc);
    }
}

package application;

import dto.Car;

import java.util.*;
import java.util.stream.Collectors;

public class HWApp {
    public static void main(String[] args) {
        //Map<Boolean, CarForPrint>

        Map<Boolean, ArrayList<CarForPrint>> carsByAC = Car
                .createStream(20)
                .collect(Collectors.toMap(
                        Car::isAc,
                        (Car car) -> {
                            ArrayList<CarForPrint> arrForPrint = new ArrayList<>();
                            arrForPrint.add(new CarForPrint(car));
                            return arrForPrint;
                        },
                        (oldValue, newValue) -> {
                            oldValue.addAll(newValue);
                            return oldValue;
                        }
                ));

        System.out.println(carsByAC.get(false));
        System.out.println(carsByAC.get(true));
    }
}

package application;

import dto.Car;
import printcar.CarForPrint;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamToMapApp {

    public static void main(String[] args) {
        Map<String, ArrayList<CarForPrint>> map =
                Car.createStream(20)
                        .collect(Collectors.toMap(
                                // Key mapper
                                c -> c.getModel(),

                                // Value mapper
                                c -> {
                                    ArrayList<CarForPrint> al = new ArrayList<>();
                                    al.add(new CarForPrint(c));
                                    return al;
                                },

                                // Merging function
                                (a, b) -> {
                                    a.addAll(b);
                                    return a;
                                },

                                TreeMap:: new

                                )
                        );
        for(String i:map.keySet()){
            System.out.println(i+"; "+map.get(i));
        }
    }

    public static ArrayList<CarForPrint> lambda(Car car){
        ArrayList<CarForPrint> al = new ArrayList<>();
        al.add(new CarForPrint(car));
        return al;
    }

}

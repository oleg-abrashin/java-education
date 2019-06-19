package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SublistApp {

    private static final int NUM_NUM = 10;
    static Random gen = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> ali = new ArrayList<>();

        for (int i = 0; i < NUM_NUM; i++)ali.add(gen.nextInt(10));
        System.out.println("ali = "+ali);

        List<Integer> sub = ali.subList(2,7);
        //ArrayList<Integer> sub = new ArrayList<>();


        System.out.println("sub = "+sub);

        //sub.set(2, 777);
        System.out.println("ali = "+ali);
        System.out.println("sub = "+sub);

        ArrayList<Integer> range = new ArrayList<>(sub);

        System.out.println("range = "+range);
        range.set(2,777);
        System.out.println("ali = "+ali);
        System.out.println("sub = "+sub);
        System.out.println("range = "+range);

    }

}

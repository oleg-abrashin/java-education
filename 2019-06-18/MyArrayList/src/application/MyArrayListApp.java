package application;

import model.MyArrayList;

import java.util.Iterator;
import java.util.Random;

public class MyArrayListApp {
    private static final int NUM_NUM = 5;
    static Random gen = new Random(12345);

    public static void main(String[] args) {

        MyArrayList<Integer> mali = new MyArrayList<Integer>();
        for (int i = 0; i < NUM_NUM; i++) {
            mali.add(i);
        }

//        System.out.println(mali);
//        mali.add(4);
//        System.out.println(mali);
//        System.out.println(mali);
//        System.out.println(mali.size());
//        mali.add(6);
//        System.out.println(mali);
//        System.out.println(mali.size());
//        System.out.println(mali.get(5));
//        System.out.println(mali.set(666, 8));
//        System.out.println(mali);
//        mali.add(888, 7);
//        System.out.println(mali);
//        System.out.println(mali.indexOf(888));
//        System.out.println(mali.contains(66));
//        mali.shuffle();
//        System.out.println(mali);

//        mali.trim();
//        mali.remove(7);
//        mali.remove(6);
//        mali.remove(5);
//        mali.remove(0);
//        mali.remove(3);
//        mali.remove(2);
//        mali.remove(1);
//        mali.remove(0);
//        mali.remove(0, 5);

//        System.out.println(mali);

        Iterator<Integer> iter = mali.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // write your code here
    }
}

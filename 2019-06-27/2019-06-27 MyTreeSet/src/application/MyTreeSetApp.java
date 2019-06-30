package application;

import model.MyTreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class MyTreeSetApp {

    private static final int NUM_NUM = 11;
    static Random gen = new Random();

    public static void main(String[] args) {

        MyTreeSet<Integer> mtsi = new MyTreeSet<Integer>(Comparator.naturalOrder());

        for (int i = 0; i < NUM_NUM; i++) {
            mtsi.add(i);
        }

        mtsi.add(25);
//        mtsi.add(10);
//        mtsi.add(31);
//        mtsi.add(8);
//        mtsi.add(24);
//        mtsi.add(9);
//        mtsi.add(3);
//        mtsi.add(12);
//        mtsi.add(4);
//        mtsi.add(86);
//        mtsi.add(40);
//        mtsi.add(97);
//        mtsi.add(37);
//        mtsi.add(59);
//        mtsi.add(99);
//        mtsi.add(36);
//        mtsi.add(34);
//
//        mtsi.add(35);
//        mtsi.add(100);
//
//        System.out.println("Size: " + mtsi.size());
//
//        mtsi.remove(36);
//
        mtsi.remove(25);
        Iterator<Integer> iterator = mtsi.iterator();

        int counter = 0;
        while (iterator.hasNext()) {
            counter++;
            System.out.println(iterator.next());
        }
        System.out.println("Left: " + counter);

//        Iterator<Integer> rangeIterator = mtsi.rangeIterator(5, 15);
//
//        while (rangeIterator.hasNext()) {
//            counter++;
//            System.out.println(rangeIterator.next());
//        }

//        Iterator<Integer> rangeIterator = mtsi.recursiveIterator();
//
//        while (rangeIterator.hasNext()) {
//            counter++;
//            System.out.println(rangeIterator.next());
//        }

        mtsi.remove(25);

    }
}



package application;
import model.MyArrayList;
import java.util.Random;

public class MyArrayListApp {
    private static final int NUM_NUM = 30;
    static Random gen = new Random(12345);
    public static void main(String[] args) {
        MyArrayList<Integer> mali = new MyArrayList<>();
        for (int i = 0; i < NUM_NUM; i++)mali.add(gen.nextInt(10));
//        System.out.println(mali);
//        System.out.println(mali.get(5));
//        System.out.println(mali.set(666,8));
//        System.out.println(mali);
        mali.add(888,0);
        System.out.println(mali);
        //System.out.println(mali.indexOf(888));
        //System.out.println(mali.contains(6666));
//        System.out.println(mali.array.length);
//        mali.trim();
//        System.out.println(mali.array.length);
        mali.shuffle();
        System.out.println(mali);
    }
}

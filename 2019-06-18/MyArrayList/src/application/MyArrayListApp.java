package application;
import model.MyArrayList;
import java.util.Random;

public class MyArrayListApp {
    private static final int NUM_NUM = 3;
    static Random gen = new Random(12345);
    public static void main(String[] args) {
        MyArrayList<Integer> mali = new MyArrayList<>();

        //for (int i = 0; i < NUM_NUM; i++)mali.add(gen.nextInt(3));
        //System.out.println("mali = "+mali);

//        System.out.println(mali);
//        System.out.println(mali.get(5));
//        System.out.println(mali.set(666,8));
//        System.out.println(mali);
        mali.add(111);
        //System.out.println("mali = "+mali);
        mali.add(222);
        //System.out.println("mali = "+mali);
        mali.add(333);
        mali.add(444);
        mali.add(555);
        System.out.println("mali = "+mali);
        //mali.add(222,8);
        //mali.add(333,9);

//        System.out.println(mali.indexOf(888));
//        System.out.println(mali.contains(6666));
//        System.out.println(mali.array.length);
//        mali.trim();
//        System.out.println(mali.array.length);
//        mali.shuffle();

        //mali.trim_first();
        //System.out.println("mali = "+mali);

        //mali.trim_last();
        //System.out.println("mali = "+mali);


        mali.remove(4);
        System.out.println("mali = "+mali);

        mali.mark_range_as_null(0,1);
        System.out.println("mali = "+mali);

        mali.input_value_in_range(0,1,"deleted");
        System.out.println("mali = "+mali);
    }
}

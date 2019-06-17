package application;

import java.util.Arrays;
import java.util.Random;

public class ArraysCopyingApp {

    private static final int NUM_NUM = 20;
    
    static Random gen = new Random();

    public static void main(String[] args) {

        int[] arr = new int[NUM_NUM];
        for (int i=0; i < arr.length; i++){

            arr[i] = gen.nextInt(10);

        }

        System.out.println(Arrays.toString(arr));

    }

}

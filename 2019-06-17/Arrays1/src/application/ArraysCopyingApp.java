package application;

import java.util.Arrays;
import java.util.Random;

public class ArraysCopyingApp {

    private static final int NUM_NUM = 20;

    static Random gen = new Random();

    public static void main(String[] args) {

        int[] arr = new int[NUM_NUM];

        for (int i=0; i < arr.length; i++){

            arr[i] = 10+gen.nextInt(10);

        }

          System.out.println(Arrays.toString(arr));

//        int[] copy = Arrays.copyOf(arr, 25);
//
//        System.out.println(Arrays.toString(copy));
//
//        int[] range = Arrays.copyOfRange(arr,5,10);
//
//        System.out.println(Arrays.toString(range));

//        range[2] = 444;
//        System.out.println(Arrays.toString(range));
//        System.out.println(Arrays.toString(arr));

//        int dest[] = new int[NUM_NUM/2];
//
//        System.arraycopy(arr,3,dest,5,3);
//
//        System.out.println(Arrays.toString(dest));

          System.out.println(Arrays.toString( remove(arr,10)));



    }

    public static int[] remove(int[] arr, int index){

        int len1 = arr.length-1;

        System.arraycopy(arr, index+1, arr, index, len1 - index);

        return Arrays.copyOf(arr,len1);

    }

}
